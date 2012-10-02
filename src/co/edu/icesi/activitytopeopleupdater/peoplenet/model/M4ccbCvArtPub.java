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
 * @author 38555240 - Blanca Gómez Muñoz
 */
@Entity
@Table(name = "M4CCB_CV_ART_PUB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvArtPub.findAll", query = "SELECT m FROM M4ccbCvArtPub m"),
    @NamedQuery(name = "M4ccbCvArtPub.findByIdOrganization", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.m4ccbCvArtPubPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbOrArtPub", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.m4ccbCvArtPubPK.ccbOrArtPub = :ccbOrArtPub"),
    @NamedQuery(name = "M4ccbCvArtPub.findByStdIdHr", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.m4ccbCvArtPubPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbOtroTprod", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbOtroTprod = :ccbOtroTprod"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbOtroCateg", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbOtroCateg = :ccbOtroCateg"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbOtroTArt", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbOtroTArt = :ccbOtroTArt"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbNomProd", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbCoautores", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIssnIsbn", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIssnIsbn = :ccbIssnIsbn"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIndexada", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIndexada = :ccbIndexada"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbNomRevper", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbNomRevper = :ccbNomRevper"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbTRevista", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbTRevista = :ccbTRevista"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbVolumen", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbNumPag", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbEvalPares", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbEvalPares = :ccbEvalPares"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbConfidPriv", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbConfidPriv = :ccbConfidPriv"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbResumen", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbUrl", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdRevistas", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdRevistas = :ccbIdRevistas"),
    @NamedQuery(name = "M4ccbCvArtPub.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvArtPub.findByStdIdCountry", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvArtPub.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvArtPub.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvArtPub.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdTArticulo", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdTArticulo = :ccbIdTArticulo"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvArtPub.findByIdApprole", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvArtPub.findByIdSecuser", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvArtPub.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "M4ccbCvArtPub.findByCcbCargueAc", query = "SELECT m FROM M4ccbCvArtPub m WHERE m.ccbCargueAc = :ccbCargueAc")})
public class M4ccbCvArtPub implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvArtPubPK m4ccbCvArtPubPK;
    @Column(name = "CCB_OTRO_TPROD")
    private String ccbOtroTprod;
    @Column(name = "CCB_OTRO_CATEG")
    private String ccbOtroCateg;
    @Column(name = "CCB_OTRO_T_ART")
    private String ccbOtroTArt;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_ISSN_ISBN")
    private String ccbIssnIsbn;
    @Column(name = "CCB_INDEXADA")
    private String ccbIndexada;
    @Column(name = "CCB_NOM_REVPER")
    private String ccbNomRevper;
    @Column(name = "CCB_T_REVISTA")
    private String ccbTRevista;
    @Column(name = "CCB_VOLUMEN")
    private String ccbVolumen;
    @Column(name = "CCB_FASCICULO")
    private String ccbFasciculo;
    @Column(name = "CCB_NUM_PAG")
    private String ccbNumPag;
    @Column(name = "CCB_EVAL_PARES")
    private String ccbEvalPares;
    @Column(name = "CCB_CONFID_PRIV")
    private String ccbConfidPriv;
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
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "CCB_ID_T_ARTICULO")
    private String ccbIdTArticulo;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "CCB_ID_EST_PUB")
    private String ccbIdEstPub;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "CCB_CARGUE_AC")
    private String ccbCargueAc;

    public M4ccbCvArtPub() {
    }

    public M4ccbCvArtPub(M4ccbCvArtPubPK m4ccbCvArtPubPK) {
        this.m4ccbCvArtPubPK = m4ccbCvArtPubPK;
    }

    public M4ccbCvArtPub(String idOrganization, short ccbOrArtPub, String stdIdHr) {
        this.m4ccbCvArtPubPK = new M4ccbCvArtPubPK(idOrganization, ccbOrArtPub, stdIdHr);
    }

    public M4ccbCvArtPubPK getM4ccbCvArtPubPK() {
        return m4ccbCvArtPubPK;
    }

    public void setM4ccbCvArtPubPK(M4ccbCvArtPubPK m4ccbCvArtPubPK) {
        this.m4ccbCvArtPubPK = m4ccbCvArtPubPK;
    }

    public String getCcbOtroTprod() {
        return ccbOtroTprod;
    }

    public void setCcbOtroTprod(String ccbOtroTprod) {
        this.ccbOtroTprod = ccbOtroTprod;
    }

    public String getCcbOtroCateg() {
        return ccbOtroCateg;
    }

    public void setCcbOtroCateg(String ccbOtroCateg) {
        this.ccbOtroCateg = ccbOtroCateg;
    }

    public String getCcbOtroTArt() {
        return ccbOtroTArt;
    }

    public void setCcbOtroTArt(String ccbOtroTArt) {
        this.ccbOtroTArt = ccbOtroTArt;
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

    public String getCcbIndexada() {
        return ccbIndexada;
    }

    public void setCcbIndexada(String ccbIndexada) {
        this.ccbIndexada = ccbIndexada;
    }

    public String getCcbNomRevper() {
        return ccbNomRevper;
    }

    public void setCcbNomRevper(String ccbNomRevper) {
        this.ccbNomRevper = ccbNomRevper;
    }

    public String getCcbTRevista() {
        return ccbTRevista;
    }

    public void setCcbTRevista(String ccbTRevista) {
        this.ccbTRevista = ccbTRevista;
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

    public String getCcbEvalPares() {
        return ccbEvalPares;
    }

    public void setCcbEvalPares(String ccbEvalPares) {
        this.ccbEvalPares = ccbEvalPares;
    }

    public String getCcbConfidPriv() {
        return ccbConfidPriv;
    }

    public void setCcbConfidPriv(String ccbConfidPriv) {
        this.ccbConfidPriv = ccbConfidPriv;
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

    public String getCcbIdTArticulo() {
        return ccbIdTArticulo;
    }

    public void setCcbIdTArticulo(String ccbIdTArticulo) {
        this.ccbIdTArticulo = ccbIdTArticulo;
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

    public String getCcbCargueAc() {
        return ccbCargueAc;
    }

    public void setCcbCargueAc(String ccbCargueAc) {
        this.ccbCargueAc = ccbCargueAc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4ccbCvArtPubPK != null ? m4ccbCvArtPubPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvArtPub)) {
            return false;
        }
        M4ccbCvArtPub other = (M4ccbCvArtPub) object;
        if ((this.m4ccbCvArtPubPK == null && other.m4ccbCvArtPubPK != null) || (this.m4ccbCvArtPubPK != null && !this.m4ccbCvArtPubPK.equals(other.m4ccbCvArtPubPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvArtPub[ m4ccbCvArtPubPK=" + m4ccbCvArtPubPK + " ]";
    }
    
}
