
package BDacademico;
import java.sql.*; //libreria para conexion con mysql
import javax.swing.table.DefaultTableModel; //para trabajar con jtable
import javax.swing.JOptionPane;

public class Frm_MantTurno extends javax.swing.JFrame {
//mostrar los datos en la tabla
DefaultTableModel modeloTablaTurno = new DefaultTableModel();
//objetos de conexion a la base de datos
Conexion_alexander conexionBD;
    
    public Frm_MantTurno() {
         this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents(); //inizialisa los componentes visuales
        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        txtdescripcionturno.setEnabled(false);
        txtcodigoturno.setEnabled(false);
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
String titulos[] = {
    "Código Turno",
    "Descripción"
};

modeloTablaTurno.setColumnIdentifiers(titulos);

JTABLE_Mant_Turnos.setModel(modeloTablaTurno);

/* 3. Deshabilitar el código */
txtcodigoturno.setEnabled(false);

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
        txtcodigoturno = new javax.swing.JTextField();
        txtdescripcionturno = new javax.swing.JTextField();
        BTN_VerTurnos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Turnos = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarTurnos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE TURNOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Turno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigoturno.setEditable(false);
        txtcodigoturno.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoturno.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoturno.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoturno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoturno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigoturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtdescripcionturno.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtdescripcionturno.setForeground(new java.awt.Color(0, 0, 204));
        txtdescripcionturno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdescripcionturno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtdescripcionturno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionturnoKeyTyped(evt);
            }
        });
        jPanel1.add(txtdescripcionturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerTurnos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerTurnos.setText("VER TURNOS");
        BTN_VerTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerTurnosActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 120));

        JTABLE_Mant_Turnos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Turnos.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Turnos.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Turnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_TurnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Turnos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 810, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 190, 50));

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 190, 50));

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
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 200, 50));

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
        jLabel4.setText("Ingresar el Nombre de la Facultad");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarTurnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarTurnosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarTurnosKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarTurnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

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

    private void txtdescripcionturnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionturnoKeyTyped

    }//GEN-LAST:event_txtdescripcionturnoKeyTyped

    private void BTN_VerTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerTurnosActionPerformed
    this.mostrarTurnos();
    txtdescripcionturno.setEnabled(false);
    }//GEN-LAST:event_BTN_VerTurnosActionPerformed

    private void JTABLE_Mant_TurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_TurnosMouseClicked
        txtdescripcionturno.setEnabled(true);
        /*Obtener la fila seleccionada*/
    int filaseleccionada=JTABLE_Mant_Turnos.getSelectedRow();
    if(filaseleccionada>=0){
      /*llenar los campos de texto con los datos de la fila*/
      String codigo=JTABLE_Mant_Turnos.getValueAt(filaseleccionada, 0).toString();
      String nombre=JTABLE_Mant_Turnos.getValueAt(filaseleccionada, 1).toString();
      txtcodigoturno.setText(codigo);

      txtdescripcionturno.setText(nombre);
      /*Habilitar los botones relacionados*/

      BTN_Modificar.setEnabled(true);

      
      /*Opcional: deshabilitar boton guardar */
      BTN_Guardar.setEnabled(false);  
            // TODO add your handling code here:
                  
    }         

    }//GEN-LAST:event_JTABLE_Mant_TurnosMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
// Limpia los campos de texto
txtcodigoturno.setText("");     // Limpia el código (autogenerado por ver)
txtdescripcionturno.setText("");     // Limpia el nombre de la facultad

// Da el foco al campo de nombre para que el usuario empiece a escribir
txtdescripcionturno.requestFocus();
txtdescripcionturno.setEnabled(true);

// Habilita el botón Guardar (en caso esté deshabilitado)
BTN_Guardar.setEnabled(true);

BTN_Modificar.setEnabled(false);       

    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed

  try {

        /* 1. Obtener descripción */
        String descripcion = txtdescripcionturno.getText().trim();

        /* 2. Validar */
        if (descripcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese la descripción del turno.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            txtdescripcionturno.requestFocus();
            return;
        }

        /* 3. Insertar turno */
        conexionBD.insertarTurno(descripcion);

        /* 4. Mostrar mensaje */
        JOptionPane.showMessageDialog(
                this,
                "Turno registrado correctamente."
        );

        /* 5. Limpiar campos */
        txtcodigoturno.setText("");
        txtdescripcionturno.setText("");

        /* 6. Actualizar tabla */
        mostrarTurnos();

        BTN_Modificar.setEnabled(false);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al insertar el turno: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }  
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
 try {

        /* 1. Validar código */
        if (txtcodigoturno.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un turno de la tabla."
            );

            return;
        }

        /* 2. Obtener datos */
        int codigo = Integer.parseInt(
                txtcodigoturno.getText().trim()
        );

        String nuevaDescripcion = txtdescripcionturno.getText().trim();

        /* 3. Validar descripción */
        if (nuevaDescripcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese la descripción del turno.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            txtdescripcionturno.requestFocus();
            return;
        }

        /* 4. Modificar turno */
        conexionBD.modificarTurno(codigo, nuevaDescripcion);

        /* 5. Mostrar mensaje */
        JOptionPane.showMessageDialog(
                this,
                "Turno modificado correctamente."
        );

        /* 6. Limpiar campos */
        txtcodigoturno.setText("");
        txtdescripcionturno.setText("");

        /* 7. Actualizar tabla */
        mostrarTurnos();

        BTN_Modificar.setEnabled(false);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El código del turno no es válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al modificar el turno: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed
        

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarTurnosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarTurnosKeyReleased
  
    try {

        /* 1. Obtener filtro */
        String filtro = TXT_BuscarTurnos.getText().trim();

        /* 2. Limpiar tabla */
        modeloTablaTurno.setRowCount(0);

        /* 3. Buscar turnos */
        ResultSet rs = conexionBD.buscarTurno(filtro);

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("turno")
            };

            modeloTablaTurno.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al buscar turnos: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_TXT_BuscarTurnosKeyReleased

    private void TXT_BuscarTurnosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarTurnosKeyTyped

    }//GEN-LAST:event_TXT_BuscarTurnosKeyTyped

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
            java.util.logging.Logger.getLogger(Frm_MantTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MantTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_MantTurno().setVisible(true);
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
    private javax.swing.JButton BTN_VerTurnos;
    private javax.swing.JTable JTABLE_Mant_Turnos;
    private javax.swing.JTextField TXT_BuscarTurnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigoturno;
    private javax.swing.JTextField txtdescripcionturno;
    // End of variables declaration//GEN-END:variables
/* 1. Método para mostrar turnos */
public void mostrarTurnos() {

    modeloTablaTurno.setRowCount(0);

    try {

        ResultSet rs = conexionBD.listarTurnos();

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("turno")
            };

            modeloTablaTurno.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al mostrar los turnos: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
}