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
@Table(name = "compras")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByCodCom", query = "SELECT c FROM Compras c WHERE c.codCom = :codCom"),
    @NamedQuery(name = "Compras.findByFecCom", query = "SELECT c FROM Compras c WHERE c.fecCom = :fecCom"),
    @NamedQuery(name = "Compras.findByProCom", query = "SELECT c FROM Compras c WHERE c.proCom = :proCom"),
    @NamedQuery(name = "Compras.findByCanCom", query = "SELECT c FROM Compras c WHERE c.canCom = :canCom"),
    @NamedQuery(name = "Compras.findByPreCom", query = "SELECT c FROM Compras c WHERE c.preCom = :preCom"),
    @NamedQuery(name = "Compras.findByPreVenCom", query = "SELECT c FROM Compras c WHERE c.preVenCom = :preVenCom"),
    @NamedQuery(name = "Compras.findByIdProveedores", query = "SELECT c FROM Compras c WHERE c.idProveedores = :idProveedores")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_com")
    private Integer codCom;
    @Basic(optional = false)
    @Column(name = "fec_com")
    private String fecCom;
    @Basic(optional = false)
    @Column(name = "pro_com")
    private String proCom;
    @Basic(optional = false)
    @Column(name = "can_com")
    private int canCom;
    @Basic(optional = false)
    @Column(name = "pre_com")
    private double preCom;
    @Basic(optional = false)
    @Column(name = "pre_ven_com")
    private double preVenCom;
    @Basic(optional = false)
    @Column(name = "id_proveedores")
    private int idProveedores;

    public Compras() {
    }

    public Compras(Integer codCom) {
        this.codCom = codCom;
    }

    public Compras(Integer codCom, String fecCom, String proCom, int canCom, double preCom, double preVenCom, int idProveedores) {
        this.codCom = codCom;
        this.fecCom = fecCom;
        this.proCom = proCom;
        this.canCom = canCom;
        this.preCom = preCom;
        this.preVenCom = preVenCom;
        this.idProveedores = idProveedores;
    }

    public Integer getCodCom() {
        return codCom;
    }

    public void setCodCom(Integer codCom) {
        this.codCom = codCom;
    }

    public String getFecCom() {
        return fecCom;
    }

    public void setFecCom(String fecCom) {
        this.fecCom = fecCom;
    }

    public String getProCom() {
        return proCom;
    }

    public void setProCom(String proCom) {
        this.proCom = proCom;
    }

    public int getCanCom() {
        return canCom;
    }

    public void setCanCom(int canCom) {
        this.canCom = canCom;
    }

    public double getPreCom() {
        return preCom;
    }

    public void setPreCom(double preCom) {
        this.preCom = preCom;
    }

    public double getPreVenCom() {
        return preVenCom;
    }

    public void setPreVenCom(double preVenCom) {
        this.preVenCom = preVenCom;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCom != null ? codCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.codCom == null && other.codCom != null) || (this.codCom != null && !this.codCom.equals(other.codCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Compras[ codCom=" + codCom + " ]";
    }
    
}
