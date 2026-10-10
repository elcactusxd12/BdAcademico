package BDacademico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_Matricula extends javax.swing.JFrame {

    DefaultTableModel modeloTablaMatricula = new DefaultTableModel();

    private static final java.util.logging.Logger logger
            = java.util.logging.Logger.getLogger(Frm_Matricula.class.getName());

    Conexion_miguel conexion_BD;

    public Frm_Matricula() {
        this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents();

        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        
        conexion_BD = new Conexion_miguel();

        try {
            conexion_BD.getConexion();

            String[] titulos = {
                "ID",
                "Estudiante",
                "Carrera",
                "Turno",
                "Semestre",
                "Ciclo",
                "Modalidad",
                "Fecha",
                "N° Operación",
                "Estado Pago",
                "Detalles"
            };

            modeloTablaMatricula = new DefaultTableModel(titulos, 0) {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            JTABLE_Matricula.setModel(modeloTablaMatricula);
            this.ajustarColumnasTabla();

            // Mantener los campos desactivados al iniciar.
            habilitarCampos(false);

            txtIdMatricula.setEnabled(false);

            BTN_Guardar.setEnabled(false);
            BTN_Modificar.setEnabled(false);

            // Cargar las opciones de los combos.
            cargarTodosLosCombos();

            // La fecha se ingresa manualmente.
            txtFechaMatricula.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al iniciar el formulario: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIdMatricula = new javax.swing.JTextField();
        cmbEstudiante = new javax.swing.JComboBox<>();
        cmbCarrera = new javax.swing.JComboBox<>();
        cmbTurno = new javax.swing.JComboBox<>();
        cmbSemestre = new javax.swing.JComboBox<>();
        cmbCiclo = new javax.swing.JComboBox<>();
        cmbModalidad = new javax.swing.JComboBox<>();
        txtFechaMatricula = new javax.swing.JTextField();
        txtEstadoPago = new javax.swing.JTextField();
        BTN_VerMatriculas = new javax.swing.JButton();
        txtDetalles = new javax.swing.JTextField();
        txtNumOperacion2 = new javax.swing.JTextField();
        jCheckEstudiante = new javax.swing.JCheckBox();
        jCheckCarrera = new javax.swing.JCheckBox();
        jCheckTurno = new javax.swing.JCheckBox();
        jCheckModalidad = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Matricula = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        TXT_BuscarMatricula = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FORMULARIO DE MATRíCULA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID Matrícula:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Estudiante:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 45, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Carrera:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Turno:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 105, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Semestre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ciclo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 165, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Modalidad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 195, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha Matrícula:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("N° Operación:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Estado Pago:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Detalles:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        txtIdMatricula.setEditable(false);
        jPanel1.add(txtIdMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 280, 25));

        jPanel1.add(cmbEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 280, 25));

        jPanel1.add(cmbCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 280, 25));

        jPanel1.add(cmbTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 280, 25));

        jPanel1.add(cmbSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 280, 25));

        jPanel1.add(cmbCiclo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 280, 25));

        jPanel1.add(cmbModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 280, 25));

        txtFechaMatricula.setEditable(false);
        jPanel1.add(txtFechaMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 330, 25));
        jPanel1.add(txtEstadoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 330, 25));

        BTN_VerMatriculas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerMatriculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/information.png"))); // NOI18N
        BTN_VerMatriculas.setText("VER MATRíCULAS");
        BTN_VerMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerMatriculasActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 280, 60));
        jPanel1.add(txtDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 330, 25));
        jPanel1.add(txtNumOperacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 330, 25));

        jCheckEstudiante.setText("ir al FrmEstudiantes");
        jCheckEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, -1, -1));

        jCheckCarrera.setText("ir al FrmCarrera");
        jCheckCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCarreraActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        jCheckTurno.setText("Ir al FrmTurno");
        jCheckTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckTurnoActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        jCheckModalidad.setText("ir al FrmModalidad");
        jCheckModalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckModalidadActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1110, 230));

        JTABLE_Matricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estudiante", "Carrera", "Turno", "Semestre", "Ciclo", "Modalidad", "Fecha", "N° Op", "Estado", "Detalles"
            }
        ));
        JTABLE_Matricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_MatriculaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Matricula);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 1140, 230));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 180, 60));

        BTN_Guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 180, 60));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Modificar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 180, 60));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Buscar Matrícula:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        TXT_BuscarMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarMatriculaKeyReleased(evt);
            }
        });
        jPanel2.add(TXT_BuscarMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 480, 25));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        jLabel14.setText("BUSCAR");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1140, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 670, 140, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_VerMatriculasActionPerformed(java.awt.event.ActionEvent evt) {
        this.mostrarMatriculas();
        this.limpiarFormulario();
        this.habilitarCampos(false);

        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
    }

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarFormulario();
        habilitarCampos(true);

        txtIdMatricula.setEnabled(false);
        txtFechaMatricula.setEnabled(true);

        BTN_Guardar.setEnabled(true);
        BTN_Modificar.setEnabled(false);

        cmbEstudiante.requestFocus();
    }

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Obtener los valores del formulario.
            String estudianteNombre
                    = cmbEstudiante.getSelectedItem() == null
                    ? "" : cmbEstudiante.getSelectedItem().toString();

            String carreraNombre
                    = cmbCarrera.getSelectedItem() == null
                    ? "" : cmbCarrera.getSelectedItem().toString();

            String turnoNombre
                    = cmbTurno.getSelectedItem() == null
                    ? "" : cmbTurno.getSelectedItem().toString();

            String semestreNombre
                    = cmbSemestre.getSelectedItem() == null
                    ? "" : cmbSemestre.getSelectedItem().toString();

            String cicloNombre
                    = cmbCiclo.getSelectedItem() == null
                    ? "" : cmbCiclo.getSelectedItem().toString();

            String modalidadNombre
                    = cmbModalidad.getSelectedItem() == null
                    ? "" : cmbModalidad.getSelectedItem().toString();

            String fecha = txtFechaMatricula.getText().trim();
            String numeroOperacion = txtNumOperacion2.getText().trim();
            String estadoTexto = txtEstadoPago.getText().trim();
            String detalles = txtDetalles.getText().trim();

            // Validar los campos obligatorios.
            if (estudianteNombre.isEmpty()
                    || carreraNombre.isEmpty()
                    || turnoNombre.isEmpty()
                    || semestreNombre.isEmpty()
                    || cicloNombre.isEmpty()
                    || modalidadNombre.isEmpty()
                    || fecha.isEmpty()
                    || estadoTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete los campos obligatorios.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Validar que la fecha tenga formato AAAA-MM-DD.
            if (!validarFecha(fecha)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese la fecha en formato AAAA-MM-DD.\n"
                        + "Ejemplo: 2026-10-09",
                        "Fecha incorrecta",
                        JOptionPane.WARNING_MESSAGE
                );
                txtFechaMatricula.requestFocus();
                return;
            }

            // El estado de pago debe ser 0 o 1.
            int estadoPago;

            try {
                estadoPago = Integer.parseInt(estadoTexto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "El estado de pago debe ser 0 o 1.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                txtEstadoPago.requestFocus();
                return;
            }

            if (estadoPago != 0 && estadoPago != 1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Use 0 para pendiente o 1 para pagado.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Obtener los ID mediante los métodos ya creados.
            int estudiante = conexion_BD
                    .obtenerIdEstudiantePorNombre_Matricula(estudianteNombre);

            int carrera = conexion_BD
                    .obtenerIdCarreraPorNombre_Matricula(carreraNombre);

            int turno = conexion_BD
                    .obtenerIdTurnoPorNombre_Matricula(turnoNombre);

            int semestre = conexion_BD
                    .obtenerIdSemestrePorNombre_Matricula(semestreNombre);

            int ciclo = conexion_BD
                    .obtenerIdCicloPorNombre_Matricula(cicloNombre);

            int modalidad = conexion_BD
                    .obtenerIdModalidadPorNombre_Matricula(modalidadNombre);

            if (estudiante <= 0 || carrera <= 0 || turno <= 0
                    || semestre <= 0 || ciclo <= 0 || modalidad <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se pudieron obtener todos los ID seleccionados.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            /*
             * IMPORTANTE:
             * El método insertarMatricula que tenemos actualmente
             * no recibe la fecha. Por eso, aunque la validamos aquí,
             * todavía no puede guardar la fecha escrita en el formulario.
             */
            java.sql.Date fechaMatricula
                    = java.sql.Date.valueOf(txtFechaMatricula.getText().trim());

            conexion_BD.insertarMatricula(
                    estudiante,
                    carrera,
                    turno,
                    semestre,
                    ciclo,
                    modalidad,
                    fechaMatricula,
                    numeroOperacion,
                    estadoPago,
                    detalles
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Matrícula registrada.\n"
                    + "Recuerde que la fecha escrita aún no se guarda "
                    + "con el procedimiento actual.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarFormulario();
            habilitarCampos(false);

            BTN_Guardar.setEnabled(false);
            BTN_Modificar.setEnabled(false);

            mostrarMatriculas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al registrar la matrícula: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (txtIdMatricula.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione una matrícula de la tabla.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int id = Integer.parseInt(txtIdMatricula.getText().trim());

            String estudianteNombre = cmbEstudiante.getSelectedItem() == null
                    ? "" : cmbEstudiante.getSelectedItem().toString();

            String carreraNombre = cmbCarrera.getSelectedItem() == null
                    ? "" : cmbCarrera.getSelectedItem().toString();

            String turnoNombre = cmbTurno.getSelectedItem() == null
                    ? "" : cmbTurno.getSelectedItem().toString();

            String semestreNombre = cmbSemestre.getSelectedItem() == null
                    ? "" : cmbSemestre.getSelectedItem().toString();

            String cicloNombre = cmbCiclo.getSelectedItem() == null
                    ? "" : cmbCiclo.getSelectedItem().toString();

            String modalidadNombre = cmbModalidad.getSelectedItem() == null
                    ? "" : cmbModalidad.getSelectedItem().toString();

            String fecha = txtFechaMatricula.getText().trim();
            String numeroOperacion = txtNumOperacion2.getText().trim();
            String estadoTexto = txtEstadoPago.getText().trim();
            String detalles = txtDetalles.getText().trim();

            if (estudianteNombre.isEmpty()
                    || carreraNombre.isEmpty()
                    || turnoNombre.isEmpty()
                    || semestreNombre.isEmpty()
                    || cicloNombre.isEmpty()
                    || modalidadNombre.isEmpty()
                    || fecha.isEmpty()
                    || estadoTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Complete los campos obligatorios.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (!validarFecha(fecha)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese la fecha en formato AAAA-MM-DD.\n"
                        + "Ejemplo: 2026-10-09",
                        "Fecha incorrecta",
                        JOptionPane.WARNING_MESSAGE
                );
                txtFechaMatricula.requestFocus();
                return;
            }

            int estadoPago;

            try {
                estadoPago = Integer.parseInt(estadoTexto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "El estado de pago debe ser 0 o 1.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            if (estadoPago != 0 && estadoPago != 1) {
                JOptionPane.showMessageDialog(
                        this,
                        "Use 0 para pendiente o 1 para pagado.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int estudiante = conexion_BD
                    .obtenerIdEstudiantePorNombre_Matricula(estudianteNombre);

            int carrera = conexion_BD
                    .obtenerIdCarreraPorNombre_Matricula(carreraNombre);

            int turno = conexion_BD
                    .obtenerIdTurnoPorNombre_Matricula(turnoNombre);

            int semestre = conexion_BD
                    .obtenerIdSemestrePorNombre_Matricula(semestreNombre);

            int ciclo = conexion_BD
                    .obtenerIdCicloPorNombre_Matricula(cicloNombre);

            int modalidad = conexion_BD
                    .obtenerIdModalidadPorNombre_Matricula(modalidadNombre);

            if (estudiante <= 0 || carrera <= 0 || turno <= 0
                    || semestre <= 0 || ciclo <= 0 || modalidad <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se pudieron obtener todos los ID seleccionados.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            java.sql.Date fechaMatricula
                    = java.sql.Date.valueOf(txtFechaMatricula.getText().trim());

            conexion_BD.modificarMatricula(
                    id,
                    estudiante,
                    carrera,
                    turno,
                    semestre,
                    ciclo,
                    modalidad,
                    fechaMatricula,
                    numeroOperacion,
                    estadoPago,
                    detalles
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Matrícula modificada.\n"
                    + "Recuerde que la fecha escrita aún no se guarda "
                    + "con el procedimiento actual.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarFormulario();
            habilitarCampos(false);

            BTN_Guardar.setEnabled(false);
            BTN_Modificar.setEnabled(false);

            mostrarMatriculas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al modificar la matrícula: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void JTABLE_MatriculaMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = JTABLE_Matricula.getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {
            txtIdMatricula.setText(
                    JTABLE_Matricula.getValueAt(fila, 0).toString()
            );

            cmbEstudiante.setSelectedItem(
                    JTABLE_Matricula.getValueAt(fila, 1).toString()
            );

            cmbCarrera.setSelectedItem(
                    JTABLE_Matricula.getValueAt(fila, 2).toString()
            );

            cmbTurno.setSelectedItem(
                    JTABLE_Matricula.getValueAt(fila, 3).toString()
            );

            cmbSemestre.setSelectedItem(
                    JTABLE_Matricula.getValueAt(fila, 4).toString()
            );

            cmbCiclo.setSelectedItem(
                    JTABLE_Matricula.getValueAt(fila, 5).toString()
            );

            cmbModalidad.setSelectedItem(
                    JTABLE_Matricula.getValueAt(fila, 6).toString()
            );

            Object fecha = JTABLE_Matricula.getValueAt(fila, 7);
            txtFechaMatricula.setText(fecha == null ? "" : fecha.toString());

            Object operacion = JTABLE_Matricula.getValueAt(fila, 8);
            txtNumOperacion2.setText(
                    operacion == null ? "" : operacion.toString()
            );

            Object estado = JTABLE_Matricula.getValueAt(fila, 9);
            txtEstadoPago.setText(
                    estado == null ? "" : estado.toString()
            );

            Object detalle = JTABLE_Matricula.getValueAt(fila, 10);
            txtDetalles.setText(
                    detalle == null ? "" : detalle.toString()
            );

            habilitarCampos(true);

            txtIdMatricula.setEnabled(false);
            BTN_Guardar.setEnabled(false);
            BTN_Modificar.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al seleccionar la matrícula: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void TXT_BuscarMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarMatriculaKeyReleased
        modeloTablaMatricula.setRowCount(0);
        String criterio = TXT_BuscarMatricula.getText().trim();
        try {
            ResultSet rs = conexion_BD.buscarMatricula(criterio);
            if (rs != null) {
                while (rs.next()) {
                    Object[] fila = {
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                    };
                    modeloTablaMatricula.addRow(fila);
                }
                rs.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar matrículas:\n" + e.getMessage(), "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TXT_BuscarMatriculaKeyReleased

    private void BTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar este formulario?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                if (conexion_BD != null) {
                    conexion_BD.cerrarConexion();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
            dispose();
        }
    }//GEN-LAST:event_BTN_CerrarActionPerformed

    private void jCheckEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckEstudianteActionPerformed
        if (jCheckEstudiante.isSelected()) {
        try {
            Frm_Estudiantes formulario = new Frm_Estudiantes();
            formulario.setLocationRelativeTo(this);
            formulario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al abrir Estudiantes:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            jCheckEstudiante.setSelected(false);
        }
    }
    }//GEN-LAST:event_jCheckEstudianteActionPerformed

    private void jCheckCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCarreraActionPerformed
         if (jCheckCarrera.isSelected()) {
        try {
            Frm_Carrera formulario = new Frm_Carrera();
            formulario.setLocationRelativeTo(this);
            formulario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al abrir Carrera:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            jCheckCarrera.setSelected(false);
        }
         }
    }//GEN-LAST:event_jCheckCarreraActionPerformed

    private void jCheckTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckTurnoActionPerformed
          if (jCheckTurno.isSelected()) {
        try {
            Frm_MantTurno formulario = new Frm_MantTurno();
            formulario.setLocationRelativeTo(this);
            formulario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al abrir Turno:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            jCheckTurno.setSelected(false);
        }
    }

    }//GEN-LAST:event_jCheckTurnoActionPerformed

    private void jCheckModalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckModalidadActionPerformed
           if (jCheckModalidad.isSelected()) {
        try {
            Frm_Modalidad formulario = new Frm_Modalidad();
            formulario.setLocationRelativeTo(this);
            formulario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al abrir Modalidad:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            jCheckModalidad.setSelected(false);
        }
    }
    }//GEN-LAST:event_jCheckModalidadActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new Frm_Matricula().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_VerMatriculas;
    private javax.swing.JTable JTABLE_Matricula;
    private javax.swing.JTextField TXT_BuscarMatricula;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JComboBox<String> cmbCiclo;
    private javax.swing.JComboBox<String> cmbEstudiante;
    private javax.swing.JComboBox<String> cmbModalidad;
    private javax.swing.JComboBox<String> cmbSemestre;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JCheckBox jCheckCarrera;
    private javax.swing.JCheckBox jCheckEstudiante;
    private javax.swing.JCheckBox jCheckModalidad;
    private javax.swing.JCheckBox jCheckTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtEstadoPago;
    private javax.swing.JTextField txtFechaMatricula;
    private javax.swing.JTextField txtIdMatricula;
    private javax.swing.JTextField txtNumOperacion2;
    // End of variables declaration//GEN-END:variables

    private void cargarTodosLosCombos() {
        cargarCombo(cmbEstudiante, "estudiante");
        cargarCombo(cmbCarrera, "carrera");
        cargarCombo(cmbTurno, "turno");
        cargarCombo(cmbSemestre, "semestre");
        cargarCombo(cmbCiclo, "ciclo");
        cargarCombo(cmbModalidad, "modalidad");
    }

    private void cargarCombo(
            javax.swing.JComboBox<String> combo,
            String tipo) {

        DefaultComboBoxModel<String> modelo
                = new DefaultComboBoxModel<>();

        // Primera opción de todos los ComboBox
        modelo.addElement("<<seleccionar>>");

        try {
            ResultSet rs = null;

            switch (tipo) {
                case "estudiante":
                    rs = conexion_BD.listarEstudiantesCombo();
                    break;

                case "carrera":
                    rs = conexion_BD.listarCarrerasCombo();
                    break;

                case "turno":
                    rs = conexion_BD.listarTurnosCombo();
                    break;

                case "semestre":
                    rs = conexion_BD.listarSemestresCombo();
                    break;

                case "ciclo":
                    rs = conexion_BD.listarCiclosCombo();
                    break;

                case "modalidad":
                    rs = conexion_BD.listarModalidadesCombo();
                    break;
            }

            if (rs != null) {
                while (rs.next()) {
                    modelo.addElement(rs.getString(2));
                }

                rs.close();
            }

            combo.setModel(modelo);
            combo.setSelectedIndex(0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar el combo " + tipo + ": "
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void mostrarMatriculas() {
        modeloTablaMatricula.setRowCount(0);

        try {
            ResultSet rs = conexion_BD.listarMatriculas();

            while (rs.next()) {
                Object[] fila = {
                    rs.getObject(1),
                    rs.getObject(2),
                    rs.getObject(3),
                    rs.getObject(4),
                    rs.getObject(5),
                    rs.getObject(6),
                    rs.getObject(7),
                    rs.getObject(8),
                    rs.getObject(9),
                    rs.getObject(10),
                    rs.getObject(11)
                };

                modeloTablaMatricula.addRow(fila);
            }

            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al listar las matrículas: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void habilitarCampos(boolean estado) {
        cmbEstudiante.setEnabled(estado);
        cmbCarrera.setEnabled(estado);
        cmbTurno.setEnabled(estado);
        cmbSemestre.setEnabled(estado);
        cmbCiclo.setEnabled(estado);
        cmbModalidad.setEnabled(estado);

        txtFechaMatricula.setEnabled(estado);
        txtFechaMatricula.setEditable(estado);
        txtNumOperacion2.setEnabled(estado);
        txtEstadoPago.setEnabled(estado);
        txtDetalles.setEnabled(estado);

        txtIdMatricula.setEnabled(false);
    }

    private void limpiarFormulario() {
        txtIdMatricula.setText("");

        txtFechaMatricula.setText("");
        txtNumOperacion2.setText("");
        txtEstadoPago.setText("");
        txtDetalles.setText("");

        if (cmbEstudiante.getItemCount() > 0) {
            cmbEstudiante.setSelectedIndex(0);
        }

        if (cmbCarrera.getItemCount() > 0) {
            cmbCarrera.setSelectedIndex(0);
        }

        if (cmbTurno.getItemCount() > 0) {
            cmbTurno.setSelectedIndex(0);
        }

        if (cmbSemestre.getItemCount() > 0) {
            cmbSemestre.setSelectedIndex(0);
        }

        if (cmbCiclo.getItemCount() > 0) {
            cmbCiclo.setSelectedIndex(0);
        }

        if (cmbModalidad.getItemCount() > 0) {
            cmbModalidad.setSelectedIndex(0);
        }

        JTABLE_Matricula.clearSelection();
    }

    private boolean validarFecha(String fecha) {
        SimpleDateFormat formato
                = new SimpleDateFormat("yyyy-MM-dd");

        formato.setLenient(false);

        try {
            Date fechaConvertida = formato.parse(fecha);

            // Evitar que se acepten fechas con caracteres adicionales.
            return formato.format(fechaConvertida).equals(fecha);

        } catch (ParseException e) {
            return false;
        }
    }
    
private void ajustarColumnasTabla() {

    javax.swing.table.TableColumnModel columnas =
            JTABLE_Matricula.getColumnModel();

    // ID
    columnas.getColumn(0).setPreferredWidth(40);
    columnas.getColumn(0).setMinWidth(35);
    columnas.getColumn(0).setMaxWidth(55);

    // Estudiante
    columnas.getColumn(1).setPreferredWidth(160);

    // Carrera
    columnas.getColumn(2).setPreferredWidth(130);

    // Turno
    columnas.getColumn(3).setPreferredWidth(70);

    // Semestre
    columnas.getColumn(4).setPreferredWidth(85);

    // Ciclo: más pequeño
    columnas.getColumn(5).setPreferredWidth(45);
    columnas.getColumn(5).setMinWidth(40);
    columnas.getColumn(5).setMaxWidth(60);

    // Modalidad
    columnas.getColumn(6).setPreferredWidth(90);

    // Fecha
    columnas.getColumn(7).setPreferredWidth(90);

    // Número de operación
    columnas.getColumn(8).setPreferredWidth(110);

    // Estado de pago: más pequeño
    columnas.getColumn(9).setPreferredWidth(75);
    columnas.getColumn(9).setMinWidth(65);
    columnas.getColumn(9).setMaxWidth(90);

    // Detalles: espacio amplio
    columnas.getColumn(10).setPreferredWidth(180);

    // Altura de las filas
    JTABLE_Matricula.setRowHeight(24);

    // Ajuste automático del ancho de las columnas desactivado
    // para respetar los tamaños definidos arriba.
    JTABLE_Matricula.setAutoResizeMode(
            javax.swing.JTable.AUTO_RESIZE_OFF
    );
}
}
