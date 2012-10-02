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
@Table(name = "M4CCB_CV_LIBRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvLibro.findAll", query = "SELECT m FROM M4ccbCvLibro m"),
    @NamedQuery(name = "M4ccbCvLibro.findByIdOrganization", query = "SELECT m FROM M4ccbCvLibro m WHERE m.m4ccbCvLibroPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbOrLibro", query = "SELECT m FROM M4ccbCvLibro m WHERE m.m4ccbCvLibroPK.ccbOrLibro = :ccbOrLibro"),
    @NamedQuery(name = "M4ccbCvLibro.findByStdIdHr", query = "SELECT m FROM M4ccbCvLibro m WHERE m.m4ccbCvLibroPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbNomProd", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbCoautores", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbIssnIsbn", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbIssnIsbn = :ccbIssnIsbn"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbEditorial", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbVolumen", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbNumPag", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbResumen", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbUrl", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvLibro.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvLibro m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvLibro.findByStdIdCountry", query = "SELECT m FROM M4ccbCvLibro m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvLibro.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvLibro m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvLibro.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvLibro m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvLibro.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvLibro m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvLibro.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvLibro m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvLibro.findByIdApprole", query = "SELECT m FROM M4ccbCvLibro m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvLibro.findByIdSecuser", query = "SELECT m FROM M4ccbCvLibro m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvLibro.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvLibro m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvLibro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvLibroPK m4ccbCvLibroPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_ISSN_ISBN")
    private String ccbIssnIsbn;
    @Column(name = "CCB_EDITORIAL")
    private String ccbEditorial;
    @Column(name = "CCB_VOLUMEN")
    private String ccbVolumen;
    @Column(name = "CCB_FASCICULO")
    private String ccbFasciculo;
    @Column(name = "CCB_NUM_PAG")
    private String ccbNumPag;
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
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_EST_PUB")
    private String ccbIdEstPub;
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
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvLibro() {
    }

    public M4ccbCvLibro(M4ccbCvLibroPK m4ccbCvLibroPK) {
        this.m4ccbCvLibroPK = m4ccbCvLibroPK;
    }

    public M4ccbCvLibro(String idOrganization, short ccbOrLibro, String stdIdHr) {
        this.m4ccbCvLibroPK = new M4ccbCvLibroPK(idOrganization, ccbOrLibro, stdIdHr);
    }

    public M4ccbCvLibroPK getM4ccbCvLibroPK() {
        return m4ccbCvLibroPK;
    }

    public void setM4ccbCvLibroPK(M4ccbCvLibroPK m4ccbCvLibroPK) {
        this.m4ccbCvLibroPK = m4ccbCvLibroPK;
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

    public String getCcbIssnIsbn() {
        return ccbIssnIsbn;
    }

    public void setCcbIssnIsbn(String ccbIssnIsbn) {
        this.ccbIssnIsbn = ccbIssnIsbn;
    }

    public String getCcbEditorial() {
        return ccbEditorial;
    }

    public void setCcbEditorial(String ccbEditorial) {
        this.ccbEditorial = ccbEditorial;
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

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
    }

    public String getCcbIdEstPub() {
        return ccbIdEstPub;
    }

    public void setCcbIdEstPub(String ccbIdEstPub) {
        this.ccbIdEstPub = ccbIdEstPub;
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
        hash += (m4ccbCvLibroPK != null ? m4ccbCvLibroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvLibro)) {
            return false;
        }
        M4ccbCvLibro other = (M4ccbCvLibro) object;
        if ((this.m4ccbCvLibroPK == null && other.m4ccbCvLibroPK != null) || (this.m4ccbCvLibroPK != null && !this.m4ccbCvLibroPK.equals(other.m4ccbCvLibroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvLibro[ m4ccbCvLibroPK=" + m4ccbCvLibroPK + " ]";
    }
    
}
