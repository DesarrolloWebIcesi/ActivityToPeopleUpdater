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
@Table(name = "M4CCB_CV_ACT_INVES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvActInves.findAll", query = "SELECT m FROM M4ccbCvActInves m"),
    @NamedQuery(name = "M4ccbCvActInves.findByIdOrganization", query = "SELECT m FROM M4ccbCvActInves m WHERE m.m4ccbCvActInvesPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbOrActInv", query = "SELECT m FROM M4ccbCvActInves m WHERE m.m4ccbCvActInvesPK.ccbOrActInv = :ccbOrActInv"),
    @NamedQuery(name = "M4ccbCvActInves.findByStdIdHr", query = "SELECT m FROM M4ccbCvActInves m WHERE m.m4ccbCvActInvesPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbDtStart", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbDtStart = :ccbDtStart"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbDtEnd", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbDtEnd = :ccbDtEnd"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbOtraAct", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbOtraAct = :ccbOtraAct"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbOtraRea", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbOtraRea = :ccbOtraRea"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbTituloProy", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbTituloProy = :ccbTituloProy"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbInstitucion", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbInstitucion = :ccbInstitucion"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbFacultad", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbFacultad = :ccbFacultad"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbDepto", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbDepto = :ccbDepto"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbOtrOrg", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbOtrOrg = :ccbOtrOrg"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbOtrPart", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbOtrPart = :ccbOtrPart"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbRolAct", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbRolAct = :ccbRolAct"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbValorProy", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbValorProy = :ccbValorProy"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbOtrEst", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbOtrEst = :ccbOtrEst"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbDtEnvio", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbDtEnvio = :ccbDtEnvio"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbDtProp", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbDtProp = :ccbDtProp"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbResumInv", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbResumInv = :ccbResumInv"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbUrl", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbIdActInv", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbIdActInv = :ccbIdActInv"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbIdAreaEstrat", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbIdAreaEstrat = :ccbIdAreaEstrat"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbIdOrganiz", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbIdOrganiz = :ccbIdOrganiz"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbIdEstInves", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbIdEstInves = :ccbIdEstInves"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbIdEstadoAct", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbIdEstadoAct = :ccbIdEstadoAct"),
    @NamedQuery(name = "M4ccbCvActInves.findByStdIdCountry", query = "SELECT m FROM M4ccbCvActInves m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvActInves.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvActInves m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvActInves.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvActInves m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvActInves.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvActInves m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvActInves.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvActInves m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvActInves.findByIdApprole", query = "SELECT m FROM M4ccbCvActInves m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvActInves.findByIdSecuser", query = "SELECT m FROM M4ccbCvActInves m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvActInves.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvActInves m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvActInves implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvActInvesPK m4ccbCvActInvesPK;
    @Column(name = "CCB_DT_START")
    @Temporal(TemporalType.DATE)
    private Date ccbDtStart;
    @Column(name = "CCB_DT_END")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnd;
    @Column(name = "CCB_OTRA_ACT")
    private String ccbOtraAct;
    @Column(name = "CCB_OTRA_REA")
    private String ccbOtraRea;
    @Column(name = "CCB_TITULO_PROY")
    private String ccbTituloProy;
    @Column(name = "CCB_INSTITUCION")
    private String ccbInstitucion;
    @Column(name = "CCB_FACULTAD")
    private String ccbFacultad;
    @Column(name = "CCB_DEPTO")
    private String ccbDepto;
    @Column(name = "CCB_OTR_ORG")
    private String ccbOtrOrg;
    @Column(name = "CCB_OTR_PART")
    private String ccbOtrPart;
    @Column(name = "CCB_ROL_ACT")
    private String ccbRolAct;
    @Column(name = "CCB_VALOR_PROY")
    private Integer ccbValorProy;
    @Column(name = "CCB_OTR_EST")
    private String ccbOtrEst;
    @Column(name = "CCB_DT_ENVIO")
    @Temporal(TemporalType.DATE)
    private Date ccbDtEnvio;
    @Column(name = "CCB_DT_PROP")
    @Temporal(TemporalType.DATE)
    private Date ccbDtProp;
    @Column(name = "CCB_RESUM_INV")
    private String ccbResumInv;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_ACT_INV")
    private String ccbIdActInv;
    @Column(name = "CCB_ID_AREA_ESTRAT")
    private String ccbIdAreaEstrat;
    @Column(name = "CCB_ID_ORGANIZ")
    private String ccbIdOrganiz;
    @Column(name = "CCB_ID_EST_INVES")
    private String ccbIdEstInves;
    @Column(name = "CCB_ID_ESTADO_ACT")
    private String ccbIdEstadoAct;
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

    public M4ccbCvActInves() {
    }

    public M4ccbCvActInves(M4ccbCvActInvesPK m4ccbCvActInvesPK) {
        this.m4ccbCvActInvesPK = m4ccbCvActInvesPK;
    }

    public M4ccbCvActInves(String idOrganization, short ccbOrActInv, String stdIdHr) {
        this.m4ccbCvActInvesPK = new M4ccbCvActInvesPK(idOrganization, ccbOrActInv, stdIdHr);
    }

    public M4ccbCvActInvesPK getM4ccbCvActInvesPK() {
        return m4ccbCvActInvesPK;
    }

    public void setM4ccbCvActInvesPK(M4ccbCvActInvesPK m4ccbCvActInvesPK) {
        this.m4ccbCvActInvesPK = m4ccbCvActInvesPK;
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

    public String getCcbOtraAct() {
        return ccbOtraAct;
    }

    public void setCcbOtraAct(String ccbOtraAct) {
        this.ccbOtraAct = ccbOtraAct;
    }

    public String getCcbOtraRea() {
        return ccbOtraRea;
    }

    public void setCcbOtraRea(String ccbOtraRea) {
        this.ccbOtraRea = ccbOtraRea;
    }

    public String getCcbTituloProy() {
        return ccbTituloProy;
    }

    public void setCcbTituloProy(String ccbTituloProy) {
        this.ccbTituloProy = ccbTituloProy;
    }

    public String getCcbInstitucion() {
        return ccbInstitucion;
    }

    public void setCcbInstitucion(String ccbInstitucion) {
        this.ccbInstitucion = ccbInstitucion;
    }

    public String getCcbFacultad() {
        return ccbFacultad;
    }

    public void setCcbFacultad(String ccbFacultad) {
        this.ccbFacultad = ccbFacultad;
    }

    public String getCcbDepto() {
        return ccbDepto;
    }

    public void setCcbDepto(String ccbDepto) {
        this.ccbDepto = ccbDepto;
    }

    public String getCcbOtrOrg() {
        return ccbOtrOrg;
    }

    public void setCcbOtrOrg(String ccbOtrOrg) {
        this.ccbOtrOrg = ccbOtrOrg;
    }

    public String getCcbOtrPart() {
        return ccbOtrPart;
    }

    public void setCcbOtrPart(String ccbOtrPart) {
        this.ccbOtrPart = ccbOtrPart;
    }

    public String getCcbRolAct() {
        return ccbRolAct;
    }

    public void setCcbRolAct(String ccbRolAct) {
        this.ccbRolAct = ccbRolAct;
    }

    public Integer getCcbValorProy() {
        return ccbValorProy;
    }

    public void setCcbValorProy(Integer ccbValorProy) {
        this.ccbValorProy = ccbValorProy;
    }

    public String getCcbOtrEst() {
        return ccbOtrEst;
    }

    public void setCcbOtrEst(String ccbOtrEst) {
        this.ccbOtrEst = ccbOtrEst;
    }

    public Date getCcbDtEnvio() {
        return ccbDtEnvio;
    }

    public void setCcbDtEnvio(Date ccbDtEnvio) {
        this.ccbDtEnvio = ccbDtEnvio;
    }

    public Date getCcbDtProp() {
        return ccbDtProp;
    }

    public void setCcbDtProp(Date ccbDtProp) {
        this.ccbDtProp = ccbDtProp;
    }

    public String getCcbResumInv() {
        return ccbResumInv;
    }

    public void setCcbResumInv(String ccbResumInv) {
        this.ccbResumInv = ccbResumInv;
    }

    public String getCcbUrl() {
        return ccbUrl;
    }

    public void setCcbUrl(String ccbUrl) {
        this.ccbUrl = ccbUrl;
    }

    public String getCcbIdActInv() {
        return ccbIdActInv;
    }

    public void setCcbIdActInv(String ccbIdActInv) {
        this.ccbIdActInv = ccbIdActInv;
    }

    public String getCcbIdAreaEstrat() {
        return ccbIdAreaEstrat;
    }

    public void setCcbIdAreaEstrat(String ccbIdAreaEstrat) {
        this.ccbIdAreaEstrat = ccbIdAreaEstrat;
    }

    public String getCcbIdOrganiz() {
        return ccbIdOrganiz;
    }

    public void setCcbIdOrganiz(String ccbIdOrganiz) {
        this.ccbIdOrganiz = ccbIdOrganiz;
    }

    public String getCcbIdEstInves() {
        return ccbIdEstInves;
    }

    public void setCcbIdEstInves(String ccbIdEstInves) {
        this.ccbIdEstInves = ccbIdEstInves;
    }

    public String getCcbIdEstadoAct() {
        return ccbIdEstadoAct;
    }

    public void setCcbIdEstadoAct(String ccbIdEstadoAct) {
        this.ccbIdEstadoAct = ccbIdEstadoAct;
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
        hash += (m4ccbCvActInvesPK != null ? m4ccbCvActInvesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvActInves)) {
            return false;
        }
        M4ccbCvActInves other = (M4ccbCvActInves) object;
        if ((this.m4ccbCvActInvesPK == null && other.m4ccbCvActInvesPK != null) || (this.m4ccbCvActInvesPK != null && !this.m4ccbCvActInvesPK.equals(other.m4ccbCvActInvesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvActInves[ m4ccbCvActInvesPK=" + m4ccbCvActInvesPK + " ]";
    }
    
}
