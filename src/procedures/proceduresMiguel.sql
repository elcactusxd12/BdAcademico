/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
--==============================TABLA CARGO=========================================================
-- Procedure para insertar registros en la tabla cargo
DROP PROCEDURE IF EXISTS sp_cargo_insertar;
DELIMITER $$

CREATE PROCEDURE sp_cargo_insertar(
    IN p_nombreCargo VARCHAR(100)
)
BEGIN
    -- Declaramos la variable para limpiar el nombre
    DECLARE v_nombreLim VARCHAR(100);

    -- Quitamos espacios al inicio y al final
    SET v_nombreLim = TRIM(p_nombreCargo);

    -- Validamos que no venga vacío
    IF v_nombreLim = '' OR v_nombreLim IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del cargo no puede estar vacío.';
    END IF;

    -- Verificamos si ya existe
    IF NOT EXISTS (
        SELECT 1
        FROM cargo
        WHERE nombre_cargo = v_nombreLim
    ) THEN

        -- Insertamos el nuevo cargo
        INSERT INTO cargo (nombre_cargo, estado_cargo)
        VALUES (v_nombreLim, 1);

    ELSE

        -- Si existe, mostramos un error
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cargo ya existe, no se puede insertar un duplicado.';

    END IF;

END$$

DELIMITER ;
--=================================================================================================
-- 2.-Procedure para modificar registros de la tabla cargo
DROP PROCEDURE IF EXISTS sp_cargo_modificar;
DELIMITER $$

