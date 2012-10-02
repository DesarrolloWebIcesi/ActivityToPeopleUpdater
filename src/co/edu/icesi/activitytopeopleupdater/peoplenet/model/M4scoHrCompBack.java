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
@Table(name = "M4SCO_HR_COMP_BACK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scoHrCompBack.findAll", query = "SELECT m FROM M4scoHrCompBack m"),
    @NamedQuery(name = "M4scoHrCompBack.findByIdOrganization", query = "SELECT m FROM M4scoHrCompBack m WHERE m.m4scoHrCompBackPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scoHrCompBack.findByStdIdHr", query = "SELECT m FROM M4scoHrCompBack m WHERE m.m4scoHrCompBackPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoOrCompBg", query = "SELECT m FROM M4scoHrCompBack m WHERE m.m4scoHrCompBackPK.scoOrCompBg = :scoOrCompBg"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoNCourse", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoNCourse = :scoNCourse"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoDtStart", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoDtStart = :scoDtStart"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoDtEnd", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoDtEnd = :scoDtEnd"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoNumberHours", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoNumberHours = :scoNumberHours"),
    @NamedQuery(name = "M4scoHrCompBack.findByStdIdCountry", query = "SELECT m FROM M4scoHrCompBack m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoNCenter", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoNCenter = :scoNCenter"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoGrants", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoGrants = :scoGrants"),
    @NamedQuery(name = "M4scoHrCompBack.findByScoComment", query = "SELECT m FROM M4scoHrCompBack m WHERE m.scoComment = :scoComment"),
    @NamedQuery(name = "M4scoHrCompBack.findByCcbIdActividad", query = "SELECT m FROM M4scoHrCompBack m WHERE m.ccbIdActividad = :ccbIdActividad"),
    @NamedQuery(name = "M4scoHrCompBack.findByCcbTipoAcad", query = "SELECT m FROM M4scoHrCompBack m WHERE m.ccbTipoAcad = :ccbTipoAcad"),
    @NamedQuery(name = "M4scoHrCompBack.findByCcbOtroCurs", query = "SELECT m FROM M4scoHrCompBack m WHERE m.ccbOtroCurs = :ccbOtroCurs"),
    @NamedQuery(name = "M4scoHrCompBack.findByCcbDescription", query = "SELECT m FROM M4scoHrCompBack m WHERE m.ccbDescription = :ccbDescription"),
    @NamedQuery(name = "M4scoHrCompBack.findByStdIdGeoDiv", query = "SELECT m FROM M4scoHrCompBack m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4scoHrCompBack.findByStdIdSubGeoDiv", query = "SELECT m FROM M4scoHrCompBack m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4scoHrCompBack.findByStdIdGeoPlace", query = "SELECT m FROM M4scoHrCompBack m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4scoHrCompBack.findByDtStart", query = "SELECT m FROM M4scoHrCompBack m WHERE m.dtStart = :dtStart"),
    @NamedQuery(name = "M4scoHrCompBack.findByDtEnd", query = "SELECT m FROM M4scoHrCompBack m WHERE m.dtEnd = :dtEnd"),
    @NamedQuery(name = "M4scoHrCompBack.findByCcbCargueAct", query = "SELECT m FROM M4scoHrCompBack m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4scoHrCompBack.findByIdApprole", query = "SELECT m FROM M4scoHrCompBack m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4scoHrCompBack.findByIdSecuser", query = "SELECT m FROM M4scoHrCompBack m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scoHrCompBack.findByDtLastUpdate", query = "SELECT m FROM M4scoHrCompBack m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4scoHrCompBack implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scoHrCompBackPK m4scoHrCompBackPK;
    @Column(name = "SCO_N_COURSE")
    private String scoNCourse;
    @Column(name = "SCO_DT_START")
    @Temporal(TemporalType.DATE)
    private Date scoDtStart;
    @Column(name = "SCO_DT_END")
    @Temporal(TemporalType.DATE)
    private Date scoDtEnd;
    @Column(name = "SCO_NUMBER_HOURS")
    private Short scoNumberHours;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "SCO_N_CENTER")
    private String scoNCenter;
    @Column(name = "SCO_GRANTS")
    private String scoGrants;
    @Column(name = "SCO_COMMENT")
    private String scoComment;
    @Column(name = "CCB_ID_ACTIVIDAD")
    private String ccbIdActividad;
    @Column(name = "CCB_TIPO_ACAD")
    private String ccbTipoAcad;
    @Column(name = "CCB_OTRO_CURS")
    private String ccbOtroCurs;
    @Column(name = "CCB_DESCRIPTION")
    private String ccbDescription;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "DT_START")
    @Temporal(TemporalType.DATE)
    private Date dtStart;
    @Column(name = "DT_END")
    @Temporal(TemporalType.DATE)
    private Date dtEnd;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4scoHrCompBack() {
    }

    public M4scoHrCompBack(M4scoHrCompBackPK m4scoHrCompBackPK) {
        this.m4scoHrCompBackPK = m4scoHrCompBackPK;
    }

    public M4scoHrCompBack(String idOrganization, String stdIdHr, short scoOrCompBg) {
        this.m4scoHrCompBackPK = new M4scoHrCompBackPK(idOrganization, stdIdHr, scoOrCompBg);
    }

    public M4scoHrCompBackPK getM4scoHrCompBackPK() {
        return m4scoHrCompBackPK;
    }

    public void setM4scoHrCompBackPK(M4scoHrCompBackPK m4scoHrCompBackPK) {
        this.m4scoHrCompBackPK = m4scoHrCompBackPK;
    }

    public String getScoNCourse() {
        return scoNCourse;
    }

    public void setScoNCourse(String scoNCourse) {
        this.scoNCourse = scoNCourse;
    }

    public Date getScoDtStart() {
        return scoDtStart;
    }

    public void setScoDtStart(Date scoDtStart) {
        this.scoDtStart = scoDtStart;
    }

    public Date getScoDtEnd() {
        return scoDtEnd;
    }

    public void setScoDtEnd(Date scoDtEnd) {
        this.scoDtEnd = scoDtEnd;
    }

    public Short getScoNumberHours() {
        return scoNumberHours;
    }

    public void setScoNumberHours(Short scoNumberHours) {
        this.scoNumberHours = scoNumberHours;
    }

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
    }

    public String getScoNCenter() {
        return scoNCenter;
    }

    public void setScoNCenter(String scoNCenter) {
        this.scoNCenter = scoNCenter;
    }

    public String getScoGrants() {
        return scoGrants;
    }

    public void setScoGrants(String scoGrants) {
        this.scoGrants = scoGrants;
    }

    public String getScoComment() {
        return scoComment;
    }

    public void setScoComment(String scoComment) {
        this.scoComment = scoComment;
    }

    public String getCcbIdActividad() {
        return ccbIdActividad;
    }

    public void setCcbIdActividad(String ccbIdActividad) {
        this.ccbIdActividad = ccbIdActividad;
    }

    public String getCcbTipoAcad() {
        return ccbTipoAcad;
    }

    public void setCcbTipoAcad(String ccbTipoAcad) {
        this.ccbTipoAcad = ccbTipoAcad;
    }

    public String getCcbOtroCurs() {
        return ccbOtroCurs;
    }

    public void setCcbOtroCurs(String ccbOtroCurs) {
        this.ccbOtroCurs = ccbOtroCurs;
    }

    public String getCcbDescription() {
        return ccbDescription;
    }

    public void setCcbDescription(String ccbDescription) {
        this.ccbDescription = ccbDescription;
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
        hash += (m4scoHrCompBackPK != null ? m4scoHrCompBackPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoHrCompBack)) {
            return false;
        }
        M4scoHrCompBack other = (M4scoHrCompBack) object;
        if ((this.m4scoHrCompBackPK == null && other.m4scoHrCompBackPK != null) || (this.m4scoHrCompBackPK != null && !this.m4scoHrCompBackPK.equals(other.m4scoHrCompBackPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoHrCompBack[ m4scoHrCompBackPK=" + m4scoHrCompBackPK + " ]";
    }
    
}
