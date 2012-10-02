/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 38555240
 */
@Entity
@Table(name = "M4CCB_CV_NORMA_N")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvNormaN.findAll", query = "SELECT m FROM M4ccbCvNormaN m"),
    @NamedQuery(name = "M4ccbCvNormaN.findByIdOrganization", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.m4ccbCvNormaNPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbOrNorma", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.m4ccbCvNormaNPK.ccbOrNorma = :ccbOrNorma"),
    @NamedQuery(name = "M4ccbCvNormaN.findByStdIdHr", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.m4ccbCvNormaNPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbPatente", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbPatente = :ccbPatente"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbDereAut", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbDereAut = :ccbDereAut"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbNomProd", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbCoautores", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbDispRest", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbDispRest = :ccbDispRest"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbObligatoria", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbObligatoria = :ccbObligatoria"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbOtroReg", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbOtroReg = :ccbOtroReg"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbNomReg", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbNomReg = :ccbNomReg"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbNumPag", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbEditorial", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbEntPatro", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbEntPatro = :ccbEntPatro"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbContReg", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbContReg = :ccbContReg"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbInstCert", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbInstCert = :ccbInstCert"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbListNaciones", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbListNaciones = :ccbListNaciones"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbLicPrin", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbLicPrin = :ccbLicPrin"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbPosDere", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbPosDere = :ccbPosDere"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbFechaCreacion", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbFechaCreacion = :ccbFechaCreacion"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbFechaSolicitud", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbFechaSolicitud = :ccbFechaSolicitud"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbFechaPatente", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbFechaPatente = :ccbFechaPatente"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbFechaRenov", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbFechaRenov = :ccbFechaRenov"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbFinalidad", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbFinalidad = :ccbFinalidad"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbResumen", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbUrl", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvNormaN.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbIdTNorma", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbIdTNorma = :ccbIdTNorma"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbIdRegulacion", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbIdRegulacion = :ccbIdRegulacion"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbIdNacPatent", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbIdNacPatent = :ccbIdNacPatent"),
    @NamedQuery(name = "M4ccbCvNormaN.findByStdIdCountry", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvNormaN.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvNormaN.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvNormaN.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvNormaN.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvNormaN.findByIdApprole", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvNormaN.findByIdSecuser", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvNormaN.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvNormaN m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvNormaN implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvNormaNPK m4ccbCvNormaNPK;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_PATENTE")
    private String ccbPatente;
    @Column(name = "CCB_DERE_AUT")
    private String ccbDereAut;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_DISP_REST")
    private String ccbDispRest;
    @Column(name = "CCB_OBLIGATORIA")
    private String ccbObligatoria;
    @Column(name = "CCB_OTRO_REG")
    private String ccbOtroReg;
    @Column(name = "CCB_NOM_REG")
    private String ccbNomReg;
    @Column(name = "CCB_NUM_PAG")
    private String ccbNumPag;
    @Column(name = "CCB_EDITORIAL")
    private String ccbEditorial;
    @Column(name = "CCB_ENT_PATRO")
    private String ccbEntPatro;
    @Column(name = "CCB_CONT_REG")
    private String ccbContReg;
    @Column(name = "CCB_INST_CERT")
    private String ccbInstCert;
    @Column(name = "CCB_LIST_NACIONES")
    private String ccbListNaciones;
    @Column(name = "CCB_LIC_PRIN")
    private String ccbLicPrin;
    @Column(name = "CCB_POS_DERE")
    private String ccbPosDere;
    @Column(name = "CCB_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaCreacion;
    @Column(name = "CCB_FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaSolicitud;
    @Column(name = "CCB_FECHA_APROB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaAprob;
    @Column(name = "CCB_FECHA_PATENTE")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPatente;
    @Column(name = "CCB_FECHA_RENOV")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRenov;
    @Column(name = "CCB_FINALIDAD")
    private String ccbFinalidad;
    @Column(name = "CCB_RESUMEN")
    private String ccbResumen;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_T_NORMA")
    private String ccbIdTNorma;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "CCB_ID_REGULACION")
    private String ccbIdRegulacion;
    @Column(name = "CCB_ID_NAC_PATENT")
    private String ccbIdNacPatent;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvNormaN() {
    }

    public M4ccbCvNormaN(M4ccbCvNormaNPK m4ccbCvNormaNPK) {
        this.m4ccbCvNormaNPK = m4ccbCvNormaNPK;
    }

    public M4ccbCvNormaN(String idOrganization, short ccbOrNorma, String stdIdHr) {
        this.m4ccbCvNormaNPK = new M4ccbCvNormaNPK(idOrganization, ccbOrNorma, stdIdHr);
    }

    public M4ccbCvNormaNPK getM4ccbCvNormaNPK() {
        return m4ccbCvNormaNPK;
    }

    public void setM4ccbCvNormaNPK(M4ccbCvNormaNPK m4ccbCvNormaNPK) {
        this.m4ccbCvNormaNPK = m4ccbCvNormaNPK;
    }

    public String getCcbOtraCat() {
        return ccbOtraCat;
    }

    public void setCcbOtraCat(String ccbOtraCat) {
        this.ccbOtraCat = ccbOtraCat;
    }

    public String getCcbPatente() {
        return ccbPatente;
    }

    public void setCcbPatente(String ccbPatente) {
        this.ccbPatente = ccbPatente;
    }

    public String getCcbDereAut() {
        return ccbDereAut;
    }

    public void setCcbDereAut(String ccbDereAut) {
        this.ccbDereAut = ccbDereAut;
    }

    public String getCcbOtroTip() {
        return ccbOtroTip;
    }

    public void setCcbOtroTip(String ccbOtroTip) {
        this.ccbOtroTip = ccbOtroTip;
    }

    public String getCcbNomProd() {
        return ccbNomProd;
    }

    public void setCcbNomProd(String ccbNomProd) {
        this.ccbNomProd = ccbNomProd;
    }

    public String getCcbCoautores() {
        return ccbCoautores;
    }

    public void setCcbCoautores(String ccbCoautores) {
        this.ccbCoautores = ccbCoautores;
    }

    public String getCcbDispRest() {
        return ccbDispRest;
    }

    public void setCcbDispRest(String ccbDispRest) {
        this.ccbDispRest = ccbDispRest;
    }

    public String getCcbObligatoria() {
        return ccbObligatoria;
    }

    public void setCcbObligatoria(String ccbObligatoria) {
        this.ccbObligatoria = ccbObligatoria;
    }

    public String getCcbOtroReg() {
        return ccbOtroReg;
    }

    public void setCcbOtroReg(String ccbOtroReg) {
        this.ccbOtroReg = ccbOtroReg;
    }

    public String getCcbNomReg() {
        return ccbNomReg;
    }

    public void setCcbNomReg(String ccbNomReg) {
        this.ccbNomReg = ccbNomReg;
    }

    public String getCcbNumPag() {
        return ccbNumPag;
    }

    public void setCcbNumPag(String ccbNumPag) {
        this.ccbNumPag = ccbNumPag;
    }

    public String getCcbEditorial() {
        return ccbEditorial;
    }

    public void setCcbEditorial(String ccbEditorial) {
        this.ccbEditorial = ccbEditorial;
    }

    public String getCcbEntPatro() {
        return ccbEntPatro;
    }

    public void setCcbEntPatro(String ccbEntPatro) {
        this.ccbEntPatro = ccbEntPatro;
    }

    public String getCcbContReg() {
        return ccbContReg;
    }

    public void setCcbContReg(String ccbContReg) {
        this.ccbContReg = ccbContReg;
    }

    public String getCcbInstCert() {
        return ccbInstCert;
    }

    public void setCcbInstCert(String ccbInstCert) {
        this.ccbInstCert = ccbInstCert;
    }

    public String getCcbListNaciones() {
        return ccbListNaciones;
    }

    public void setCcbListNaciones(String ccbListNaciones) {
        this.ccbListNaciones = ccbListNaciones;
    }

    public String getCcbLicPrin() {
        return ccbLicPrin;
    }

    public void setCcbLicPrin(String ccbLicPrin) {
        this.ccbLicPrin = ccbLicPrin;
    }

    public String getCcbPosDere() {
        return ccbPosDere;
    }

    public void setCcbPosDere(String ccbPosDere) {
        this.ccbPosDere = ccbPosDere;
    }

    public Date getCcbFechaCreacion() {
        return ccbFechaCreacion;
    }

    public void setCcbFechaCreacion(Date ccbFechaCreacion) {
        this.ccbFechaCreacion = ccbFechaCreacion;
    }

    public Date getCcbFechaSolicitud() {
        return ccbFechaSolicitud;
    }

    public void setCcbFechaSolicitud(Date ccbFechaSolicitud) {
        this.ccbFechaSolicitud = ccbFechaSolicitud;
    }

    public Date getCcbFechaAprob() {
        return ccbFechaAprob;
    }

    public void setCcbFechaAprob(Date ccbFechaAprob) {
        this.ccbFechaAprob = ccbFechaAprob;
    }

    public Date getCcbFechaPatente() {
        return ccbFechaPatente;
    }

    public void setCcbFechaPatente(Date ccbFechaPatente) {
        this.ccbFechaPatente = ccbFechaPatente;
    }

    public Date getCcbFechaRenov() {
        return ccbFechaRenov;
    }

    public void setCcbFechaRenov(Date ccbFechaRenov) {
        this.ccbFechaRenov = ccbFechaRenov;
    }

    public String getCcbFinalidad() {
        return ccbFinalidad;
    }

    public void setCcbFinalidad(String ccbFinalidad) {
        this.ccbFinalidad = ccbFinalidad;
    }

    public String getCcbResumen() {
        return ccbResumen;
    }

    public void setCcbResumen(String ccbResumen) {
        this.ccbResumen = ccbResumen;
    }

    public String getCcbUrl() {
        return ccbUrl;
    }

    public void setCcbUrl(String ccbUrl) {
        this.ccbUrl = ccbUrl;
    }

    public String getCcbIdValPares() {
        return ccbIdValPares;
    }

    public void setCcbIdValPares(String ccbIdValPares) {
        this.ccbIdValPares = ccbIdValPares;
    }

    public String getCcbIdCategoria() {
        return ccbIdCategoria;
    }

    public void setCcbIdCategoria(String ccbIdCategoria) {
        this.ccbIdCategoria = ccbIdCategoria;
    }

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
    }

    public String getCcbIdTNorma() {
        return ccbIdTNorma;
    }

    public void setCcbIdTNorma(String ccbIdTNorma) {
        this.ccbIdTNorma = ccbIdTNorma;
    }

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
    }

    public String getCcbIdRegulacion() {
        return ccbIdRegulacion;
    }

    public void setCcbIdRegulacion(String ccbIdRegulacion) {
        this.ccbIdRegulacion = ccbIdRegulacion;
    }

    public String getCcbIdNacPatent() {
        return ccbIdNacPatent;
    }

    public void setCcbIdNacPatent(String ccbIdNacPatent) {
        this.ccbIdNacPatent = ccbIdNacPatent;
    }

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
    }

    public String getStdIdGeoDiv() {
        return stdIdGeoDiv;
    }

    public void setStdIdGeoDiv(String stdIdGeoDiv) {
        this.stdIdGeoDiv = stdIdGeoDiv;
    }

    public String getStdIdSubGeoDiv() {
        return stdIdSubGeoDiv;
    }

    public void setStdIdSubGeoDiv(String stdIdSubGeoDiv) {
        this.stdIdSubGeoDiv = stdIdSubGeoDiv;
    }

    public String getStdIdGeoPlace() {
        return stdIdGeoPlace;
    }

    public void setStdIdGeoPlace(String stdIdGeoPlace) {
        this.stdIdGeoPlace = stdIdGeoPlace;
    }

    public String getCcbCargueAct() {
        return ccbCargueAct;
    }

    public void setCcbCargueAct(String ccbCargueAct) {
        this.ccbCargueAct = ccbCargueAct;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4ccbCvNormaNPK != null ? m4ccbCvNormaNPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvNormaN)) {
            return false;
        }
        M4ccbCvNormaN other = (M4ccbCvNormaN) object;
        if ((this.m4ccbCvNormaNPK == null && other.m4ccbCvNormaNPK != null) || (this.m4ccbCvNormaNPK != null && !this.m4ccbCvNormaNPK.equals(other.m4ccbCvNormaNPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvNormaN[ m4ccbCvNormaNPK=" + m4ccbCvNormaNPK + " ]";
    }
    
}
