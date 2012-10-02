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
@Table(name = "M4CCB_CV_EXP_DOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvExpDoc.findAll", query = "SELECT m FROM M4ccbCvExpDoc m"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByIdOrganization", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.m4ccbCvExpDocPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbOrExpDoc", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.m4ccbCvExpDocPK.ccbOrExpDoc = :ccbOrExpDoc"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByStdIdHr", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.m4ccbCvExpDocPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByDtStart", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.dtStart = :dtStart"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByDtEnd", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.dtEnd = :dtEnd"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbFacultad", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbFacultad = :ccbFacultad"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbPrograma", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbPrograma = :ccbPrograma"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbDepartamento", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbDepartamento = :ccbDepartamento"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbActivCarg", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbActivCarg = :ccbActivCarg"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbPeriodo", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbPeriodo = :ccbPeriodo"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbConsecPerd", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbConsecPerd = :ccbConsecPerd"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbDescripAct", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbDescripAct = :ccbDescripAct"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbIdNivel", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbIdNivel = :ccbIdNivel"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByScoIdEducCenter", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.scoIdEducCenter = :scoIdEducCenter"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByStdIdCountry", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByIdApprole", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByIdSecuser", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvExpDoc.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvExpDoc m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvExpDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvExpDocPK m4ccbCvExpDocPK;
    @Column(name = "DT_START")
    @Temporal(TemporalType.DATE)
    private Date dtStart;
    @Column(name = "DT_END")
    @Temporal(TemporalType.DATE)
    private Date dtEnd;
    @Column(name = "CCB_FACULTAD")
    private String ccbFacultad;
    @Column(name = "CCB_PROGRAMA")
    private String ccbPrograma;
    @Column(name = "CCB_DEPARTAMENTO")
    private String ccbDepartamento;
    @Column(name = "CCB_ACTIV_CARG")
    private String ccbActivCarg;
    @Column(name = "CCB_PERIODO")
    private String ccbPeriodo;
    @Column(name = "CCB_CONSEC_PERD")
    private String ccbConsecPerd;
    @Column(name = "CCB_DESCRIP_ACT")
    private String ccbDescripAct;
    @Column(name = "CCB_ID_NIVEL")
    private String ccbIdNivel;
    @Column(name = "SCO_ID_EDUC_CENTER")
    private String scoIdEducCenter;
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

    public M4ccbCvExpDoc() {
    }

    public M4ccbCvExpDoc(M4ccbCvExpDocPK m4ccbCvExpDocPK) {
        this.m4ccbCvExpDocPK = m4ccbCvExpDocPK;
    }

    public M4ccbCvExpDoc(String idOrganization, short ccbOrExpDoc, String stdIdHr) {
        this.m4ccbCvExpDocPK = new M4ccbCvExpDocPK(idOrganization, ccbOrExpDoc, stdIdHr);
    }

    public M4ccbCvExpDocPK getM4ccbCvExpDocPK() {
        return m4ccbCvExpDocPK;
    }

    public void setM4ccbCvExpDocPK(M4ccbCvExpDocPK m4ccbCvExpDocPK) {
        this.m4ccbCvExpDocPK = m4ccbCvExpDocPK;
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getCcbFacultad() {
        return ccbFacultad;
    }

    public void setCcbFacultad(String ccbFacultad) {
        this.ccbFacultad = ccbFacultad;
    }

    public String getCcbPrograma() {
        return ccbPrograma;
    }

    public void setCcbPrograma(String ccbPrograma) {
        this.ccbPrograma = ccbPrograma;
    }

    public String getCcbDepartamento() {
        return ccbDepartamento;
    }

    public void setCcbDepartamento(String ccbDepartamento) {
        this.ccbDepartamento = ccbDepartamento;
    }

    public String getCcbActivCarg() {
        return ccbActivCarg;
    }

    public void setCcbActivCarg(String ccbActivCarg) {
        this.ccbActivCarg = ccbActivCarg;
    }

    public String getCcbPeriodo() {
        return ccbPeriodo;
    }

    public void setCcbPeriodo(String ccbPeriodo) {
        this.ccbPeriodo = ccbPeriodo;
    }

    public String getCcbConsecPerd() {
        return ccbConsecPerd;
    }

    public void setCcbConsecPerd(String ccbConsecPerd) {
        this.ccbConsecPerd = ccbConsecPerd;
    }

    public String getCcbDescripAct() {
        return ccbDescripAct;
    }

    public void setCcbDescripAct(String ccbDescripAct) {
        this.ccbDescripAct = ccbDescripAct;
    }

    public String getCcbIdNivel() {
        return ccbIdNivel;
    }

    public void setCcbIdNivel(String ccbIdNivel) {
        this.ccbIdNivel = ccbIdNivel;
    }

    public String getScoIdEducCenter() {
        return scoIdEducCenter;
    }

    public void setScoIdEducCenter(String scoIdEducCenter) {
        this.scoIdEducCenter = scoIdEducCenter;
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
        hash += (m4ccbCvExpDocPK != null ? m4ccbCvExpDocPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvExpDoc)) {
            return false;
        }
        M4ccbCvExpDoc other = (M4ccbCvExpDoc) object;
        if ((this.m4ccbCvExpDocPK == null && other.m4ccbCvExpDocPK != null) || (this.m4ccbCvExpDocPK != null && !this.m4ccbCvExpDocPK.equals(other.m4ccbCvExpDocPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvExpDoc[ m4ccbCvExpDocPK=" + m4ccbCvExpDocPK + " ]";
    }
    
}
