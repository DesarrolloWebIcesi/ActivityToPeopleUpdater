/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbCvConsultJpaController;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.NonexistentEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.exceptions.PreexistingEntityException;
import co.edu.icesi.activitytopeopleupdater.peoplenet.model.*;
import co.edu.icesi.activitytopeopleupdater.util.DateFormats;
import co.edu.icesi.activitytopeopleupdater.util.DocumentProcessor;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Ejecuta la importación de CONSULT, la cual permite llenar 1 tabla de
 * PeopleNet
 *
 * @author 38555240 - Blanca Gómez Muñoz
 */
public class ConsultProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(ConsultProcessor.class);
    private Professor profesor;
    private DateFormats oFechas;
    private String pStart_Start;
    private String pStart_End;
    private String vType;
    private String vOrg;
    private String vNumhours_Yearl;
    private String vTypeother;
    private String pDesc;
    private String pComp;

    /** 
     * Constructor
     * 
     * @param professor The professor for who the processor will be run.
     * @param entitie The class of entity the processor will run.
     */
    public ConsultProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    /** Actually do the task of the processor */
    @Override
    protected synchronized void runProcesor() {

        /**
         * TODO implement the processor funtionality, you can start with
         * crossing the entities atribute
         */
        M4ccbCvConsultJpaController vConsultActivitiesController = new M4ccbCvConsultJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));

        for (int i = 0; i < this.entities.getLength(); i++) {


            Element consult = (Element) this.entities.item(i);
            String vConsultId = consult.getAttribute("id") + ":" + this.professor.getUsername();
            // String vCargCat=vConsultId+":"+professor.getUsername();  
            try {

                M4ccbCvConsult vActivitie = vConsultActivitiesController.findM4ccBActConsultByCcbCargueAct(vConsultId);

                pDesc = DocumentProcessor.getTagValue("DESC", consult);
                pComp = DocumentProcessor.getTagValue("COMP", consult);
                pStart_Start = (DocumentProcessor.getTagValue("START_START", consult));
                pStart_End = (DocumentProcessor.getTagValue("START_END", consult));
                vOrg = (DocumentProcessor.getTagValue("ORG", consult));
                vNumhours_Yearl = (DocumentProcessor.getTagValue("NUMHOURS_YEARLY", consult));
                vTypeother = (DocumentProcessor.getTagValue("TYPEOTHER", consult));



                if (pComp != null) {
                    vActivitie.setCcbCompensado("1");
                } else {
                    vActivitie.setCcbCompensado("0");
                }

                if (pDesc != null) {
                    if (pDesc.length() > 254) {
                        vActivitie.setCcbActDes(pDesc.substring(0, 254));
                    } else {
                        vActivitie.setCcbActDes(pDesc);
                    }

                }


                if (pStart_Start != null && !pStart_Start.equalsIgnoreCase("")) {
                    vActivitie.setCcbDtStart(oFechas.DeStringADate(pStart_Start));

                }
                if (pStart_End != null && !pStart_End.equalsIgnoreCase("")) {
                    vActivitie.setCcbDtEnd(oFechas.DeStringADate(pStart_End));
                }


                if (vOrg != null) {
                    if (vOrg.length() > 1000) {
                        vActivitie.setCcbEmpOrg(vOrg.substring(0, 1000));
                    } else {
                        vActivitie.setCcbEmpOrg(vOrg);
                    }

                }

                if (vType != null) {
                    vActivitie.setCcbIdConsultoria(this.idFormat(vType));
                }
                if (vNumhours_Yearl != null) {
                    vActivitie.setCcbNumHoras(vNumhours_Yearl);
                }


                if (vTypeother != null) {
                    if (vTypeother.length() > 70) {
                        vActivitie.setCcbOtroTip(vTypeother.substring(0, 70));
                    } else {
                        vActivitie.setCcbOtroTip(vTypeother);
                    }

                }


                vActivitie.setDtLastUpdate(new Date());
                //vActivitie.setCcbCargueAct(vConsultId + ":" + this.professor.getUsername());
                vActivitie.setCcbCargueAct(vConsultId);
                try {
                    logger.info("Trying to edit " + this.entitie + " with id " + vConsultId);
                    vConsultActivitiesController.edit(vActivitie);
                    logger.info(this.entitie + " with id " + vConsultId + " successfully edited");
                } catch (NonexistentEntityException ex) {
                    logger.error("There are not Consult with the id " + vConsultId + " in peopleNet database", ex);
                } catch (Exception ex) {
                    logger.fatal(null, ex);
                }

            } catch (NoResultException ex) {
                try {

                    M4ccbCvConsultPK vActivityPk = new M4ccbCvConsultPK();
                    vActivityPk.setIdOrganization(ORGANIZATION_CODE);
                    vActivityPk.setStdIdHr(this.professor.getPeopleId());
                    short nextCcbOrConsult = ((Integer) (vConsultActivitiesController.getMaxCcbOrConsult(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
                    vActivityPk.setCcbOrConsult(nextCcbOrConsult);

                    M4ccbCvConsult vActivitie = new M4ccbCvConsult(vActivityPk);

                    pDesc = (DocumentProcessor.getTagValue("DESC", consult));
                    pComp = (DocumentProcessor.getTagValue("COMP", consult));
                    //   
                    pStart_Start = DocumentProcessor.getTagValue("START_START", consult);
                    pStart_End = (DocumentProcessor.getTagValue("START_END", consult));
                    vOrg = (DocumentProcessor.getTagValue("ORG", consult));
                    vNumhours_Yearl = (DocumentProcessor.getTagValue("NUMHOURS_YEARLY", consult));
                    vTypeother = (DocumentProcessor.getTagValue("TYPEOTHER", consult));


                    if (pComp != null) {
                        vActivitie.setCcbCompensado("1");
                    } else {
                        vActivitie.setCcbCompensado("0");
                    }


                    if (pDesc != null) {
                        if (pDesc.length() > 254) {
                            vActivitie.setCcbActDes(pDesc.substring(0, 254));
                        } else {
                            vActivitie.setCcbActDes(pDesc);
                        }

                    }
                    if (pStart_Start != null && !pStart_Start.equalsIgnoreCase("")) {
                        vActivitie.setCcbDtStart(oFechas.DeStringADate(pStart_Start));
                    }
                    if (pStart_End != null && !pStart_End.equalsIgnoreCase("")) {
                        vActivitie.setCcbDtEnd(oFechas.DeStringADate(pStart_End));
                    }


                    if (vOrg != null) {
                        if (vOrg.length() > 1000) {
                            vActivitie.setCcbEmpOrg(vOrg.substring(0, 1000));
                        } else {
                            vActivitie.setCcbEmpOrg(vOrg);
                        }

                    }

                    if (vType != null) {
                        vActivitie.setCcbIdConsultoria(this.idFormat(vType));
                    }
                    if (vNumhours_Yearl != null) {
                        vActivitie.setCcbNumHoras(vNumhours_Yearl);
                    }
                    if (vTypeother != null) {
                        if (vTypeother.length() > 70) {
                            vActivitie.setCcbOtroTip(vTypeother.substring(0, 70));
                        } else {
                            vActivitie.setCcbOtroTip(vTypeother);
                        }

                    }

//                    vActivitie.getM4ccbCvConsultPK().setStdIdHr(profesor.getPeopleId());
                    vActivitie.getM4ccbCvConsultPK().setIdOrganization("0000");
                    vActivitie.setDtLastUpdate(new Date());
                    vActivitie.setCcbCargueAct(vConsultId);
                    //DD654
                    logger.info("Trying to insert " + this.entitie + " with id " + vConsultId);
                    vConsultActivitiesController.create(vActivitie);
                    logger.info(this.entitie + " with id " + vConsultId + " successfully inserted");
                } //catch
                catch (PreexistingEntityException ex1) {
                    logger.error("The Consult " + vConsultId + " already exist in PeopleNet database", ex1);
                } catch (Exception ex1) {
                    logger.fatal(null, ex1);
                }
            }//catch
            catch (NonUniqueResultException ex2) {
                if (vConsultId != null) {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vConsultId + "in the PeopleNet system table " + M4ccbCvConsult.class.getName(), ex2);
                } else {
                    logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvConsult.class.getName(), ex2);
                }

            }

        }

        /*
         * oConsultCotrol.create(oConsultModelo);
         *
         *
         */

        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    public String idFormat(String idConsults) {
        String pCodSalida;
        switch (idConsults) {

            case "Academic":
                pCodSalida = "CT_01";
                break;
            case "For Profit Organization":
                pCodSalida = "CT_02";
                break;
            case "Government":
                pCodSalida = "CT_03";
                break;
            case "Litigation":
                pCodSalida = "CT_04";
                break;

            case "Non-Governmental Organization (NGO)":
                pCodSalida = "CT_05";
                break;
            case "Other":
                pCodSalida = "CT_99";
                break;

            default:
                pCodSalida = "CT_99";
                break;
        }

        return pCodSalida;
    }
}
