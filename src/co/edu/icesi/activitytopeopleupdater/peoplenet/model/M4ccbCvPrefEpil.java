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
@Table(name = "M4CCB_CV_PREF_EPIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvPrefEpil.findAll", query = "SELECT m FROM M4ccbCvPrefEpil m"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByIdOrganization", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.m4ccbCvPrefEpilPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbOrPrefacio", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.m4ccbCvPrefEpilPK.ccbOrPrefacio = :ccbOrPrefacio"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByStdIdHr", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.m4ccbCvPrefEpilPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbOtroTPref", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbOtroTPref = :ccbOtroTPref"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbNomProd", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbCoautores", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIsbn", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIsbn = :ccbIsbn"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbLibRevPub", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbLibRevPub = :ccbLibRevPub"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbVolumen", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbNumPag", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbEditorial", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbResumen", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbUrl", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByStdIdCountry", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIdTEpilogo", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIdTEpilogo = :ccbIdTEpilogo"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByIdApprole", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByIdSecuser", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvPrefEpil.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvPrefEpil m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvPrefEpil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvPrefEpilPK m4ccbCvPrefEpilPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_T_PREF")
    private String ccbOtroTPref;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_ISBN")
    private String ccbIsbn;
    @Column(name = "CCB_LIB_REV_PUB")
    private String ccbLibRevPub;
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
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
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
    @Column(name = "CCB_ID_T_EPILOGO")
    private String ccbIdTEpilogo;
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

    public M4ccbCvPrefEpil() {
    }

    public M4ccbCvPrefEpil(M4ccbCvPrefEpilPK m4ccbCvPrefEpilPK) {
        this.m4ccbCvPrefEpilPK = m4ccbCvPrefEpilPK;
    }

    public M4ccbCvPrefEpil(String idOrganization, short ccbOrPrefacio, String stdIdHr) {
        this.m4ccbCvPrefEpilPK = new M4ccbCvPrefEpilPK(idOrganization, ccbOrPrefacio, stdIdHr);
    }

    public M4ccbCvPrefEpilPK getM4ccbCvPrefEpilPK() {
        return m4ccbCvPrefEpilPK;
    }

    public void setM4ccbCvPrefEpilPK(M4ccbCvPrefEpilPK m4ccbCvPrefEpilPK) {
        this.m4ccbCvPrefEpilPK = m4ccbCvPrefEpilPK;
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

    public String getCcbOtroTPref() {
        return ccbOtroTPref;
    }

    public void setCcbOtroTPref(String ccbOtroTPref) {
        this.ccbOtroTPref = ccbOtroTPref;
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

    public String getCcbIsbn() {
        return ccbIsbn;
    }

    public void setCcbIsbn(String ccbIsbn) {
        this.ccbIsbn = ccbIsbn;
    }

    public String getCcbLibRevPub() {
        return ccbLibRevPub;
    }

    public void setCcbLibRevPub(String ccbLibRevPub) {
        this.ccbLibRevPub = ccbLibRevPub;
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

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
    }

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
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

    public String getCcbIdTEpilogo() {
        return ccbIdTEpilogo;
    }

    public void setCcbIdTEpilogo(String ccbIdTEpilogo) {
        this.ccbIdTEpilogo = ccbIdTEpilogo;
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
        hash += (m4ccbCvPrefEpilPK != null ? m4ccbCvPrefEpilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvPrefEpil)) {
            return false;
        }
        M4ccbCvPrefEpil other = (M4ccbCvPrefEpil) object;
        if ((this.m4ccbCvPrefEpilPK == null && other.m4ccbCvPrefEpilPK != null) || (this.m4ccbCvPrefEpilPK != null && !this.m4ccbCvPrefEpilPK.equals(other.m4ccbCvPrefEpilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPrefEpil[ m4ccbCvPrefEpilPK=" + m4ccbCvPrefEpilPK + " ]";
    }
    
}
