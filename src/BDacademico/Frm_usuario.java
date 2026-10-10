package BDacademico;
import BDacademico.Conexion_miguel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 07CHMK1PA104A07
 */
public class Frm_usuario extends javax.swing.JFrame {
DefaultTableModel dtm = new DefaultTableModel();
    Conexion_miguel conexionBD;
    /**
     * Creates new form Mant_usuario
     */
    public Frm_usuario() {
        initComponents();
     this.BTN_GUARDARUSUARIO.setEnabled(false);
        this.BTN_RESETPASSWORD.setEnabled(false);
        this.jRadio_ActivarUsuarios.setEnabled(false);
        this.jRadio_DesactivarUsuarios.setEnabled(false);
        this.jRadio_ListarUsuarios_Desactivados.setEnabled(false);
        this.txtIdUsuario.setEnabled(false);
        this.txtestadousuario.setEnabled(false);
         // 1. Definimos la cadena exacta del placeholder para evitar confusiones
        String placeholderText = "Buscar Código o Cargo...";

        // 2. Configuración inicial del Placeholder
        TXTBUSCAR_Usuario.setText(placeholderText);
        TXTBUSCAR_Usuario.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue
         TXTBUSCAR_Usuario.addFocusListener(new java.awt.event.FocusAdapter() {
             @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Si el texto actual es exactamente el placeholder, se limpia y se pone color negro
                if (TXTBUSCAR_Usuario.getText().equals(placeholderText)) {
                    TXTBUSCAR_Usuario.setText("");
                    TXTBUSCAR_Usuario.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale y la caja queda vacía, vuelve a aparecer el texto guía
                if (TXTBUSCAR_Usuario.getText().trim().isEmpty()) {
                    TXTBUSCAR_Usuario.setText(placeholderText);
                    TXTBUSCAR_Usuario.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });

        String titulos[] = {"ID", "Código", "Contraseña", "Cargo", "Estado"};
        dtm.setColumnIdentifiers(titulos);
        JTABLE_USUARIOS.setModel(dtm);
        
     JTABLE_USUARIOS.getColumnModel().getColumn(0).setPreferredWidth(40);   // ID
JTABLE_USUARIOS.getColumnModel().getColumn(1).setPreferredWidth(70);   // Código
JTABLE_USUARIOS.getColumnModel().getColumn(2).setPreferredWidth(400);  // Contraseña
JTABLE_USUARIOS.getColumnModel().getColumn(3).setPreferredWidth(250);  // Cargo
JTABLE_USUARIOS.getColumnModel().getColumn(4).setPreferredWidth(80);   // Estado

        /**/
        conexionBD = new Conexion_miguel();

        /**/
        this.llenarJComboBox_Cargos_usuarios();
                 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcomboboxCargo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtaPassword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtestadousuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        txtcodigoUsuario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        BTN_listarUsuarios = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadio_ListarUsuarios_Desactivados = new javax.swing.JRadioButton();
        jRadio_DesactivarUsuarios = new javax.swing.JRadioButton();
        jRadio_ActivarUsuarios = new javax.swing.JRadioButton();
        BTN_NuevoUSUARIO = new javax.swing.JButton();
        BTN_GUARDARUSUARIO = new javax.swing.JButton();
        BTN_RESETPASSWORD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXTBUSCAR_Usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_USUARIOS = new javax.swing.JTable();
        BTN_CERRAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("IDUSUARIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jcomboboxCargo.setForeground(new java.awt.Color(0, 0, 153));
        jcomboboxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcomboboxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboboxCargoActionPerformed(evt);
            }
        });
        jPanel1.add(jcomboboxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 410, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("CODIGO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtaPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtaPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtaPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaPasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 410, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("ESTADO USUARIO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtestadousuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtestadousuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtestadousuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtestadousuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtestadousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 410, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("CARGO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtIdUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIdUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 410, -1));

        txtcodigoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcodigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtcodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 410, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("PASSWORD");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        BTN_listarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_listarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/escuela.png"))); // NOI18N
        BTN_listarUsuarios.setText("LISTAR USUARIOS");
        BTN_listarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_listarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_listarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadio_ListarUsuarios_Desactivados);
        jRadio_ListarUsuarios_Desactivados.setText("Listar Desactivado");
        jRadio_ListarUsuarios_Desactivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadio_ListarUsuarios_DesactivadosActionPerformed(evt);
            }
        });
        jPanel3.add(jRadio_ListarUsuarios_Desactivados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        buttonGroup1.add(jRadio_DesactivarUsuarios);
        jRadio_DesactivarUsuarios.setText("Desactivar");
        jRadio_DesactivarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadio_DesactivarUsuariosActionPerformed(evt);
            }
        });
        jPanel3.add(jRadio_DesactivarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, 20));

        buttonGroup1.add(jRadio_ActivarUsuarios);
        jRadio_ActivarUsuarios.setText("Activar");
        jRadio_ActivarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadio_ActivarUsuariosActionPerformed(evt);
            }
        });
        jPanel3.add(jRadio_ActivarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 400, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1070, 180));

        BTN_NuevoUSUARIO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NuevoUSUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Nuevo.png"))); // NOI18N
        BTN_NuevoUSUARIO.setText("NUEVO");
        BTN_NuevoUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoUSUARIOActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NuevoUSUARIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 50));

        BTN_GUARDARUSUARIO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GUARDARUSUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Guardar.png"))); // NOI18N
        BTN_GUARDARUSUARIO.setText("GUARDAR");
        BTN_GUARDARUSUARIO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GUARDARUSUARIOMouseClicked(evt);
            }
        });
        BTN_GUARDARUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GUARDARUSUARIOActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GUARDARUSUARIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 190, 50));

        BTN_RESETPASSWORD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_RESETPASSWORD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Modificar.png"))); // NOI18N
        BTN_RESETPASSWORD.setText("RESET");
        BTN_RESETPASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_RESETPASSWORDActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_RESETPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 200, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar Escuela Profesional");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 30));

        TXTBUSCAR_Usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXTBUSCAR_Usuario.setToolTipText("");
        TXTBUSCAR_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXTBUSCAR_UsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXTBUSCAR_UsuarioKeyTyped(evt);
            }
        });
        jPanel2.add(TXTBUSCAR_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 370, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1090, 50));

        JTABLE_USUARIOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_USUARIOS.setForeground(new java.awt.Color(0, 0, 153));
        JTABLE_USUARIOS.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_USUARIOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_USUARIOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_USUARIOS);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1090, 290));

        BTN_CERRAR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_CERRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salir.png"))); // NOI18N
        BTN_CERRAR.setText("Cerrar");
        BTN_CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 640, 130, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE USUARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 240, 30));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_NuevoUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoUSUARIOActionPerformed
   this.BTN_GUARDARUSUARIO.setEnabled(true);
        this.BTN_listarUsuarios.setEnabled(true);
        this.txtcodigoUsuario.setText("");
        this.txtIdUsuario.setText("");
        this.txtaPassword.setText("");
        this.jRadio_ActivarUsuarios.setEnabled(true);
        this.jRadio_DesactivarUsuarios.setEnabled(true);
        this.jRadio_ListarUsuarios_Desactivados.setEnabled(false);

    }//GEN-LAST:event_BTN_NuevoUSUARIOActionPerformed

    private void BTN_GUARDARUSUARIOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GUARDARUSUARIOMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GUARDARUSUARIOMouseClicked

    private void BTN_GUARDARUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GUARDARUSUARIOActionPerformed
       String codigo = txtcodigoUsuario.getText().trim();
        // Si usas un JPasswordField o JTextField para el password:
        String passwordPlano = txtaPassword.getText().trim();

        // 1. Validar campos obligatorios
        if (codigo.isEmpty() || passwordPlano.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el nombre del cargo seleccionado en el ComboBox
        String nombreCargoSeleccionado = jcomboboxCargo.getSelectedItem().toString();
        if (nombreCargoSeleccionado.equals("<<Seleccionar>>") || nombreCargoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cargo válido.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 3. Obtener el ID numérico (CodigoCargo) a partir del nombre seleccionado
            int id_cargo = conexionBD.obtenerCodigoCargoPorNombre_usuarios(nombreCargoSeleccionado);
            if (id_cargo == 0) {
                JOptionPane.showMessageDialog(this, "El cargo seleccionado no es válido en la base de datos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 4. Encriptar la contraseña a SHA-256 antes de enviarla
            String passwordHash = conexionBD.convertirSHA256(passwordPlano);

            // 5. Ejecutar el procedimiento de inserción a través del DAO
            boolean resultado = conexionBD.insertarUsuario(codigo, passwordHash, id_cargo);

            if (resultado) {
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                mostrarDatosTablaUsuarios(); // Refrescar la grilla
                // limpiarCampos(); // Método opcional para limpiar tus cajas de texto
            } else {
                JOptionPane.showMessageDialog(this, "El código de usuario ya se encuentra registrado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos al guardar el usuario: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_GUARDARUSUARIOActionPerformed

    private void BTN_RESETPASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_RESETPASSWORDActionPerformed
// 1. Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = JTABLE_USUARIOS.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para "
                    + "restablecer su contraseña.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el ID del usuario (Índice 0: IdUsuario) y su Código (Índice 1: Codigo)
        int idUsuario = Integer.parseInt(JTABLE_USUARIOS.getValueAt(filaSeleccionada, 0).toString());
        String codigoUsuario = JTABLE_USUARIOS.getValueAt(filaSeleccionada, 1).toString();

        // 3. Ventana de confirmación antes de ejecutar
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de restablecer la contraseña del usuario con código [" + codigoUsuario + "] "
                + "al valor por defecto ('123456')?",
                "Confirmar Restablecimiento", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 4. Llamar al método DAO que gestiona el procedimiento almacenado
                boolean resultado = conexionBD.resetearPasswordUsuario(idUsuario);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "¡Contraseña restablecida exitosamente al valor"
                            + " por defecto ('123456')!",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // 5. Actualizar la tabla para reflejar los cambios si fuera necesario
                    mostrarDatosTablaUsuarios();

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la operación. El ID de "
                            + "usuario no existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos al restablecer la contraseña: "
                        + "" + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BTN_RESETPASSWORDActionPerformed

    private void TXTBUSCAR_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTBUSCAR_UsuarioKeyReleased
        String texto = TXTBUSCAR_Usuario.getText().trim();
        String placeholderText = "Buscar Código o Cargo...";

        // 1. Si tiene el texto de guía o está vacío, restauramos/mostramos todos los registros y salimos
        if (texto.equals(placeholderText) || texto.isEmpty()) {
            mostrarDatosTablaUsuarios(); // Vuelve a cargar todos los usuarios en lugar de dejar la tabla en blanco
            return;
        }

        // 2. Limpiar tabla antes de mostrar resultados nuevos del filtro
        dtm.setRowCount(0);

        // 3. Usamos try-with-resources para ejecutar el procedimiento almacenado de búsqueda a través del DAO
        try (ResultSet rs = conexionBD.buscarUsuario(texto)) {

            // 4. Llenar la tabla con los resultados obtenidos del filtro
            while (rs != null && rs.next()) {
                Object fila[] = {
                    rs.getInt("id_usuario"),
                    rs.getString("codigo"),
                    rs.getString("password"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_usuario")
                };
                dtm.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar usuarios: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TXTBUSCAR_UsuarioKeyReleased

    private void TXTBUSCAR_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXTBUSCAR_UsuarioKeyTyped

    }//GEN-LAST:event_TXTBUSCAR_UsuarioKeyTyped

    private void JTABLE_USUARIOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_USUARIOSMouseClicked
    this.BTN_RESETPASSWORD.setEnabled(true);
        this.jRadio_ActivarUsuarios.setEnabled(true);
        this.jRadio_DesactivarUsuarios.setEnabled(true);
        this.jRadio_ListarUsuarios_Desactivados.setEnabled(false);      
    }//GEN-LAST:event_JTABLE_USUARIOSMouseClicked

    private void BTN_CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CERRARActionPerformed
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
    }//GEN-LAST:event_BTN_CERRARActionPerformed

    private void BTN_listarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_listarUsuariosActionPerformed
       this.mostrarDatosTablaUsuarios();
        this.BTN_listarUsuarios.setEnabled(false);
        this.jRadio_ListarUsuarios_Desactivados.setEnabled(true);
    }//GEN-LAST:event_BTN_listarUsuariosActionPerformed

    private void txtestadousuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtestadousuarioKeyTyped

    }//GEN-LAST:event_txtestadousuarioKeyTyped

    private void txtaPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaPasswordKeyTyped

    }//GEN-LAST:event_txtaPasswordKeyTyped

    private void txtcodigoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoUsuarioKeyTyped

    }//GEN-LAST:event_txtcodigoUsuarioKeyTyped

    private void jRadio_DesactivarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadio_DesactivarUsuariosActionPerformed
        // 1. Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = JTABLE_USUARIOS.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para desactivar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el ID y el estado actual desde la tabla 
        // (Asegúrate de que el índice 0 sea el IdUsuario y el índice 4 sea el EstadoUsuario)
        int idUsuario = Integer.parseInt(JTABLE_USUARIOS.getValueAt(filaSeleccionada, 0).toString());
        String estadoUsuario = JTABLE_USUARIOS.getValueAt(filaSeleccionada, 4).toString();

        // 3. Validar que el usuario esté activo para poder desactivarlo
        if (estadoUsuario.equalsIgnoreCase("Inactivo")) {
            JOptionPane.showMessageDialog(this, "El usuario seleccionado ya se encuentra inactivo.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 4. Ventana de confirmación antes de proceder
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de desactivar al usuario seleccionado?",
                "Confirmar Desactivación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 5. Llamar al método DAO que ejecuta el procedimiento almacenado seguro
                boolean resultado = conexionBD.desactivarUsuario(idUsuario);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Usuario desactivado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // 6. Refrescar la tabla de usuarios activos y limpiar campos
                    this.mostrarDatosTablaUsuarios();
                    // limpiarCampos(); // Descomenta si tienes un método para limpiar los JTextFields
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la operación. El ID de usuario no existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos al desactivar el usuario: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.jRadio_DesactivarUsuarios.setEnabled(false); 
        
// TODO add your handling code here:
    }//GEN-LAST:event_jRadio_DesactivarUsuariosActionPerformed

    private void jcomboboxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboboxCargoActionPerformed
            
    }//GEN-LAST:event_jcomboboxCargoActionPerformed

    private void jRadio_ListarUsuarios_DesactivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadio_ListarUsuarios_DesactivadosActionPerformed
  // Limpiar la tabla antes de cargar los registros inactivos
        dtm.setRowCount(0);

        boolean hayRegistros = false;

        // Usamos try-with-resources para asegurar el cierre automático del ResultSet
        try (ResultSet rs = conexionBD.listarUsuariosInactivos()) {
            while (rs != null && rs.next()) {
                hayRegistros = true;
                Object fila[] = {
                    rs.getInt("id_usuario"),
                    rs.getString("codigo"),
                    rs.getString("password"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_usuario") // Muestra 'Inactivo' según la vista
                };
                dtm.addRow(fila);
            }

            // Si no se encontró ningún registro, mostramos un mensaje informativo
            if (!hayRegistros) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios inactivos registrados.",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar los usuarios inactivos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
       this.jRadio_ListarUsuarios_Desactivados.setEnabled(false);
        this.jRadio_ActivarUsuarios.setEnabled(true);    
        this.jRadio_DesactivarUsuarios.setEnabled(false);    
         this.BTN_listarUsuarios.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadio_ListarUsuarios_DesactivadosActionPerformed

    private void jRadio_ActivarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadio_ActivarUsuariosActionPerformed
    // 1. Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = JTABLE_USUARIOS.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para activar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el ID y el estado actual desde la tabla 
        // (Índice 0: IdUsuario, ÍNDICE 4: EstadoUsuario)
        int idUsuario = Integer.parseInt(JTABLE_USUARIOS.getValueAt(filaSeleccionada, 0).toString());
        String estadoUsuario = JTABLE_USUARIOS.getValueAt(filaSeleccionada, 4).toString();

        // 3. Validar que el usuario esté inactivo para poder activarlo (si ya está activo, no procede)
        if (estadoUsuario.equalsIgnoreCase("Activo")) {
            JOptionPane.showMessageDialog(this, "El usuario seleccionado ya se encuentra activo.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 4. Ventana de confirmación antes de proceder
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de activar al usuario seleccionado?",
                "Confirmar Activación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 5. Llamar al método DAO que ejecuta el procedimiento almacenado seguro
                boolean resultado = conexionBD.reactivarUsuario(idUsuario);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Usuario activado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // 6. Refrescar la tabla de inactivos (ya que al activarlo, este usuario saldrá de la lista de inactivos)
                    // Puedes invocar nuevamente la carga de inactivos o tu método de actualización según prefieras:
                    this.mostrarDatosTablaUsuarios();

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la operación. El ID de usuario no existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos al activar el usuario: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.jRadio_ListarUsuarios_Desactivados.setEnabled(true);
        this.jRadio_ActivarUsuarios.setEnabled(false);
        this.jRadio_DesactivarUsuarios.setEnabled(false);
                                                          
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadio_ActivarUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CERRAR;
    private javax.swing.JButton BTN_GUARDARUSUARIO;
    private javax.swing.JButton BTN_NuevoUSUARIO;
    private javax.swing.JButton BTN_RESETPASSWORD;
    private javax.swing.JButton BTN_listarUsuarios;
    private javax.swing.JTable JTABLE_USUARIOS;
    private javax.swing.JTextField TXTBUSCAR_Usuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadio_ActivarUsuarios;
    private javax.swing.JRadioButton jRadio_DesactivarUsuarios;
    private javax.swing.JRadioButton jRadio_ListarUsuarios_Desactivados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcomboboxCargo;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtaPassword;
    private javax.swing.JTextField txtcodigoUsuario;
    private javax.swing.JTextField txtestadousuario;
    // End of variables declaration//GEN-END:variables
 private void llenarJComboBox_Cargos_usuarios() {
        try {
            jcomboboxCargo.removeAllItems();
            jcomboboxCargo.addItem("<<Seleccionar>>"); // Opción por defecto

            // Usamos try-with-resources para asegurar el cierre del ResultSet si el método lo permite,
            try (ResultSet rs = conexionBD.combobox_ListarCargosUsuarios()) {
                while (rs != null && rs.next()) {
                    String NombreCargo = rs.getString("nombre_cargo");
                    if (NombreCargo != null) {
                        jcomboboxCargo.addItem(NombreCargo.trim());
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar NombreCargo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
 private void mostrarDatosTablaUsuarios() {
        // Limpiar la tabla antes de cargar nuevos registros
        dtm.setRowCount(0);

        // Usamos try-with-resources para asegurar el cierre automático de los recursos
        try (ResultSet rs = conexionBD.listarUsuariosDesdeVista()) {
            while (rs != null && rs.next()) {
                Object fila[] = {
                    rs.getInt("id_usuario"),
                    rs.getString("codigo"),
                    rs.getString("password"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_usuario") // Llega como 'Activo' o 'Inactivo' gracias a la vista
                };
                dtm.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar los usuarios: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*Metodo para listar los registro en la tabla*/
    
 }
