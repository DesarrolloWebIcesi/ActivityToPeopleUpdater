/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.processors;

import co.edu.icesi.activitytopeopleupdater.peoplenet.dao.*;
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
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Ejecuta la importación de INTELLCONT, la cual permite llenar 10 tablas de
 * PeopleNet
 *
 * @author 38555240 - Blanca Gómez Muñoz
 */
public class IntellcontProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(IntellcontProcessor.class);
    private String pContype;

    public IntellcontProcessor(Professor professor, String entitie) {
        super(professor, entitie);
    }

    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo libros
     *
     * @param M4ccbCvLibro pLibro
     * @param Element pLibroNode
     * @return pLibro libro con todos los datos consumidos desde activity
     */
    public M4ccbCvLibro LlenarLibro(M4ccbCvLibro pLibro, Element pLibroNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pLibroNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pLibroNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pEditors = DocumentProcessor.getTagValue("EDITORS", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);



        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pLibro.setCcbIssnIsbn(pIsbn.substring(0, 70));
            } else {
                pLibro.setCcbIssnIsbn(pIsbn);
            }

        }

        if (pTitle != null) {
            pLibro.setCcbNomProd(pTitle);
        }

        if (pOther != null) {
            if (pOther.length() > 70) {
                pLibro.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pLibro.setCcbOtroTip(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pLibro.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pLibro.setCcbResumen(pAbstract);
            }

        }

        if (pWeb != null) {
            if (pWeb.length() > 150) {
                pLibro.setCcbUrl(pWeb.substring(0, 150));
            } else {
                pLibro.setCcbUrl(pWeb);
            }

        }

        if (pVolume != null) {
            pLibro.setCcbVolumen(pVolume);
        }

        if (pPagNum != null) {
            if (pPagNum.length() > 20) {
                pLibro.setCcbNumPag(pPagNum.substring(0, 20));
            } else {
                pLibro.setCcbNumPag(pPagNum);
            }

        }

        if ("Yes".equals(pConfidencialidad)) {
            pLibro.setCcbConfPriv("1");
        } else {
            pLibro.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pLibro.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && !pDtmPub.equalsIgnoreCase("") && pDtmPub != null && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pLibro.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("")
                && pDtmEx != null && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pLibro.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pLibro.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pLibro.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pLibro.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pLibro.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            pLibro.setCcbIdEstPub(getIdEstado(pIdestado));
        }
        if (pEditors != null) {
            pLibro.setCcbEditorial(pEditors);
        }

        if (pIssue != null) {
            if (pIssue.length() > 20) {
                pLibro.setCcbFasciculo(pIssue.substring(0, 20));
            } else {
                pLibro.setCcbFasciculo(pIssue);
            }

        }

        if ("Yes".equals(pRefereed)) {
            pLibro.setCcbEvaPares("1");
        } else {
            pLibro.setCcbEvaPares("0");
        }

        if (pCoautores != null) {
            if (pCoautores.length() > 100) {
                pLibro.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pLibro.setCcbCoautores(pCoautores);
            }

        }


        return pLibro;
    }

    /**
     * ******************************************************************************************************
     * ARTICULOS PUBLICADOS EN REVISTAS CON EVALUADOR ANÓNIMO M4CCB_CV_ART_PUB
     * *****************************************************************************************************
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo Revistas
     *
     * @param M4ccbCvArtPub pRevista
     * @param Element pRevistaNode
     * @return pRevista Revista con todos los datos consumidos desde activity
     */
    public M4ccbCvArtPub LlenarRevista(M4ccbCvArtPub pRevista, Element pRevistaNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pRevistaNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pRevistaNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pRevistaNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pRevistaNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pRevistaNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pRevistaNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pRevistaNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pRevistaNode);
        String pCoautores = getLibroCoautores(pRevistaNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pRevistaNode);

        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pRevistaNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pRevistaNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pRevistaNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pRevistaNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pRevistaNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pRevistaNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pRevistaNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pRevistaNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pRevistaNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pRevistaNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pRevistaNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pRevistaNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pRevistaNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pRevistaNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pRevistaNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pRevistaNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pRevistaNode);


        /**
         * *****************************************************************************************
         * Especificos de revista PUBLISHER
         */
        String pPublisher = DocumentProcessor.getTagValue("PUBLISHER", pRevistaNode);


        /**
         * ************************************************************************************
         */
        if (pPublisher != null) {
            if (pPublisher.length() > 1000) {
                pRevista.setCcbNomRevper(pPublisher.substring(0, 1000));
            } else {
                pRevista.setCcbNomRevper(pPublisher);
            }

        }

        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pRevista.setCcbIssnIsbn(pIsbn.substring(0, 70));
            } else {
                pRevista.setCcbIssnIsbn(pIsbn);
            }

        }


        if (pTitle != null) {
            pRevista.setCcbNomProd(pTitle);
        }


        if (pOther != null) {
            if (pOther.length() > 70) {
                pRevista.setCcbOtroTprod(pOther.substring(0, 70));
            } else {
                pRevista.setCcbOtroTprod(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pRevista.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pRevista.setCcbResumen(pAbstract);
            }

        }


        if (pWeb != null) {
            if (pWeb.length() > 150) {
                pRevista.setCcbUrl(pWeb.substring(0, 150));
            } else {
                pRevista.setCcbUrl(pWeb);
            }

        }



        if (pVolume != null) {
            pRevista.setCcbVolumen(pVolume);
        }
        if (pPagNum != null) {
            pRevista.setCcbNumPag(pPagNum);
        }

        if ("Yes".equals(pConfidencialidad)) {
            pRevista.setCcbConfidPriv("1");

        } else {
            pRevista.setCcbConfidPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("")
                && pDty != null && !pDty.equalsIgnoreCase("")) {
            pRevista.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("")
                && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && pDtyPub.equalsIgnoreCase("")) {
            pRevista.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pRevista.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pRevista.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pRevista.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pRevista.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pRevista.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            pRevista.setCcbIdEstPub(getIdEstado(pIdestado));
        }


        if (pIssue != null) {
            if (pIssue.length() > 20) {
                pRevista.setCcbFasciculo(pIssue.substring(0, 20));
            } else {
                pRevista.setCcbFasciculo(pIssue);
            }

        }
        if ("Yes".equals(pRefereed)) {
            pRevista.setCcbEvalPares("1");

        } else {
            pRevista.setCcbEvalPares("0");
        }


        if (pCoautores != null) {
            if (pCoautores.length() > 100) {
                pRevista.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pRevista.setCcbCoautores(pCoautores);
            }

        }

        pRevista.setDtLastUpdate(new Date());

        return pRevista;
    }

    /**
     * *****************************************************************************************************
     */
    /**
     * *******************************************************************************************************
     * CAPÍTULOS DE LIBRO PUBLICADO M4CCB_CV_CAP_LIB
     * ******************************************************************************************************
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo capitulos libros
     *
     * @param M4ccbCvCapLib pCapLibro
     * @param Element pCapNode
     * @return pCapLibro Capitulo libro con todos los datos consumidos desde
     * activity
     */
    public M4ccbCvCapLib LlenarLibroPublicado(M4ccbCvCapLib pCapLibro, Element pCapNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pCapNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pCapNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pCapNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pCapNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pCapNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pCapNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pCapNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pCapNode);
        String pCoautores = getLibroCoautores(pCapNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pCapNode);
        String pEditors = DocumentProcessor.getTagValue("EDITORS", pCapNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pCapNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pCapNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pCapNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pCapNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pCapNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pCapNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pCapNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pCapNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pCapNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pCapNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pCapNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pCapNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pCapNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pCapNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pCapNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pCapNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pCapNode);
        /*
         * Cap Libro y 3.4.9	Documento de trabajo - Working Papers Publicados
         */
        String pNomLibro = DocumentProcessor.getTagValue("TITLE_SECONDARY", pCapNode);



        if (pNomLibro != null) {
            if (pNomLibro.length() > 1000) {
                pCapLibro.setCcbNomLibro(pNomLibro.substring(0, 1000));
            } else {
                pCapLibro.setCcbNomLibro(pNomLibro);
            }

        }

        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pCapLibro.setCcbIssnIsbn(pIsbn.substring(0, 70));
            } else {
                pCapLibro.setCcbIssnIsbn(pIsbn);
            }

        }


        if (pTitle != null) {
            pCapLibro.setCcbNomProd(pTitle);
        }


        if (pOther != null) {
            if (pOther.length() > 70) {
                pCapLibro.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pCapLibro.setCcbOtroTip(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pCapLibro.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pCapLibro.setCcbResumen(pAbstract);
            }

        }



        if (pWeb != null) {
            if (pWeb.length() > 150) {
                pCapLibro.setCcbUrl(pWeb.substring(0, 150));
            } else {
                pCapLibro.setCcbUrl(pWeb);
            }

        }

        if (pVolume != null) {
            pCapLibro.setCcbVolumen(pVolume);
        }
        if (pPagNum != null) {
            pCapLibro.setCcbNumPag(pPagNum);
        }

        if ("Yes".equals(pConfidencialidad)) {
            pCapLibro.setCcbConfPriv("1");
        } else {
            pCapLibro.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pCapLibro.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pCapLibro.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("")
                && pDtmEx != null && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pCapLibro.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pCapLibro.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pCapLibro.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pCapLibro.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pCapLibro.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            pCapLibro.setCcbIdEstPub(getIdEstado(pIdestado));
        }
        if (pEditors != null) {
            pCapLibro.setCcbEditorial(pEditors);
        }
        if (pIssue != null) {
            if (pIssue.length() > 20) {
                pCapLibro.setCcbFasciculo(pIssue.substring(0, 20));
            } else {
                pCapLibro.setCcbFasciculo(pIssue);
            }

        }


        if ("Yes".equals(pRefereed)) {
            pCapLibro.setCcbEvaPares("1");
        } else {
            pCapLibro.setCcbEvaPares("0");
        }


        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pCapLibro.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pCapLibro.setCcbCoautores(pCoautores);
            }

        }

        return pCapLibro;
    }

    /**
     * LLENAR Software Registrado
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo capitulos software registrado
     *
     * @param M4ccbCvSoftReg pSfwReg
     * @param Element pCapNode
     * @return pSfwReg Capitulo libro con todos los datos consumidos desde
     * activity
     */
    public M4ccbCvSoftReg LlenarSoftwareRegistrad(M4ccbCvSoftReg pSfwReg, Element pCapNode) {


        String pTitle = DocumentProcessor.getTagValue("TITLE", pCapNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pCapNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pCapNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pCapNode);
        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pCapNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pCapNode);
        String pCoautores = getLibroCoautores(pCapNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pCapNode);

        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pCapNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pCapNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pCapNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pCapNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pCapNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pCapNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pCapNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pCapNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pCapNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pCapNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pCapNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pCapNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pCapNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pCapNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pCapNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pCapNode);

        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pSfwReg.setCcbContReg(pIsbn.substring(0, 70));
            } else {
                pSfwReg.setCcbContReg(pIsbn);
            }

        }

        if (pTitle != null) {
            pSfwReg.setCcbNomProd(pTitle);
        }


        if (pOther != null) {
            if (pOther.length() > 70) {
                pSfwReg.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pSfwReg.setCcbOtroTip(pOther);
            }

        }
        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pSfwReg.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pSfwReg.setCcbResumen(pAbstract);
            }

        }



        if (pWeb != null) {
            if (pWeb.length() > 150) {
                pSfwReg.setCcbUrl(pWeb.substring(0, 150));
            } else {
                pSfwReg.setCcbUrl(pWeb);
            }

        }


        if ("Yes".equals(pConfidencialidad)) {
            pSfwReg.setCcbConfPriv("1");
        } else {
            pSfwReg.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pSfwReg.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pSfwReg.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("")
                && pDtmEx != null && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pSfwReg.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pSfwReg.setCcbFechaRev(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));

        }
        if (pIdAmbito != null) {
            pSfwReg.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pSfwReg.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pSfwReg.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            pSfwReg.setCcbIdEstInves(pIdestado);
        }
        pSfwReg.setDtLastUpdate(new Date());

        if ("Yes".equals(pRefereed)) {
            pSfwReg.setCcbEvaPares("1");
        } else {
            pSfwReg.setCcbEvaPares("0");
        }


        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pSfwReg.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pSfwReg.setCcbCoautores(pCoautores);
            }

        }


        return pSfwReg;
    }

    /**
     * *****************************************************************************************************
     * Edición y revisión
     * *****************************************************************************************************
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo capitulos software registrado
     *
     * @param M4ccbCvEdicionR pEdiRev
     * @param Element pLibroNode
     * @return pEdiRev Edición y revisión con todos los datos consumidos desde
     * activity
     */
    public M4ccbCvEdicionR LlenarEdicRevision(M4ccbCvEdicionR pEdiRev, Element pLibroNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pLibroNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pLibroNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pEditors = DocumentProcessor.getTagValue("EDITORS", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);

        String pNomLibro = DocumentProcessor.getTagValue("TITLE_SECONDARY", pLibroNode);



        if (pNomLibro != null) {
            if (pNomLibro.length() > 1000) {
                pEdiRev.setCcbLibRevPub(pNomLibro.substring(0, 1000));
            } else {
                pEdiRev.setCcbLibRevPub(pNomLibro);
            }

        }


        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pEdiRev.setCcbIsbn(pIsbn.substring(0, 70));
            } else {
                pEdiRev.setCcbIsbn(pIsbn);
            }

        }

        if (pTitle != null) {
            pEdiRev.setCcbNomProd(pTitle);
        }

        if (pOther != null) {
            if (pOther.length() > 70) {
                pEdiRev.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pEdiRev.setCcbOtroTip(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pEdiRev.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pEdiRev.setCcbResumen(pAbstract);
            }

        }



        if (pWeb != null) {
            if (pWeb.length() > 70) {
                pEdiRev.setCcbUrl(pWeb.substring(0, 70));
            } else {
                pEdiRev.setCcbUrl(pWeb);
            }

        }

        if (pVolume != null) {
            pEdiRev.setCcbVolumen(pVolume);
        }
        if (pPagNum != null) {
            pEdiRev.setCcbNumPag(pPagNum);
        }

        if ("Yes".equals(pConfidencialidad)) {
            pEdiRev.setCcbConfPriv("1");
        } else {
            pEdiRev.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pEdiRev.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pEdiRev.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pEdiRev.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }



        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pEdiRev.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pEdiRev.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pEdiRev.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pEdiRev.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            //rev
            pEdiRev.setCcbIdEstPub(getIdEstado(pIdestado));
        }
        if (pEditors != null) {
            pEdiRev.setCcbEditorial(pEditors);
        }

        if (pIssue != null) {
            if (pIssue.length() > 20) {
                pEdiRev.setCcbFasciculo(pIssue.substring(0, 20));
            } else {
                pEdiRev.setCcbFasciculo(pIssue);
            }

        }

        if ("Yes".equals(pRefereed)) {
            pEdiRev.setCcbEvaPares("1");
        } else {
            pEdiRev.setCcbEvaPares("0");
        }


        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pEdiRev.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pEdiRev.setCcbCoautores(pCoautores);
            }

        }

        pEdiRev.setDtLastUpdate(new Date());
        return pEdiRev;
    }

    /**
     * ***********************************************************************************************
     * Trabajos tecnicos
     * *************************************************************************************************
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo trabajos Tecnicos
     *
     * @param M4ccbCvTrabTecn pTrabTec
     * @param Element pLibroNode
     * @return pTrabTec Trabajo tecnico con todos los datos consumidos desde
     * activity
     */
    public M4ccbCvTrabTecn LlenarTrabajosTec(M4ccbCvTrabTecn pTrabTec, Element pLibroNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pLibroNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);

        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);


        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pTrabTec.setCcbContratoReg(pIsbn.substring(0, 70));
            } else {
                pTrabTec.setCcbContratoReg(pIsbn);
            }

        }

        if (pTitle != null) {
            pTrabTec.setCcbNomProd(pTitle);
        }


        if (pOther != null) {
            if (pOther.length() > 70) {
                pTrabTec.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pTrabTec.setCcbOtroTip(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pTrabTec.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pTrabTec.setCcbResumen(pAbstract);
            }

        }



        if (pWeb != null) {
            if (pWeb.length() > 70) {
                pTrabTec.setCcbUrl(pWeb.substring(0, 70));
            } else {
                pTrabTec.setCcbUrl(pWeb);
            }

        }

        if ("Yes".equals(pConfidencialidad)) {
            pTrabTec.setCcbConfPriv("1");
        } else {
            pTrabTec.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pTrabTec.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pTrabTec.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pTrabTec.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pTrabTec.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pTrabTec.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pTrabTec.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pTrabTec.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            //rev

            pTrabTec.setCcbIdEstPub(getIdEstado(pIdestado));
        }

        if ("Yes".equals(pRefereed)) {
            pTrabTec.setCcbEvaPares("1");
        } else {
            pTrabTec.setCcbEvaPares("0");
        }

        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pTrabTec.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pTrabTec.setCcbCoautores(pCoautores);
            }

        }

        pTrabTec.setDtLastUpdate(new Date());
        return pTrabTec;
    }

    /**
     * ***********************************************************************************************
     * Documento de trabajo
     * **********************************************************************************************
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo documento trabajo
     *
     * @param M4ccbCvDocTrab pDocTrab
     * @param Element pLibroNode
     * @return pDocTrab Documento de trabajo con todos los datos consumidos
     * desde activity
     */
    public M4ccbCvDocTrab LlenarDocumenTrab(M4ccbCvDocTrab pDocTrab, Element pLibroNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pLibroNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pLibroNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pEditors = DocumentProcessor.getTagValue("EDITORS", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);

        String pNomLibro = DocumentProcessor.getTagValue("TITLE_SECONDARY", pLibroNode);

        if (pNomLibro != null) {
            if (pNomLibro.length() > 1000) {
                pDocTrab.setCcbLibRev(pNomLibro.substring(0, 1000));
            } else {
                pDocTrab.setCcbLibRev(pNomLibro);
            }

        }


        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pDocTrab.setCcbIsbn(pIsbn.substring(0, 70));
            } else {
                pDocTrab.setCcbIsbn(pIsbn);
            }

        }

        if (pTitle != null) {
            pDocTrab.setCcbNomProd(pTitle);
        }


        if (pOther != null) {
            if (pOther.length() > 70) {
                pDocTrab.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pDocTrab.setCcbOtroTip(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pDocTrab.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pDocTrab.setCcbResumen(pAbstract);
            }

        }


        if (pWeb != null) {
            if (pWeb.length() > 70) {
                pDocTrab.setCcbUrl(pWeb.substring(0, 70));
            } else {
                pDocTrab.setCcbUrl(pWeb);
            }

        }

        if (pVolume != null) {
            pDocTrab.setCcbVolumen(pVolume);
        }
        if (pPagNum != null) {
            pDocTrab.setCcbNumPag(pPagNum);
        }

        if ("Yes".equals(pConfidencialidad)) {
            pDocTrab.setCcbConfPriv("1");
        } else {
            pDocTrab.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pDocTrab.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pDocTrab.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pDocTrab.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pDocTrab.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pDocTrab.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pDocTrab.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pDocTrab.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {
            pDocTrab.setCcbIdEstPub(getIdEstado(pIdestado));
        }
        if (pEditors != null) {
            pDocTrab.setCcbEditorial(pEditors);
        }

        if (pIssue != null) {
            if (pIssue.length() > 20) {
                pDocTrab.setCcbFasciculo(pIssue.substring(0, 20));
            } else {
                pDocTrab.setCcbFasciculo(pIssue);
            }

        }

        if ("Yes".equals(pRefereed)) {
            pDocTrab.setCcbEvaPares("1");
        } else {
            pDocTrab.setCcbEvaPares("0");
        }


        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pDocTrab.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pDocTrab.setCcbCoautores(pCoautores);
            }

        }


        pDocTrab.setDtLastUpdate(new Date());
        return pDocTrab;
    }

    /**
     * *******************************************************************************************************
     * Desarrollo de Material Didáctico o de Instrucción
     * *******************************************************************************************************
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo Desarrollo de Material Didáctico o de
     * Instrucción
     *
     * @param M4ccbCvDlloMat pMatInst
     * @param Element pLibroNode
     * @return pMatInst Desarrollo de Material Didáctico o de Instrucción con
     * todos los datos consumidos desde activity
     */
    public M4ccbCvDlloMat LlenarDlloMatInst(M4ccbCvDlloMat pMatInst, Element pLibroNode) {

        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);


        if (pTitle != null) {
            if (pTitle.length() > 1000) {
                pMatInst.setCcbNomProd(pTitle.substring(0, 1000));
            } else {
                pMatInst.setCcbNomProd(pTitle);
            }

        }

        if (pOther != null) {
            if (pOther.length() > 70) {
                pMatInst.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pMatInst.setCcbOtroTip(pOther);
            }

        }
        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pMatInst.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pMatInst.setCcbResumen(pAbstract);
            }

        }



        if (pWeb != null) {
            if (pWeb.length() > 70) {
                pMatInst.setCcbUrl(pWeb.substring(0, 70));
            } else {
                pMatInst.setCcbUrl(pWeb);
            }

        }

        if ("Yes".equals(pConfidencialidad)) {
            pMatInst.setCcbConfPriv("1");
        } else {
            pMatInst.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pMatInst.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pMatInst.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pMatInst.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pMatInst.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pMatInst.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pMatInst.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null) {
            pMatInst.setCcbIdProdInt(this.getIdProdInt(pContype));

        }
        if (pIdestado != null) {

            pMatInst.setCcbIdEstPub(getIdEstado(pIdestado));
        }

        if ("Yes".equals(pRefereed)) {
            pMatInst.setCcbEvaPares("1");
        } else {
            pMatInst.setCcbEvaPares("0");
        }

        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pMatInst.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pMatInst.setCcbCoautores(pCoautores);
            }

        }

        pMatInst.setDtLastUpdate(new Date());
        return pMatInst;
    }

    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo Prefacio
     *
     * @param M4ccbCvPrefEpil pPrefacio
     * @param Element pLibroNode
     * @return pPrefacio Prefacio – Epílogo con todos los datos consumidos desde
     * activity
     */
    public M4ccbCvPrefEpil LlenarPrefacio(M4ccbCvPrefEpil pPrefacio, Element pLibroNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pLibroNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pLibroNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pEditors = DocumentProcessor.getTagValue("EDITORS", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);
        String pNomLibro = DocumentProcessor.getTagValue("TITLE_SECONDARY", pLibroNode);

        if (pNomLibro != null) {
            if (pNomLibro.length() > 1000) {
                pPrefacio.setCcbLibRevPub(pNomLibro.substring(0, 1000));
            } else {
                pPrefacio.setCcbLibRevPub(pNomLibro);
            }

        }

        if (pIsbn != null) {
            if (pIsbn.length() > 70) {
                pPrefacio.setCcbIsbn(pIsbn.substring(0, 70));
            } else {
                pPrefacio.setCcbIsbn(pIsbn);
            }

        }
        if (pTitle != null) {
            pPrefacio.setCcbNomProd(pTitle);
        }


        if (pOther != null) {
            if (pOther.length() > 70) {
                pPrefacio.setCcbOtroTip(pOther.substring(0, 70));
            } else {
                pPrefacio.setCcbOtroTip(pOther);
            }

        }

        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pPrefacio.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pPrefacio.setCcbResumen(pAbstract);
            }

        }



        if (pWeb != null) {
            if (pWeb.length() > 70) {
                pPrefacio.setCcbUrl(pWeb.substring(0, 70));
            } else {
                pPrefacio.setCcbUrl(pWeb);
            }

        }

        if (pVolume != null) {
            pPrefacio.setCcbVolumen(pVolume);
        }
        if (pPagNum != null) {
            pPrefacio.setCcbNumPag(pPagNum);
        }

        if ("Yes".equals(pConfidencialidad)) {
            pPrefacio.setCcbConfPriv("1");
        } else {
            pPrefacio.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pPrefacio.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pPrefacio.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pPrefacio.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pPrefacio.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pPrefacio.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pPrefacio.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null && "Other".equals(pContype)) {
            pPrefacio.setCcbIdProdInt("CO_99");

        }
        if (pIdestado != null) {
            pPrefacio.setCcbIdEstPub(getIdEstado(pIdestado));
        }
        if (pEditors != null) {
            pPrefacio.setCcbEditorial(pEditors);
        }

        if (pIssue != null) {
            if (pIssue.length() > 20) {
                pPrefacio.setCcbFasciculo(pIssue.substring(0, 20));
            } else {
                pPrefacio.setCcbFasciculo(pIssue);
            }

        }
        if ("Yes".equals(pRefereed)) {
            pPrefacio.setCcbEvaPares("1");
        } else {
            pPrefacio.setCcbEvaPares("0");
        }

        if (pCoautores != null && !pCoautores.equalsIgnoreCase("")) {
            if (pCoautores.length() > 100) {
                pPrefacio.setCcbCoautores(pCoautores.substring(0, 100));
            } else {
                pPrefacio.setCcbCoautores(pCoautores);
            }

        }
        

        pPrefacio.setDtLastUpdate(new Date());
        return pPrefacio;
    }

    /**
     */
    /**
     * StdHrLangTrans-TraduccionIdioma
     */
    /**
     * Asigna el valor obtenido de activity a cada campo de la tabla que guarda
     * las producciones intelectuales tipo Traducciones RH
     *
     * @param StdHrLangTrans pTraduccion
     * @param Element pLibroNode
     * @return pTraduccion Traducción Idioma RH – Epílogo con todos los datos
     * consumidos desde activity
     */
    public StdHrLangTrans LlenarTraduccion(StdHrLangTrans pTraduccion, Element pLibroNode) {

        String pIsbn = DocumentProcessor.getTagValue("ISBNISSN", pLibroNode);
        String pTitle = DocumentProcessor.getTagValue("TITLE", pLibroNode);
        String pPagNum = DocumentProcessor.getTagValue("PAGENUM", pLibroNode);
        String pOther = DocumentProcessor.getTagValue("CONTYPEOTHER", pLibroNode);
        String pAbstract = DocumentProcessor.getTagValue("ABSTRACT", pLibroNode);
        String pWeb = DocumentProcessor.getTagValue("WEB_ADDRESS", pLibroNode);
        String pVolume = DocumentProcessor.getTagValue("VOLUME", pLibroNode);
        //String pCoautores = getLibroCoautores("INTELLCONT_AUTH", pLibroNode);
        String pCoautores = getLibroCoautores(pLibroNode);
        String pConfidencialidad = DocumentProcessor.getTagValue("PUBLICAVAIL", pLibroNode);
        String pEditors = DocumentProcessor.getTagValue("EDITORS", pLibroNode);
        String pRefereed = DocumentProcessor.getTagValue("REFEREED", pLibroNode);
        String pIssue = DocumentProcessor.getTagValue("ISSUE", pLibroNode);
        String pDtm = DocumentProcessor.getTagValue("DTM_ACC", pLibroNode);
        String pDty = DocumentProcessor.getTagValue("DTY_ACC", pLibroNode);
        String pDtd = DocumentProcessor.getTagValue("DTD_PUB", pLibroNode);
        String pDtmPub = DocumentProcessor.getTagValue("DTM_PUB", pLibroNode);
        String pDtyPub = DocumentProcessor.getTagValue("DTY_PUB", pLibroNode);

        String pDtdEx = DocumentProcessor.getTagValue("DTD_EXPSUB", pLibroNode);
        String pDtmEx = DocumentProcessor.getTagValue("DTM_EXPSUB", pLibroNode);
        String pDtyEx = DocumentProcessor.getTagValue("DTY_EXPSUB", pLibroNode);

        String pDtdSub = DocumentProcessor.getTagValue("DTD_SUB", pLibroNode);
        String pDtmSub = DocumentProcessor.getTagValue("DTM_SUB", pLibroNode);
        String pDtySub = DocumentProcessor.getTagValue("DTY_SUB", pLibroNode);
        String pIdAmbito = DocumentProcessor.getTagValue("AUDIENCE", pLibroNode);
        String pIdCategoria = DocumentProcessor.getTagValue("CLASSIFICATION", pLibroNode);
        String pIdestado = DocumentProcessor.getTagValue("STATUS", pLibroNode);
        String pContype = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);
        String pNomLibro = DocumentProcessor.getTagValue("TITLE_SECONDARY", pLibroNode);

        if (pNomLibro != null) {
            pTraduccion.setCcbLibRevPub(pNomLibro);
        }
        if (pIsbn != null) {
            pTraduccion.setCcbIsbn(pIsbn);
        }
        if (pTitle != null) {
            pTraduccion.setCcbNomProd(pTitle);
        }
        if (pOther != null) {
            pTraduccion.setCcbOtroTipo(pOther);
        }
        if (pAbstract != null) {
            if (pAbstract.length() > 1000) {
                pTraduccion.setCcbResumen(pAbstract.substring(0, 1000));
            } else {
                pTraduccion.setCcbResumen(pAbstract);
            }

        }

        if (pWeb != null) {
            pTraduccion.setCcbUrl(pWeb);
        }

        if (pVolume != null) {
            pTraduccion.setCcbVolumen(pVolume);
        }
        if (pPagNum != null) {
            pTraduccion.setCcbNumPag(pPagNum);
        }

        if ("Yes".equals(pConfidencialidad)) {
            pTraduccion.setCcbConfPriv("1");
        } else {
            pTraduccion.setCcbConfPriv("0");
        }
        if (pDtm != null && !pDtm.equalsIgnoreCase("") && pDty != null && !pDty.equalsIgnoreCase("")) {
            pTraduccion.setCcbFechaAprob(DateFormats.fullStringToDate("01/" + pDtm + "/" + pDty));
        }

        if (pDtd != null && !pDtd.equalsIgnoreCase("") && pDtmPub != null && !pDtmPub.equalsIgnoreCase("")
                && pDtyPub != null && !pDtyPub.equalsIgnoreCase("")) {
            pTraduccion.setCcbFechaPub(DateFormats.fullStringToDate(pDtd + "/" + pDtmPub + "/" + pDtyPub));

        }
        if (pDtdEx != null && !pDtdEx.equalsIgnoreCase("") && pDtmEx != null
                && !pDtmEx.equalsIgnoreCase("")
                && pDtyEx != null && !pDtyEx.equalsIgnoreCase("")) {
            pTraduccion.setCcbFechaProp(DateFormats.fullStringToDate(pDtdEx + "/" + pDtmEx + "/" + pDtyEx));

        }
        if (pDtdSub != null && !pDtdSub.equalsIgnoreCase("")
                && pDtmSub != null && !pDtmSub.equalsIgnoreCase("")
                && pDtySub != null && !pDtySub.equalsIgnoreCase("")) {
            pTraduccion.setCcbFechaRevision(DateFormats.fullStringToDate(pDtdSub + "/" + pDtmSub + "/" + pDtySub));
        }
        if (pIdAmbito != null) {
            pTraduccion.setCcbIdAmbito(this.IdAmbito(pIdAmbito));
        }
        if (pIdCategoria != null) {
            pTraduccion.setCcbIdCategoria(this.IdCategoria(pIdCategoria));
        }

        if (pContype != null && "Other".equals(pContype)) {
            pTraduccion.setCcbIdProdInt("CO_99");

        }
        if (pIdestado != null) {
            pTraduccion.setCcbIdEstPub(getIdEstado(pIdestado));
        }
        if (pEditors != null) {
            pTraduccion.setCcbEditorial(pEditors);
        }
        if (pIssue != null) {
            pTraduccion.setCcbFasciculo(pIssue);
        }
        if ("Yes".equals(pRefereed)) {
            pTraduccion.setCcbEvaPares("1");
        } else {
            pTraduccion.setCcbEvaPares("0");
        }
        if (pCoautores != null) {
            pTraduccion.setCcbCoautores(pCoautores);
        }
        pTraduccion.setDtLastUpdate(new Date());
        return pTraduccion;
    }

    /**
     * ****************************************************************************************************
     */
    @Override
    protected synchronized void runProcesor() {

        M4ccbCvLibroJpaController vLibroActivitiesController = new M4ccbCvLibroJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvArtPubJpaController vrevistaActivitiesController = new M4ccbCvArtPubJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvCapLibJpaController vCapLbActivitiesController = new M4ccbCvCapLibJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvSoftRegJpaController vSoftRegActivitiesController = new M4ccbCvSoftRegJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvTrabTecnJpaController vTrabTecActivitiesController = new M4ccbCvTrabTecnJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvEdicionRJpaController vEdRActivitiesController = new M4ccbCvEdicionRJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvDocTrabJpaController vDocTrabActivitiesController = new M4ccbCvDocTrabJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvDlloMatJpaController vDocDlloActivitiesController = new M4ccbCvDlloMatJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        M4ccbCvPrefEpilJpaController vPrefEpilActivitiesController = new M4ccbCvPrefEpilJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        StdHrLangTransJpaController vTransController = new StdHrLangTransJpaController(Persistence.createEntityManagerFactory("ActivityToPeopleUpdaterPU"));
        for (int i = 0; i < this.entities.getLength(); i++) {
            int rangLb = 0;
            Element pLibroNode = (Element) this.entities.item(i);
            //String vLibroId = pLibroNode.getAttribute("id");
            String vLibroId  = pLibroNode.getAttribute("id")+":"+this.professor.getUsername();
            String vNodoType = DocumentProcessor.getTagValue("CONTYPE", pLibroNode);

            if (vNodoType != null) {
                pContype = getIdProdInt(vNodoType);
                if (pContype != null) {

                    if (("CO_08".equals(pContype)) || ("CO_09".equals(pContype)) || ("CO_10".equals(pContype)) || ("CO_11".equals(pContype)) || ("CO_12".equals(pContype)) || ("CO_13".equals(pContype))) // if(rangLb>=8 && rangLb<=13)
                    {
                        transaccionesLibro(vLibroId, pLibroNode, vLibroActivitiesController);
                    }
                    /*
                     * Revistas
                     */
                    if (("CO_18".equals(pContype)) || ("CO_19".equals(pContype)) || ("CO_20".equals(pContype)) || ("CO_21".equals(pContype)) || ("CO_22".equals(pContype)) || ("CO_23".equals(pContype))) {
                        transaccionesRevista(vLibroId, pLibroNode, vrevistaActivitiesController);

                        //revistas

                    }
                    /**
                     * ****Capitulos Libros**********
                     */
                    if (("CO_02".equals(pContype)) || ("CO_03".equals(pContype)) || ("CO_04".equals(pContype)) || ("CO_05".equals(pContype)) || ("CO_06".equals(pContype)) || ("CO_07".equals(pContype))) {
                        transaccionesCapLibros(vLibroId, pLibroNode, vCapLbActivitiesController);
                    }
                    /*
                     * Fin Capitulos libros
                     */

                    /**
                     * ********************Software
                     * Registrado*********************************************
                     */
                    if (("CO_28".equals(pContype)) || ("CO_29".equals(pContype))) {

                        transaccionesSoftReg(vLibroId, pLibroNode, vSoftRegActivitiesController);
                    }
                    /**
                     * ****************************
                     */
                    /**
                     * *********Trabajos Tecnicos*************
                     */
                    if (("CO_24".equals(pContype)) || ("CO_26".equals(pContype))) {
                        transaccionesTrabtecnico(vLibroId, pLibroNode, vTrabTecActivitiesController);

                    }
                    /**
                     * ************Edición o
                     * revisión****M4ccbCvEdicionR*************
                     */
                    if (("CO_01".equals(pContype))) {
                        transaccionesEdicionR(vLibroId, pLibroNode, vEdRActivitiesController);
                    }
                    /**
                     * ***********Documento de trabajo*************************
                     */
                    if ("CO_33".equals(pContype)) {
                        transaccionesDocTrab(vLibroId, pLibroNode, vDocTrabActivitiesController);

                    }
                    /**
                     * ********Desarrollo de Material Didáctico o de
                     * Instrucción****
                     */
                    if (("CO_14".equals(pContype)) || ("CO_17".equals(pContype)) || ("CO_25".equals(pContype)) || ("CO_30".equals(pContype)) || ("CO_31".equals(pContype)) || ("CO_34".equals(pContype))) {
                        transaccionesDlloMat(vLibroId, pLibroNode, vDocDlloActivitiesController);
                    }
                    /**
                     * ***Prefacio o epilogo**"CO_99"*
                     */
                    if ("CO_99".equals(pContype)) {
                        transaccionesPrefEpil(vLibroId, pLibroNode, vPrefEpilActivitiesController);
                    }
                    /*
                     * Traduccion RH Se comento dado que no se tiene claridad en
                     * los valores que toma los campos que forman la llave
                     * primaria
                     */
                    /*
                     * if ("CO_32".equals(pContype)) {
                     * this.transaccionesTraduccionRH(vLibroId, pLibroNode,
                     * vTransController); }
                     */
                } else {
                    logger.error("No hay tipo para comparar");
                }
            }
        }//for

    }

    /**
     * Obtiene los coautores de cada produccion Intelectual
     *
     * @param String pElementsByTagName
     * @param Element pLibroNode
     * @return vLibroString cadena en la que se encuentra los coautores
     * separados por /
     */
    private String getLibroCoautores(Element pLibroNode) {
        NodeList vLibroList = pLibroNode.getElementsByTagName("INTELLCONT_AUTH");
        String vLibroString = "";

        if (vLibroList != null && vLibroList.getLength() > 0) {
            int vLibroCount = 0;
            for (int i = 0; i < vLibroList.getLength(); i++) {
                Element vLibro = (Element) vLibroList.item(i);
                String libroFacultyName = DocumentProcessor.getTagValue("FACULTY_NAME", vLibro);

                if (libroFacultyName == null || !libroFacultyName.equalsIgnoreCase(this.professor.getDmuId())) {
                    String vFname = DocumentProcessor.getTagValue("FNAME", vLibro);
                    String vMNAME = DocumentProcessor.getTagValue("MNAME", vLibro);
                    String vLname = DocumentProcessor.getTagValue("LNAME", vLibro);
                    String vStudentLevel = DocumentProcessor.getTagValue("STUDENT_LEVEL", vLibro);

                    if (vLibroCount != 0) {
                        vLibroString += "/ ";
                    }
                    if (vFname != null) {
                        vLibroString += vFname;
                    }
                    if (vMNAME != null) {
                        vLibroString += " " + vMNAME;
                    }
                    if (vLname != null) {
                        vLibroString += " " + vLname;
                    }

                    if (vStudentLevel != null) {
                        vLibroString += " " + vStudentLevel;
                    }

                    vLibroCount++;
                }
            }
        }
        return vLibroString;
    }

    /**
     * Metodo encargado de asignar el codigo equivalente en peopleNet segun el
     * valor de tag AUDIENCE de activity
     *
     * @param pIdAmbito
     * @return String pCodSalida codigo para people
     */
    public String IdAmbito(String pIdAmbito) {
        String pCodSalida;
        switch (pIdAmbito) {

            case "International":
                pCodSalida = "SP_01";
                break;
            case "National":
                pCodSalida = "SP_02";
                break;
            case "Regional":
                pCodSalida = "SP_03";
                break;
            case "State":
                pCodSalida = "SP_04";
                break;

            case "Local":
                pCodSalida = "SP_05";
                break;
            case "University":
                pCodSalida = "SP_06";
                break;
            case "College":
                pCodSalida = "SP_07";
                break;
            case "Department":
                pCodSalida = "SP_08";
                break;

            default:
                pCodSalida = "SP_99";
                break;
        }

        return pCodSalida;


    }

    /**
     * Metodo encargado de asignar el codigo equivalente en peopleNet segun el
     * valor de tag CLASSIFICATION de activity
     *
     * @param String pIdCategoria tag de Activity
     * @return String pCodSalida codigo para people
     */
    public String IdCategoria(String pIdCategoria) {
        String pCodSalida;
        switch (pIdCategoria) {

            case "Learning and Pedagogical Research":
                pCodSalida = "IP";
                break;
            case "Contributions to Practice":
                pCodSalida = "IA";
                break;
            case "Discipline-based Scholarship":
                pCodSalida = "IC";
                break;

            default:
                pCodSalida = "OT";
                break;
        }

        return pCodSalida;


    }

    /**
     * Metodo encargado de asignar el codigo equivalente en peopleNet segun el
     * valor de tag STATUS de activity
     *
     * @param String pIdEstado tag de Activity
     * @return String pCodSalida codigo para people
     */
    public String getIdEstado(String pIdEstado) {
        String pCodSalida;
        switch (pIdEstado) {

            case "In Preparation; Not Yet Submitted":
                pCodSalida = "EP_01";
                break;
            case "Working Paper":
                pCodSalida = "EP_02";
                break;
            case "Submitted":
                pCodSalida = "EP_03";
                break;
            case "Revising to Resubmit":
                pCodSalida = "EP_04";
                break;

            case "Not Accepted":
                pCodSalida = "EP_05";
                break;
            case "Accepted":
                pCodSalida = "EP_06";
                break;
            case "Published":
                pCodSalida = "EP_07";
                break;
            default:
                pCodSalida = "EP_99";
                break;
        }

        return pCodSalida;


    }

    /**
     * Metodo encargado de asignar el codigo equivalente en peopleNet segun el
     * valor de tag CONTYPE de activity
     *
     * @param String pIdProdInt tag de Activity
     * @return String pCodSalida codigo para people
     */
    public String getIdProdInt(String pIdProdInt) {
        String pCodSalida;
        switch (pIdProdInt) {
            case "Book Review":
                pCodSalida = "CO_01";
                break;
            case "Book, Chapter in Non-Scholarly Book-New":
                pCodSalida = "CO_02";
                break;
            case "Book, Chapter in Non-Scholarly Book-Revised":
                pCodSalida = "CO_03";
                break;
            case "Book, Chapter in Scholarly Book-New":
                pCodSalida = "CO_04";
                break;
            case "Book, Chapter in Scholarly Book-Revised":
                pCodSalida = "CO_05";
                break;
            case "Book, Chapter in Textbook-New":
                pCodSalida = "CO_06";
                break;
            case "Book, Chapter in Textbook-Revised":
                pCodSalida = "CO_07";
                break;
            case "Book, Non-Scholarly-New":
                pCodSalida = "CO_08";
                break;
            case "Book, Non-Scholarly-Revised":
                pCodSalida = "CO_09";
                break;
            case "Book, Scholarly-New":
                pCodSalida = "CO_10";
                break;
            case "Book, Scholarly-Revised":
                pCodSalida = "CO_11";
                break;
            case "Book, Textbook-New":
                pCodSalida = "CO_12";
                break;
            case "Book, Textbook-Revised":
                pCodSalida = "CO_13";
                break;

            case "Broadcast Media":
                pCodSalida = "CO_14";
                break;
            case "Instructor's Manual":
                pCodSalida = "CO_17";
                break;
            case "Journal Article, Academic Journal":
                pCodSalida = "CO_18";
                break;
            case "Journal Article, In-House Journal":
                pCodSalida = "CO_19";
                break;
            case "Journal Article, Professional Journal":
                pCodSalida = "CO_20";
                break;
            case "Journal Article, Public or Trade Journal":
                pCodSalida = "CO_21";
                break;

            case "Law Review":
                pCodSalida = "CO_22";
                break;
            case "Magazine/Trade Publication":
                pCodSalida = "CO_23";
                break;
            case "Manuscript":
                pCodSalida = "CO_24";
                break;

            case "Material Regarding New Courses/Curricula":
                pCodSalida = "CO_25";
                break;

            case "Monograph/Research Report/Technical Report":
                pCodSalida = "CO_26";
                break;
            case "Software":
                pCodSalida = "CO_28";
                break;
            case "Software, Instructional":
                pCodSalida = "CO_29";
                break;

            case "Study Guide":
                pCodSalida = "CO_30";
                break;

            case "Supporting Material for Courses":
                pCodSalida = "CO_31";
                break;
            case "Translation or Transcription":
                pCodSalida = "CO_32";
                break;
            case "Trabajo Working Paper":
                pCodSalida = "CO_33";
                break;
            case "Written Case with Instructional Material":
                pCodSalida = "CO_34";
                break;
            case "Other":
                pCodSalida = "CO_99";
                break;
            default:
                pCodSalida = null;
                break;
        }

        return pCodSalida;


    }

    /**
     * transaccionesLibro Metodo que permite editar o guardar la información de
     * tipo libro
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvLibroJpaController vLibroActivitiesController controlador
     * de la entidad libro
     */
    private void transaccionesLibro(String vLibroId, Element pLibroNode, M4ccbCvLibroJpaController vLibroActivitiesController) {
        
        
        try {
            M4ccbCvLibro activity = vLibroActivitiesController.findM4ccBActLibroByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activity = this.LlenarLibro(activity, pLibroNode);
            activity.setDtLastUpdate(new Date());
            activity.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vLibroActivitiesController.edit(activity);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");

            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:libro with the id " + vLibroId + " in peopleNet database", ex);
            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {
            M4ccbCvLibroPK pLibroPk = new M4ccbCvLibroPK();
            pLibroPk.setIdOrganization(ORGANIZATION_CODE);
            pLibroPk.setStdIdHr(this.professor.getPeopleId());
            //ccbOrLibro
            short nextCcbOrActlb = ((Integer) (vLibroActivitiesController.getMaxCcbOrActLbr(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pLibroPk.setCcbOrLibro(nextCcbOrActlb);

            M4ccbCvLibro pNewlibro = new M4ccbCvLibro(pLibroPk);
            pNewlibro = LlenarLibro(pNewlibro, pLibroNode);
            pNewlibro.setDtLastUpdate(new Date());
            //modifica valor cargue
            //pNewlibro.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pNewlibro.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to insert intellcont:libro " + this.entitie + " with id " + vLibroId);
                vLibroActivitiesController.create(pNewlibro);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:libro " + vLibroId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.error("The intellcont:libro " + vLibroId + " already exist in PeopleNet database", ex1);
            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvLibro.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvLibro.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesRevista Metodo que permite editar o guardar la información
     * de tipo revista
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvArtPubJpaController vrevistaActivitiesController
     * controlador de la entidad revista (M4ccbCvArtPub)
     */
    private void transaccionesRevista(String vLibroId, Element pLibroNode, M4ccbCvArtPubJpaController vrevistaActivitiesController) {

        try {
            M4ccbCvArtPub activityRevista = vrevistaActivitiesController.findM4ccBActArtPubByCcbCargueAct(vLibroId);

            activityRevista = this.LlenarRevista(activityRevista, pLibroNode);
            //activityRevista.setCcbCargueAc(vLibroId);
            activityRevista.setCcbCargueAc(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vrevistaActivitiesController.edit(activityRevista);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");

            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:ArtPub with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {

            M4ccbCvArtPubPK pRevistaPK = new M4ccbCvArtPubPK();
            pRevistaPK.setIdOrganization(this.ORGANIZATION_CODE);
            pRevistaPK.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrRevista = ((Integer) (vrevistaActivitiesController.getMaxCcbOrActArtPub(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pRevistaPK.setCcbOrArtPub(nextCcbOrRevista);


            M4ccbCvArtPub pNewRevista = new M4ccbCvArtPub(pRevistaPK);
            pNewRevista = LlenarRevista(pNewRevista, pLibroNode);
            pNewRevista.setDtLastUpdate(new Date());
            //pNewRevista.setCcbCargueAc(vLibroId + ":" + this.professor.getUsername());
            pNewRevista.setCcbCargueAc(vLibroId);
            try {
                logger.info("Trying to insert intellcont:Revista " + this.entitie + " with id " + vLibroId);
                vrevistaActivitiesController.create(pNewRevista);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");

            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:Revista " + vLibroId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.error("The intellcont:Revista " + vLibroId + " already exist in PeopleNet database", ex1);
            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvArtPub.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvArtPub.class.getName(), ex2);
            }
        }

    }

    /**
     * transaccionesCapLibros Metodo que permite editar o guardar la información
     * de tipo Capitulo Libro
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvCapLibJpaController vCapLbActivitiesController controlador
     * de la entidad Capitulo Libro(M4ccbCvCapLib)
     */
    private void transaccionesCapLibros(String vLibroId, Element pLibroNode, M4ccbCvCapLibJpaController vCapLbActivitiesController) {
        try {
            M4ccbCvCapLib activityCapLb = vCapLbActivitiesController.findM4ccBActCapLibByCcbCargueAct(vLibroId);
            // If exist, update the registry.

            activityCapLb = this.LlenarLibroPublicado(activityCapLb, pLibroNode);
            activityCapLb.setDtLastUpdate(new Date());
            activityCapLb.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vCapLbActivitiesController.edit(activityCapLb);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:CapLib with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }

        } catch (NoResultException ex) {
            M4ccbCvCapLibPK pCapLbPK = new M4ccbCvCapLibPK();
            pCapLbPK.setIdOrganization(this.ORGANIZATION_CODE);
            pCapLbPK.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrActcp = ((Integer) (vCapLbActivitiesController.getMaxCcbOrActCapLib(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pCapLbPK.setCcbOrCapLib(nextCcbOrActcp);


            M4ccbCvCapLib pNewcaplb = new M4ccbCvCapLib(pCapLbPK);
            pNewcaplb = this.LlenarLibroPublicado(pNewcaplb, pLibroNode);
            pNewcaplb.setDtLastUpdate(new Date());
            //pNewcaplb.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pNewcaplb.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to insert intellcont:libro " + this.entitie + " with id " + vLibroId);

                vCapLbActivitiesController.create(pNewcaplb);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");

            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:CapLib " + vLibroId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.error("The intellcont:CapLib " + vLibroId + " already exist in PeopleNet database", ex1);
            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvCapLib.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvCapLib.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesSoftReg Metodo que permite editar o guardar la información
     * de tipo Software Registrado
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvSoftRegJpaController vSoftRegActivitiesController
     * controlador de la entidad Capitulo Software Registrado(M4ccbCvSoftReg)
     */
    private void transaccionesSoftReg(String vLibroId, Element pLibroNode, M4ccbCvSoftRegJpaController vSoftRegActivitiesController) {

        try {
            M4ccbCvSoftReg activitySfReg = vSoftRegActivitiesController.findM4ccBActSoftRegByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activitySfReg = this.LlenarSoftwareRegistrad(activitySfReg, pLibroNode);
            activitySfReg.setDtLastUpdate(new Date());
            activitySfReg.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vSoftRegActivitiesController.edit(activitySfReg);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:SofwReg with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {

            M4ccbCvSoftRegPK pSfregPK = new M4ccbCvSoftRegPK();
            pSfregPK.setIdOrganization(this.ORGANIZATION_CODE);
            pSfregPK.setStdIdHr(this.professor.getPeopleId());
            short nextCcbOrActSfw = ((Integer) (vSoftRegActivitiesController.getMaxCcbOrSoftReg(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pSfregPK.setCcbOrSoftReg(nextCcbOrActSfw);

            M4ccbCvSoftReg pNewSfreg = new M4ccbCvSoftReg(pSfregPK);
            pNewSfreg = this.LlenarSoftwareRegistrad(pNewSfreg, pLibroNode);
            pNewSfreg.setDtLastUpdate(new Date());
            //pNewSfreg.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pNewSfreg.setCcbCargueAct(vLibroId);

            try {
                logger.info("Trying to insert intellcont:SoftReg " + this.entitie + " with id " + vLibroId);
                vSoftRegActivitiesController.create(pNewSfreg);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:SoftReg " + vLibroId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.error("The intellcont:SoftReg " + vLibroId + " already exist in PeopleNet database", ex1);
            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvSoftReg.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvSoftReg.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesTrabtecnico Metodo que permite editar o guardar la
     * información de tipo Trabajos tecnicos
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvTrabTecnJpaController vTrabTecActivitiesController
     * controlador de la entidad Trabajos tecnicos(M4ccbCvTrabTecn)
     */
    private void transaccionesTrabtecnico(String vLibroId, Element pLibroNode, M4ccbCvTrabTecnJpaController vTrabTecActivitiesController) {
        
        try {
            M4ccbCvTrabTecn activityTrbTec = vTrabTecActivitiesController.findM4ccBActTrabTecnByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activityTrbTec = this.LlenarTrabajosTec(activityTrbTec, pLibroNode);
            activityTrbTec.setDtLastUpdate(new Date());
            activityTrbTec.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vTrabTecActivitiesController.edit(activityTrbTec);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:TrabTecn with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {
            M4ccbCvTrabTecnPK pTrabatecPK = new M4ccbCvTrabTecnPK();
            pTrabatecPK.setIdOrganization(this.ORGANIZATION_CODE);
            pTrabatecPK.setStdIdHr(this.professor.getPeopleId());
            //Poner lo del maximo

            short nextCcbOrActSfw = ((Integer) (vTrabTecActivitiesController.getMaxCcbOrTrabTecn(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pTrabatecPK.setCcbOrTrabTec(nextCcbOrActSfw);
            M4ccbCvTrabTecn pTrabTecn = new M4ccbCvTrabTecn(pTrabatecPK);
            pTrabTecn = this.LlenarTrabajosTec(pTrabTecn, pLibroNode);
            pTrabTecn.setDtLastUpdate(new Date());
            //pTrabTecn.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pTrabTecn.setCcbCargueAct(vLibroId);
            try {
                vTrabTecActivitiesController.create(pTrabTecn);
            } catch (PreexistingEntityException ex1) {
                logger.error("The " + this.entitie + " " + vLibroId + ":" + this.professor.getUsername() + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.fatal(null, ex1);
            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvTrabTecn.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvTrabTecn.class.getName(), ex2);
            }
        }

    }

    /**
     * transaccionesEdicionR Metodo que permite editar o guardar la información
     * de tipo Edicion o Revisión
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvEdicionRJpaController vEdRActivitiesController controlador
     * de la entidad Edición Revista(M4ccbCvEdicionR)
     */
    private void transaccionesEdicionR(String vLibroId, Element pLibroNode, M4ccbCvEdicionRJpaController vEdRActivitiesController) {

        try {
            M4ccbCvEdicionR activityEdR = vEdRActivitiesController.findM4ccBActEdicionRByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activityEdR = this.LlenarEdicRevision(activityEdR, pLibroNode);
            activityEdR.setDtLastUpdate(new Date());
            activityEdR.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vEdRActivitiesController.edit(activityEdR);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:EdicionR with the id " + vLibroId + " in peopleNet database", ex);
            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {
            M4ccbCvEdicionRPK pEdrevPK = new M4ccbCvEdicionRPK();
            pEdrevPK.setIdOrganization(this.ORGANIZATION_CODE);
            pEdrevPK.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrActEdrev = ((Integer) (vEdRActivitiesController.getMaxCcbOrEdicionR(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pEdrevPK.setCcbOrEdicRev(nextCcbOrActEdrev);

            M4ccbCvEdicionR pNewEdRev = new M4ccbCvEdicionR(pEdrevPK);
            pNewEdRev = this.LlenarEdicRevision(pNewEdRev, pLibroNode);
            pNewEdRev.setDtLastUpdate(new Date());
            //pNewEdRev.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pNewEdRev.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to insert intellcont:EdicionR " + this.entitie + " with id " + vLibroId);
                vEdRActivitiesController.create(pNewEdRev);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:CvEdicionR " + vLibroId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.error("The intellcont:CvEdicionR " + vLibroId + " already exist in PeopleNet database", ex1);
            }

        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvEdicionR.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvEdicionR.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesDocTrab Metodo que permite editar o guardar la información
     * de tipo Edicion o Revisión
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvEdicionRJpaController vEdRActivitiesController controlador
     * de la entidad Edición Revista(M4ccbCvEdicionR)
     */
    private void transaccionesDocTrab(String vLibroId, Element pLibroNode, M4ccbCvDocTrabJpaController vDocTrabActivitiesController) {

        try {
            M4ccbCvDocTrab activityDoct = vDocTrabActivitiesController.findM4ccBActDocTrabByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activityDoct = this.LlenarDocumenTrab(activityDoct, pLibroNode);
            activityDoct.setDtLastUpdate(new Date());
            activityDoct.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vDocTrabActivitiesController.edit(activityDoct);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:DocTrb with the id " + vLibroId + " in peopleNet database", ex);
            } catch (Exception ex) {
                logger.fatal(null, ex);
            }


        } catch (NoResultException ex) {
            M4ccbCvDocTrabPK pDocTrbPK = new M4ccbCvDocTrabPK();
            pDocTrbPK.setIdOrganization(this.ORGANIZATION_CODE);
            pDocTrbPK.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrActDoct = ((Integer) (vDocTrabActivitiesController.getMaxCcbOrDocTrab(this.professor.getPeopleId(), this.ORGANIZATION_CODE) + 1)).shortValue();
            pDocTrbPK.setCcbOrDocTrab(nextCcbOrActDoct);

            M4ccbCvDocTrab pNewDocTrb = new M4ccbCvDocTrab(pDocTrbPK);
            pNewDocTrb = this.LlenarDocumenTrab(pNewDocTrb, pLibroNode);
            pNewDocTrb.setDtLastUpdate(new Date());
            //pNewDocTrb.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pNewDocTrb.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to insert intellcont:DocTrab " + this.entitie + " with id " + vLibroId);

                vDocTrabActivitiesController.create(pNewDocTrb);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");

            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:DocTrab " + vLibroId + " already exist in PeopleNet database", ex1);

            } catch (Exception ex1) {
                logger.error("The intellcont:DocTrab " + vLibroId + " already exist in PeopleNet database", ex1);

            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvDocTrab.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvDocTrab.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesDlloMat Metodo que permite editar o guardar la información
     * de tipo 3.4.10	Desarrollo de Material Didáctico o de Instrucción
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvDlloMatJpaController vDocDlloActivitiesController
     * controlador de la entidad Edición Revista(M4ccbCvEdicionR)
     */
    private void transaccionesDlloMat(String vLibroId, Element pLibroNode, M4ccbCvDlloMatJpaController vDocDlloActivitiesController) {
        try {

            M4ccbCvDlloMat activityDllo = vDocDlloActivitiesController.findM4ccBActDlloMatByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activityDllo = this.LlenarDlloMatInst(activityDllo, pLibroNode);
            activityDllo.setDtLastUpdate(new Date());
            activityDllo.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vDocDlloActivitiesController.edit(activityDllo);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:DesMat with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {

            M4ccbCvDlloMatPK pDelloMatPK = new M4ccbCvDlloMatPK();
            pDelloMatPK.setIdOrganization(this.ORGANIZATION_CODE);
            pDelloMatPK.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrActDesMat = ((Integer) (vDocDlloActivitiesController.getMaxCcbOrDelloMat(this.professor.getPeopleId(), ORGANIZATION_CODE) + 1)).shortValue();
            pDelloMatPK.setCcbOrDesMat(nextCcbOrActDesMat);

            M4ccbCvDlloMat pDelloMat = new M4ccbCvDlloMat(pDelloMatPK);
            pDelloMat = this.LlenarDlloMatInst(pDelloMat, pLibroNode);
            pDelloMat.setDtLastUpdate(new Date());
            //pDelloMat.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pDelloMat.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to insert intellcont:DlloMat " + this.entitie + " with id " + vLibroId);

                vDocDlloActivitiesController.create(pDelloMat);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:PrefEpil " + vLibroId + " already exist in PeopleNet database", ex1);
            } catch (Exception ex1) {
                logger.error("The intellcont:PrefEpil " + vLibroId + " already exist in PeopleNet database", ex1);
            }

        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvDlloMat.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvDlloMat.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesPrefEpil Metodo que permite editar o guardar la información
     * de tipo Prefacio y epilogo
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvPrefEpilJpaController vPrefEpilActivitiesController
     * controlador de la entidad Prefacio y epilogo (M4ccbCvPrefEpil)
     */
    private void transaccionesPrefEpil(String vLibroId, Element pLibroNode, M4ccbCvPrefEpilJpaController vPrefEpilActivitiesController) {

        try {
            M4ccbCvPrefEpil activityPrepil = vPrefEpilActivitiesController.findM4ccBActPrefEpilByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activityPrepil = this.LlenarPrefacio(activityPrepil, pLibroNode);
            activityPrepil.setDtLastUpdate(new Date());
            activityPrepil.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vPrefEpilActivitiesController.edit(activityPrepil);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:PrePil with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {
            M4ccbCvPrefEpilPK pPrepilMatPK = new M4ccbCvPrefEpilPK();
            pPrepilMatPK.setIdOrganization(this.ORGANIZATION_CODE);
            pPrepilMatPK.setStdIdHr(this.professor.getPeopleId());

            short nextCcbOrActDesMat = ((Integer) (vPrefEpilActivitiesController.getMaxCcbOrPrepil(this.professor.getPeopleId(), this.ORGANIZATION_CODE) + 1)).shortValue();
            pPrepilMatPK.setCcbOrPrefacio(nextCcbOrActDesMat);

            M4ccbCvPrefEpil pPrepil = new M4ccbCvPrefEpil(pPrepilMatPK);
            pPrepil = this.LlenarPrefacio(pPrepil, pLibroNode);
            pPrepil.setDtLastUpdate(new Date());
            //pPrepil.setCcbCargueAct(vLibroId + ":" + this.professor.getUsername());
            pPrepil.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to insert intellcont:PrefEpil " + this.entitie + " with id " + vLibroId);

                vPrefEpilActivitiesController.create(pPrepil);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:PrefEpil " + vLibroId + " already exist in PeopleNet database", ex1);

            } catch (Exception ex1) {
                logger.error("The intellcont:PrefEpil " + vLibroId + " already exist in PeopleNet database", ex1);

            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + M4ccbCvPrefEpil.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + M4ccbCvPrefEpil.class.getName(), ex2);
            }
        }
    }

    /**
     * transaccionesTraduccionRH Metodo que permite editar o guardar la
     * información de tipo Traducciones
     *
     * @param String vLibroId id en activity de la entidad
     * @param Element pLibroNode nodo de la entidad
     * @param M4ccbCvPrefEpilJpaController vPrefEpilActivitiesController
     * controlador de la entidad Traducciones (StdHrLangTrans)
     */
    private void transaccionesTraduccionRH(String vLibroId, Element pLibroNode, StdHrLangTransJpaController vTransController) {

        try {
            StdHrLangTrans activityTraduccion = vTransController.findM4ccBActTransLangByCcbCargueAct(vLibroId);
            // If exist, update the registry.
            activityTraduccion = this.LlenarTraduccion(activityTraduccion, pLibroNode);
            activityTraduccion.setDtLastUpdate(new Date());
            activityTraduccion.setCcbCargueAct(vLibroId);
            try {
                logger.info("Trying to edit " + this.entitie + " with id " + vLibroId);
                vTransController.edit(activityTraduccion);
                logger.info(this.entitie + " with id " + vLibroId + " successfully edited");
            } catch (NonexistentEntityException ex) {
                logger.error("There are not intellcont:Traduccion RH with the id " + vLibroId + " in peopleNet database", ex);

            } catch (Exception ex) {
                logger.fatal(null, ex);
            }
        } catch (NoResultException ex) {
            StdHrLangTransPK pTraduccionRHPK = new StdHrLangTransPK();
            pTraduccionRHPK.setIdOrganization(this.ORGANIZATION_CODE);
            pTraduccionRHPK.setStdIdHr(this.professor.getPeopleId());
            pTraduccionRHPK.setStdDtStart(new Date());

            short nextCcbOrActDesMat = ((Integer) (vTransController.getMaxCcbOrTranslang(this.professor.getPeopleId(), this.ORGANIZATION_CODE) + 1)).shortValue();
            pTraduccionRHPK.setCcbOrTraducc(nextCcbOrActDesMat);

            StdHrLangTrans pTraduccion = new StdHrLangTrans(pTraduccionRHPK);
            pTraduccion = this.LlenarTraduccion(pTraduccion, pLibroNode);
            pTraduccion.setDtLastUpdate(new Date());
            pTraduccion.setCcbCargueAct(vLibroId);

            try {
                logger.info("Trying to insert intellcont:PrefEpil " + this.entitie + " with id " + vLibroId);

                vTransController.create(pTraduccion);
                logger.info(this.entitie + " with id " + vLibroId + " successfully inserted");
            } catch (PreexistingEntityException ex1) {
                logger.error("The intellcont:PrefEpil " + vLibroId + " already exist in PeopleNet database", ex1);

            } catch (Exception ex1) {
                logger.error("The intellcont:PrefEpil " + vLibroId + " already exist in PeopleNet database", ex1);

            }
        } catch (NonUniqueResultException ex2) {
            if (vLibroId != null) {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value" + vLibroId + "in the PeopleNet system table " + StdHrLangTrans.class.getName(), ex2);
            } else {
                logger.error("There are several registries with the same CCB_CARGUE_ACT value in the PeopleNet system table " + StdHrLangTrans.class.getName(), ex2);
            }
        }

    }
}