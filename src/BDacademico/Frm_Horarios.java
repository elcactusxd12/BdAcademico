
package BDacademico;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Frm_Horarios extends javax.swing.JFrame {
DefaultTableModel dmt = new DefaultTableModel();
    Conexion_alexander conexionBD;
    
    public Frm_Horarios() {
        this.setUndecorated(rootPaneCheckingEnabled);
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null); // Centra la ventana
        // Centrar el formulario en la pantalla
        this.setLocationRelativeTo(null);
        
         conexionBD = new Conexion_alexander();
   txtcodigo.setEnabled(false);
txttotalhoras.setEditable(false);

btnguardar.setEnabled(false);
btnmodificar.setEnabled(false);
BTN_Calcular.setEnabled(false);
BTN_EXCEL1.setEnabled(false);
BTN_PDF.setEnabled(false);

String placeholderText = "Buscar horario por código, día o descripción...";

txtBuscar.setText(placeholderText);
txtBuscar.setForeground(new java.awt.Color(153, 153, 153));

txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        if (txtBuscar.getText().equals(placeholderText)) {
            txtBuscar.setText("");
            txtBuscar.setForeground(java.awt.Color.BLACK);
        }
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        if (txtBuscar.getText().trim().isEmpty()) {
            txtBuscar.setText(placeholderText);
            txtBuscar.setForeground(
                    new java.awt.Color(153, 153, 153));
        }
    }
});

String[] titulos = {
    "Código",
    "Detalle Matrícula",
    "Pabellón",
    "Aula",
    "Día",
    "Hora Inicio",
    "Hora Fin",
    "Total Horas",
    "Descripción"
};

dmt.setColumnIdentifiers(titulos);
jTable_Horarios.setModel(dmt);

cargarComboDetalleMatricula();
cargarComboPabellon();
cargarComboAula();
cargarComboDias();



