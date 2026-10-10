--===================================================================================
-- 1. Procedure para insertar a la tabla carrera
DROP PROCEDURE IF EXISTS sp_carrera_insertar;
DELIMITER $$

CREATE PROCEDURE sp_carrera_insertar(
    IN p_nombreCarrera VARCHAR(100),
    IN p_descripcion VARCHAR(255)
)
BEGIN
    DECLARE v_nombreLim VARCHAR(100);
    DECLARE v_descripcionLim VARCHAR(255);

    -- Limpiar espacios
    SET v_nombreLim = TRIM(p_nombreCarrera);
    SET v_descripcionLim = TRIM(p_descripcion);

    -- Validar nombre
    IF v_nombreLim = '' OR v_nombreLim IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre de la carrera no puede estar vacío.';
    END IF;

    -- Verificar si ya existe
    IF EXISTS (
        SELECT 1
        FROM carrera
        WHERE nombre_carrera = v_nombreLim
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La carrera ya existe, no se puede insertar un duplicado.';
    END IF;

    -- Insertar carrera
    INSERT INTO carrera (nombre_carrera, descripcion)
    VALUES (v_nombreLim, v_descripcionLim);

END$$

DELIMITER ;

-- Ejemplo de uso
CALL sp_carrera_insertar(
    'Ingeniería de Software',
    'Carrera profesional orientada al desarrollo de software.'
);
--==================================================================================
-- 2. Procedure para modificar una carrera
DROP PROCEDURE IF EXISTS sp_carrera_actualizar;
DELIMITER //

CREATE PROCEDURE sp_carrera_actualizar(
    IN p_idCarrera INT,
    IN p_nuevoNombre VARCHAR(100),
    IN p_nuevaDescripcion VARCHAR(255)
)
BEGIN
    DECLARE v_nombreLim VARCHAR(100);
    DECLARE v_descripcionLim VARCHAR(255);

    -- Limpiar espacios
    SET v_nombreLim = TRIM(p_nuevoNombre);
    SET v_descripcionLim = TRIM(p_nuevaDescripcion);

    -- 1. Validar código
    IF p_idCarrera <= 0 OR p_idCarrera IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código de la carrera no es válido.';
    END IF;

    -- 2. Validar nombre
    IF v_nombreLim = '' OR v_nombreLim IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre de la carrera no puede estar vacío.';
    END IF;

    -- 3. Verificar que exista
    IF NOT EXISTS (
        SELECT 1
        FROM carrera
        WHERE id_carrera = p_idCarrera
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La carrera que intenta modificar no existe.';
    END IF;

    -- 4. Verificar que no exista otra carrera con el mismo nombre
    IF EXISTS (
        SELECT 1
        FROM carrera
        WHERE nombre_carrera = v_nombreLim
        AND id_carrera != p_idCarrera
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe otra carrera registrada con ese mismo nombre.';
    ELSE
        -- Actualizar
        UPDATE carrera
        SET nombre_carrera = v_nombreLim,
            descripcion = v_descripcionLim
        WHERE id_carrera = p_idCarrera;
    END IF;

END //

DELIMITER ;

-- Ejemplo de uso
CALL sp_carrera_actualizar(
    1,
    'Ingeniería de Sistemas',
    'Carrera profesional especializada en sistemas informáticos.'
);
--========================================================================
--proceso para buscar carrera
DROP PROCEDURE IF EXISTS sp_carrera_buscar;
DELIMITER //

CREATE PROCEDURE sp_carrera_buscar(
    IN p_nombreCarrera VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_nombreCarrera);

    SELECT
        id_carrera,
        nombre_carrera,
        descripcion
    FROM carrera
    WHERE v_filtro = ''
       OR nombre_carrera LIKE CONCAT('%', v_filtro, '%')
    ORDER BY id_carrera;
END //

DELIMITER ;
--=====================MODALIDAD====================================
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_modalidad_buscar;

DELIMITER //

CREATE PROCEDURE sp_modalidad_buscar(
    IN p_modalidad VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_modalidad);

    SELECT
        codigo,
        modalidad
    FROM vista_modalidades
    WHERE v_filtro = ''
       OR modalidad LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
--proceso para insertar
DROP PROCEDURE IF EXISTS sp_modalidad_insertar;

DELIMITER //

CREATE PROCEDURE sp_modalidad_insertar(
    IN p_modalidad VARCHAR(100)
)
BEGIN
    INSERT INTO modalidad (
        nombre_modalidad
    )
    VALUES (
        TRIM(p_modalidad)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_modalidad_actualizar;

DELIMITER //

CREATE PROCEDURE sp_modalidad_actualizar(
    IN p_codigo INT,
    IN p_modalidad VARCHAR(100)
)
BEGIN
    UPDATE modalidad
    SET nombre_modalidad = TRIM(p_modalidad)
    WHERE id_modalidad = p_codigo;
END //

DELIMITER ;
--=====================AULAS========================================
--proceso para guardar
DROP PROCEDURE IF EXISTS sp_aula_insertar;

DELIMITER //

CREATE PROCEDURE sp_aula_insertar(
    IN p_numero VARCHAR(100)
)
BEGIN
    INSERT INTO aula (
        numero
    )
    VALUES (
        TRIM(p_numero)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_aula_actualizar;

DELIMITER //

CREATE PROCEDURE sp_aula_actualizar(
    IN p_codigo INT,
    IN p_numero VARCHAR(100)
)
BEGIN
    UPDATE aula
    SET numero = TRIM(p_numero)
    WHERE id_aula = p_codigo;
END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_aula_buscar;

DELIMITER //

CREATE PROCEDURE sp_aula_buscar(
    IN p_aula VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_aula);

    SELECT
        codigo,
        aula
    FROM vista_aulas
    WHERE v_filtro = ''
       OR aula LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
--=====================CONDICION====================================
--proceso para insertar
DROP PROCEDURE IF EXISTS sp_condicion_insertar;

DELIMITER //

CREATE PROCEDURE sp_condicion_insertar(
    IN p_condicion VARCHAR(100)
)
BEGIN
    IF p_condicion IS NULL OR TRIM(p_condicion) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese el nombre de la condición';
    END IF;

    INSERT INTO condicion (
        nombre_condicion
    )
    VALUES (
        TRIM(p_condicion)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_condicion_actualizar;

DELIMITER //

CREATE PROCEDURE sp_condicion_actualizar(
    IN p_codigo INT,
    IN p_condicion VARCHAR(100)
)
BEGIN
    IF p_codigo IS NULL OR p_codigo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código de la condición no es válido';
    END IF;

    IF p_condicion IS NULL OR TRIM(p_condicion) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese el nombre de la condición';
    END IF;

    UPDATE condicion
    SET nombre_condicion = TRIM(p_condicion)
    WHERE id_condicion = p_codigo;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se encontró la condición o no hubo cambios';
    END IF;
END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_condicion_buscar;

DELIMITER //

CREATE PROCEDURE sp_condicion_buscar(
    IN p_condicion VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_condicion);

    SELECT
        codigo,
        condicion
    FROM vista_condiciones
    WHERE v_filtro = ''
       OR condicion LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
/*=============================TURNO========================================*/
--proceso para guardar
DROP PROCEDURE IF EXISTS sp_turno_insertar;

DELIMITER //

CREATE PROCEDURE sp_turno_insertar(
    IN p_turno VARCHAR(100)
)
BEGIN
    IF p_turno IS NULL OR TRIM(p_turno) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese la descripción del turno';
    END IF;

    INSERT INTO turno (
        descripcion
    )
    VALUES (
        TRIM(p_turno)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_turno_actualizar;

DELIMITER //

CREATE PROCEDURE sp_turno_actualizar(
    IN p_codigo INT,
    IN p_turno VARCHAR(100)
)
BEGIN
    IF p_codigo IS NULL OR p_codigo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código del turno no es válido';
    END IF;

    IF p_turno IS NULL OR TRIM(p_turno) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese la descripción del turno';
    END IF;

    UPDATE turno
    SET descripcion = TRIM(p_turno)
    WHERE id_turno = p_codigo;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se encontró el turno o no hubo cambios';
    END IF;
END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_turno_buscar;

DELIMITER //

CREATE PROCEDURE sp_turno_buscar(
    IN p_turno VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_turno);

    SELECT
        codigo,
        turno
    FROM vista_turnos
    WHERE v_filtro = ''
       OR turno LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
--======================HORARIO======================================
--proceso para insertar

DROP PROCEDURE IF EXISTS sp_horario_insertar;

DELIMITER $$

CREATE PROCEDURE sp_horario_insertar(
    IN p_id_detalle_matricula INT,
    IN p_id_pabellon INT,
    IN p_id_aula INT,
    IN p_id_dia INT,
    IN p_fecha DATE,
    IN p_hora_inicio TIME,
    IN p_hora_fin TIME,
    IN p_total_horas DECIMAL(10,2),
    IN p_descripcion VARCHAR(200)
)
BEGIN
    IF p_hora_fin <= p_hora_inicio THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La hora final debe ser posterior a la hora inicial';
    ELSE
        INSERT INTO horario (
            id_detalle_matricula,
            id_pabellon,
            id_aula,
            id_dia,
            fecha,
            hora_inicio,
            hora_fin,
            total_horas,
            descripcion
        )
        VALUES (
            p_id_detalle_matricula,
            p_id_pabellon,
            p_id_aula,
            p_id_dia,
            p_fecha,
            p_hora_inicio,
            p_hora_fin,
            p_total_horas,
            p_descripcion
        );
    END IF;
END $$

DELIMITER ;
--proceso para buscar

DROP PROCEDURE IF EXISTS sp_horario_buscar;

DELIMITER $$

CREATE PROCEDURE sp_horario_buscar(
    IN p_busqueda VARCHAR(100)
)
BEGIN
    SELECT
        id_horario,
        id_detalle_matricula,
        id_pabellon,
        id_aula,
        id_dia,
        fecha,
        hora_inicio,
        hora_fin,
        total_horas,
        descripcion
    FROM horario
    WHERE
        COALESCE(TRIM(p_busqueda), '') = ''
        OR CAST(id_horario AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(id_detalle_matricula AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(id_pabellon AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(id_aula AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(id_dia AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(fecha AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(hora_inicio AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(hora_fin AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR CAST(total_horas AS CHAR) LIKE CONCAT('%', TRIM(p_busqueda), '%')
        OR descripcion LIKE CONCAT('%', TRIM(p_busqueda), '%')
    ORDER BY id_horario DESC;
END $$

DELIMITER ;
--proceso para modificar 

DROP PROCEDURE IF EXISTS sp_horario_modificar;

DELIMITER $$

CREATE PROCEDURE sp_horario_modificar(
    IN p_id_horario INT,
    IN p_id_detalle_matricula INT,
    IN p_id_pabellon INT,
    IN p_id_aula INT,
    IN p_id_dia INT,
    IN p_fecha DATE,
    IN p_hora_inicio TIME,
    IN p_hora_fin TIME,
    IN p_total_horas DECIMAL(10,2),
    IN p_descripcion VARCHAR(200)
)
BEGIN
    IF p_hora_fin <= p_hora_inicio THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La hora final debe ser posterior a la hora inicial';
    ELSE
        UPDATE horario
        SET
            id_detalle_matricula = p_id_detalle_matricula,
            id_pabellon = p_id_pabellon,
            id_aula = p_id_aula,
            id_dia = p_id_dia,
            fecha = p_fecha,
            hora_inicio = p_hora_inicio,
            hora_fin = p_hora_fin,
            total_horas = p_total_horas,
            descripcion = p_descripcion
        WHERE id_horario = p_id_horario;
    END IF;
END $$

DELIMITER ;






--=====================APODERADO====================================
--insertar apoderado
DROP PROCEDURE IF EXISTS sp_apoderado_insertar;

DELIMITER //

CREATE PROCEDURE sp_apoderado_insertar(
    IN p_dni VARCHAR(15),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_direccion_actual VARCHAR(200),
    IN p_correo VARCHAR(150),
    IN p_id_genero INT,
    IN p_otro_contacto VARCHAR(100)
)
BEGIN

    IF TRIM(p_dni) = '' OR p_dni IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El DNI es obligatorio';
    END IF;

    IF TRIM(p_nombres) = '' OR p_nombres IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Los nombres son obligatorios';
    END IF;

    IF TRIM(p_apellidos) = '' OR p_apellidos IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Los apellidos son obligatorios';
    END IF;

    IF p_id_genero IS NULL OR p_id_genero <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Debe seleccionar un género';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM apoderado
        WHERE dni = TRIM(p_dni)
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El DNI del apoderado ya existe';
    END IF;

    INSERT INTO apoderado(
        dni,
        nombres,
        apellidos,
        direccion_actual,
        correo,
        id_genero,
        otro_contacto
    )
    VALUES(
        TRIM(p_dni),
        TRIM(p_nombres),
        TRIM(p_apellidos),
        TRIM(p_direccion_actual),
        TRIM(p_correo),
        p_id_genero,
        TRIM(p_otro_contacto)
    );

END //

DELIMITER ;
--Proceso de actualizar
DROP PROCEDURE IF EXISTS sp_apoderado_actualizar;

DELIMITER //

CREATE PROCEDURE sp_apoderado_actualizar(
    IN p_id_apoderado INT,
    IN p_dni VARCHAR(15),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_direccion_actual VARCHAR(200),
    IN p_correo VARCHAR(150),
    IN p_id_genero INT,
    IN p_otro_contacto VARCHAR(100)
)
BEGIN

    IF p_id_apoderado IS NULL OR p_id_apoderado <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Código de apoderado inválido';
    END IF;

    IF NOT EXISTS (
        SELECT 1
        FROM apoderado
        WHERE id_apoderado = p_id_apoderado
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El apoderado no existe';
    END IF;

    IF TRIM(p_dni) = '' OR p_dni IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El DNI es obligatorio';
    END IF;

    IF TRIM(p_nombres) = '' OR p_nombres IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Los nombres son obligatorios';
    END IF;

    IF TRIM(p_apellidos) = '' OR p_apellidos IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Los apellidos son obligatorios';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM apoderado
        WHERE dni = TRIM(p_dni)
        AND id_apoderado <> p_id_apoderado
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El DNI ya pertenece a otro apoderado';
    END IF;

    UPDATE apoderado
    SET
        dni = TRIM(p_dni),
        nombres = TRIM(p_nombres),
        apellidos = TRIM(p_apellidos),
        direccion_actual = TRIM(p_direccion_actual),
        correo = TRIM(p_correo),
        id_genero = p_id_genero,
        otro_contacto = TRIM(p_otro_contacto)
    WHERE id_apoderado = p_id_apoderado;

END //

DELIMITER ;
--proceso para buscar==
DROP PROCEDURE IF EXISTS sp_apoderado_buscar;

DELIMITER //

CREATE PROCEDURE sp_apoderado_buscar(
    IN p_apellidos VARCHAR(100)
)
BEGIN

    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_apellidos);

    SELECT
        id_apoderado,
        dni,
        apellidos,
        nombres,
        direccion_actual,
        correo,
        id_genero,
        nombre_genero,
        otro_contacto
    FROM vista_apoderado
    WHERE v_filtro = ''
       OR apellidos LIKE CONCAT('%', v_filtro, '%')
    ORDER BY apellidos, nombres;

END //

DELIMITER ;
--======================procesos para el formulario de estudiantes===========================
--proceso para insertar
DROP PROCEDURE IF EXISTS sp_estudiante_insertar;

DELIMITER //

CREATE PROCEDURE sp_estudiante_insertar(
    IN p_id_distrito INT,
    IN p_dni CHAR(8),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(130),
    IN p_id_genero INT,
    IN p_fecha_nacimiento DATE,
    IN p_correo1 VARCHAR(150),
    IN p_correo2 VARCHAR(150),
    IN p_telefono1 VARCHAR(20),
    IN p_telefono2 VARCHAR(20),
    IN p_id_procedencia INT,
    IN p_id_condicion INT,
    IN p_id_apoderado INT
)
BEGIN

    INSERT INTO estudiante (
        id_distrito,
        dni,
        nombres,
        apellidos,
        id_genero,
        fecha_nacimiento,
        correo1,
        correo2,
        telefono1,
        telefono2,
        id_procedencia,
        id_condicion,
        estado,
        id_apoderado
    )
    VALUES (
        p_id_distrito,
        TRIM(p_dni),
        TRIM(p_nombres),
        TRIM(p_apellidos),
        p_id_genero,
        p_fecha_nacimiento,
        TRIM(p_correo1),
        TRIM(p_correo2),
        TRIM(p_telefono1),
        TRIM(p_telefono2),
        p_id_procedencia,
        p_id_condicion,
        1,
        p_id_apoderado
    );

END //

DELIMITER ;
--proceso para modificar/actualizar
DROP PROCEDURE IF EXISTS sp_estudiante_actualizar;

DELIMITER //

CREATE PROCEDURE sp_estudiante_actualizar(
    IN p_id_estudiante INT,
    IN p_id_distrito INT,
    IN p_dni CHAR(8),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(130),
    IN p_id_genero INT,
    IN p_fecha_nacimiento DATE,
    IN p_correo1 VARCHAR(150),
    IN p_correo2 VARCHAR(150),
    IN p_telefono1 VARCHAR(20),
    IN p_telefono2 VARCHAR(20),
    IN p_id_procedencia INT,
    IN p_id_condicion INT,
    IN p_id_apoderado INT
)
BEGIN

    UPDATE estudiante
    SET
        id_distrito = p_id_distrito,
        dni = TRIM(p_dni),
        nombres = TRIM(p_nombres),
        apellidos = TRIM(p_apellidos),
        id_genero = p_id_genero,
        fecha_nacimiento = p_fecha_nacimiento,
        correo1 = TRIM(p_correo1),
        correo2 = TRIM(p_correo2),
        telefono1 = TRIM(p_telefono1),
        telefono2 = TRIM(p_telefono2),
        id_procedencia = p_id_procedencia,
        id_condicion = p_id_condicion,
        id_apoderado = p_id_apoderado
    WHERE id_estudiante = p_id_estudiante;

END //

DELIMITER ;
--proceso para dar de baja
DROP PROCEDURE IF EXISTS sp_estudiante_dar_baja;

DELIMITER //

CREATE PROCEDURE sp_estudiante_dar_baja(
    IN p_id_estudiante INT
)
BEGIN

    UPDATE estudiante
    SET estado = 0
    WHERE id_estudiante = p_id_estudiante;

END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_estudiante_buscar;

DELIMITER //

CREATE PROCEDURE sp_estudiante_buscar(
    IN p_busqueda VARCHAR(150)
)
BEGIN

    DECLARE v_busqueda VARCHAR(150);

    SET v_busqueda = TRIM(p_busqueda);

    SELECT
        id_estudiante,
        id_distrito,
        dni,
        nombres,
        apellidos,
        id_genero,
        fecha_nacimiento,
        correo1,
        correo2,
        telefono1,
        telefono2,
        id_procedencia,
        id_condicion,
        id_apoderado,
        estado
    FROM estudiante
    WHERE estado = 1
      AND (
            v_busqueda = ''
            OR dni LIKE CONCAT('%', v_busqueda, '%')
            OR nombres LIKE CONCAT('%', v_busqueda, '%')
            OR apellidos LIKE CONCAT('%', v_busqueda, '%')
          )
    ORDER BY apellidos, nombres;

END //

DELIMITER ;