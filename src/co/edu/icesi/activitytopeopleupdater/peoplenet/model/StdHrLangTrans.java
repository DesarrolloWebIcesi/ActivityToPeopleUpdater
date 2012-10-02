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
@Table(name = "STD_HR_LANG_TRANS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdHrLangTrans.findAll", query = "SELECT s FROM StdHrLangTrans s"),
    @NamedQuery(name = "StdHrLangTrans.findByIdOrganization", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdHrLangTransPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdHr", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdHrLangTransPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdLanguage", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdHrLangTransPK.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdLanguageTo", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdHrLangTransPK.stdIdLanguageTo = :stdIdLanguageTo"),
    @NamedQuery(name = "StdHrLangTrans.findByStdDtStart", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdHrLangTransPK.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbOrTraducc", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdHrLangTransPK.ccbOrTraducc = :ccbOrTraducc"),
    @NamedQuery(name = "StdHrLangTrans.findByStdDtEnd", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbUrl", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbResumen", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbFechaPub", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbFechaAprob", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbFechaRevision", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbFechaProp", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbConfPriv", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbEvaPares", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbEditorial", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbNumPag", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbFasciculo", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbVolumen", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbLibRevPub", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbLibRevPub = :ccbLibRevPub"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIsbn", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIsbn = :ccbIsbn"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbCoautores", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbNomProd", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbOtroTrad", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbOtroTrad = :ccbOtroTrad"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbOtraCat", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbOtroTipo", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbOtroTipo = :ccbOtroTipo"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdTransLevel", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdIdTransLevel = :stdIdTransLevel"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdInterLevel", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdIdInterLevel = :stdIdInterLevel"),
    @NamedQuery(name = "StdHrLangTrans.findByStdComment", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdComment = :stdComment"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdCountry", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdGeoDiv", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIdProdInt", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIdCategoria", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdSubGeoDiv", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIdValPares", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "StdHrLangTrans.findByStdIdGeoPlace", query = "SELECT s FROM StdHrLangTrans s WHERE s.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIdTraduc", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIdTraduc = :ccbIdTraduc"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIdAmbito", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbIdEstPub", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "StdHrLangTrans.findByCcbCargueAct", query = "SELECT s FROM StdHrLangTrans s WHERE s.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "StdHrLangTrans.findByIdApprole", query = "SELECT s FROM StdHrLangTrans s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdHrLangTrans.findByIdSecuser", query = "SELECT s FROM StdHrLangTrans s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdHrLangTrans.findByDtLastUpdate", query = "SELECT s FROM StdHrLangTrans s WHERE s.dtLastUpdate = :dtLastUpdate")})
public class StdHrLangTrans implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdHrLangTransPK stdHrLangTransPK;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_RESUMEN")
    private String ccbResumen;
    @Column(name = "CCB_FECHA_PUB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPub;
    @Column(name = "CCB_FECHA_APROB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaAprob;
    @Column(name = "CCB_FECHA_REVISION")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRevision;
    @Column(name = "CCB_FECHA_PROP")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaProp;
    @Column(name = "CCB_CONF_PRIV")
    private String ccbConfPriv;
    @Column(name = "CCB_EVA_PARES")
    private String ccbEvaPares;
    @Column(name = "CCB_EDITORIAL")
    private String ccbEditorial;
    @Column(name = "CCB_NUM_PAG")
    private String ccbNumPag;
    @Column(name = "CCB_FASCICULO")
    private String ccbFasciculo;
    @Column(name = "CCB_VOLUMEN")
    private String ccbVolumen;
    @Column(name = "CCB_LIB_REV_PUB")
    private String ccbLibRevPub;
    @Column(name = "CCB_ISBN")
    private String ccbIsbn;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_OTRO_TRAD")
    private String ccbOtroTrad;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_TIPO")
    private String ccbOtroTipo;
    @Column(name = "STD_ID_TRANS_LEVEL")
    private String stdIdTransLevel;
    @Column(name = "STD_ID_INTER_LEVEL")
    private String stdIdInterLevel;
    @Column(name = "STD_COMMENT")
    private String stdComment;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "CCB_ID_PROD_INT")
    private String ccbIdProdInt;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "CCB_ID_TRADUC")
    private String ccbIdTraduc;
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

    public StdHrLangTrans() {
    }

    public StdHrLangTrans(StdHrLangTransPK stdHrLangTransPK) {
        this.stdHrLangTransPK = stdHrLangTransPK;
    }

    public StdHrLangTrans(String idOrganization, String stdIdHr, String stdIdLanguage, String stdIdLanguageTo, Date stdDtStart, short ccbOrTraducc) {
        this.stdHrLangTransPK = new StdHrLangTransPK(idOrganization, stdIdHr, stdIdLanguage, stdIdLanguageTo, stdDtStart, ccbOrTraducc);
    }

    public StdHrLangTransPK getStdHrLangTransPK() {
        return stdHrLangTransPK;
    }

    public void setStdHrLangTransPK(StdHrLangTransPK stdHrLangTransPK) {
        this.stdHrLangTransPK = stdHrLangTransPK;
    }

    public Date getStdDtEnd() {
        return stdDtEnd;
    }

    public void setStdDtEnd(Date stdDtEnd) {
        this.stdDtEnd = stdDtEnd;
    }

    public String getCcbUrl() {
        return ccbUrl;
    }

    public void setCcbUrl(String ccbUrl) {
        this.ccbUrl = ccbUrl;
    }

    public String getCcbResumen() {
        return ccbResumen;
    }

    public void setCcbResumen(String ccbResumen) {
        this.ccbResumen = ccbResumen;
    }

    public Date getCcbFechaPub() {
        return ccbFechaPub;
    }

    public void setCcbFechaPub(Date ccbFechaPub) {
        this.ccbFechaPub = ccbFechaPub;
    }

    public Date getCcbFechaAprob() {
        return ccbFechaAprob;
    }

    public void setCcbFechaAprob(Date ccbFechaAprob) {
        this.ccbFechaAprob = ccbFechaAprob;
    }

    public Date getCcbFechaRevision() {
        return ccbFechaRevision;
    }

    public void setCcbFechaRevision(Date ccbFechaRevision) {
        this.ccbFechaRevision = ccbFechaRevision;
    }

    public Date getCcbFechaProp() {
        return ccbFechaProp;
    }

    public void setCcbFechaProp(Date ccbFechaProp) {
        this.ccbFechaProp = ccbFechaProp;
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

    public String getCcbEditorial() {
        return ccbEditorial;
    }

    public void setCcbEditorial(String ccbEditorial) {
        this.ccbEditorial = ccbEditorial;
    }

    public String getCcbNumPag() {
        return ccbNumPag;
    }

    public void setCcbNumPag(String ccbNumPag) {
        this.ccbNumPag = ccbNumPag;
    }

    public String getCcbFasciculo() {
        return ccbFasciculo;
    }

    public void setCcbFasciculo(String ccbFasciculo) {
        this.ccbFasciculo = ccbFasciculo;
    }

    public String getCcbVolumen() {
        return ccbVolumen;
    }

    public void setCcbVolumen(String ccbVolumen) {
        this.ccbVolumen = ccbVolumen;
    }

    public String getCcbLibRevPub() {
        return ccbLibRevPub;
    }

    public void setCcbLibRevPub(String ccbLibRevPub) {
        this.ccbLibRevPub = ccbLibRevPub;
    }

    public String getCcbIsbn() {
        return ccbIsbn;
    }

    public void setCcbIsbn(String ccbIsbn) {
        this.ccbIsbn = ccbIsbn;
    }

    public String getCcbCoautores() {
        return ccbCoautores;
    }

    public void setCcbCoautores(String ccbCoautores) {
        this.ccbCoautores = ccbCoautores;
    }

    public String getCcbNomProd() {
        return ccbNomProd;
    }

    public void setCcbNomProd(String ccbNomProd) {
        this.ccbNomProd = ccbNomProd;
    }

    public String getCcbOtroTrad() {
        return ccbOtroTrad;
    }

    public void setCcbOtroTrad(String ccbOtroTrad) {
        this.ccbOtroTrad = ccbOtroTrad;
    }

    public String getCcbOtraCat() {
        return ccbOtraCat;
    }

    public void setCcbOtraCat(String ccbOtraCat) {
        this.ccbOtraCat = ccbOtraCat;
    }

    public String getCcbOtroTipo() {
        return ccbOtroTipo;
    }

    public void setCcbOtroTipo(String ccbOtroTipo) {
        this.ccbOtroTipo = ccbOtroTipo;
    }

    public String getStdIdTransLevel() {
        return stdIdTransLevel;
    }

    public void setStdIdTransLevel(String stdIdTransLevel) {
        this.stdIdTransLevel = stdIdTransLevel;
    }

    public String getStdIdInterLevel() {
        return stdIdInterLevel;
    }

    public void setStdIdInterLevel(String stdIdInterLevel) {
        this.stdIdInterLevel = stdIdInterLevel;
    }

    public String getStdComment() {
        return stdComment;
    }

    public void setStdComment(String stdComment) {
        this.stdComment = stdComment;
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

    public String getStdIdSubGeoDiv() {
        return stdIdSubGeoDiv;
    }

    public void setStdIdSubGeoDiv(String stdIdSubGeoDiv) {
        this.stdIdSubGeoDiv = stdIdSubGeoDiv;
    }

    public String getCcbIdValPares() {
        return ccbIdValPares;
    }

    public void setCcbIdValPares(String ccbIdValPares) {
        this.ccbIdValPares = ccbIdValPares;
    }

    public String getStdIdGeoPlace() {
        return stdIdGeoPlace;
    }

    public void setStdIdGeoPlace(String stdIdGeoPlace) {
        this.stdIdGeoPlace = stdIdGeoPlace;
    }

    public String getCcbIdTraduc() {
        return ccbIdTraduc;
    }

    public void setCcbIdTraduc(String ccbIdTraduc) {
        this.ccbIdTraduc = ccbIdTraduc;
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
        hash += (stdHrLangTransPK != null ? stdHrLangTransPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrLangTrans)) {
            return false;
        }
        StdHrLangTrans other = (StdHrLangTrans) object;
        if ((this.stdHrLangTransPK == null && other.stdHrLangTransPK != null) || (this.stdHrLangTransPK != null && !this.stdHrLangTransPK.equals(other.stdHrLangTransPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrLangTrans[ stdHrLangTransPK=" + stdHrLangTransPK + " ]";
    }
    
}
