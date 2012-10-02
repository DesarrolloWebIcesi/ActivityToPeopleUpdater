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
@Table(name = "M4CCB_CV_CAP_LIB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvCapLib.findAll", query = "SELECT m FROM M4ccbCvCapLib m"),
    @NamedQuery(name = "M4ccbCvCapLib.findByIdOrganization", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.m4ccbCvCapLibPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbOrCapLib", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.m4ccbCvCapLibPK.ccbOrCapLib = :ccbOrCapLib"),
    @NamedQuery(name = "M4ccbCvCapLib.findByStdIdHr", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.m4ccbCvCapLibPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbNomProd", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbNomLibro", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbNomLibro = :ccbNomLibro"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbCoautores", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbIssnIsbn", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbIssnIsbn = :ccbIssnIsbn"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbOrganizadores", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbOrganizadores = :ccbOrganizadores"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbEditorial", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbVolumen", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbNumPag", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbResumen", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbUrl", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvCapLib.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvCapLib.findByStdIdCountry", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvCapLib.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvCapLib.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvCapLib.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvCapLib.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvCapLib.findByIdApprole", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvCapLib.findByIdSecuser", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvCapLib.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvCapLib m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvCapLib implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvCapLibPK m4ccbCvCapLibPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_NOM_LIBRO")
    private String ccbNomLibro;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_ISSN_ISBN")
    private String ccbIssnIsbn;
    @Column(name = "CCB_ORGANIZADORES")
    private String ccbOrganizadores;
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

    public M4ccbCvCapLib() {
    }

    public M4ccbCvCapLib(M4ccbCvCapLibPK m4ccbCvCapLibPK) {
        this.m4ccbCvCapLibPK = m4ccbCvCapLibPK;
    }

    public M4ccbCvCapLib(String idOrganization, short ccbOrCapLib, String stdIdHr) {
        this.m4ccbCvCapLibPK = new M4ccbCvCapLibPK(idOrganization, ccbOrCapLib, stdIdHr);
    }

    public M4ccbCvCapLibPK getM4ccbCvCapLibPK() {
        return m4ccbCvCapLibPK;
    }

    public void setM4ccbCvCapLibPK(M4ccbCvCapLibPK m4ccbCvCapLibPK) {
        this.m4ccbCvCapLibPK = m4ccbCvCapLibPK;
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

    public String getCcbNomLibro() {
        return ccbNomLibro;
    }

    public void setCcbNomLibro(String ccbNomLibro) {
        this.ccbNomLibro = ccbNomLibro;
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

    public String getCcbOrganizadores() {
        return ccbOrganizadores;
    }

    public void setCcbOrganizadores(String ccbOrganizadores) {
        this.ccbOrganizadores = ccbOrganizadores;
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
        hash += (m4ccbCvCapLibPK != null ? m4ccbCvCapLibPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvCapLib)) {
            return false;
        }
        M4ccbCvCapLib other = (M4ccbCvCapLib) object;
        if ((this.m4ccbCvCapLibPK == null && other.m4ccbCvCapLibPK != null) || (this.m4ccbCvCapLibPK != null && !this.m4ccbCvCapLibPK.equals(other.m4ccbCvCapLibPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCapLib[ m4ccbCvCapLibPK=" + m4ccbCvCapLibPK + " ]";
    }
    
}
