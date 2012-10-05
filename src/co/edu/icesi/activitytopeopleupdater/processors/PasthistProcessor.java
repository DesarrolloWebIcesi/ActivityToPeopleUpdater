/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvExpDocJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.StdHrLangTransJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.Professor;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrPrevJobs;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrPrevJobsPK;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.StdHrPrevJobsJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.util.DateFormats;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.*;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;

/**
 * Ejecuta la importación de PASTHIST, la cual permite llenar 2 tablas de
 * PeopleNet
 *
 * @author 38555240 - Blanca Gómez Muñoz
 */
public class PasthistProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(PasthistProcessor.class);

    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public PasthistProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {

        StdHrPrevJobsJpaController vPrevJobsController = new StdHrPrevJobsJpaController(this.EMF);
        M4ccbCvExpDocJpaController vExpDocController = new M4ccbCvExpDocJpaController(this.EMF);
        for (int i = 0; i < this.entities.getLength(); i++) {
            Element jobsNode = (Element) this.entities.item(i);
            String jobsId = jobsNode.getAttribute("id")+ ":" + this.professor.getUsername();
            //First verify if the activitie exist
            String vNodoExpType = DocumentProcessor.getTagValue("EXPTYPE", jobsNode);
            if (vNodoExpType != null) {
                if (("Academic - Post-Secondary".equals(vNodoExpType))) {
                    // 4.1 para experiencia docente
                    this.transaccionesExpDoc(jobsId, jobsNode, vExpDocController);
                }
                if ("Academic - P-12".equals(vNodoExpType) || "Professional".equals(vNodoExpType) || "Military".equals(vNodoExpType) || "Government".equals(vNodoExpType)) {
                    //5.1. experiencia profesional  
                    this.transaccionesPrevJobs(jobsId, jobsNode, vPrevJobsController);
                }
            }
        }
    }
    /*
     *
     */

    /**
     * processPrevJobs Asigna el valor obtenido de activity a cada campo de la
     * tabla que guarda la Experiencia Profesional
     *
     * @param StdHrPrevJobs activityJobs
     * @param Element jobsNode
     * @return activityJobs Entidad Experiencia profesional con todos los datos
     * consumidos desde activity
     */
    private StdHrPrevJobs processPrevJobs(StdHrPrevJobs activityJobs, Element jobsNode) {
        String pOwnComp = DocumentProcessor.getTagValue("OWN_COMPANY", jobsNode);
        String pDesc = DocumentProcessor.getTagValue("DESC", jobsNode);
        String pDtdstart = DocumentProcessor.getTagValue("DTD_START", jobsNode);
        String pDtmstart = DocumentProcessor.getTagValue("DTM_START", jobsNode);
        String pDtystart = DocumentProcessor.getTagValue("DTY_START", jobsNode);

        String pDtdend = DocumentProcessor.getTagValue("DTD_END", jobsNode);
        String pDtmend = DocumentProcessor.getTagValue("DTM_END", jobsNode);
        String pDtyend = DocumentProcessor.getTagValue("DTY_END", jobsNode);

        String pOrg = DocumentProcessor.getTagValue("ORG", jobsNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", jobsNode);
        activityJobs.setDtLastUpdate(new Date());

        if ("Yes".equals(pOwnComp) && pOwnComp != null) {
            activityJobs.setCcbEmpProp("1");
        } else {
            activityJobs.setCcbEmpProp("0");
        }

        if (pDesc != null) {
            if (pDesc.length() > 254) {
                activityJobs.setScoComment(pDesc.substring(0, 254));
            } else {
                activityJobs.setScoComment(pDesc);
            }

        }


        if (pDtdstart != null && !pDtdstart.equalsIgnoreCase("") && pDtmstart != null && !pDtmstart.equalsIgnoreCase("")
                && pDtystart != null && !pDtystart.equalsIgnoreCase("")) {
            activityJobs.setStdDtStart(DateFormats.fullStringToDate(pDtdstart + "/" + pDtmstart + "/" + pDtystart));

        }

        if (pDtdend != null && !pDtdend.equalsIgnoreCase("") && pDtmend != null && !pDtmend.equalsIgnoreCase("")
                && pDtyend != null && !pDtyend.equalsIgnoreCase("")) {
            activityJobs.setStdDtEnd(DateFormats.fullStringToDate(pDtdend + "/" + pDtmend + "/" + pDtyend));
        }


        if (pOrg != null) {
            if (pOrg.length() > 1000) {
                activityJobs.setStdEmployer(pOrg.substring(0, 1000));
            } else {
                activityJobs.setStdEmployer(pOrg);
            }

        }


        if (pTitle != null) {
            if (pTitle.length() > 62) {
                activityJobs.setStdFinalJob(pTitle.substring(0, 62));
            } else {
                activityJobs.setStdFinalJob(pTitle);
            }

        }

        activityJobs.setDtLastUpdate(new Date());

        return activityJobs;
    }

    /**
     * Experiencia Docente
     */
    /**
     * processExpDoc Asigna el valor obtenido de activity a cada campo de la
     * tabla que guarda la Experiencia Docente
     *
     * @param M4ccbCvExpDoc activityExpDoc
     * @param Element jobsNode
     * @return activityExpDoc Entidad Experiencia Docente con todos los datos
     * consumidos desde activity
     */
    private M4ccbCvExpDoc processExpDoc(M4ccbCvExpDoc activityExpDoc, Element expDocNode) {
        String pOwnComp = DocumentProcessor.getTagValue("OWN_COMPANY", expDocNode);
        String pDesc = DocumentProcessor.getTagValue("DESC", expDocNode);
        String pDtdstart = DocumentProcessor.getTagValue("DTD_START", expDocNode);
        String pDtmstart = DocumentProcessor.getTagValue("DTM_START", expDocNode);
        String pDtystart = DocumentProcessor.getTagValue("DTY_START", expDocNode);

        String pDtdend = DocumentProcessor.getTagValue("DTD_END", expDocNode);
        String pDtmend = DocumentProcessor.getTagValue("DTM_END", expDocNode);
        String pDtyend = DocumentProcessor.getTagValue("DTY_END", expDocNode);

        String pOrg = DocumentProcessor.getTagValue("ORG", expDocNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", expDocNode);
        activityExpDoc.setDtLastUpdate(new Date());

        if (pDesc != null) {
            if (pDesc.length() > 254) {
                activityExpDoc.setCcbDescripAct(pDesc.substring(0, 254));
            } else {
                activityExpDoc.setCcbDescripAct(pDesc);
            }

        }

        if (pTitle != null) {
            if (pTitle.length() > 1000) {
                activityExpDoc.setCcbActivCarg(pTitle.substring(0, 1000));
            } else {
                activityExpDoc.setCcbActivCarg(pTitle);
            }

        }

        
          if (pOrg != null) {
            if (pOrg.length() > 1000) {
                activityExpDoc.setCcbFacultad(pOrg.substring(0, 1000));
            } else {
                activityExpDoc.setCcbFacultad(pOrg);
            }

        }



        if (pDtdstart != null && !pDtdstart.equalsIgnoreCase("") && pDtmstart != null && !pDtmstart.equalsIgnoreCase("")
                && pDtystart != null && !pDtystart.equalsIgnoreCase("")) {
            activityExpDoc.setDtStart(DateFormats.fullStringToDate(pDtdstart + "/" + pDtmstart + "/" + pDtystart));

        }

        if (pDtdend != null && !pDtdend.equalsIgnoreCase("") && pDtmend != null && !pDtmend.equalsIgnoreCase("")
                && pDtyend != null && !pDtyend.equalsIgnoreCase("")) {
            activityExpDoc.setDtEnd(DateFormats.fullStringToDate(pDtdend + "/" + pDtmend + "/" + pDtyend));
        }
        /*
         * if (pOrg != null) { activityExpDoc.setScoIdEducCenter(pOrg); }
         */
        activityExpDoc.setDtLastUpdate(new Date());

        return activityExpDoc;
    }

    /**
     * transaccionesPrevJobs Metodo que permite editar o guardar la información
     * de tipo Experiencia Profesional tomado de la entidad Pasthist
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param StdHrPrevJobsJpaController vPrevJobsController controlador de la
     * entidad Experiencia Profesional (StdHrPrevJobs)
     */
    private void transaccionesPrevJobs(String vPrevJobsId, Element pPrevJobsNode, StdHrPrevJobsJpaController vPrevJobsController) {
        try {

            StdHrPrevJobs activity = vPrevJobsController.findM4ccBActPrevJobsByCcbCargueAct(vPrevJobsId);
            // If exist, update the registry.
            activity = processPrevJobs(activity, pPrevJobsNode);
            activity.setDtLastUpdate(new Date());
            activity.setCcbCargueAct(vPrevJobsId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vPrevJobsId);
                vPrevJobsController.edit(activity);
                logger.info(this.entitie + " with id " + vPrevJobsId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not investigation activities with the id " + vPrevJobsId + " in peopleNet database", ex);
            } catch (Exception ex) {
                logger.fatal(null, ex);
            }

        } catch (NoResultException ex) {
            // Insert, if there are no regitries for the congrantId.
            StdHrPrevJobsPK newActivityPk = new StdHrPrevJobsPK();
            newActivityPk.setIdOrganization(ORGANIZATION_CODE);
            newActivityPk.setStdIdHr(this.professor.getPeopleId());
            short nextCcbOrActInv = ((Integer) (vPrevJobsController.getMaxCcbOrPrevJobs(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            newActivityPk.setStdOrProfBackg(nextCcbOrActInv);

            StdHrPrevJobs newActivity = new StdHrPrevJobs(newActivityPk);
            //newActivity.setCcbCargueAct(vPrevJobsId + ":" + this.professor.getUsername());
            newActivity.setCcbCargueAct(vPrevJobsId);
            newActivity = processPrevJobs(newActivity, pPrevJobsNode);
            try {
                logger.info("Trying to insert " + this.entitie + " with id " + vPrevJobsId);
                vPrevJobsController.create(newActivity);
                logger.info("PrevJobs" + this.entitie + " with id " + vPrevJobsId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The psthist " + vPrevJobsId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.fatal(null, ex1);
            }

        } catch (NonUniqueResultException ex2) {
            if (vPrevJobsId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vPrevJobsId + "in the PeopleNet system table " + StdHrPrevJobs.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + StdHrPrevJobs.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesExpDoc Metodo que permite editar o guardar la información de
     * tipo Experiencia Docente tomado de la entidad Pasthist
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvExpDocJpaController vExpDocController controlador de la
     * entidad Experiencia Docente (M4ccbCvExpDoc)
     */
    private void transaccionesExpDoc(String vExpDocId, Element pExpDocNode, M4ccbCvExpDocJpaController vExpDocController) {
        try {

            M4ccbCvExpDoc activityExpDoc = vExpDocController.findM4ccBActExpDocByCcbCargueAct(vExpDocId);
            // If exist, update the registry.
            activityExpDoc = processExpDoc(activityExpDoc, pExpDocNode);
            activityExpDoc.setDtLastUpdate(new Date());
            activityExpDoc.setCcbCargueAct(vExpDocId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vExpDocId);
                vExpDocController.edit(activityExpDoc);
                logger.info(this.entitie + " with id " + vExpDocId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not investigation activities with the id " + vExpDocId + " in peopleNet database", ex);
            } catch (Exception ex) {
                logger.fatal(null, ex);
            }

        } catch (NoResultException ex) {
            // Insert, if there are no regitries for the congrantId.
            M4ccbCvExpDocPK newActivityPkExpDoc = new M4ccbCvExpDocPK();
            newActivityPkExpDoc.setIdOrganization(ORGANIZATION_CODE);
            newActivityPkExpDoc.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrActInv = ((Integer) (vExpDocController.getMaxCcbOrExpDoc(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            newActivityPkExpDoc.setCcbOrExpDoc(nextCcbOrActInv);

            M4ccbCvExpDoc newActivityExpDoc = new M4ccbCvExpDoc(newActivityPkExpDoc);
            //newActivityExpDoc.setCcbCargueAct(vExpDocId + ":" + this.professor.getUsername());
            newActivityExpDoc.setCcbCargueAct(vExpDocId);
            newActivityExpDoc = processExpDoc(newActivityExpDoc, pExpDocNode);
            try {
                logger.info("Trying to insert " + this.entitie + " with id " + vExpDocId);
                vExpDocController.create(newActivityExpDoc);
                logger.info("ExpDoc" + this.entitie + " with id " + vExpDocId + " successfully inserted ");
            } catch (PreexistingEntityException ex1) {
                logger.error("The psthist:ExpDoc " + vExpDocId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.fatal(null, ex1);
            }

        } catch (NonUniqueResultException ex2) {
            if (vExpDocId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vExpDocId + "in the PeopleNet system table " + M4ccbCvExpDoc.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvExpDoc.class.getName(), ex2);
            }
        }
    }
}
