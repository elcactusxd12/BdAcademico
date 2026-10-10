package BDacademico;

import java.sql.*;

public class Conexion_miguel {
//Variables de instancia para la conexion y ejecucion de consultas

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    //parametros de conexion
    private static final String URL = "jdbc:mysql://localhost:3306/BdAcademico";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Conexion_miguel() {
        try {
            // cargar el driver de mysql(opcional en versiones recientes
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer conexion con la bd
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion estableida correctamente con la bd 'universidad'.");
        } catch (ClassNotFoundException e) {
            System.out.println("error:driver de mysql no encontrado");
        } catch (SQLException e) {
            System.out.println("error al conectar con la base de datos");

        }

    }
    //================================TABLA CARGOS===============================================================

    public ResultSet listarCargos() throws SQLException {
        String sql = "SELECT*FROM vista_cargos";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void insertarCargo(String nombreCargo) throws SQLException {
        String sql = "{CALL sp_cargo_insertar(?)}";
        // 
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, nombreCargo);
            cs.execute();
            System.out.println("Cargo insertado correctamente...!");
        }
    }

    // 4. 
    public void modificarCargo(int codigo, String nuevoNombre) throws SQLException {
        String sql = "{CALL sp_cargo_actualizar(?, ?)}";
        // Usamos CallableStatement en lugar de PreparedStatement para llamadas a SPs
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, nuevoNombre);

            cs.executeUpdate();
            System.out.println("Cargo modificado correctamente...!");
        }
    }

    public void desactivarCargo(int codigo) throws SQLException {
        String sql = "{CALL sp_cargo_desactivar(?)}";
        // 
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.executeUpdate();
            System.out.println("Cargo desactivado correctamente...!");
        }
    }

    public ResultSet buscarCargos(String nombre) throws SQLException {

        String sql = "{CALL sp_cargo_buscar(?)}";

        // Llamada al procedimiento almacenado
        CallableStatement cs = conn.prepareCall(sql);

        // Enviar el nombre como parámetro
        cs.setString(1, nombre);

        // Ejecutar procedimiento
        rs = cs.executeQuery();

        return rs;
    }
    //====================================TABLA CURSOS==================================================

    public ResultSet listarCursos() throws SQLException {
        String sql = "SELECT * FROM vista_cursos";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet buscarCurso(String nombre) throws SQLException {

        String sql = "{CALL sp_curso_buscar(?)}";

        CallableStatement cs = conn.prepareCall(sql);

        cs.setString(1, nombre);

        rs = cs.executeQuery();

        return rs;
    }

    public void insertarCurso(String nombre_curso, String descripcion) throws SQLException {

        String sql = "{CALL sp_curso_insertar(?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, nombre_curso);
            cs.setString(2, descripcion);

            cs.execute();

            System.out.println("Curso insertado correctamente...!");
        }
    }

    public void modificarCurso(int codigo, String nuevoNombre, String nuevaDescripcion) throws SQLException {

        String sql = "{CALL sp_curso_actualizar(?, ?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, codigo);
            cs.setString(2, nuevoNombre);
            cs.setString(3, nuevaDescripcion);

            cs.executeUpdate();

            System.out.println("Curso modificado correctamente...!");
        }
    }

    /*=============================PABELLON====================================*/
    public ResultSet listarPabellones() throws SQLException {
        String sql = "SELECT * FROM vista_pabellones";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet buscarPabellon(String pabellon) throws SQLException {
        String sql = "{CALL sp_pabellon_buscar(?)}";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, pabellon);
        rs = cs.executeQuery();
        return rs;
    }

    public void insertarPabellon(String pabellon) throws SQLException {
        String sql = "{CALL sp_pabellon_insertar(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, pabellon);
            cs.execute();

            System.out.println("Pabellón insertado correctamente...!");
        }
    }

    public void modificarPabellon(int codigo, String pabellon) throws SQLException {
        String sql = "{CALL sp_pabellon_actualizar(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, pabellon);
            cs.executeUpdate();

            System.out.println("Pabellón modificado correctamente...!");
        }
    }
