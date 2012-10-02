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
@Table(name = "M4CCB_CV_PROD_TEC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvProdTec.findAll", query = "SELECT m FROM M4ccbCvProdTec m"),
    @NamedQuery(name = "M4ccbCvProdTec.findByIdOrganization", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.m4ccbCvProdTecPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbOrProdTec", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.m4ccbCvProdTecPK.ccbOrProdTec = :ccbOrProdTec"),
    @NamedQuery(name = "M4ccbCvProdTec.findByStdIdHr", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.m4ccbCvProdTecPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbPatente", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbPatente = :ccbPatente"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbDerAut", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbDerAut = :ccbDerAut"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbOtroTipProd", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbOtroTipProd = :ccbOtroTipProd"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbNomProd", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbNomProd = :ccbNomProd"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbCoautores", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbDispRest", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbDispRest = :ccbDispRest"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbEntPatro", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbEntPatro = :ccbEntPatro"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbContReg", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbContReg = :ccbContReg"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbInstCert", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbInstCert = :ccbInstCert"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbListNac", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbListNac = :ccbListNac"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbLicPrincip", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbLicPrincip = :ccbLicPrincip"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbPosDerec", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbPosDerec = :ccbPosDerec"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbFechaPresent", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbFechaPresent = :ccbFechaPresent"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbFechaSolic", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbFechaSolic = :ccbFechaSolic"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbFechaPatente", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbFechaPatente = :ccbFechaPatente"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbFechaRenov", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbFechaRenov = :ccbFechaRenov"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbFinalidad", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbFinalidad = :ccbFinalidad"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbResumen", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbResumen = :ccbResumen"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbUrl", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvProdTec.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbIdProduc", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbIdProduc = :ccbIdProduc"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvProdTec.findByStdIdCountry", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbIdNacPatent", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbIdNacPatent = :ccbIdNacPatent"),
    @NamedQuery(name = "M4ccbCvProdTec.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvProdTec.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvProdTec.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvProdTec.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvProdTec.findByIdApprole", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvProdTec.findByIdSecuser", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvProdTec.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvProdTec m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvProdTec implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvProdTecPK m4ccbCvProdTecPK;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_PATENTE")
    private String ccbPatente;
    @Column(name = "CCB_DER_AUT")
    private String ccbDerAut;
    @Column(name = "CCB_OTRO_TIP_PROD")
    private String ccbOtroTipProd;
    @Column(name = "CCB_NOM_PROD")
    private String ccbNomProd;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_DISP_REST")
    private String ccbDispRest;
    @Column(name = "CCB_ENT_PATRO")
    private String ccbEntPatro;
    @Column(name = "CCB_CONT_REG")
    private String ccbContReg;
    @Column(name = "CCB_INST_CERT")
    private String ccbInstCert;
    @Column(name = "CCB_LIST_NAC")
    private String ccbListNac;
    @Column(name = "CCB_LIC_PRINCIP")
    private String ccbLicPrincip;
    @Column(name = "CCB_POS_DEREC")
    private String ccbPosDerec;
    @Column(name = "CCB_FECHA_PRESENT")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPresent;
    @Column(name = "CCB_FECHA_SOLIC")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaSolic;
    @Column(name = "CCB_FECHA_APROB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaAprob;
    @Column(name = "CCB_FECHA_PATENTE")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPatente;
    @Column(name = "CCB_FECHA_RENOV")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRenov;
    @Column(name = "CCB_FINALIDAD")
    private String ccbFinalidad;
    @Column(name = "CCB_RESUMEN")
    private String ccbResumen;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_PRODUC")
    private String ccbIdProduc;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "CCB_ID_NAC_PATENT")
    private String ccbIdNacPatent;
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

    public M4ccbCvProdTec() {
    }

    public M4ccbCvProdTec(M4ccbCvProdTecPK m4ccbCvProdTecPK) {
        this.m4ccbCvProdTecPK = m4ccbCvProdTecPK;
    }

    public M4ccbCvProdTec(String idOrganization, short ccbOrProdTec, String stdIdHr) {
        this.m4ccbCvProdTecPK = new M4ccbCvProdTecPK(idOrganization, ccbOrProdTec, stdIdHr);
    }

    public M4ccbCvProdTecPK getM4ccbCvProdTecPK() {
        return m4ccbCvProdTecPK;
    }

    public void setM4ccbCvProdTecPK(M4ccbCvProdTecPK m4ccbCvProdTecPK) {
        this.m4ccbCvProdTecPK = m4ccbCvProdTecPK;
    }

    public String getCcbOtraCat() {
        return ccbOtraCat;
    }

    public void setCcbOtraCat(String ccbOtraCat) {
        this.ccbOtraCat = ccbOtraCat;
    }

    public String getCcbPatente() {
        return ccbPatente;
    }

    public void setCcbPatente(String ccbPatente) {
        this.ccbPatente = ccbPatente;
    }

    public String getCcbDerAut() {
        return ccbDerAut;
    }

    public void setCcbDerAut(String ccbDerAut) {
        this.ccbDerAut = ccbDerAut;
    }

    public String getCcbOtroTipProd() {
        return ccbOtroTipProd;
    }

    public void setCcbOtroTipProd(String ccbOtroTipProd) {
        this.ccbOtroTipProd = ccbOtroTipProd;
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

    public String getCcbDispRest() {
        return ccbDispRest;
    }

    public void setCcbDispRest(String ccbDispRest) {
        this.ccbDispRest = ccbDispRest;
    }

    public String getCcbEntPatro() {
        return ccbEntPatro;
    }

    public void setCcbEntPatro(String ccbEntPatro) {
        this.ccbEntPatro = ccbEntPatro;
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

    public String getCcbListNac() {
        return ccbListNac;
    }

    public void setCcbListNac(String ccbListNac) {
        this.ccbListNac = ccbListNac;
    }

    public String getCcbLicPrincip() {
        return ccbLicPrincip;
    }

    public void setCcbLicPrincip(String ccbLicPrincip) {
        this.ccbLicPrincip = ccbLicPrincip;
    }

    public String getCcbPosDerec() {
        return ccbPosDerec;
    }

    public void setCcbPosDerec(String ccbPosDerec) {
        this.ccbPosDerec = ccbPosDerec;
    }

    public Date getCcbFechaPresent() {
        return ccbFechaPresent;
    }

    public void setCcbFechaPresent(Date ccbFechaPresent) {
        this.ccbFechaPresent = ccbFechaPresent;
    }

    public Date getCcbFechaSolic() {
        return ccbFechaSolic;
    }

    public void setCcbFechaSolic(Date ccbFechaSolic) {
        this.ccbFechaSolic = ccbFechaSolic;
    }

    public Date getCcbFechaAprob() {
        return ccbFechaAprob;
    }

    public void setCcbFechaAprob(Date ccbFechaAprob) {
        this.ccbFechaAprob = ccbFechaAprob;
    }

    public Date getCcbFechaPatente() {
        return ccbFechaPatente;
    }

    public void setCcbFechaPatente(Date ccbFechaPatente) {
        this.ccbFechaPatente = ccbFechaPatente;
    }

    public Date getCcbFechaRenov() {
        return ccbFechaRenov;
    }

    public void setCcbFechaRenov(Date ccbFechaRenov) {
        this.ccbFechaRenov = ccbFechaRenov;
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

    public String getCcbIdNacPatent() {
        return ccbIdNacPatent;
    }

    public void setCcbIdNacPatent(String ccbIdNacPatent) {
        this.ccbIdNacPatent = ccbIdNacPatent;
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
        hash += (m4ccbCvProdTecPK != null ? m4ccbCvProdTecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvProdTec)) {
            return false;
        }
        M4ccbCvProdTec other = (M4ccbCvProdTec) object;
        if ((this.m4ccbCvProdTecPK == null && other.m4ccbCvProdTecPK != null) || (this.m4ccbCvProdTecPK != null && !this.m4ccbCvProdTecPK.equals(other.m4ccbCvProdTecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvProdTec[ m4ccbCvProdTecPK=" + m4ccbCvProdTecPK + " ]";
    }
    
}
