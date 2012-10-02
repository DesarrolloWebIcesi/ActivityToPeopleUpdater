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
public class M4ccbCvConsDetPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "CCB_OR_DET_CONS")
    private short ccbOrDetCons;
    @Basic(optional = false)
    @Column(name = "CCB_OR_CONSULT")
    private short ccbOrConsult;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;

    public M4ccbCvConsDetPK() {
    }

    public M4ccbCvConsDetPK(String idOrganization, short ccbOrDetCons, short ccbOrConsult, String stdIdHr) {
        this.idOrganization = idOrganization;
        this.ccbOrDetCons = ccbOrDetCons;
        this.ccbOrConsult = ccbOrConsult;
        this.stdIdHr = stdIdHr;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public short getCcbOrDetCons() {
        return ccbOrDetCons;
    }

    public void setCcbOrDetCons(short ccbOrDetCons) {
        this.ccbOrDetCons = ccbOrDetCons;
    }

    public short getCcbOrConsult() {
        return ccbOrConsult;
    }

    public void setCcbOrConsult(short ccbOrConsult) {
        this.ccbOrConsult = ccbOrConsult;
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
        hash += (int) ccbOrDetCons;
        hash += (int) ccbOrConsult;
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvConsDetPK)) {
            return false;
        }
        M4ccbCvConsDetPK other = (M4ccbCvConsDetPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if (this.ccbOrDetCons != other.ccbOrDetCons) {
            return false;
        }
        if (this.ccbOrConsult != other.ccbOrConsult) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsDetPK[ idOrganization=" + idOrganization + ", ccbOrDetCons=" + ccbOrDetCons + ", ccbOrConsult=" + ccbOrConsult + ", stdIdHr=" + stdIdHr + " ]";
    }
    
}
