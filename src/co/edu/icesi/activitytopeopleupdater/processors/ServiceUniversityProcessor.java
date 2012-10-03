/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4scoAssocMeJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoAssocMe;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoAssocMePK;
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
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
public class ServiceUniversityProcessor extends AbstractProcessor{
    
    private static Logger logger = Logger.getLogger(ServiceUniversityProcessor.class);
    private final String INTERNATIONAL_SCOPE = "SC_01";
    private final String NATIONAL_SCOPE = "SC_02";
    private final String REGIONAL_SCOPE = "SC_03";
    private final String STATE_SCOPE = "SC_04";
    private final String LOCAL_SCOPE = "SC_05";
    private final String UNIVERSITY_SCOPE = "SC_06";
    private final String COLLEGE_SCOPE = "SC_07";
    private final String DEPARTMENT_SCOPE = "SC_08";

    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public ServiceUniversityProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }
    
    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {
        M4scoAssocMeJpaController associationsController = new M4scoAssocMeJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element multipleNode = (Element) this.entities.item(i);
            String multipleId = multipleNode.getAttribute("id")+":"+this.professor.getUsername();
            try {
                M4scoAssocMe association = associationsController.findM4scoAssocMeByCcbCargueAct(multipleId);
                // If exist, update the registry.
                association = processAssociation(association, multipleNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + multipleId);
                    associationsController.edit(association);
                    logger.info(this.entitie + " with id " + multipleId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not " + this.entitie + " with the id " + multipleId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the multipleId.
                M4scoAssocMePK newAssociationPk = new M4scoAssocMePK();
                newAssociationPk.setIdOrganization(ORGANIZATION_CODE);
                newAssociationPk.setScoIdHr(this.professor.getPeopleId());
                short nextScoOrAssocMemb =((Integer)(associationsController.getMaxScoOrAssocMemb(this.professor.getPeopleId(), ORGANIZATION_CODE)+1)).shortValue();
                newAssociationPk.setScoOrAssocMemb(nextScoOrAssocMemb);
                M4scoAssocMe newAssociation = new M4scoAssocMe(newAssociationPk);
                newAssociation.setCcbCargueAct(multipleId);
                newAssociation = processAssociation(newAssociation, multipleNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + multipleId);
                    associationsController.create(newAssociation);
                    logger.info(this.entitie + " with id " + multipleId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The " + this.entitie + " " + multipleId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }

            } catch (NonUniqueResultException ex2) {
                if (multipleId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + multipleId + "in the PeopleNet system table " + M4scoAssocMe.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4scoAssocMe.class.getName(), ex2);
                }
            }
        }
    }

    private M4scoAssocMe processAssociation(M4scoAssocMe association, Element multipleNode) {

        String organization = DocumentProcessor.getTagValue("ORGABBR", multipleNode);
        if (organization != null && !organization.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 10 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(organization.length()>10){
                association.setCcbAbreviatura(organization.substring(0,9));
            }else{
                association.setCcbAbreviatura(organization);
            }
        }

        String description = DocumentProcessor.getTagValue("DESC", multipleNode);
        if (description != null && !description.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(description.length()>254){
                association.setCcbActOrg(description.substring(0, 253));
                association.setCcbResponsb(description.substring(0, 253));
            }else{
                association.setCcbActOrg(description);
                association.setCcbResponsb(description);
            }
        }

        String isCompensated = DocumentProcessor.getTagValue("COMPENSATED", multipleNode);
        if (isCompensated != null && !isCompensated.equalsIgnoreCase("Compensated")) {
            if (isCompensated.equalsIgnoreCase("Compensated")) {
                association.setCcbCompens("1");
            } else {
                association.setCcbCompens("0");
            }
        }

        String isElected = DocumentProcessor.getTagValue("ELECAPP", multipleNode);
        if (isElected != null && !isElected.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 70 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(isElected.length()>70){
                association.setCcbFormaElec(isElected.substring(0,69));
            }else{
                association.setCcbFormaElec(isElected);
            }
        }

        String scope = DocumentProcessor.getTagValue("SCOPE", multipleNode);
        if (scope != null && !scope.equalsIgnoreCase("")) {
            String scopeCode=getAssociationScopeCode(scope);
            if(!scopeCode.equalsIgnoreCase("")){
                association.setCcbIdAmbito(scopeCode);
            }
        }

        String isServedEx = DocumentProcessor.getTagValue("EXOFFICIO", multipleNode);
        if (isServedEx != null && !isServedEx.equalsIgnoreCase("")) {
            if (isServedEx.equalsIgnoreCase("Yes")) {
                association.setCcbInherCarg("1");
            } else {
                association.setCcbInherCarg("0");
            }
        }

        String name = DocumentProcessor.getTagValue("NAME", multipleNode);
        if (name != null && !name.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 520 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(name.length()>520){
                association.setCcbNombre(name.substring(0,519));
            }else{
                association.setCcbNombre(name);
            }
        }
        
        name=DocumentProcessor.getTagValue("ORG", multipleNode);
        if (name != null && !name.equalsIgnoreCase("")) {
            /**
             * FIXME: Trunc in 520 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(name.length()>520){
                association.setCcbNombre(name.substring(0,519));
            }else{
                association.setCcbNombre(name);
            }
        }
        
        String leadershipOrRole=DocumentProcessor.getTagValue("LEADERSHIP", multipleNode);
        if(leadershipOrRole!=null && !leadershipOrRole.equalsIgnoreCase("")){
            /**
             * FIXME: Trunc in 70 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(leadershipOrRole.length() > 70){
                association.setCcbRolCarg(leadershipOrRole.substring(0, 69));
            }else{
                association.setCcbRolCarg(leadershipOrRole);
            }
        }
        
        leadershipOrRole=DocumentProcessor.getTagValue("ROLE", multipleNode);
        if(leadershipOrRole!=null && !leadershipOrRole.equalsIgnoreCase("")){
            /**
             * FIXME: Trunc in 70 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(leadershipOrRole.length() > 70){
                association.setCcbRolCarg(leadershipOrRole.substring(0, 69));
            }else{
                association.setCcbRolCarg(leadershipOrRole);
            }
        }
        
        String dtdEnd = DocumentProcessor.getTagValue("DTD_END", multipleNode);
        String dtmEnd = DocumentProcessor.getTagValue("DTM_END", multipleNode);
        String dtyEnd = DocumentProcessor.getTagValue("DTY_END", multipleNode);
        if (dtdEnd != null && !dtdEnd.equalsIgnoreCase("")
                && dtmEnd != null && !dtmEnd.equalsIgnoreCase("")
                && dtyEnd != null && !dtyEnd.equalsIgnoreCase("")) {
            association.setScoDtEnd(DateFormats.fullStringToDate(dtdEnd + "/" + dtmEnd + "/" + dtyEnd));
        }
        
        String dtdStart = DocumentProcessor.getTagValue("DTD_START", multipleNode);
        String dtmStart = DocumentProcessor.getTagValue("DTM_START", multipleNode);
        String dtyStart = DocumentProcessor.getTagValue("DTY_START", multipleNode);
        if (dtdStart != null && !dtdStart.equalsIgnoreCase("")
                && dtmStart != null && !dtmStart.equalsIgnoreCase("")
                && dtyStart != null && !dtyStart.equalsIgnoreCase("")) {
            association.setScoDtStart(DateFormats.fullStringToDate(dtdStart + "/" + dtmStart + "/" + dtyStart));
        }

        association.setCcbIdActAsc("TA_04");
        association.setDtLastUpdate(new Date());

        return association;
    }
    
    private String getAssociationScopeCode(String scope) {
         String scopeCode="";
        switch(scope){
            case "International":
                scopeCode=this.INTERNATIONAL_SCOPE;
                break;
            case "National":
                scopeCode=this.NATIONAL_SCOPE;
                break;
            case "Regional":
                scopeCode=this.REGIONAL_SCOPE;
                break;
            case "State":
                scopeCode=this.STATE_SCOPE;
                break;
            case "Local":
                scopeCode=this.LOCAL_SCOPE;
                break;
            case "University":
                scopeCode=this.UNIVERSITY_SCOPE;
                break;
            case "College":
                scopeCode=this.COLLEGE_SCOPE;
                break;
            case "Department":
                scopeCode=this.DEPARTMENT_SCOPE;
                break;
        }
        return scopeCode;
    }
    
}
