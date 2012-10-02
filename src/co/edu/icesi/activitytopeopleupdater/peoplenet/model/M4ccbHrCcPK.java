/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author 38555240
 */
@Embeddable
public class M4ccbHrCcPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;
    @Basic(optional = false)
    @Column(name = "STD_OR_HR_PERIOD")
    private short stdOrHrPeriod;
    @Basic(optional = false)
    @Column(name = "CCB_CENTRO_COSTO")
    private String ccbCentroCosto;
    @Basic(optional = false)
    @Column(name = "DT_START")
    @Temporal(TemporalType.DATE)
    private Date dtStart;

    public M4ccbHrCcPK() {
    }

    public M4ccbHrCcPK(String idOrganization, String stdIdHr, short stdOrHrPeriod, String ccbCentroCosto, Date dtStart) {
        this.idOrganization = idOrganization;
        this.stdIdHr = stdIdHr;
        this.stdOrHrPeriod = stdOrHrPeriod;
        this.ccbCentroCosto = ccbCentroCosto;
        this.dtStart = dtStart;
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

    public short getStdOrHrPeriod() {
        return stdOrHrPeriod;
    }

    public void setStdOrHrPeriod(short stdOrHrPeriod) {
        this.stdOrHrPeriod = stdOrHrPeriod;
    }

    public String getCcbCentroCosto() {
        return ccbCentroCosto;
    }

    public void setCcbCentroCosto(String ccbCentroCosto) {
        this.ccbCentroCosto = ccbCentroCosto;
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        hash += (int) stdOrHrPeriod;
        hash += (ccbCentroCosto != null ? ccbCentroCosto.hashCode() : 0);
        hash += (dtStart != null ? dtStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbHrCcPK)) {
            return false;
        }
        M4ccbHrCcPK other = (M4ccbHrCcPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        if (this.stdOrHrPeriod != other.stdOrHrPeriod) {
            return false;
        }
        if ((this.ccbCentroCosto == null && other.ccbCentroCosto != null) || (this.ccbCentroCosto != null && !this.ccbCentroCosto.equals(other.ccbCentroCosto))) {
            return false;
        }
        if ((this.dtStart == null && other.dtStart != null) || (this.dtStart != null && !this.dtStart.equals(other.dtStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbHrCcPK[ idOrganization=" + idOrganization + ", stdIdHr=" + stdIdHr + ", stdOrHrPeriod=" + stdOrHrPeriod + ", ccbCentroCosto=" + ccbCentroCosto + ", dtStart=" + dtStart + " ]";
    }
    
}