jTable_Horarios.getColumnModel().getColumn(0).setMinWidth(0);
jTable_Horarios.getColumnModel().getColumn(0).setMaxWidth(0);
jTable_Horarios.getColumnModel().getColumn(0).setWidth(0);
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Horarios = new javax.swing.JTable();
        btn_salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtcodigo = new javax.swing.JTextField();
        jComboDetalleMatricula = new javax.swing.JComboBox<>();
        jComboBoxPabellon = new javax.swing.JComboBox<>();
        jComboBoxAula = new javax.swing.JComboBox<>();
        jComboBoxdia = new javax.swing.JComboBox<>();
        txtHoraInicio = new javax.swing.JTextField();
        txthorasFin = new javax.swing.JTextField();
        txttotalhoras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BTN_LISTARPLANESTUDIOS = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        BTN_PDF = new javax.swing.JButton();
        BTN_EXCEL1 = new javax.swing.JButton();
        BTN_Calcular = new javax.swing.JButton();
        jCheckPabellon = new javax.swing.JCheckBox();
        jCheckAula = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 180, 50));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarMouseClicked(evt);
            }
        });
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 210, 50));

        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Modificar.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 300, 220, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar por: Escuela Profesional, Cursos, Ciclo, Semestre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 30));

        txtBuscar.setToolTipText("");
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 450, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1390, 50));

        jTable_Horarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable_Horarios.setForeground(new java.awt.Color(0, 0, 153));
        jTable_Horarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_Horarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_HorariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Horarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 1390, 270));

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir.png"))); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, 200, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcodigo.setEditable(false);
        txtcodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcodigo.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 360, -1));

        jComboDetalleMatricula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboDetalleMatricula.setForeground(new java.awt.Color(0, 0, 204));
        jComboDetalleMatricula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboDetalleMatriculaItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboDetalleMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 360, 30));

        jComboBoxPabellon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPabellon.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jComboBoxPabellon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 360, 30));

        jComboBoxAula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAula.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jComboBoxAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 360, 30));

        jComboBoxdia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxdia.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.add(jComboBoxdia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 360, 30));

        txtHoraInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtHoraInicio.setForeground(new java.awt.Color(0, 0, 204));
        txtHoraInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 360, -1));

        txthorasFin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txthorasFin.setForeground(new java.awt.Color(0, 0, 204));
        txthorasFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txthorasFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthorasFinActionPerformed(evt);
            }
        });
        jPanel1.add(txthorasFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 340, -1));

        txttotalhoras.setEditable(false);
        txttotalhoras.setBackground(new java.awt.Color(204, 204, 204));
        txttotalhoras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txttotalhoras.setForeground(new java.awt.Color(0, 0, 204));
        txttotalhoras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txttotalhoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 260, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Detalle Matricula");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Pabellon");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Hora de Inicio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Hora de fin");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 170, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Aula");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Dia");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Descripcion");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 160, 20));

        BTN_LISTARPLANESTUDIOS.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        BTN_LISTARPLANESTUDIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/escuela.png"))); // NOI18N
        BTN_LISTARPLANESTUDIOS.setText("PLAN DE ESTUDIOS");
        BTN_LISTARPLANESTUDIOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BTN_LISTARPLANESTUDIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LISTARPLANESTUDIOSActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_LISTARPLANESTUDIOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 30, -1, 50));

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane2.setViewportView(txtdescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 340, 60));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("Total Horas");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 170, 20));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pdf.png"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 160, 150, 40));

        BTN_EXCEL1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/excel.png"))); // NOI18N
        BTN_EXCEL1.setText("Exportar");
        BTN_EXCEL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCEL1ActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_EXCEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 100, 150, 40));

        BTN_Calcular.setText("CALCULAR");
        BTN_Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CalcularActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Calcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, -1, 40));

        jCheckPabellon.setText("Ir al FrmPabellon");
        jCheckPabellon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckPabellonActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckPabellon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        jCheckAula.setText("Ir al FrmAulas");
        jCheckAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAulaActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1380, 250));
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("MANTENIMIENTO DE HORARIOS");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void jCheckPabellonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckPabellonActionPerformed
        
    if (jCheckPabellon.isSelected()) {
        try {
            Frm_pabellon formulario = new Frm_pabellon();
            formulario.setLocationRelativeTo(this);
            formulario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo abrir el formulario de pabellones:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            jCheckPabellon.setSelected(false);
        }
    }
    }//GEN-LAST:event_jCheckPabellonActionPerformed

    private void jCheckAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAulaActionPerformed
        
    if (jCheckAula.isSelected()) {
        try {
            Frm_Aula formulario = new Frm_Aula();
            formulario.setLocationRelativeTo(this);
            formulario.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo abrir el formulario de aulas:\n"
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            jCheckAula.setSelected(false);
        }
    }
    }//GEN-LAST:event_jCheckAulaActionPerformed

   private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {
    limpiarFormulario();
    btnguardar.setEnabled(true);
    btnmodificar.setEnabled(false);
    BTN_Calcular.setEnabled(true);
}

private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {
    // La acción de guardar se realiza en btnguardarActionPerformed.
}

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {
    if (!validarCombos()) {
        return;
    }

    try {
        ItemCombo detalle = (ItemCombo) jComboDetalleMatricula.getSelectedItem();
        ItemCombo aula = (ItemCombo) jComboBoxAula.getSelectedItem();

        int idDetalle = detalle.getId();
        int idPabellon = conexionBD.obtener_codigoPabellon(
                jComboBoxPabellon.getSelectedItem().toString());

        int idAula = aula.getId();

        int idDia = conexionBD.obtener_codigoDia(
                jComboBoxdia.getSelectedItem().toString());

        if (idPabellon <= 0 || idDia <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No se pudieron obtener los códigos seleccionados.");
            return;
        }

        java.sql.Time inicio = convertirHora(txtHoraInicio.getText());
        java.sql.Time fin = convertirHora(txthorasFin.getText());

        if (fin.getTime() <= inicio.getTime()) {
            JOptionPane.showMessageDialog(this,
                    "La hora final debe ser posterior a la hora de inicio.");
            return;
        }

        double total = calcularHoras(inicio, fin);
        txttotalhoras.setText(String.format(
                java.util.Locale.US, "%.2f", total));

        java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());

        conexionBD.insertarHorario(
                idDetalle,
                idPabellon,
                idAula,
                idDia,
                fecha,
                inicio,
                fin,
                total,
                txtdescripcion.getText().trim()
        );

        JOptionPane.showMessageDialog(this,
                "Horario registrado correctamente.");

        mostrarDatosTablaHorario();
        limpiarFormulario();

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this,
                "Formato de hora incorrecto. Utiliza HH:mm, por ejemplo 08:30.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al guardar el horario:\n" + e.getMessage());
    }
}

