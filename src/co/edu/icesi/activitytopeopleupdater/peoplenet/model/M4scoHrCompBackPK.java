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
public class M4scoHrCompBackPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;
    @Basic(optional = false)
    @Column(name = "SCO_OR_COMP_BG")
    private short scoOrCompBg;

    public M4scoHrCompBackPK() {
    }

    public M4scoHrCompBackPK(String idOrganization, String stdIdHr, short scoOrCompBg) {
        this.idOrganization = idOrganization;
        this.stdIdHr = stdIdHr;
        this.scoOrCompBg = scoOrCompBg;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getStdIdHr() {
        return stdIdHr;
    }

    public void setStdIdHr(String stdIdHr) {
        this.stdIdHr = stdIdHr;
    }

    public short getScoOrCompBg() {
        return scoOrCompBg;
    }

    public void setScoOrCompBg(short scoOrCompBg) {
        this.scoOrCompBg = scoOrCompBg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        hash += (int) scoOrCompBg;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoHrCompBackPK)) {
            return false;
        }
        M4scoHrCompBackPK other = (M4scoHrCompBackPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        if (this.scoOrCompBg != other.scoOrCompBg) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoHrCompBackPK[ idOrganization=" + idOrganization + ", stdIdHr=" + stdIdHr + ", scoOrCompBg=" + scoOrCompBg + " ]";
    }
    
}
