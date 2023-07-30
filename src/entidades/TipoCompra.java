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
@Table(name = "tipo_compra")
@NamedQueries({
    @NamedQuery(name = "TipoCompra.findAll", query = "SELECT t FROM TipoCompra t"),
    @NamedQuery(name = "TipoCompra.findByIdPro", query = "SELECT t FROM TipoCompra t WHERE t.idPro = :idPro"),
    @NamedQuery(name = "TipoCompra.findByNomPro", query = "SELECT t FROM TipoCompra t WHERE t.nomPro = :nomPro")})
public class TipoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pro")
    private Integer idPro;
    @Basic(optional = false)
    @Column(name = "nom_pro")
    private String nomPro;

    public TipoCompra() {
    }

    public TipoCompra(Integer idPro) {
        this.idPro = idPro;
    }

    public TipoCompra(Integer idPro, String nomPro) {
        this.idPro = idPro;
        this.nomPro = nomPro;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPro != null ? idPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCompra)) {
            return false;
        }
        TipoCompra other = (TipoCompra) object;
        if ((this.idPro == null && other.idPro != null) || (this.idPro != null && !this.idPro.equals(other.idPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoCompra[ idPro=" + idPro + " ]";
    }
    
}
