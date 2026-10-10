package BDacademico;
import java.sql.*;
/**
 *
 * @author MIGUEL CORONADO
 */
public class Conexion_alexander {
      private Connection conn;
    private Statement st;
    private ResultSet rs;
    //parametros de conexion
    private static final String URL = "jdbc:mysql://localhost:3306/BdAcademico";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
     public Conexion_alexander() {
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
/*===============================================================
TABLA CARRERA
=================================================================*/
     public ResultSet listarCarreras() throws SQLException {
        String sql = "SELECT*FROM view_carrera";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

   
     public ResultSet buscarCarrera(String nombre) throws SQLException {
    
    // Llamada al procedimiento almacenado
    String sql = "{CALL sp_carrera_buscar(?)}";
    
    // Crear CallableStatement
    CallableStatement cs = conn.prepareCall(sql);
    
    // Enviar el nombre de la carrera como parámetro
    cs.setString(1, nombre);
    
    // Ejecutar procedimiento y obtener resultados
    rs = cs.executeQuery();
    
    return rs;
}

     public void insertarCarrera(String nombre_carrera, String descripcion) throws SQLException {
         String sql = "{CALL sp_carrera_insertar(?,?)}";
          try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, nombre_carrera);
             cs.setString(2, descripcion);
            cs.execute();
            System.out.println("Carrera insertada correctamente...!");
        }
     }
     
      public void modificarCarrera(int codigo, String nuevoNombre, String nuevaDescripcion) throws SQLException {
        String sql = "{CALL sp_carrera_actualizar(?, ?, ?)}";
        // Usamos CallableStatement en lugar de PreparedStatement para llamadas a SPs
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, nuevoNombre);
            cs.setString(3, nuevaDescripcion);
            cs.executeUpdate();
            System.out.println("carrera modificada correctamente...!");
        }
    }
      /*========================================================
      TABLA MODALIDAD
      ==========================================================*/
      public ResultSet listarModalidades() throws SQLException {
    String sql = "SELECT * FROM vista_modalidades";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}


public ResultSet buscarModalidad(String modalidad) throws SQLException {

    String sql = "{CALL sp_modalidad_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setString(1, modalidad);

    rs = cs.executeQuery();

    return rs;
}


public void insertarModalidad(String modalidad) throws SQLException {

    String sql = "{CALL sp_modalidad_insertar(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setString(1, modalidad);

        cs.execute();

        System.out.println("Modalidad insertada correctamente...!");
    }
}


public void modificarModalidad(
        int codigo,
        String modalidad) throws SQLException {

    String sql = "{CALL sp_modalidad_actualizar(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, codigo);
        cs.setString(2, modalidad);

        cs.executeUpdate();

        System.out.println("Modalidad modificada correctamente...!");
    }
}
/*===============================================================
TABLA AULA
=================================================================*/
public ResultSet listarAulas() throws SQLException {
    String sql = "SELECT * FROM vista_aulas";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

public ResultSet buscarAula(String aula) throws SQLException {
    String sql = "{CALL sp_aula_buscar(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, aula);
    rs = cs.executeQuery();
    return rs;
}

public void insertarAula(String aula) throws SQLException {
    String sql = "{CALL sp_aula_insertar(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setString(1, aula);
        cs.execute();

        System.out.println("Aula insertada correctamente...!");
    }
}

public void modificarAula(int codigo, String aula) throws SQLException {
    String sql = "{CALL sp_aula_actualizar(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, codigo);
        cs.setString(2, aula);
        cs.executeUpdate();

        System.out.println("Aula modificada correctamente...!");
    }
}
/*===============================================================
TABLA CONDICION
=================================================================*/
/* 1. Método para listar condiciones */
public ResultSet listarCondiciones() throws SQLException {
    String sql = "SELECT * FROM vista_condiciones";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 2. Método para buscar condiciones */
public ResultSet buscarCondicion(String condicion) throws SQLException {
    String sql = "{CALL sp_condicion_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, condicion);
    rs = cs.executeQuery();

    return rs;
}

/* 3. Método para insertar condiciones */
public void insertarCondicion(String condicion) throws SQLException {
    String sql = "{CALL sp_condicion_insertar(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setString(1, condicion);
        cs.execute();

        System.out.println("Condición insertada correctamente...!");
    }
}

