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
public class M4ccbCvDistinciPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_ID_DISTINCION")
    private String ccbIdDistincion;

    public M4ccbCvDistinciPK() {
    }

    public M4ccbCvDistinciPK(String idOrganization, String ccbIdDistincion) {
        this.idOrganization = idOrganization;
        this.ccbIdDistincion = ccbIdDistincion;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getCcbIdDistincion() {
        return ccbIdDistincion;
    }

    public void setCcbIdDistincion(String ccbIdDistincion) {
        this.ccbIdDistincion = ccbIdDistincion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (ccbIdDistincion != null ? ccbIdDistincion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvDistinciPK)) {
            return false;
        }
        M4ccbCvDistinciPK other = (M4ccbCvDistinciPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.ccbIdDistincion == null && other.ccbIdDistincion != null) || (this.ccbIdDistincion != null && !this.ccbIdDistincion.equals(other.ccbIdDistincion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistinciPK[ idOrganization=" + idOrganization + ", ccbIdDistincion=" + ccbIdDistincion + " ]";
    }
    
}
