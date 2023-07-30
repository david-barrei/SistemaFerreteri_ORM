/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author davba
 */
@Entity
@Table(name = "detalle_factura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByNumFac", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.numFac = :numFac"),
    @NamedQuery(name = "DetalleFactura.findByIdPro", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.idPro = :idPro"),
    @NamedQuery(name = "DetalleFactura.findByCanPro", query = "SELECT d FROM DetalleFactura d WHERE d.canPro = :canPro"),
    @NamedQuery(name = "DetalleFactura.findByTotLinea", query = "SELECT d FROM DetalleFactura d WHERE d.totLinea = :totLinea")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
    @Basic(optional = false)
    @Column(name = "can_pro")
    private int canPro;
    @Basic(optional = false)
    @Column(name = "tot_linea")
    private double totLinea;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK, int canPro, double totLinea) {
        this.detalleFacturaPK = detalleFacturaPK;
        this.canPro = canPro;
        this.totLinea = totLinea;
    }

    public DetalleFactura(int numFac, int idPro) {
        this.detalleFacturaPK = new DetalleFacturaPK(numFac, idPro);
    }

    public DetalleFacturaPK getDetalleFacturaPK() {
        return detalleFacturaPK;
    }

    public void setDetalleFacturaPK(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public int getCanPro() {
        return canPro;
    }

    public void setCanPro(int canPro) {
        this.canPro = canPro;
    }

    public double getTotLinea() {
        return totLinea;
    }

    public void setTotLinea(double totLinea) {
        this.totLinea = totLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaPK != null ? detalleFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.detalleFacturaPK == null && other.detalleFacturaPK != null) || (this.detalleFacturaPK != null && !this.detalleFacturaPK.equals(other.detalleFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleFactura[ detalleFacturaPK=" + detalleFacturaPK + " ]";
    }
    
}