/* 4. Método para modificar condiciones */
public void modificarCondicion(int codigo, String condicion) throws SQLException {
    String sql = "{CALL sp_condicion_actualizar(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, codigo);
        cs.setString(2, condicion);
        cs.execute();

        System.out.println("Condición modificada correctamente...!");
    }
}
/*===============================================================
TABLA TURNO
=================================================================*/
/* 1. Método para listar turnos */
public ResultSet listarTurnos() throws SQLException {
    String sql = "SELECT * FROM vista_turnos";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 2. Método para buscar turnos */
public ResultSet buscarTurno(String turno) throws SQLException {
    String sql = "{CALL sp_turno_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, turno);
    rs = cs.executeQuery();

    return rs;
}

/* 3. Método para insertar turnos */
public void insertarTurno(String turno) throws SQLException {
    String sql = "{CALL sp_turno_insertar(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setString(1, turno);
        cs.execute();

        System.out.println("Turno insertado correctamente...!");
    }
}

/* 4. Método para modificar turnos */
public void modificarTurno(int codigo, String turno) throws SQLException {
    String sql = "{CALL sp_turno_actualizar(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, codigo);
        cs.setString(2, turno);
        cs.execute();

        System.out.println("Turno modificado correctamente...!");
    }
}
/* ==============================================================
TABLA APODERADO
 ================================================================*/

/* 1. Listar apoderados */
public ResultSet listarApoderados() throws SQLException {

    String sql = "SELECT * FROM vista_apoderado";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 2. Insertar apoderado */
public void insertarApoderado(
        String dni,
        String nombres,
        String apellidos,
        String direccion,
        String correo,
        int idGenero,
        String otroContacto) throws SQLException {

    String sql = "{CALL sp_apoderado_insertar(?,?,?,?,?,?,?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setString(1, dni);
        cs.setString(2, nombres);
        cs.setString(3, apellidos);
        cs.setString(4, direccion);
        cs.setString(5, correo);
        cs.setInt(6, idGenero);
        cs.setString(7, otroContacto);

        cs.execute();

        System.out.println(
                "Apoderado insertado correctamente...!"
        );
    }
}


/* 3. Modificar apoderado */
public void modificarApoderado(
        int idApoderado,
        String dni,
        String nombres,
        String apellidos,
        String direccion,
        String correo,
        int idGenero,
        String otroContacto) throws SQLException {

    String sql = "{CALL sp_apoderado_actualizar(?,?,?,?,?,?,?,?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idApoderado);
        cs.setString(2, dni);
        cs.setString(3, nombres);
        cs.setString(4, apellidos);
        cs.setString(5, direccion);
        cs.setString(6, correo);
        cs.setInt(7, idGenero);
        cs.setString(8, otroContacto);

        cs.executeUpdate();

        System.out.println(
                "Apoderado modificado correctamente...!"
        );
    }
}


/* 4. Buscar apoderado */
public ResultSet buscarApoderados(
        String apellidos) throws SQLException {

    String sql = "{CALL sp_apoderado_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setString(1, apellidos);

    rs = cs.executeQuery();

    return rs;
}


/* 5. Cargar géneros en el JComboBox */
public ResultSet combobox_ListarGenerosApoderado()
        throws SQLException {

    String sql = "SELECT nombre_genero "
               + "FROM genero "
               + "ORDER BY nombre_genero";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 6. Obtener ID del género por nombre */
public int obtenerIdGeneroPorNombre_Apoderado(
        String nombreGenero) throws SQLException {

    String sql = "SELECT id_genero "
               + "FROM genero "
               + "WHERE nombre_genero = ?";

    try (PreparedStatement ps =
            conn.prepareStatement(sql)) {

        ps.setString(1, nombreGenero);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id_genero");
            }
        }
    }

    return 0;
}

