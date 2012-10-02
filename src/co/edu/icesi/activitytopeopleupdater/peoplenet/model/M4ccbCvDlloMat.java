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
@Table(name = "M4CCB_CV_DLLO_MAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvDlloMat.findAll", query = "SELECT m FROM M4ccbCvDlloMat m"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByIdOrganization", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.m4ccbCvDlloMatPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbOrDesMat", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.m4ccbCvDlloMatPK.ccbOrDesMat = :ccbOrDesMat"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByStdIdHr", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.m4ccbCvDlloMatPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbTipoClas", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbTipoClas = :ccbTipoClas"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbNomProd", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbCoautores", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbInstCert", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbInstCert = :ccbInstCert"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCbbDisponib", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.cbbDisponib = :cbbDisponib"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbFinalidad", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbFinalidad = :ccbFinalidad"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbResumen", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbUrl", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByStdIdCountry", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByIdApprole", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByIdSecuser", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvDlloMat.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvDlloMat m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvDlloMat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvDlloMatPK m4ccbCvDlloMatPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_TIPO_CLAS")
    private String ccbTipoClas;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_INST_CERT")
    private String ccbInstCert;
    @Column(name = "CCB_EVA_PARES")
    private String ccbEvaPares;
    @Column(name = "CCB_CONF_PRIV")
    private String ccbConfPriv;
    @Column(name = "CBB_DISPONIB")
    private String cbbDisponib;
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
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "CCB_ID_PROD_INT")
    private String ccbIdProdInt;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
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

    public M4ccbCvDlloMat() {
    }

    public M4ccbCvDlloMat(M4ccbCvDlloMatPK m4ccbCvDlloMatPK) {
        this.m4ccbCvDlloMatPK = m4ccbCvDlloMatPK;
    }

    public M4ccbCvDlloMat(String idOrganization, short ccbOrDesMat, String stdIdHr) {
        this.m4ccbCvDlloMatPK = new M4ccbCvDlloMatPK(idOrganization, ccbOrDesMat, stdIdHr);
    }

    public M4ccbCvDlloMatPK getM4ccbCvDlloMatPK() {
        return m4ccbCvDlloMatPK;
    }

    public void setM4ccbCvDlloMatPK(M4ccbCvDlloMatPK m4ccbCvDlloMatPK) {
        this.m4ccbCvDlloMatPK = m4ccbCvDlloMatPK;
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

    public String getCcbTipoClas() {
        return ccbTipoClas;
    }

    public void setCcbTipoClas(String ccbTipoClas) {
        this.ccbTipoClas = ccbTipoClas;
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

    public String getCbbDisponib() {
        return cbbDisponib;
    }

    public void setCbbDisponib(String cbbDisponib) {
        this.cbbDisponib = cbbDisponib;
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

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
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
        hash += (m4ccbCvDlloMatPK != null ? m4ccbCvDlloMatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvDlloMat)) {
            return false;
        }
        M4ccbCvDlloMat other = (M4ccbCvDlloMat) object;
        if ((this.m4ccbCvDlloMatPK == null && other.m4ccbCvDlloMatPK != null) || (this.m4ccbCvDlloMatPK != null && !this.m4ccbCvDlloMatPK.equals(other.m4ccbCvDlloMatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDlloMat[ m4ccbCvDlloMatPK=" + m4ccbCvDlloMatPK + " ]";
    }
    
}
