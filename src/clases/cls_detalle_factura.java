
package clases;


public class cls_detalle_factura {
 
    private int num_fac;
    private int is_pro;
    private int can_pro;
    private double tot_linea;
    
    
    public cls_detalle_factura(){
        
        
    }

    public cls_detalle_factura(int num_fac, int is_pro, int can_pro, double tot_linea) {
        this.num_fac = num_fac;
        this.is_pro = is_pro;
        this.can_pro = can_pro;
        this.tot_linea = tot_linea;
    }

    public int getNum_fac() {
        return num_fac;
    }

    public void setNum_fac(int num_fac) {
        this.num_fac = num_fac;
    }

    public int getIs_pro() {
        return is_pro;
    }

    public void setIs_pro(int is_pro) {
        this.is_pro = is_pro;
    }

    public int getCan_pro() {
        return can_pro;
    }

    public void setCan_pro(int can_pro) {
        this.can_pro = can_pro;
    }

    public double getTot_linea() {
        return tot_linea;
    }

    public void setTot_linea(double tot_linea) {
        this.tot_linea = tot_linea;
    }
    
    
     cls_conexion obj_conx = new cls_conexion();
    public String guardar(){   //int num_fac, int id_pro, int can_pro, double tot_linea
         return obj_conx.ejecutar("INSERT INTO detalle_factura (num_fac, id_pro ,can_pro, tot_linea) VALUES ("+getNum_fac()+",'"+getIs_pro()+"','"+getCan_pro()+"',"+getTot_linea()+")");
       
    
}
}
