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
@Table(name = "M4CCB_CV_JUR_COM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvJurCom.findAll", query = "SELECT m FROM M4ccbCvJurCom m"),
    @NamedQuery(name = "M4ccbCvJurCom.findByIdOrganization", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.m4ccbCvJurComPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbOrJurCom", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.m4ccbCvJurComPK.ccbOrJurCom = :ccbOrJurCom"),
    @NamedQuery(name = "M4ccbCvJurCom.findByStdIdHr", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.m4ccbCvJurComPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbDtStart", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbDtStart = :ccbDtStart"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbDtEnd", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbDtEnd = :ccbDtEnd"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbOtrInvoluc", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbOtrInvoluc = :ccbOtrInvoluc"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbInstitucion", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbInstitucion = :ccbInstitucion"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbPrograma", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbPrograma = :ccbPrograma"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbNomEstud", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbNomEstud = :ccbNomEstud"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbTituloProy", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbTituloProy = :ccbTituloProy"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbComentarios", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbComentarios = :ccbComentarios"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbUrl", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvJurCom.findByStdIdCountry", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvJurCom.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvJurCom.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbIdOrientacion", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbIdOrientacion = :ccbIdOrientacion"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbIdEstadoAct", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbIdEstadoAct = :ccbIdEstadoAct"),
    @NamedQuery(name = "M4ccbCvJurCom.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvJurCom.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvJurCom.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvJurCom.findByIdApprole", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvJurCom.findByIdSecuser", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvJurCom.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvJurCom m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvJurCom implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvJurComPK m4ccbCvJurComPK;
    @Column(name = "CCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date ccbDtStart;
    @Column(name = "CCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnd;
    @Column(name = "CCB_OTR_INVOLUC")
    private String ccbOtrInvoluc;
    @Column(name = "CCB_INSTITUCION")
    private String ccbInstitucion;
    @Column(name = "CCB_PROGRAMA")
    private String ccbPrograma;
    @Column(name = "CCB_NOM_ESTUD")
    private String ccbNomEstud;
    @Column(name = "CCB_TITULO_PROY")
    private String ccbTituloProy;
    @Column(name = "CCB_COMENTARIOS")
    private String ccbComentarios;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "CCB_ID_ORIENTACION")
    private String ccbIdOrientacion;
    @Column(name = "CCB_ID_ESTADO_ACT")
    private String ccbIdEstadoAct;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
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

    public M4ccbCvJurCom() {
    }

    public M4ccbCvJurCom(M4ccbCvJurComPK m4ccbCvJurComPK) {
        this.m4ccbCvJurComPK = m4ccbCvJurComPK;
    }

    public M4ccbCvJurCom(String idOrganization, short ccbOrJurCom, String stdIdHr) {
        this.m4ccbCvJurComPK = new M4ccbCvJurComPK(idOrganization, ccbOrJurCom, stdIdHr);
    }

    public M4ccbCvJurComPK getM4ccbCvJurComPK() {
        return m4ccbCvJurComPK;
    }

    public void setM4ccbCvJurComPK(M4ccbCvJurComPK m4ccbCvJurComPK) {
        this.m4ccbCvJurComPK = m4ccbCvJurComPK;
    }

    public Date getCcbDtStart() {
        return ccbDtStart;
    }

    public void setCcbDtStart(Date ccbDtStart) {
        this.ccbDtStart = ccbDtStart;
    }

    public Date getCcbDtEnd() {
        return ccbDtEnd;
    }

    public void setCcbDtEnd(Date ccbDtEnd) {
        this.ccbDtEnd = ccbDtEnd;
    }

    public String getCcbOtrInvoluc() {
        return ccbOtrInvoluc;
    }

    public void setCcbOtrInvoluc(String ccbOtrInvoluc) {
        this.ccbOtrInvoluc = ccbOtrInvoluc;
    }

    public String getCcbInstitucion() {
        return ccbInstitucion;
    }

    public void setCcbInstitucion(String ccbInstitucion) {
        this.ccbInstitucion = ccbInstitucion;
    }

    public String getCcbPrograma() {
        return ccbPrograma;
    }

    public void setCcbPrograma(String ccbPrograma) {
        this.ccbPrograma = ccbPrograma;
    }

    public String getCcbNomEstud() {
        return ccbNomEstud;
    }

    public void setCcbNomEstud(String ccbNomEstud) {
        this.ccbNomEstud = ccbNomEstud;
    }

    public String getCcbTituloProy() {
        return ccbTituloProy;
    }

    public void setCcbTituloProy(String ccbTituloProy) {
        this.ccbTituloProy = ccbTituloProy;
    }

    public String getCcbComentarios() {
        return ccbComentarios;
    }

    public void setCcbComentarios(String ccbComentarios) {
        this.ccbComentarios = ccbComentarios;
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

    public String getCcbIdOrientacion() {
        return ccbIdOrientacion;
    }

    public void setCcbIdOrientacion(String ccbIdOrientacion) {
        this.ccbIdOrientacion = ccbIdOrientacion;
    }

    public String getCcbIdEstadoAct() {
        return ccbIdEstadoAct;
    }

    public void setCcbIdEstadoAct(String ccbIdEstadoAct) {
        this.ccbIdEstadoAct = ccbIdEstadoAct;
    }

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
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
        hash += (m4ccbCvJurComPK != null ? m4ccbCvJurComPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvJurCom)) {
            return false;
        }
        M4ccbCvJurCom other = (M4ccbCvJurCom) object;
        if ((this.m4ccbCvJurComPK == null && other.m4ccbCvJurComPK != null) || (this.m4ccbCvJurComPK != null && !this.m4ccbCvJurComPK.equals(other.m4ccbCvJurComPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurCom[ m4ccbCvJurComPK=" + m4ccbCvJurComPK + " ]";
    }
    
}
