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
@Table(name = "M4CCB_CV_PRESENTAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvPresentac.findAll", query = "SELECT m FROM M4ccbCvPresentac m"),
    @NamedQuery(name = "M4ccbCvPresentac.findByIdOrganization", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.m4ccbCvPresentacPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbOrProdDiv", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.m4ccbCvPresentacPK.ccbOrProdDiv = :ccbOrProdDiv"),
    @NamedQuery(name = "M4ccbCvPresentac.findByStdIdHr", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.m4ccbCvPresentacPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbOtroEnc", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbOtroEnc = :ccbOtroEnc"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbNomEven", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbNomEven = :ccbNomEven"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbInstOrg", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbInstOrg = :ccbInstOrg"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbNomPresnt", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbNomPresnt = :ccbNomPresnt"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbCoautores", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbRol", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbRol = :ccbRol"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbTipoAcad", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbTipoAcad = :ccbTipoAcad"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbEvaPar", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbEvaPar = :ccbEvaPar"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbInvitado", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbInvitado = :ccbInvitado"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbFechaPrest", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbFechaPrest = :ccbFechaPrest"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbFechaPub", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbFechaPub = :ccbFechaPub"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbPubMemor", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbPubMemor = :ccbPubMemor"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbPubOtroMed", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbPubOtroMed = :ccbPubOtroMed"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbMemoriaComp", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbMemoriaComp = :ccbMemoriaComp"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbNomProd", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbOtroMed", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbOtroMed = :ccbOtroMed"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbNomPubl", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbNomPubl = :ccbNomPubl"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIsbn", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIsbn = :ccbIsbn"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbVolumen", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbVolumen = :ccbVolumen"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbFasciculo", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbFasciculo = :ccbFasciculo"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbNumPag", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbNumPag = :ccbNumPag"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbResumen", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbUrl", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvPresentac.findByStdIdCountry", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIdPresent", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIdPresent = :ccbIdPresent"),
    @NamedQuery(name = "M4ccbCvPresentac.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvPresentac.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvPresentac.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvPresentac.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIdEvento", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIdEvento = :ccbIdEvento"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbIdMetDivul", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbIdMetDivul = :ccbIdMetDivul"),
    @NamedQuery(name = "M4ccbCvPresentac.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvPresentac.findByIdApprole", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvPresentac.findByIdSecuser", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvPresentac.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvPresentac m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvPresentac implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvPresentacPK m4ccbCvPresentacPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_ENC")
    private String ccbOtroEnc;
    @Column(name = "CCB_NOM_EVEN")
    private String ccbNomEven;
    @Column(name = "CCB_INST_ORG")
    private String ccbInstOrg;
    @Column(name = "CCB_NOM_PRESNT")
    private String ccbNomPresnt;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_ROL")
    private String ccbRol;
    @Column(name = "CCB_TIPO_ACAD")
    private String ccbTipoAcad;
    @Column(name = "CCB_EVA_PAR")
    private String ccbEvaPar;
    @Column(name = "CCB_INVITADO")
    private String ccbInvitado;
    @Column(name = "CCB_FECHA_PREST")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPrest;
    @Column(name = "CCB_FECHA_PUB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPub;
    @Column(name = "CCB_PUB_MEMOR")
    private String ccbPubMemor;
    @Column(name = "CCB_PUB_OTRO_MED")
    private String ccbPubOtroMed;
    @Column(name = "CCB_MEMORIA_COMP")
    private String ccbMemoriaComp;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_OTRO_MED")
    private String ccbOtroMed;
    @Column(name = "CCB_NOM_PUBL")
    private String ccbNomPubl;
    @Column(name = "CCB_ISBN")
    private String ccbIsbn;
    @Column(name = "CCB_VOLUMEN")
    private String ccbVolumen;
    @Column(name = "CCB_FASCICULO")
    private String ccbFasciculo;
    @Column(name = "CCB_NUM_PAG")
    private String ccbNumPag;
    @Column(name = "CCB_RESUMEN")
    private String ccbResumen;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "CCB_ID_PRESENT")
    private String ccbIdPresent;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_EVENTO")
    private String ccbIdEvento;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "CCB_ID_MET_DIVUL")
    private String ccbIdMetDivul;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvPresentac() {
    }

    public M4ccbCvPresentac(M4ccbCvPresentacPK m4ccbCvPresentacPK) {
        this.m4ccbCvPresentacPK = m4ccbCvPresentacPK;
    }

    public M4ccbCvPresentac(String idOrganization, short ccbOrProdDiv, String stdIdHr) {
        this.m4ccbCvPresentacPK = new M4ccbCvPresentacPK(idOrganization, ccbOrProdDiv, stdIdHr);
    }

    public M4ccbCvPresentacPK getM4ccbCvPresentacPK() {
        return m4ccbCvPresentacPK;
    }

    public void setM4ccbCvPresentacPK(M4ccbCvPresentacPK m4ccbCvPresentacPK) {
        this.m4ccbCvPresentacPK = m4ccbCvPresentacPK;
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

    public String getCcbOtroEnc() {
        return ccbOtroEnc;
    }

    public void setCcbOtroEnc(String ccbOtroEnc) {
        this.ccbOtroEnc = ccbOtroEnc;
    }

    public String getCcbNomEven() {
        return ccbNomEven;
    }

    public void setCcbNomEven(String ccbNomEven) {
        this.ccbNomEven = ccbNomEven;
    }

    public String getCcbInstOrg() {
        return ccbInstOrg;
    }

    public void setCcbInstOrg(String ccbInstOrg) {
        this.ccbInstOrg = ccbInstOrg;
    }

    public String getCcbNomPresnt() {
        return ccbNomPresnt;
    }

    public void setCcbNomPresnt(String ccbNomPresnt) {
        this.ccbNomPresnt = ccbNomPresnt;
    }

    public String getCcbCoautores() {
        return ccbCoautores;
    }

    public void setCcbCoautores(String ccbCoautores) {
        this.ccbCoautores = ccbCoautores;
    }

    public String getCcbRol() {
        return ccbRol;
    }

    public void setCcbRol(String ccbRol) {
        this.ccbRol = ccbRol;
    }

    public String getCcbTipoAcad() {
        return ccbTipoAcad;
    }

    public void setCcbTipoAcad(String ccbTipoAcad) {
        this.ccbTipoAcad = ccbTipoAcad;
    }

    public String getCcbEvaPar() {
        return ccbEvaPar;
    }

    public void setCcbEvaPar(String ccbEvaPar) {
        this.ccbEvaPar = ccbEvaPar;
    }

    public String getCcbInvitado() {
        return ccbInvitado;
    }

    public void setCcbInvitado(String ccbInvitado) {
        this.ccbInvitado = ccbInvitado;
    }

    public Date getCcbFechaPrest() {
        return ccbFechaPrest;
    }

    public void setCcbFechaPrest(Date ccbFechaPrest) {
        this.ccbFechaPrest = ccbFechaPrest;
    }

    public Date getCcbFechaPub() {
        return ccbFechaPub;
    }

    public void setCcbFechaPub(Date ccbFechaPub) {
        this.ccbFechaPub = ccbFechaPub;
    }

    public String getCcbPubMemor() {
        return ccbPubMemor;
    }

    public void setCcbPubMemor(String ccbPubMemor) {
        this.ccbPubMemor = ccbPubMemor;
    }

    public String getCcbPubOtroMed() {
        return ccbPubOtroMed;
    }

    public void setCcbPubOtroMed(String ccbPubOtroMed) {
        this.ccbPubOtroMed = ccbPubOtroMed;
    }

    public String getCcbMemoriaComp() {
        return ccbMemoriaComp;
    }

    public void setCcbMemoriaComp(String ccbMemoriaComp) {
        this.ccbMemoriaComp = ccbMemoriaComp;
    }

    public String getCcbNomProd() {
        return ccbNomProd;
    }

    public void setCcbNomProd(String ccbNomProd) {
        this.ccbNomProd = ccbNomProd;
    }

    public String getCcbOtroMed() {
        return ccbOtroMed;
    }

    public void setCcbOtroMed(String ccbOtroMed) {
        this.ccbOtroMed = ccbOtroMed;
    }

    public String getCcbNomPubl() {
        return ccbNomPubl;
    }

    public void setCcbNomPubl(String ccbNomPubl) {
        this.ccbNomPubl = ccbNomPubl;
    }

    public String getCcbIsbn() {
        return ccbIsbn;
    }

    public void setCcbIsbn(String ccbIsbn) {
        this.ccbIsbn = ccbIsbn;
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

    public String getCcbIdPresent() {
        return ccbIdPresent;
    }

    public void setCcbIdPresent(String ccbIdPresent) {
        this.ccbIdPresent = ccbIdPresent;
    }

    public String getStdIdGeoDiv() {
        return stdIdGeoDiv;
    }

    public void setStdIdGeoDiv(String stdIdGeoDiv) {
        this.stdIdGeoDiv = stdIdGeoDiv;
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

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
    }

    public String getCcbIdEvento() {
        return ccbIdEvento;
    }

    public void setCcbIdEvento(String ccbIdEvento) {
        this.ccbIdEvento = ccbIdEvento;
    }

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
    }

    public String getCcbIdMetDivul() {
        return ccbIdMetDivul;
    }

    public void setCcbIdMetDivul(String ccbIdMetDivul) {
        this.ccbIdMetDivul = ccbIdMetDivul;
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
        hash += (m4ccbCvPresentacPK != null ? m4ccbCvPresentacPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvPresentac)) {
            return false;
        }
        M4ccbCvPresentac other = (M4ccbCvPresentac) object;
        if ((this.m4ccbCvPresentacPK == null && other.m4ccbCvPresentacPK != null) || (this.m4ccbCvPresentacPK != null && !this.m4ccbCvPresentacPK.equals(other.m4ccbCvPresentacPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvPresentac[ m4ccbCvPresentacPK=" + m4ccbCvPresentacPK + " ]";
    }
    
}
