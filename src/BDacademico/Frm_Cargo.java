package BDacademico;
import java.sql.*; //libreria para conexion con mysql
import javax.swing.table.DefaultTableModel; //para trabajar con jtable
import javax.swing.JOptionPane;


public class Frm_Cargo extends javax.swing.JFrame {
    //mostrar los datos en la tabla
DefaultTableModel modeloTablaCargo = new DefaultTableModel();
//objetos de conexion a la base de datos

    
        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frm_Cargo.class.getName());
    Conexion_miguel conexionBD;
    
    public Frm_Cargo() {
         this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents();
          this.setLocationRelativeTo(null);
          this.setLocationRelativeTo(null);
        txtnombrecargo.setEnabled(true);
        txtcodigocargo.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
         BTN_Desactivar.setEnabled(false);
         //crear la conexion al iniciar el formulario
          conexionBD = new  Conexion_miguel();
          //verificar si la conexion fue exitosa
          if (conexionBD.getConexion() == null){
              JOptionPane.showMessageDialog(this, "no se puede conectar con la base de datos.",
                                                  "Error de conexion",JOptionPane.ERROR_MESSAGE);
              return;//evita continuar si no hay conexion
          }
            //definir encabezados de la tabla
          String titulos[] = {"Código Cargo", "Nombre Cargo", "Estado Cargo"};
          //asignar titulos al modelo
          modeloTablaCargo.setColumnIdentifiers(titulos);
          //Establecer el modelo de la Jtable
          JTABLE_Mant_Cargo.setModel(modeloTablaCargo);
          //desahabilitar campo de codigo
          txtcodigocargo.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigocargo = new javax.swing.JTextField();
        txtnombrecargo = new javax.swing.JTextField();
        BTN_VerCargos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Cargo = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_Desactivar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarCargos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE CARGOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Cargo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre Cargo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigocargo.setEditable(false);
        txtcodigocargo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigocargo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigocargo.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigocargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigocargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigocargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtnombrecargo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombrecargo.setForeground(new java.awt.Color(0, 0, 204));
        txtnombrecargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrecargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombrecargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrecargoKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombrecargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerCargos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerCargos.setText("VER CARGOS");
        BTN_VerCargos.addActionListener(this::BTN_VerCargosActionPerformed);
        jPanel1.add(BTN_VerCargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 120));

        JTABLE_Mant_Cargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Cargo.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Cargo.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_CargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Cargo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 810, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(this::BTN_NuevoActionPerformed);
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 190, 50));

        BTN_Guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarMouseClicked(evt);
            }
        });
        BTN_Guardar.addActionListener(this::BTN_GuardarActionPerformed);
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 190, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Modificar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(this::BTN_ModificarActionPerformed);
        BTN_Modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BTN_ModificarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BTN_ModificarKeyTyped(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 200, 50));

        BTN_Desactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/serv.png"))); // NOI18N
        BTN_Desactivar.setText("DAR DE BAJA");
        BTN_Desactivar.addActionListener(this::BTN_DesactivarActionPerformed);
        getContentPane().add(BTN_Desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 180, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(this::BTN_EXCELActionPerformed);
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de el Cargo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarCargos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarCargosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarCargosKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarCargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 810, 50));

        BTN_Cerrar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir.png"))); // NOI18N
        BTN_Cerrar1.setText("Cerrar");
        BTN_Cerrar1.addActionListener(this::BTN_Cerrar1ActionPerformed);
        getContentPane().add(BTN_Cerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 130, 40));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(this::BTN_PDFActionPerformed);
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombrecargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrecargoKeyTyped


    }//GEN-LAST:event_txtnombrecargoKeyTyped

    private void BTN_VerCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerCargosActionPerformed
                                                
    this.mostrarCargo();
    txtnombrecargo.setEnabled(false);



                }//GEN-LAST:event_BTN_VerCargosActionPerformed

    private void JTABLE_Mant_CargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_CargoMouseClicked
       txtnombrecargo.setEnabled(true);
        /*Obtener la fila seleccionada*/
    int filaseleccionada=JTABLE_Mant_Cargo.getSelectedRow();
    if(filaseleccionada>=0){
      /*llenar los campos de texto con los datos de la fila*/
      String codigo=JTABLE_Mant_Cargo.getValueAt(filaseleccionada, 0).toString();
      String nombre=JTABLE_Mant_Cargo.getValueAt(filaseleccionada, 1).toString();
      txtcodigocargo.setText(codigo);

      txtnombrecargo.setText(nombre);
      /*Habilitar los botones relacionados*/

      BTN_Modificar.setEnabled(true);

      BTN_Desactivar.setEnabled(true);
      /*Opcional: deshabilitar boton guardar */
      BTN_Guardar.setEnabled(false);  
            // TODO add your handling code here:
                  
    }         

     
    }//GEN-LAST:event_JTABLE_Mant_CargoMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
      // Limpia los campos de texto
txtcodigocargo.setText("");     // Limpia el código (autogenerado por ver)
txtnombrecargo.setText("");     // Limpia el nombre de la facultad

