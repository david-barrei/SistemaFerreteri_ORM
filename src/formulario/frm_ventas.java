/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davba
 */
public class frm_ventas extends javax.swing.JInternalFrame {

  
    DefaultTableModel m;
    public frm_ventas() {
        initComponents();
        PrepararTabla();
        
        
        
        clases.cls_cabecera_factura obj = new clases.cls_cabecera_factura();
        obj.CargarTabla(tabla_registro);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setSelectedIndex(0);
    }

    private void PrepararTabla() {
        String titulos[] = {"ID", "PRODUCTO", "PVP", "CANTIDAD", "TOTAL"};
        m = new DefaultTableModel(null, titulos);
        tabla_compras.setModel(m);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_registro = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_numfac = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        txt_nombre = new javax.swing.JTextField();
        txt_buscar_Kclientes = new javax.swing.JButton();
        txt_agregar_Kcompras = new javax.swing.JButton();
        txt_quitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_compras = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_descuento = new javax.swing.JComboBox<>();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tabla_registro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabla_registro);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new_file256_25213.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btn_nuevo)
                        .addGap(58, 58, 58)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Numero Factura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, 100, 25));

        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 48, 80, 25));

        jLabel3.setText("Cedula");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 85, 80, 25));

        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 122, 80, 25));
        jPanel1.add(txt_numfac, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, -1));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 120, -1));
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 120, -1));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 120, -1));

        txt_buscar_Kclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/preview_search_find_locate_1551.png"))); // NOI18N
        txt_buscar_Kclientes.setText("Buscar");
        txt_buscar_Kclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscar_KclientesActionPerformed(evt);
            }
        });
        jPanel1.add(txt_buscar_Kclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        txt_agregar_Kcompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/addfileinterfacesymbolofpapersheetwithtextlinesandplussign_79821.png"))); // NOI18N
        txt_agregar_Kcompras.setText("Agregar");
        txt_agregar_Kcompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_agregar_KcomprasActionPerformed(evt);
            }
        });
        jPanel1.add(txt_agregar_Kcompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        txt_quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trash-can_115312.png"))); // NOI18N
        txt_quitar.setText("Quitar");
        txt_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quitarActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        tabla_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_compras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 880, 290));

        jLabel6.setText("SubTotal");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 70, 20));

        jLabel7.setText("Descuento");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 60, 20));
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 90, -1));

        jLabel8.setText("IVA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 590, 60, 20));

        jLabel9.setText("Total");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 60, 20));

        cb_descuento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cb_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_descuentoActionPerformed(evt);
            }
        });
        jPanel1.add(cb_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 60, -1));
        jPanel1.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, 90, -1));
        jPanel1.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 590, 90, -1));
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 620, 90, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/diskette_save_saveas_1514.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, -1, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/receipt_cancel_icon_177356.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, -1, -1));

        jTabbedPane1.addTab("Ventas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscar_KclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscar_KclientesActionPerformed
       formulario.kardex_clientes kardex = new formulario.kardex_clientes(new javax.swing.JFrame(), true);
        
        kardex.setVisible(true);
        txt_cedula.setText(kardex.getCed_cli());
        txt_nombre.setText(kardex.getNom_cli());
        
        
    }//GEN-LAST:event_txt_buscar_KclientesActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
       
        
         try {
            Limpiar();

            clases.cls_conexion obj = new clases.cls_conexion();
            ResultSet rs = obj.Consulta("Select max(num_fac)+1 AS Codigo FROM cabecera_factura");

            while (rs.next()) {
                try {
                    if (rs.getObject("Codigo") == null) {
                        txt_numfac.setText("1");
                    } else {
                        txt_numfac.setText(rs.getObject("Codigo").toString());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frm_ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            txt_numfac.enable(false);
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(frm_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
      
        
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quitarActionPerformed
        try {
            if (tabla_compras.getSelectedRow() >= 0) {
                m = (DefaultTableModel) tabla_compras.getModel();
                m.removeRow(tabla_compras.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un registro");
            }
        } catch (Exception er) {
            javax.swing.JOptionPane.showMessageDialog(null, er.getMessage());
        }
    }//GEN-LAST:event_txt_quitarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        try {
            String error;
            // int num_fac, String fec_fac, String ced_cli, double sub_fac, double des_fac, double iva_fac, double tot_fac
            clases.cls_cabecera_factura obj = new clases.cls_cabecera_factura(Integer.parseInt(txt_numfac.getText()), fecha.getDate().toLocaleString(), txt_cedula.getText(), Double.parseDouble(txt_subtotal.getText()), Double.parseDouble(txt_descuento.getText()), Double.parseDouble(txt_iva.getText()), Double.parseDouble(txt_total.getText()));
            error = obj.guardar();
            if (!"".equals(error)) {
                JOptionPane.showMessageDialog(null, error, "Sistema Inventario", JOptionPane.ERROR_MESSAGE);
            }
            for (int i = 0; i < tabla_compras.getRowCount(); i++) {
                clases.cls_detalle_factura obj_det = new clases.cls_detalle_factura(Integer.parseInt(txt_numfac.getText()), Integer.parseInt(tabla_compras.getValueAt(i, 0).toString()), Integer.parseInt(tabla_compras.getValueAt(i, 3).toString()), Double.parseDouble(tabla_compras.getValueAt(i, 4).toString()));
                error = obj_det.guardar();
                if (!"".equals(error)) {
                    JOptionPane.showMessageDialog(null, error, "Sistema Inventario", JOptionPane.ERROR_MESSAGE);
                }
            }
            obj.CargarTabla(tabla_registro);
        } catch (Exception er) {
            javax.swing.JOptionPane.showMessageDialog(null, er.getMessage());
        }
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setSelectedIndex(0);      
      
      
        
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_agregar_KcomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_agregar_KcomprasActionPerformed
       
        
        formulario.kardex_compras kardex = new formulario.kardex_compras(new javax.swing.JFrame(), true);
        kardex.setVisible(true);

        m = (DefaultTableModel) tabla_compras.getModel();
        // {"ID", "Producto", "PVP", "Cantidad", "Total Línea"
        String fila[] = {String.valueOf(kardex.getId_pro()), kardex.getNom_pro(), String.valueOf(kardex.getPvp_pr()), String.valueOf(kardex.getCant_pro()), String.valueOf(kardex.getPvp_pr() * kardex.getCant_pro())};
        m.addRow(fila);

        mtd_calculos();
        
        
        
    }//GEN-LAST:event_txt_agregar_KcomprasActionPerformed

    private void cb_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_descuentoActionPerformed
        mtd_calculos();
    }//GEN-LAST:event_cb_descuentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         
        clases.cls_reportes reporte = new clases.cls_reportes();
        reporte.ReporteFactura();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

      private void mtd_calculos() {
        double subtotal = 0;
        double descuento = 0;
        double iva;
        double total;

        for (int i = 0; i < tabla_compras.getRowCount(); i++) {
            subtotal = subtotal + Double.parseDouble(tabla_compras.getValueAt(i, 4).toString());
        }
        txt_subtotal.setText(String.valueOf(subtotal));

        descuento = (Double.parseDouble(cb_descuento.getSelectedItem().toString()) * subtotal) / 100;
        txt_descuento.setText(String.valueOf(descuento));

        iva = ((subtotal - descuento) * 14) / 100;
        txt_iva.setText(String.valueOf(Math.round(iva)));

         total = (subtotal - descuento) + iva;
        
        txt_total.setText(String.valueOf(Math.round(total)));
        
        
    }
      double tot;
      
      
      

    public void Limpiar() {
        txt_numfac.setText("");
        txt_cedula.setText("");
        txt_nombre.setText("");
        txt_subtotal.setText("");
        txt_descuento.setText("");
        txt_iva.setText("");
        txt_total.setText("");
        cb_descuento.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cb_descuento;
    private org.jdesktop.swingx.JXDatePicker fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla_compras;
    private javax.swing.JTable tabla_registro;
    private javax.swing.JButton txt_agregar_Kcompras;
    private javax.swing.JButton txt_buscar_Kclientes;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numfac;
    private javax.swing.JButton txt_quitar;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
