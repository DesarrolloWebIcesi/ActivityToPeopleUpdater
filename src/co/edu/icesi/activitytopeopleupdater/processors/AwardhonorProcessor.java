/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvDistincJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistinc;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistincPK;
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
 * Execute the import process for the AWARDHONOR entities
 *
 * @author David Andrés Manzano Herrera - damanzano
 */
public class AwardhonorProcessor extends AbstractProcessor {
    
    private static Logger logger = Logger.getLogger(AwardhonorProcessor.class);
    private final String LEADERSHIP_SCOPE = "DS_01";
    private final String TEACHING_SCOPE = "DS_02";
    private final String RESEARCH_SCOPE = "DS_03";
    private final String COMMUNITY_SERVICE_SCOPE = "DS_04";
    private final String PROFESIONAL_SERVICE_SCOPE = "DS_05";
    private final String UNIVERSITY_SERVICE_SCOPE = "DS_06";
    private final String OTHER_SCOPE = "DS_99";
    private final String INTERNATIONAL_SCOPE_LOCALE = "SP_01";
    private final String NATIONAL_SCOPE_LOCALE = "SP_02";
    private final String REGIONAL_SCOPE_LOCALE = "SP_03";
    private final String STATE_SCOPE_LOCALE = "SP_04";
    private final String LOCAL_SCOPE_LOCALE = "SP_05";
    private final String UNIVERSITY_SCOPE_LOCALE = "SP_06";
    private final String COLLEGE_SCOPE_LOCALE = "SP_07";
    private final String DEPARTMENT_SCOPE_LOCALE = "SP_08";

