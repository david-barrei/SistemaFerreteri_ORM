/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author davba
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "num_fac")
    private int numFac;
    @Basic(optional = false)
    @Column(name = "id_pro")
    private int idPro;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(int numFac, int idPro) {
        this.numFac = numFac;
        this.idPro = idPro;
    }

    public int getNumFac() {
        return numFac;
    }

    public void setNumFac(int numFac) {
        this.numFac = numFac;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numFac;
        hash += (int) idPro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.numFac != other.numFac) {
            return false;
        }
        if (this.idPro != other.idPro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleFacturaPK[ numFac=" + numFac + ", idPro=" + idPro + " ]";
    }
    
}
