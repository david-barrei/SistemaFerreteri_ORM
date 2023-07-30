/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JTable;

/**
 *
 * @author davba
 */
public class cls_cabecera_factura {
    
    private int num_fac;
    private String fec_fac;
    private String ced_cli;
    private double sub_fac;
    private double des_fac;
    private double iva_fac;
    private double tot_fac;
    
    
    public cls_cabecera_factura(){
        
        
    }

    public cls_cabecera_factura(int num_fac, String fec_fac, String ced_cli, double sub_fac, double des_fac, double iva_fac, double tot_fac) {
        this.num_fac = num_fac;
        this.fec_fac = fec_fac;
        this.ced_cli = ced_cli;
        this.sub_fac = sub_fac;
        this.des_fac = des_fac;
        this.iva_fac = iva_fac;
        this.tot_fac = tot_fac;
    }

    public int getNum_fac() {
        return num_fac;
    }

    public void setNum_fac(int num_fac) {
        this.num_fac = num_fac;
    }

    public String getFec_fac() {
        return fec_fac;
    }

    public void setFec_fac(String fec_fac) {
        this.fec_fac = fec_fac;
    }

    public String getCed_cli() {
        return ced_cli;
    }

    public void setCed_cli(String ced_cli) {
        this.ced_cli = ced_cli;
    }

    public double getSub_fac() {
        return sub_fac;
    }

    public void setSub_fac(double sub_fac) {
        this.sub_fac = sub_fac;
    }

    public double getDes_fac() {
        return des_fac;
    }

    public void setDes_fac(double des_fac) {
        this.des_fac = des_fac;
    }

    public double getIva_fac() {
        return iva_fac;
    }

    public void setIva_fac(double iva_fac) {
        this.iva_fac = iva_fac;
    }

    public double getTot_fac() {
        return tot_fac;
    }

    public void setTot_fac(double tot_fac) {
        this.tot_fac = tot_fac;
    }
    
    
    cls_conexion obj_conx = new cls_conexion();
    public String guardar(){    //int num_fac, String fec_fac, String ced_cli, double sub_fac, double des_fac, double iva_fac, double tot_fac)
         return obj_conx.ejecutar("INSERT INTO cabecera_factura (num_fac, fec_fac,ced_cli, sub_fac, des_fac, iva_fac,tot_fac) VALUES ("+getNum_fac()+",'"+getFec_fac()+"','"+getCed_cli()+"',"+getSub_fac()+","+getDes_fac()+","+getIva_fac()+","+getTot_fac()+")");
      
        
    }
    
     public void CargarTabla (JTable NombreTabla){
        obj_conx.CargarTabla("Select num_fac as '# Factura', fec_fac as Fecha_Factura, ced_cli as Cedula_Cliente, sub_fac as Subtotal,des_fac as Descuento, iva_fac as IVA, tot_fac as Total From cabecera_factura", NombreTabla);
    }
    
}
