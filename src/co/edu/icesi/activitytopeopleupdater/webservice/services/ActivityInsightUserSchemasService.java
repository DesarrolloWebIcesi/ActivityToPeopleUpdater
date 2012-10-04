/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.webservice.services;

import co.edu.icesi.activitytopeopleupdater.core.ConfigurationManager;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.webservice.connection.RestConnection;
import co.edu.icesi.activitytopeopleupdater.webservice.connection.RestResponse;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 
 * @author David Andrés Manzano Herrera - damanzano
 */
public class ActivityInsightUserSchemasService {
    private static  Logger logger = Logger.getLogger(ActivityInsightUsersService.class);
    private static String webServiceBaseUrl = ConfigurationManager.getProperty("webservices.baseurl");
    public final static String USER_BASESCHEMA_SERVICE_URL = "/login/service/v4/UserSchema/USERNAME:";
    public final static String INIDIVIDUAL_ACTIVITIES_SCHEMA="/INDIVIDUAL-ACTIVITIES-AdministrativeandEconomicSciences";
    
    /** 
     * Returns a XML formated document that represent a schema's data of a professor in ActivityInsight system
     * 
     * @param username The identification of the processor in ActivityInsight system (cc)
     * @param schema The ActivityInsight's schema tha will be consulted.
     */
    public static Document getUserSchema(String username, String schema) throws IOException, ParserConfigurationException, SAXException{
        RestConnection restConn = new RestConnection(webServiceBaseUrl+USER_BASESCHEMA_SERVICE_URL+username+schema);
        ActivityInsightAuthenticator.login();
        
        RestResponse response;
        response = restConn.get();
        String responseStr = response.getDataAsString();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse (new InputSource(new StringReader(responseStr)));
                    
        // normalize text representation
        doc.getDocumentElement ().normalize ();
        logger.debug("Root element of the doc is " + doc.getDocumentElement().getNodeName());
       
        return doc;
    }
    
   /** 
     * Returns a XML formated document that represent a schema's data of a professor in ActivityInsight system
     * 
     * @param professor  A Professor Object that represent the professor taht will be consulted
     * @param schema The ActivityInsight's schema tha will be consulted.
     * @see getUserSchema(String username, String schema)
     */
    public static Document getUserSchema(Professor professor, String schema) throws IOException, ParserConfigurationException, SAXException{
        return  getUserSchema(professor.getUsername(),schema);
    }
    
}
