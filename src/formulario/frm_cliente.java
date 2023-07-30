/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesfdhdgu ueowuh
 * and open the template in the editor.
 */
package formulario;

import controladores.exceptions.NonexistentEntityException;
import entidades.Clientes;
import clases.cls_conexion;
import java.awt.Color;
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
public class frm_cliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form frm_cliente
     */
    DefaultTableModel modelo;
    controladores.ClientesJpaController cclientes = new controladores.ClientesJpaController();

    public frm_cliente() {
        initComponents();

        clases.cls_conexion cnx = new clases.cls_conexion();
        cnx.cargarCombo("Select concat_WS('-', id_tip_cli, tip_cli) AS Nombre from tipo_clientes", cb_clientes);

        createmodelo();
        cargar_informacion();

        tab_clientes.setEnabledAt(0, true);
        tab_clientes.setEnabledAt(1, false);
        tab_clientes.setSelectedIndex(0);

    }

    private void limpiar() {
        txt_codigo.setText("");
        txt_ruc.setText("");
        txt_nombre.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");

    }

//    private void LlenarTabla() {
//        clases.cls_clientes obj = new clases.cls_clientes();
//        obj.CargarTabla(tabla_clientes);
//
//    }
    private void createmodelo() {
        try {
            modelo = (new DefaultTableModel(null, new String[]{"Código", "RUC", "Nombre", "Correo", "Teléfono", "Tipo_cliente"}) {
                Class[] types = new Class[]{
                    java.lang.Integer.class,
                    java.lang.Integer.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.Integer.class,
                    java.lang.Integer.class

                };
                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};

                @Override
                public Class getColumnClass(int columnindex) {
                    return types[columnindex];
                }

                @Override
                public boolean isCellEditable(int rowindex, int colindex) {
                    return canEdit[colindex];
                }
            });
            tabla_clientes.setModel(modelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "error");
        }
    }

    private void cargar_informacion() {
        try {
            Object[] o = null;
            List<Clientes> listaclientes = cclientes.findClientesEntities();
            for (int i = 0; i < listaclientes.size(); i++) {
                modelo.addRow(o);
                modelo.setValueAt(listaclientes.get(i).getCodCli(), i, 0);
                modelo.setValueAt(listaclientes.get(i).getRucCli(), i, 1);
                modelo.setValueAt(listaclientes.get(i).getNomCli(), i, 2);
                modelo.setValueAt(listaclientes.get(i).getCorCli(), i, 3);
                modelo.setValueAt(listaclientes.get(i).getTelCli(), i, 4);
                modelo.setValueAt(listaclientes.get(i).getIdTipCli(), i, 5);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_clientes = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_elinar = new javax.swing.JButton();
        Panel_buscar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cb_combo = new javax.swing.JComboBox<>();
        txt_buscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lb_codigo = new javax.swing.JLabel();
        lb_ruc = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lb_correo = new javax.swing.JLabel();
        lb_telefono = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_ruc = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lb_tip_cli = new javax.swing.JLabel();
        cb_clientes = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_clientes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 91, 709, 347));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 461, -1, -1));

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 461, -1, -1));

        btn_elinar.setText("Eliminar");
        btn_elinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elinarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_elinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 461, -1, -1));

        jLabel9.setText("Campos");

        cb_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Codigo", "Nombre", " " }));

        jLabel10.setText("Buscar:");

        btn_buscar.setText("Buscar:");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_buscarLayout = new javax.swing.GroupLayout(Panel_buscar);
        Panel_buscar.setLayout(Panel_buscarLayout);
        Panel_buscarLayout.setHorizontalGroup(
            Panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_buscarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(cb_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_buscar)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        Panel_buscarLayout.setVerticalGroup(
            Panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_buscarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(Panel_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.add(Panel_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btn_imprimir.setText("Imprimir");
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, -1));

        tab_clientes.addTab("Registro", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_codigo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lb_codigo.setText("Codigo");
        lb_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lb_codigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lb_codigoKeyReleased(evt);
            }
        });
        jPanel1.add(lb_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 146, 80, 30));

        lb_ruc.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lb_ruc.setText("Ruc");
        lb_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lb_rucKeyReleased(evt);
            }
        });
        jPanel1.add(lb_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 146, 80, 30));

        lb_nombre.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lb_nombre.setText("Nombre");
        jPanel1.add(lb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 80, 30));

        lb_correo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lb_correo.setText("Correo");
        jPanel1.add(lb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 80, 30));

        lb_telefono.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lb_telefono.setText("Telefono");
        jPanel1.add(lb_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 325, 80, 30));

        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 188, 125, 25));

        txt_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_rucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rucKeyTyped(evt);
            }
        });
        jPanel1.add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 188, 125, 25));

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
        });
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 125, 25));

        txt_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_correoKeyReleased(evt);
            }
        });
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 125, 25));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 125, 25));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/business_application_addmale_useradd_insert_add_user_client_2312.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 16, 118, 115));

        lb_tip_cli.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lb_tip_cli.setText("Tipo Clientes");
        jPanel1.add(lb_tip_cli, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 326, 100, 30));

        jPanel1.add(cb_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 125, 25));

        tab_clientes.addTab("Clientes", jPanel1);

        getContentPane().add(tab_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 544));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        cls_conexion cnx = new cls_conexion();
        if (cb_combo.getSelectedItem().toString().equals("*")) {
            cnx.CargarTabla("Select  cod_cli as CODIGO, ruc_cli as RUC, nom_cli as NOMBRE, cor_cli as CORREO, tel_cli as TELEFONO, tip_cli as Tipo_cliente From clientes inner join tipo_clientes on tipo_clientes.id_tip_cli=Clientes.id_tip_cli", tabla_clientes);

        }
        if (cb_combo.getSelectedItem().toString().equals("Codigo")) {
            cnx.CargarTabla("Select  cod_cli as CODIGO, ruc_cli as RUC, nom_cli as NOMBRE, cor_cli as CORREO, tel_cli as TELEFONO, tip_cli as Tipo_cliente From clientes inner join tipo_clientes on tipo_clientes.id_tip_cli=Clientes.id_tip_cli Where (cod_cli= " + txt_buscar.getText() + ")", tabla_clientes);

        }
        if (cb_combo.getSelectedItem().toString().equals("Nombre")) {
            cnx.CargarTabla("Select cod_cli as CODIGO, ruc_cli as RUC, nom_cli as NOMBRE, cor_cli as CORREO, tel_cli as TELEFONO, tip_cli as Tipo_cliente From clientes inner join tipo_clientes on tipo_clientes.id_tip_cli=Clientes.id_tip_cli Where (nom_cli='" + txt_buscar.getText() + "')", tabla_clientes);

        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        try {
            if (tabla_clientes.getSelectedRow() >= 0) {
                //cod_equi, nombre_equi, marca_equi, mod_equi, cant_equi, col_equi, cos_uni_equi, est_equi
                txt_codigo.setText(tabla_clientes.getValueAt(tabla_clientes.getSelectedRow(), 0).toString());
                txt_ruc.setText(tabla_clientes.getValueAt(tabla_clientes.getSelectedRow(), 1).toString());
                txt_nombre.setText(tabla_clientes.getValueAt(tabla_clientes.getSelectedRow(), 2).toString());
                txt_correo.setText(tabla_clientes.getValueAt(tabla_clientes.getSelectedRow(), 3).toString());
                txt_telefono.setText(tabla_clientes.getValueAt(tabla_clientes.getSelectedRow(), 4).toString());

                tab_clientes.setEnabledAt(1, true);
                tab_clientes.setEnabledAt(0, false);
                tab_clientes.setSelectedIndex(1);
                ga = true;
                txt_codigo.setEnabled(false);

            } else {
                
                JOptionPane.showMessageDialog(null, "seleccione una fila");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }


    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed

        cls_conexion cnx = new cls_conexion();

        ResultSet rs = cnx.Consulta("SELECT max(cod_cli)+1 as Codigo from clientes");
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
            tab_clientes.setEnabledAt(1, true);
            tab_clientes.setEnabledAt(0, false);
            tab_clientes.setSelectedIndex(1);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema inventario", JOptionPane.ERROR_MESSAGE);

        }
        txt_codigo.setEnabled(false);

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_elinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elinarActionPerformed
        if (tabla_clientes.getSelectedRow() >= 0) {

            try {
                cclientes.destroy(Integer.parseInt(tabla_clientes.getValueAt(tabla_clientes.getSelectedRow(), 0).toString()));
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            createmodelo();
            cargar_informacion();

        }
    }//GEN-LAST:event_btn_elinarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed

        tab_clientes.setEnabledAt(0, true);
        tab_clientes.setEnabledAt(1, false);
        tab_clientes.setSelectedIndex(0);
        Panel_buscar.setVisible(true);

        createmodelo();
        cargar_informacion();
        limpiar();
        txt_buscar.setText("");

    }//GEN-LAST:event_btn_cancelarActionPerformed
    private boolean ga = false;
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        try {
            Clientes cli = new Clientes();
            cli.setCodCli(Integer.parseInt(txt_codigo.getText()));
            cli.setRucCli(Integer.parseInt(txt_ruc.getText()));
            cli.setNomCli(txt_nombre.getText());
            cli.setCorCli(txt_correo.getText());
            cli.setTelCli(Integer.parseInt(txt_telefono.getText()));
            cli.setIdTipCli(CortarCodigo(cb_clientes.getSelectedItem().toString()));

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

            tab_clientes.setEnabledAt(0, true);
            tab_clientes.setEnabledAt(1, false);
            tab_clientes.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void lb_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lb_codigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_codigoKeyPressed

    private void lb_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lb_codigoKeyReleased


    }//GEN-LAST:event_lb_codigoKeyReleased

    private void lb_rucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lb_rucKeyReleased

    }//GEN-LAST:event_lb_rucKeyReleased

    private void txt_rucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyReleased

        if (txt_ruc.getText().equals("")) {
            lb_ruc.setForeground(Color.RED);

        } else {
            lb_ruc.setText("Ruc");
            lb_ruc.setForeground(Color.blue);
        }

    }//GEN-LAST:event_txt_rucKeyReleased

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased

        if (txt_nombre.getText().equals("")) {
            lb_nombre.setForeground(Color.RED);

        } else {
            lb_nombre.setText("Nombre");
            lb_nombre.setForeground(Color.blue);
        }

    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoKeyReleased

        if (txt_correo.getText().equals("")) {
            lb_correo.setForeground(Color.RED);

        } else {
            lb_correo.setText("Correo");
            lb_correo.setForeground(Color.blue);
        }


    }//GEN-LAST:event_txt_correoKeyReleased

    private void txt_telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyReleased

        if (txt_telefono.getText().equals("")) {
            lb_telefono.setForeground(Color.RED);

        } else {
            lb_telefono.setText("Telefono");
            lb_telefono.setForeground(Color.blue);
        }


    }//GEN-LAST:event_txt_telefonoKeyReleased

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')) {

            evt.consume();
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_rucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyTyped
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')) {
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
        }
    }//GEN-LAST:event_txt_rucKeyTyped

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
       
        
        clases.cls_reportes reporte = new clases.cls_reportes();
        reporte.ReporteCliente();
        
        
        
        
        
        
    }//GEN-LAST:event_btn_imprimirActionPerformed

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
        return Integer.parseInt(res);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_buscar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_elinar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cb_clientes;
    private javax.swing.JComboBox<String> cb_combo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_ruc;
    private javax.swing.JLabel lb_telefono;
    private javax.swing.JLabel lb_tip_cli;
    private javax.swing.JTabbedPane tab_clientes;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
