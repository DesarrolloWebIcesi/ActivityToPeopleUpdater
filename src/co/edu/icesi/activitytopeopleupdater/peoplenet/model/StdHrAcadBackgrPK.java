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
public class StdHrAcadBackgrPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;
    @Basic(optional = false)
    @Column(name = "STD_ORD_ACD_BACK")
    private short stdOrdAcdBack;

    public StdHrAcadBackgrPK() {
    }

    public StdHrAcadBackgrPK(String idOrganization, String stdIdHr, short stdOrdAcdBack) {
        this.idOrganization = idOrganization;
        this.stdIdHr = stdIdHr;
        this.stdOrdAcdBack = stdOrdAcdBack;
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

    public short getStdOrdAcdBack() {
        return stdOrdAcdBack;
    }

    public void setStdOrdAcdBack(short stdOrdAcdBack) {
        this.stdOrdAcdBack = stdOrdAcdBack;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        hash += (int) stdOrdAcdBack;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrAcadBackgrPK)) {
            return false;
        }
        StdHrAcadBackgrPK other = (StdHrAcadBackgrPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        if (this.stdOrdAcdBack != other.stdOrdAcdBack) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrAcadBackgrPK[ idOrganization=" + idOrganization + ", stdIdHr=" + stdIdHr + ", stdOrdAcdBack=" + stdOrdAcdBack + " ]";
    }
    
}
