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
@Table(name = "STD_HR_PREV_JOBS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdHrPrevJobs.findAll", query = "SELECT s FROM StdHrPrevJobs s"),
    @NamedQuery(name = "StdHrPrevJobs.findByIdOrganization", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdHrPrevJobsPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdIdHr", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdHrPrevJobsPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdOrProfBackg", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdHrPrevJobsPK.stdOrProfBackg = :stdOrProfBackg"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdDtStart", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdDtEnd", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdDtEnd = :stdDtEnd"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdEmployer", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdEmployer = :stdEmployer"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdIdSector", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdIdSector = :stdIdSector"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdNumbEmployees", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdNumbEmployees = :stdNumbEmployees"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdInitialJob", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdInitialJob = :stdInitialJob"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdFinalJob", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdFinalJob = :stdFinalJob"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdDevelActivits", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdDevelActivits = :stdDevelActivits"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdCurrSalary", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdCurrSalary = :stdCurrSalary"),
    @NamedQuery(name = "StdHrPrevJobs.findByScoComment", query = "SELECT s FROM StdHrPrevJobs s WHERE s.scoComment = :scoComment"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdCurrType", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdCurrType = :stdCurrType"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdExchDt", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdExchDt = :stdExchDt"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdExchType", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdExchType = :stdExchType"),
    @NamedQuery(name = "StdHrPrevJobs.findByScoIdArea", query = "SELECT s FROM StdHrPrevJobs s WHERE s.scoIdArea = :scoIdArea"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdIdCountry", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "StdHrPrevJobs.findByCcbEmpProp", query = "SELECT s FROM StdHrPrevJobs s WHERE s.ccbEmpProp = :ccbEmpProp"),
    @NamedQuery(name = "StdHrPrevJobs.findByCcbJefeInmd", query = "SELECT s FROM StdHrPrevJobs s WHERE s.ccbJefeInmd = :ccbJefeInmd"),
    @NamedQuery(name = "StdHrPrevJobs.findByCcbTelContacto", query = "SELECT s FROM StdHrPrevJobs s WHERE s.ccbTelContacto = :ccbTelContacto"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdIdGeoDiv", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdIdSubGeoDiv", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "StdHrPrevJobs.findByStdIdGeoPlace", query = "SELECT s FROM StdHrPrevJobs s WHERE s.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "StdHrPrevJobs.findByCcbCargueAct", query = "SELECT s FROM StdHrPrevJobs s WHERE s.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "StdHrPrevJobs.findByIdApprole", query = "SELECT s FROM StdHrPrevJobs s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdHrPrevJobs.findByIdSecuser", query = "SELECT s FROM StdHrPrevJobs s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdHrPrevJobs.findByDtLastUpdate", query = "SELECT s FROM StdHrPrevJobs s WHERE s.dtLastUpdate = :dtLastUpdate")})