private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {
    if (txtcodigo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Selecciona un horario de la tabla.");
        return;
    }

    if (!validarCombos()) {
        return;
    }

    try {
        int idHorario = Integer.parseInt(txtcodigo.getText().trim());

        ItemCombo detalle = (ItemCombo) jComboDetalleMatricula.getSelectedItem();
        ItemCombo aula = (ItemCombo) jComboBoxAula.getSelectedItem();

        int idDetalle = detalle.getId();
        int idAula = aula.getId();

        int idPabellon = conexionBD.obtener_codigoPabellon(
                jComboBoxPabellon.getSelectedItem().toString());

        int idDia = conexionBD.obtener_codigoDia(
                jComboBoxdia.getSelectedItem().toString());

        if (idPabellon <= 0 || idDia <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No se pudieron obtener los códigos seleccionados.");
            return;
        }

        java.sql.Time inicio = convertirHora(txtHoraInicio.getText());
        java.sql.Time fin = convertirHora(txthorasFin.getText());

        if (fin.getTime() <= inicio.getTime()) {
            JOptionPane.showMessageDialog(this,
                    "La hora final debe ser posterior a la hora de inicio.");
            return;
        }

        double total = calcularHoras(inicio, fin);
        txttotalhoras.setText(String.format(
                java.util.Locale.US, "%.2f", total));

        java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());

        conexionBD.modificarHorario(
                idHorario,
                idDetalle,
                idPabellon,
                idAula,
                idDia,
                fecha,
                inicio,
                fin,
                total,
                txtdescripcion.getText().trim()
        );

        JOptionPane.showMessageDialog(this,
                "Horario modificado correctamente.");

        mostrarDatosTablaHorario();
        limpiarFormulario();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "El código del horario no es válido.");
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this,
                "Formato de hora incorrecto. Utiliza HH:mm.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al modificar el horario:\n" + e.getMessage());
    }
}

private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {
    String texto = txtBuscar.getText().trim();

    if (texto.equals("Buscar horario por código, día o descripción...")
            || texto.isEmpty()) {
        mostrarDatosTablaHorario();
        return;
    }

    dmt.setRowCount(0);

    try (ResultSet rs = conexionBD.buscarHorario(texto)) {
        while (rs.next()) {
            Object[] fila = {
                rs.getInt("id_horario"),
                rs.getString("observaciones"),
                rs.getString("nombre_pabellon"),
                rs.getString("numero_aula"),
                rs.getString("nombre_dia"),
                rs.getString("hora_inicio"),
                rs.getString("hora_fin"),
                rs.getDouble("total_horas"),
                rs.getString("descripcion")
            };

            dmt.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al buscar horarios:\n" + e.getMessage());
    }
}

private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {
    // Sin acción adicional.
}

private void jTable_HorariosMouseClicked(java.awt.event.MouseEvent evt) {
    int filaVista = jTable_Horarios.getSelectedRow();

    if (filaVista < 0) {
        return;
    }

    int fila = jTable_Horarios.convertRowIndexToModel(filaVista);

    txtcodigo.setText(String.valueOf(dmt.getValueAt(fila, 0)));

    seleccionarComboPorTexto(
            jComboDetalleMatricula, dmt.getValueAt(fila, 1));
    seleccionarComboPorTexto(
            jComboBoxPabellon, dmt.getValueAt(fila, 2));
    seleccionarComboPorTexto(
            jComboBoxAula, dmt.getValueAt(fila, 3));
    seleccionarComboPorTexto(
            jComboBoxdia, dmt.getValueAt(fila, 4));

    txtHoraInicio.setText(String.valueOf(dmt.getValueAt(fila, 5)));
    txthorasFin.setText(String.valueOf(dmt.getValueAt(fila, 6)));
    txttotalhoras.setText(String.valueOf(dmt.getValueAt(fila, 7)));

    Object descripcion = dmt.getValueAt(fila, 8);
    txtdescripcion.setText(descripcion == null ? "" : descripcion.toString());

    btnguardar.setEnabled(false);
    btnmodificar.setEnabled(true);
    BTN_Calcular.setEnabled(true);
    BTN_PDF.setEnabled(true);
    BTN_EXCEL1.setEnabled(true);
}

private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {
    int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea salir del sistema?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (opcion == JOptionPane.YES_OPTION) {
        dispose();
    }
}

private void jComboDetalleMatriculaItemStateChanged(
        java.awt.event.ItemEvent evt) {
    // Sin acción adicional.
}

private void BTN_LISTARPLANESTUDIOSActionPerformed(java.awt.event.ActionEvent evt) {
    this.mostrarDatosTablaHorario();
    limpiarFormulario();
    btnguardar.setEnabled(false);
     btnmodificar.setEnabled(false);
}

private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this,
            "La exportación a PDF todavía no está configurada.");
}

