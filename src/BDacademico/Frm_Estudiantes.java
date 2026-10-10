package BDacademico;

import java.sql.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Frm_Estudiantes extends javax.swing.JFrame {

    DefaultTableModel modeloTablaEstudiante = new DefaultTableModel();

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName());

    Conexion_alexander conexion_BD;

    public Frm_Estudiantes() {
        
 this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents();

        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);

        /* 1. Bloquear controles al iniciar */
        txtid_estudiante.setEnabled(false);
        habilitarCampos(false);

        /* 2. Instanciar conexión */
        conexion_BD = new Conexion_alexander();

        /* 3. Verificar conexión */
        if (conexion_BD.getConexion() == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se puede conectar con la base de datos.",
                    "Error de conexion",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        /* 4. Definir encabezados de la JTable */
        String titulos[] = {
            "ID",
            "DNI",
            "Nombres",
            "Apellidos",
            "Distrito",
            "Género",
            "F. Nacimiento",
            "Correo 1",
            "Correo 2",
            "Teléfono 1",
            "Teléfono 2",
            "Procedencia",
            "Condición",
            "Apoderado",
            "Estado"
        };

        modeloTablaEstudiante.setColumnIdentifiers(titulos);

        JTABLE_Mant_Estudiante.setModel(modeloTablaEstudiante);
        /* 5. Ajustar tamaño de las columnas */

JTABLE_Mant_Estudiante.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_OFF
);

