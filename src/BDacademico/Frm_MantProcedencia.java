
package BDacademico;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_MantProcedencia extends javax.swing.JFrame {
DefaultTableModel modeloTablaProcedencia = new DefaultTableModel();

Conexion_miguel conexionBD;
    
    public Frm_MantProcedencia() {
        this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents(); //inizialisa los componentes visuales
        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        
        txtdescripcionProcedencia.setEnabled(false);
        txtcodigoProcedencia.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
         
         
         //crear la conexion al iniciar el formulario
          conexionBD = new  Conexion_miguel();
          //verificar si la conexion fue exitosa
          if (conexionBD.getConexion() == null){
              JOptionPane.showMessageDialog(this, "no se puede conectar con la base de datos.",
                                                  "Error de conexion",JOptionPane.ERROR_MESSAGE);
              return;//evita continuar si no hay conexion
          }
          /* 2. Definir los encabezados */
String titulos[] = {
    "Código Procedencia",
    "Descripción"
};

modeloTablaProcedencia.setColumnIdentifiers(titulos);

JTABLE_Mant_Procedencia.setModel(modeloTablaProcedencia);

/* 3. Deshabilitar el código */
txtcodigoProcedencia.setEnabled(false);

/* 4. Deshabilitar modificar inicialmente */
BTN_Modificar.setEnabled(false);
    }
   
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigoProcedencia = new javax.swing.JTextField();
        txtdescripcionProcedencia = new javax.swing.JTextField();
        BTN_VerFacultades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Procedencia = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarProcedencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE PROCEDENCIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Procedencia");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigoProcedencia.setEditable(false);
        txtcodigoProcedencia.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoProcedencia.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoProcedencia.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoProcedencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoProcedencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigoProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtdescripcionProcedencia.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtdescripcionProcedencia.setForeground(new java.awt.Color(0, 0, 204));
        txtdescripcionProcedencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdescripcionProcedencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtdescripcionProcedencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionProcedenciaKeyTyped(evt);
            }
        });
        jPanel1.add(txtdescripcionProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerFacultades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerFacultades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerFacultades.setText("VER PROCEDENCIA");
        BTN_VerFacultades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerFacultadesActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerFacultades, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 210, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 120));

        JTABLE_Mant_Procedencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Procedencia.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Procedencia.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Procedencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_ProcedenciaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Procedencia);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 810, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 190, 50));

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 190, 50));

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
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 200, 50));

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
        jLabel4.setText("Ingresar la descripcion de la procedencia");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        TXT_BuscarProcedencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarProcedenciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarProcedenciaKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

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

    private void txtdescripcionProcedenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionProcedenciaKeyTyped

    }//GEN-LAST:event_txtdescripcionProcedenciaKeyTyped

    private void BTN_VerFacultadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerFacultadesActionPerformed
    this.mostrarProcedencias();
    txtdescripcionProcedencia.setEnabled(false);
    }//GEN-LAST:event_BTN_VerFacultadesActionPerformed

    private void JTABLE_Mant_ProcedenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_ProcedenciaMouseClicked
        txtdescripcionProcedencia.setEnabled(true);
        /*Obtener la fila seleccionada*/
    int filaseleccionada=JTABLE_Mant_Procedencia.getSelectedRow();
    if(filaseleccionada>=0){
      /*llenar los campos de texto con los datos de la fila*/
      String codigo=JTABLE_Mant_Procedencia.getValueAt(filaseleccionada, 0).toString();
      String nombre=JTABLE_Mant_Procedencia.getValueAt(filaseleccionada, 1).toString();
      txtcodigoProcedencia.setText(codigo);

      txtdescripcionProcedencia.setText(nombre);
      /*Habilitar los botones relacionados*/

      BTN_Modificar.setEnabled(true);

      
      /*Opcional: deshabilitar boton guardar */
      BTN_Guardar.setEnabled(false);  
            // TODO add your handling code here:
                  
    }         

    }//GEN-LAST:event_JTABLE_Mant_ProcedenciaMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
