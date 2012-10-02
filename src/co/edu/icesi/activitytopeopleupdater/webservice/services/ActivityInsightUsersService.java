/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.webservice.services;

import co.edu.icesi.activitytopeopleupdater.core.ConfigurationManager;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.StdPersonJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import co.edu.icesi.activitytopeopleupdater.webservice.connection.RestConnection;
import co.edu.icesi.activitytopeopleupdater.webservice.connection.RestResponse;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Consume the ActivityInsight system webservices to populate a list.
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
public class ActivityInsightUsersService {

    private static Logger logger = Logger.getLogger(ActivityInsightUsersService.class);
    /*
     * Activityinsight webservices base url, extracted from configuration file
     */
    private static String webServiceBaseUrl = ConfigurationManager.getProperty("webservices.baseurl");
    /*
     * Activityinsight users Webservice url
     */
    public final static String USERS_SERVICE_URL = "/login/service/v4/User/";
    /*
     * List of professors
     */
    private static List<Professor> professors;
    /*
     * Controller for the PeopleNet database access
     */
    private static StdPersonJpaController stdPersonController = new StdPersonJpaController();

    /**
     * Get the list of professor extracted from webservice, invokes the
     * webservice if the list is currently empty.
     *
     * @see #loadProfessors()
     */
    public static List<Professor> getProfessors() {
        if (professors == null || professors.isEmpty()) {
            loadProfessors();
        }
        return professors;
    }

    /**
     * Invoke the webservices to get all users from ActivityInsight, filter the
     * professor users and set the professors list. <p>Some registries in
     * ActivityInsight system has invalid usernames, for example there is an
     * user with the username MasterinEconomics, these users doesn't match with
     * a professor in PeoploNet system so must be excluded.
     */
    private static void loadProfessors() {
        logger.info("Consulting the users list in ActivityInsight System");
        professors = new ArrayList<Professor>();
        try {
            Document usersDoc = getAllUsers();
            if (usersDoc != null) {
                NodeList usersList = usersDoc.getElementsByTagName("User");
                logger.info("Total number of users in ActivityInsight: " + usersList.getLength());

                for (int i = 0; i < usersList.getLength(); i++) {
                    Element userNode = (Element) usersList.item(i);
                    String userNodeUsername = userNode.getAttribute("username");
                    String userNodeDmuId = userNode.getAttribute("dmu:userId");


                    Element userNodeItem = (Element) userNode.getElementsByTagName("Item").item(0);
                    String userDetailsLink = userNodeItem.getAttribute("xlink:href");

                    logger.debug("Consulting user detail webservice for: " + userNodeUsername + ": " + userDetailsLink);
                    Document userDetailsDoc = getUserDetails(userDetailsLink);

                    if (userDetailsDoc != null) {

                        NodeList userSchemas = userDetailsDoc.getElementsByTagName("dmu:Schemas");
                        logger.debug("Number of schemas for user " + userNodeUsername + ": " + userSchemas.getLength());

                        // If the user has no schemas can't be a professor, then is discardted.
                        if (userSchemas != null && userSchemas.getLength() > 0) {

                            try {
                                //The professor must belong to the  Management and Economics' Faculty
                                logger.info("Searching " + userNodeUsername + " in PeopleNet database");
                                String userNodePeopleId = stdPersonController.userPeople(userNodeUsername);
                                if (userNodePeopleId != null && !userNodePeopleId.equalsIgnoreCase("")) {

                                    Professor professor = new Professor();
                                    professor.setUsername(userNodeUsername);
                                    professor.setDmuId(userNodeDmuId);
                                    professor.setFirstName(DocumentProcessor.getTagValue("FirstName", userNode) + " " + DocumentProcessor.getTagValue("MiddleName", userNode));
                                    professor.setLastName(DocumentProcessor.getTagValue("LastName", userNode));
                                    professor.setDetailsServiceUrl(userDetailsLink);
                                    professor.setSchemasServiceUrl(((Element) userSchemas.item(0)).getAttribute("xlink:href"));
                                    professor.setSchemaDocument(ActivityInsightUserSchemasService.getUserSchema(professor, ActivityInsightUserSchemasService.INIDIVIDUAL_ACTIVITIES_SCHEMA));
                                    professor.setPeopleId(userNodePeopleId);

                                    professors.add(professor);
                                }else{
                                    logger.error("User " + userNodeUsername + " not found in PeopleNet databse");
                                }
                            } catch (NonexistentEntityException ex) {
                                logger.error(ex, ex);
                            } catch (javax.persistence.NoResultException ex) {
                                logger.error("User " + userNodeUsername + " not found in PeopleNet databse", ex);
                            }
                        }
                    } else {
                        logger.info("User details document for " + userNodeUsername + " could not be found. Ingnoring process for this user");
                    }
                }
                logger.info("Total number of professors in ActivityInsight: " + professors.size());
            } else {
                logger.fatal("Error conecting wiht ActivityInsight users webservice");
            }

        } catch (IOException | ParserConfigurationException | SAXException ex) {
            logger.fatal("Error conecting wiht ActivityInsight users webservice", ex);
        }
    }

    /**
     * Invoke the ActivityInsight users webservice and retrive a Document object
     * that represent the xml response of the service.
     *
     * @return
     * <code>Document</code> a Document object that represent the xml response
     * of the service.
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static Document getAllUsers() {
        try {
            RestConnection restConn = new RestConnection(webServiceBaseUrl + USERS_SERVICE_URL);
            ActivityInsightAuthenticator.login();

            RestResponse response;
            response = restConn.get();
            String responseStr = response.getDataAsString();

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new InputSource(new StringReader(responseStr)));

            // normalize text representation
            doc.getDocumentElement().normalize();
            logger.info("Root element of the doc is " + doc.getDocumentElement().getNodeName());

            return doc;
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            logger.error("Error conecting or parsing ActivityInsight users webservice at " + USERS_SERVICE_URL, ex);
            return null;
        }
    }

    /**
     * Invoke the ActivityInsight user details webservice and retrive a Document
     * object that represent the xml response of the service.
     *
     * @return
     * <code>Document</code> a Document object that represent the xml response
     * of the service.
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static Document getUserDetails(String userDetailsServiceUrl) throws IOException, ParserConfigurationException, SAXException {
        try {
            RestConnection restConn = new RestConnection(webServiceBaseUrl + userDetailsServiceUrl);
            ActivityInsightAuthenticator.login();

            RestResponse response;
            response = restConn.get();
            String responseStr = response.getDataAsString();

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new InputSource(new StringReader(responseStr)));

            // normalize text representation
            doc.getDocumentElement().normalize();
            logger.info("Root element of the doc is " + doc.getDocumentElement().getNodeName());

            return doc;
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            logger.error("Error conecting or parsing ActivityInsight user item webservice at " + userDetailsServiceUrl, ex);
            return null;
        }
    }
}