//=============================METODOS PARA TABLA ESTUDIANTES============================================
/* 1. Listar estudiantes activos */
public ResultSet listarEstudiantesActivos() throws SQLException {

    String sql = "SELECT * FROM vista_estudiantes_activos";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 2. Insertar estudiante */
public void insertarEstudiante(
        int idDistrito,
        String dni,
        String nombres,
        String apellidos,
        int idGenero,
        String correo1,
        String correo2,
        String telefono1,
        String telefono2,
        int idProcedencia,
        int idCondicion,
        int idApoderado) throws SQLException {

    String sql = "{CALL sp_estudiante_insertar(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idDistrito);
        cs.setString(2, dni);
        cs.setString(3, nombres);
        cs.setString(4, apellidos);
        cs.setInt(5, idGenero);

        // Fecha de nacimiento
        cs.setNull(6, java.sql.Types.DATE);

        cs.setString(7, correo1);
        cs.setString(8, correo2);
        cs.setString(9, telefono1);
        cs.setString(10, telefono2);
        cs.setInt(11, idProcedencia);
        cs.setInt(12, idCondicion);

        if (idApoderado > 0) {
            cs.setInt(13, idApoderado);
        } else {
            cs.setNull(13, java.sql.Types.INTEGER);
        }

        cs.execute();

        System.out.println("Estudiante insertado correctamente...!");
    }
}



/* 3. Modificar estudiante */
public void modificarEstudiante(
        int idEstudiante,
        int idDistrito,
        String dni,
        String nombres,
        String apellidos,
        int idGenero,
        String correo1,
        String correo2,
        String telefono1,
        String telefono2,
        int idProcedencia,
        int idCondicion,
        int idApoderado) throws SQLException {

    String sql = "{CALL sp_estudiante_actualizar(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idEstudiante);
        cs.setInt(2, idDistrito);
        cs.setString(3, dni);
        cs.setString(4, nombres);
        cs.setString(5, apellidos);
        cs.setInt(6, idGenero);

        // Fecha de nacimiento
        cs.setNull(7, java.sql.Types.DATE);

        cs.setString(8, correo1);
        cs.setString(9, correo2);
        cs.setString(10, telefono1);
        cs.setString(11, telefono2);
        cs.setInt(12, idProcedencia);
        cs.setInt(13, idCondicion);

        if (idApoderado > 0) {
            cs.setInt(14, idApoderado);
        } else {
            cs.setNull(14, java.sql.Types.INTEGER);
        }

        cs.executeUpdate();

        System.out.println(
                "Estudiante modificado correctamente...!"
        );
    }
}


/* 4. Dar de baja estudiante */
public void darBajaEstudiante(
        int idEstudiante) throws SQLException {

    String sql = "{CALL sp_estudiante_dar_baja(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idEstudiante);

        cs.executeUpdate();

        System.out.println(
                "Estudiante dado de baja correctamente...!"
        );
    }
}


/* 5. Buscar estudiante */
public ResultSet buscarEstudiantes(
        String busqueda) throws SQLException {

    String sql = "{CALL sp_estudiante_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setString(1, busqueda);

    rs = cs.executeQuery();

    return rs;
}


/* 6. Cargar géneros en el JComboBox */
public ResultSet combobox_ListarGenerosEstudiante()
        throws SQLException {

    String sql = "SELECT nombre_genero "
               + "FROM genero "
               + "ORDER BY nombre_genero";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 7. Obtener ID del género por nombre */
public int obtenerIdGeneroPorNombre_Estudiante(
        String nombreGenero) throws SQLException {

    String sql = "SELECT id_genero "
               + "FROM genero "
               + "WHERE nombre_genero = ?";

    try (PreparedStatement ps =
            conn.prepareStatement(sql)) {

        ps.setString(1, nombreGenero);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id_genero");
            }
        }
    }

    return 0;
}


/* 8. Cargar procedencias en el JComboBox */
public ResultSet combobox_ListarProcedenciasEstudiante()
        throws SQLException {

    String sql = "SELECT descripcion "
               + "FROM procedencia "
               + "ORDER BY descripcion";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 9. Obtener ID de procedencia por descripción */
public int obtenerIdProcedenciaPorDescripcion_Estudiante(
        String descripcion) throws SQLException {

    String sql = "SELECT id_procedencia "
               + "FROM procedencia "
               + "WHERE descripcion = ?";

    try (PreparedStatement ps =
            conn.prepareStatement(sql)) {

        ps.setString(1, descripcion);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id_procedencia");
            }
        }
    }

    return 0;
}


