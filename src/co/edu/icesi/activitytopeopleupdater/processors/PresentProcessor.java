/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvPresentacJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPresentac;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPresentacPK;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.util.DateFormats;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Execute the import process for the PRESENT entities
 * 
 * @author David Andrés Manzano Herrera - damanzano
 */
public class PresentProcessor extends AbstractProcessor{
    
    private static Logger logger = Logger.getLogger(PresentProcessor.class);
    private final String INTERNATIONAL_SCOPE="SC_01";
    private final String NATIONAL_SCOPE="SC_02";
    private final String REGIONAL_SCOPE="SC_03";
    private final String STATE_SCOPE="SC_04";
    private final String LOCAL_SCOPE="SC_05";
    private final String UNIVERSITY_SCOPE="SC_06";
    private final String COLLEGE_SCOPE="SC_07";
    private final String DEPARTMENT_SCOPE="SC_08";
    
    private final String PEDAGOGICAL_CLASSIFICATION="IP";
    private final String CONTRIBUTION_PRACTICE_CLASSIFICATION="IA";
    private final String DISCIPLINE_BASED_CLASSIFICATION="IC";
    private final String TEC_DEVELOPMENT_CLASSIFICATION="DT";
    private final String OTHER_CLASSIFICATION="OT";
    
    private final String DEMONSTRATION_TYPE="PR_O1";
    private final String EXHIBIT_TYPE="PR_O2";
    private final String KEYNOTE_TYPE="PR_O3";
    private final String LECTURE_TYPE="PR_O4";
    private final String ORAL_PRESENTATION_TYPE="PR_O5";
    private final String PAPER_TYPE="PR_O6";
    private final String POSTER_TYPE="PR_O7";
    private final String PERFORMANCE_TYPE="PR_O8";
    private final String OTHER_TYPE="PR_99";
    