    public AwardhonorProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    @Override
    protected synchronized void runProcesor() {

        M4ccbCvDistincJpaController distinctionsController = new M4ccbCvDistincJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        for (int i = 0; i < this.entities.getLength(); i++) {
            //First verify if the activitie exist
            Element awardNode = (Element) this.entities.item(i);
            String awardId = awardNode.getAttribute("id")+":"+this.professor.getUsername();

            try {
                M4ccbCvDistinc distinction = distinctionsController.findM4ccbCvDistincByCcbCargueAct(awardId);
                // If exist, update the registry.
                distinction = processDistinction(distinction, awardNode);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + awardId);
                    distinctionsController.edit(distinction);
                    logger.info(this.entitie + " with id " + awardId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not dsl with the id " + awardId + " in PeopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }
            } catch (NoResultException ex) {
                // Insert, if there are no regitries for the congrantId.
                M4ccbCvDistincPK newDistinctionPk = new M4ccbCvDistincPK();
                newDistinctionPk.setIdOrganization(ORGANIZATION_CODE);
                newDistinctionPk.setStdIdHr(this.professor.getPeopleId());
                short nextCcbOrDistinc = ((Integer) (distinctionsController.getMaxCcbOrDistinc(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
                newDistinctionPk.setCcbOrDistinc(nextCcbOrDistinc);

                M4ccbCvDistinc newDistinction = new M4ccbCvDistinc(newDistinctionPk);
                newDistinction.setCcbCargueAct(awardId);
                newDistinction = processDistinction(newDistinction, awardNode);
                try {
                    logger.info("Trying to insert " + this.entitie + " with id " + awardId);
                    distinctionsController.create(newDistinction);
                    logger.info(this.entitie + " with id " + awardId + " successfully inserted");
                } catch (PreexistingEntityException ex1) {
                    logger.error("The dsl " + awardId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }
            } catch (NonUniqueResultException ex2) {
                if (awardId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + awardId + "in the PeopleNet system table " + M4ccbCvDistinc.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvDistinc.class.getName(), ex2);
                }
            }
        }
    }

    private M4ccbCvDistinc processDistinction(M4ccbCvDistinc distinction, Element awardNode) {
        
        String distinctionDescription = DocumentProcessor.getTagValue("DESC", awardNode);
        if (distinctionDescription != null && !distinctionDescription.equals("")) {
            /**
             * FIXME: Trunc in 254 because that is the lenght of the field in PeopleNet system
             * replace after to 1000.             
             */
            if(distinctionDescription.length()>254){
                distinction.setCcbDescripDist(distinctionDescription.substring(0, 253));
            }else{
                distinction.setCcbDescripDist(distinctionDescription);
            }
        }

        String distinctionOrganization = DocumentProcessor.getTagValue("ORG", awardNode);
        if (distinctionOrganization != null && !distinctionOrganization.equals("")) {
            distinction.setCcbEntidad(distinctionOrganization);
        }

        String dtdDate = DocumentProcessor.getTagValue("DTD_DATE", awardNode);
        String dtmDate = DocumentProcessor.getTagValue("DTM_DATE", awardNode);
        String dtyDate = DocumentProcessor.getTagValue("DTY_DATE", awardNode);
        if (dtdDate != null && !dtdDate.equalsIgnoreCase("")
                && dtmDate != null && !dtmDate.equalsIgnoreCase("")
                && dtyDate != null && !dtyDate.equalsIgnoreCase("")) {
            distinction.setCcbFechaRecep(DateFormats.fullStringToDate(dtdDate + "/" + dtmDate + "/" + dtyDate));
        }

        String distinctionScope = DocumentProcessor.getTagValue("SCOPE", awardNode);
        if (distinctionScope != null) {
            distinctionScope = getAwardScopeCode(distinctionScope);
            distinction.setCcbIdDistincion(distinctionScope);
        }

        String distinctionScopeLocale = DocumentProcessor.getTagValue("SCOPE_LOCALE", awardNode);
        if (distinctionScopeLocale != null) {
            distinctionScopeLocale = getAwardScopelocaleCode(distinctionScopeLocale);
            if (distinctionScopeLocale != null) {
                distinction.setCcbIdAmbito(distinctionScopeLocale);
            }
        }

        String distinctionName = DocumentProcessor.getTagValue("NAME", awardNode);
        if (distinctionName != null) {
            distinction.setCcbNomDistinc(distinctionName);
        }

        distinction.setDtLastUpdate(new Date());

        return distinction;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    private String getAwardScopeCode(String awardScope) {
        String scopeCode = this.OTHER_SCOPE;
        switch (awardScope) {
            case "Leadership":
                scopeCode = this.LEADERSHIP_SCOPE;
                break;
            case "Teaching":
                scopeCode = this.TEACHING_SCOPE;
                break;
            case "Scholarship/Research":
                scopeCode = this.RESEARCH_SCOPE;
                break;
            case "Service, Community":
                scopeCode = this.COMMUNITY_SERVICE_SCOPE;
                break;
            case "Service, Professional":
                scopeCode = this.PROFESIONAL_SERVICE_SCOPE;
                break;
            case "Service, University":
                scopeCode = this.UNIVERSITY_SERVICE_SCOPE;
                break;
            default:
                scopeCode = this.OTHER_SCOPE;
        }
        return scopeCode;
    }

    private String getAwardScopelocaleCode(String awardScopelocale) {
        String scopelocaleCode = null;
        switch (awardScopelocale) {
            case "International":
                scopelocaleCode = this.INTERNATIONAL_SCOPE_LOCALE;
                break;
            case "National":
                scopelocaleCode = this.NATIONAL_SCOPE_LOCALE;
                break;
            case "Regional":
                scopelocaleCode = this.REGIONAL_SCOPE_LOCALE;
                break;
            case "State":
                scopelocaleCode = this.STATE_SCOPE_LOCALE;
                break;
            case "Local":
                scopelocaleCode = this.LOCAL_SCOPE_LOCALE;
                break;
            case "University":
                scopelocaleCode = this.UNIVERSITY_SCOPE_LOCALE;
                break;
            case "College":
                scopelocaleCode = this.COLLEGE_SCOPE_LOCALE;
                break;
            case "Department":
                scopelocaleCode = this.DEPARTMENT_SCOPE_LOCALE;
                break;
        }
        return scopelocaleCode;
    }
}