private void BTN_EXCEL1ActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this,
            "La exportación a Excel todavía no está configurada.");
}

private void BTN_CalcularActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        java.sql.Time inicio = convertirHora(txtHoraInicio.getText());
        java.sql.Time fin = convertirHora(txthorasFin.getText());

        if (fin.getTime() <= inicio.getTime()) {
            JOptionPane.showMessageDialog(this,
                    "La hora final debe ser posterior a la inicial.");
            return;
        }

        double total = calcularHoras(inicio, fin);

        txttotalhoras.setText(String.format(
                java.util.Locale.US, "%.2f", total));

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this,
                "Ingresa las horas con el formato HH:mm, por ejemplo 09:30.");
    }
}

private void txthorasFinActionPerformed(java.awt.event.ActionEvent evt) {
    BTN_CalcularActionPerformed(evt);
}

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
            java.util.logging.Logger.getLogger(Frm_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Horarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Calcular;
    private javax.swing.JButton BTN_EXCEL1;
    private javax.swing.JButton BTN_LISTARPLANESTUDIOS;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JCheckBox jCheckAula;
    private javax.swing.JCheckBox jCheckPabellon;
    private javax.swing.JComboBox<String> jComboBoxAula;
    private javax.swing.JComboBox<String> jComboBoxPabellon;
    private javax.swing.JComboBox<String> jComboBoxdia;
    private javax.swing.JComboBox<String> jComboDetalleMatricula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Horarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextArea txtdescripcion;
    private javax.swing.JTextField txthorasFin;
    private javax.swing.JTextField txttotalhoras;
    // End of variables declaration//GEN-END:variables
// ============================================================
// 9. MÉTODOS AUXILIARES
// Pégalos al final de Frm_Horarios, antes de la última llave }
// ============================================================

private boolean validarCombos() {
    if (jComboDetalleMatricula.getSelectedIndex() <= 0
            || jComboBoxPabellon.getSelectedIndex() <= 0
            || jComboBoxAula.getSelectedIndex() <= 0
            || jComboBoxdia.getSelectedIndex() <= 0) {

        JOptionPane.showMessageDialog(this,
                "Seleccione el detalle de matrícula, pabellón, aula y día.",
                "Validación", JOptionPane.WARNING_MESSAGE);

        return false;
    }

    if (txtHoraInicio.getText().trim().isEmpty()
            || txthorasFin.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "Ingrese la hora de inicio y la hora final.",
                "Validación", JOptionPane.WARNING_MESSAGE);

        return false;
    }

    return true;
}

private java.sql.Time convertirHora(String texto) {
    String hora = texto.trim();

    if (hora.matches("\\d{2}:\\d{2}")) {
        hora += ":00";
    }

    return java.sql.Time.valueOf(hora);
}

private double calcularHoras(
        java.sql.Time horaInicio, java.sql.Time horaFin) {

    long diferenciaMilisegundos =
            horaFin.getTime() - horaInicio.getTime();

    return diferenciaMilisegundos / 3600000.0;
}