/* 10. Cargar condiciones en el JComboBox */
public ResultSet combobox_ListarCondicionesEstudiante()
        throws SQLException {

    String sql = "SELECT nombre_condicion "
               + "FROM condicion "
               + "ORDER BY nombre_condicion";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 11. Obtener ID de condición por nombre */
public int obtenerIdCondicionPorNombre_Estudiante(
        String nombreCondicion) throws SQLException {

    String sql = "SELECT id_condicion "
               + "FROM condicion "
               + "WHERE nombre_condicion = ?";

    try (PreparedStatement ps =
            conn.prepareStatement(sql)) {

        ps.setString(1, nombreCondicion);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id_condicion");
            }
        }
    }

    return 0;
}
/* 12. Cargar distritos en el JComboBox */
public ResultSet combobox_ListarDistritosEstudiante()
        throws SQLException {

    String sql = "SELECT nombre_distrito "
               + "FROM distrito "
               + "ORDER BY nombre_distrito";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 13. Obtener ID del distrito por nombre */
public int obtenerIdDistritoPorNombre_Estudiante(
        String nombreDistrito) throws SQLException {

    String sql = "SELECT id_distrito "
               + "FROM distrito "
               + "WHERE nombre_distrito = ?";

    try (PreparedStatement ps =
            conn.prepareStatement(sql)) {

        ps.setString(1, nombreDistrito);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id_distrito");
            }
        }
    }

    return 0;
}


/* 14. Cargar apoderados en el JComboBox */
public ResultSet combobox_ListarApoderadosEstudiante()
        throws SQLException {

    String sql = "SELECT CONCAT(nombres, ' ', apellidos) AS apoderado "
               + "FROM apoderado "
               + "ORDER BY apellidos, nombres";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 15. Obtener ID del apoderado por nombre */
public int obtenerIdApoderadoPorNombre_Estudiante(
        String nombreApoderado) throws SQLException {

    String sql = "SELECT id_apoderado "
               + "FROM apoderado "
               + "WHERE CONCAT(nombres, ' ', apellidos) = ?";

    try (PreparedStatement ps =
            conn.prepareStatement(sql)) {

        ps.setString(1, nombreApoderado);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id_apoderado");
            }
        }
    }

    return 0;
}
/* 1. Obtener nombre del distrito por ID */
public String obtenerNombreDistritoPorId_Estudiante(
        int idDistrito) throws SQLException {

    String sql = "SELECT nombre_distrito "
               + "FROM distrito "
               + "WHERE id_distrito = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idDistrito);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("nombre_distrito");
            }
        }
    }

    return "";
}


/* 2. Obtener nombre del género por ID */
public String obtenerNombreGeneroPorId_Estudiante(
        int idGenero) throws SQLException {

    String sql = "SELECT nombre_genero "
               + "FROM genero "
               + "WHERE id_genero = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idGenero);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("nombre_genero");
            }
        }
    }

    return "";
}


/* 3. Obtener descripción de procedencia por ID */
public String obtenerDescripcionProcedenciaPorId_Estudiante(
        int idProcedencia) throws SQLException {

    String sql = "SELECT descripcion "
               + "FROM procedencia "
               + "WHERE id_procedencia = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idProcedencia);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("descripcion");
            }
        }
    }

    return "";
}


/* 4. Obtener nombre de condición por ID */
public String obtenerNombreCondicionPorId_Estudiante(
        int idCondicion) throws SQLException {

    String sql = "SELECT nombre_condicion "
               + "FROM condicion "
               + "WHERE id_condicion = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idCondicion);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("nombre_condicion");
            }
        }
    }

    return "";
}


/* 5. Obtener nombre del apoderado por ID */
public String obtenerNombreApoderadoPorId_Estudiante(
        int idApoderado) throws SQLException {

    String sql = "SELECT CONCAT(nombres, ' ', apellidos) AS apoderado "
               + "FROM apoderado "
               + "WHERE id_apoderado = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idApoderado);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getString("apoderado");
            }
        }
    }

    return "";
}
      
/* ===================== TABLA HORARIO ===================== */

/* 1. Cargar los detalles de matrícula al JComboBox */
public ResultSet combobox_listarDetalleMatricula() throws SQLException {
    String sql = "SELECT id_detalle_matricula, observaciones "
               + "FROM detalle_matricula "
               + "ORDER BY id_detalle_matricula";

    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;

}

