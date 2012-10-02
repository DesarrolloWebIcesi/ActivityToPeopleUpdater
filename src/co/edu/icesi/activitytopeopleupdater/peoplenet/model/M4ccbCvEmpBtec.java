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
@Table(name = "M4CCB_CV_EMP_BTEC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvEmpBtec.findAll", query = "SELECT m FROM M4ccbCvEmpBtec m"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByIdOrganization", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.m4ccbCvEmpBtecPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbOrBtecg", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.m4ccbCvEmpBtecPK.ccbOrBtecg = :ccbOrBtecg"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByStdIdHr", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.m4ccbCvEmpBtecPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbOtraCat", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbOtraCat = :ccbOtraCat"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbPatente", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbPatente = :ccbPatente"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbDerAut", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbDerAut = :ccbDerAut"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbNit", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbNit = :ccbNit"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbNomEmp", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbNomEmp = :ccbNomEmp"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbCoautores", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbCoautores = :ccbCoautores"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbListaNac", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbListaNac = :ccbListaNac"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbLicenPrinc", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbLicenPrinc = :ccbLicenPrinc"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbPosDerechos", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbPosDerechos = :ccbPosDerechos"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbFechaCreacion", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbFechaCreacion = :ccbFechaCreacion"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbFechaSolicitud", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbFechaSolicitud = :ccbFechaSolicitud"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbFechaAprob", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbFechaAprob = :ccbFechaAprob"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbFechaPatente", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbFechaPatente = :ccbFechaPatente"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbFechaRenov", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbFechaRenov = :ccbFechaRenov"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbDescripcion", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbDescripcion = :ccbDescripcion"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbUrl", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbUrl = :ccbUrl"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbDireccion", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbDireccion = :ccbDireccion"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbTelefono", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbTelefono = :ccbTelefono"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbIdCategoria", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbIdCategoria = :ccbIdCategoria"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbIdValPares", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbIdValPares = :ccbIdValPares"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbIdAmbito", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbIdAmbito = :ccbIdAmbito"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbIdNacPatent", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbIdNacPatent = :ccbIdNacPatent"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByStdIdCountry", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.stdIdCountry = :stdIdCountry"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByStdIdGeoDiv", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.stdIdGeoDiv = :stdIdGeoDiv"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByStdIdSubGeoDiv", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.stdIdSubGeoDiv = :stdIdSubGeoDiv"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByStdIdGeoPlace", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.stdIdGeoPlace = :stdIdGeoPlace"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByCcbCargueAct", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.ccbCargueAct = :ccbCargueAct"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByIdApprole", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByIdSecuser", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvEmpBtec.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvEmpBtec m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvEmpBtec implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvEmpBtecPK m4ccbCvEmpBtecPK;
    @Column(name = "CCB_OTRA_CAT")
    private String ccbOtraCat;
    @Column(name = "CCB_PATENTE")
    private String ccbPatente;
    @Column(name = "CCB_DER_AUT")
    private String ccbDerAut;
    @Column(name = "CCB_NIT")
    private String ccbNit;
    @Column(name = "CCB_NOM_EMP")
    private String ccbNomEmp;
    @Column(name = "CCB_COAUTORES")
    private String ccbCoautores;
    @Column(name = "CCB_LISTA_NAC")
    private String ccbListaNac;
    @Column(name = "CCB_LICEN_PRINC")
    private String ccbLicenPrinc;
    @Column(name = "CCB_POS_DERECHOS")
    private String ccbPosDerechos;
    @Column(name = "CCB_FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaCreacion;
    @Column(name = "CCB_FECHA_SOLICITUD")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaSolicitud;
    @Column(name = "CCB_FECHA_APROB")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaAprob;
    @Column(name = "CCB_FECHA_PATENTE")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPatente;
    @Column(name = "CCB_FECHA_RENOV")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaRenov;
    @Column(name = "CCB_DESCRIPCION")
    private String ccbDescripcion;
    @Column(name = "CCB_URL")
    private String ccbUrl;
    @Column(name = "CCB_DIRECCION")
    private String ccbDireccion;
    @Column(name = "CCB_TELEFONO")
    private String ccbTelefono;
    @Column(name = "CCB_ID_CATEGORIA")
    private String ccbIdCategoria;
    @Column(name = "CCB_ID_VAL_PARES")
    private String ccbIdValPares;
    @Column(name = "CCB_ID_AMBITO")
    private String ccbIdAmbito;
    @Column(name = "CCB_ID_NAC_PATENT")
    private String ccbIdNacPatent;
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

    public M4ccbCvEmpBtec() {
    }

    public M4ccbCvEmpBtec(M4ccbCvEmpBtecPK m4ccbCvEmpBtecPK) {
        this.m4ccbCvEmpBtecPK = m4ccbCvEmpBtecPK;
    }

    public M4ccbCvEmpBtec(String idOrganization, short ccbOrBtecg, String stdIdHr) {
        this.m4ccbCvEmpBtecPK = new M4ccbCvEmpBtecPK(idOrganization, ccbOrBtecg, stdIdHr);
    }

    public M4ccbCvEmpBtecPK getM4ccbCvEmpBtecPK() {
        return m4ccbCvEmpBtecPK;
    }

    public void setM4ccbCvEmpBtecPK(M4ccbCvEmpBtecPK m4ccbCvEmpBtecPK) {
        this.m4ccbCvEmpBtecPK = m4ccbCvEmpBtecPK;
    }

    public String getCcbOtraCat() {
        return ccbOtraCat;
    }

    public void setCcbOtraCat(String ccbOtraCat) {
        this.ccbOtraCat = ccbOtraCat;
    }

    public String getCcbPatente() {
        return ccbPatente;
    }

    public void setCcbPatente(String ccbPatente) {
        this.ccbPatente = ccbPatente;
    }

    public String getCcbDerAut() {
        return ccbDerAut;
    }

    public void setCcbDerAut(String ccbDerAut) {
        this.ccbDerAut = ccbDerAut;
    }

    public String getCcbNit() {
        return ccbNit;
    }

    public void setCcbNit(String ccbNit) {
        this.ccbNit = ccbNit;
    }

    public String getCcbNomEmp() {
        return ccbNomEmp;
    }

    public void setCcbNomEmp(String ccbNomEmp) {
        this.ccbNomEmp = ccbNomEmp;
    }

    public String getCcbCoautores() {
        return ccbCoautores;
    }

    public void setCcbCoautores(String ccbCoautores) {
        this.ccbCoautores = ccbCoautores;
    }

    public String getCcbListaNac() {
        return ccbListaNac;
    }

    public void setCcbListaNac(String ccbListaNac) {
        this.ccbListaNac = ccbListaNac;
    }

    public String getCcbLicenPrinc() {
        return ccbLicenPrinc;
    }

    public void setCcbLicenPrinc(String ccbLicenPrinc) {
        this.ccbLicenPrinc = ccbLicenPrinc;
    }

    public String getCcbPosDerechos() {
        return ccbPosDerechos;
    }

    public void setCcbPosDerechos(String ccbPosDerechos) {
        this.ccbPosDerechos = ccbPosDerechos;
    }

    public Date getCcbFechaCreacion() {
        return ccbFechaCreacion;
    }

    public void setCcbFechaCreacion(Date ccbFechaCreacion) {
        this.ccbFechaCreacion = ccbFechaCreacion;
    }

    public Date getCcbFechaSolicitud() {
        return ccbFechaSolicitud;
    }

    public void setCcbFechaSolicitud(Date ccbFechaSolicitud) {
        this.ccbFechaSolicitud = ccbFechaSolicitud;
    }

    public Date getCcbFechaAprob() {
        return ccbFechaAprob;
    }

    public void setCcbFechaAprob(Date ccbFechaAprob) {
        this.ccbFechaAprob = ccbFechaAprob;
    }

    public Date getCcbFechaPatente() {
        return ccbFechaPatente;
    }

    public void setCcbFechaPatente(Date ccbFechaPatente) {
        this.ccbFechaPatente = ccbFechaPatente;
    }

    public Date getCcbFechaRenov() {
        return ccbFechaRenov;
    }

    public void setCcbFechaRenov(Date ccbFechaRenov) {
        this.ccbFechaRenov = ccbFechaRenov;
    }

    public String getCcbDescripcion() {
        return ccbDescripcion;
    }

    public void setCcbDescripcion(String ccbDescripcion) {
        this.ccbDescripcion = ccbDescripcion;
    }

    public String getCcbUrl() {
        return ccbUrl;
    }

    public void setCcbUrl(String ccbUrl) {
        this.ccbUrl = ccbUrl;
    }

    public String getCcbDireccion() {
        return ccbDireccion;
    }

    public void setCcbDireccion(String ccbDireccion) {
        this.ccbDireccion = ccbDireccion;
    }

    public String getCcbTelefono() {
        return ccbTelefono;
    }

    public void setCcbTelefono(String ccbTelefono) {
        this.ccbTelefono = ccbTelefono;
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

    public String getCcbIdAmbito() {
        return ccbIdAmbito;
    }

    public void setCcbIdAmbito(String ccbIdAmbito) {
        this.ccbIdAmbito = ccbIdAmbito;
    }

    public String getCcbIdNacPatent() {
        return ccbIdNacPatent;
    }

    public void setCcbIdNacPatent(String ccbIdNacPatent) {
        this.ccbIdNacPatent = ccbIdNacPatent;
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
        hash += (m4ccbCvEmpBtecPK != null ? m4ccbCvEmpBtecPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvEmpBtec)) {
            return false;
        }
        M4ccbCvEmpBtec other = (M4ccbCvEmpBtec) object;
        if ((this.m4ccbCvEmpBtecPK == null && other.m4ccbCvEmpBtecPK != null) || (this.m4ccbCvEmpBtecPK != null && !this.m4ccbCvEmpBtecPK.equals(other.m4ccbCvEmpBtecPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvEmpBtec[ m4ccbCvEmpBtecPK=" + m4ccbCvEmpBtecPK + " ]";
    }
    
}