// Da el foco al campo de nombre para que el usuario empiece a escribir
txtnombrecargo.requestFocus();
txtnombrecargo.setEnabled(true);
// Habilita el botón Guardar (en caso esté deshabilitado)
BTN_Guardar.setEnabled(true);
BTN_Desactivar.setEnabled(false);
BTN_Modificar.setEnabled(false); 
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked

    }//GEN-LAST:event_BTN_GuardarMouseClicked
    
    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
    // 1. Validar que el campo no esté vacío
    String nombre = txtnombrecargo.getText().trim();
    if (nombre.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Ingrese el nombre del Cargo", "Campo requerido", JOptionPane.WARNING_MESSAGE);
      txtnombrecargo.requestFocus();

      return;
    }
    // 2. Confirmar si el usuario desea guardar
    int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro de facultad?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION) {
      try {
        // 3. Llamar al método para insertar
        conexionBD.insertarCargo(nombre);
        // 4. Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this, "Cargo registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        //5. Actualizar tabla y limpiar campos
        this.mostrarCargo();

      } catch (SQLException ex) {

        JOptionPane.showMessageDialog(this, "Error al registrar cargo:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
      }
    }                                   
       
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        // Validar que se haya seleccionado un registro
  String codStr = txtcodigocargo.getText().trim();
  String nuevoNombre = txtnombrecargo.getText().trim();
  if (codStr.isEmpty() || nuevoNombre.isEmpty()) {
   JOptionPane.showMessageDialog(this, "Seleccione una facultad y complete el nuevo nombre", "Campo requerido", JOptionPane.WARNING_MESSAGE);
   return;
  }
  int codigo = Integer.parseInt(codStr); 
  // Confirmación del usuario
  int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar esta facultad?", "Confirmación", JOptionPane.YES_NO_OPTION);
  if (respuesta == JOptionPane.YES_OPTION) {
   try {
    conexionBD.modificarCargo(codigo, nuevoNombre );
    JOptionPane.showMessageDialog(this, "Cargo modificado correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
    this.mostrarCargo();
    // Limpia los campos de texto
    txtcodigocargo.setText("");
    txtnombrecargo.setText("");
    BTN_Desactivar.setEnabled(false);
    BTN_Modificar.setEnabled(false);
   } catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Error al modificar facultad:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
  
   }
   }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_ModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_ModificarKeyReleased

    }//GEN-LAST:event_BTN_ModificarKeyReleased

    private void BTN_ModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_ModificarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ModificarKeyTyped

    private void BTN_DesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DesactivarActionPerformed
        // 1. Validar que se haya seleccionado una facultad
        String codStr = txtcodigocargo.getText().trim();
        if (codStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un Cargo en la tabla para desactivar.", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int codigo = Integer.parseInt(codStr); // Convertir a entero
        // 2. Confirmar la acción con el usuario
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea desactivar este Cargo?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                // 3. Llamar al método que ejecuta el procedure de desactivación
                conexionBD.desactivarCargo(codigo);
                // 4. Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Cargo desactivado correctamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
                // 5. Actualizar tabla y limpiar campos
                this.mostrarCargo();
                // Limpia los campos de texto
                txtcodigocargo.setText("");
                txtnombrecargo.setText("");
                BTN_Desactivar.setEnabled(false);
                BTN_Modificar.setEnabled(false);
            } catch (SQLException ex) {
                // 6. Captura cualquier error lanzado por el procedure (por SIGNAL)
                JOptionPane.showMessageDialog(this, "Error al desactivar Cargo:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BTN_DesactivarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarCargosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCargosKeyReleased
modeloTablaCargo.setRowCount(0);

String nombres = TXT_BuscarCargos.getText().trim();

try {

    ResultSet rs = conexionBD.buscarCargos(nombres);

    while (rs.next()) {

        Object[] fila = {
            rs.getInt("id_cargo"),
            rs.getString("nombre_cargo"),
            rs.getInt("estado_cargo")
        };

        modeloTablaCargo.addRow(fila);
    }

    rs.close();

} catch (SQLException e) {

    JOptionPane.showMessageDialog(
        this,
        "Error al mostrar cargos:\n" + e.getMessage(),
        "Error de consulta",
        JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_TXT_BuscarCargosKeyReleased

    private void TXT_BuscarCargosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCargosKeyTyped

    }//GEN-LAST:event_TXT_BuscarCargosKeyTyped

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Frm_Cargo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar1;
    private javax.swing.JButton BTN_Desactivar;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerCargos;
    private javax.swing.JTable JTABLE_Mant_Cargo;
    private javax.swing.JTextField TXT_BuscarCargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcodigocargo;
    private javax.swing.JTextField txtnombrecargo;
    // End of variables declaration//GEN-END:variables
public void mostrarCargo(){
        //ordenar ASC,DSC
        JTABLE_Mant_Cargo.setAutoCreateRowSorter(true);
        //limpiar la tabla antes de mostrar nuevos datos
       modeloTablaCargo.setRowCount(0);
       try {
        //llama al metodo que devuelva los datos de facultades
        ResultSet rs=conexionBD.listarCargos();
        //recorre cada fila del resultado y agregar la tabla
           while (rs.next()) {
               Object[] fila={
                 rs.getInt("codigo"),
                 rs.getString("cargo"),
                 rs.getString("estado")
               };
               modeloTablaCargo.addRow(fila);//permite que la tabla muestre los R
           }
    } catch (SQLException e) {
        //si hay errores
         JOptionPane.showMessageDialog(this, "error al mostrar Cargos:\n" + e.getMessage(),
                                                  "Error de consulta",JOptionPane.ERROR_MESSAGE);
    }
       
}

}