CREATE PROCEDURE sp_cargo_modificar(
    IN p_idCargo INT,
    IN p_nombreCargo VARCHAR(100),
    IN p_estadoCargo TINYINT
)
BEGIN
    DECLARE v_nombreLim VARCHAR(100);

    -- Limpiamos espacios
    SET v_nombreLim = TRIM(p_nombreCargo);

    -- Validamos que el nombre no esté vacío
    IF v_nombreLim = '' OR v_nombreLim IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del cargo no puede estar vacío.';
    END IF;

    -- Verificamos que el cargo exista
    IF NOT EXISTS (
        SELECT 1
        FROM cargo
        WHERE id_cargo = p_idCargo
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cargo que desea modificar no existe.';
    END IF;

    -- Verificamos que no exista otro cargo con el mismo nombre
    IF EXISTS (
        SELECT 1
        FROM cargo
        WHERE nombre_cargo = v_nombreLim
        AND id_cargo <> p_idCargo
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe otro cargo con ese nombre.';
    END IF;

    -- Validamos el estado
    IF p_estadoCargo NOT IN (0,1) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El estado debe ser 0 o 1.';
    END IF;

    -- Actualizamos el registro
    UPDATE cargo
    SET nombre_cargo = v_nombreLim,
        estado_cargo = p_estadoCargo
    WHERE id_cargo = p_idCargo;

END$$
--===================================================================================================
--desactivar registro
DELIMITER ;
DROP PROCEDURE IF EXISTS sp_cargo_desactivar;
DELIMITER //

CREATE PROCEDURE sp_cargo_desactivar(IN p_idCargo INT)
BEGIN
    -- Validar que el código sea válido antes de consultar
    IF p_idCargo <= 0 OR p_idCargo IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código del cargo no es válido.';
    END IF;

    -- 1. Verificar si el cargo existe
    IF NOT EXISTS (
        SELECT 1
        FROM cargo
        WHERE id_cargo = p_idCargo
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El código de cargo especificado no existe.';
    END IF;

    -- 2. Verificar si ya está desactivado
    IF EXISTS (
        SELECT 1
        FROM cargo
        WHERE id_cargo = p_idCargo
        AND estado_cargo = 0
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cargo ya se encuentra desactivado.';
    END IF;

    -- 3. Proceder con la desactivación lógica
    UPDATE cargo
    SET estado_cargo = 0
    WHERE id_cargo = p_idCargo;

END //

DELIMITER ;

-- Ejemplo de uso:
CALL sp_cargo_desactivar(10);
--===================================================================================
--proceso para buscar cargos
DROP PROCEDURE IF EXISTS sp_cargo_buscar;
DELIMITER //

CREATE PROCEDURE sp_cargo_buscar(IN p_nombreCargo VARCHAR(100))
BEGIN
    DECLARE v_filtro VARCHAR(100);
    SET v_filtro = TRIM(p_nombreCargo);

    SELECT 
        id_cargo,
        nombre_cargo,
        estado_cargo
    FROM vista_cargo
    WHERE (v_filtro = '' OR nombre_cargo LIKE CONCAT('%', v_filtro, '%'));
END //

DELIMITER ;

-- Ejemplo de uso:
CALL sp_cargo_buscar('administrador');
CALL sp_cargo_buscar(''); -- Devuelve todos los cargos activos

--=================================PROCESOS PARA  LA TABLA CURSO==============================================
--proceso para insertar curso
DROP PROCEDURE IF EXISTS sp_curso_insertar;
DELIMITER //

CREATE PROCEDURE sp_curso_insertar(
    IN p_nombre_curso VARCHAR(100),
    IN p_descripcion VARCHAR(255)
)
BEGIN
    DECLARE v_nombre VARCHAR(100);

    SET v_nombre = TRIM(p_nombre_curso);

    IF v_nombre IS NULL OR v_nombre = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del curso es obligatorio';
    END IF;

    IF EXISTS (
        SELECT 1 
        FROM curso 
        WHERE nombre_curso = v_nombre
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El curso ya existe';
    END IF;

    INSERT INTO curso(nombre_curso, descripcion)
    VALUES(v_nombre, TRIM(p_descripcion));
END //

DELIMITER ;
--====================================================================================
--proceso para actualizar curso
DROP PROCEDURE IF EXISTS sp_curso_actualizar;
DELIMITER //

CREATE PROCEDURE sp_curso_actualizar(
    IN p_id_curso INT,
    IN p_nuevo_nombre VARCHAR(100),
    IN p_nueva_descripcion VARCHAR(255)
)
BEGIN
    DECLARE v_nombre VARCHAR(100);

    SET v_nombre = TRIM(p_nuevo_nombre);

    IF p_id_curso IS NULL OR p_id_curso <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código del curso no es válido';
    END IF;

    IF v_nombre IS NULL OR v_nombre = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del curso es obligatorio';
    END IF;

    IF NOT EXISTS (
        SELECT 1 
        FROM curso 
        WHERE id_curso = p_id_curso
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El curso no existe';
    END IF;

    IF EXISTS (
        SELECT 1 
        FROM curso
        WHERE nombre_curso = v_nombre
          AND id_curso <> p_id_curso
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe otro curso con ese nombre';
    END IF;

    UPDATE curso
    SET nombre_curso = v_nombre,
        descripcion = TRIM(p_nueva_descripcion)
    WHERE id_curso = p_id_curso;
END //

DELIMITER ;
--===========================================================================
--proceso para buscar cursos
DROP PROCEDURE IF EXISTS sp_curso_buscar;
DELIMITER //

CREATE PROCEDURE sp_curso_buscar(
    IN p_nombre_curso VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_nombre_curso);

    SELECT
        id_curso,
        nombre_curso,
        descripcion
    FROM vista_cursos
    WHERE v_filtro = ''
       OR nombre_curso LIKE CONCAT('%', v_filtro, '%')
    ORDER BY id_curso;
END //

DELIMITER ;
--=======================PROCESOS PARA LA TABLA PABELLON======================================
--proceso para guardar
DROP PROCEDURE IF EXISTS sp_pabellon_insertar;

DELIMITER //

CREATE PROCEDURE sp_pabellon_insertar(
    IN p_pabellon VARCHAR(100)
)
BEGIN
    INSERT INTO pabellon (
        nombre_pabellon
    )
    VALUES (
        TRIM(p_pabellon)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_pabellon_actualizar;

DELIMITER //

CREATE PROCEDURE sp_pabellon_actualizar(
    IN p_codigo INT,
    IN p_pabellon VARCHAR(100)
)
BEGIN
    UPDATE pabellon
    SET nombre_pabellon = TRIM(p_pabellon)
    WHERE id_pabellon = p_codigo;
END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_pabellon_buscar;

DELIMITER //

CREATE PROCEDURE sp_pabellon_buscar(
    IN p_pabellon VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_pabellon);

    SELECT
        codigo,
        pabellon
    FROM vista_pabellones
    WHERE v_filtro = ''
       OR pabellon LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
/*==============================PROCEDENCIA======================================*/
--proceso para Guardar
DROP PROCEDURE IF EXISTS sp_procedencia_insertar;

DELIMITER //

CREATE PROCEDURE sp_procedencia_insertar(
    IN p_descripcion VARCHAR(100)
)
BEGIN
    IF p_descripcion IS NULL OR TRIM(p_descripcion) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese la descripción de la procedencia';
    END IF;

    INSERT INTO procedencia (
        descripcion
    )
    VALUES (
        TRIM(p_descripcion)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_procedencia_actualizar;

DELIMITER //

CREATE PROCEDURE sp_procedencia_actualizar(
    IN p_codigo INT,
    IN p_descripcion VARCHAR(100)
)
BEGIN
    IF p_codigo IS NULL OR p_codigo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código de la procedencia no es válido';
    END IF;

    IF p_descripcion IS NULL OR TRIM(p_descripcion) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese la descripción de la procedencia';
    END IF;

    UPDATE procedencia
    SET descripcion = TRIM(p_descripcion)
    WHERE id_procedencia = p_codigo;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se encontró la procedencia o no hubo cambios';
    END IF;
END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_procedencia_buscar;

DELIMITER //

CREATE PROCEDURE sp_procedencia_buscar(
    IN p_procedencia VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_procedencia);

    SELECT
        codigo,
        procedencia
    FROM vista_procedencias
    WHERE v_filtro = ''
       OR procedencia LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
/*===========================SEMESTRES========================================*/
--procedimiento para insertar
DROP PROCEDURE IF EXISTS sp_semestre_insertar;

DELIMITER //

CREATE PROCEDURE sp_semestre_insertar(
    IN p_semestre VARCHAR(100)
)
BEGIN
    IF p_semestre IS NULL OR TRIM(p_semestre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese el nombre del semestre';
    END IF;

    INSERT INTO semestre (
        nombre_semestre
    )
    VALUES (
        TRIM(p_semestre)
    );
END //

DELIMITER ;
--procedimiento para modificar
DROP PROCEDURE IF EXISTS sp_semestre_actualizar;

DELIMITER //

CREATE PROCEDURE sp_semestre_actualizar(
    IN p_codigo INT,
    IN p_semestre VARCHAR(100)
)
BEGIN
    IF p_codigo IS NULL OR p_codigo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código del semestre no es válido';
    END IF;

    IF p_semestre IS NULL OR TRIM(p_semestre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese el nombre del semestre';
    END IF;

    UPDATE semestre
    SET nombre_semestre = TRIM(p_semestre)
    WHERE id_semestre = p_codigo;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se encontró el semestre o no hubo cambios';
    END IF;
END //

DELIMITER ;
--procedimiento para buscar
DROP PROCEDURE IF EXISTS sp_semestre_buscar;

DELIMITER //

CREATE PROCEDURE sp_semestre_buscar(
    IN p_semestre VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_semestre);

    SELECT
        codigo,
        semestre
    FROM vista_semestres
    WHERE v_filtro = ''
       OR semestre LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
/*=========================TIPO_PAGO============================================*/
--proceso para insertar 
DROP PROCEDURE IF EXISTS sp_tipo_pago_insertar;

DELIMITER //

CREATE PROCEDURE sp_tipo_pago_insertar(
    IN p_tipo_pago VARCHAR(100)
)
BEGIN
    IF p_tipo_pago IS NULL OR TRIM(p_tipo_pago) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese el concepto del tipo de pago';
    END IF;

    INSERT INTO tipo_pago (
        concepto_pago
    )
    VALUES (
        TRIM(p_tipo_pago)
    );
END //

DELIMITER ;
--proceso para modificar
DROP PROCEDURE IF EXISTS sp_tipo_pago_actualizar;

DELIMITER //

CREATE PROCEDURE sp_tipo_pago_actualizar(
    IN p_codigo INT,
    IN p_tipo_pago VARCHAR(100)
)
BEGIN
    IF p_codigo IS NULL OR p_codigo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El código del tipo de pago no es válido';
    END IF;

    IF p_tipo_pago IS NULL OR TRIM(p_tipo_pago) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ingrese el concepto del tipo de pago';
    END IF;

    UPDATE tipo_pago
    SET concepto_pago = TRIM(p_tipo_pago)
    WHERE id_tipo_pago = p_codigo;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se encontró el tipo de pago o no hubo cambios';
    END IF;
END //

DELIMITER ;
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_tipo_pago_buscar;

DELIMITER //

CREATE PROCEDURE sp_tipo_pago_buscar(
    IN p_concepto VARCHAR(100)
)
BEGIN
    DECLARE v_filtro VARCHAR(100);

    SET v_filtro = TRIM(p_concepto);

    SELECT
        codigo,
        concepto
    FROM vista_tipos_pago
    WHERE v_filtro = ''
       OR concepto LIKE CONCAT('%', v_filtro, '%');
END //

DELIMITER ;
/*=========================LOGIN==============================================*/
/*Se considera como parametros Codigo, password,nombrecargo para el ingreso*/
DELIMITER //

DROP PROCEDURE IF EXISTS sp_validar_usuario //

CREATE PROCEDURE sp_validar_usuario(
    IN p_codigo VARCHAR(15), 
    IN p_password VARCHAR(255), 
    IN p_cargo VARCHAR(85)
)
BEGIN
    SELECT 
        u.id_usuario,
        u.codigo,
        u.password,
        c.nombre_cargo,
        CASE 
            WHEN u.estado_usuario = 1 THEN 'Activo'
            ELSE 'Inactivo'
        END AS estado_usuario
    FROM usuario u
    INNER JOIN cargo c 
        ON u.id_cargo = c.id_cargo
    WHERE u.codigo = p_codigo
      AND u.password = p_password
      AND c.nombre_cargo = p_cargo
      AND u.estado_usuario = 1;
END //

DELIMITER ;
/*Procedure para cambiar el estadousuario cuando supera los intentos*/
DELIMITER //

DROP PROCEDURE IF EXISTS sp_bloquear_usuario //

CREATE PROCEDURE sp_bloquear_usuario(
    IN p_codigo VARCHAR(15)
)
BEGIN
    UPDATE usuario
    SET estado_usuario = 0
    WHERE codigo = p_codigo;
END //

DELIMITER ;
/*========================USUARIOS=============================================*

/*1. Procedure para buscar, haciendo uso de la vista*/
DROP PROCEDURE IF EXISTS sp_buscar_usuario;
DELIMITER //

CREATE PROCEDURE sp_buscar_usuario(
    IN p_busqueda VARCHAR(100)
)
BEGIN
    SELECT
        id_usuario,
        codigo,
        password,
        nombre_cargo,
        estado_usuario
    FROM view_usuarios
    WHERE codigo LIKE CONCAT('%', p_busqueda, '%')
       OR nombre_cargo LIKE CONCAT('%', p_busqueda, '%');
END //

DELIMITER ;

/*2. Procedure para desactivar un usuario desde la interfaz*/
DROP PROCEDURE IF EXISTS sp_desactivar_usuario;
DELIMITER //
CREATE PROCEDURE sp_desactivar_usuario(
    IN p_id_usuario INT,
    OUT p_resultado INT
)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN
        UPDATE usuario
        SET estado_usuario = 0
        WHERE id_usuario = p_id_usuario;
        SET p_resultado = 1;
    ELSE
        SET p_resultado = 0;
    END IF;
END //
DELIMITER ;


/*3. Procedure para activar un usuario desde la interfaz*/
DROP PROCEDURE IF EXISTS sp_reactivar_usuario;
DELIMITER //
CREATE PROCEDURE sp_reactivar_usuario(
    IN p_id_usuario INT,
    OUT p_resultado INT
)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN
        UPDATE usuario
        SET estado_usuario = 1
        WHERE id_usuario = p_id_usuario;
        SET p_resultado = 1;
    ELSE
        SET p_resultado = 0;
    END IF;
END //
DELIMITER ;
/*4. Para guardar un nuevo usuario*/
DROP PROCEDURE IF EXISTS sp_insertar_usuario;
DELIMITER //
CREATE PROCEDURE sp_insertar_usuario(
    IN p_codigo VARCHAR(15),
    IN p_password VARCHAR(255),
    IN p_id_cargo INT,
    OUT p_resultado INT
)
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM usuario
        WHERE codigo = p_codigo
    ) THEN
        INSERT INTO usuario (
            codigo,
            password,
            id_cargo,
            estado_usuario
        )
        VALUES (
            p_codigo,
            p_password,
            p_id_cargo,
            1
        );
        SET p_resultado = 1;
    ELSE
        SET p_resultado = 0;
    END IF;
END //
DELIMITER ;

/*5. Para resetar la contraseña a por default 1 al 6 cuando el usario lo haya olvidado*/
DROP PROCEDURE IF EXISTS sp_reset_password;
DELIMITER //
CREATE PROCEDURE sp_reset_password(
    IN p_id_usuario INT,
    IN p_nueva_password VARCHAR(255),
    OUT p_resultado INT
)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN
        UPDATE usuario
        SET password = p_nueva_password
        WHERE id_usuario = p_id_usuario;
        SET p_resultado = 1;
    ELSE
        SET p_resultado = 0;
    END IF;
END //
DELIMITER ;
/*==============================MATRICULA=============================================*/
--proceso para insertar

DROP PROCEDURE IF EXISTS sp_matricula_insertar;

DELIMITER $$

CREATE PROCEDURE sp_matricula_insertar(
    IN p_id_estudiante INT,
    IN p_id_carrera INT,
    IN p_id_turno INT,
    IN p_id_semestre INT,
    IN p_id_ciclo INT,
    IN p_id_modalidad INT,
    IN p_fecha_matricula DATE,
    IN p_numero_operacion VARCHAR(100),
    IN p_estado_pago INT,
    IN p_detalles VARCHAR(500)
)
BEGIN
    IF p_fecha_matricula IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Debe ingresar la fecha de matrícula';
    END IF;

    IF p_estado_pago NOT IN (0, 1) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El estado de pago debe ser 0 o 1';
    END IF;

    INSERT INTO matricula (
        id_estudiante,
        id_carrera,
        id_turno,
        id_semestre,
        id_ciclo,
        id_modalidad,
        fecha_matricula,
        numero_operacion,
        estado_pago,
        detalles
    )
    VALUES (
        p_id_estudiante,
        p_id_carrera,
        p_id_turno,
        p_id_semestre,
        p_id_ciclo,
        p_id_modalidad,
        p_fecha_matricula,
        p_numero_operacion,
        p_estado_pago,
        p_detalles
    );
END $$

DELIMITER ;
--proceso para modificar

DROP PROCEDURE IF EXISTS sp_matricula_actualizar;

DELIMITER $$

CREATE PROCEDURE sp_matricula_actualizar(
    IN p_id_matricula INT,
    IN p_id_estudiante INT,
    IN p_id_carrera INT,
    IN p_id_turno INT,
    IN p_id_semestre INT,
    IN p_id_ciclo INT,
    IN p_id_modalidad INT,
    IN p_fecha_matricula DATE,
    IN p_numero_operacion VARCHAR(100),
    IN p_estado_pago INT,
    IN p_detalles VARCHAR(500)
)
BEGIN
    IF p_id_matricula IS NULL OR p_id_matricula <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El ID de matrícula no es válido';
    END IF;

    IF p_fecha_matricula IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Debe ingresar la fecha de matrícula';
    END IF;

    IF p_estado_pago NOT IN (0, 1) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El estado de pago debe ser 0 o 1';
    END IF;

    IF NOT EXISTS (
        SELECT 1
        FROM matricula
        WHERE id_matricula = p_id_matricula
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La matrícula no existe';
    END IF;

    UPDATE matricula
    SET
        id_estudiante = p_id_estudiante,
        id_carrera = p_id_carrera,
        id_turno = p_id_turno,
        id_semestre = p_id_semestre,
        id_ciclo = p_id_ciclo,
        id_modalidad = p_id_modalidad,
        fecha_matricula = p_fecha_matricula,
        numero_operacion = p_numero_operacion,
        estado_pago = p_estado_pago,
        detalles = p_detalles
    WHERE id_matricula = p_id_matricula;
END $$

DELIMITER ;
--proceso para buscar

DROP PROCEDURE IF EXISTS sp_matricula_buscar;

DELIMITER $$

CREATE PROCEDURE sp_matricula_buscar(
    IN p_busqueda VARCHAR(100)
)
BEGIN
    DECLARE v_busqueda VARCHAR(100);

    SET v_busqueda = TRIM(IFNULL(p_busqueda, ''));

    SELECT
        id_matricula,
        estudiante,
        carrera,
        turno,
        semestre,
        ciclo,
        modalidad,
        fecha_matricula,
        numero_operacion,
        estado_pago,
        detalles
    FROM vista_matriculas
    WHERE v_busqueda = ''
       OR LOWER(
            CONVERT(estudiante USING utf8mb4)
            COLLATE utf8mb4_general_ci
          ) LIKE CONCAT(
            '%',
            LOWER(
                CONVERT(v_busqueda USING utf8mb4)
                COLLATE utf8mb4_general_ci
            ),
            '%'
          )
    ORDER BY id_matricula;
END $$

DELIMITER ;
--====================================PLAN_ESTUDIOS=========================================
--proceso para buscar
DROP PROCEDURE IF EXISTS sp_buscar_planestudios;

DELIMITER //

CREATE PROCEDURE sp_buscar_planestudios(
    IN p_busqueda VARCHAR(100)
)
BEGIN
    DECLARE v_busqueda VARCHAR(100);

    SET v_busqueda = TRIM(COALESCE(p_busqueda, ''));

    SELECT *
    FROM vw_planestudios
    WHERE v_busqueda = ''
       OR NombreCarrera LIKE CONCAT('%', v_busqueda, '%')
       OR NombreCurso LIKE CONCAT('%', v_busqueda, '%')
       OR NombreCiclo LIKE CONCAT('%', v_busqueda, '%')
       OR NombreSemestre LIKE CONCAT('%', v_busqueda, '%');
END //

DELIMITER ;
--proceso para insertar

DROP PROCEDURE IF EXISTS sp_insertar_planestudios;

DELIMITER //

CREATE PROCEDURE sp_insertar_planestudios(
    IN p_id_curso INT,
    IN p_id_carrera INT,
    IN p_id_ciclo INT,
    IN p_id_semestre INT,
    IN p_numero_semanas INT,
    IN p_creditos DECIMAL(4,1),
    IN p_observaciones VARCHAR(500),
    IN p_HorasTeoricas INT,
    IN p_HorasPracticas INT,
    IN p_HorasLaboratorio INT,
    IN p_HorasSemal INT,
    IN p_TotalHoras INT
)
BEGIN
    INSERT INTO plan_estudios (
        id_curso,
        id_carrera,
        id_ciclo,
        id_semestre,
        numero_semanas,
        creditos,
        observaciones,
        HorasTeoricas,
        HorasPracticas,
        HorasLaboratorio,
        HorasSemal,
        TotalHoras,
        EstadoPlanEstudios
    )
    VALUES (
        p_id_curso,
        p_id_carrera,
        p_id_ciclo,
        p_id_semestre,
        p_numero_semanas,
        p_creditos,
        p_observaciones,
        p_HorasTeoricas,
        p_HorasPracticas,
        p_HorasLaboratorio,
        p_HorasSemal,
        p_TotalHoras,
        1
    );
END //

DELIMITER ;
--proceso para modificar

DROP PROCEDURE IF EXISTS sp_modificar_planestudios;

DELIMITER //

CREATE PROCEDURE sp_modificar_planestudios(
    IN p_id_plan_estudios INT,
    IN p_id_curso INT,
    IN p_id_carrera INT,
    IN p_id_ciclo INT,
    IN p_id_semestre INT,
    IN p_numero_semanas INT,
    IN p_creditos DECIMAL(4,1),
    IN p_observaciones VARCHAR(500),
    IN p_HorasTeoricas INT,
    IN p_HorasPracticas INT,
    IN p_HorasLaboratorio INT,
    IN p_HorasSemal INT,
    IN p_TotalHoras INT
)
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM plan_estudios
        WHERE id_plan_estudios = p_id_plan_estudios
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El plan de estudios seleccionado no existe.';

    ELSEIF EXISTS (
        SELECT 1
        FROM plan_estudios
        WHERE id_carrera = p_id_carrera
          AND id_curso = p_id_curso
          AND id_semestre = p_id_semestre
          AND id_plan_estudios <> p_id_plan_estudios
          AND EstadoPlanEstudios = 1
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Este curso ya está registrado y activo para la carrera y el semestre seleccionados.';

    ELSE
        UPDATE plan_estudios
        SET id_curso = p_id_curso,
            id_carrera = p_id_carrera,
            id_ciclo = p_id_ciclo,
            id_semestre = p_id_semestre,
            numero_semanas = p_numero_semanas,
            creditos = p_creditos,
            observaciones = p_observaciones,
            HorasTeoricas = p_HorasTeoricas,
            HorasPracticas = p_HorasPracticas,
            HorasLaboratorio = p_HorasLaboratorio,
            HorasSemal = p_HorasSemal,
            TotalHoras = p_TotalHoras
        WHERE id_plan_estudios = p_id_plan_estudios;
    END IF;
END //

DELIMITER ;
--proceso para dar de baja

DROP PROCEDURE IF EXISTS sp_dar_baja_planestudios;

DELIMITER //

CREATE PROCEDURE sp_dar_baja_planestudios(
    IN p_id_plan_estudios INT
)
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM plan_estudios
        WHERE id_plan_estudios = p_id_plan_estudios
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'El plan de estudios seleccionado no existe.';

    ELSEIF EXISTS (
        SELECT 1
        FROM plan_estudios
        WHERE id_plan_estudios = p_id_plan_estudios
          AND EstadoPlanEstudios = 0
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'El plan de estudios ya se encuentra inactivo.';

    ELSE
        UPDATE plan_estudios
        SET EstadoPlanEstudios = 0
        WHERE id_plan_estudios = p_id_plan_estudios;
    END IF;
END //

DELIMITER ;
--==============================================================================