// Limpia los campos de texto
txtcodigoProcedencia.setText("");     // Limpia el código (autogenerado por ver)
txtdescripcionProcedencia.setText("");     // Limpia el nombre de la facultad

// Da el foco al campo de nombre para que el usuario empiece a escribir
txtdescripcionProcedencia.requestFocus();
txtdescripcionProcedencia.setEnabled(true);

// Habilita el botón Guardar (en caso esté deshabilitado)
BTN_Guardar.setEnabled(true);

BTN_Modificar.setEnabled(false);       

    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed

  try {

        /* 1. Obtener la descripción */
        String descripcion =
                txtdescripcionProcedencia.getText().trim();

        /* 2. Validar el campo */
        if (descripcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese la descripción de la procedencia.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            txtdescripcionProcedencia.requestFocus();
            return;
        }

        /* 3. Insertar procedencia */
        conexionBD.insertarProcedencia(descripcion);

        /* 4. Mostrar mensaje */
        JOptionPane.showMessageDialog(
                this,
                "Procedencia registrada correctamente."
        );

        /* 5. Limpiar campos */
        txtcodigoProcedencia.setText("");
        txtdescripcionProcedencia.setText("");

        /* 6. Actualizar tabla */
        mostrarProcedencias();

        BTN_Modificar.setEnabled(false);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al insertar la procedencia: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
try {

        /* 1. Validar que exista un código */
        if (txtcodigoProcedencia.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una procedencia de la tabla."
            );

            return;
        }

        /* 2. Obtener los datos */
        int codigo = Integer.parseInt(
                txtcodigoProcedencia.getText().trim()
        );

        String nuevaDescripcion =
                txtdescripcionProcedencia.getText().trim();

        /* 3. Validar descripción */
        if (nuevaDescripcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese la descripción de la procedencia.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            txtdescripcionProcedencia.requestFocus();
            return;
        }

        /* 4. Modificar procedencia */
        conexionBD.modificarProcedencia(codigo, nuevaDescripcion);

        /* 5. Mostrar mensaje */
        JOptionPane.showMessageDialog(
                this,
                "Procedencia modificada correctamente."
        );

        /* 6. Limpiar campos */
        txtcodigoProcedencia.setText("");
        txtdescripcionProcedencia.setText("");

        /* 7. Actualizar tabla */
        mostrarProcedencias();

        BTN_Modificar.setEnabled(false);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El código de la procedencia no es válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al modificar la procedencia: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed
        

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarProcedenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarProcedenciaKeyReleased
  
     try {

        /* 1. Obtener el texto de búsqueda */
        String filtro = TXT_BuscarProcedencia.getText().trim();

        /* 2. Limpiar la tabla */
        modeloTablaProcedencia.setRowCount(0);

        /* 3. Buscar procedencias */
        ResultSet rs = conexionBD.buscarProcedencia(filtro);

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("procedencia")
            };

            modeloTablaProcedencia.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al buscar procedencias: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_TXT_BuscarProcedenciaKeyReleased

    private void TXT_BuscarProcedenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarProcedenciaKeyTyped

    }//GEN-LAST:event_TXT_BuscarProcedenciaKeyTyped

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
            java.util.logging.Logger.getLogger(Frm_MantProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MantProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MantProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MantProcedencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_MantProcedencia().setVisible(true);
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
    private javax.swing.JTable JTABLE_Mant_Procedencia;
    private javax.swing.JTextField TXT_BuscarProcedencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigoProcedencia;
    private javax.swing.JTextField txtdescripcionProcedencia;
    // End of variables declaration//GEN-END:variables
/* 1. Método para mostrar procedencias */
public void mostrarProcedencias() {

    modeloTablaProcedencia.setRowCount(0);

    try {

        ResultSet rs = conexionBD.listarProcedencias();

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("procedencia")
            };

            modeloTablaProcedencia.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al mostrar las procedencias: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
}