/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvActInvesJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvActInves;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvActInvesPK;
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
 * Execute the import process for the CONGRANT entities
 *
 * @author David Andrés Manzano Herrera
 */
public class CongrantProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(CongrantProcessor.class);
    private final String CONTRACT_TYPE = "TI_01";
    private final String FELLOWSHIP_TYPE = "TI_02";
    private final String GRANT_TYPE = "TI_03";
    private final String SPONSORED_RESEARCH_TYPE = "TI_04";
    private final String OTHER_TYPE = "TI_99";
    private final String UNDER_REVIEW_STATUS = "ES_01";
    private final String FUNDED_STATUS = "ES_02";
    private final String NOT_FUNDED_STATUS = "ES_03";
    private final String OTHER_STATUS = "ES_99";
    private final String ICESI_AWARDORG = "AO_01";
    private final String LOCAL_AWARDORG = "AO_02";
    private final String STATE_AWARDORG = "AO_03";
    private final String FEDERAL_AWARDORG = "AO_04";
    private final String PRIVATE_AWARDORG = "AO_05";
    private final String OTHER_AWARDORG = "AO_99";

   /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public CongrantProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }
    
    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {
        M4ccbCvActInvesJpaController investActivitiesController = new M4ccbCvActInvesJpaController(this.EMF);
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element congrantNode = (Element) this.entities.item(i);
            String congrantId = congrantNode.getAttribute("id")+":"+this.professor.getUsername();
            try {
                M4ccbCvActInves activity = investActivitiesController.findM4ccbActInvesByCcbCargueAct(congrantId);
                // If exist, update the registry.
                activity = processActivity(activity, congrantNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + congrantId);
                    investActivitiesController.edit(activity);
                    logger.info(this.entitie + " with id " + congrantId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not investigation activities with the id " + congrantId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the congrantId.
                M4ccbCvActInvesPK newActivityPk = new M4ccbCvActInvesPK();
                newActivityPk.setIdOrganization(ORGANIZATION_CODE);
                newActivityPk.setStdIdHr(this.professor.getPeopleId());
                short nextCcbOrActInv =((Integer)(investActivitiesController.getMaxCcbOrActInv(this.professor.getPeopleId(), ORGANIZATION_CODE)+1)).shortValue();
                newActivityPk.setCcbOrActInv(nextCcbOrActInv);
                M4ccbCvActInves newActivity = new M4ccbCvActInves(newActivityPk);
                newActivity.setCcbCargueAct(congrantId);
                newActivity = processActivity(newActivity, congrantNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + congrantId);
                    investActivitiesController.create(newActivity);
                    logger.info(this.entitie + " with id " + congrantId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The investigation activity " + congrantId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }

            } catch (NonUniqueResultException ex2) {
                if (congrantId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + congrantId + "in the PeopleNet system table " + M4ccbCvActInves.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvActInves.class.getName(), ex2);
                }
            }
        }
    }

    /** 
     * Process an entity's information and saves it in PeopleNet database objects 
     * 
     * @param activity A M4ccbCvActInves Object in which the information will be saved
     * @param congrantNode The entity node that will be processed
     * 
     * @return A filled M4ccbCvActInves Object
     */
    private M4ccbCvActInves processActivity(M4ccbCvActInves activity, Element congrantNode) {
        String dtdEnd = DocumentProcessor.getTagValue("DTD_END", congrantNode);
        String dtmEnd = DocumentProcessor.getTagValue("DTM_END", congrantNode);
        String dtyEnd = DocumentProcessor.getTagValue("DTY_END", congrantNode);
        if (dtdEnd != null && !dtdEnd.equalsIgnoreCase("")
                && dtmEnd != null && !dtmEnd.equalsIgnoreCase("")
                && dtyEnd != null && !dtyEnd.equalsIgnoreCase("")) {
            activity.setCcbDtEnd(DateFormats.fullStringToDate(dtdEnd + "/" + dtmEnd + "/" + dtyEnd));
        }

        String dtdSub = DocumentProcessor.getTagValue("DTD_SUB", congrantNode);
        String dtmSub = DocumentProcessor.getTagValue("DTM_SUB", congrantNode);
        String dtySub = DocumentProcessor.getTagValue("DTY_SUB", congrantNode);
        if (dtdSub != null && !dtdSub.equalsIgnoreCase("")
                && dtmSub != null && !dtmSub.equalsIgnoreCase("")
                && dtySub != null && !dtySub.equalsIgnoreCase("")) {
            activity.setCcbDtEnvio(DateFormats.fullStringToDate(dtdSub + "/" + dtmSub + "/" + dtySub));
        }

        String dtdExpSub = DocumentProcessor.getTagValue("DTD_EXPSUB", congrantNode);
        String dtmExpSub = DocumentProcessor.getTagValue("DTM_EXPSUB", congrantNode);
        String dtyExpSub = DocumentProcessor.getTagValue("DTY_EXPSUB", congrantNode);
        if (dtdExpSub != null && !dtdExpSub.equalsIgnoreCase("")
                && dtmExpSub != null && !dtmExpSub.equalsIgnoreCase("")
                && dtyExpSub != null && !dtyExpSub.equalsIgnoreCase("")) {
            activity.setCcbDtProp(DateFormats.fullStringToDate(dtdExpSub + "/" + dtmExpSub + "/" + dtyExpSub));
        }

        String dtdStart = DocumentProcessor.getTagValue("DTD_START", congrantNode);
        String dtmStart = DocumentProcessor.getTagValue("DTM_START", congrantNode);
        String dtyStart = DocumentProcessor.getTagValue("DTY_START", congrantNode);
        if (dtdStart != null && !dtdStart.equalsIgnoreCase("")
                && dtmStart != null && !dtmStart.equalsIgnoreCase("")
                && dtyStart != null && !dtyStart.equalsIgnoreCase("")) {
            activity.setCcbDtStart(DateFormats.fullStringToDate(dtdStart + "/" + dtmStart + "/" + dtyStart));
        }

        String activityType=DocumentProcessor.getTagValue("TYPE", congrantNode);
        if(activityType!=null){
            activity.setCcbIdActInv(getCongrantTypeCode(activityType));
        }
        

        String activityStatus = DocumentProcessor.getTagValue("STATUS", congrantNode);
        if (activityStatus != null) {
            activity.setCcbIdEstInves(getCongrantStatusCode(activityStatus));
        }

        String actitvityAwardorg = DocumentProcessor.getTagValue("AWARDORG", congrantNode);
        if (actitvityAwardorg != null) {
            activity.setCcbIdOrganiz(getCongrantAwardorgCode(actitvityAwardorg));
        }

        String activitySponorg = DocumentProcessor.getTagValue("SPONORG", congrantNode);
        if (activitySponorg != null) {
            activity.setCcbInstitucion(activitySponorg);
        }

        String otherInvest = getCongrantOtherInvests(congrantNode);
        if (otherInvest != null && !otherInvest.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(otherInvest.length()>254){
                activity.setCcbOtrPart(otherInvest.substring(0,253));
            }else{
                activity.setCcbOtrPart(otherInvest);
            }
        }

        String activityAbstrac = DocumentProcessor.getTagValue("ABSTRACT", congrantNode);
        if (activityAbstrac != null) {
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(activityAbstrac.length()>254){
                activity.setCcbResumInv(activityAbstrac.substring(0, 253));
            }else{
                activity.setCcbResumInv(activityAbstrac);
            }
            
        }

        String professorRole = getCongrantInvestRole(congrantNode);
        if (professorRole != null) {
            activity.setCcbRolAct(professorRole);
        }

        String activityTitle=DocumentProcessor.getTagValue("TITLE", congrantNode);
        if(activityTitle!=null){
            activity.setCcbTituloProy(activityTitle);
        }

        String activityAmount = DocumentProcessor.getTagValue("AMOUNT", congrantNode);
        if (activityAmount != null) {
            try {
                double amount = Double.parseDouble(activityAmount);
                activity.setCcbValorProy((int)amount);
            } catch (NumberFormatException ex) {
                logger.error("The amount " + activityAmount + " can not be parsed as Integer");
            }
        }

        activity.setDtLastUpdate(new Date());

        return activity;
    }

    /** 
     * Get the code in PeopleNet system of a congrant TYPE tag
     * 
     * @param activityType An string for which the code will be looked
     * @return The PeopleNet system code for the activityType param
     */
    private String getCongrantTypeCode(String activityType) {
        String typeCode = this.OTHER_TYPE;
        switch (activityType) {
            case "Contract":
                typeCode = this.CONTRACT_TYPE;
                break;
            case "Fellowship":
                typeCode = this.FELLOWSHIP_TYPE;
                break;
            case "Grant":
                typeCode = this.GRANT_TYPE;
                break;
            case "Sponsored Research":
                typeCode = this.SPONSORED_RESEARCH_TYPE;
                break;
        }
        return typeCode;
    }

    /** 
     * Get the code in PeopleNet system of a congrant STATUS tag
     * 
     * @param activityStatus An string for which the code will be looked
     * @return The PeopleNet system code for the activityStatus param
     */
    private String getCongrantStatusCode(String activityStatus) {
        String statusCode = this.OTHER_STATUS;
        switch (activityStatus) {
            case "Currently under review":
                statusCode = this.UNDER_REVIEW_STATUS;
                break;
            case "Funded":
                statusCode = this.FUNDED_STATUS;
                break;
            case "Not Funded":
                statusCode = this.NOT_FUNDED_STATUS;
                break;
        }
        return statusCode;
    }

    /** 
     * Get the code in PeopleNet system of a congrant AWARDORG tag
     * 
     * @param activityAwardorg An string for which the code will be looked
     * @return The PeopleNet system code for the activityAwardorg param
     */
    private String getCongrantAwardorgCode(String activityAwardorg) {
        String awardorgCode = this.OTHER_AWARDORG;
        switch (activityAwardorg) {
            case "Universidad Icesi":
                awardorgCode = this.ICESI_AWARDORG;
                break;
            case "Local":
                awardorgCode = this.LOCAL_AWARDORG;
                break;
            case "State":
                awardorgCode = this.STATE_AWARDORG;
                break;
            case "Federal":
                awardorgCode = this.FEDERAL_AWARDORG;
                break;
            case "Private":
                awardorgCode = this.PRIVATE_AWARDORG;
                break;
        }
        return awardorgCode;
    }

    /** 
     * Get the investigators' names of a congrant tag separeted by /
     * 
     * @param congrantNode the congrant tag node to process
     * @return A string of concatened investigators' names of the congrant node passed as param.
     */
    private String getCongrantOtherInvests(Element congrantNode) {
        NodeList investList = congrantNode.getElementsByTagName("CONGRANT_INVEST");
        String investsString = "";

        if (investList != null && investList.getLength() > 0) {
            int investCount = 0;
            for (int i = 0; i < investList.getLength(); i++) {
                Element invest = (Element) investList.item(i);

                //TODO VALIDATE investFacultyName NOT NULL
                String investFacultyName = DocumentProcessor.getTagValue("FACULTY_NAME", invest);
                if (investFacultyName == null || !investFacultyName.equalsIgnoreCase(this.professor.getDmuId())) {
                    String investFname = DocumentProcessor.getTagValue("FNAME", invest);
                    String investMname = DocumentProcessor.getTagValue("MNAME", invest);
                    String investLname = DocumentProcessor.getTagValue("LNAME", invest);
                    String investRole = DocumentProcessor.getTagValue("ROLE", invest);
                    String investStudentLevel = DocumentProcessor.getTagValue("STUDENT_LEVEL", invest);

                    if (investCount != 0) {
                        investsString += "/ ";
                    }
                    if (investFname != null) {
                        investsString += investFname;
                    }
                    if (investMname != null) {
                        investsString += " " + investMname;
                    }
                    if (investLname != null) {
                        investsString += " " + investLname;
                    }
                    if (investRole != null) {
                        investsString += " '" + investRole + "'";
                    }
                    if (investStudentLevel != null) {
                        investsString += " " + investStudentLevel;
                    }

                    investCount++;
                }
            }
        }
        return investsString;
    }

    /** 
     * Get the role of the congrant's  main investigator of a congrant tag
     * 
     * @param congrantNode the congrant tag node to process
     * @return A string representing the role of the congrant's  main investigator
     */
    private String getCongrantInvestRole(Element congrantNode) {
        NodeList investList = congrantNode.getElementsByTagName("CONGRANT_INVEST");
        String investRole = null;

        if (investList != null && investList.getLength() > 0) {
            for (int i = 0; i < investList.getLength(); i++) {
                Element invest = (Element) investList.item(0);
                String investFacultyName = DocumentProcessor.getTagValue("FACULTY_NAME", invest);
                if(investFacultyName!=null && !investFacultyName.equalsIgnoreCase("")){
                    if (investFacultyName.equalsIgnoreCase(this.professor.getDmuId())) {
                        investRole = DocumentProcessor.getTagValue("ROLE", invest);
                        return investRole;
                    }
                }
            }
        }

        return investRole;
    }
}
