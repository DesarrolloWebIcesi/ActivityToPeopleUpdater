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
@Table(name = "M4CCB_CV_CONS_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "M4ccbCvConsDet.findAll", query = "SELECT m FROM M4ccbCvConsDet m"),
    @NamedQuery(name = "M4ccbCvConsDet.findByIdOrganization", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.m4ccbCvConsDetPK.idOrganization = :idOrganization"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbOrDetCons", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.m4ccbCvConsDetPK.ccbOrDetCons = :ccbOrDetCons"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbProduct", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.ccbProduct = :ccbProduct"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbFechaEntr", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.ccbFechaEntr = :ccbFechaEntr"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbFechaPago", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.ccbFechaPago = :ccbFechaPago"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbValorPagar", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.ccbValorPagar = :ccbValorPagar"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbObservacion", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.ccbObservacion = :ccbObservacion"),
    @NamedQuery(name = "M4ccbCvConsDet.findByCcbOrConsult", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.m4ccbCvConsDetPK.ccbOrConsult = :ccbOrConsult"),
    @NamedQuery(name = "M4ccbCvConsDet.findByStdIdHr", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.m4ccbCvConsDetPK.stdIdHr = :stdIdHr"),
    @NamedQuery(name = "M4ccbCvConsDet.findByIdApprole", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.idApprole = :idApprole"),
    @NamedQuery(name = "M4ccbCvConsDet.findByIdSecuser", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.idSecuser = :idSecuser"),
    @NamedQuery(name = "M4ccbCvConsDet.findByDtLastUpdate", query = "SELECT m FROM M4ccbCvConsDet m WHERE m.dtLastUpdate = :dtLastUpdate")})
public class M4ccbCvConsDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M4ccbCvConsDetPK m4ccbCvConsDetPK;
    @Column(name = "CCB_PRODUCT")
    private String ccbProduct;
    @Column(name = "CCB_FECHA_ENTR")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaEntr;
    @Column(name = "CCB_FECHA_PAGO")
    @Temporal(TemporalType.DATE)
    private Date ccbFechaPago;
    @Column(name = "CCB_VALOR_PAGAR")
    private Long ccbValorPagar;
    @Column(name = "CCB_OBSERVACION")
    private String ccbObservacion;
    @Column(name = "ID_APPROLE")
    private String idApprole;
    @Column(name = "ID_SECUSER")
    private String idSecuser;
    @Column(name = "DT_LAST_UPDATE")
    @Temporal(TemporalType.DATE)
    private Date dtLastUpdate;

    public M4ccbCvConsDet() {
    }

    public M4ccbCvConsDet(M4ccbCvConsDetPK m4ccbCvConsDetPK) {
        this.m4ccbCvConsDetPK = m4ccbCvConsDetPK;
    }

    public M4ccbCvConsDet(String idOrganization, short ccbOrDetCons, short ccbOrConsult, String stdIdHr) {
        this.m4ccbCvConsDetPK = new M4ccbCvConsDetPK(idOrganization, ccbOrDetCons, ccbOrConsult, stdIdHr);
    }

    public M4ccbCvConsDetPK getM4ccbCvConsDetPK() {
        return m4ccbCvConsDetPK;
    }

    public void setM4ccbCvConsDetPK(M4ccbCvConsDetPK m4ccbCvConsDetPK) {
        this.m4ccbCvConsDetPK = m4ccbCvConsDetPK;
    }

    public String getCcbProduct() {
        return ccbProduct;
    }

    public void setCcbProduct(String ccbProduct) {
        this.ccbProduct = ccbProduct;
    }

    public Date getCcbFechaEntr() {
        return ccbFechaEntr;
    }

    public void setCcbFechaEntr(Date ccbFechaEntr) {
        this.ccbFechaEntr = ccbFechaEntr;
    }

    public Date getCcbFechaPago() {
        return ccbFechaPago;
    }

    public void setCcbFechaPago(Date ccbFechaPago) {
        this.ccbFechaPago = ccbFechaPago;
    }

    public Long getCcbValorPagar() {
        return ccbValorPagar;
    }

    public void setCcbValorPagar(Long ccbValorPagar) {
        this.ccbValorPagar = ccbValorPagar;
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
        hash += (m4ccbCvConsDetPK != null ? m4ccbCvConsDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M4ccbCvConsDet)) {
            return false;
        }
        M4ccbCvConsDet other = (M4ccbCvConsDet) object;
        if ((this.m4ccbCvConsDetPK == null && other.m4ccbCvConsDetPK != null) || (this.m4ccbCvConsDetPK != null && !this.m4ccbCvConsDetPK.equals(other.m4ccbCvConsDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.icesi.activitytopeopleupdater.peoplenet.model.M4ccbCvConsDet[ m4ccbCvConsDetPK=" + m4ccbCvConsDetPK + " ]";
    }
    
}
