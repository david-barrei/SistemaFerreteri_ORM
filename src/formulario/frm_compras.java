/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import clases.cls_conexion;
import controladores.exceptions.NonexistentEntityException;
import entidades.Clientes;
import entidades.Compras;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davba
 */
public class frm_compras extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    controladores.ComprasJpaController cclientes = new controladores.ComprasJpaController();

    public frm_compras() {

        initComponents();

        //txt_codigo.enable(false);
        clases.cls_conexion cnx = new clases.cls_conexion();
        cnx.cargarCombo("Select concat_WS('-', id_pro, nom_pro) AS Nombre from proveedor", cb_proveedor);

        createmodelo();
        cargar_informacion();

        tab_compras.setEnabledAt(0, true);
        tab_compras.setEnabledAt(1, false);
        tab_compras.setSelectedIndex(0);

    }

    private void createmodelo() {
        try {
            modelo = (new DefaultTableModel(null, new String[]{"Código", "Fecha", "Proveedor", "Producto", "Cantidad", "Precio Compra","Precio Venta"}) {
                Class[] types = new Class[]{
                    java.lang.Integer.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.Integer.class,
                    java.lang.Double.class,
                    java.lang.Double.class,
                    java.lang.Integer.class

                };
                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false,false};

                @Override
                public Class getColumnClass(int columnindex) {
                    return types[columnindex];
                }

                @Override
                public boolean isCellEditable(int rowindex, int colindex) {
                    return canEdit[colindex];
                }
            });
            tabla_compras.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "error");
        }
    }

    private void cargar_informacion() {
        try {
            Object[] o = null;
            List<Compras> listaclientes = cclientes.findComprasEntities();
            for (int i = 0; i < listaclientes.size(); i++) {
                modelo.addRow(o);
                modelo.setValueAt(listaclientes.get(i).getCodCom(), i, 0);
                modelo.setValueAt(listaclientes.get(i).getFecCom(), i, 1);
                modelo.setValueAt(listaclientes.get(i).getIdProveedores(), i, 2);
                modelo.setValueAt(listaclientes.get(i).getProCom(), i, 3);
                modelo.setValueAt(listaclientes.get(i).getCanCom(), i, 4);
                modelo.setValueAt(listaclientes.get(i).getPreCom(), i, 5);
                modelo.setValueAt(listaclientes.get(i).getPreVenCom(), i, 6);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_compras = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_compras = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_producto = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_precioc = new javax.swing.JTextField();
        txt_preciov = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jd_fecha = new org.jdesktop.swingx.JXDatePicker();
        cb_proveedor = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

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

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new_file256_25213.png"))); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/document-edit_114472.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/document_delete_256_icon-icons.com_75995.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btn_nuevo)
                .addGap(45, 45, 45)
                .addComponent(btn_editar)
                .addGap(44, 44, 44)
                .addComponent(btn_eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tab_compras.addTab("Mantenimiento", jPanel3);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Codigo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 24, 80, 25));

        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 61, 80, 25));

        jLabel3.setText("Marca:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 98, 80, 25));

        jLabel4.setText("Producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 135, 80, 25));

        jLabel5.setText("Cantidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 25));

        jLabel6.setText("Precio Compra");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 25));

        jLabel7.setText("Precio Venta");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 25));
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 150, 25));
        jPanel1.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, 25));

        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, 25));

        txt_precioc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_preciocKeyTyped(evt);
            }
        });
        jPanel1.add(txt_precioc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, 25));

        txt_preciov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_preciovKeyTyped(evt);
            }
        });
        jPanel1.add(txt_preciov, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 150, 25));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save_78348.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/receipt_cancel_icon_177356.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compras.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 80, 100));
        jPanel1.add(jd_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, -1));

        jPanel1.add(cb_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 150, 30));

        tab_compras.addTab("Compras", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tab_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
           cls_conexion cnx = new cls_conexion();

        ResultSet rs = cnx.Consulta("SELECT max(cod_com)+1 as Codigo from compras");
        try {
            while (rs.next()) {
                if (rs.getObject("Codigo") == null) {
                    txt_codigo.setText("1");
                } else {
                    txt_codigo.setText(rs.getObject("Codigo").toString());
                }

            }
            txt_codigo.setEnabled(true);

            txt_codigo.setEnabled(true);
            tab_compras.setEnabledAt(1, true);
            tab_compras.setEnabledAt(0, false);
            tab_compras.setSelectedIndex(1);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema inventario", JOptionPane.ERROR_MESSAGE);

        }
        txt_codigo.setEnabled(false);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void limpiar() {
        txt_codigo.setText("");

        txt_producto.setText("");
        txt_cantidad.setText("");
        txt_precioc.setText("");
        txt_preciov.setText("");

    }

   
    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
       if (tabla_compras.getSelectedRow() >= 0) {

            try {
                cclientes.destroy(Integer.parseInt(tabla_compras.getValueAt(tabla_compras.getSelectedRow(), 0).toString()));
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            createmodelo();
            cargar_informacion();

        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        tab_compras.setEnabledAt(0, true);
        tab_compras.setEnabledAt(1, false);
        tab_compras.setSelectedIndex(0);
        tab_compras.setVisible(true);

        createmodelo();
        cargar_informacion();
        limpiar();
        
    }//GEN-LAST:event_btn_cancelarActionPerformed
    private boolean ga = false;
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
       try {
            Compras cli = new Compras();
            cli.setCodCom(Integer.parseInt(txt_codigo.getText()));
            cli.setFecCom(jd_fecha.getDate().toLocaleString());
            cli.setIdProveedores(CortarCodigo(cb_proveedor.getSelectedItem().toString()));
            cli.setProCom(txt_producto.getText());
            cli.setCanCom(Integer.parseInt(txt_cantidad.getText()));
            cli.setPreCom(Double.parseDouble(txt_precioc.getText()));
            cli.setPreVenCom(Double.parseDouble(txt_preciov.getText()));

            //cclientes.create(cli);
            if (ga == false) {
                cclientes.create(cli);
            } else {
                cclientes.edit(cli);
                ga = false;
            }

            JOptionPane.showMessageDialog(null, "Los datos se han guardado satisfactoriamente!!");
            createmodelo();
            cargar_informacion();
            limpiar();

            tab_compras.setEnabledAt(0, true);
            tab_compras.setEnabledAt(1, false);
            tab_compras.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed

         try {
            if (tabla_compras.getSelectedRow() >= 0) {
                //cod_equi, nombre_equi, marca_equi, mod_equi, cant_equi, col_equi, cos_uni_equi, est_equi
                txt_codigo.setText(tabla_compras.getValueAt(tabla_compras.getSelectedRow(), 0).toString()); 
                txt_producto.setText(tabla_compras.getValueAt(tabla_compras.getSelectedRow(), 3).toString());
                txt_cantidad.setText(tabla_compras.getValueAt(tabla_compras.getSelectedRow(), 4).toString());
                txt_precioc.setText(tabla_compras.getValueAt(tabla_compras.getSelectedRow(), 5).toString());
                txt_preciov.setText(tabla_compras.getValueAt(tabla_compras.getSelectedRow(), 6).toString());

                tab_compras.setEnabledAt(1, true);
                tab_compras.setEnabledAt(0, false);
                tab_compras.setSelectedIndex(1);
                ga = true;
                txt_codigo.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "seleccione una fila");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_btn_editarActionPerformed

    private void txt_preciocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preciocKeyTyped

    }//GEN-LAST:event_txt_preciocKeyTyped

    private void txt_preciovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_preciovKeyTyped

    }//GEN-LAST:event_txt_preciovKeyTyped

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')) {
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_txt_cantidadKeyTyped
    public int CortarCodigo(String Cadena) {

        String res = "";
        for (int i = 0; i <= Cadena.length() - 1; i++) {
            String a = Cadena.substring(i, i + 1);
            if (a.equals("-")) {
                break;
            } else {
                res = res + a;
            }
        }
        System.out.println("holaa");
        return Integer.parseInt(res);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cb_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jd_fecha;
    private javax.swing.JTabbedPane tab_compras;
    private javax.swing.JTable tabla_compras;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_precioc;
    private javax.swing.JTextField txt_preciov;
    private javax.swing.JTextField txt_producto;
    // End of variables declaration//GEN-END:variables
}