private void limpiarFormulario() {
    txtcodigo.setText("");

    if (jComboDetalleMatricula.getItemCount() > 0) {
        jComboDetalleMatricula.setSelectedIndex(0);
    }

    if (jComboBoxPabellon.getItemCount() > 0) {
        jComboBoxPabellon.setSelectedIndex(0);
    }

    if (jComboBoxAula.getItemCount() > 0) {
        jComboBoxAula.setSelectedIndex(0);
    }

    if (jComboBoxdia.getItemCount() > 0) {
        jComboBoxdia.setSelectedIndex(0);
    }

    txtHoraInicio.setText("");
    txthorasFin.setText("");
    txttotalhoras.setText("");
    txtdescripcion.setText("");

    btnguardar.setEnabled(false);
    btnmodificar.setEnabled(false);
    BTN_Calcular.setEnabled(false);
    BTN_PDF.setEnabled(false);
    BTN_EXCEL1.setEnabled(false);
}

private void mostrarDatosTablaHorario() {
    jTable_Horarios.setAutoCreateRowSorter(true);
    dmt.setRowCount(0);

    try (ResultSet rs = conexionBD.listar_Horarios()) {
        while (rs != null && rs.next()) {
            Object[] fila = {
                rs.getInt("id_horario"),
                rs.getString("observaciones"),
                rs.getString("nombre_pabellon"),
                rs.getString("numero"),
                rs.getString("nombre_dia"),
                rs.getString("hora_inicio"),
                rs.getString("hora_fin"),
                rs.getInt("total_horas"),
                rs.getString("descripcion")
            };

            dmt.addRow(fila);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al listar horarios:\n" + e.getMessage());
    }
}

// ============================================================
// COMBOBOX: DETALLE DE MATRÍCULA
// ============================================================


private void cargarComboDetalleMatricula() {
    jComboDetalleMatricula.removeAllItems();
    jComboDetalleMatricula.addItem("<<seleccionar>>");

    try (ResultSet rs = conexionBD.combobox_listarDetalleMatricula()) {
        while (rs.next()) {
            String observaciones = rs.getString("observaciones");

            if (observaciones == null || observaciones.trim().isEmpty()) {
                observaciones = "Sin observaciones";
            }

            jComboDetalleMatricula.addItem(observaciones);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al cargar detalle de matrícula:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// ============================================================
// COMBOBOX: PABELLÓN
// ============================================================

private void cargarComboPabellon() {
    jComboBoxPabellon.removeAllItems();
    jComboBoxPabellon.addItem("<<seleccionar>>");

    try (ResultSet rs = conexionBD.combobox_listarPabellon()) {
        while (rs != null && rs.next()) {
            jComboBoxPabellon.addItem(
                    rs.getString("nombre_pabellon"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al cargar pabellones:\n" + e.getMessage());
    }
}

// ============================================================
// COMBOBOX: AULA
// ============================================================


private void cargarComboAula() {
    jComboBoxAula.removeAllItems();
    jComboBoxAula.addItem("<<seleccionar>>");

    try (ResultSet rs = conexionBD.combobox_listarAula()) {
        while (rs.next()) {
            String numero = rs.getString("numero");
            jComboBoxAula.addItem(numero);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al cargar aulas:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// ============================================================
// COMBOBOX: DÍAS
// ============================================================

private void cargarComboDias() {
    jComboBoxdia.removeAllItems();
    jComboBoxdia.addItem("<<seleccionar>>");

    try (ResultSet rs = conexionBD.combobox_listarDias()) {
        while (rs != null && rs.next()) {
            jComboBoxdia.addItem(
                    rs.getString("nombre_dia"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al cargar los días:\n" + e.getMessage());
    }
}
private class ItemCombo {

    private final int id;
    private final String texto;

    public ItemCombo(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return texto;
    }
}
private void seleccionarComboPorTexto(
        javax.swing.JComboBox<?> combo, Object valor) {

    if (valor == null) {
        combo.setSelectedIndex(0);
        return;
    }

    String textoBuscado = valor.toString();

    for (int i = 1; i < combo.getItemCount(); i++) {
        Object elemento = combo.getItemAt(i);

        if (elemento != null
                && elemento.toString().equals(textoBuscado)) {
            combo.setSelectedIndex(i);
            return;
        }
    }

    combo.setSelectedIndex(0);
}



}
