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
@Table(name = "M4CCB_CV_TRABA_DIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvTrabaDir.findAll", query = "SELECT m FROM M4ccbCvTrabaDir m"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByIdOrganization", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.m4ccbCvTrabaDirPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbOrTrabDir", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.m4ccbCvTrabaDirPK.ccbOrTrabDir = :ccbOrTrabDir"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByStdIdHr", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.m4ccbCvTrabaDirPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbOtroTip", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbOtroTip = :ccbOtroTip"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbOtroTrab", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbOtroTrab = :ccbOtroTrab"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbNomTrab", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbNomTrab = :ccbNomTrab"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbDistObt", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbDistObt = :ccbDistObt"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbInstUniv", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbInstUniv = :ccbInstUniv"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbFacultad", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbFacultad = :ccbFacultad"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbPrograma", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbPrograma = :ccbPrograma"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbNomEst", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbNomEst = :ccbNomEst"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbFechaIni", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbFechaIni = :ccbFechaIni"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbFechaFin", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbFechaFin = :ccbFechaFin"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbComentario", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbComentario = :ccbComentario"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbUrl", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbIdOrientacion", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbIdOrientacion = :ccbIdOrientacion"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByStdIdLanguage", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.stdIdLanguage = :stdIdLanguage"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbIdTrbDir", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbIdTrbDir = :ccbIdTrbDir"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByCcbIdEstadoAct", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.ccbIdEstadoAct = :ccbIdEstadoAct"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByStdIdCountry", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByIdApprole", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByIdSecuser", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvTrabaDir.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvTrabaDir m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvTrabaDir implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvTrabaDirPK m4ccbCvTrabaDirPK;
    @Column(name = "CCB_OTRO_TIP")
    private String ccbOtroTip;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_OTRO_TRAB")
    private String ccbOtroTrab;
    @Column(name = "CCB_NOM_TRAB")
    private String ccbNomTrab;
    @Column(name = "CCB_DIST_OBT")
    private String ccbDistObt;
    @Column(name = "CCB_INST_UNIV")
    private String ccbInstUniv;
    @Column(name = "CCB_FACULTAD")
    private String ccbFacultad;
    @Column(name = "CCB_PROGRAMA")
    private String ccbPrograma;
    @Column(name = "CCB_NOM_EST")
    private String ccbNomEst;
    @Column(name = "CCB_FECHA_INI")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaIni;
    @Column(name = "CCB_FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaFin;
    @Column(name = "CCB_COMENTARIO")
    private String ccbComentario;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_ID_ORIENTACION")
    private String ccbIdOrientacion;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "STD_ID_LANGUAGE")
    private String stdIdLanguage;
    @Column(name = "CCB_ID_TRB_DIR")
    private String ccbIdTrbDir;
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
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvTrabaDir() {
    }

    public M4ccbCvTrabaDir(M4ccbCvTrabaDirPK m4ccbCvTrabaDirPK) {
        this.m4ccbCvTrabaDirPK = m4ccbCvTrabaDirPK;
    }

    public M4ccbCvTrabaDir(String idOrganization, short ccbOrTrabDir, String stdIdHr) {
        this.m4ccbCvTrabaDirPK = new M4ccbCvTrabaDirPK(idOrganization, ccbOrTrabDir, stdIdHr);
    }

    public M4ccbCvTrabaDirPK getM4ccbCvTrabaDirPK() {
        return m4ccbCvTrabaDirPK;
    }

    public void setM4ccbCvTrabaDirPK(M4ccbCvTrabaDirPK m4ccbCvTrabaDirPK) {
        this.m4ccbCvTrabaDirPK = m4ccbCvTrabaDirPK;
    }

    public String getCcbOtroTip() {
        return ccbOtroTip;
    }

    public void setCcbOtroTip(String ccbOtroTip) {
        this.ccbOtroTip = ccbOtroTip;
    }

    public String getCcbOtraCat() {
        return ccbOtraCat;
    }

    public void setCcbOtraCat(String ccbOtraCat) {
        this.ccbOtraCat = ccbOtraCat;
    }

    public String getCcbOtroTrab() {
        return ccbOtroTrab;
    }

    public void setCcbOtroTrab(String ccbOtroTrab) {
        this.ccbOtroTrab = ccbOtroTrab;
    }

    public String getCcbNomTrab() {
        return ccbNomTrab;
    }

    public void setCcbNomTrab(String ccbNomTrab) {
        this.ccbNomTrab = ccbNomTrab;
    }

    public String getCcbDistObt() {
        return ccbDistObt;
    }

    public void setCcbDistObt(String ccbDistObt) {
        this.ccbDistObt = ccbDistObt;
    }

    public String getCcbInstUniv() {
        return ccbInstUniv;
    }

    public void setCcbInstUniv(String ccbInstUniv) {
        this.ccbInstUniv = ccbInstUniv;
    }

    public String getCcbFacultad() {
        return ccbFacultad;
    }

    public void setCcbFacultad(String ccbFacultad) {
        this.ccbFacultad = ccbFacultad;
    }

    public String getCcbPrograma() {
        return ccbPrograma;
    }

    public void setCcbPrograma(String ccbPrograma) {
        this.ccbPrograma = ccbPrograma;
    }

    public String getCcbNomEst() {
        return ccbNomEst;
    }

    public void setCcbNomEst(String ccbNomEst) {
        this.ccbNomEst = ccbNomEst;
    }

    public Date getCcbFechaIni() {
        return ccbFechaIni;
    }

    public void setCcbFechaIni(Date ccbFechaIni) {
        this.ccbFechaIni = ccbFechaIni;
    }

    public Date getCcbFechaFin() {
        return ccbFechaFin;
    }

    public void setCcbFechaFin(Date ccbFechaFin) {
        this.ccbFechaFin = ccbFechaFin;
    }

    public String getCcbComentario() {
        return ccbComentario;
    }

    public void setCcbComentario(String ccbComentario) {
        this.ccbComentario = ccbComentario;
    }

    public String getCcbUrl() {
        return ccbUrl;
    }

    public void setCcbUrl(String ccbUrl) {
        this.ccbUrl = ccbUrl;
    }

    public String getCcbIdOrientacion() {
        return ccbIdOrientacion;
    }

    public void setCcbIdOrientacion(String ccbIdOrientacion) {
        this.ccbIdOrientacion = ccbIdOrientacion;
    }

    public String getCcbIdCategoria() {
        return ccbIdCategoria;
    }

    public void setCcbIdCategoria(String ccbIdCategoria) {
        this.ccbIdCategoria = ccbIdCategoria;
    }

    public String getCcbIdValPares() {
        return ccbIdValPares;
    }

    public void setCcbIdValPares(String ccbIdValPares) {
        this.ccbIdValPares = ccbIdValPares;
    }

    public String getStdIdLanguage() {
        return stdIdLanguage;
    }

    public void setStdIdLanguage(String stdIdLanguage) {
        this.stdIdLanguage = stdIdLanguage;
    }

    public String getCcbIdTrbDir() {
        return ccbIdTrbDir;
    }

    public void setCcbIdTrbDir(String ccbIdTrbDir) {
        this.ccbIdTrbDir = ccbIdTrbDir;
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
        hash += (m4ccbCvTrabaDirPK != null ? m4ccbCvTrabaDirPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvTrabaDir)) {
            return false;
        }
        M4ccbCvTrabaDir other = (M4ccbCvTrabaDir) object;
        if ((this.m4ccbCvTrabaDirPK == null && other.m4ccbCvTrabaDirPK != null) || (this.m4ccbCvTrabaDirPK != null && !this.m4ccbCvTrabaDirPK.equals(other.m4ccbCvTrabaDirPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvTrabaDir[ m4ccbCvTrabaDirPK=" + m4ccbCvTrabaDirPK + " ]";
    }
    
}
