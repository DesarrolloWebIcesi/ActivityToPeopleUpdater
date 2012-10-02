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
public class StdHrLangTransPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORGANIZATION")
    private String idOrganization;
    @Basic(optional = false)
    @Column(name = "STD_ID_HR")
    private String stdIdHr;
    @Basic(optional = false)
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Basic(optional = false)
    @Column(name = "STD_ID_LANGUAGE_TO")
    private String stdIdLanguageTo;
    @Basic(optional = false)
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Basic(optional = false)
    @Column(name = "CCB_OR_TRADUCC")
    private short ccbOrTraducc;

    public StdHrLangTransPK() {
    }

    public StdHrLangTransPK(String idOrganization, String stdIdHr, String stdIdLanguage, String stdIdLanguageTo, Date stdDtStart, short ccbOrTraducc) {
        this.idOrganization = idOrganization;
        this.stdIdHr = stdIdHr;
        this.stdIdLanguage = stdIdLanguage;
        this.stdIdLanguageTo = stdIdLanguageTo;
        this.stdDtStart = stdDtStart;
        this.ccbOrTraducc = ccbOrTraducc;
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

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
    }

    public String getStdIdLanguageTo() {
        return stdIdLanguageTo;
    }

    public void setStdIdLanguageTo(String stdIdLanguageTo) {
        this.stdIdLanguageTo = stdIdLanguageTo;
    }

    public Date getStdDtStart() {
        return stdDtStart;
    }

    public void setStdDtStart(Date stdDtStart) {
        this.stdDtStart = stdDtStart;
    }

    public short getCcbOrTraducc() {
        return ccbOrTraducc;
    }

    public void setCcbOrTraducc(short ccbOrTraducc) {
        this.ccbOrTraducc = ccbOrTraducc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganization != null ? idOrganization.hashCode() : 0);
        hash += (stdIdHr != null ? stdIdHr.hashCode() : 0);
        hash += (stdIdLanguage != null ? stdIdLanguage.hashCode() : 0);
        hash += (stdIdLanguageTo != null ? stdIdLanguageTo.hashCode() : 0);
        hash += (stdDtStart != null ? stdDtStart.hashCode() : 0);
        hash += (int) ccbOrTraducc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrLangTransPK)) {
            return false;
        }
        StdHrLangTransPK other = (StdHrLangTransPK) object;
        if ((this.idOrganization == null && other.idOrganization != null) || (this.idOrganization != null && !this.idOrganization.equals(other.idOrganization))) {
            return false;
        }
        if ((this.stdIdHr == null && other.stdIdHr != null) || (this.stdIdHr != null && !this.stdIdHr.equals(other.stdIdHr))) {
            return false;
        }
        if ((this.stdIdLanguage == null && other.stdIdLanguage != null) || (this.stdIdLanguage != null && !this.stdIdLanguage.equals(other.stdIdLanguage))) {
            return false;
        }
        if ((this.stdIdLanguageTo == null && other.stdIdLanguageTo != null) || (this.stdIdLanguageTo != null && !this.stdIdLanguageTo.equals(other.stdIdLanguageTo))) {
            return false;
        }
        if ((this.stdDtStart == null && other.stdDtStart != null) || (this.stdDtStart != null && !this.stdDtStart.equals(other.stdDtStart))) {
            return false;
        }
        if (this.ccbOrTraducc != other.ccbOrTraducc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrLangTransPK[ idOrganization=" + idOrganization + ", stdIdHr=" + stdIdHr + ", stdIdLanguage=" + stdIdLanguage + ", stdIdLanguageTo=" + stdIdLanguageTo + ", stdDtStart=" + stdDtStart + ", ccbOrTraducc=" + ccbOrTraducc + " ]";
    }
    
}