    private final String CONFERENCE_METTYPE="MT_01";
    private final String PANEL_METTYPE="MT_02";
    private final String ROUNDTABLE_METTYPE="MT_03";
    private final String SEMINAR_METTYPE="MT_04";
    private final String SESSION_METTYPE="MT_05";
    private final String WORKSHOP_METTYPE="MT_06";
    private final String OTHER_METTYPE="MT_99";
    
    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public PresentProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }
    
    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {
        M4ccbCvPresentacJpaController presentationsController = new M4ccbCvPresentacJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element presentNode = (Element) this.entities.item(i);
            String presentId = presentNode.getAttribute("id")+":"+this.professor.getUsername();
            try {
                M4ccbCvPresentac presentation = presentationsController.findM4ccbCvPresentacByCcbCargueAct(presentId);
                // If exist, update the registry.
                presentation = processPresentation(presentation, presentNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + presentId);
                    presentationsController.edit(presentation);
                    logger.info(this.entitie + " with id " + presentId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not " + this.entitie + " with the id " + presentId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the presentId.
                M4ccbCvPresentacPK newPresentationPk = new M4ccbCvPresentacPK();
                newPresentationPk.setIdOrganization(ORGANIZATION_CODE);
                newPresentationPk.setStdIdHr(this.professor.getPeopleId());
                short nextCcbOrProdDiv =((Integer)(presentationsController.getMaxCcbOrProdDiv(this.professor.getPeopleId(), ORGANIZATION_CODE)+1)).shortValue();
                newPresentationPk.setCcbOrProdDiv(nextCcbOrProdDiv);
                M4ccbCvPresentac newPresentation = new M4ccbCvPresentac(newPresentationPk);
                newPresentation.setCcbCargueAct(presentId);
                newPresentation = processPresentation(newPresentation, presentNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + presentId);
                    presentationsController.create(newPresentation);
                    logger.info(this.entitie + " with id " + presentId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The " + this.entitie + " " + presentId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }
            } catch (NonUniqueResultException ex2) {
                if (presentId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + presentId + "in the PeopleNet system table " + M4ccbCvPresentac.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvPresentac.class.getName(), ex2);
                }
            }
        }
    }

    private M4ccbCvPresentac processPresentation(M4ccbCvPresentac presentation, Element presentNode) {
        
        String otherAuthors = getPresentOtherAuthors(presentNode);
        if (otherAuthors != null && !otherAuthors.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 100 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(otherAuthors.length()>100){
                presentation.setCcbCoautores(otherAuthors.substring(0, 99));
            }else{
                presentation.setCcbCoautores(otherAuthors);
            }
        }
        
        String presentationIsRefered=DocumentProcessor.getTagValue("REFEREED", presentNode);
        if(presentationIsRefered!=null && presentationIsRefered.equalsIgnoreCase("yes")){
            presentation.setCcbEvaPar("1");
        }else{
            presentation.setCcbEvaPar("0");        
        }
        
        String dtdDate = DocumentProcessor.getTagValue("DTD_DATE", presentNode);
        String dtmDate = DocumentProcessor.getTagValue("DTM_DATE", presentNode);
        String dtyDate = DocumentProcessor.getTagValue("DTY_DATE", presentNode);
        if (dtdDate != null && !dtdDate.equalsIgnoreCase("")
                && dtmDate != null && !dtmDate.equalsIgnoreCase("")
                && dtyDate != null && !dtyDate.equalsIgnoreCase("")) {
            presentation.setCcbFechaPrest(DateFormats.fullStringToDate(dtdDate + "/" + dtmDate + "/" + dtyDate));
        }
        
        String presentationScope=DocumentProcessor.getTagValue("SCOPE", presentNode);
        if(presentationScope!=null && !presentationScope.equalsIgnoreCase("")){
            String presentationScopeCode=getPresentScopeCode(presentationScope);
            if(!presentationScopeCode.equalsIgnoreCase("")){
                presentation.setCcbIdAmbito(presentationScopeCode);
            }
        }
        
        String presentationClassification=DocumentProcessor.getTagValue("CLASSIFICATION", presentNode);
        if(presentationClassification!=null &&!presentationClassification.equalsIgnoreCase("")){
            presentation.setCcbIdCategoria(getPresentClassificationCode(presentationClassification));
        }
        
        String conferenceName=DocumentProcessor.getTagValue("NAME", presentNode);
        if(conferenceName!=null && !conferenceName.equalsIgnoreCase("")){
            //FIXME: There is no field in PeopleNet database to store this information. Ask Arlex.
            //presentation.setCcbIdEvento(conferenceName);
            presentation.setCcbNomEven(conferenceName);
        }
        
        String presentationType=DocumentProcessor.getTagValue("PRESENTATION_TYPE", presentNode);
        if(presentationType!=null && !presentationType.equalsIgnoreCase("")){
            presentation.setCcbIdPresent(getPresentTypeCode(presentationType));
        }
        
        String presentationOrg=DocumentProcessor.getTagValue("ORG", presentNode);
        if(presentationOrg!=null && !presentationOrg.equalsIgnoreCase("")){
            presentation.setCcbInstOrg(presentationOrg);
        }
        
        String isGuest=DocumentProcessor.getTagValue("INVACC", presentNode);
        if(isGuest!=null && isGuest.equalsIgnoreCase("Invited")){
            presentation.setCcbInvitado("1");
        }else{
            presentation.setCcbInvitado("0");
        }
        
        String presentationTitle=DocumentProcessor.getTagValue("TITLE", presentNode);
        if(presentationTitle!=null && !presentationTitle.equalsIgnoreCase("")){
            presentation.setCcbNomPresnt(presentationTitle);
        }
        
        String conferenceType=DocumentProcessor.getTagValue("MEETING_TYPE", presentNode);
        if(conferenceType!=null && !conferenceType.equalsIgnoreCase("")){
            //FIXME: It is posible that CcbOtroEnc is not the attribute in  what this information must be saved.
            //presentation.setCcbOtroEnc(getPresentMeetingTypeCode(conferenceType));
            
            //NOTE: damanzano corregido según indicaciones de Arlex.
            presentation.setCcbIdEvento(getPresentMeetingTypeCode(conferenceType));
        }
        
        String isPublishedProceedings=DocumentProcessor.getTagValue("PUBPROCEED", presentNode);
        if(isPublishedProceedings!=null && isPublishedProceedings.equalsIgnoreCase("yes")){
            presentation.setCcbPubMemor("1");
        }else{
            presentation.setCcbPubMemor("0");
        }
        
        String isPublishedElsewere=DocumentProcessor.getTagValue("PUBELSE", presentNode);
        if(isPublishedElsewere!=null && isPublishedElsewere.equalsIgnoreCase("yes")){
            presentation.setCcbPubOtroMed("1");
        }else{
            presentation.setCcbPubOtroMed("0");
        }
        
        String presentationAbstract=DocumentProcessor.getTagValue("ABSTRACT", presentNode);
        if(presentationAbstract!=null && !presentationAbstract.equalsIgnoreCase("")){
            if(presentationAbstract.length()> 1000){
                presentation.setCcbResumen(presentationAbstract.substring(0, 999));
            }else{
                presentation.setCcbResumen(presentationAbstract);
            }
        }
        
        String authorRole=getPresentAuthorRole(presentNode);
        if(authorRole!=null && !authorRole.equalsIgnoreCase("")){
            presentation.setCcbRol(authorRole);
        }
        
        String isAcademic=DocumentProcessor.getTagValue("ACADEMIC", presentNode);
        if(isAcademic!=null && isAcademic.equalsIgnoreCase("Academic")){
            presentation.setCcbTipoAcad("1");
        }else{
            presentation.setCcbTipoAcad("0");
        }
        
        presentation.setDtLastUpdate(new Date());
        
        return presentation;
    }
    
    private String getPresentOtherAuthors(Element presentNode) {
        NodeList authorList = presentNode.getElementsByTagName("PRESENT_AUTH");
        String authorsString = "";

        if (authorList != null && authorList.getLength() > 0) {
            int authorCount = 0;
            for (int i = 0; i < authorList.getLength(); i++) {
                Element author = (Element) authorList.item(i);

                //TODO VALIDATE authorFacultyName NOT NULL
                String authorFacultyName = DocumentProcessor.getTagValue("FACULTY_NAME", author);
                if (authorFacultyName == null || !authorFacultyName.equalsIgnoreCase(this.professor.getDmuId())) {
                    String authorFname = DocumentProcessor.getTagValue("FNAME", author);
                    String authorMname = DocumentProcessor.getTagValue("MNAME", author);
                    String authorLname = DocumentProcessor.getTagValue("LNAME", author);
                    String authorRole = DocumentProcessor.getTagValue("ROLE", author);
                    String authorStudentLevel = DocumentProcessor.getTagValue("STUDENT_LEVEL", author);

                    if (authorCount != 0) {
                        authorsString += "/ ";
                    }
                    if (authorFname != null) {
                        authorsString += authorFname;
                    }
                    if (authorMname != null) {
                        authorsString += " " + authorMname;
                    }
                    if (authorLname != null) {
                        authorsString += " " + authorLname;
                    }
                    if (authorRole != null) {
                        authorsString += " '" + authorRole + "'";
                    }
                    if (authorStudentLevel != null) {
                        authorsString += " " + authorStudentLevel;
                    }

                    authorCount++;
                }
            }
        }
        return authorsString;
    }
    
    private String getPresentScopeCode(String presentScope){
        String presentScopeCode="";
        switch(presentScope){
            case "International":
                presentScopeCode=this.INTERNATIONAL_SCOPE;
                break;
            case "National":
                presentScopeCode=this.NATIONAL_SCOPE;
                break;
            case "Regional":
                presentScopeCode=this.REGIONAL_SCOPE;
                break;
            case "State":
                presentScopeCode=this.STATE_SCOPE;
                break;
            case "Local":
                presentScopeCode=this.LOCAL_SCOPE;
                break;
            case "University":
                presentScopeCode=this.UNIVERSITY_SCOPE;
                break;
            case "College":
                presentScopeCode=this.COLLEGE_SCOPE;
                break;
            case "Department":
                presentScopeCode=this.DEPARTMENT_SCOPE;
                break;
        }
        return presentScopeCode;
    }
    
    private String getPresentClassificationCode(String presentClassification){
        String presentClassificationCode=this.OTHER_CLASSIFICATION;
        switch(presentClassification){
            case "Learning and Pedagogical Research":
                presentClassificationCode=this.PEDAGOGICAL_CLASSIFICATION;
                break;
            case "Contributions to Practice":
                presentClassificationCode=this.CONTRIBUTION_PRACTICE_CLASSIFICATION;
                break;
            case "Discipline-based Scholarship":
                presentClassificationCode=this.DISCIPLINE_BASED_CLASSIFICATION;
                break;
        }
        return presentClassificationCode;
    }
    
    private String getPresentTypeCode(String presentType){
        String presentationTypeCode=this.OTHER_TYPE;
        switch(presentType){
            case "Demonstration":
                presentationTypeCode=this.DEMONSTRATION_TYPE;
                break;
            case "Exhibit":
                presentationTypeCode=this.EXHIBIT_TYPE;
                break;
            case "Keynote/Plenary Address":
                presentationTypeCode=this.KEYNOTE_TYPE;
                break;
            case "Lecture":
                presentationTypeCode=this.LECTURE_TYPE;
                break;
            case "Oral Presentation":
                presentationTypeCode=this.ORAL_PRESENTATION_TYPE;
                break;
            case "Paper":
                presentationTypeCode=this.PAPER_TYPE;
                break;
            case "Poster":
                presentationTypeCode=this.POSTER_TYPE;
                break;
            case "Reading of Creative Work/Performance":
                presentationTypeCode=this.PERFORMANCE_TYPE;
                break;
        }
        
        return presentationTypeCode;
    }
    
    private String getPresentMeetingTypeCode (String presentMeetingType){
        String presentMeetingTypeCode=this.OTHER_METTYPE;
        switch(presentMeetingType){
            case "Conference":
                presentMeetingTypeCode=this.CONFERENCE_METTYPE;
                break;
            case "Panel":
                presentMeetingTypeCode=this.PANEL_METTYPE;
                break;
            case "Roundtable":
                presentMeetingTypeCode=this.ROUNDTABLE_METTYPE;
                break;
            case "Seminar":
                presentMeetingTypeCode=this.SEMINAR_METTYPE;
                break;
            case "Session":
                presentMeetingTypeCode=this.SESSION_METTYPE;
                break;
            case "Workshop":
                presentMeetingTypeCode=this.WORKSHOP_METTYPE;
                break;
        }
        return presentMeetingTypeCode;
    }
    
    private String getPresentAuthorRole(Element presentNode) {
        NodeList authorList = presentNode.getElementsByTagName("PRESENT_AUTH");
        String authorRole = null;

        if (authorList != null && authorList.getLength() > 0) {
            for (int i = 0; i < authorList.getLength(); i++) {
                Element author = (Element) authorList.item(0);
                String authorFacultyName = DocumentProcessor.getTagValue("FACULTY_NAME", author);
                if(authorFacultyName!=null && !authorFacultyName.equalsIgnoreCase("")){
                    if (authorFacultyName.equalsIgnoreCase(this.professor.getDmuId())) {
                        authorRole = DocumentProcessor.getTagValue("ROLE", author);
                        return authorRole;
                    }
                }
            }
        }

        return authorRole;
    }
}
