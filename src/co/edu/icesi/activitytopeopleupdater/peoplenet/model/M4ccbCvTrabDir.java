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
@Table(name = "M4CCB_CV_TRAB_DIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvTrabDir.findAll", query = "SELECT m FROM M4ccbCvTrabDir m"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByIdOrganization", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.m4ccbCvTrabDirPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByCcbIdTrbDir", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.m4ccbCvTrabDirPK.ccbIdTrbDir = :ccbIdTrbDir"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByCcbNomTdirig", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.ccbNomTdirig = :ccbNomTdirig"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByCcbNomActivTdir", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.ccbNomActivTdir = :ccbNomActivTdir"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByCcbObservacion", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.ccbObservacion = :ccbObservacion"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByIdApprole", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByIdSecuser", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvTrabDir.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvTrabDir m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvTrabDir implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvTrabDirPK m4ccbCvTrabDirPK;
    @Column(name = "CCB_NOM_TDIRIG")
    private String ccbNomTdirig;
    @Column(name = "CCB_NOM_ACTIV_TDIR")
    private String ccbNomActivTdir;
    @Column(name = "CCB_OBSERVACION")
    private String ccbObservacion;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvTrabDir() {
    }

    public M4ccbCvTrabDir(M4ccbCvTrabDirPK m4ccbCvTrabDirPK) {
        this.m4ccbCvTrabDirPK = m4ccbCvTrabDirPK;
    }

    public M4ccbCvTrabDir(String idOrganization, String ccbIdTrbDir) {
        this.m4ccbCvTrabDirPK = new M4ccbCvTrabDirPK(idOrganization, ccbIdTrbDir);
    }

    public M4ccbCvTrabDirPK getM4ccbCvTrabDirPK() {
        return m4ccbCvTrabDirPK;
    }

    public void setM4ccbCvTrabDirPK(M4ccbCvTrabDirPK m4ccbCvTrabDirPK) {
        this.m4ccbCvTrabDirPK = m4ccbCvTrabDirPK;
    }

    public String getCcbNomTdirig() {
        return ccbNomTdirig;
    }

    public void setCcbNomTdirig(String ccbNomTdirig) {
        this.ccbNomTdirig = ccbNomTdirig;
    }

    public String getCcbNomActivTdir() {
        return ccbNomActivTdir;
    }

    public void setCcbNomActivTdir(String ccbNomActivTdir) {
        this.ccbNomActivTdir = ccbNomActivTdir;
    }

    public String getCcbObservacion() {
        return ccbObservacion;
    }

    public void setCcbObservacion(String ccbObservacion) {
        this.ccbObservacion = ccbObservacion;
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
        hash += (m4ccbCvTrabDirPK != null ? m4ccbCvTrabDirPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvTrabDir)) {
            return false;
        }
        M4ccbCvTrabDir other = (M4ccbCvTrabDir) object;
        if ((this.m4ccbCvTrabDirPK == null && other.m4ccbCvTrabDirPK != null) || (this.m4ccbCvTrabDirPK != null && !this.m4ccbCvTrabDirPK.equals(other.m4ccbCvTrabDirPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabDir[ m4ccbCvTrabDirPK=" + m4ccbCvTrabDirPK + " ]";
    }
    
}
