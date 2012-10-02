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
public class M4ccbCvTrabTecPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_ID_TRAB_TEC")
    private String ccbIdTrabTec;

    public M4ccbCvTrabTecPK() {
    }

    public M4ccbCvTrabTecPK(String idOrganization, String ccbIdTrabTec) {
        this.idOrganization = idOrganization;
        this.ccbIdTrabTec = ccbIdTrabTec;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getCcbIdTrabTec() {
        return ccbIdTrabTec;
    }

    public void setCcbIdTrabTec(String ccbIdTrabTec) {
        this.ccbIdTrabTec = ccbIdTrabTec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (ccbIdTrabTec != null ? ccbIdTrabTec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvTrabTecPK)) {
            return false;
        }
        M4ccbCvTrabTecPK other = (M4ccbCvTrabTecPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.ccbIdTrabTec == null && other.ccbIdTrabTec != null) || (this.ccbIdTrabTec != null && !this.ccbIdTrabTec.equals(other.ccbIdTrabTec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabTecPK[ idOrganization=" + idOrganization + ", ccbIdTrabTec=" + ccbIdTrabTec + " ]";
    }
    
}
