
package BDacademico;
import BDacademico.Conexion_alexander;
import java.sql.*; //libreria para conexion con mysql
import javax.swing.table.DefaultTableModel; //para trabajar con jtable
import javax.swing.JOptionPane;

public class Frm_Modalidad extends javax.swing.JFrame {
//mostrar los datos en la tabla
DefaultTableModel modeloTablaModalidad = new DefaultTableModel();
//objetos de conexion a la base de datos
Conexion_alexander conexionBD;
    
    public Frm_Modalidad() {
         this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true); // Oculta la barra de título por completo
        initComponents(); //inizialisa los componentes visuales
        
        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        
        txtnombremodalidad.setEnabled(false);
        txtcodigomodalidad.setEnabled(false);
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
         //definir encabezados de la tabla
        String titulos[] = {"Codigo Modalidad", "Modalidad"};
        //asignar titulos al modelo
        modeloTablaModalidad.setColumnIdentifiers(titulos);
        //Establecer el modelo de la Jtable
          JTABLE_Mant_Modalidades.setModel(modeloTablaModalidad);
          //desahabilitar campo de codigo
          txtcodigomodalidad.setEnabled(false);
    }
   
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigomodalidad = new javax.swing.JTextField();
        txtnombremodalidad = new javax.swing.JTextField();
        BTN_VerModalidades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Modalidades = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarModalidades = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE MODALIDAD");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Modalidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre Modalidad");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigomodalidad.setEditable(false);
        txtcodigomodalidad.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigomodalidad.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigomodalidad.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigomodalidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigomodalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigomodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtnombremodalidad.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombremodalidad.setForeground(new java.awt.Color(0, 0, 204));
        txtnombremodalidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombremodalidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombremodalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombremodalidadKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombremodalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerModalidades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerModalidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerModalidades.setText("VER MODALIDADES");
        BTN_VerModalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerModalidadesActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerModalidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 230, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 120));

        JTABLE_Mant_Modalidades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Modalidades.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Modalidades.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Modalidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_ModalidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Modalidades);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 810, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 190, 50));

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 190, 50));

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
        jLabel4.setText("Ingresar el Nombre de la Modalidad");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        TXT_BuscarModalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarModalidadesActionPerformed(evt);
            }
        });
        TXT_BuscarModalidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarModalidadesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarModalidadesKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarModalidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

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

    private void txtnombremodalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombremodalidadKeyTyped

    }//GEN-LAST:event_txtnombremodalidadKeyTyped

    private void BTN_VerModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerModalidadesActionPerformed
    this.mostrarModalidades();
    txtnombremodalidad.setEnabled(false);
    }//GEN-LAST:event_BTN_VerModalidadesActionPerformed

    private void JTABLE_Mant_ModalidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_ModalidadesMouseClicked
       txtnombremodalidad.setEnabled(true);

    /* Obtener la fila seleccionada */
    int filaseleccionada =
            JTABLE_Mant_Modalidades.getSelectedRow();

    if (filaseleccionada >= 0) {

        /* llenar los campos de texto con los datos de la fila */
        String codigo =
                JTABLE_Mant_Modalidades
                        .getValueAt(filaseleccionada, 0)
                        .toString();

        String nombre =
                JTABLE_Mant_Modalidades
                        .getValueAt(filaseleccionada, 1)
                        .toString();

        txtcodigomodalidad.setText(codigo);
        txtnombremodalidad.setText(nombre);

        /* Habilitar el botón modificar */
        BTN_Modificar.setEnabled(true);

        /* Deshabilitar botón guardar */
        BTN_Guardar.setEnabled(false);
    }

    }//GEN-LAST:event_JTABLE_Mant_ModalidadesMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
                                        

    // Limpia los campos de texto
    txtcodigomodalidad.setText("");
    txtnombremodalidad.setText("");

    // Da el foco al campo de nombre
    txtnombremodalidad.requestFocus();
    txtnombremodalidad.setEnabled(true);

    // Habilita el botón Guardar
    BTN_Guardar.setEnabled(true);

    // Deshabilita Modificar
    BTN_Modificar.setEnabled(false);


    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed

 // 1. Validar que el campo no esté vacío
    String nombre = txtnombremodalidad.getText().trim();

    if (nombre.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Ingrese el nombre de la modalidad",
                "Campo requerido",
                JOptionPane.WARNING_MESSAGE
        );

        txtnombremodalidad.requestFocus();

        return;
    }

    // 2. Confirmar si el usuario desea guardar
    int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Desea guardar el registro de modalidad?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {

        try {

            // 3. Llamar al método para insertar
            conexionBD.insertarModalidad(nombre);

            // 4. Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(
                    this,
                    "Modalidad registrada correctamente",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // 5. Actualizar tabla
            this.mostrarModalidades();

            // 6. Limpiar campos
            txtcodigomodalidad.setText("");
            txtnombremodalidad.setText("");

            // 7. Deshabilitar controles
            txtnombremodalidad.setEnabled(false);
            BTN_Guardar.setEnabled(false);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al registrar modalidad:\n"
                    + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
// Validar que se haya seleccionado un registro
    String codStr = txtcodigomodalidad.getText().trim();
    String nuevoNombre = txtnombremodalidad.getText().trim();

    if (codStr.isEmpty() || nuevoNombre.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Seleccione una modalidad y complete el nuevo nombre",
                "Campo requerido",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    int codigo;

    try {

        codigo = Integer.parseInt(codStr);

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El código de la modalidad no es válido",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

        return;
    }

    // Confirmación del usuario
    int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Desea modificar esta modalidad?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {

        try {

            // Modificar modalidad
            conexionBD.modificarModalidad(
                    codigo,
                    nuevoNombre
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Modalidad modificada correctamente",
                    "Modificación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Actualizar tabla
            this.mostrarModalidades();

            // Limpiar campos
            txtcodigomodalidad.setText("");
            txtnombremodalidad.setText("");

            // Deshabilitar botones
            BTN_Modificar.setEnabled(false);
            BTN_Guardar.setEnabled(false);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al modificar modalidad:\n"
                    + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed
        

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarModalidadesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarModalidadesKeyReleased
  modeloTablaModalidad .setRowCount(0);

    String nombre =
            TXT_BuscarModalidades.getText().trim();

    try {

        ResultSet rs =
                conexionBD.buscarModalidad(nombre);

        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("modalidad")
            };

            modeloTablaModalidad.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al mostrar modalidades:\n"
                + e.getMessage(),
                "Error de consulta",
                JOptionPane.ERROR_MESSAGE
        );
    }


    }//GEN-LAST:event_TXT_BuscarModalidadesKeyReleased

    private void TXT_BuscarModalidadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarModalidadesKeyTyped

    }//GEN-LAST:event_TXT_BuscarModalidadesKeyTyped

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

    private void TXT_BuscarModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarModalidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarModalidadesActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Modalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Modalidad().setVisible(true);
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
    private javax.swing.JButton BTN_VerModalidades;
    private javax.swing.JTable JTABLE_Mant_Modalidades;
    private javax.swing.JTextField TXT_BuscarModalidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigomodalidad;
    private javax.swing.JTextField txtnombremodalidad;
    // End of variables declaration//GEN-END:variables
public void mostrarModalidades() {

    // ordenar ASC, DSC
    JTABLE_Mant_Modalidades.setAutoCreateRowSorter(true);

    // limpiar la tabla antes de mostrar nuevos datos
    modeloTablaModalidad.setRowCount(0);

    try {

        // llama al método que devuelve los datos de modalidades
        ResultSet rs =
                conexionBD.listarModalidades();

        // recorre cada fila del resultado y agrega a la tabla
        while (rs.next()) {

            Object[] fila = {
                rs.getInt("codigo"),
                rs.getString("modalidad")
            };

            modeloTablaModalidad.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al mostrar modalidades:\n"
                + e.getMessage(),
                "Error de consulta",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
}