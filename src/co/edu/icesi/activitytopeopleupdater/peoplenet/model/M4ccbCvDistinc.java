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
@Table(name = "M4CCB_CV_DISTINC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvDistinc.findAll", query = "SELECT m FROM M4ccbCvDistinc m"),
    @NamedQuery(name = "M4ccbCvDistinc.findByIdOrganization", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.m4ccbCvDistincPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbOrDistinc", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.m4ccbCvDistincPK.ccbOrDistinc = :ccbOrDistinc"),
    @NamedQuery(name = "M4ccbCvDistinc.findByStdIdHr", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.m4ccbCvDistincPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbNomDistinc", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbNomDistinc = :ccbNomDistinc"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbEntidad", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbEntidad = :ccbEntidad"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbFechaRecep", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbFechaRecep = :ccbFechaRecep"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbDescripDist", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbDescripDist = :ccbDescripDist"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbIdDistincion", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbIdDistincion = :ccbIdDistincion"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvDistinc.findByStdIdCountry", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvDistinc.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvDistinc.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvDistinc.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvDistinc.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvDistinc.findByIdApprole", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvDistinc.findByIdSecuser", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvDistinc.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvDistinc m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvDistinc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvDistincPK m4ccbCvDistincPK;
    @Column(name = "CCB_NOM_DISTINC")
    private String ccbNomDistinc;
    @Column(name = "CCB_ENTIDAD")
    private String ccbEntidad;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_FECHA_RECEP")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRecep;
    @Column(name = "CCB_DESCRIP_DIST")
    private String ccbDescripDist;
    @Column(name = "CCB_ID_DISTINCION")
    private String ccbIdDistincion;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
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

    public M4ccbCvDistinc() {
    }

    public M4ccbCvDistinc(M4ccbCvDistincPK m4ccbCvDistincPK) {
        this.m4ccbCvDistincPK = m4ccbCvDistincPK;
    }

    public M4ccbCvDistinc(String idOrganization, short ccbOrDistinc, String stdIdHr) {
        this.m4ccbCvDistincPK = new M4ccbCvDistincPK(idOrganization, ccbOrDistinc, stdIdHr);
    }

    public M4ccbCvDistincPK getM4ccbCvDistincPK() {
        return m4ccbCvDistincPK;
    }

    public void setM4ccbCvDistincPK(M4ccbCvDistincPK m4ccbCvDistincPK) {
        this.m4ccbCvDistincPK = m4ccbCvDistincPK;
    }

    public String getCcbNomDistinc() {
        return ccbNomDistinc;
    }

    public void setCcbNomDistinc(String ccbNomDistinc) {
        this.ccbNomDistinc = ccbNomDistinc;
    }

    public String getCcbEntidad() {
        return ccbEntidad;
    }

    public void setCcbEntidad(String ccbEntidad) {
        this.ccbEntidad = ccbEntidad;
    }

    public String getCcbOtroTip() {
        return ccbOtroTip;
    }

    public void setCcbOtroTip(String ccbOtroTip) {
        this.ccbOtroTip = ccbOtroTip;
    }

    public Date getCcbFechaRecep() {
        return ccbFechaRecep;
    }

    public void setCcbFechaRecep(Date ccbFechaRecep) {
        this.ccbFechaRecep = ccbFechaRecep;
    }

    public String getCcbDescripDist() {
        return ccbDescripDist;
    }

    public void setCcbDescripDist(String ccbDescripDist) {
        this.ccbDescripDist = ccbDescripDist;
    }

    public String getCcbIdDistincion() {
        return ccbIdDistincion;
    }

    public void setCcbIdDistincion(String ccbIdDistincion) {
        this.ccbIdDistincion = ccbIdDistincion;
    }

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
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
        hash += (m4ccbCvDistincPK != null ? m4ccbCvDistincPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvDistinc)) {
            return false;
        }
        M4ccbCvDistinc other = (M4ccbCvDistinc) object;
        if ((this.m4ccbCvDistincPK == null && other.m4ccbCvDistincPK != null) || (this.m4ccbCvDistincPK != null && !this.m4ccbCvDistincPK.equals(other.m4ccbCvDistincPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistinc[ m4ccbCvDistincPK=" + m4ccbCvDistincPK + " ]";
    }
    
}
