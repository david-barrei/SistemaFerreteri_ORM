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
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpleado", query = "SELECT e FROM Empleados e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleados.findByNomEmp", query = "SELECT e FROM Empleados e WHERE e.nomEmp = :nomEmp"),
    @NamedQuery(name = "Empleados.findByApeEmp", query = "SELECT e FROM Empleados e WHERE e.apeEmp = :apeEmp"),
    @NamedQuery(name = "Empleados.findByCarEmp", query = "SELECT e FROM Empleados e WHERE e.carEmp = :carEmp"),
    @NamedQuery(name = "Empleados.findByCivEmp", query = "SELECT e FROM Empleados e WHERE e.civEmp = :civEmp"),
    @NamedQuery(name = "Empleados.findByGenEmp", query = "SELECT e FROM Empleados e WHERE e.genEmp = :genEmp"),
    @NamedQuery(name = "Empleados.findByTelEmp", query = "SELECT e FROM Empleados e WHERE e.telEmp = :telEmp"),
    @NamedQuery(name = "Empleados.findByFecEmp", query = "SELECT e FROM Empleados e WHERE e.fecEmp = :fecEmp")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @Column(name = "nom_emp")
    private String nomEmp;
    @Basic(optional = false)
    @Column(name = "ape_emp")
    private String apeEmp;
    @Basic(optional = false)
    @Column(name = "car_emp")
    private String carEmp;
    @Basic(optional = false)
    @Column(name = "civ_emp")
    private String civEmp;
    @Basic(optional = false)
    @Column(name = "gen_emp")
    private String genEmp;
    @Basic(optional = false)
    @Column(name = "tel_emp")
    private int telEmp;
    @Basic(optional = false)
    @Column(name = "fec_emp")
    private String fecEmp;

    public Empleados() {
    }

    public Empleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(Integer idEmpleado, String nomEmp, String apeEmp, String carEmp, String civEmp, String genEmp, int telEmp, String fecEmp) {
        this.idEmpleado = idEmpleado;
        this.nomEmp = nomEmp;
        this.apeEmp = apeEmp;
        this.carEmp = carEmp;
        this.civEmp = civEmp;
        this.genEmp = genEmp;
        this.telEmp = telEmp;
        this.fecEmp = fecEmp;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getApeEmp() {
        return apeEmp;
    }

    public void setApeEmp(String apeEmp) {
        this.apeEmp = apeEmp;
    }

    public String getCarEmp() {
        return carEmp;
    }

    public void setCarEmp(String carEmp) {
        this.carEmp = carEmp;
    }

    public String getCivEmp() {
        return civEmp;
    }

    public void setCivEmp(String civEmp) {
        this.civEmp = civEmp;
    }

    public String getGenEmp() {
        return genEmp;
    }

    public void setGenEmp(String genEmp) {
        this.genEmp = genEmp;
    }

    public int getTelEmp() {
        return telEmp;
    }

    public void setTelEmp(int telEmp) {
        this.telEmp = telEmp;
    }

    public String getFecEmp() {
        return fecEmp;
    }

    public void setFecEmp(String fecEmp) {
        this.fecEmp = fecEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
