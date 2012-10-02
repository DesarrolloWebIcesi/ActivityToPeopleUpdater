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
@Table(name = "M4SCO_ASSOC_ME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4scoAssocMe.findAll", query = "SELECT m FROM M4scoAssocMe m"),
    @NamedQuery(name = "M4scoAssocMe.findByIdOrganization", query = "SELECT m FROM M4scoAssocMe m WHERE m.m4scoAssocMePK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4scoAssocMe.findByScoIdHr", query = "SELECT m FROM M4scoAssocMe m WHERE m.m4scoAssocMePK.scoIdHr = :scoIdHr"),
    @NamedQuery(name = "M4scoAssocMe.findByScoOrAssocMemb", query = "SELECT m FROM M4scoAssocMe m WHERE m.m4scoAssocMePK.scoOrAssocMemb = :scoOrAssocMemb"),
    @NamedQuery(name = "M4scoAssocMe.findByScoDtStart", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoDtStart = :scoDtStart"),
    @NamedQuery(name = "M4scoAssocMe.findByScoDtEnd", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoDtEnd = :scoDtEnd"),
    @NamedQuery(name = "M4scoAssocMe.findByScoIdAssociation", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoIdAssociation = :scoIdAssociation"),
    @NamedQuery(name = "M4scoAssocMe.findByScoIdAssocType", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoIdAssocType = :scoIdAssocType"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivitybra", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivitybra = :scoNActivitybra"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivityeng", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivityeng = :scoNActivityeng"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivityesp", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivityesp = :scoNActivityesp"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivityfra", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivityfra = :scoNActivityfra"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivitygen", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivitygen = :scoNActivitygen"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivityger", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivityger = :scoNActivityger"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNActivityita", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNActivityita = :scoNActivityita"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositionbra", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositionbra = :scoNmPositionbra"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositioneng", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositioneng = :scoNmPositioneng"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositionesp", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositionesp = :scoNmPositionesp"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositionfra", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositionfra = :scoNmPositionfra"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositiongen", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositiongen = :scoNmPositiongen"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositionger", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositionger = :scoNmPositionger"),
    @NamedQuery(name = "M4scoAssocMe.findByScoNmPositionita", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoNmPositionita = :scoNmPositionita"),
    @NamedQuery(name = "M4scoAssocMe.findByScoComment", query = "SELECT m FROM M4scoAssocMe m WHERE m.scoComment = :scoComment"),
    @NamedQuery(name = "M4scoAssocMe.findBySukCompanySponso", query = "SELECT m FROM M4scoAssocMe m WHERE m.sukCompanySponso = :sukCompanySponso"),
    @NamedQuery(name = "M4scoAssocMe.findBySukIdMemberType", query = "SELECT m FROM M4scoAssocMe m WHERE m.sukIdMemberType = :sukIdMemberType"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbOtroTip", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbNombre", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbNombre = :ccbNombre"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbAbreviatura", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbAbreviatura = :ccbAbreviatura"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbOrgConf", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbOrgConf = :ccbOrgConf"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbActOrg", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbActOrg = :ccbActOrg"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbCoord", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbCoord = :ccbCoord"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbRolCarg", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbRolCarg = :ccbRolCarg"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbInherCarg", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbInherCarg = :ccbInherCarg"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbResponsb", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbResponsb = :ccbResponsb"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbNumHoras", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbNumHoras = :ccbNumHoras"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbCompens", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbCompens = :ccbCompens"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbFormaElec", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbFormaElec = :ccbFormaElec"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbIdAmbito", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbIdActAsc", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbIdActAsc = :ccbIdActAsc"),
    @NamedQuery(name = "M4scoAssocMe.findByStdIdCountry", query = "SELECT m FROM M4scoAssocMe m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4scoAssocMe.findByStdIdGeoDiv", query = "SELECT m FROM M4scoAssocMe m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4scoAssocMe.findByStdIdSubGeoDiv", query = "SELECT m FROM M4scoAssocMe m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4scoAssocMe.findByStdIdGeoPlace", query = "SELECT m FROM M4scoAssocMe m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4scoAssocMe.findByCcbCargueAct", query = "SELECT m FROM M4scoAssocMe m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4scoAssocMe.findByIdApprole", query = "SELECT m FROM M4scoAssocMe m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4scoAssocMe.findByIdSecuser", query = "SELECT m FROM M4scoAssocMe m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4scoAssocMe.findByDtLastUpdate", query = "SELECT m FROM M4scoAssocMe m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4scoAssocMe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4scoAssocMePK m4scoAssocMePK;
    @Column(name = "SCO_DT_START")
    @Temporal(TemporalType.DATE)
    private Date scoDtStart;
    @Column(name = "SCO_DT_END")
    @Temporal(TemporalType.DATE)
    private Date scoDtEnd;
    @Column(name = "SCO_ID_ASSOCIATION")
    private String scoIdAssociation;
    @Column(name = "SCO_ID_ASSOC_TYPE")
    private String scoIdAssocType;
    @Column(name = "SCO_N_ACTIVITYBRA")
    private String scoNActivitybra;
    @Column(name = "SCO_N_ACTIVITYENG")
    private String scoNActivityeng;
    @Column(name = "SCO_N_ACTIVITYESP")
    private String scoNActivityesp;
    @Column(name = "SCO_N_ACTIVITYFRA")
    private String scoNActivityfra;
    @Column(name = "SCO_N_ACTIVITYGEN")
    private String scoNActivitygen;
    @Column(name = "SCO_N_ACTIVITYGER")
    private String scoNActivityger;
    @Column(name = "SCO_N_ACTIVITYITA")
    private String scoNActivityita;
    @Column(name = "SCO_NM_POSITIONBRA")
    private String scoNmPositionbra;
    @Column(name = "SCO_NM_POSITIONENG")
    private String scoNmPositioneng;
    @Column(name = "SCO_NM_POSITIONESP")
    private String scoNmPositionesp;
    @Column(name = "SCO_NM_POSITIONFRA")
    private String scoNmPositionfra;
    @Column(name = "SCO_NM_POSITIONGEN")
    private String scoNmPositiongen;
    @Column(name = "SCO_NM_POSITIONGER")
    private String scoNmPositionger;
    @Column(name = "SCO_NM_POSITIONITA")
    private String scoNmPositionita;
    @Column(name = "SCO_COMMENT")
    private String scoComment;
    @Column(name = "SUK_COMPANY_SPONSO")
    private Short sukCompanySponso;
    @Column(name = "SUK_ID_MEMBER_TYPE")
    private String sukIdMemberType;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_NOMBRE")
    private String ccbNombre;
    @Column(name = "CCB_ABREVIATURA")
    private String ccbAbreviatura;
    @Column(name = "CCB_ORG_CONF")
    private String ccbOrgConf;
    @Column(name = "CCB_ACT_ORG")
    private String ccbActOrg;
    @Column(name = "CCB_COORD")
    private String ccbCoord;
    @Column(name = "CCB_ROL_CARG")
    private String ccbRolCarg;
    @Column(name = "CCB_INHER_CARG")
    private String ccbInherCarg;
    @Column(name = "CCB_RESPONSB")
    private String ccbResponsb;
    @Column(name = "CCB_NUM_HORAS")
    private Short ccbNumHoras;
    @Column(name = "CCB_COMPENS")
    private String ccbCompens;
    @Column(name = "CCB_FORMA_ELEC")
    private String ccbFormaElec;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "CCB_ID_ACT_ASC")
    private String ccbIdActAsc;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
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

    public M4scoAssocMe() {
    }

    public M4scoAssocMe(M4scoAssocMePK m4scoAssocMePK) {
        this.m4scoAssocMePK = m4scoAssocMePK;
    }

    public M4scoAssocMe(String idOrganization, String scoIdHr, short scoOrAssocMemb) {
        this.m4scoAssocMePK = new M4scoAssocMePK(idOrganization, scoIdHr, scoOrAssocMemb);
    }

    public M4scoAssocMePK getM4scoAssocMePK() {
        return m4scoAssocMePK;
    }

    public void setM4scoAssocMePK(M4scoAssocMePK m4scoAssocMePK) {
        this.m4scoAssocMePK = m4scoAssocMePK;
    }

    public Date getScoDtStart() {
        return scoDtStart;
    }

    public void setScoDtStart(Date scoDtStart) {
        this.scoDtStart = scoDtStart;
    }

    public Date getScoDtEnd() {
        return scoDtEnd;
    }

    public void setScoDtEnd(Date scoDtEnd) {
        this.scoDtEnd = scoDtEnd;
    }

    public String getScoIdAssociation() {
        return scoIdAssociation;
    }

    public void setScoIdAssociation(String scoIdAssociation) {
        this.scoIdAssociation = scoIdAssociation;
    }

    public String getScoIdAssocType() {
        return scoIdAssocType;
    }

    public void setScoIdAssocType(String scoIdAssocType) {
        this.scoIdAssocType = scoIdAssocType;
    }

    public String getScoNActivitybra() {
        return scoNActivitybra;
    }

    public void setScoNActivitybra(String scoNActivitybra) {
        this.scoNActivitybra = scoNActivitybra;
    }

    public String getScoNActivityeng() {
        return scoNActivityeng;
    }

    public void setScoNActivityeng(String scoNActivityeng) {
        this.scoNActivityeng = scoNActivityeng;
    }

    public String getScoNActivityesp() {
        return scoNActivityesp;
    }

    public void setScoNActivityesp(String scoNActivityesp) {
        this.scoNActivityesp = scoNActivityesp;
    }

    public String getScoNActivityfra() {
        return scoNActivityfra;
    }

    public void setScoNActivityfra(String scoNActivityfra) {
        this.scoNActivityfra = scoNActivityfra;
    }

    public String getScoNActivitygen() {
        return scoNActivitygen;
    }

    public void setScoNActivitygen(String scoNActivitygen) {
        this.scoNActivitygen = scoNActivitygen;
    }

    public String getScoNActivityger() {
        return scoNActivityger;
    }

    public void setScoNActivityger(String scoNActivityger) {
        this.scoNActivityger = scoNActivityger;
    }

    public String getScoNActivityita() {
        return scoNActivityita;
    }

    public void setScoNActivityita(String scoNActivityita) {
        this.scoNActivityita = scoNActivityita;
    }

    public String getScoNmPositionbra() {
        return scoNmPositionbra;
    }

    public void setScoNmPositionbra(String scoNmPositionbra) {
        this.scoNmPositionbra = scoNmPositionbra;
    }

    public String getScoNmPositioneng() {
        return scoNmPositioneng;
    }

    public void setScoNmPositioneng(String scoNmPositioneng) {
        this.scoNmPositioneng = scoNmPositioneng;
    }

    public String getScoNmPositionesp() {
        return scoNmPositionesp;
    }

    public void setScoNmPositionesp(String scoNmPositionesp) {
        this.scoNmPositionesp = scoNmPositionesp;
    }

    public String getScoNmPositionfra() {
        return scoNmPositionfra;
    }

    public void setScoNmPositionfra(String scoNmPositionfra) {
        this.scoNmPositionfra = scoNmPositionfra;
    }

    public String getScoNmPositiongen() {
        return scoNmPositiongen;
    }

    public void setScoNmPositiongen(String scoNmPositiongen) {
        this.scoNmPositiongen = scoNmPositiongen;
    }

    public String getScoNmPositionger() {
        return scoNmPositionger;
    }

    public void setScoNmPositionger(String scoNmPositionger) {
        this.scoNmPositionger = scoNmPositionger;
    }

    public String getScoNmPositionita() {
        return scoNmPositionita;
    }

    public void setScoNmPositionita(String scoNmPositionita) {
        this.scoNmPositionita = scoNmPositionita;
    }

    public String getScoComment() {
        return scoComment;
    }

    public void setScoComment(String scoComment) {
        this.scoComment = scoComment;
    }

    public Short getSukCompanySponso() {
        return sukCompanySponso;
    }

    public void setSukCompanySponso(Short sukCompanySponso) {
        this.sukCompanySponso = sukCompanySponso;
    }

    public String getSukIdMemberType() {
        return sukIdMemberType;
    }

    public void setSukIdMemberType(String sukIdMemberType) {
        this.sukIdMemberType = sukIdMemberType;
    }

    public String getCcbOtroTip() {
        return ccbOtroTip;
    }

    public void setCcbOtroTip(String ccbOtroTip) {
        this.ccbOtroTip = ccbOtroTip;
    }

    public String getCcbNombre() {
        return ccbNombre;
    }

    public void setCcbNombre(String ccbNombre) {
        this.ccbNombre = ccbNombre;
    }

    public String getCcbAbreviatura() {
        return ccbAbreviatura;
    }

    public void setCcbAbreviatura(String ccbAbreviatura) {
        this.ccbAbreviatura = ccbAbreviatura;
    }

    public String getCcbOrgConf() {
        return ccbOrgConf;
    }

    public void setCcbOrgConf(String ccbOrgConf) {
        this.ccbOrgConf = ccbOrgConf;
    }

    public String getCcbActOrg() {
        return ccbActOrg;
    }

    public void setCcbActOrg(String ccbActOrg) {
        this.ccbActOrg = ccbActOrg;
    }

    public String getCcbCoord() {
        return ccbCoord;
    }

    public void setCcbCoord(String ccbCoord) {
        this.ccbCoord = ccbCoord;
    }

    public String getCcbRolCarg() {
        return ccbRolCarg;
    }

    public void setCcbRolCarg(String ccbRolCarg) {
        this.ccbRolCarg = ccbRolCarg;
    }

    public String getCcbInherCarg() {
        return ccbInherCarg;
    }

    public void setCcbInherCarg(String ccbInherCarg) {
        this.ccbInherCarg = ccbInherCarg;
    }

    public String getCcbResponsb() {
        return ccbResponsb;
    }

    public void setCcbResponsb(String ccbResponsb) {
        this.ccbResponsb = ccbResponsb;
    }

    public Short getCcbNumHoras() {
        return ccbNumHoras;
    }

    public void setCcbNumHoras(Short ccbNumHoras) {
        this.ccbNumHoras = ccbNumHoras;
    }

    public String getCcbCompens() {
        return ccbCompens;
    }

    public void setCcbCompens(String ccbCompens) {
        this.ccbCompens = ccbCompens;
    }

    public String getCcbFormaElec() {
        return ccbFormaElec;
    }

    public void setCcbFormaElec(String ccbFormaElec) {
        this.ccbFormaElec = ccbFormaElec;
    }

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
    }

    public String getCcbIdActAsc() {
        return ccbIdActAsc;
    }

    public void setCcbIdActAsc(String ccbIdActAsc) {
        this.ccbIdActAsc = ccbIdActAsc;
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
        hash += (m4scoAssocMePK != null ? m4scoAssocMePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4scoAssocMe)) {
            return false;
        }
        M4scoAssocMe other = (M4scoAssocMe) object;
        if ((this.m4scoAssocMePK == null && other.m4scoAssocMePK != null) || (this.m4scoAssocMePK != null && !this.m4scoAssocMePK.equals(other.m4scoAssocMePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4scoAssocMe[ m4scoAssocMePK=" + m4scoAssocMePK + " ]";
    }
    
}
