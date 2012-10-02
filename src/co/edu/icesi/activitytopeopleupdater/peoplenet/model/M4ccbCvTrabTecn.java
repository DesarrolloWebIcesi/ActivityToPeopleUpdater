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
@Table(name = "M4CCB_CV_TRAB_TECN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvTrabTecn.findAll", query = "SELECT m FROM M4ccbCvTrabTecn m"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByIdOrganization", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.m4ccbCvTrabTecnPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbOrTrabTec", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.m4ccbCvTrabTecnPK.ccbOrTrabTec = :ccbOrTrabTec"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByStdIdHr", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.m4ccbCvTrabTecnPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbOtroTipTrab", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbOtroTipTrab = :ccbOtroTipTrab"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbNomProd", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbCoautores", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCbbEntPatr", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.cbbEntPatr = :cbbEntPatr"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbContratoReg", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbContratoReg = :ccbContratoReg"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbInstCert", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbInstCert = :ccbInstCert"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbDispRest", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbDispRest = :ccbDispRest"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbFinalidad", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbFinalidad = :ccbFinalidad"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbResumen", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbUrl", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbIdTrabTec", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbIdTrabTec = :ccbIdTrabTec"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByStdIdCountry", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByIdApprole", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByIdSecuser", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvTrabTecn.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvTrabTecn m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvTrabTecn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvTrabTecnPK m4ccbCvTrabTecnPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_TIP_TRAB")
    private String ccbOtroTipTrab;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CBB_ENT_PATR")
    private String cbbEntPatr;
    @Column(name = "CCB_CONTRATO_REG")
    private String ccbContratoReg;
    @Column(name = "CCB_INST_CERT")
    private String ccbInstCert;
    @Column(name = "CCB_EVA_PARES")
    private String ccbEvaPares;
    @Column(name = "CCB_CONF_PRIV")
    private String ccbConfPriv;
    @Column(name = "CCB_DISP_REST")
    private String ccbDispRest;
    @Column(name = "CCB_FECHA_PROP")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaProp;
    @Column(name = "CCB_FECHA_REVISION")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRevision;
    @Column(name = "CCB_FECHA_APROB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaAprob;
    @Column(name = "CCB_FECHA_PUB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPub;
    @Column(name = "CCB_FINALIDAD")
    private String ccbFinalidad;
    @Column(name = "CCB_RESUMEN")
    private String ccbResumen;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_PROD_INT")
    private String ccbIdProdInt;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_TRAB_TEC")
    private String ccbIdTrabTec;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "CCB_ID_EST_PUB")
    private String ccbIdEstPub;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvTrabTecn() {
    }

    public M4ccbCvTrabTecn(M4ccbCvTrabTecnPK m4ccbCvTrabTecnPK) {
        this.m4ccbCvTrabTecnPK = m4ccbCvTrabTecnPK;
    }

    public M4ccbCvTrabTecn(String idOrganization, short ccbOrTrabTec, String stdIdHr) {
        this.m4ccbCvTrabTecnPK = new M4ccbCvTrabTecnPK(idOrganization, ccbOrTrabTec, stdIdHr);
    }

    public M4ccbCvTrabTecnPK getM4ccbCvTrabTecnPK() {
        return m4ccbCvTrabTecnPK;
    }

    public void setM4ccbCvTrabTecnPK(M4ccbCvTrabTecnPK m4ccbCvTrabTecnPK) {
        this.m4ccbCvTrabTecnPK = m4ccbCvTrabTecnPK;
    }

    public String getCcbOtroTip() {
        return ccbOtroTip;
    }

    public void setCcbOtroTip(String ccbOtroTip) {
        this.ccbOtroTip = ccbOtroTip;
    }

    public String getCcbOtraCat() {
        return ccbOtraCat;
    }

    public void setCcbOtraCat(String ccbOtraCat) {
        this.ccbOtraCat = ccbOtraCat;
    }

    public String getCcbOtroTipTrab() {
        return ccbOtroTipTrab;
    }

    public void setCcbOtroTipTrab(String ccbOtroTipTrab) {
        this.ccbOtroTipTrab = ccbOtroTipTrab;
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

    public String getCbbEntPatr() {
        return cbbEntPatr;
    }

    public void setCbbEntPatr(String cbbEntPatr) {
        this.cbbEntPatr = cbbEntPatr;
    }

    public String getCcbContratoReg() {
        return ccbContratoReg;
    }

    public void setCcbContratoReg(String ccbContratoReg) {
        this.ccbContratoReg = ccbContratoReg;
    }

    public String getCcbInstCert() {
        return ccbInstCert;
    }

    public void setCcbInstCert(String ccbInstCert) {
        this.ccbInstCert = ccbInstCert;
    }

    public String getCcbEvaPares() {
        return ccbEvaPares;
    }

    public void setCcbEvaPares(String ccbEvaPares) {
        this.ccbEvaPares = ccbEvaPares;
    }

    public String getCcbConfPriv() {
        return ccbConfPriv;
    }

    public void setCcbConfPriv(String ccbConfPriv) {
        this.ccbConfPriv = ccbConfPriv;
    }

    public String getCcbDispRest() {
        return ccbDispRest;
    }

    public void setCcbDispRest(String ccbDispRest) {
        this.ccbDispRest = ccbDispRest;
    }

    public Date getCcbFechaProp() {
        return ccbFechaProp;
    }

    public void setCcbFechaProp(Date ccbFechaProp) {
        this.ccbFechaProp = ccbFechaProp;
    }

    public Date getCcbFechaRevision() {
        return ccbFechaRevision;
    }

    public void setCcbFechaRevision(Date ccbFechaRevision) {
        this.ccbFechaRevision = ccbFechaRevision;
    }

    public Date getCcbFechaAprob() {
        return ccbFechaAprob;
    }

    public void setCcbFechaAprob(Date ccbFechaAprob) {
        this.ccbFechaAprob = ccbFechaAprob;
    }

    public Date getCcbFechaPub() {
        return ccbFechaPub;
    }

    public void setCcbFechaPub(Date ccbFechaPub) {
        this.ccbFechaPub = ccbFechaPub;
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

    public String getCcbIdProdInt() {
        return ccbIdProdInt;
    }

    public void setCcbIdProdInt(String ccbIdProdInt) {
        this.ccbIdProdInt = ccbIdProdInt;
    }

    public String getCcbIdCategoria() {
        return ccbIdCategoria;
    }

    public void setCcbIdCategoria(String ccbIdCategoria) {
        this.ccbIdCategoria = ccbIdCategoria;
    }

    public String getCcbIdValPares() {
        return ccbIdValPares;
    }

    public void setCcbIdValPares(String ccbIdValPares) {
        this.ccbIdValPares = ccbIdValPares;
    }

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
    }

    public String getCcbIdTrabTec() {
        return ccbIdTrabTec;
    }

    public void setCcbIdTrabTec(String ccbIdTrabTec) {
        this.ccbIdTrabTec = ccbIdTrabTec;
    }

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
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

    public String getCcbIdEstPub() {
        return ccbIdEstPub;
    }

    public void setCcbIdEstPub(String ccbIdEstPub) {
        this.ccbIdEstPub = ccbIdEstPub;
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
        hash += (m4ccbCvTrabTecnPK != null ? m4ccbCvTrabTecnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvTrabTecn)) {
            return false;
        }
        M4ccbCvTrabTecn other = (M4ccbCvTrabTecn) object;
        if ((this.m4ccbCvTrabTecnPK == null && other.m4ccbCvTrabTecnPK != null) || (this.m4ccbCvTrabTecnPK != null && !this.m4ccbCvTrabTecnPK.equals(other.m4ccbCvTrabTecnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTecn[ m4ccbCvTrabTecnPK=" + m4ccbCvTrabTecnPK + " ]";
    }
    
}
