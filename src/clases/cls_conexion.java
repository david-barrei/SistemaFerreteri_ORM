/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davba
 */
public class cls_conexion {

    Connection Conec;
    Statement St;


    /*Creando la instancia de conexión para que exista comunicación con la base de
datos*/
    public cls_conexion() {
        try {
// com.mysql.jdbc.Driver es el nombre del archivo Jark agregado.
            Class.forName("com.mysql.cj.jdbc.Driver");
//Sirve para que exista comunicación de la clase con la base de datos
// El nombre bdt_pruebas es el nombre indicado en la base de datos.
//La contraseña es la que se le coloca al momento de instalar MYSQL pide que
//ingrese su contraseña esta es la que se pone aquí.

            Conec = DriverManager.getConnection("jdbc:mysql://localhost:3310/ferreteria", "root", "");
            if (Conec != null) {
                System.out.println();
                System.out.println("Successfully connected");
                System.out.println();
                System.out.println("\nDriver Information");
            }
        } catch (SQLException excepcionSql) {
            JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),
                    "Error en base de datos", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException claseNoEncontrada) {
            JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),
                    "No se encontró el controlador", JOptionPane.ERROR_MESSAGE);

        }
    }

    //Metodo de ejecucion de insert,update,delete a la base de datos.
    public String ejecutar(String instruccionsql) {
        String error = "";
        try {
            St = Conec.createStatement();
            St.executeUpdate(instruccionsql);
        } catch (Exception ex) {
            error = ex.getMessage();
        }
        return (error);
    }

    public ResultSet Consulta(String sql) {
        ResultSet res = null;
        try {
            Statement s = Conec.createStatement();
            res = s.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "No se encontró los Datos", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }
//Este método sirve para visializar la tabla o los datos que se tiene en MYSQL.

    public void CargarTabla(String instruccionSQL, JTable NombreTabla) {
        try {
//Para establecer el modelo al JTable
            DefaultTableModel modelo = new DefaultTableModel();
            NombreTabla.setModel(modelo);
            ResultSet rs = Consulta(instruccionSQL);
//Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
//Establecer como cabezeras el nombre de las columnas
            for (int i = 1; i <= rsMd.getColumnCount(); i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
//Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[rsMd.getColumnCount()];
                for (int i = 0; i < rsMd.getColumnCount(); i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            rs.close();
        } catch (Exception ex) {

        }
    }

    public void cargarCombo(String instruccionSQL, JComboBox jComboBox1) {
        try {
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            ResultSet rs = Consulta(instruccionSQL);
            while (rs.next()) {
                modeloCombo.addElement(rs.getObject("Nombre"));
            }
            rs.close();
            jComboBox1.setModel(modeloCombo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