//=================================PROCEDENCIA=====================================
/* 1. Método para listar procedencias */
    public ResultSet listarProcedencias() throws SQLException {
        String sql = "SELECT * FROM vista_procedencias";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /* 2. Método para buscar procedencias */
    public ResultSet buscarProcedencia(String procedencia) throws SQLException {
        String sql = "{CALL sp_procedencia_buscar(?)}";

        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, procedencia);
        rs = cs.executeQuery();

        return rs;
    }

    /* 3. Método para insertar procedencias */
    public void insertarProcedencia(String descripcion) throws SQLException {
        String sql = "{CALL sp_procedencia_insertar(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, descripcion);
            cs.execute();

            System.out.println("Procedencia insertada correctamente...!");
        }
    }

    /* 4. Método para modificar procedencias */
    public void modificarProcedencia(int codigo, String descripcion) throws SQLException {
        String sql = "{CALL sp_procedencia_actualizar(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, descripcion);
            cs.execute();

            System.out.println("Procedencia modificada correctamente...!");
        }
    }
//=============================SEMESTRE==========================================
/* 1. Método para listar semestres */
    public ResultSet listarSemestres() throws SQLException {
        String sql = "SELECT * FROM vista_semestres";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /* 2. Método para buscar semestres */
    public ResultSet buscarSemestre(String semestre) throws SQLException {
        String sql = "{CALL sp_semestre_buscar(?)}";

        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, semestre);
        rs = cs.executeQuery();

        return rs;
    }

    /* 3. Método para insertar semestres */
    public void insertarSemestre(String semestre) throws SQLException {
        String sql = "{CALL sp_semestre_insertar(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, semestre);
            cs.execute();

            System.out.println("Semestre insertado correctamente...!");
        }
    }

    /* 4. Método para modificar semestres */
    public void modificarSemestre(int codigo, String semestre) throws SQLException {
        String sql = "{CALL sp_semestre_actualizar(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, semestre);
            cs.execute();

            System.out.println("Semestre modificado correctamente...!");
        }
    }
