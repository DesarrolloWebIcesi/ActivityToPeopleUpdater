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
public class M4ccbCvOrgEvenPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_OR_ORG_EVENT")
    private short ccbOrOrgEvent;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;

    public M4ccbCvOrgEvenPK() {
    }

    public M4ccbCvOrgEvenPK(String idOrganization, short ccbOrOrgEvent, String stdIdHr) {
        this.idOrganization = idOrganization;
        this.ccbOrOrgEvent = ccbOrOrgEvent;
        this.stdIdHr = stdIdHr;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public short getCcbOrOrgEvent() {
        return ccbOrOrgEvent;
    }

    public void setCcbOrOrgEvent(short ccbOrOrgEvent) {
        this.ccbOrOrgEvent = ccbOrOrgEvent;
    }

    public String getStdIdHr() {
        return stdIdHr;
    }

    public void setStdIdHr(String stdIdHr) {
        this.stdIdHr = stdIdHr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (int) ccbOrOrgEvent;
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvOrgEvenPK)) {
            return false;
        }
        M4ccbCvOrgEvenPK other = (M4ccbCvOrgEvenPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if (this.ccbOrOrgEvent != other.ccbOrOrgEvent) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvOrgEvenPK[ idOrganization=" + idOrganization + ", ccbOrOrgEvent=" + ccbOrOrgEvent + ", stdIdHr=" + stdIdHr + " ]";
    }
    
}
