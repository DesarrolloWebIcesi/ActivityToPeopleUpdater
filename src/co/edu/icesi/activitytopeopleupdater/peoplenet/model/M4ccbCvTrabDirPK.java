/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 38555240
 */
@Embeddable
public class M4ccbCvTrabDirPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_ID_TRB_DIR")
    private String ccbIdTrbDir;

    public M4ccbCvTrabDirPK() {
    }

    public M4ccbCvTrabDirPK(String idOrganization, String ccbIdTrbDir) {
        this.idOrganization = idOrganization;
        this.ccbIdTrbDir = ccbIdTrbDir;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getCcbIdTrbDir() {
        return ccbIdTrbDir;
    }

    public void setCcbIdTrbDir(String ccbIdTrbDir) {
        this.ccbIdTrbDir = ccbIdTrbDir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (ccbIdTrbDir != null ? ccbIdTrbDir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvTrabDirPK)) {
            return false;
        }
        M4ccbCvTrabDirPK other = (M4ccbCvTrabDirPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.ccbIdTrbDir == null && other.ccbIdTrbDir != null) || (this.ccbIdTrbDir != null && !this.ccbIdTrbDir.equals(other.ccbIdTrbDir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabDirPK[ idOrganization=" + idOrganization + ", ccbIdTrbDir=" + ccbIdTrbDir + " ]";
    }
    
}
