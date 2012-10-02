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
@Table(name = "M4CCB_CV_DOC_TRAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvDocTrab.findAll", query = "SELECT m FROM M4ccbCvDocTrab m"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByIdOrganization", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.m4ccbCvDocTrabPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbOrDocTrab", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.m4ccbCvDocTrabPK.ccbOrDocTrab = :ccbOrDocTrab"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByStdIdHr", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.m4ccbCvDocTrabPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbDocTrab", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbDocTrab = :ccbDocTrab"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbOtroTipDoc", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbOtroTipDoc = :ccbOtroTipDoc"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbNomProd", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbCoautores", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbOtroMed", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbOtroMed = :ccbOtroMed"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIsbn", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIsbn = :ccbIsbn"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbLibRev", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbLibRev = :ccbLibRev"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbVolumen", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbNumPag", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbEditorial", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbResumen", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbUrl", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdRevistas", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdRevistas = :ccbIdRevistas"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByStdIdCountry", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdMedioPres", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdMedioPres = :ccbIdMedioPres"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByIdApprole", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByIdSecuser", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvDocTrab.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvDocTrab m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvDocTrab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvDocTrabPK m4ccbCvDocTrabPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_DOC_TRAB")
    private String ccbDocTrab;
    @Column(name = "CCB_OTRO_TIP_DOC")
    private String ccbOtroTipDoc;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_OTRO_MED")
    private String ccbOtroMed;
    @Column(name = "CCB_ISBN")
    private String ccbIsbn;
    @Column(name = "CCB_LIB_REV")
    private String ccbLibRev;
    @Column(name = "CCB_VOLUMEN")
    private String ccbVolumen;
    @Column(name = "CCB_FASCICULO")
    private String ccbFasciculo;
    @Column(name = "CCB_NUM_PAG")
    private String ccbNumPag;
    @Column(name = "CCB_EDITORIAL")
    private String ccbEditorial;
    @Column(name = "CCB_EVA_PARES")
    private String ccbEvaPares;
    @Column(name = "CCB_CONF_PRIV")
    private String ccbConfPriv;
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
    @Column(name = "CCB_ID_REVISTAS")
    private String ccbIdRevistas;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
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
    @Column(name = "CCB_ID_MEDIO_PRES")
    private String ccbIdMedioPres;
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

    public M4ccbCvDocTrab() {
    }

    public M4ccbCvDocTrab(M4ccbCvDocTrabPK m4ccbCvDocTrabPK) {
        this.m4ccbCvDocTrabPK = m4ccbCvDocTrabPK;
    }

    public M4ccbCvDocTrab(String idOrganization, short ccbOrDocTrab, String stdIdHr) {
        this.m4ccbCvDocTrabPK = new M4ccbCvDocTrabPK(idOrganization, ccbOrDocTrab, stdIdHr);
    }

    public M4ccbCvDocTrabPK getM4ccbCvDocTrabPK() {
        return m4ccbCvDocTrabPK;
    }

    public void setM4ccbCvDocTrabPK(M4ccbCvDocTrabPK m4ccbCvDocTrabPK) {
        this.m4ccbCvDocTrabPK = m4ccbCvDocTrabPK;
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

    public String getCcbDocTrab() {
        return ccbDocTrab;
    }

    public void setCcbDocTrab(String ccbDocTrab) {
        this.ccbDocTrab = ccbDocTrab;
    }

    public String getCcbOtroTipDoc() {
        return ccbOtroTipDoc;
    }

    public void setCcbOtroTipDoc(String ccbOtroTipDoc) {
        this.ccbOtroTipDoc = ccbOtroTipDoc;
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

    public String getCcbOtroMed() {
        return ccbOtroMed;
    }

    public void setCcbOtroMed(String ccbOtroMed) {
        this.ccbOtroMed = ccbOtroMed;
    }

    public String getCcbIsbn() {
        return ccbIsbn;
    }

    public void setCcbIsbn(String ccbIsbn) {
        this.ccbIsbn = ccbIsbn;
    }

    public String getCcbLibRev() {
        return ccbLibRev;
    }

    public void setCcbLibRev(String ccbLibRev) {
        this.ccbLibRev = ccbLibRev;
    }

    public String getCcbVolumen() {
        return ccbVolumen;
    }

    public void setCcbVolumen(String ccbVolumen) {
        this.ccbVolumen = ccbVolumen;
    }

    public String getCcbFasciculo() {
        return ccbFasciculo;
    }

    public void setCcbFasciculo(String ccbFasciculo) {
        this.ccbFasciculo = ccbFasciculo;
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

    public String getCcbIdRevistas() {
        return ccbIdRevistas;
    }

    public void setCcbIdRevistas(String ccbIdRevistas) {
        this.ccbIdRevistas = ccbIdRevistas;
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

    public String getCcbIdMedioPres() {
        return ccbIdMedioPres;
    }

    public void setCcbIdMedioPres(String ccbIdMedioPres) {
        this.ccbIdMedioPres = ccbIdMedioPres;
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
        hash += (m4ccbCvDocTrabPK != null ? m4ccbCvDocTrabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvDocTrab)) {
            return false;
        }
        M4ccbCvDocTrab other = (M4ccbCvDocTrab) object;
        if ((this.m4ccbCvDocTrabPK == null && other.m4ccbCvDocTrabPK != null) || (this.m4ccbCvDocTrabPK != null && !this.m4ccbCvDocTrabPK.equals(other.m4ccbCvDocTrabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDocTrab[ m4ccbCvDocTrabPK=" + m4ccbCvDocTrabPK + " ]";
    }
    
}
