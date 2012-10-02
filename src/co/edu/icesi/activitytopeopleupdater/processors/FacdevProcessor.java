/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4scoHrCompBackJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoHrCompBack;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoHrCompBackPK;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.util.DateFormats;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

/**
 * Execute the import process for the FACDEV entities
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
public class FacdevProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(FacdevProcessor.class);
    private final String CONFERENCE_TYPE = "AT_01";
    private final String CONTINUING_EDUCATION_TYPE = "AT_01";
    private final String PROGRAM_TYPE = "AT_01";
    private final String FACULTY_INTERSHIP_TYPE = "AT_01";
    private final String FACULTY_FELLOWSHIP_TYPE = "AT_01";
    private final String SELF_STUDY_TYPE = "AT_01";
    private final String SEMINAR_TYPE = "AT_01";
    private final String TUTORIAL_TYPE = "AT_01";
    private final String WORKSHOP_TYPE = "AT_01";
    private final String OTHER_TYPE = "AT_99";

    public FacdevProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    @Override
    protected synchronized void runProcesor() {
        M4scoHrCompBackJpaController backgroundController = new M4scoHrCompBackJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element facdevNode = (Element) this.entities.item(i);
            String facdevId = facdevNode.getAttribute("id")+":"+this.professor.getUsername();
            try {
                M4scoHrCompBack background = backgroundController.findM4scoHrCompBackByCcbCargueAct(facdevId);
                // If exist, update the registry.
                background = processBackground(background, facdevNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + facdevId);
                    backgroundController.edit(background);
                    logger.info(this.entitie + " with id " + facdevId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not " + this.entitie + " with the id " + facdevId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the facdevId.
                M4scoHrCompBackPK newBackgroundPk = new M4scoHrCompBackPK();
                newBackgroundPk.setIdOrganization(ORGANIZATION_CODE);
                newBackgroundPk.setStdIdHr(this.professor.getPeopleId());
                short nextScoOrCompBg = ((Integer) (backgroundController.getMaxScoOrCompBg(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
                newBackgroundPk.setScoOrCompBg(nextScoOrCompBg);
                M4scoHrCompBack newBackground = new M4scoHrCompBack(newBackgroundPk);
                newBackground.setCcbCargueAct(facdevId);
                newBackground = processBackground(newBackground, facdevNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + facdevId);
                    backgroundController.create(newBackground);
                    logger.info(this.entitie + " with id " + facdevId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The " + this.entitie + " " + facdevId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }

            } catch (NonUniqueResultException ex2) {
                if (facdevId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + facdevId + "in the PeopleNet system table " + M4scoHrCompBack.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4scoHrCompBack.class.getName(), ex2);
                }
            }
        }
    }

    private M4scoHrCompBack processBackground(M4scoHrCompBack background, Element facdevNode) {
        String facdevDesc = DocumentProcessor.getTagValue("DESC", facdevNode);
        if (facdevDesc != null && !facdevDesc.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(facdevDesc.length() > 254){
                background.setCcbDescription(facdevDesc.substring(0, 254));
            }else{
                background.setCcbDescription(facdevDesc);
            }
        }

        String facdevType = DocumentProcessor.getTagValue("TYPE", facdevNode);
        if (facdevType != null && !facdevType.equalsIgnoreCase("")) {
            background.setCcbIdActividad(getFacdevTypeCode(facdevType));
        }

        String facdevOtherType = DocumentProcessor.getTagValue("TYPEOTHER", facdevNode);
        if (facdevOtherType != null && !facdevOtherType.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 70 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(facdevOtherType.length() > 70){
                background.setCcbOtroCurs(facdevOtherType.substring(0, 70));
            }else{
                background.setCcbOtroCurs(facdevOtherType);
            }
        }

        String dtdEnd = DocumentProcessor.getTagValue("DTD_END", facdevNode);
        String dtmEnd = DocumentProcessor.getTagValue("DTM_END", facdevNode);
        String dtyEnd = DocumentProcessor.getTagValue("DTY_END", facdevNode);
        if (dtdEnd != null && !dtdEnd.equalsIgnoreCase("")
                && dtmEnd != null && !dtmEnd.equalsIgnoreCase("")
                && dtyEnd != null && !dtyEnd.equalsIgnoreCase("")) {
            background.setScoDtEnd(DateFormats.fullStringToDate(dtdEnd + "/" + dtmEnd + "/" + dtyEnd));
        }

        String dtdStart = DocumentProcessor.getTagValue("DTD_START", facdevNode);
        String dtmStart = DocumentProcessor.getTagValue("DTM_START", facdevNode);
        String dtyStart = DocumentProcessor.getTagValue("DTY_START", facdevNode);
        if (dtdStart != null && !dtdStart.equalsIgnoreCase("")
                && dtmStart != null && !dtmStart.equalsIgnoreCase("")
                && dtyStart != null && !dtyStart.equalsIgnoreCase("")) {
            background.setScoDtStart(DateFormats.fullStringToDate(dtdStart + "/" + dtmStart + "/" + dtyStart));
        }

        String facdevNumHours = DocumentProcessor.getTagValue("NUMHOURS_YEARLY", facdevNode);
        if (facdevNumHours != null && !facdevNumHours.equalsIgnoreCase("")) {
            short numHours = 0;
            try {
                numHours = Short.parseShort(facdevNumHours);
            } catch (NumberFormatException ex) {
                logger.error(facdevNumHours+" is not a number");
            }
            background.setScoNumberHours(numHours);
        }
        
        String facdevOrg=DocumentProcessor.getTagValue("ORG", facdevNode);
        if(facdevOrg!=null && !facdevOrg.equalsIgnoreCase("")){
            background.setScoNCenter(facdevOrg);
        }
        
        String facdevTitle=DocumentProcessor.getTagValue("TITLE", facdevNode);
        if(facdevTitle!=null && !facdevTitle.equalsIgnoreCase("")){
            background.setScoNCourse(facdevTitle);
        }

        background.setScoDtStart(new Date());

        return background;
    }

    private String getFacdevTypeCode(String facdevType) {
        String facdevTypeCode = this.OTHER_TYPE;
        switch (facdevType) {
            case "Conference Attendance":
                facdevTypeCode = this.CONFERENCE_TYPE;
                break;
            case "Continuing Education":
                facdevTypeCode = this.CONTINUING_EDUCATION_TYPE;
                break;
            case "Program":
                facdevTypeCode = this.PROGRAM_TYPE;
                break;
            case "Faculty Internship":
                facdevTypeCode = this.FACULTY_INTERSHIP_TYPE;
                break;
            case "Faculty Fellowship":
                facdevTypeCode = this.FACULTY_FELLOWSHIP_TYPE;
                break;
            case "Self-Study Program":
                facdevTypeCode = this.SELF_STUDY_TYPE;
                break;
            case "Seminar":
                facdevTypeCode = this.SEMINAR_TYPE;
                break;
            case "Tutorial":
                facdevTypeCode = this.TUTORIAL_TYPE;
                break;
            case "Workshop":
                facdevTypeCode = this.WORKSHOP_TYPE;
                break;
        }
        return facdevTypeCode;
    }
}
