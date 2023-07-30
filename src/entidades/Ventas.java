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
@Table(name = "ventas")
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByCodVen", query = "SELECT v FROM Ventas v WHERE v.codVen = :codVen"),
    @NamedQuery(name = "Ventas.findByFecVen", query = "SELECT v FROM Ventas v WHERE v.fecVen = :fecVen"),
    @NamedQuery(name = "Ventas.findByProVen", query = "SELECT v FROM Ventas v WHERE v.proVen = :proVen"),
    @NamedQuery(name = "Ventas.findByCanVen", query = "SELECT v FROM Ventas v WHERE v.canVen = :canVen"),
    @NamedQuery(name = "Ventas.findByPreUniVen", query = "SELECT v FROM Ventas v WHERE v.preUniVen = :preUniVen"),
    @NamedQuery(name = "Ventas.findByIvaVen", query = "SELECT v FROM Ventas v WHERE v.ivaVen = :ivaVen"),
    @NamedQuery(name = "Ventas.findBySubVen", query = "SELECT v FROM Ventas v WHERE v.subVen = :subVen"),
    @NamedQuery(name = "Ventas.findByTotVen", query = "SELECT v FROM Ventas v WHERE v.totVen = :totVen")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_ven")
    private Integer codVen;
    @Basic(optional = false)
    @Column(name = "fec_ven")
    private String fecVen;
    @Basic(optional = false)
    @Column(name = "pro_ven")
    private String proVen;
    @Basic(optional = false)
    @Column(name = "can_ven")
    private int canVen;
    @Basic(optional = false)
    @Column(name = "pre_uni_ven")
    private double preUniVen;
    @Basic(optional = false)
    @Column(name = "iva_ven")
    private int ivaVen;
    @Basic(optional = false)
    @Column(name = "sub_ven")
    private double subVen;
    @Basic(optional = false)
    @Column(name = "tot_ven")
    private double totVen;

    public Ventas() {
    }

    public Ventas(Integer codVen) {
        this.codVen = codVen;
    }

    public Ventas(Integer codVen, String fecVen, String proVen, int canVen, double preUniVen, int ivaVen, double subVen, double totVen) {
        this.codVen = codVen;
        this.fecVen = fecVen;
        this.proVen = proVen;
        this.canVen = canVen;
        this.preUniVen = preUniVen;
        this.ivaVen = ivaVen;
        this.subVen = subVen;
        this.totVen = totVen;
    }

    public Integer getCodVen() {
        return codVen;
    }

    public void setCodVen(Integer codVen) {
        this.codVen = codVen;
    }

    public String getFecVen() {
        return fecVen;
    }

    public void setFecVen(String fecVen) {
        this.fecVen = fecVen;
    }

    public String getProVen() {
        return proVen;
    }

    public void setProVen(String proVen) {
        this.proVen = proVen;
    }

    public int getCanVen() {
        return canVen;
    }

    public void setCanVen(int canVen) {
        this.canVen = canVen;
    }

    public double getPreUniVen() {
        return preUniVen;
    }

    public void setPreUniVen(double preUniVen) {
        this.preUniVen = preUniVen;
    }

    public int getIvaVen() {
        return ivaVen;
    }

    public void setIvaVen(int ivaVen) {
        this.ivaVen = ivaVen;
    }

    public double getSubVen() {
        return subVen;
    }

    public void setSubVen(double subVen) {
        this.subVen = subVen;
    }

    public double getTotVen() {
        return totVen;
    }

    public void setTotVen(double totVen) {
        this.totVen = totVen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVen != null ? codVen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.codVen == null && other.codVen != null) || (this.codVen != null && !this.codVen.equals(other.codVen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ventas[ codVen=" + codVen + " ]";
    }
    
}
