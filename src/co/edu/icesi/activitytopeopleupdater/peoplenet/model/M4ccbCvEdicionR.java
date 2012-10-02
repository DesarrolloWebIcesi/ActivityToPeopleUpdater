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
@Table(name = "M4CCB_CV_EDICION_R")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvEdicionR.findAll", query = "SELECT m FROM M4ccbCvEdicionR m"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByIdOrganization", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.m4ccbCvEdicionRPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbOrEdicRev", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.m4ccbCvEdicionRPK.ccbOrEdicRev = :ccbOrEdicRev"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdHr", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.m4ccbCvEdicionRPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbOtroEdic", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbOtroEdic = :ccbOtroEdic"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbNomProd", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbCoautores", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIsbn", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIsbn = :ccbIsbn"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbLibRevPub", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbLibRevPub = :ccbLibRevPub"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbVolumen", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbNumPag", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbEditorial", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbEditorial = :ccbEditorial"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCbbEntPatr", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.cbbEntPatr = :cbbEntPatr"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbEvaPares", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbEvaPares = :ccbEvaPares"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbConfPriv", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbConfPriv = :ccbConfPriv"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbFechaProp", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbFechaProp = :ccbFechaProp"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbFechaRevision", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbFechaRevision = :ccbFechaRevision"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbResumen", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbUrl", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIdProdInt", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIdProdInt = :ccbIdProdInt"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIdContribu", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIdContribu = :ccbIdContribu"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdCountry", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByStdIdGeoDiv1", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.stdIdGeoDiv1 = :stdIdGeoDiv1"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbIdEstPub", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbIdEstPub = :ccbIdEstPub"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByIdApprole", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByIdSecuser", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvEdicionR.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvEdicionR m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvEdicionR implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvEdicionRPK m4ccbCvEdicionRPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_EDIC")
    private String ccbOtroEdic;
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
    @Column(name = "CBB_ENT_PATR")
    private String cbbEntPatr;
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
    @Column(name = "CCB_ID_CONTRIBU")
    private String ccbIdContribu;
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
    @Column(name = "STD_ID_GEO_DIV1")
    private String stdIdGeoDiv1;
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

    public M4ccbCvEdicionR() {
    }

    public M4ccbCvEdicionR(M4ccbCvEdicionRPK m4ccbCvEdicionRPK) {
        this.m4ccbCvEdicionRPK = m4ccbCvEdicionRPK;
    }

    public M4ccbCvEdicionR(String idOrganization, short ccbOrEdicRev, String stdIdHr) {
        this.m4ccbCvEdicionRPK = new M4ccbCvEdicionRPK(idOrganization, ccbOrEdicRev, stdIdHr);
    }

    public M4ccbCvEdicionRPK getM4ccbCvEdicionRPK() {
        return m4ccbCvEdicionRPK;
    }

    public void setM4ccbCvEdicionRPK(M4ccbCvEdicionRPK m4ccbCvEdicionRPK) {
        this.m4ccbCvEdicionRPK = m4ccbCvEdicionRPK;
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

    public String getCcbOtroEdic() {
        return ccbOtroEdic;
    }

    public void setCcbOtroEdic(String ccbOtroEdic) {
        this.ccbOtroEdic = ccbOtroEdic;
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

    public String getCbbEntPatr() {
        return cbbEntPatr;
    }

    public void setCbbEntPatr(String cbbEntPatr) {
        this.cbbEntPatr = cbbEntPatr;
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

    public String getCcbIdContribu() {
        return ccbIdContribu;
    }

    public void setCcbIdContribu(String ccbIdContribu) {
        this.ccbIdContribu = ccbIdContribu;
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

    public String getStdIdGeoDiv1() {
        return stdIdGeoDiv1;
    }

    public void setStdIdGeoDiv1(String stdIdGeoDiv1) {
        this.stdIdGeoDiv1 = stdIdGeoDiv1;
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
        hash += (m4ccbCvEdicionRPK != null ? m4ccbCvEdicionRPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvEdicionR)) {
            return false;
        }
        M4ccbCvEdicionR other = (M4ccbCvEdicionR) object;
        if ((this.m4ccbCvEdicionRPK == null && other.m4ccbCvEdicionRPK != null) || (this.m4ccbCvEdicionRPK != null && !this.m4ccbCvEdicionRPK.equals(other.m4ccbCvEdicionRPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvEdicionR[ m4ccbCvEdicionRPK=" + m4ccbCvEdicionRPK + " ]";
    }
    
}
