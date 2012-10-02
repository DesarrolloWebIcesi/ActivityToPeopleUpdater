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
@Table(name = "M4CCB_CV_DISTINCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvDistinci.findAll", query = "SELECT m FROM M4ccbCvDistinci m"),
    @NamedQuery(name = "M4ccbCvDistinci.findByIdOrganization", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.m4ccbCvDistinciPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvDistinci.findByCcbIdDistincion", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.m4ccbCvDistinciPK.ccbIdDistincion = :ccbIdDistincion"),
    @NamedQuery(name = "M4ccbCvDistinci.findByCcbNomDistincion", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.ccbNomDistincion = :ccbNomDistincion"),
    @NamedQuery(name = "M4ccbCvDistinci.findByCcbNomActivDist", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.ccbNomActivDist = :ccbNomActivDist"),
    @NamedQuery(name = "M4ccbCvDistinci.findByCcbObservacion", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.ccbObservacion = :ccbObservacion"),
    @NamedQuery(name = "M4ccbCvDistinci.findByIdApprole", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvDistinci.findByIdSecuser", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvDistinci.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvDistinci m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvDistinci implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvDistinciPK m4ccbCvDistinciPK;
    @Column(name = "CCB_NOM_DISTINCION")
    private String ccbNomDistincion;
    @Column(name = "CCB_NOM_ACTIV_DIST")
    private String ccbNomActivDist;
    @Column(name = "CCB_OBSERVACION")
    private String ccbObservacion;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvDistinci() {
    }

    public M4ccbCvDistinci(M4ccbCvDistinciPK m4ccbCvDistinciPK) {
        this.m4ccbCvDistinciPK = m4ccbCvDistinciPK;
    }

    public M4ccbCvDistinci(String idOrganization, String ccbIdDistincion) {
        this.m4ccbCvDistinciPK = new M4ccbCvDistinciPK(idOrganization, ccbIdDistincion);
    }

    public M4ccbCvDistinciPK getM4ccbCvDistinciPK() {
        return m4ccbCvDistinciPK;
    }

    public void setM4ccbCvDistinciPK(M4ccbCvDistinciPK m4ccbCvDistinciPK) {
        this.m4ccbCvDistinciPK = m4ccbCvDistinciPK;
    }

    public String getCcbNomDistincion() {
        return ccbNomDistincion;
    }

    public void setCcbNomDistincion(String ccbNomDistincion) {
        this.ccbNomDistincion = ccbNomDistincion;
    }

    public String getCcbNomActivDist() {
        return ccbNomActivDist;
    }

    public void setCcbNomActivDist(String ccbNomActivDist) {
        this.ccbNomActivDist = ccbNomActivDist;
    }

    public String getCcbObservacion() {
        return ccbObservacion;
    }

    public void setCcbObservacion(String ccbObservacion) {
        this.ccbObservacion = ccbObservacion;
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
        hash += (m4ccbCvDistinciPK != null ? m4ccbCvDistinciPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvDistinci)) {
            return false;
        }
        M4ccbCvDistinci other = (M4ccbCvDistinci) object;
        if ((this.m4ccbCvDistinciPK == null && other.m4ccbCvDistinciPK != null) || (this.m4ccbCvDistinciPK != null && !this.m4ccbCvDistinciPK.equals(other.m4ccbCvDistinciPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvDistinci[ m4ccbCvDistinciPK=" + m4ccbCvDistinciPK + " ]";
    }
    
}
