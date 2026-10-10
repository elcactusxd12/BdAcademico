package BDacademico;

import java.sql.*; //libreria para conexion con mysql
import javax.swing.table.DefaultTableModel; //para trabajar con jtable
import javax.swing.JOptionPane;

public class Frm_MantTipo_pago extends javax.swing.JFrame {
//mostrar los datos en la tabla

    DefaultTableModel modeloTablaTipoPago = new DefaultTableModel();
//objetos de conexion a la base de datos
    Conexion_miguel conexionBD;

    public Frm_MantTipo_pago() {
         this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents(); //inizialisa los componentes visuales
 this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        
        
        txtconceptopago.setEnabled(false);
        txtcodigotipopago.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);

        //crear la conexion al iniciar el formulario
        conexionBD = new Conexion_miguel();
        //verificar si la conexion fue exitosa
        if (conexionBD.getConexion() == null) {
            JOptionPane.showMessageDialog(this, "no se puede conectar con la base de datos.",
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
            return;//evita continuar si no hay conexion
        }
        /* 2. Definir encabezados */
        String titulos[] = {
            "Código Tipo de Pago",
            "Concepto de Pago"
        };

        modeloTablaTipoPago.setColumnIdentifiers(titulos);

        JTABLE_Mant_TiposPago.setModel(modeloTablaTipoPago);

        /* 3. Deshabilitar el código */
        txtcodigotipopago.setEnabled(false);

        /* 4. Deshabilitar modificar al inicio */
        BTN_Modificar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigotipopago = new javax.swing.JTextField();
        txtconceptopago = new javax.swing.JTextField();
        BTN_VerFacultades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_TiposPago = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarTiposPago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE TIPOS DE  PAGO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Concepto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigotipopago.setEditable(false);
        txtcodigotipopago.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigotipopago.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigotipopago.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigotipopago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigotipopago.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigotipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtconceptopago.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtconceptopago.setForeground(new java.awt.Color(0, 0, 204));
        txtconceptopago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtconceptopago.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtconceptopago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtconceptopagoKeyTyped(evt);
            }
        });
        jPanel1.add(txtconceptopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerFacultades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerFacultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerFacultades.setText("VER TIPOS DE PAGO");
        BTN_VerFacultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerFacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerFacultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 120));

        JTABLE_Mant_TiposPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_TiposPago.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_TiposPago.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_TiposPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_TiposPagoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_TiposPago);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 810, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 190, 50));

        BTN_Guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarMouseClicked(evt);
            }
        });
        BTN_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 190, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Modificar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        BTN_Modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BTN_ModificarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BTN_ModificarKeyTyped(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 200, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Concepto de pago");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarTiposPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarTiposPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarTiposPagoKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarTiposPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 810, 50));

        BTN_Cerrar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir.png"))); // NOI18N
        BTN_Cerrar1.setText("Cerrar");
        BTN_Cerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Cerrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 130, 40));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtconceptopagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtconceptopagoKeyTyped

    }//GEN-LAST:event_txtconceptopagoKeyTyped

    private void BTN_VerFacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerFacultadesActionPerformed
        this.mostrarTiposPago();
        txtconceptopago.setEnabled(false);
    }//GEN-LAST:event_BTN_VerFacultadesActionPerformed

    private void JTABLE_Mant_TiposPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_TiposPagoMouseClicked
        txtconceptopago.setEnabled(true);
        /*Obtener la fila seleccionada*/
        int filaseleccionada = JTABLE_Mant_TiposPago.getSelectedRow();
        if (filaseleccionada >= 0) {
            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_TiposPago.getValueAt(filaseleccionada, 0).toString();
            String nombre = JTABLE_Mant_TiposPago.getValueAt(filaseleccionada, 1).toString();
            txtcodigotipopago.setText(codigo);

            txtconceptopago.setText(nombre);
            /*Habilitar los botones relacionados*/

            BTN_Modificar.setEnabled(true);

            /*Opcional: deshabilitar boton guardar */
            BTN_Guardar.setEnabled(false);
            // TODO add your handling code here:

        }

    }//GEN-LAST:event_JTABLE_Mant_TiposPagoMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
// Limpia los campos de texto
        txtcodigotipopago.setText("");     // Limpia el código (autogenerado por ver)
        txtconceptopago.setText("");     // Limpia el nombre de la facultad