//==============================TIPO_PAGO=========================================
/* 1. Método para listar tipos de pago */
    public ResultSet listarTiposPago() throws SQLException {
        String sql = "SELECT * FROM vista_tipos_pago";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /* 2. Método para buscar tipos de pago */
    public ResultSet buscarTipoPago(String tipoPago) throws SQLException {
        String sql = "{CALL sp_tipo_pago_buscar(?)}";

        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, tipoPago);
        rs = cs.executeQuery();

        return rs;
    }

    /* 3. Método para insertar tipos de pago */
    public void insertarTipoPago(String tipoPago) throws SQLException {
        String sql = "{CALL sp_tipo_pago_insertar(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, tipoPago);
            cs.execute();

            System.out.println("Tipo de pago insertado correctamente...!");
        }
    }

    /* 4. Método para modificar tipos de pago */
    public void modificarTipoPago(int codigo, String tipoPago) throws SQLException {
        String sql = "{CALL sp_tipo_pago_actualizar(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, tipoPago);
            cs.execute();

            System.out.println("Tipo de pago modificado correctamente...!");
        }
    }

    //=============================METODOS PARA TABLA MATRICULA============================================
    /* =========================================================
   1. LISTAR TODAS LAS MATRÍCULAS
   ========================================================= */
    public ResultSet listarMatriculas() throws SQLException {

        String sql = "SELECT * FROM vista_matriculas ORDER BY id_matricula";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* =========================================================
   2. INSERTAR UNA MATRÍCULA
   Procedimiento: sp_matricula_insertar
   ========================================================= */
    public void insertarMatricula(
            int idEstudiante,
            int idCarrera,
            int idTurno,
            int idSemestre,
            int idCiclo,
            int idModalidad,
            java.sql.Date fechaMatricula,
            String numeroOperacion,
            int estadoPago,
            String detalles) throws SQLException {

        String sql = "{CALL sp_matricula_insertar(?,?,?,?,?,?,?,?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, idEstudiante);
            cs.setInt(2, idCarrera);
            cs.setInt(3, idTurno);
            cs.setInt(4, idSemestre);
            cs.setInt(5, idCiclo);
            cs.setInt(6, idModalidad);
            cs.setDate(7, fechaMatricula);
            cs.setString(8, numeroOperacion);
            cs.setInt(9, estadoPago);
            cs.setString(10, detalles);

            cs.executeUpdate();
        }
    }


    /* =========================================================
   3. MODIFICAR UNA MATRÍCULA
   Procedimiento: sp_matricula_actualizar
   ========================================================= */
    public void modificarMatricula(
            int idMatricula,
            int idEstudiante,
            int idCarrera,
            int idTurno,
            int idSemestre,
            int idCiclo,
            int idModalidad,
            java.sql.Date fechaMatricula,
            String numeroOperacion,
            int estadoPago,
            String detalles) throws SQLException {

        String sql = "{CALL sp_matricula_actualizar(?,?,?,?,?,?,?,?,?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, idMatricula);
            cs.setInt(2, idEstudiante);
            cs.setInt(3, idCarrera);
            cs.setInt(4, idTurno);
            cs.setInt(5, idSemestre);
            cs.setInt(6, idCiclo);
            cs.setInt(7, idModalidad);
            cs.setDate(8, fechaMatricula);
            cs.setString(9, numeroOperacion);
            cs.setInt(10, estadoPago);
            cs.setString(11, detalles);

            cs.executeUpdate();
        }
    }


    /* =========================================================
   4. BUSCAR MATRÍCULAS
   Procedimiento: sp_matricula_buscar
   ========================================================= */
    public ResultSet buscarMatricula(String busqueda) throws SQLException {

        String sql = "{CALL sp_matricula_buscar(?)}";

        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, busqueda);

        rs = cs.executeQuery();

        return rs;
    }

    //=============================METODOS PARA COMBOBOX============================================
    /* 5. Cargar estudiantes en el JComboBox */
    public ResultSet listarEstudiantesCombo() throws SQLException {

        String sql = "SELECT id_estudiante, "
                + "CONCAT(nombres, ' ', apellidos) AS estudiante "
                + "FROM estudiante "
                + "ORDER BY apellidos, nombres";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* 6. Obtener ID del estudiante por nombre */
    public int obtenerIdEstudiantePorNombre_Matricula(
            String nombreEstudiante) throws SQLException {

        String sql = "SELECT id_estudiante "
                + "FROM estudiante "
                + "WHERE CONCAT(nombres, ' ', apellidos) = ? "
                + "LIMIT 1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreEstudiante);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("id_estudiante");
                }
            }
        }

        return 0;
    }


    /* 7. Obtener nombre del estudiante por ID */
    public String obtenerNombreEstudiantePorId_Matricula(
            int idEstudiante) throws SQLException {

        String sql = "SELECT CONCAT(nombres, ' ', apellidos) AS estudiante "
                + "FROM estudiante "
                + "WHERE id_estudiante = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("estudiante");
                }
            }
        }

        return "";
    }


    /* 8. Cargar carreras en el JComboBox */
    public ResultSet listarCarrerasCombo() throws SQLException {

        String sql = "SELECT id_carrera, nombre_carrera "
                + "FROM carrera "
                + "ORDER BY nombre_carrera";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* 9. Obtener ID de carrera por nombre */
    public int obtenerIdCarreraPorNombre_Matricula(
            String nombreCarrera) throws SQLException {

        String sql = "SELECT id_carrera "
                + "FROM carrera "
                + "WHERE nombre_carrera = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreCarrera);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("id_carrera");
                }
            }
        }

        return 0;
    }


    /* 10. Obtener nombre de carrera por ID */
    public String obtenerNombreCarreraPorId_Matricula(
            int idCarrera) throws SQLException {

        String sql = "SELECT nombre_carrera "
                + "FROM carrera "
                + "WHERE id_carrera = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCarrera);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("nombre_carrera");
                }
            }
        }

        return "";
    }


    /* 11. Cargar turnos en el JComboBox */
    public ResultSet listarTurnosCombo() throws SQLException {

        String sql = "SELECT id_turno, descripcion "
                + "FROM turno "
                + "ORDER BY descripcion";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* 12. Obtener ID de turno por descripción */
    public int obtenerIdTurnoPorNombre_Matricula(
            String nombreTurno) throws SQLException {

        String sql = "SELECT id_turno "
                + "FROM turno "
                + "WHERE descripcion = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreTurno);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("id_turno");
                }
            }
        }

        return 0;
    }


    /* 13. Obtener descripción del turno por ID */
    public String obtenerNombreTurnoPorId_Matricula(
            int idTurno) throws SQLException {

        String sql = "SELECT descripcion "
                + "FROM turno "
                + "WHERE id_turno = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idTurno);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("descripcion");
                }
            }
        }

        return "";
    }


    /* 14. Cargar semestres en el JComboBox */
    public ResultSet listarSemestresCombo() throws SQLException {

        String sql = "SELECT id_semestre, nombre_semestre "
                + "FROM semestre "
                + "ORDER BY nombre_semestre";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* 15. Obtener ID del semestre por nombre */
    public int obtenerIdSemestrePorNombre_Matricula(
            String nombreSemestre) throws SQLException {

        String sql = "SELECT id_semestre "
                + "FROM semestre "
                + "WHERE nombre_semestre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreSemestre);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("id_semestre");
                }
            }
        }

        return 0;
    }


    /* 16. Obtener nombre del semestre por ID */
    public String obtenerNombreSemestrePorId_Matricula(
            int idSemestre) throws SQLException {

        String sql = "SELECT nombre_semestre "
                + "FROM semestre "
                + "WHERE id_semestre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idSemestre);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("nombre_semestre");
                }
            }
        }

        return "";
    }


    /* 17. Cargar ciclos en el JComboBox */
    public ResultSet listarCiclosCombo() throws SQLException {

        String sql = "SELECT id_ciclo, nombre_ciclo "
                + "FROM ciclo "
                + "ORDER BY nombre_ciclo";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* 18. Obtener ID del ciclo por nombre */
    public int obtenerIdCicloPorNombre_Matricula(
            String nombreCiclo) throws SQLException {

        String sql = "SELECT id_ciclo "
                + "FROM ciclo "
                + "WHERE nombre_ciclo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreCiclo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("id_ciclo");
                }
            }
        }

        return 0;
    }


    /* 19. Obtener nombre del ciclo por ID */
    public String obtenerNombreCicloPorId_Matricula(
            int idCiclo) throws SQLException {

        String sql = "SELECT nombre_ciclo "
                + "FROM ciclo "
                + "WHERE id_ciclo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCiclo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("nombre_ciclo");
                }
            }
        }

        return "";
    }


    /* 20. Cargar modalidades en el JComboBox */
    public ResultSet listarModalidadesCombo() throws SQLException {

        String sql = "SELECT id_modalidad, nombre_modalidad "
                + "FROM modalidad "
                + "ORDER BY nombre_modalidad";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }


    /* 21. Obtener ID de modalidad por nombre */
    public int obtenerIdModalidadPorNombre_Matricula(
            String nombreModalidad) throws SQLException {

        String sql = "SELECT id_modalidad "
                + "FROM modalidad "
                + "WHERE nombre_modalidad = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreModalidad);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("id_modalidad");
                }
            }
        }

        return 0;
    }


    /* 22. Obtener nombre de modalidad por ID */
    public String obtenerNombreModalidadPorId_Matricula(
            int idModalidad) throws SQLException {

        String sql = "SELECT nombre_modalidad "
                + "FROM modalidad "
                + "WHERE id_modalidad = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idModalidad);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("nombre_modalidad");
                }
            }
        }

        return "";
    }
