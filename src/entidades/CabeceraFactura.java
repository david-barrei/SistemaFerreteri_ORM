/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author davba
 */
@Entity
@Table(name = "cabecera_factura")
@NamedQueries({
    @NamedQuery(name = "CabeceraFactura.findAll", query = "SELECT c FROM CabeceraFactura c"),
    @NamedQuery(name = "CabeceraFactura.findByNumFac", query = "SELECT c FROM CabeceraFactura c WHERE c.numFac = :numFac"),
    @NamedQuery(name = "CabeceraFactura.findByFecFac", query = "SELECT c FROM CabeceraFactura c WHERE c.fecFac = :fecFac"),
    @NamedQuery(name = "CabeceraFactura.findByCedCli", query = "SELECT c FROM CabeceraFactura c WHERE c.cedCli = :cedCli"),
    @NamedQuery(name = "CabeceraFactura.findBySubFac", query = "SELECT c FROM CabeceraFactura c WHERE c.subFac = :subFac"),
    @NamedQuery(name = "CabeceraFactura.findByDesFac", query = "SELECT c FROM CabeceraFactura c WHERE c.desFac = :desFac"),
    @NamedQuery(name = "CabeceraFactura.findByIvaFac", query = "SELECT c FROM CabeceraFactura c WHERE c.ivaFac = :ivaFac"),
    @NamedQuery(name = "CabeceraFactura.findByTotFac", query = "SELECT c FROM CabeceraFactura c WHERE c.totFac = :totFac")})
public class CabeceraFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "num_fac")
    private Integer numFac;
    @Basic(optional = false)
    @Column(name = "fec_fac")
    private String fecFac;
    @Basic(optional = false)
    @Column(name = "ced_cli")
    private String cedCli;
    @Basic(optional = false)
    @Column(name = "sub_fac")
    private double subFac;
    @Basic(optional = false)
    @Column(name = "des_fac")
    private double desFac;
    @Basic(optional = false)
    @Column(name = "iva_fac")
    private double ivaFac;
    @Basic(optional = false)
    @Column(name = "tot_fac")
    private double totFac;

    public CabeceraFactura() {
    }

    public CabeceraFactura(Integer numFac) {
        this.numFac = numFac;
    }

    public CabeceraFactura(Integer numFac, String fecFac, String cedCli, double subFac, double desFac, double ivaFac, double totFac) {
        this.numFac = numFac;
        this.fecFac = fecFac;
        this.cedCli = cedCli;
        this.subFac = subFac;
        this.desFac = desFac;
        this.ivaFac = ivaFac;
        this.totFac = totFac;
    }

    public Integer getNumFac() {
        return numFac;
    }

    public void setNumFac(Integer numFac) {
        this.numFac = numFac;
    }

    public String getFecFac() {
        return fecFac;
    }

    public void setFecFac(String fecFac) {
        this.fecFac = fecFac;
    }

    public String getCedCli() {
        return cedCli;
    }

    public void setCedCli(String cedCli) {
        this.cedCli = cedCli;
    }

    public double getSubFac() {
        return subFac;
    }

    public void setSubFac(double subFac) {
        this.subFac = subFac;
    }

    public double getDesFac() {
        return desFac;
    }

    public void setDesFac(double desFac) {
        this.desFac = desFac;
    }

    public double getIvaFac() {
        return ivaFac;
    }

    public void setIvaFac(double ivaFac) {
        this.ivaFac = ivaFac;
    }

    public double getTotFac() {
        return totFac;
    }

    public void setTotFac(double totFac) {
        this.totFac = totFac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numFac != null ? numFac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraFactura)) {
            return false;
        }
        CabeceraFactura other = (CabeceraFactura) object;
        if ((this.numFac == null && other.numFac != null) || (this.numFac != null && !this.numFac.equals(other.numFac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CabeceraFactura[ numFac=" + numFac + " ]";
    }
    
}
