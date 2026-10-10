package BDacademico;
import java.sql.*; //libreria para conexion con mysql
import javax.swing.table.DefaultTableModel; //para trabajar con jtable
import javax.swing.JOptionPane;

public class Frm_Carrera extends javax.swing.JFrame {
    DefaultTableModel modeloTablaCarrera = new DefaultTableModel();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frm_Carrera.class.getName());
Conexion_alexander conexion_BD;
    /**
     * Creates new form Frm_Carrera
     */
    public Frm_Carrera() {
         this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents();
          this.setLocationRelativeTo(null);
          this.setLocationRelativeTo(null);
        txtcodigocarrera.setEnabled(false);
        txtnombrecarrera.setEnabled(false);
        txtdescripcion.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
         //crear la conexion al iniciar el formulario
          conexion_BD = new Conexion_alexander();
          //verificar si la conexion fue exitosa
          if (conexion_BD.getConexion() == null){
              JOptionPane.showMessageDialog(this, "no se puede conectar con la base de datos.",
                                                  "Error de conexion",JOptionPane.ERROR_MESSAGE);
              return;//evita continuar si no hay conexion
          }
            //definir encabezados de la tabla
          String titulos[] = {"Código Carrera", "Nombre Carrera", "Descipcion"};
          //asignar titulos al modelo
          modeloTablaCarrera.setColumnIdentifiers(titulos);
          //Establecer el modelo de la Jtable
          JTABLE_Mant_Carrera.setModel(modeloTablaCarrera);
          //desahabilitar campo de codigo
          txtnombrecarrera.setEnabled(false);
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigocarrera = new javax.swing.JTextField();
        txtnombrecarrera = new javax.swing.JTextField();
        BTN_VerCargos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Carrera = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarCarreras = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar1 = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE CARRERA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Carrera");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre Carrera");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtcodigocarrera.setEditable(false);
        txtcodigocarrera.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigocarrera.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigocarrera.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigocarrera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigocarrera.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigocarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtnombrecarrera.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombrecarrera.setForeground(new java.awt.Color(0, 0, 204));
        txtnombrecarrera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrecarrera.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombrecarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrecarreraKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombrecarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        BTN_VerCargos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerCargos.setText("VER CARRERA");
        BTN_VerCargos.addActionListener(this::BTN_VerCargosActionPerformed);
        jPanel1.add(BTN_VerCargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre Carrera");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Descripcion");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txtdescripcion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtdescripcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 150));

        JTABLE_Mant_Carrera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Carrera.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Carrera.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Carrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_CarreraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Carrera);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 810, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(this::BTN_NuevoActionPerformed);
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 190, 50));

        BTN_Guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarMouseClicked(evt);
            }
        });
        BTN_Guardar.addActionListener(this::BTN_GuardarActionPerformed);
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 190, 50));

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
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 200, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(this::BTN_EXCELActionPerformed);
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de el Cargo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarCarreras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarCarrerasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarCarrerasKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 810, 50));

        BTN_Cerrar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir.png"))); // NOI18N
        BTN_Cerrar1.setText("Cerrar");
        BTN_Cerrar1.addActionListener(this::BTN_Cerrar1ActionPerformed);
        getContentPane().add(BTN_Cerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 130, 40));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(this::BTN_PDFActionPerformed);
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombrecarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrecarreraKeyTyped

    }//GEN-LAST:event_txtnombrecarreraKeyTyped

    private void BTN_VerCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerCargosActionPerformed

        this.mostrarCarreras();
        txtnombrecarrera.setEnabled(false);
        txtdescripcion.setEnabled(false);
    }//GEN-LAST:event_BTN_VerCargosActionPerformed

    private void JTABLE_Mant_CarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_CarreraMouseClicked
        txtnombrecarrera.setEnabled(true);
        txtdescripcion.setEnabled(true);
        /*Obtener la fila seleccionada*/
        int filaseleccionada=JTABLE_Mant_Carrera.getSelectedRow();
        if(filaseleccionada>=0){
            /*llenar los campos de texto con los datos de la fila*/
            String codigo=JTABLE_Mant_Carrera.getValueAt(filaseleccionada, 0).toString();
            String nombre=JTABLE_Mant_Carrera.getValueAt(filaseleccionada, 1).toString();
            txtcodigocarrera.setText(codigo);

            txtnombrecarrera.setText(nombre);
            /*Habilitar los botones relacionados*/

            BTN_Modificar.setEnabled(true);
            /*Opcional: deshabilitar boton guardar */
            BTN_Guardar.setEnabled(false);
            // TODO add your handling code here:

        }

    }//GEN-LAST:event_JTABLE_Mant_CarreraMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        // Limpia los campos de texto
        txtcodigocarrera.setText("");     // Limpia el código (autogenerado por ver)
        txtnombrecarrera.setText("");     // Limpia el nombre de la facultad
        txtdescripcion.setText("");
        // Da el foco al campo de nombre para que el usuario empiece a escribir
        txtnombrecarrera.requestFocus();
        txtnombrecarrera.setEnabled(true);
        txtdescripcion.setEnabled(true);
        // Habilita el botón Guardar (en caso esté deshabilitado)
        BTN_Guardar.setEnabled(true);
        BTN_Modificar.setEnabled(false);
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked

    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
       // 1. Obtener los datos de los campos
    String nombre = txtnombrecarrera.getText().trim();
    String descripcion = txtdescripcion.getText().trim();

    // 2. Validar que el nombre no esté vacío
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Ingrese el nombre de la carrera",
            "Campo requerido",
            JOptionPane.WARNING_MESSAGE
        );

        txtnombrecarrera.requestFocus();
        return;
    }

    // 3. Validar que la descripción no esté vacía
    if (descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Ingrese la descripción de la carrera",
            "Campo requerido",
            JOptionPane.WARNING_MESSAGE
        );

        txtdescripcion.requestFocus();
        return;
    }

    // 4. Confirmar si el usuario desea guardar
    int respuesta = JOptionPane.showConfirmDialog(
        this,
        "¿Desea guardar el registro de carrera?",
        "Confirmación",
        JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {

        try {

            // 5. Llamar al método para insertar
            conexion_BD.insertarCarrera(nombre, descripcion);

            // 6. Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(
                this,
                "Carrera registrada correctamente",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );

            // 7. Actualizar la tabla
            this.mostrarCarreras();

            // 8. Limpiar los campos
            txtnombrecarrera.setText("");
            txtdescripcion.setText("");

            // 9. Regresar el cursor al nombre
            txtnombrecarrera.requestFocus();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Error al registrar carrera:\n" + ex.getMessage(),
                "Error de base de datos",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
         // Validar que se haya seleccionado un registro
    String codStr = txtcodigocarrera.getText().trim();
    String nuevoNombre = txtnombrecarrera.getText().trim();
    String nuevaDescripcion = txtdescripcion.getText().trim();

    // Validar campos
    if (codStr.isEmpty() || nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Seleccione una carrera y complete el nombre y la descripción",
            "Campo requerido",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Convertir código a entero
    int codigo;

    try {
        codigo = Integer.parseInt(codStr);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(
            this,
            "El código de la carrera debe ser un número válido",
            "Código inválido",
            JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Confirmación del usuario
    int respuesta = JOptionPane.showConfirmDialog(
        this,
        "¿Desea modificar esta carrera?",
        "Confirmación",
        JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {

        try {

            // Modificar nombre y descripción
            conexion_BD.modificarCarrera(
                codigo,
                nuevoNombre,
                nuevaDescripcion
            );

            // Mensaje de éxito
            JOptionPane.showMessageDialog(
                this,
                "Carrera modificada correctamente",
                "Modificación exitosa",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Actualizar la tabla
            this.mostrarCarreras();

            // Limpiar los campos
            txtcodigocarrera.setText("");
            txtnombrecarrera.setText("");
            txtdescripcion.setText("");

            // Deshabilitar botones
            
            BTN_Modificar.setEnabled(false);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Error al modificar carrera:\n" + ex.getMessage(),
                "Error de base de datos",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_ModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_ModificarKeyReleased

    }//GEN-LAST:event_BTN_ModificarKeyReleased

    private void BTN_ModificarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTN_ModificarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ModificarKeyTyped

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarCarrerasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCarrerasKeyReleased
       modeloTablaCarrera.setRowCount(0);

String nombres = TXT_BuscarCarreras.getText().trim();

try {

    ResultSet rs = conexion_BD.buscarCarrera(nombres);

    while (rs.next()) {

        Object[] fila = {
            rs.getInt("id_carrera"),
            rs.getString("nombre_carrera"),
            rs.getString("descripcion")
        };

        modeloTablaCarrera.addRow(fila);
    }

    rs.close();

} catch (SQLException e) {

    JOptionPane.showMessageDialog(
        this,
        "Error al mostrar carreras:\n" + e.getMessage(),
        "Error de consulta",
        JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_TXT_BuscarCarrerasKeyReleased

    private void TXT_BuscarCarrerasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCarrerasKeyTyped

    }//GEN-LAST:event_TXT_BuscarCarrerasKeyTyped

    private void BTN_Cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Cerrar1ActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?", "Confirmar salida",
            JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Cerrar conexión si tienes un método cerrarConexion()
                conexion_BD.cerrarConexion();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());

            }
            // Cierra el formulario actual
            dispose(); // o this.dispose() si estás dentro del formulario
        }

    }//GEN-LAST:event_BTN_Cerrar1ActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionKeyTyped

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
        java.awt.EventQueue.invokeLater(() -> new Frm_Carrera().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar1;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerCargos;
    private javax.swing.JTable JTABLE_Mant_Carrera;
    private javax.swing.JTextField TXT_BuscarCarreras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcodigocarrera;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtnombrecarrera;
    // End of variables declaration//GEN-END:variables
public void mostrarCarreras(){
        //ordenar ASC,DSC
        JTABLE_Mant_Carrera.setAutoCreateRowSorter(true);
        //limpiar la tabla antes de mostrar nuevos datos
       modeloTablaCarrera.setRowCount(0);
       try {
        //llama al metodo que devuelva los datos de facultades
        ResultSet rs=conexion_BD.listarCarreras();
        //recorre cada fila del resultado y agregar la tabla
           while (rs.next()) {
               Object[] fila={
                 rs.getInt("codigo"),
                 rs.getString("carrera"),
                 rs.getString("descripcion")
               };
               modeloTablaCarrera.addRow(fila);//permite que la tabla muestre los R
           }
    } catch (SQLException e) {
        //si hay errores
         JOptionPane.showMessageDialog(this, "error al mostrar Cargos:\n" + e.getMessage(),
                                                  "Error de consulta",JOptionPane.ERROR_MESSAGE);
    }
       
}

}


