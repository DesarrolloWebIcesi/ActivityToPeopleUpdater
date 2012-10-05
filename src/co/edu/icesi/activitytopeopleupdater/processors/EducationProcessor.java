/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.StdHrAcadBackgrJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrAcadBackgr;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrAcadBackgrPK;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

/**
 * Execute the import process for the EDUCATION entities
 * 
 * @author David Andrés Manzano Herrera - damanzano
 */
public class EducationProcessor extends AbstractProcessor {
    
    private static Logger logger = Logger.getLogger(EducationProcessor.class);
    private final String BACHELOR_ARTS_DEGREE="BA";
    private final String BACHELOR_SCIENCES_DEGREE="BS";
    private final String BACHELOR_BUSINESS_DEGREE="BBA";
    private final String JURIS_DOCTOR_DEGREE="JD";
    private final String MASTER_ARTS_DEGREE="MA";
    private final String MASTER_SCIENCES_DEGREE="MS";
    private final String MASTER_BUSINESS_DEGREE="MBA";
    private final String MASTER_LAWS_DEGREE="LLM";
    private final String PHD_DEGREE="Ph.D";
    private final String DOCTOR_BUSINESS_DEGREE="DBA";
    private final String DOCTOR_EDUCATION_DEGREE="EDD";
    private final String OTHER_DEGREE="000";

    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public EducationProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {
        StdHrAcadBackgrJpaController academicBgsController = new StdHrAcadBackgrJpaController(this.EMF);
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element educationNode = (Element) this.entities.item(i);
            String educationID = educationNode.getAttribute("id")+":"+this.professor.getUsername();
            try {
                StdHrAcadBackgr academicBg = academicBgsController.findStdHrAcadBackgrByCcbCargueAct(educationID);
                // If exist, update the registry.
                academicBg = processAcademicBg(academicBg, educationNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + educationID);
                    academicBgsController.edit(academicBg);
                    logger.info(this.entitie + " with id " + educationID + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not " + this.entitie + " with the id " + educationID + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the educationID.
                StdHrAcadBackgrPK newAcademicBgPk = new StdHrAcadBackgrPK();
                newAcademicBgPk.setIdOrganization(ORGANIZATION_CODE);
                newAcademicBgPk.setStdIdHr(this.professor.getPeopleId());
                short nextCcbOrCurCdur = ((Integer) (academicBgsController.getMaxStdOrdAcdBack(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
                newAcademicBgPk.setStdOrdAcdBack(nextCcbOrCurCdur);
                StdHrAcadBackgr newAcademicBg = new StdHrAcadBackgr(newAcademicBgPk);
                newAcademicBg.setCcbCargueAct(educationID);
                newAcademicBg = processAcademicBg(newAcademicBg, educationNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + educationID);
                    academicBgsController.create(newAcademicBg);
                    logger.info(this.entitie + " with id " + educationID + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The " + this.entitie + " " + educationID + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }

            } catch (NonUniqueResultException ex2) {
                if (educationID != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + educationID + "in the PeopleNet system table " + StdHrAcadBackgr.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + StdHrAcadBackgr.class.getName(), ex2);
                }
            }
        }
    }

    /** 
     * Process an entity's information and saves it in PeopleNet database objects 
     * 
     * @param academicBg A StdHrAcadBackgr Object in which the information will be saved
     * @param educationNode The entity node that will be processed
     * 
     * @return A filled StdHrAcadBackgr Object
     */
    private StdHrAcadBackgr processAcademicBg(StdHrAcadBackgr academicBg, Element educationNode) {
        String isHighest = DocumentProcessor.getTagValue("HIGHEST", educationNode);
        if (isHighest != null && isHighest.equalsIgnoreCase("yes")) {
            academicBg.setCcbMaxTituObt("1");
        } else {
            academicBg.setCcbMaxTituObt("0");
        }
        
        String academicBgArea=DocumentProcessor.getTagValue("SUPPAREA", educationNode);
        if(academicBgArea!=null && !academicBgArea.equalsIgnoreCase("")){
            //FIXED
            //academicBg.setCcbOtroTitul(academicBgArea);
            academicBg.setCcbOtroEspec(academicBgArea);
        }
        
        String academicBgTitulation=DocumentProcessor.getTagValue("DEGOTHER", educationNode);
        if(academicBgTitulation!=null && !academicBgTitulation.equals("")){
            academicBg.setCcbOtroTForm(academicBgTitulation);
        }
        
        String dissertationTitle=DocumentProcessor.getTagValue("DISSTITLE", educationNode);
        if(dissertationTitle!=null && !dissertationTitle.equalsIgnoreCase("")){
            academicBg.setCcbTituTrab(dissertationTitle);
        }
        
        String academicBgDistinction=DocumentProcessor.getTagValue("DISTINCTION", educationNode);
        if(academicBgDistinction!=null && !academicBgDistinction.equalsIgnoreCase("")){
            academicBg.setCcbValorOpt(academicBgDistinction);
        }
        
        String academicBgYearComp=DocumentProcessor.getTagValue("YR_COMP", educationNode);
        if(academicBgYearComp!=null && !academicBgYearComp.equalsIgnoreCase("")){
            academicBg.setCcbYearTerm(academicBgYearComp);
        }
        
        String institutionLocation=DocumentProcessor.getTagValue("LOCATION", educationNode);
        if(institutionLocation!=null && !institutionLocation.equalsIgnoreCase("")){
            academicBg.setStdComment(institutionLocation);
        }
        
        /** 
         * FIXME: I decide always saving the OTHER=000 value, beacuse the match between the value in ActivityInsight
         * and the universities list in PeopleNet is really tought to do comparing universities names strings
         * besides the input for the same university can be diferent in both systems, for example: lowercase
         * uppercase and special chars 
         */
        academicBg.setStdIdEduCenter("000");
        
        String institution=DocumentProcessor.getTagValue("SCHOOL", educationNode);
        if(institution!=null && !institution.equalsIgnoreCase("")){
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(institution.length()>254){
                academicBg.setStdDescEduCenter(institution.substring(0, 253));
            }else{
                academicBg.setStdDescEduCenter(institution);
            }
        }
        
        //FIXME: I decide saving the same value of the web service - damanzano
        String academicBgDegree=DocumentProcessor.getTagValue("DEG", educationNode);
        if(academicBgDegree!=null && !academicBgDegree.equalsIgnoreCase("")){
            /** 
             * The line below was commented because there was an error in the map document
             * and the degree level must be seved in the STD_id_DIPLOMA field.
             */
            //academicBg.setSukIdQualLevel(academicBgDegree);
            academicBg.setStdIdDiploma(getEducationDegreeCode(academicBgDegree));
        }
        
        academicBg.setDtLastUpdate(new Date());
                
        return academicBg;
    }
    
    /** 
     * Special case for the Ph D degree level that must be saved as Ph.D in place of Ph D.
     * The other degree values are stored as they come from the webservice.
     * 
     * @param educationDegree An string for which the code will be looked
     * @return The PeopleNet system code for the educationDegree param
     */
    private String getEducationDegreeCode(String educationDegree) {
        if(educationDegree.equalsIgnoreCase("Ph D")){
            return "Ph.D";
        }
        return educationDegree;
    }
}