//==============================LOGIN=========================================

    public ResultSet combobox_ListarCargos() throws SQLException {
        String sql = "SELECT nombre_cargo FROM cargo WHERE estado_cargo = 1";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /* Método para validar si el acceso es correcto y devuelve true o false */
    public boolean validarLogin(String codigo, String password, String cargo) throws SQLException {
        String sql = "{CALL sp_validar_usuario(?, ?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codigo);
            cs.setString(2, password);
            cs.setString(3, cargo);

            try (ResultSet rs = cs.executeQuery()) {
                // Si encuentra un registro, significa que el usuario, clave y cargo coinciden y está activo
                return rs.next();
            }
        }
    }

    /* Método para bloquear al usuario tras superar los intentos fallidos */
    public void bloquearUsuario(String codigo) throws SQLException {
        String sql = "{CALL sp_bloquear_usuario(?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codigo);
            cs.executeUpdate();
        }
    }

    //=============================================================================================
    /*TABLA USUARIOS:*/
 /*1. Para cargar los cargos en el JComboBox del formulario usuarios*/
    public ResultSet combobox_ListarCargosUsuarios() throws SQLException {
        String sql = "SELECT nombre_cargo FROM cargo WHERE estado_cargo = 1";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /*2. Método para obtener el CodigoCargo (ID) dado el NombreCargo seleccionado */
    public int obtenerCodigoCargoPorNombre_usuarios(String nombre_cargo) throws SQLException {
        String sql = "SELECT id_cargo FROM cargo WHERE nombre_cargo = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre_cargo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_cargo");
                }
            }
        }
        return 0; // Retorna 0 si no se encuentra
    }

    /*3. Método para listar usuarios usando directamente la vista de la base de datos */
    public ResultSet listarUsuariosDesdeVista() throws SQLException {
        String sql = "SELECT * FROM view_usuarios";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    /*4. Procedure para buscar*/
    public ResultSet buscarUsuario(String filtro) throws SQLException {
        String sql = "{CALL sp_buscar_usuario(?)}";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, filtro);
        return cs.executeQuery();
    }

    /*5. Método para listar usuarios inactivos desde la vista */
    public ResultSet listarUsuariosInactivos() throws SQLException {
        String sql = "SELECT * FROM vw_listar_usuarios_inactivos";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }


    /*6. Método seguro para desactivar un usuario */
    public boolean desactivarUsuario(int id_usuario) throws SQLException {
        String sql = "{CALL sp_desactivar_usuario(?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_usuario);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.execute();

            int resultado = cs.getInt(2);
            return resultado > 0; // Retorna true si se desactivó, false si el ID no existía
        }
    }

    /*7. Método seguro para reactivar un usuario */
    public boolean reactivarUsuario(int id_usuario) throws SQLException {
        String sql = "{CALL sp_reactivar_usuario(?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_usuario);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.execute();

            int resultado = cs.getInt(2);
            return resultado > 0; // Retorna true si se reactivó, false si el ID no existía
        }
    }

    /*8. Método para encriptar cadenas a SHA-256 (estándar del sistema) */
    public String convertirSHA256(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error al encriptar la contraseña: " + ex.getMessage(), ex);
        }
    }

    /*9. Método seguro para registrar un nuevo usuario */
    public boolean insertarUsuario(String codigo, String passwordEncriptado, int codigo_cargo) throws SQLException {
        String sql = "{CALL sp_insertar_usuario(?, ?, ?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codigo);
            cs.setString(2, passwordEncriptado);
            cs.setInt(3, codigo_cargo);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.execute();

            return cs.getInt(4) > 0; // Retorna true si se insertó correctamente
        }
    }

    /*10. Método para restablecer la contraseña de un usuario al valor por defecto (1 al 6) */
    public boolean resetearPasswordUsuario(int id_usuario) throws SQLException {
        // Encriptamos la clave por defecto "123456" utilizando el método SHA-256 del sistema
        String passwordEncriptado = convertirSHA256("123456");

        String sql = "{CALL sp_reset_password(?, ?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_usuario);
            cs.setString(2, passwordEncriptado);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.execute();

            return cs.getInt(3) > 0; // Retorna true si se actualizó correctamente
        }
    }/*Finaliza*/



 /* ===================== TABLA PLAN DE ESTUDIOS ============================= */

 /* 1. Cargar las carreras al JComboBox */
    public ResultSet combobox_listarCarrera() throws SQLException {
        String sql = "SELECT nombre_carrera FROM carrera";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }

    /* 2. Obtener el ID de una carrera a partir de su nombre */
    public int obtener_codigoCarrera(String nombre_carrera) throws SQLException {
        String sql = "SELECT id_carrera FROM carrera WHERE nombre_carrera = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre_carrera);

            try (ResultSet rsAux = ps.executeQuery()) {
                if (rsAux.next()) {
                    return rsAux.getInt("id_carrera");
                }
            }
        }

        return -1;
    }

    /* 3. Cargar los cursos al JComboBox */
    public ResultSet combobox_listarCursos() throws SQLException {
        String sql = "SELECT nombre_curso FROM curso";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }

    /* 4. Obtener el ID de un curso */
    public int obtener_codigoCurso(String nombre_curso) throws SQLException {
        String sql = "SELECT id_curso FROM curso WHERE nombre_curso = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre_curso);

            try (ResultSet rsAux = ps.executeQuery()) {
                if (rsAux.next()) {
                    return rsAux.getInt("id_curso");
                }
            }
        }

        return -1;
    }

    /* 5. Cargar los ciclos al JComboBox */
    public ResultSet combobox_listarCiclo() throws SQLException {
        String sql = "SELECT nombre_ciclo FROM ciclo";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }

    /* 6. Obtener el ID de un ciclo */
    public int obtener_codigoCiclo(String nombre_ciclo) throws SQLException {
        String sql = "SELECT id_ciclo FROM ciclo WHERE nombre_ciclo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre_ciclo);

            try (ResultSet rsAux = ps.executeQuery()) {
                if (rsAux.next()) {
                    return rsAux.getInt("id_ciclo");
                }
            }
        }

        return -1;
    }

    /* 7. Cargar los semestres al JComboBox */
    public ResultSet combobox_listarSemestre() throws SQLException {
        String sql = "SELECT nombre_semestre FROM semestre";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }

    /* 8. Obtener el ID de un semestre */
    public int obtener_codigoSemestre(String nombre_semestre) throws SQLException {
        String sql = "SELECT id_semestre FROM semestre WHERE nombre_semestre = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre_semestre);

            try (ResultSet rsAux = ps.executeQuery()) {
                if (rsAux.next()) {
                    return rsAux.getInt("id_semestre");
                }
            }
        }

        return -1;
    }

    /* 9. Listar los planes de estudio mediante la vista */
    public ResultSet listar_PlanEstudios() throws SQLException {
        String sql = "SELECT * FROM vw_planestudios";

        st = conn.createStatement();
        rs = st.executeQuery(sql);

        return rs;
    }

    /* 10. Buscar planes de estudio */
    public ResultSet buscarPlanEstudios(String filtro) throws SQLException {
        String sql = "{CALL sp_buscar_planestudios(?)}";

        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, filtro);

        return cs.executeQuery();
    }

    /* 11. Insertar un plan de estudios */
    public void insertarPlanEstudios(
            int id_curso,
            int id_carrera,
            int id_ciclo,
            int id_semestre,
            int numero_semanas,
            double creditos,
            String observaciones,
            int HorasTeoricas,
            int HorasPracticas,
            int HorasLaboratorio,
            int HorasSemal,
            int TotalHoras) throws SQLException {

        String sql = "{CALL sp_insertar_planestudios(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_curso);
            cs.setInt(2, id_carrera);
            cs.setInt(3, id_ciclo);
            cs.setInt(4, id_semestre);
            cs.setInt(5, numero_semanas);
            cs.setDouble(6, creditos);
            cs.setString(7, observaciones);
            cs.setInt(8, HorasTeoricas);
            cs.setInt(9, HorasPracticas);
            cs.setInt(10, HorasLaboratorio);
            cs.setInt(11, HorasSemal);
            cs.setInt(12, TotalHoras);

            cs.execute();
        }
    }

    /* 12. Modificar un plan de estudios */
    public void modificarPlanEstudios(
            int id_plan_estudios,
            int id_curso,
            int id_carrera,
            int id_ciclo,
            int id_semestre,
            int numero_semanas,
            double creditos,
            String observaciones,
            int HorasTeoricas,
            int HorasPracticas,
            int HorasLaboratorio,
            int HorasSemal,
            int TotalHoras) throws SQLException {

        String sql = "{CALL sp_modificar_planestudios(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_plan_estudios);
            cs.setInt(2, id_curso);
            cs.setInt(3, id_carrera);
            cs.setInt(4, id_ciclo);
            cs.setInt(5, id_semestre);
            cs.setInt(6, numero_semanas);
            cs.setDouble(7, creditos);
            cs.setString(8, observaciones);
            cs.setInt(9, HorasTeoricas);
            cs.setInt(10, HorasPracticas);
            cs.setInt(11, HorasLaboratorio);
            cs.setInt(12, HorasSemal);
            cs.setInt(13, TotalHoras);

            cs.execute();
        }
    }

    /* 13. Dar de baja un plan de estudios */
    public void darDeBajaPlanEstudios(int id_plan_estudios) throws SQLException {
        String sql = "{CALL sp_dar_baja_planestudios(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_plan_estudios);
            cs.execute();
        }
    }

    public void cerrarConexion() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("conexion cerrada correctamente");
        } catch (SQLException e) {
            System.out.println("error al cerrar la conexion");
        }
    }

//**Metodo opcional:permite obtener el objeto Connection si se requiere
    public Connection getConexion() {
        return conn;
    }
}
