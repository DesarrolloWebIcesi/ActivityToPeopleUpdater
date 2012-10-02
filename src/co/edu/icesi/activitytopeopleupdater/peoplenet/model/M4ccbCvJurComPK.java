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
public class M4ccbCvJurComPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_OR_JUR_COM")
    private short ccbOrJurCom;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;

    public M4ccbCvJurComPK() {
    }

    public M4ccbCvJurComPK(String idOrganization, short ccbOrJurCom, String stdIdHr) {
        this.idOrganization = idOrganization;
        this.ccbOrJurCom = ccbOrJurCom;
        this.stdIdHr = stdIdHr;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public short getCcbOrJurCom() {
        return ccbOrJurCom;
    }

    public void setCcbOrJurCom(short ccbOrJurCom) {
        this.ccbOrJurCom = ccbOrJurCom;
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
        hash += (int) ccbOrJurCom;
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvJurComPK)) {
            return false;
        }
        M4ccbCvJurComPK other = (M4ccbCvJurComPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if (this.ccbOrJurCom != other.ccbOrJurCom) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvJurComPK[ idOrganization=" + idOrganization + ", ccbOrJurCom=" + ccbOrJurCom + ", stdIdHr=" + stdIdHr + " ]";
    }
    
}
