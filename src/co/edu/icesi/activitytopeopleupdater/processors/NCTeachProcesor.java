/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvCurCdurJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCurCdur;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCurCdurPK;
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
 * Execute the import process for the NCTEACH entities
 * @author David Andrés Manzano Herrera - damanzano
 */
public class NCTeachProcesor extends AbstractProcessor{
    
    private static Logger logger = Logger.getLogger(NCTeachProcesor.class);
    private final String INTERNAL_AUDIENCE="AU_01";
    private final String EXTERNAL_AUDIENCE="AU_02";
    private final String BOTH_AUDIENCE="AU_03";
    
    private final String CERTIFICATION_TYPE="IT_01";
    private final String CONTINUING_EDUCATION_TYPE="IT_02";
    private final String FACULTY_INTERNSHIP_TYPE="IT_03";
    private final String GUEST_LECTURE_TYPE="IT_04";
    private final String MANAGEMENT_TYPE="IT_05";
    private final String REVIEW_TYPE="IT_06";
    private final String SEMINAR_TYPE="IT_07";
    private final String WORKSHOP_TYPE="IT_08";
    private final String OTHER_TYPE="IT_99";

    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public NCTeachProcesor(Professor professor, String entitie) {
        super(professor, entitie);
    }
    
    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {
        M4ccbCvCurCdurJpaController coursesController = new M4ccbCvCurCdurJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element ncteachNode = (Element) this.entities.item(i);
            String ncteachId = ncteachNode.getAttribute("id")+":"+this.professor.getUsername();
            try {
                M4ccbCvCurCdur course = coursesController.findM4ccbCvCurCdurByCcbCargueAct(ncteachId);
                // If exist, update the registry.
                course = processCourse(course, ncteachNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + ncteachId);
                    coursesController.edit(course);
                    logger.info(this.entitie + " with id " + ncteachId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not " + this.entitie + " with the id " + ncteachId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the ncteachId.
                M4ccbCvCurCdurPK newCoursePk = new M4ccbCvCurCdurPK();
                newCoursePk.setIdOrganization(ORGANIZATION_CODE);
                newCoursePk.setStdIdHr(this.professor.getPeopleId());
                short nextCcbOrCurCdur =((Integer)(coursesController.getMaxCcbOrCurCdur(this.professor.getPeopleId(), ORGANIZATION_CODE)+1)).shortValue();
                newCoursePk.setCcbOrCurCdur(nextCcbOrCurCdur);
                M4ccbCvCurCdur newCourse = new M4ccbCvCurCdur(newCoursePk);
                newCourse.setCcbCargueAct(ncteachId);
                newCourse = processCourse(newCourse, ncteachNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + ncteachId);
                    coursesController.create(newCourse);
                    logger.info(this.entitie + " with id " + ncteachId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The " + this.entitie + " " + ncteachId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }

            } catch (NonUniqueResultException ex2) {
                if (ncteachId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value " + ncteachId + "in the PeopleNet system table " + M4ccbCvCurCdur.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvCurCdur.class.getName(), ex2);
                }
            }
        }
    }

    /** 
     * Process an entity's information and saves it in PeopleNet database objects 
     * 
     * @param course A M4ccbCvCurCdur Object in which the information will be saved
     * @param ncteachNode The entity node that will be processed
     * 
     * @return A filled M4ccbCvCurCdur Object
     */
    private M4ccbCvCurCdur processCourse(M4ccbCvCurCdur course, Element ncteachNode) {
        String courseDescription=DocumentProcessor.getTagValue("DESC", ncteachNode);
        if(courseDescription!=null && !courseDescription.equalsIgnoreCase("")){
            if(courseDescription.length() > 1000){
                course.setCcbDescAct(courseDescription.substring(0, 999));
            }else{
                course.setCcbDescAct(courseDescription);
            }
        }
        
        String dtdEnd = DocumentProcessor.getTagValue("DTD_END", ncteachNode);
        String dtmEnd = DocumentProcessor.getTagValue("DTM_END", ncteachNode);
        String dtyEnd = DocumentProcessor.getTagValue("DTY_END", ncteachNode);
        if (dtdEnd != null && !dtdEnd.equalsIgnoreCase("")
                && dtmEnd != null && !dtmEnd.equalsIgnoreCase("")
                && dtyEnd != null && !dtyEnd.equalsIgnoreCase("")) {
            course.setCcbDtEnd(DateFormats.fullStringToDate(dtdEnd + "/" + dtmEnd + "/" + dtyEnd));
        }
        
        String dtdStart = DocumentProcessor.getTagValue("DTD_START", ncteachNode);
        String dtmStart = DocumentProcessor.getTagValue("DTM_START", ncteachNode);
        String dtyStart = DocumentProcessor.getTagValue("DTY_START", ncteachNode);
        if (dtdStart != null && !dtdStart.equalsIgnoreCase("")
                && dtmStart != null && !dtmStart.equalsIgnoreCase("")
                && dtyStart != null && !dtyStart.equalsIgnoreCase("")) {
            course.setCcbDtStart(DateFormats.fullStringToDate(dtdStart + "/" + dtmStart + "/" + dtyStart));
        }
        
        String courseAudience=DocumentProcessor.getTagValue("AUDIENCE", ncteachNode);
        if(courseAudience!=null && !courseAudience.equalsIgnoreCase("")){
            course.setCcbIdAudiencia(getNCTeachAudienceCode(courseAudience));
        }
        
        String courseType=DocumentProcessor.getTagValue("TYPE", ncteachNode);
        if(courseType!=null && !courseType.equalsIgnoreCase("")){
            course.setCcbIdInstruc(getNCTeachTypeCode(courseType));
        }
        
        String courseOrg=DocumentProcessor.getTagValue("ORG", ncteachNode);
        if(courseOrg!=null && !courseOrg.equalsIgnoreCase("")){
            course.setCcbInstEmp(courseOrg);
        }
        
        String courseNumPart=DocumentProcessor.getTagValue("NUMPART", ncteachNode);
        if(courseNumPart!=null && !courseNumPart.equalsIgnoreCase("")){
            /**
             * FIXME: Trunc in 10 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(courseNumPart.length() > 10){
                course.setCcbNumPart(courseNumPart.substring(0, 10));
            }else{
                course.setCcbNumPart(courseNumPart);
            }
        }
        
        String courseOtherType = DocumentProcessor.getTagValue("TYPEOTHER", ncteachNode);
        if(courseOtherType!=null && !courseOtherType.equalsIgnoreCase("")){
            course.setCcbOtroInst(courseOtherType);
        }
        
        String isProfessional=DocumentProcessor.getTagValue("PROFACAD", ncteachNode);
        if(isProfessional!=null && isProfessional.equalsIgnoreCase("Academic")){
            course.setCcbRamaAcad("1");
        }else{
            course.setCcbRamaAcad("0");
        }
        
        course.setDtLastUpdate(new Date());
        
        return course;
    }
    
    /** 
     * Get the code in PeopleNet system of a ncteach AUDIENCE tag
     * 
     * @param ncteachAudience An string for which the code will be looked
     * @return The PeopleNet system code for the ncteachAudience param
     */
    private String getNCTeachAudienceCode(String ncteachAudience){
        String ncteachAudienceCode=this.BOTH_AUDIENCE;
        switch(ncteachAudience){
            case "Internal to Universidad Icesi":
                ncteachAudienceCode=this.INTERNAL_AUDIENCE;
                break;
            case "External to Universidad Icesi":
                ncteachAudienceCode=this.EXTERNAL_AUDIENCE;
                break;
            case "Both":
                ncteachAudienceCode=this.BOTH_AUDIENCE;
                break;
        }
        return ncteachAudienceCode;
    }

    /** 
     * Get the code in PeopleNet system of a ncteach TYPE tag
     * 
     * @param ncteachType An string for which the code will be looked
     * @return The PeopleNet system code for the ncteachType param
     */
    private String getNCTeachTypeCode(String ncteachType) {
        String ncteachTypeCode=this.OTHER_TYPE;
        switch(ncteachType){
            case "Certification":
                ncteachTypeCode=this.CERTIFICATION_TYPE;
                break;
            case "Continuing Education":
                ncteachTypeCode=this.CONTINUING_EDUCATION_TYPE;
                break;
            case "Faculty Internship":
                ncteachTypeCode=this.FACULTY_INTERNSHIP_TYPE;
                break;
            case "Guest Lecture":
                ncteachTypeCode=this.GUEST_LECTURE_TYPE;
                break;
            case "Management/Executive Development":
                ncteachTypeCode=this.MANAGEMENT_TYPE;
                break;
            case "Review Course":
                ncteachTypeCode=this.REVIEW_TYPE;
                break;
            case "Seminar":
                ncteachTypeCode=this.SEMINAR_TYPE;
                break;
            case "Workshop":
                ncteachTypeCode=this.WORKSHOP_TYPE;
                break;
        }
        return ncteachTypeCode;
    }
    
}
