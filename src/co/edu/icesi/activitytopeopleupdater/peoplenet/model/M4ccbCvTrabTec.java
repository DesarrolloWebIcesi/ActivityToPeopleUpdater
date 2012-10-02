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
@Table(name = "M4CCB_CV_TRAB_TEC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvTrabTec.findAll", query = "SELECT m FROM M4ccbCvTrabTec m"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByIdOrganization", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.m4ccbCvTrabTecPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByCcbIdTrabTec", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.m4ccbCvTrabTecPK.ccbIdTrabTec = :ccbIdTrabTec"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByCcbNomTrabTec", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.ccbNomTrabTec = :ccbNomTrabTec"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByCcbNomActivTrabt", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.ccbNomActivTrabt = :ccbNomActivTrabt"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByCcbObservacion", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.ccbObservacion = :ccbObservacion"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByIdApprole", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByIdSecuser", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvTrabTec.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvTrabTec m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvTrabTec implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvTrabTecPK m4ccbCvTrabTecPK;
    @Column(name = "CCB_NOM_TRAB_TEC")
    private String ccbNomTrabTec;
    @Column(name = "CCB_NOM_ACTIV_TRABT")
    private String ccbNomActivTrabt;
    @Column(name = "CCB_OBSERVACION")
    private String ccbObservacion;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvTrabTec() {
    }

    public M4ccbCvTrabTec(M4ccbCvTrabTecPK m4ccbCvTrabTecPK) {
        this.m4ccbCvTrabTecPK = m4ccbCvTrabTecPK;
    }

    public M4ccbCvTrabTec(String idOrganization, String ccbIdTrabTec) {
        this.m4ccbCvTrabTecPK = new M4ccbCvTrabTecPK(idOrganization, ccbIdTrabTec);
    }

    public M4ccbCvTrabTecPK getM4ccbCvTrabTecPK() {
        return m4ccbCvTrabTecPK;
    }

    public void setM4ccbCvTrabTecPK(M4ccbCvTrabTecPK m4ccbCvTrabTecPK) {
        this.m4ccbCvTrabTecPK = m4ccbCvTrabTecPK;
    }

    public String getCcbNomTrabTec() {
        return ccbNomTrabTec;
    }

    public void setCcbNomTrabTec(String ccbNomTrabTec) {
        this.ccbNomTrabTec = ccbNomTrabTec;
    }

    public String getCcbNomActivTrabt() {
        return ccbNomActivTrabt;
    }

    public void setCcbNomActivTrabt(String ccbNomActivTrabt) {
        this.ccbNomActivTrabt = ccbNomActivTrabt;
    }

    public String getCcbObservacion() {
        return ccbObservacion;
    }

    public void setCcbObservacion(String ccbObservacion) {
        this.ccbObservacion = ccbObservacion;
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
        hash += (m4ccbCvTrabTecPK != null ? m4ccbCvTrabTecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvTrabTec)) {
            return false;
        }
        M4ccbCvTrabTec other = (M4ccbCvTrabTec) object;
        if ((this.m4ccbCvTrabTecPK == null && other.m4ccbCvTrabTecPK != null) || (this.m4ccbCvTrabTecPK != null && !this.m4ccbCvTrabTecPK.equals(other.m4ccbCvTrabTecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTec[ m4ccbCvTrabTecPK=" + m4ccbCvTrabTecPK + " ]";
    }
    
}
