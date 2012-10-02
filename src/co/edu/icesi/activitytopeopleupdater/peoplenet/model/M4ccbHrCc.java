/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 38555240
 */
@Entity
@Table(name = "M4CCB_HR_CC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbHrCc.findAll", query = "SELECT m FROM M4ccbHrCc m"),
    @NamedQuery(name = "M4ccbHrCc.findByIdOrganization", query = "SELECT m FROM M4ccbHrCc m WHERE m.m4ccbHrCcPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbHrCc.findByStdIdHr", query = "SELECT m FROM M4ccbHrCc m WHERE m.m4ccbHrCcPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbHrCc.findByStdOrHrPeriod", query = "SELECT m FROM M4ccbHrCc m WHERE m.m4ccbHrCcPK.stdOrHrPeriod = :stdOrHrPeriod"),
    @NamedQuery(name = "M4ccbHrCc.findByCcbCentroCosto", query = "SELECT m FROM M4ccbHrCc m WHERE m.m4ccbHrCcPK.ccbCentroCosto = :ccbCentroCosto"),
    @NamedQuery(name = "M4ccbHrCc.findByDtStart", query = "SELECT m FROM M4ccbHrCc m WHERE m.m4ccbHrCcPK.dtStart = :dtStart"),
    @NamedQuery(name = "M4ccbHrCc.findByDtEnd", query = "SELECT m FROM M4ccbHrCc m WHERE m.dtEnd = :dtEnd"),
    @NamedQuery(name = "M4ccbHrCc.findByCcbPorcentDistr", query = "SELECT m FROM M4ccbHrCc m WHERE m.ccbPorcentDistr = :ccbPorcentDistr"),
    @NamedQuery(name = "M4ccbHrCc.findByCcbPrincipal", query = "SELECT m FROM M4ccbHrCc m WHERE m.ccbPrincipal = :ccbPrincipal"),
    @NamedQuery(name = "M4ccbHrCc.findByCcbPorcObraCont", query = "SELECT m FROM M4ccbHrCc m WHERE m.ccbPorcObraCont = :ccbPorcObraCont"),
    @NamedQuery(name = "M4ccbHrCc.findByIdApprole", query = "SELECT m FROM M4ccbHrCc m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbHrCc.findByIdSecuser", query = "SELECT m FROM M4ccbHrCc m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbHrCc.findByDtLastUpdate", query = "SELECT m FROM M4ccbHrCc m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbHrCc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbHrCcPK m4ccbHrCcPK;
    @Column(name = "DT_END")
    @Temporal(TemporalType.DATE)
    private Date dtEnd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CCB_PORCENT_DISTR")
    private BigDecimal ccbPorcentDistr;
    @Column(name = "CCB_PRINCIPAL")
    private Short ccbPrincipal;
    @Column(name = "CCB_PORC_OBRA_CONT")
    private BigDecimal ccbPorcObraCont;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbHrCc() {
    }

    public M4ccbHrCc(M4ccbHrCcPK m4ccbHrCcPK) {
        this.m4ccbHrCcPK = m4ccbHrCcPK;
    }

    public M4ccbHrCc(String idOrganization, String stdIdHr, short stdOrHrPeriod, String ccbCentroCosto, Date dtStart) {
        this.m4ccbHrCcPK = new M4ccbHrCcPK(idOrganization, stdIdHr, stdOrHrPeriod, ccbCentroCosto, dtStart);
    }

    public M4ccbHrCcPK getM4ccbHrCcPK() {
        return m4ccbHrCcPK;
    }

    public void setM4ccbHrCcPK(M4ccbHrCcPK m4ccbHrCcPK) {
        this.m4ccbHrCcPK = m4ccbHrCcPK;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public BigDecimal getCcbPorcentDistr() {
        return ccbPorcentDistr;
    }

    public void setCcbPorcentDistr(BigDecimal ccbPorcentDistr) {
        this.ccbPorcentDistr = ccbPorcentDistr;
    }

    public Short getCcbPrincipal() {
        return ccbPrincipal;
    }

    public void setCcbPrincipal(Short ccbPrincipal) {
        this.ccbPrincipal = ccbPrincipal;
    }

    public BigDecimal getCcbPorcObraCont() {
        return ccbPorcObraCont;
    }

    public void setCcbPorcObraCont(BigDecimal ccbPorcObraCont) {
        this.ccbPorcObraCont = ccbPorcObraCont;
    }

    public String getIdApprole() {
        return idApprole;
    }

    public void setIdApprole(String idApprole) {
        this.idApprole = idApprole;
    }

    public String getIdSecuser() {
        return idSecuser;
    }

    public void setIdSecuser(String idSecuser) {
        this.idSecuser = idSecuser;
    }

    public Date getDtLastUpdate() {
        return dtLastUpdate;
    }

    public void setDtLastUpdate(Date dtLastUpdate) {
        this.dtLastUpdate = dtLastUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m4ccbHrCcPK != null ? m4ccbHrCcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbHrCc)) {
            return false;
        }
        M4ccbHrCc other = (M4ccbHrCc) object;
        if ((this.m4ccbHrCcPK == null && other.m4ccbHrCcPK != null) || (this.m4ccbHrCcPK != null && !this.m4ccbHrCcPK.equals(other.m4ccbHrCcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.dao.M4ccbHrCc[ m4ccbHrCcPK=" + m4ccbHrCcPK + " ]";
    }
    
}
