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
@Table(name = "tipo_clientes")
@NamedQueries({
    @NamedQuery(name = "TipoClientes.findAll", query = "SELECT t FROM TipoClientes t"),
    @NamedQuery(name = "TipoClientes.findByIdTipCli", query = "SELECT t FROM TipoClientes t WHERE t.idTipCli = :idTipCli"),
    @NamedQuery(name = "TipoClientes.findByTipCli", query = "SELECT t FROM TipoClientes t WHERE t.tipCli = :tipCli")})
public class TipoClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tip_cli")
    private Integer idTipCli;
    @Basic(optional = false)
    @Column(name = "tip_cli")
    private String tipCli;

    public TipoClientes() {
    }

    public TipoClientes(Integer idTipCli) {
        this.idTipCli = idTipCli;
    }

    public TipoClientes(Integer idTipCli, String tipCli) {
        this.idTipCli = idTipCli;
        this.tipCli = tipCli;
    }

    public Integer getIdTipCli() {
        return idTipCli;
    }

    public void setIdTipCli(Integer idTipCli) {
        this.idTipCli = idTipCli;
    }

    public String getTipCli() {
        return tipCli;
    }

    public void setTipCli(String tipCli) {
        this.tipCli = tipCli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipCli != null ? idTipCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoClientes)) {
            return false;
        }
        TipoClientes other = (TipoClientes) object;
        if ((this.idTipCli == null && other.idTipCli != null) || (this.idTipCli != null && !this.idTipCli.equals(other.idTipCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoClientes[ idTipCli=" + idTipCli + " ]";
    }
    
}