/* 2. Obtener el código del detalle de matrícula */
public int obtener_codigoDetalleMatricula(int idDetalleMatricula)
        throws SQLException {

    String sql = "SELECT id_detalle_matricula "
               + "FROM detalle_matricula "
               + "WHERE id_detalle_matricula = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idDetalleMatricula);

        try (ResultSet rsAux = ps.executeQuery()) {
            if (rsAux.next()) {
                return rsAux.getInt("id_detalle_matricula");
            }
        }
    }

    return -1;
}

/* 3. Cargar los pabellones al JComboBox */
public ResultSet combobox_listarPabellon() throws SQLException {
    String sql = "SELECT id_pabellon, nombre_pabellon "
               + "FROM pabellon ORDER BY nombre_pabellon";

    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 4. Obtener el código del pabellón por su nombre */
public int obtener_codigoPabellon(String nombrePabellon)
        throws SQLException {

    String sql = "SELECT id_pabellon FROM pabellon "
               + "WHERE nombre_pabellon = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nombrePabellon);

        try (ResultSet rsAux = ps.executeQuery()) {
            if (rsAux.next()) {
                return rsAux.getInt("id_pabellon");
            }
        }
    }

    return -1;
}

/* 5. Cargar las aulas al JComboBox */
public ResultSet combobox_listarAula() throws SQLException {
    String sql = "SELECT id_aula, numero FROM aula ORDER BY numero";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;

}

/* 6. Obtener el código del aula por su número */
public int obtener_codigoAula(String numero)
        throws SQLException {

    String sql = "SELECT id_aula FROM aula WHERE numero = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, numero);

        try (ResultSet rsAux = ps.executeQuery()) {
            if (rsAux.next()) {
                return rsAux.getInt("id_aula");
            }
        }
    }

    return -1;
}

/* 7. Cargar los días al JComboBox */
public ResultSet combobox_listarDias() throws SQLException {
    String sql = "SELECT id_dia, nombre_dia "
               + "FROM dias ORDER BY id_dia";

    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 8. Obtener el código del día por su nombre */
public int obtener_codigoDia(String nombreDia)
        throws SQLException {

    String sql = "SELECT id_dia FROM dias WHERE nombre_dia = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, nombreDia);

        try (ResultSet rsAux = ps.executeQuery()) {
            if (rsAux.next()) {
                return rsAux.getInt("id_dia");
            }
        }
    }

    return -1;
}


/* 9. Listar los horarios */
public ResultSet listar_Horarios() throws SQLException {
    String sql = "SELECT * FROM vw_horarios";

    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}


/* 10. Buscar horarios */
public ResultSet buscarHorario(String filtro) throws SQLException {
    String sql = "{CALL sp_horario_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, filtro);

    return cs.executeQuery();
}


/* 11. Insertar horario */
public void insertarHorario(
        int idDetalleMatricula,
        int idPabellon,
        int idAula,
        int idDia,
        java.sql.Date fecha,
        java.sql.Time horaInicio,
        java.sql.Time horaFin,
        double totalHoras,
        String descripcion) throws SQLException {

    String sql = "{CALL sp_horario_insertar(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, idDetalleMatricula);
        cs.setInt(2, idPabellon);
        cs.setInt(3, idAula);
        cs.setInt(4, idDia);
        cs.setDate(5, fecha);
        cs.setTime(6, horaInicio);
        cs.setTime(7, horaFin);
        cs.setDouble(8, totalHoras);
        cs.setString(9, descripcion);

        cs.execute();
    }
}


/* 12. Modificar horario */
public void modificarHorario(
        int idHorario,
        int idDetalleMatricula,
        int idPabellon,
        int idAula,
        int idDia,
        java.sql.Date fecha,
        java.sql.Time horaInicio,
        java.sql.Time horaFin,
        double totalHoras,
        String descripcion) throws SQLException {

    String sql = "{CALL sp_horario_modificar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, idHorario);
        cs.setInt(2, idDetalleMatricula);
        cs.setInt(3, idPabellon);
        cs.setInt(4, idAula);
        cs.setInt(5, idDia);
        cs.setDate(6, fecha);
        cs.setTime(7, horaInicio);
        cs.setTime(8, horaFin);
        cs.setDouble(9, totalHoras);
        cs.setString(10, descripcion);

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
     
     public Connection getConexion() {
        return conn;
}
}