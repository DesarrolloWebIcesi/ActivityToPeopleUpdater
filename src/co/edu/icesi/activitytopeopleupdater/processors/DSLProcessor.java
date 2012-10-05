/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvJurComJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurCom;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurComPK;

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
 * Execute the import process for the DSL entities
 *
 * @author David Andrés Manzano Herrera
 */
public class DSLProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(DSLProcessor.class);
    private final String COMPLETE_COMPSTAGE = "SC_01";
    private final String IN_PROCESS_COMPSTAGE = "SC_02";
    private final String PROPOSAL_COMPSTAGE = "SC_03";
    private final String CANCELED_COMPSTAGE = "SC_04";
    private final String OTHER_COMPSTAGE = "SC_99";
    private final String DISSERTATION_COMMITTEE_CHAIR_TYPE = "IV_01";
    private final String DISSERTATION_DEFENSE_COMMITTEE_CHAIR_TYPE = "IV_02";
    private final String DISSETATION_COMMITTEE_MEMBER_TYPE = "IV_03";
    private final String DOCTORAL_ADVISORY_COMMITTEE_CHAIR_TYPE = "IV_04";
    private final String DOCTORAL_ADVISORY_COMMITTEE_MEMBER_TYPE = "IV_05";
    private final String INTERSHIP_ADVISOR_TYPE = "IV_06";
    private final String MASTER_THESIS_COMMITTEE_CHAIT_TYPE = "IV_07";
    private final String MASTER_THESIS_COMMITTEE_MEMBER_TYPE = "IV_05";
    private final String SUPERVISED_RESEARCH_TYPE = "IV_09";
    private final String SUPERVISED_TEACHING_ACTIVITY_TYPE = "IV_10";
    private final String UNDERGRADUATE_FINAL_PROJECT_TYPE = "IV_11";
    private final String OTHER_TYPE = "IV_99";

    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public DSLProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {
        M4ccbCvJurComJpaController dslController = new M4ccbCvJurComJpaController(this.EMF);
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element dslNode = (Element) this.entities.item(i);
            String dslId = dslNode.getAttribute("id") + ":" + this.professor.getUsername();

            try {
                M4ccbCvJurCom dsl = dslController.findM4ccbCvJurComByCcbCargueAct(dslId);
                // If exist, update the registry.
                dsl = processDSL(dsl, dslNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + dslId);
                    dslController.edit(dsl);
                    logger.info(this.entitie + " with id " + dslId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not " + this.entitie + " with the id " + dslId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the congrantId.
                M4ccbCvJurComPK newDSLPk = new M4ccbCvJurComPK();
                newDSLPk.setIdOrganization(ORGANIZATION_CODE);
                newDSLPk.setStdIdHr(this.professor.getPeopleId());
                short nextCcbOrJurCom = ((Integer) (dslController.getMaxCcbOrJurCom(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
                newDSLPk.setCcbOrJurCom(nextCcbOrJurCom);
                M4ccbCvJurCom newDSL = new M4ccbCvJurCom(newDSLPk);
                newDSL.setCcbCargueAct(dslId);
                newDSL = processDSL(newDSL, dslNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + dslId);
                    dslController.create(newDSL);
                    logger.info(this.entitie + " with id " + dslId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The " + this.entitie + " " + dslId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }

            } catch (NonUniqueResultException ex2) {
                if (dslId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + dslId + "in the PeopleNet system table " + M4ccbCvJurCom.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvJurCom.class.getName(), ex2);
                }
            }
        }
    }
    
    /** 
     * Process an entity's information and saves it in PeopleNet database objects 
     * 
     * @param dsl A M4ccbCvJurCom Object in which the information will be saved
     * @param dslNode The entity node that will be processed
     * 
     * @return A filled M4ccbCvJurCom Object
     */
    private M4ccbCvJurCom processDSL(M4ccbCvJurCom dsl, Element dslNode) {
        String dslComment = DocumentProcessor.getTagValue("COMMENT", dslNode);
        if (dslComment != null) {
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in
             * PeopleNet system replace after to 1000.
             */
            if (dslComment.length() > 254) {
                dsl.setCcbComentarios(dslComment.substring(0, 253));
            } else {
                dsl.setCcbComentarios(dslComment);
            }
        }

        String dtdEnd = DocumentProcessor.getTagValue("DTD_END", dslNode);
        String dtmEnd = DocumentProcessor.getTagValue("DTM_END", dslNode);
        String dtyEnd = DocumentProcessor.getTagValue("DTY_END", dslNode);
        if (dtdEnd != null && !dtdEnd.equalsIgnoreCase("")
                && dtmEnd != null && !dtmEnd.equalsIgnoreCase("")
                && dtyEnd != null && !dtyEnd.equalsIgnoreCase("")) {
            dsl.setCcbDtEnd(DateFormats.fullStringToDate(dtdEnd + "/" + dtmEnd + "/" + dtyEnd));
        }

        String dtdStart = DocumentProcessor.getTagValue("DTD_START", dslNode);
        String dtmStart = DocumentProcessor.getTagValue("DTM_START", dslNode);
        String dtyStart = DocumentProcessor.getTagValue("DTY_START", dslNode);
        if (dtdStart != null && !dtdStart.equalsIgnoreCase("")
                && dtmStart != null && !dtmStart.equalsIgnoreCase("")
                && dtyStart != null && !dtyStart.equalsIgnoreCase("")) {
            dsl.setCcbDtStart(DateFormats.fullStringToDate(dtdStart + "/" + dtmStart + "/" + dtyStart));
        }

        String dslCompstage = DocumentProcessor.getTagValue("COMPSTAGE", dslNode);
        if (dslCompstage != null) {
            dslCompstage = getDslCompstageCode(dslCompstage);
            dsl.setCcbIdEstadoAct(dslCompstage);
        }

        String dslType = DocumentProcessor.getTagValue("TYPE", dslNode);
        if (dslType != null && !dslType.equalsIgnoreCase("")) {
            dslType = getDslTypeCode(dslType);
        } else {
            dslType = this.OTHER_TYPE;
        }
        dsl.setCcbIdOrientacion(dslType);

        if (dslType.equalsIgnoreCase(this.OTHER_TYPE)) {
            String dslOtherType = DocumentProcessor.getTagValue("TYPE_OTHER", dslNode);
            if (dslOtherType != null) {
                /**
                 * FIXME: Trunc in 70 because that is the lenght of the field
                 * in PeopleNet system replace after to 1000.
                 */
                if(dslOtherType.length()>70){
                    dsl.setCcbOtrInvoluc(dslOtherType.substring(0,69));
                }else{
                    dsl.setCcbOtrInvoluc(dslOtherType);
                }
            }
        }

        String students = getDslStudents(dslNode);
        if (students != null && !students.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 100 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(students.length()>100){
                dsl.setCcbNomEstud(students.substring(0, 99));
            }else{
                dsl.setCcbNomEstud(students);
            }
        }

        String studentsProgram = getDslStudentsPrograms(dslNode);
        if (studentsProgram != null) {
            dsl.setCcbPrograma(studentsProgram);
        }

        String dslTitle = DocumentProcessor.getTagValue("TITLE", dslNode);
        if (dslTitle != null) {
            dsl.setCcbTituloProy(dslTitle);
        }

        dsl.setDtLastUpdate(new Date());

        return dsl;
    }

    /** 
     * Get the code in PeopleNet system of a dsl COMPSTAGE tag
     * 
     * @param dslCompstage An string for which the code will be looked
     * @return The PeopleNet system code for the dslCompstage param
     */
    private String getDslCompstageCode(String dslCompstage) {
        String compsatageCode = this.OTHER_COMPSTAGE;
        switch (dslCompstage) {
            case "Completed":
                compsatageCode = this.COMPLETE_COMPSTAGE;
                break;
            case "In-Process":
                compsatageCode = this.IN_PROCESS_COMPSTAGE;
                break;
            case "Proposal":
                compsatageCode = this.PROPOSAL_COMPSTAGE;
                break;
            case "Canceled":
                compsatageCode = this.CANCELED_COMPSTAGE;
                break;
            default:
                compsatageCode = this.OTHER_COMPSTAGE;
        }
        return compsatageCode;
    }

    /** 
     * Get the students' names of a dsl tag separeted by /
     * 
     * @param dslNode the dsl tag node to process
     * @return A string of concatened students' names of the dsl node passed as param.
     */
    private String getDslStudents(Element dslNode) {
        NodeList studentsList = dslNode.getElementsByTagName("DSL_STUDENT");
        String studentsString = "";

        if (studentsList != null && studentsList.getLength() > 0) {
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element student = (Element) studentsList.item(i);
                String studentFname = DocumentProcessor.getTagValue("FNAME", student);
                String studentLname = DocumentProcessor.getTagValue("LNAME", student);

                if (i != 0) {
                    studentsString += "/ ";
                }
                if (studentFname != null) {
                    studentsString += studentFname;
                }
                if (studentLname != null) {
                    studentsString += " " + studentLname;
                }
            }
        }

        return studentsString;
    }

    /** 
     * Get the code in PeopleNet system of a dsl TYPE tag
     * 
     * @param dslType An string for which the code will be looked
     * @return The PeopleNet system code for the dslType param
     */
    private String getDslTypeCode(String dslType) {
        String dslTypeCode = this.OTHER_TYPE;
        switch (dslType) {
            case "Dissertation Committee Chair":
                dslTypeCode = this.DISSERTATION_COMMITTEE_CHAIR_TYPE;
                break;
            case "Dissertation Defense Committee Chair":
                dslTypeCode = this.DISSERTATION_DEFENSE_COMMITTEE_CHAIR_TYPE;
                break;
            case "Dissertation Committee Member":
                dslTypeCode = this.DISSETATION_COMMITTEE_MEMBER_TYPE;
                break;
            case "Doctoral Advisory Committee Chair":
                dslTypeCode = this.DOCTORAL_ADVISORY_COMMITTEE_CHAIR_TYPE;
                break;
            case "Doctoral Advisory Committee Member":
                dslTypeCode = this.DOCTORAL_ADVISORY_COMMITTEE_MEMBER_TYPE;
                break;
            case "Internship Advisor":
                dslTypeCode = this.INTERSHIP_ADVISOR_TYPE;
                break;
            case "Master's Thesis Committee Chair":
                dslTypeCode = this.MASTER_THESIS_COMMITTEE_CHAIT_TYPE;
                break;
            case "Master's Thesis Committee Member":
                dslTypeCode = this.MASTER_THESIS_COMMITTEE_MEMBER_TYPE;
                break;
            case "Supervised Research":
                dslTypeCode = this.SUPERVISED_RESEARCH_TYPE;
                break;
            case "Supervised Teaching Activity":
                dslTypeCode = this.SUPERVISED_TEACHING_ACTIVITY_TYPE;
                break;
            case "Undergraduate Final Project":
                dslTypeCode = this.UNDERGRADUATE_FINAL_PROJECT_TYPE;
                break;
            default:
                dslTypeCode = this.OTHER_TYPE;
        }
        return dslTypeCode;
    }

    /** 
     * Get the students' programs of a dsl tag separeted by /
     * 
     * @param dslNode the dsl tag node to process
     * @return A string of concatened students' programs of the dsl node passed as param.
     */
    private String getDslStudentsPrograms(Element dslNode) {
        NodeList studentsList = dslNode.getElementsByTagName("DSL_STUDENT");
        String studentsProgramString = "";

        if (studentsList != null && studentsList.getLength() > 0) {
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element student = (Element) studentsList.item(i);
                String studentProgram = DocumentProcessor.getTagValue("PROGRAM", student);

                if (i != 0) {
                    studentsProgramString += "/ ";
                }
                if (studentProgram != null) {
                    studentsProgramString += studentProgram;
                }else{
                    studentsProgramString += "-";
                }
            }
        }

        return studentsProgramString;
    }
}
