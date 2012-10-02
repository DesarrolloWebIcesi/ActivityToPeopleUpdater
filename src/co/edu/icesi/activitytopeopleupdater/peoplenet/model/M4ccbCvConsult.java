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
@Table(name = "M4CCB_CV_CONSULT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvConsult.findAll", query = "SELECT m FROM M4ccbCvConsult m"),
    @NamedQuery(name = "M4ccbCvConsult.findByIdOrganization", query = "SELECT m FROM M4ccbCvConsult m WHERE m.m4ccbCvConsultPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbOrConsult", query = "SELECT m FROM M4ccbCvConsult m WHERE m.m4ccbCvConsultPK.ccbOrConsult = :ccbOrConsult"),
    @NamedQuery(name = "M4ccbCvConsult.findByStdIdHr", query = "SELECT m FROM M4ccbCvConsult m WHERE m.m4ccbCvConsultPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbDtStart", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbDtStart = :ccbDtStart"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbDtEnd", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbDtEnd = :ccbDtEnd"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbEmpOrg", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbEmpOrg = :ccbEmpOrg"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbNomProy", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbNomProy = :ccbNomProy"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbRolAct", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbRolAct = :ccbRolAct"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbTotalProy", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbTotalProy = :ccbTotalProy"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbCompensado", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbCompensado = :ccbCompensado"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbValPagar", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbValPagar = :ccbValPagar"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbNumHoras", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbNumHoras = :ccbNumHoras"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbActDes", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbActDes = :ccbActDes"),
    @NamedQuery(name = "M4ccbCvConsult.findByStdIdCountry", query = "SELECT m FROM M4ccbCvConsult m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbIdConsultoria", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbIdConsultoria = :ccbIdConsultoria"),
    @NamedQuery(name = "M4ccbCvConsult.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvConsult m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvConsult.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvConsult m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvConsult.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvConsult m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvConsult.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvConsult m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvConsult.findByIdApprole", query = "SELECT m FROM M4ccbCvConsult m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvConsult.findByIdSecuser", query = "SELECT m FROM M4ccbCvConsult m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvConsult.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvConsult m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvConsult implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvConsultPK m4ccbCvConsultPK;
    @Column(name = "CCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date ccbDtStart;
    @Column(name = "CCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnd;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_EMP_ORG")
    private String ccbEmpOrg;
    @Column(name = "CCB_NOM_PROY")
    private String ccbNomProy;
    @Column(name = "CCB_ROL_ACT")
    private String ccbRolAct;
    @Column(name = "CCB_TOTAL_PROY")
    private Long ccbTotalProy;
    @Column(name = "CCB_COMPENSADO")
    private String ccbCompensado;
    @Column(name = "CCB_VAL_PAGAR")
    private Long ccbValPagar;
    @Column(name = "CCB_NUM_HORAS")
    private String ccbNumHoras;
    @Column(name = "CCB_ACT_DES")
    private String ccbActDes;
    @Column(name = "STD_ID_COUNTRY")
    private String stdIdCountry;
    @Column(name = "CCB_ID_CONSULTORIA")
    private String ccbIdConsultoria;
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

    public M4ccbCvConsult() {
    }

    public M4ccbCvConsult(M4ccbCvConsultPK m4ccbCvConsultPK) {
        this.m4ccbCvConsultPK = m4ccbCvConsultPK;
    }

    public M4ccbCvConsult(String idOrganization, short ccbOrConsult, String stdIdHr) {
        this.m4ccbCvConsultPK = new M4ccbCvConsultPK(idOrganization, ccbOrConsult, stdIdHr);
    }

    public M4ccbCvConsultPK getM4ccbCvConsultPK() {
        return m4ccbCvConsultPK;
    }

    public void setM4ccbCvConsultPK(M4ccbCvConsultPK m4ccbCvConsultPK) {
        this.m4ccbCvConsultPK = m4ccbCvConsultPK;
    }

    public Date getCcbDtStart() {
        return ccbDtStart;
    }

    public void setCcbDtStart(Date ccbDtStart) {
        this.ccbDtStart = ccbDtStart;
    }

    public Date getCcbDtEnd() {
        return ccbDtEnd;
    }

    public void setCcbDtEnd(Date ccbDtEnd) {
        this.ccbDtEnd = ccbDtEnd;
    }

    public String getCcbOtroTip() {
        return ccbOtroTip;
    }

    public void setCcbOtroTip(String ccbOtroTip) {
        this.ccbOtroTip = ccbOtroTip;
    }

    public String getCcbEmpOrg() {
        return ccbEmpOrg;
    }

    public void setCcbEmpOrg(String ccbEmpOrg) {
        this.ccbEmpOrg = ccbEmpOrg;
    }

    public String getCcbNomProy() {
        return ccbNomProy;
    }

    public void setCcbNomProy(String ccbNomProy) {
        this.ccbNomProy = ccbNomProy;
    }

    public String getCcbRolAct() {
        return ccbRolAct;
    }

    public void setCcbRolAct(String ccbRolAct) {
        this.ccbRolAct = ccbRolAct;
    }

    public Long getCcbTotalProy() {
        return ccbTotalProy;
    }

    public void setCcbTotalProy(Long ccbTotalProy) {
        this.ccbTotalProy = ccbTotalProy;
    }

    public String getCcbCompensado() {
        return ccbCompensado;
    }

    public void setCcbCompensado(String ccbCompensado) {
        this.ccbCompensado = ccbCompensado;
    }

    public Long getCcbValPagar() {
        return ccbValPagar;
    }

    public void setCcbValPagar(Long ccbValPagar) {
        this.ccbValPagar = ccbValPagar;
    }

    public String getCcbNumHoras() {
        return ccbNumHoras;
    }

    public void setCcbNumHoras(String ccbNumHoras) {
        this.ccbNumHoras = ccbNumHoras;
    }

    public String getCcbActDes() {
        return ccbActDes;
    }

    public void setCcbActDes(String ccbActDes) {
        this.ccbActDes = ccbActDes;
    }

    public String getStdIdCountry() {
        return stdIdCountry;
    }

    public void setStdIdCountry(String stdIdCountry) {
        this.stdIdCountry = stdIdCountry;
    }

    public String getCcbIdConsultoria() {
        return ccbIdConsultoria;
    }

    public void setCcbIdConsultoria(String ccbIdConsultoria) {
        this.ccbIdConsultoria = ccbIdConsultoria;
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
        hash += (m4ccbCvConsultPK != null ? m4ccbCvConsultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvConsult)) {
            return false;
        }
        M4ccbCvConsult other = (M4ccbCvConsult) object;
        if ((this.m4ccbCvConsultPK == null && other.m4ccbCvConsultPK != null) || (this.m4ccbCvConsultPK != null && !this.m4ccbCvConsultPK.equals(other.m4ccbCvConsultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsult[ m4ccbCvConsultPK=" + m4ccbCvConsultPK + " ]";
    }
    
}
