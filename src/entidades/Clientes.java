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
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCodCli", query = "SELECT c FROM Clientes c WHERE c.codCli = :codCli"),
    @NamedQuery(name = "Clientes.findByRucCli", query = "SELECT c FROM Clientes c WHERE c.rucCli = :rucCli"),
    @NamedQuery(name = "Clientes.findByNomCli", query = "SELECT c FROM Clientes c WHERE c.nomCli = :nomCli"),
    @NamedQuery(name = "Clientes.findByCorCli", query = "SELECT c FROM Clientes c WHERE c.corCli = :corCli"),
    @NamedQuery(name = "Clientes.findByTelCli", query = "SELECT c FROM Clientes c WHERE c.telCli = :telCli"),
    @NamedQuery(name = "Clientes.findByIdTipCli", query = "SELECT c FROM Clientes c WHERE c.idTipCli = :idTipCli")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_cli")
    private Integer codCli;
    @Basic(optional = false)
    @Column(name = "ruc_cli")
    private int rucCli;
    @Basic(optional = false)
    @Column(name = "nom_cli")
    private String nomCli;
    @Basic(optional = false)
    @Column(name = "cor_cli")
    private String corCli;
    @Basic(optional = false)
    @Column(name = "tel_cli")
    private int telCli;
    @Basic(optional = false)
    @Column(name = "id_tip_cli")
    private int idTipCli;

    public Clientes() {
    }

    public Clientes(Integer codCli) {
        this.codCli = codCli;
    }

    public Clientes(Integer codCli, int rucCli, String nomCli, String corCli, int telCli, int idTipCli) {
        this.codCli = codCli;
        this.rucCli = rucCli;
        this.nomCli = nomCli;
        this.corCli = corCli;
        this.telCli = telCli;
        this.idTipCli = idTipCli;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        this.codCli = codCli;
    }

    public int getRucCli() {
        return rucCli;
    }

    public void setRucCli(int rucCli) {
        this.rucCli = rucCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getCorCli() {
        return corCli;
    }

    public void setCorCli(String corCli) {
        this.corCli = corCli;
    }

    public int getTelCli() {
        return telCli;
    }

    public void setTelCli(int telCli) {
        this.telCli = telCli;
    }

    public int getIdTipCli() {
        return idTipCli;
    }

    public void setIdTipCli(int idTipCli) {
        this.idTipCli = idTipCli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCli != null ? codCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codCli == null && other.codCli != null) || (this.codCli != null && !this.codCli.equals(other.codCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Clientes[ codCli=" + codCli + " ]";
    }
    
}
