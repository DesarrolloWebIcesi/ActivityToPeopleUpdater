/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.icesi.activitytopeopleupdater.peoplenet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 38555240
 */
@Entity
@Table(name = "STD_HR_ACAD_BACKGR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StdHrAcadBackgr.findAll", query = "SELECT s FROM StdHrAcadBackgr s"),
    @NamedQuery(name = "StdHrAcadBackgr.findByIdOrganization", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdHrAcadBackgrPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdHr", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdHrAcadBackgrPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdOrdAcdBack", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdHrAcadBackgrPK.stdOrdAcdBack = :stdOrdAcdBack"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdDtStart", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdDtStart = :stdDtStart"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdDtEarnedExpe", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdDtEarnedExpe = :stdDtEarnedExpe"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdDiploma", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdDiploma = :stdIdDiploma"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdEduCenter", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdEduCenter = :stdIdEduCenter"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdEduSp", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdEduSp = :stdIdEduSp"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdEduType", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdEduType = :stdIdEduType"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdComment", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdComment = :stdComment"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdTotalYearsDi", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdTotalYearsDi = :stdTotalYearsDi"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdCompletedYear", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdCompletedYear = :stdCompletedYear"),
    @NamedQuery(name = "StdHrAcadBackgr.findByScoCkEndDip", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.scoCkEndDip = :scoCkEndDip"),
    @NamedQuery(name = "StdHrAcadBackgr.findBySukIdQualLevel", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.sukIdQualLevel = :sukIdQualLevel"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdDescEduCenter", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdDescEduCenter = :stdDescEduCenter"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbYearTerm", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbYearTerm = :ccbYearTerm"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbOtroTitul", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbOtroTitul = :ccbOtroTitul"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbOtroEspec", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbOtroEspec = :ccbOtroEspec"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbOtroTForm", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbOtroTForm = :ccbOtroTForm"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbValorOpt", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbValorOpt = :ccbValorOpt"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbSoporte", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbSoporte = :ccbSoporte"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbMaxTituObt", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbMaxTituObt = :ccbMaxTituObt"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbTituTrab", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbTituTrab = :ccbTituTrab"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbNomAut", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbNomAut = :ccbNomAut"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdCountry", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdGeoDiv", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdSubGeoDiv", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "StdHrAcadBackgr.findByStdIdGeoPlace", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "StdHrAcadBackgr.findByIdApprole", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.idApprole = :idApprole"),
    @NamedQuery(name = "StdHrAcadBackgr.findByIdSecuser", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.idSecuser = :idSecuser"),
    @NamedQuery(name = "StdHrAcadBackgr.findByDtLastUpdate", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.dtLastUpdate = :dtLastUpdate"),
    @NamedQuery(name = "StdHrAcadBackgr.findByCcbCargueAct", query = "SELECT s FROM StdHrAcadBackgr s WHERE s.ccbCargueAct = :ccbCargueAct")})
public class StdHrAcadBackgr implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StdHrAcadBackgrPK stdHrAcadBackgrPK;
    @Column(name = "STD_DT_START")
    @Temporal(TemporalType.DATE)
    private Date stdDtStart;
    @Column(name = "STD_DT_EARNED_EXPE")
    @Temporal(TemporalType.DATE)
    private Date stdDtEarnedExpe;
    @Column(name = "STD_ID_DIPLOMA")
    private String stdIdDiploma;
    @Column(name = "STD_ID_EDU_CENTER")
    private String stdIdEduCenter;
    @Column(name = "STD_ID_EDU_SP")
    private String stdIdEduSp;
    @Column(name = "STD_ID_EDU_TYPE")
    private String stdIdEduType;
    @Column(name = "STD_COMMENT")
    private String stdComment;
    @Column(name = "STD_TOTAL_YEARS_DI")
    private Short stdTotalYearsDi;
    @Column(name = "STD_COMPLETED_YEAR")
    private Short stdCompletedYear;
    @Column(name = "SCO_CK_END_DIP")
    private Short scoCkEndDip;
    @Column(name = "SUK_ID_QUAL_LEVEL")
    private String sukIdQualLevel;
    @Column(name = "STD_DESC_EDU_CENTER")
    private String stdDescEduCenter;
    @Column(name = "CCB_YEAR_TERM")
    private String ccbYearTerm;
    @Column(name = "CCB_OTRO_TITUL")
    private String ccbOtroTitul;
    @Column(name = "CCB_OTRO_ESPEC")
    private String ccbOtroEspec;
    @Column(name = "CCB_OTRO_T_FORM")
    private String ccbOtroTForm;
    @Column(name = "CCB_VALOR_OPT")
    private String ccbValorOpt;
    @Column(name = "CCB_SOPORTE")
    private String ccbSoporte;
    @Column(name = "CCB_MAX_TITU_OBT")
    private String ccbMaxTituObt;
    @Column(name = "CCB_TITU_TRAB")
    private String ccbTituTrab;
    @Column(name = "CCB_NOM_AUT")
    private String ccbNomAut;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "STD_ID_GEO_DIV")
    private String stdIdGeoDiv;
    @Column(name = "STD_ID_SUB_GEO_DIV")
    private String stdIdSubGeoDiv;
    @Column(name = "STD_ID_GEO_PLACE")
    private String stdIdGeoPlace;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;
    @Column(name = "CCB_CARGUE_ACT")
    private String ccbCargueAct;

    public StdHrAcadBackgr() {
    }

    public StdHrAcadBackgr(StdHrAcadBackgrPK stdHrAcadBackgrPK) {
        this.stdHrAcadBackgrPK = stdHrAcadBackgrPK;
    }

    public StdHrAcadBackgr(String idOrganization, String stdIdHr, short stdOrdAcdBack) {
        this.stdHrAcadBackgrPK = new StdHrAcadBackgrPK(idOrganization, stdIdHr, stdOrdAcdBack);
    }

    public StdHrAcadBackgrPK getStdHrAcadBackgrPK() {
        return stdHrAcadBackgrPK;
    }

    public void setStdHrAcadBackgrPK(StdHrAcadBackgrPK stdHrAcadBackgrPK) {
        this.stdHrAcadBackgrPK = stdHrAcadBackgrPK;
    }

    public Date getStdDtStart() {
        return stdDtStart;
    }

    public void setStdDtStart(Date stdDtStart) {
        this.stdDtStart = stdDtStart;
    }

    public Date getStdDtEarnedExpe() {
        return stdDtEarnedExpe;
    }

    public void setStdDtEarnedExpe(Date stdDtEarnedExpe) {
        this.stdDtEarnedExpe = stdDtEarnedExpe;
    }

    public String getStdIdDiploma() {
        return stdIdDiploma;
    }

    public void setStdIdDiploma(String stdIdDiploma) {
        this.stdIdDiploma = stdIdDiploma;
    }

    public String getStdIdEduCenter() {
        return stdIdEduCenter;
    }

    public void setStdIdEduCenter(String stdIdEduCenter) {
        this.stdIdEduCenter = stdIdEduCenter;
    }

    public String getStdIdEduSp() {
        return stdIdEduSp;
    }

    public void setStdIdEduSp(String stdIdEduSp) {
        this.stdIdEduSp = stdIdEduSp;
    }

    public String getStdIdEduType() {
        return stdIdEduType;
    }

    public void setStdIdEduType(String stdIdEduType) {
        this.stdIdEduType = stdIdEduType;
    }

    public String getStdComment() {
        return stdComment;
    }

    public void setStdComment(String stdComment) {
        this.stdComment = stdComment;
    }

    public Short getStdTotalYearsDi() {
        return stdTotalYearsDi;
    }

    public void setStdTotalYearsDi(Short stdTotalYearsDi) {
        this.stdTotalYearsDi = stdTotalYearsDi;
    }

    public Short getStdCompletedYear() {
        return stdCompletedYear;
    }

    public void setStdCompletedYear(Short stdCompletedYear) {
        this.stdCompletedYear = stdCompletedYear;
    }

    public Short getScoCkEndDip() {
        return scoCkEndDip;
    }

    public void setScoCkEndDip(Short scoCkEndDip) {
        this.scoCkEndDip = scoCkEndDip;
    }

    public String getSukIdQualLevel() {
        return sukIdQualLevel;
    }

    public void setSukIdQualLevel(String sukIdQualLevel) {
        this.sukIdQualLevel = sukIdQualLevel;
    }

    public String getStdDescEduCenter() {
        return stdDescEduCenter;
    }

    public void setStdDescEduCenter(String stdDescEduCenter) {
        this.stdDescEduCenter = stdDescEduCenter;
    }

    public String getCcbYearTerm() {
        return ccbYearTerm;
    }

    public void setCcbYearTerm(String ccbYearTerm) {
        this.ccbYearTerm = ccbYearTerm;
    }

    public String getCcbOtroTitul() {
        return ccbOtroTitul;
    }

    public void setCcbOtroTitul(String ccbOtroTitul) {
        this.ccbOtroTitul = ccbOtroTitul;
    }

    public String getCcbOtroEspec() {
        return ccbOtroEspec;
    }

    public void setCcbOtroEspec(String ccbOtroEspec) {
        this.ccbOtroEspec = ccbOtroEspec;
    }

    public String getCcbOtroTForm() {
        return ccbOtroTForm;
    }

    public void setCcbOtroTForm(String ccbOtroTForm) {
        this.ccbOtroTForm = ccbOtroTForm;
    }

    public String getCcbValorOpt() {
        return ccbValorOpt;
    }

    public void setCcbValorOpt(String ccbValorOpt) {
        this.ccbValorOpt = ccbValorOpt;
    }

    public String getCcbSoporte() {
        return ccbSoporte;
    }

    public void setCcbSoporte(String ccbSoporte) {
        this.ccbSoporte = ccbSoporte;
    }

    public String getCcbMaxTituObt() {
        return ccbMaxTituObt;
    }

    public void setCcbMaxTituObt(String ccbMaxTituObt) {
        this.ccbMaxTituObt = ccbMaxTituObt;
    }

    public String getCcbTituTrab() {
        return ccbTituTrab;
    }

    public void setCcbTituTrab(String ccbTituTrab) {
        this.ccbTituTrab = ccbTituTrab;
    }

    public String getCcbNomAut() {
        return ccbNomAut;
    }

    public void setCcbNomAut(String ccbNomAut) {
        this.ccbNomAut = ccbNomAut;
    }

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
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

    public String getCcbCargueAct() {
        return ccbCargueAct;
    }

    public void setCcbCargueAct(String ccbCargueAct) {
        this.ccbCargueAct = ccbCargueAct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdHrAcadBackgrPK != null ? stdHrAcadBackgrPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StdHrAcadBackgr)) {
            return false;
        }
        StdHrAcadBackgr other = (StdHrAcadBackgr) object;
        if ((this.stdHrAcadBackgrPK == null && other.stdHrAcadBackgrPK != null) || (this.stdHrAcadBackgrPK != null && !this.stdHrAcadBackgrPK.equals(other.stdHrAcadBackgrPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.StdHrAcadBackgr[ stdHrAcadBackgrPK=" + stdHrAcadBackgrPK + " ]";
    }
    
}
