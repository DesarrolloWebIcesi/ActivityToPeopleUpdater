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
@Table(name = "M4CCB_CV_CUR_CDUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvCurCdur.findAll", query = "SELECT m FROM M4ccbCvCurCdur m"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByIdOrganization", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.m4ccbCvCurCdurPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbOrCurCdur", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.m4ccbCvCurCdurPK.ccbOrCurCdur = :ccbOrCurCdur"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByStdIdHr", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.m4ccbCvCurCdurPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbDtStart", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbDtStart = :ccbDtStart"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbDtEnd", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbDtEnd = :ccbDtEnd"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbInstEmp", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbInstEmp = :ccbInstEmp"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbRamaAcad", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbRamaAcad = :ccbRamaAcad"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbOtroInst", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbOtroInst = :ccbOtroInst"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbNomCurso", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbNomCurso = :ccbNomCurso"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbActCargo", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbActCargo = :ccbActCargo"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbHorasDict", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbHorasDict = :ccbHorasDict"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbCurCerr", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbCurCerr = :ccbCurCerr"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbNumPart", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbNumPart = :ccbNumPart"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbDescAct", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbDescAct = :ccbDescAct"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbUrl", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbIdInstruc", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbIdInstruc = :ccbIdInstruc"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbIdAudiencia", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbIdAudiencia = :ccbIdAudiencia"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByStdIdCountry", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByIdApprole", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByIdSecuser", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvCurCdur.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvCurCdur m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvCurCdur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvCurCdurPK m4ccbCvCurCdurPK;
    @Column(name = "CCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date ccbDtStart;
    @Column(name = "CCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnd;
    @Column(name = "CCB_INST_EMP")
    private String ccbInstEmp;
    @Column(name = "CCB_RAMA_ACAD")
    private String ccbRamaAcad;
    @Column(name = "CCB_OTRO_INST")
    private String ccbOtroInst;
    @Column(name = "CCB_NOM_CURSO")
    private String ccbNomCurso;
    @Column(name = "CCB_ACT_CARGO")
    private String ccbActCargo;
    @Column(name = "CCB_HORAS_DICT")
    private String ccbHorasDict;
    @Column(name = "CCB_CUR_CERR")
    private String ccbCurCerr;
    @Column(name = "CCB_NUM_PART")
    private String ccbNumPart;
    @Column(name = "CCB_DESC_ACT")
    private String ccbDescAct;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_INSTRUC")
    private String ccbIdInstruc;
    @Column(name = "CCB_ID_AUDIENCIA")
    private String ccbIdAudiencia;
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

    public M4ccbCvCurCdur() {
    }

    public M4ccbCvCurCdur(M4ccbCvCurCdurPK m4ccbCvCurCdurPK) {
        this.m4ccbCvCurCdurPK = m4ccbCvCurCdurPK;
    }

    public M4ccbCvCurCdur(String idOrganization, short ccbOrCurCdur, String stdIdHr) {
        this.m4ccbCvCurCdurPK = new M4ccbCvCurCdurPK(idOrganization, ccbOrCurCdur, stdIdHr);
    }

    public M4ccbCvCurCdurPK getM4ccbCvCurCdurPK() {
        return m4ccbCvCurCdurPK;
    }

    public void setM4ccbCvCurCdurPK(M4ccbCvCurCdurPK m4ccbCvCurCdurPK) {
        this.m4ccbCvCurCdurPK = m4ccbCvCurCdurPK;
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

    public String getCcbInstEmp() {
        return ccbInstEmp;
    }

    public void setCcbInstEmp(String ccbInstEmp) {
        this.ccbInstEmp = ccbInstEmp;
    }

    public String getCcbRamaAcad() {
        return ccbRamaAcad;
    }

    public void setCcbRamaAcad(String ccbRamaAcad) {
        this.ccbRamaAcad = ccbRamaAcad;
    }

    public String getCcbOtroInst() {
        return ccbOtroInst;
    }

    public void setCcbOtroInst(String ccbOtroInst) {
        this.ccbOtroInst = ccbOtroInst;
    }

    public String getCcbNomCurso() {
        return ccbNomCurso;
    }

    public void setCcbNomCurso(String ccbNomCurso) {
        this.ccbNomCurso = ccbNomCurso;
    }

    public String getCcbActCargo() {
        return ccbActCargo;
    }

    public void setCcbActCargo(String ccbActCargo) {
        this.ccbActCargo = ccbActCargo;
    }

    public String getCcbHorasDict() {
        return ccbHorasDict;
    }

    public void setCcbHorasDict(String ccbHorasDict) {
        this.ccbHorasDict = ccbHorasDict;
    }

    public String getCcbCurCerr() {
        return ccbCurCerr;
    }

    public void setCcbCurCerr(String ccbCurCerr) {
        this.ccbCurCerr = ccbCurCerr;
    }

    public String getCcbNumPart() {
        return ccbNumPart;
    }

    public void setCcbNumPart(String ccbNumPart) {
        this.ccbNumPart = ccbNumPart;
    }

    public String getCcbDescAct() {
        return ccbDescAct;
    }

    public void setCcbDescAct(String ccbDescAct) {
        this.ccbDescAct = ccbDescAct;
    }

    public String getCcbUrl() {
        return ccbUrl;
    }

    public void setCcbUrl(String ccbUrl) {
        this.ccbUrl = ccbUrl;
    }

    public String getCcbIdInstruc() {
        return ccbIdInstruc;
    }

    public void setCcbIdInstruc(String ccbIdInstruc) {
        this.ccbIdInstruc = ccbIdInstruc;
    }

    public String getCcbIdAudiencia() {
        return ccbIdAudiencia;
    }

    public void setCcbIdAudiencia(String ccbIdAudiencia) {
        this.ccbIdAudiencia = ccbIdAudiencia;
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
        hash += (m4ccbCvCurCdurPK != null ? m4ccbCvCurCdurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvCurCdur)) {
            return false;
        }
        M4ccbCvCurCdur other = (M4ccbCvCurCdur) object;
        if ((this.m4ccbCvCurCdurPK == null && other.m4ccbCvCurCdurPK != null) || (this.m4ccbCvCurCdurPK != null && !this.m4ccbCvCurCdurPK.equals(other.m4ccbCvCurCdurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvCurCdur[ m4ccbCvCurCdurPK=" + m4ccbCvCurCdurPK + " ]";
    }
    
}