public class StdHrPrevJobs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdHrPrevJobsPK stdHrPrevJobsPK;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "STD_DT_END")
    @Temporal(TemporalType.DATE)
    private Date stdDtEnd;
    @Column(name = "STD_EMPLOYER")
    private String stdEmployer;
    @Column(name = "STD_ID_SECTOR")
    private String stdIdSector;
    @Column(name = "STD_NUMB_EMPLOYEES")
    private Integer stdNumbEmployees;
    @Column(name = "STD_INITIAL_JOB")
    private String stdInitialJob;
    @Column(name = "STD_FINAL_JOB")
    private String stdFinalJob;
    @Column(name = "STD_DEVEL_ACTIVITS")
    private String stdDevelActivits;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STD_CURR_SALARY")
    private BigDecimal stdCurrSalary;
    @Column(name = "SCO_COMMENT")
    private String scoComment;
    @Column(name = "STD_CURR_TYPE")
    private String stdCurrType;
    @Column(name = "STD_EXCH_DT")
    @Temporal(TemporalType.DATE)
    private Date stdExchDt;
    @Column(name = "STD_EXCH_TYPE")
    private String stdExchType;
    @Column(name = "SCO_ID_AREA")
    private String scoIdArea;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "CCB_EMP_PROP")
    private String ccbEmpProp;
    @Column(name = "CCB_JEFE_INMD")
    private String ccbJefeInmd;
    @Column(name = "CCB_TEL_CONTACTO")
    private Long ccbTelContacto;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public StdHrPrevJobs() {
    }

    public StdHrPrevJobs(StdHrPrevJobsPK stdHrPrevJobsPK) {
        this.stdHrPrevJobsPK = stdHrPrevJobsPK;
    }

    public StdHrPrevJobs(String idOrganization, String stdIdHr, short stdOrProfBackg) {
        this.stdHrPrevJobsPK = new StdHrPrevJobsPK(idOrganization, stdIdHr, stdOrProfBackg);
    }

    public StdHrPrevJobsPK getStdHrPrevJobsPK() {
        return stdHrPrevJobsPK;
    }

    public void setStdHrPrevJobsPK(StdHrPrevJobsPK stdHrPrevJobsPK) {
        this.stdHrPrevJobsPK = stdHrPrevJobsPK;
    }

    public Date getStdDtStart() {
        return stdDtStart;
    }

    public void setStdDtStart(Date stdDtStart) {
        this.stdDtStart = stdDtStart;
    }

    public Date getStdDtEnd() {
        return stdDtEnd;
    }

    public void setStdDtEnd(Date stdDtEnd) {
        this.stdDtEnd = stdDtEnd;
    }

    public String getStdEmployer() {
        return stdEmployer;
    }

    public void setStdEmployer(String stdEmployer) {
        this.stdEmployer = stdEmployer;
    }

    public String getStdIdSector() {
        return stdIdSector;
    }

    public void setStdIdSector(String stdIdSector) {
        this.stdIdSector = stdIdSector;
    }

    public Integer getStdNumbEmployees() {
        return stdNumbEmployees;
    }

    public void setStdNumbEmployees(Integer stdNumbEmployees) {
        this.stdNumbEmployees = stdNumbEmployees;
    }

    public String getStdInitialJob() {
        return stdInitialJob;
    }

    public void setStdInitialJob(String stdInitialJob) {
        this.stdInitialJob = stdInitialJob;
    }

    public String getStdFinalJob() {
        return stdFinalJob;
    }

    public void setStdFinalJob(String stdFinalJob) {
        this.stdFinalJob = stdFinalJob;
    }

    public String getStdDevelActivits() {
        return stdDevelActivits;
    }

    public void setStdDevelActivits(String stdDevelActivits) {
        this.stdDevelActivits = stdDevelActivits;
    }

    public BigDecimal getStdCurrSalary() {
        return stdCurrSalary;
    }

    public void setStdCurrSalary(BigDecimal stdCurrSalary) {
        this.stdCurrSalary = stdCurrSalary;
    }

    public String getScoComment() {
        return scoComment;
    }

    public void setScoComment(String scoComment) {
        this.scoComment = scoComment;
    }

    public String getStdCurrType() {
        return stdCurrType;
    }

    public void setStdCurrType(String stdCurrType) {
        this.stdCurrType = stdCurrType;
    }

    public Date getStdExchDt() {
        return stdExchDt;
    }

    public void setStdExchDt(Date stdExchDt) {
        this.stdExchDt = stdExchDt;
    }

    public String getStdExchType() {
        return stdExchType;
    }

    public void setStdExchType(String stdExchType) {
        this.stdExchType = stdExchType;
    }

    public String getScoIdArea() {
        return scoIdArea;
    }

    public void setScoIdArea(String scoIdArea) {
        this.scoIdArea = scoIdArea;
    }

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
    }

    public String getCcbEmpProp() {
        return ccbEmpProp;
    }

    public void setCcbEmpProp(String ccbEmpProp) {
        this.ccbEmpProp = ccbEmpProp;
    }

    public String getCcbJefeInmd() {
        return ccbJefeInmd;
    }

    public void setCcbJefeInmd(String ccbJefeInmd) {
        this.ccbJefeInmd = ccbJefeInmd;
    }

    public Long getCcbTelContacto() {
        return ccbTelContacto;
    }

    public void setCcbTelContacto(Long ccbTelContacto) {
        this.ccbTelContacto = ccbTelContacto;
    }

    public String getStdIdGeoDiv() {
        return stdIdGeoDiv;
    }

    public void setStdIdGeoDiv(String stdIdGeoDiv) {
        this.stdIdGeoDiv = stdIdGeoDiv;
    }

    public String getStdIdSubGeoDiv() {
        return stdIdSubGeoDiv;
    }

    public void setStdIdSubGeoDiv(String stdIdSubGeoDiv) {
        this.stdIdSubGeoDiv = stdIdSubGeoDiv;
    }

    public String getStdIdGeoPlace() {
        return stdIdGeoPlace;
    }

    public void setStdIdGeoPlace(String stdIdGeoPlace) {
        this.stdIdGeoPlace = stdIdGeoPlace;
    }

    public String getCcbCargueAct() {
        return ccbCargueAct;
    }

    public void setCcbCargueAct(String ccbCargueAct) {
        this.ccbCargueAct = ccbCargueAct;
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
        hash += (stdHrPrevJobsPK != null ? stdHrPrevJobsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrPrevJobs)) {
            return false;
        }
        StdHrPrevJobs other = (StdHrPrevJobs) object;
        if ((this.stdHrPrevJobsPK == null && other.stdHrPrevJobsPK != null) || (this.stdHrPrevJobsPK != null && !this.stdHrPrevJobsPK.equals(other.stdHrPrevJobsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrPrevJobs[ stdHrPrevJobsPK=" + stdHrPrevJobsPK + " ]";
    }
    
}