// Da el foco al campo de nombre para que el usuario empiece a escribir
        txtconceptopago.requestFocus();
        txtconceptopago.setEnabled(true);

// Habilita el botón Guardar (en caso esté deshabilitado)
        BTN_Guardar.setEnabled(true);

        BTN_Modificar.setEnabled(false);

    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed

        try {

            /* 1. Obtener concepto */
            String concepto = txtconceptopago.getText().trim();

            /* 2. Validar campo */
            if (concepto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese el concepto del tipo de pago.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );

                txtconceptopago.requestFocus();
                return;
            }

            /* 3. Insertar tipo de pago */
            conexionBD.insertarTipoPago(concepto);

            /* 4. Mostrar mensaje */
            JOptionPane.showMessageDialog(
                    this,
                    "Tipo de pago registrado correctamente."
            );

            /* 5. Limpiar campos */
            txtcodigotipopago.setText("");
            txtconceptopago.setText("");

            /* 6. Actualizar tabla */
            mostrarTiposPago();

            BTN_Modificar.setEnabled(false);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al insertar el tipo de pago: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        try {

            /* 1. Validar código */
            if (txtcodigotipopago.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione un tipo de pago de la tabla."
                );

                return;
            }

            /* 2. Obtener datos */
            int codigo = Integer.parseInt(
                    txtcodigotipopago.getText().trim()
            );

            String nuevoConcepto = txtconceptopago.getText().trim();

            /* 3. Validar concepto */
            if (nuevoConcepto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese el concepto del tipo de pago.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );

                txtconceptopago.requestFocus();
                return;
            }

            /* 4. Modificar tipo de pago */
            conexionBD.modificarTipoPago(codigo, nuevoConcepto);

            /* 5. Mostrar mensaje */
            JOptionPane.showMessageDialog(
                    this,
                    "Tipo de pago modificado correctamente."
            );

            /* 6. Limpiar campos */
            txtcodigotipopago.setText("");
            txtconceptopago.setText("");

            /* 7. Actualizar tabla */
            mostrarTiposPago();

            BTN_Modificar.setEnabled(false);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El código del tipo de pago no es válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al modificar el tipo de pago: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed


    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarTiposPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarTiposPagoKeyReleased

        try {

            /* 1. Obtener filtro */
            String filtro = TXT_BuscarTiposPago.getText().trim();

            /* 2. Limpiar tabla */
            modeloTablaTipoPago.setRowCount(0);

            /* 3. Buscar tipos de pago */
            ResultSet rs = conexionBD.buscarTipoPago(filtro);

            while (rs.next()) {

                Object[] fila = {
                    rs.getInt("codigo"),
                    rs.getString("concepto")
                };

                modeloTablaTipoPago.addRow(fila);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al buscar tipos de pago: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }//GEN-LAST:event_TXT_BuscarTiposPagoKeyReleased

    private void TXT_BuscarTiposPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarTiposPagoKeyTyped

    }//GEN-LAST:event_TXT_BuscarTiposPagoKeyTyped

    private void BTN_Cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Cerrar1ActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Cerrar conexión si tienes un método cerrarConexion()
                conexionBD.cerrarConexion();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());

            }
            // Cierra el formulario actual
            dispose(); // o this.dispose() si estás dentro del formulario
        }
    }//GEN-LAST:event_BTN_Cerrar1ActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void BTN_ModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_ModificarKeyReleased

    }//GEN-LAST:event_BTN_ModificarKeyReleased

    private void BTN_ModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_ModificarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ModificarKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTipo_pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTipo_pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTipo_pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTipo_pago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_MantTipo_pago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar1;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerFacultades;
    private javax.swing.JTable JTABLE_Mant_TiposPago;
    private javax.swing.JTextField TXT_BuscarTiposPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigotipopago;
    private javax.swing.JTextField txtconceptopago;
    // End of variables declaration//GEN-END:variables
/* 1. Método para mostrar tipos de pago */
    public void mostrarTiposPago() {

        modeloTablaTipoPago.setRowCount(0);

        try {

            ResultSet rs = conexionBD.listarTiposPago();

            while (rs.next()) {

                Object[] fila = {
                    rs.getInt("codigo"),
                    rs.getString("concepto")
                };

                modeloTablaTipoPago.addRow(fila);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al mostrar los tipos de pago: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
