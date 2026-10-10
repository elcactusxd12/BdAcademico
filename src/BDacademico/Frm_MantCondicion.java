
package BDacademico;
import java.sql.*; //libreria para conexion con mysql
import javax.swing.table.DefaultTableModel; //para trabajar con jtable
import javax.swing.JOptionPane;

public class Frm_MantCondicion extends javax.swing.JFrame {
DefaultTableModel modeloTablaCondicion = new DefaultTableModel();

Conexion_alexander conexionBD;


    
    public Frm_MantCondicion() {
          this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents(); //inizialisa los componentes visuales
        
        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        
        txtnombrecondicion.setEnabled(false);
        txtcodigocondicion.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
       
         
         //crear la conexion al iniciar el formulario
          conexionBD = new  Conexion_alexander();
          //verificar si la conexion fue exitosa
          if (conexionBD.getConexion() == null){
              JOptionPane.showMessageDialog(this, "no se puede conectar con la base de datos.",
                                                  "Error de conexion",JOptionPane.ERROR_MESSAGE);
              return;//evita continuar si no hay conexion
}
          /* 2. Configurar encabezados */
    String titulos[] = {"Código Condición", "Nombre Condición"};

modeloTablaCondicion.setColumnIdentifiers(titulos);

JTABLE_Mant_Condiciones.setModel(modeloTablaCondicion);

/* 3. Deshabilitar el código */
txtcodigocondicion.setEnabled(false);

/* 4. Configurar botones */
BTN_Modificar.setEnabled(false);
    }
    
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigocondicion = new javax.swing.JTextField();
        txtnombrecondicion = new javax.swing.JTextField();
        BTN_VerFacultades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Condiciones = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarCondicion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE CONDICIONES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Condicion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre Condicion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigocondicion.setEditable(false);
        txtcodigocondicion.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigocondicion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigocondicion.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigocondicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigocondicion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigocondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtnombrecondicion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombrecondicion.setForeground(new java.awt.Color(0, 0, 204));
        txtnombrecondicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrecondicion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombrecondicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrecondicionKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombrecondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerFacultades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerFacultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerFacultades.setText("VER CONDICIONES");
        BTN_VerFacultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerFacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerFacultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 120));

        JTABLE_Mant_Condiciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Condiciones.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Condiciones.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Condiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_CondicionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Condiciones);

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
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 200, 50));

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
        jLabel4.setText("Ingresar el Nombre de la Condicion");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarCondicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarCondicionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarCondicionKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

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

    private void txtnombrecondicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrecondicionKeyTyped

    }//GEN-LAST:event_txtnombrecondicionKeyTyped

    private void BTN_VerFacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerFacultadesActionPerformed
    this.mostrarCondiciones();
    txtnombrecondicion.setEnabled(false);
    }//GEN-LAST:event_BTN_VerFacultadesActionPerformed

    private void JTABLE_Mant_CondicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_CondicionesMouseClicked
      /* 1. Obtener la fila seleccionada */
int fila = JTABLE_Mant_Condiciones.getSelectedRow();

if (fila >= 0) {

    /* 2. Mostrar los datos */
    txtcodigocondicion.setText(
            JTABLE_Mant_Condiciones.getValueAt(fila, 0).toString()
    );

    txtnombrecondicion.setText(
            JTABLE_Mant_Condiciones.getValueAt(fila, 1).toString()
    );

    /* 3. Habilitar modificación */
    BTN_Modificar.setEnabled(true);
    this.txtnombrecondicion.setEnabled(true);
}  

    }//GEN-LAST:event_JTABLE_Mant_CondicionesMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
txtcodigocondicion.setText("");
    txtnombrecondicion.setText("");

    BTN_Guardar.setEnabled(true);
    BTN_Modificar.setEnabled(false);

    txtnombrecondicion.requestFocus();

    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed

 try {

        /* 1. Obtener el nombre */
        String nombre = txtnombrecondicion.getText().trim();

        /* 2. Validar el campo */
        if (nombre.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el nombre de la condición.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            txtnombrecondicion.requestFocus();
            return;
        }

        /* 3. Insertar condición */
        conexionBD.insertarCondicion(nombre);

        /* 4. Mostrar mensaje */
        JOptionPane.showMessageDialog(
                this,
                "Condición registrada correctamente."
        );

        /* 5. Limpiar campos */
        txtcodigocondicion.setText("");
        txtnombrecondicion.setText("");

        /* 6. Actualizar tabla */
        mostrarCondiciones();

        BTN_Modificar.setEnabled(false);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al insertar la condición: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
 try {

        /* 1. Validar código */
        if (txtcodigocondicion.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una condición de la tabla."
            );

            return;
        }

        /* 2. Obtener los datos */
        int codigo = Integer.parseInt(
                txtcodigocondicion.getText().trim()
        );

        String nuevoNombre = txtnombrecondicion.getText().trim();

        /* 3. Validar nombre */
        if (nuevoNombre.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el nombre de la condición.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            txtnombrecondicion.requestFocus();
            return;
        }

        /* 4. Modificar condición */
        conexionBD.modificarCondicion(codigo, nuevoNombre);

        /* 5. Mostrar mensaje */
        JOptionPane.showMessageDialog(
                this,
                "Condición modificada correctamente."
        );

        /* 6. Limpiar campos */
        txtcodigocondicion.setText("");
        txtnombrecondicion.setText("");

        /* 7. Actualizar tabla */
        mostrarCondiciones();

        BTN_Modificar.setEnabled(false);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El código de la condición no es válido."
        );

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al modificar la condición: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed
        

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarCondicionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCondicionKeyReleased
   try {

        /* 1. Obtener texto de búsqueda */
        String filtro = TXT_BuscarCondicion.getText().trim();

        /* 2. Limpiar tabla */
        modeloTablaCondicion.setRowCount(0);

        /* 3. Buscar condiciones */
        ResultSet rs = conexionBD.buscarCondicion(filtro);

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("condicion")
            };

            modeloTablaCondicion.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al buscar condiciones: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_TXT_BuscarCondicionKeyReleased

    private void TXT_BuscarCondicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCondicionKeyTyped

    }//GEN-LAST:event_TXT_BuscarCondicionKeyTyped

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
            java.util.logging.Logger.getLogger(Frm_MantCondicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MantCondicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MantCondicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MantCondicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_MantCondicion().setVisible(true);
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
    private javax.swing.JTable JTABLE_Mant_Condiciones;
    private javax.swing.JTextField TXT_BuscarCondicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigocondicion;
    private javax.swing.JTextField txtnombrecondicion;
    // End of variables declaration//GEN-END:variables
public void mostrarCondiciones() {

    modeloTablaCondicion.setRowCount(0);

    try {

        ResultSet rs = conexionBD.listarCondiciones();

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("condicion")
            };

            modeloTablaCondicion.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al mostrar las condiciones: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
}