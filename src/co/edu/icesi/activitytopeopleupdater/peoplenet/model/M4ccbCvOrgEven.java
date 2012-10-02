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
@Table(name = "M4CCB_CV_ORG_EVEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvOrgEven.findAll", query = "SELECT m FROM M4ccbCvOrgEven m"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByIdOrganization", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.m4ccbCvOrgEvenPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbOrOrgEvent", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.m4ccbCvOrgEvenPK.ccbOrOrgEvent = :ccbOrOrgEvent"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByStdIdHr", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.m4ccbCvOrgEvenPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbDtStart", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbDtStart = :ccbDtStart"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbDtEnd", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbDtEnd = :ccbDtEnd"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbOtroEvento", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbOtroEvento = :ccbOtroEvento"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbNomEvento", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbNomEvento = :ccbNomEvento"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbComentarios", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbComentarios = :ccbComentarios"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbUrl", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbIdEvento", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbIdEvento = :ccbIdEvento"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByStdIdCountry", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByIdApprole", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByIdSecuser", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvOrgEven.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvOrgEven m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvOrgEven implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvOrgEvenPK m4ccbCvOrgEvenPK;
    @Column(name = "CCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date ccbDtStart;
    @Column(name = "CCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnd;
    @Column(name = "CCB_OTRO_EVENTO")
    private String ccbOtroEvento;
    @Column(name = "CCB_NOM_EVENTO")
    private String ccbNomEvento;
    @Column(name = "CCB_COMENTARIOS")
    private String ccbComentarios;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_EVENTO")
    private String ccbIdEvento;
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

    public M4ccbCvOrgEven() {
    }

    public M4ccbCvOrgEven(M4ccbCvOrgEvenPK m4ccbCvOrgEvenPK) {
        this.m4ccbCvOrgEvenPK = m4ccbCvOrgEvenPK;
    }

    public M4ccbCvOrgEven(String idOrganization, short ccbOrOrgEvent, String stdIdHr) {
        this.m4ccbCvOrgEvenPK = new M4ccbCvOrgEvenPK(idOrganization, ccbOrOrgEvent, stdIdHr);
    }

    public M4ccbCvOrgEvenPK getM4ccbCvOrgEvenPK() {
        return m4ccbCvOrgEvenPK;
    }

    public void setM4ccbCvOrgEvenPK(M4ccbCvOrgEvenPK m4ccbCvOrgEvenPK) {
        this.m4ccbCvOrgEvenPK = m4ccbCvOrgEvenPK;
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

    public String getCcbOtroEvento() {
        return ccbOtroEvento;
    }

    public void setCcbOtroEvento(String ccbOtroEvento) {
        this.ccbOtroEvento = ccbOtroEvento;
    }

    public String getCcbNomEvento() {
        return ccbNomEvento;
    }

    public void setCcbNomEvento(String ccbNomEvento) {
        this.ccbNomEvento = ccbNomEvento;
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
        hash += (m4ccbCvOrgEvenPK != null ? m4ccbCvOrgEvenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvOrgEven)) {
            return false;
        }
        M4ccbCvOrgEven other = (M4ccbCvOrgEven) object;
        if ((this.m4ccbCvOrgEvenPK == null && other.m4ccbCvOrgEvenPK != null) || (this.m4ccbCvOrgEvenPK != null && !this.m4ccbCvOrgEvenPK.equals(other.m4ccbCvOrgEvenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvOrgEven[ m4ccbCvOrgEvenPK=" + m4ccbCvOrgEvenPK + " ]";
    }
    
}
