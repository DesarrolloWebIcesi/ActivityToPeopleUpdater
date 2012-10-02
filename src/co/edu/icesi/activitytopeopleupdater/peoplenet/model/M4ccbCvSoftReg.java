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
@Table(name = "M4CCB_CV_SOFT_REG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvSoftReg.findAll", query = "SELECT m FROM M4ccbCvSoftReg m"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByIdOrganization", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.m4ccbCvSoftRegPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbOrSoftReg", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.m4ccbCvSoftRegPK.ccbOrSoftReg = :ccbOrSoftReg"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByStdIdHr", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.m4ccbCvSoftRegPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbOtroProd", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbOtroProd = :ccbOtroProd"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbNomProd", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbCoautores", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCbbEntPatr", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.cbbEntPatr = :cbbEntPatr"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbContReg", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbContReg = :ccbContReg"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbInstCert", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbInstCert = :ccbInstCert"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbAmbiente", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbAmbiente = :ccbAmbiente"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbAreasApl", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbAreasApl = :ccbAreasApl"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbPalbCla", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbPalbCla = :ccbPalbCla"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbDispRest", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbDispRest = :ccbDispRest"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbFechaRev", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbFechaRev = :ccbFechaRev"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbFinalidad", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbFinalidad = :ccbFinalidad"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbResumen", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbUrl", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdProduc", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdProduc = :ccbIdProduc"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdEstInves", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdEstInves = :ccbIdEstInves"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByStdIdCountry", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByIdApprole", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByIdSecuser", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvSoftReg.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvSoftReg m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvSoftReg implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvSoftRegPK m4ccbCvSoftRegPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_PROD")
    private String ccbOtroProd;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_CONF_PRIV")
    private String ccbConfPriv;
    @Column(name = "CCB_EVA_PARES")
    private String ccbEvaPares;
    @Column(name = "CBB_ENT_PATR")
    private String cbbEntPatr;
    @Column(name = "CCB_CONT_REG")
    private String ccbContReg;
    @Column(name = "CCB_INST_CERT")
    private String ccbInstCert;
    @Column(name = "CCB_AMBIENTE")
    private String ccbAmbiente;
    @Column(name = "CCB_AREAS_APL")
    private String ccbAreasApl;
    @Column(name = "CCB_PALB_CLA")
    private String ccbPalbCla;
    @Column(name = "CCB_DISP_REST")
    private String ccbDispRest;
    @Column(name = "CCB_FECHA_PROP")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaProp;
    @Column(name = "CCB_FECHA_REV")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRev;
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
    @Column(name = "CCB_ID_PRODUC")
    private String ccbIdProduc;
    @Column(name = "CCB_ID_EST_INVES")
    private String ccbIdEstInves;
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

    public M4ccbCvSoftReg() {
    }

    public M4ccbCvSoftReg(M4ccbCvSoftRegPK m4ccbCvSoftRegPK) {
        this.m4ccbCvSoftRegPK = m4ccbCvSoftRegPK;
    }

    public M4ccbCvSoftReg(String idOrganization, short ccbOrSoftReg, String stdIdHr) {
        this.m4ccbCvSoftRegPK = new M4ccbCvSoftRegPK(idOrganization, ccbOrSoftReg, stdIdHr);
    }

    public M4ccbCvSoftRegPK getM4ccbCvSoftRegPK() {
        return m4ccbCvSoftRegPK;
    }

    public void setM4ccbCvSoftRegPK(M4ccbCvSoftRegPK m4ccbCvSoftRegPK) {
        this.m4ccbCvSoftRegPK = m4ccbCvSoftRegPK;
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

    public String getCcbOtroProd() {
        return ccbOtroProd;
    }

    public void setCcbOtroProd(String ccbOtroProd) {
        this.ccbOtroProd = ccbOtroProd;
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

    public String getCcbConfPriv() {
        return ccbConfPriv;
    }

    public void setCcbConfPriv(String ccbConfPriv) {
        this.ccbConfPriv = ccbConfPriv;
    }

    public String getCcbEvaPares() {
        return ccbEvaPares;
    }

    public void setCcbEvaPares(String ccbEvaPares) {
        this.ccbEvaPares = ccbEvaPares;
    }

    public String getCbbEntPatr() {
        return cbbEntPatr;
    }

    public void setCbbEntPatr(String cbbEntPatr) {
        this.cbbEntPatr = cbbEntPatr;
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

    public String getCcbAmbiente() {
        return ccbAmbiente;
    }

    public void setCcbAmbiente(String ccbAmbiente) {
        this.ccbAmbiente = ccbAmbiente;
    }

    public String getCcbAreasApl() {
        return ccbAreasApl;
    }

    public void setCcbAreasApl(String ccbAreasApl) {
        this.ccbAreasApl = ccbAreasApl;
    }

    public String getCcbPalbCla() {
        return ccbPalbCla;
    }

    public void setCcbPalbCla(String ccbPalbCla) {
        this.ccbPalbCla = ccbPalbCla;
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

    public Date getCcbFechaRev() {
        return ccbFechaRev;
    }

    public void setCcbFechaRev(Date ccbFechaRev) {
        this.ccbFechaRev = ccbFechaRev;
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

    public String getCcbIdProduc() {
        return ccbIdProduc;
    }

    public void setCcbIdProduc(String ccbIdProduc) {
        this.ccbIdProduc = ccbIdProduc;
    }

    public String getCcbIdEstInves() {
        return ccbIdEstInves;
    }

    public void setCcbIdEstInves(String ccbIdEstInves) {
        this.ccbIdEstInves = ccbIdEstInves;
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
        hash += (m4ccbCvSoftRegPK != null ? m4ccbCvSoftRegPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvSoftReg)) {
            return false;
        }
        M4ccbCvSoftReg other = (M4ccbCvSoftReg) object;
        if ((this.m4ccbCvSoftRegPK == null && other.m4ccbCvSoftRegPK != null) || (this.m4ccbCvSoftRegPK != null && !this.m4ccbCvSoftRegPK.equals(other.m4ccbCvSoftRegPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvSoftReg[ m4ccbCvSoftRegPK=" + m4ccbCvSoftRegPK + " ]";
    }
    
}
