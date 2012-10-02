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
public class M4scoAssocMePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "SCO_ID_HR")
    private String scoIdHr;
    @Basic(optional = false)
    @Column(name = "SCO_OR_ASSOC_MEMB")
    private short scoOrAssocMemb;

    public M4scoAssocMePK() {
    }

    public M4scoAssocMePK(String idOrganization, String scoIdHr, short scoOrAssocMemb) {
        this.idOrganization = idOrganization;
        this.scoIdHr = scoIdHr;
        this.scoOrAssocMemb = scoOrAssocMemb;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getScoIdHr() {
        return scoIdHr;
    }

    public void setScoIdHr(String scoIdHr) {
        this.scoIdHr = scoIdHr;
    }

    public short getScoOrAssocMemb() {
        return scoOrAssocMemb;
    }

    public void setScoOrAssocMemb(short scoOrAssocMemb) {
        this.scoOrAssocMemb = scoOrAssocMemb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (scoIdHr != null ? scoIdHr.hashCode() : 0);
        hash += (int) scoOrAssocMemb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoAssocMePK)) {
            return false;
        }
        M4scoAssocMePK other = (M4scoAssocMePK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.scoIdHr == null && other.scoIdHr != null) || (this.scoIdHr != null && !this.scoIdHr.equals(other.scoIdHr))) {
            return false;
        }
        if (this.scoOrAssocMemb != other.scoOrAssocMemb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoAssocMePK[ idOrganization=" + idOrganization + ", scoIdHr=" + scoIdHr + ", scoOrAssocMemb=" + scoOrAssocMemb + " ]";
    }
    
}