JTABLE_Mant_Estudiante.getColumnModel().getColumn(0).setPreferredWidth(50);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(1).setPreferredWidth(90);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(2).setPreferredWidth(130);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(3).setPreferredWidth(150);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(4).setPreferredWidth(130);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(5).setPreferredWidth(100);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(6).setPreferredWidth(110);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(7).setPreferredWidth(180);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(8).setPreferredWidth(180);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(9).setPreferredWidth(100);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(10).setPreferredWidth(100);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(11).setPreferredWidth(150);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(12).setPreferredWidth(120);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(13).setPreferredWidth(180);
JTABLE_Mant_Estudiante.getColumnModel().getColumn(14).setPreferredWidth(80);

        /* 5. Cargar ComboBox */
        cargarCombos();

      
       
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblIdEstudiante = new javax.swing.JLabel();
        txtid_estudiante = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        lblDistrito = new javax.swing.JLabel();
        cmbDistrito = new javax.swing.JComboBox<>();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        lblFechaNac = new javax.swing.JLabel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblCorreo1 = new javax.swing.JLabel();
        txtcorreo1 = new javax.swing.JTextField();
        lblCorreo2 = new javax.swing.JLabel();
        txtcorreo2 = new javax.swing.JTextField();
        lblTelefono1 = new javax.swing.JLabel();
        txttelefono1 = new javax.swing.JTextField();
        lblTelefono2 = new javax.swing.JLabel();
        txttelefono2 = new javax.swing.JTextField();
        lblProcedencia = new javax.swing.JLabel();
        cmbProcedencia = new javax.swing.JComboBox<>();
        lblCondicion = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox<>();
        lblApoderado = new javax.swing.JLabel();
        cmbApoderado = new javax.swing.JComboBox<>();
        BTN_VerEstudiantes = new javax.swing.JButton();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarEstudiantes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Estudiante = new javax.swing.JTable();
        BTN_PDF = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        BTN_Cerrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE ESTUDIANTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 280, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdEstudiante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdEstudiante.setText("ID Estudiante");
        jPanel1.add(lblIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtid_estudiante.setEditable(false);
        jPanel1.add(txtid_estudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 15, 210, 25));

        lblDni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDni.setText("DNI");
        jPanel1.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, -1, -1));
        jPanel1.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 210, 25));

        lblNombres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombres.setText("Nombres");
        jPanel1.add(lblNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel1.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 85, 210, 25));

        lblApellidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblApellidos.setText("Apellidos");
        jPanel1.add(lblApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, -1, -1));
        jPanel1.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 210, 25));

        lblDistrito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDistrito.setText("Distrito");
        jPanel1.add(lblDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        jPanel1.add(cmbDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 210, 25));

        lblGenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGenero.setText("Género");
        jPanel1.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar --", "Masculino", "Femenino" }));
        jPanel1.add(cmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 210, 25));

        lblFechaNac.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaNac.setText("Fecha Nacimiento");
        jPanel1.add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));
        jPanel1.add(dcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 15, 210, 25));

        lblCorreo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCorreo1.setText("Correo Principal");
        jPanel1.add(lblCorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 55, -1, -1));
        jPanel1.add(txtcorreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 210, 25));

        lblCorreo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCorreo2.setText("Correo Secundario");
        jPanel1.add(lblCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));
        jPanel1.add(txtcorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 85, 210, 25));

        lblTelefono1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefono1.setText("Teléfono 1");
        jPanel1.add(lblTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 125, -1, -1));
        jPanel1.add(txttelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 210, 25));

        lblTelefono2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTelefono2.setText("Teléfono 2");
        jPanel1.add(lblTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));
        jPanel1.add(txttelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 155, 210, 25));

        lblProcedencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblProcedencia.setText("Procedencia");
        jPanel1.add(lblProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 195, -1, -1));
        jPanel1.add(cmbProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 210, 25));

        lblCondicion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCondicion.setText("Condición");
        jPanel1.add(lblCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));
        jPanel1.add(cmbCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 15, 220, 25));

        lblApoderado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblApoderado.setText("Apoderado");
        jPanel1.add(lblApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 55, -1, -1));
        jPanel1.add(cmbApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 220, 25));

        BTN_VerEstudiantes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerEstudiantes.setText("VER ESTUDIANTES");
        BTN_VerEstudiantes.addActionListener(this::BTN_VerEstudiantesActionPerformed);
        jPanel1.add(BTN_VerEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 220, 45));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 1080, 280));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(this::BTN_NuevoActionPerformed);
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 335, 180, 45));

        BTN_Guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addActionListener(this::BTN_GuardarActionPerformed);
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 335, 180, 45));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Modificar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(this::BTN_ModificarActionPerformed);
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 335, 180, 45));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre del Estudiante");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 8, -1, 30));

        TXT_BuscarEstudiantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarEstudiantesKeyReleased(evt);
            }
        });
        jPanel2.add(TXT_BuscarEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 300, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 8, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 1100, 45));

        JTABLE_Mant_Estudiante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Estudiante.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Estudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Nombres", "Apellidos", "Distrito", "Género", "F. Nacimiento", "Correo 1", "Correo 2", "Teléfono 1", "Teléfono 2", "Procedencia", "Condición", "Apoderado"
            }
        ));
        JTABLE_Mant_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Estudiante);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 1100, 280));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        BTN_PDF.setText("Exportar");
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 730, 120, 40));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 730, 120, 40));

        BTN_Cerrar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir.png"))); // NOI18N
        BTN_Cerrar1.setText("Cerrar");
        BTN_Cerrar1.addActionListener(this::BTN_Cerrar1ActionPerformed);
        getContentPane().add(BTN_Cerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 730, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_VerEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerEstudiantesActionPerformed
        this.mostrarEstudiantes();
        
    }//GEN-LAST:event_BTN_VerEstudiantesActionPerformed

    private void JTABLE_Mant_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_EstudianteMouseClicked
        this.habilitarCampos(true);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(true);

        int fila = JTABLE_Mant_Estudiante.getSelectedRow();
        if (fila >= 0) {
            txtid_estudiante.setText(getValueString(fila, 0));
            txtdni.setText(getValueString(fila, 1));
            txtnombres.setText(getValueString(fila, 2));
            txtapellidos.setText(getValueString(fila, 3));
            cmbDistrito.setSelectedItem(getValueString(fila, 4));
            cmbGenero.setSelectedItem(getValueString(fila, 5));
            
            // Si la fecha está en la tabla, puedes parsearla
            // dcFechaNacimiento.setDate(...);

            txtcorreo1.setText(getValueString(fila, 7));
            txtcorreo2.setText(getValueString(fila, 8));
            txttelefono1.setText(getValueString(fila, 9));
            txttelefono2.setText(getValueString(fila, 10));
            cmbProcedencia.setSelectedItem(getValueString(fila, 11));
            cmbCondicion.setSelectedItem(getValueString(fila, 12));
            cmbApoderado.setSelectedItem(getValueString(fila, 13));
            
            
            
        }
    }//GEN-LAST:event_JTABLE_Mant_EstudianteMouseClicked

    private String getValueString(int row, int col) {
        Object val = JTABLE_Mant_Estudiante.getValueAt(row, col);
        return val != null ? val.toString() : "";
    }

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        this.limpiarCampos();
        this.habilitarCampos(true);
        this.BTN_Modificar.setEnabled(false);
        this.txtdni.requestFocus();
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
       try {

    /* 1. Validar campos obligatorios */
    if (txtdni.getText().trim().isEmpty()
            || txtnombres.getText().trim().isEmpty()
            || txtapellidos.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Complete los campos obligatorios.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 2. Validar ComboBox */
    if (cmbDistrito.getSelectedIndex() == 0
            || cmbGenero.getSelectedIndex() == 0
            || cmbProcedencia.getSelectedIndex() == 0
            || cmbCondicion.getSelectedIndex() == 0
            || cmbApoderado.getSelectedIndex() == 0) {

        JOptionPane.showMessageDialog(
                this,
                "Seleccione una opción en todos los campos obligatorios.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 3. Validar DNI */
    if (txtdni.getText().trim().length() != 8) {

        JOptionPane.showMessageDialog(
                this,
                "El DNI debe tener 8 dígitos.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 4. Obtener nombres seleccionados */
    String nombreDistrito =
            cmbDistrito.getSelectedItem().toString();

    String nombreGenero =
            cmbGenero.getSelectedItem().toString();

    String descripcionProcedencia =
            cmbProcedencia.getSelectedItem().toString();

    String nombreCondicion =
            cmbCondicion.getSelectedItem().toString();

    String nombreApoderado =
            cmbApoderado.getSelectedItem().toString();


    /* 5. Obtener los ID de cada ComboBox */
    int idDistrito =
            conexion_BD.obtenerIdDistritoPorNombre_Estudiante(
                    nombreDistrito
            );

    int idGenero =
            conexion_BD.obtenerIdGeneroPorNombre_Estudiante(
                    nombreGenero
            );

    int idProcedencia =
            conexion_BD.obtenerIdProcedenciaPorDescripcion_Estudiante(
                    descripcionProcedencia
            );

    int idCondicion =
            conexion_BD.obtenerIdCondicionPorNombre_Estudiante(
                    nombreCondicion
            );

    int idApoderado =
            conexion_BD.obtenerIdApoderadoPorNombre_Estudiante(
                    nombreApoderado
            );


    /* 6. Confirmar registro */
    int resp = JOptionPane.showConfirmDialog(
            this,
            "¿Desea registrar el estudiante?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
    );


    if (resp == JOptionPane.YES_OPTION) {

        /* 7. Registrar estudiante */
        conexion_BD.insertarEstudiante(
                idDistrito,
                txtdni.getText().trim(),
                txtnombres.getText().trim(),
                txtapellidos.getText().trim(),
                idGenero,
                txtcorreo1.getText().trim(),
                txtcorreo2.getText().trim(),
                txttelefono1.getText().trim(),
                txttelefono2.getText().trim(),
                idProcedencia,
                idCondicion,
                idApoderado
        );


        /* 8. Actualizar tabla */
        this.mostrarEstudiantes();


        /* 9. Limpiar campos */
        this.limpiarCampos();


        /* 10. Deshabilitar campos */
        this.habilitarCampos(false);


        /* 11. Mensaje de confirmación */
        JOptionPane.showMessageDialog(
                this,
                "Estudiante registrado correctamente.",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

} catch (SQLException e) {

    JOptionPane.showMessageDialog(
            this,
            "Error al registrar el estudiante:\n"
            + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
       try {

    /* 1. Validar que se haya seleccionado un estudiante */
    if (txtid_estudiante.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Seleccione un estudiante para modificar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 2. Validar campos obligatorios */
    if (txtdni.getText().trim().isEmpty()
            || txtnombres.getText().trim().isEmpty()
            || txtapellidos.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Complete los campos obligatorios.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 3. Validar ComboBox */
    if (cmbDistrito.getSelectedIndex() == 0
            || cmbGenero.getSelectedIndex() == 0
            || cmbProcedencia.getSelectedIndex() == 0
            || cmbCondicion.getSelectedIndex() == 0
            || cmbApoderado.getSelectedIndex() == 0) {

        JOptionPane.showMessageDialog(
                this,
                "Seleccione una opción en todos los campos obligatorios.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 4. Validar DNI */
    if (txtdni.getText().trim().length() != 8) {

        JOptionPane.showMessageDialog(
                this,
                "El DNI debe tener 8 dígitos.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }


    /* 5. Obtener ID del estudiante */
    int idEstudiante =
            Integer.parseInt(txtid_estudiante.getText().trim());


    /* 6. Obtener nombres seleccionados */
    String nombreDistrito =
            cmbDistrito.getSelectedItem().toString();

    String nombreGenero =
            cmbGenero.getSelectedItem().toString();

    String descripcionProcedencia =
            cmbProcedencia.getSelectedItem().toString();

    String nombreCondicion =
            cmbCondicion.getSelectedItem().toString();

    String nombreApoderado =
            cmbApoderado.getSelectedItem().toString();


    /* 7. Obtener los ID de cada ComboBox */
    int idDistrito =
            conexion_BD.obtenerIdDistritoPorNombre_Estudiante(
                    nombreDistrito
            );

    int idGenero =
            conexion_BD.obtenerIdGeneroPorNombre_Estudiante(
                    nombreGenero
            );

    int idProcedencia =
            conexion_BD.obtenerIdProcedenciaPorDescripcion_Estudiante(
                    descripcionProcedencia
            );

    int idCondicion =
            conexion_BD.obtenerIdCondicionPorNombre_Estudiante(
                    nombreCondicion
            );

    int idApoderado =
            conexion_BD.obtenerIdApoderadoPorNombre_Estudiante(
                    nombreApoderado
            );


    /* 8. Confirmar modificación */
    int resp = JOptionPane.showConfirmDialog(
            this,
            "¿Desea modificar el registro?",
            "Confirmar",
            JOptionPane.YES_NO_OPTION
    );


    if (resp == JOptionPane.YES_OPTION) {

        /* 9. Modificar estudiante */
        conexion_BD.modificarEstudiante(
                idEstudiante,
                idDistrito,
                txtdni.getText().trim(),
                txtnombres.getText().trim(),
                txtapellidos.getText().trim(),
                idGenero,
                txtcorreo1.getText().trim(),
                txtcorreo2.getText().trim(),
                txttelefono1.getText().trim(),
                txttelefono2.getText().trim(),
                idProcedencia,
                idCondicion,
                idApoderado
        );


        /* 10. Actualizar tabla */
        this.mostrarEstudiantes();


        /* 11. Limpiar campos */
        this.limpiarCampos();


        /* 12. Deshabilitar campos */
        this.habilitarCampos(false);


        /* 13. Mensaje de confirmación */
        JOptionPane.showMessageDialog(
                this,
                "Estudiante modificado correctamente.",
                "Modificación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

} catch (NumberFormatException e) {

    JOptionPane.showMessageDialog(
            this,
            "El ID del estudiante no es válido.",
            "Error",
            JOptionPane.ERROR_MESSAGE
    );

} catch (SQLException e) {

    JOptionPane.showMessageDialog(
            this,
            "Error al modificar el estudiante:\n"
            + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void TXT_BuscarEstudiantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarEstudiantesKeyReleased
        // Lógica de búsqueda
    }//GEN-LAST:event_TXT_BuscarEstudiantesKeyReleased

    private void BTN_Cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Cerrar1ActionPerformed
       int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?",
                "Confirmar salida",JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                conexion_BD.cerrarConexion();
            } catch (Exception e) {
            }
            dispose(); // o this.dispose() si estás dentro del formulario
        }
    }//GEN-LAST:event_BTN_Cerrar1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Frm_Estudiantes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar1;
    private javax.swing.JButton BTN_Desactivar;
    private javax.swing.JButton BTN_Desactivar1;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerEstudiantes;
    private javax.swing.JTable JTABLE_Mant_Estudiante;
    private javax.swing.JTextField TXT_BuscarEstudiantes;
    private javax.swing.JComboBox<String> cmbApoderado;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<String> cmbDistrito;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbProcedencia;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApoderado;
    private javax.swing.JLabel lblCondicion;
    private javax.swing.JLabel lblCorreo1;
    private javax.swing.JLabel lblCorreo2;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIdEstudiante;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblProcedencia;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcorreo1;
    private javax.swing.JTextField txtcorreo2;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtid_estudiante;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txttelefono1;
    private javax.swing.JTextField txttelefono2;
    // End of variables declaration//GEN-END:variables

   /* Mostrar estudiantes */
public void mostrarEstudiantes() {

    modeloTablaEstudiante.setRowCount(0);

    try {

        ResultSet rs = conexion_BD.listarEstudiantesActivos();

        while (rs.next()) {

            /* 1. Obtener IDs */
            int idDistrito = rs.getInt("id_distrito");
            int idGenero = rs.getInt("id_genero");
            int idProcedencia = rs.getInt("id_procedencia");
            int idCondicion = rs.getInt("id_condicion");
            int idApoderado = rs.getInt("id_apoderado");


            /* 2. Obtener nombres correspondientes */
            String distrito =
                    conexion_BD.obtenerNombreDistritoPorId_Estudiante(
                            idDistrito
                    );

            String genero =
                    conexion_BD.obtenerNombreGeneroPorId_Estudiante(
                            idGenero
                    );

            String procedencia =
                    conexion_BD.obtenerDescripcionProcedenciaPorId_Estudiante(
                            idProcedencia
                    );

            String condicion =
                    conexion_BD.obtenerNombreCondicionPorId_Estudiante(
                            idCondicion
                    );

            String apoderado =
                    conexion_BD.obtenerNombreApoderadoPorId_Estudiante(
                            idApoderado
                    );


            /* 3. Crear fila */
            Object[] fila = {

                rs.getInt("id_estudiante"),
                rs.getString("dni"),
                rs.getString("nombres"),
                rs.getString("apellidos"),

                distrito,
                genero,

                rs.getDate("fecha_nacimiento"),

                rs.getString("correo1"),
                rs.getString("correo2"),
                rs.getString("telefono1"),
                rs.getString("telefono2"),

                procedencia,
                condicion,
                apoderado,

                rs.getBoolean("estado")
                        ? "Activo"
                        : "Inactivo"
            };


            /* 4. Agregar fila */
            modeloTablaEstudiante.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al mostrar estudiantes:\n"
                + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
    /* 1. Habilitar o deshabilitar campos */
private void habilitarCampos(boolean estado) {

    txtdni.setEnabled(estado);
    txtnombres.setEnabled(estado);
    txtapellidos.setEnabled(estado);
    cmbDistrito.setEnabled(estado);
    cmbGenero.setEnabled(estado);
    dcFechaNacimiento.setEnabled(estado);
    txtcorreo1.setEnabled(estado);
    txtcorreo2.setEnabled(estado);
    txttelefono1.setEnabled(estado);
    txttelefono2.setEnabled(estado);
    cmbProcedencia.setEnabled(estado);
    cmbCondicion.setEnabled(estado);
    cmbApoderado.setEnabled(estado);

    BTN_Guardar.setEnabled(estado);
    BTN_Modificar.setEnabled(estado);
}
    /* 2. Limpiar campos */
private void limpiarCampos() {

    txtid_estudiante.setText("");
    txtdni.setText("");
    txtnombres.setText("");
    txtapellidos.setText("");

    if (cmbDistrito.getItemCount() > 0) {
        cmbDistrito.setSelectedIndex(0);
    }

    if (cmbGenero.getItemCount() > 0) {
        cmbGenero.setSelectedIndex(0);
    }

    dcFechaNacimiento.setDate(null);

    txtcorreo1.setText("");
    txtcorreo2.setText("");
    txttelefono1.setText("");
    txttelefono2.setText("");

    if (cmbProcedencia.getItemCount() > 0) {
        cmbProcedencia.setSelectedIndex(0);
    }

    if (cmbCondicion.getItemCount() > 0) {
        cmbCondicion.setSelectedIndex(0);
    }

    if (cmbApoderado.getItemCount() > 0) {
        cmbApoderado.setSelectedIndex(0);
    }
}
/* 5. Cargar ComboBox */
private void cargarCombos() {
    cargarDistritos();
    cargarGeneros();
    cargarProcedencias();
    cargarCondiciones();
    cargarApoderados();
}



/* 2. Cargar distritos */
private void cargarDistritos() {

    try {

        ResultSet rs =
                conexion_BD.combobox_ListarDistritosEstudiante();

        cmbDistrito.removeAllItems();

        // Primera opción
        cmbDistrito.addItem("<<seleccionar>>");

        while (rs.next()) {

            cmbDistrito.addItem(
                    rs.getString("nombre_distrito")
            );
        }

        cmbDistrito.setSelectedIndex(0);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al cargar distritos:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}


/* 3. Cargar géneros */
private void cargarGeneros() {

    try {

        ResultSet rs =
                conexion_BD.combobox_ListarGenerosEstudiante();

        cmbGenero.removeAllItems();

        // Primera opción
        cmbGenero.addItem("<<seleccionar>>");

        while (rs.next()) {

            cmbGenero.addItem(
                    rs.getString("nombre_genero")
            );
        }

        cmbGenero.setSelectedIndex(0);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al cargar géneros:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}


/* 4. Cargar procedencias */
private void cargarProcedencias() {

    try {

        ResultSet rs =
                conexion_BD.combobox_ListarProcedenciasEstudiante();

        cmbProcedencia.removeAllItems();

        // Primera opción
        cmbProcedencia.addItem("<<seleccionar>>");

        while (rs.next()) {

            cmbProcedencia.addItem(
                    rs.getString("descripcion")
            );
        }

        cmbProcedencia.setSelectedIndex(0);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al cargar procedencias:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}


/* 5. Cargar condiciones */
private void cargarCondiciones() {

    try {

        ResultSet rs =
                conexion_BD.combobox_ListarCondicionesEstudiante();

        cmbCondicion.removeAllItems();

        // Primera opción
        cmbCondicion.addItem("<<seleccionar>>");

        while (rs.next()) {

            cmbCondicion.addItem(
                    rs.getString("nombre_condicion")
            );
        }

        cmbCondicion.setSelectedIndex(0);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al cargar condiciones:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}


/* 6. Cargar apoderados */
private void cargarApoderados() {

    try {

        ResultSet rs =
                conexion_BD.combobox_ListarApoderadosEstudiante();

        cmbApoderado.removeAllItems();

        // Primera opción
        cmbApoderado.addItem("<<seleccionar>>");

        while (rs.next()) {

            cmbApoderado.addItem(
                    rs.getString("apoderado")
            );
        }

        cmbApoderado.setSelectedIndex(0);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al cargar apoderados:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    
}
}
