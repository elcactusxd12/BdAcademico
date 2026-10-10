-- ============================================================
-- BASE DE DATOS: bdacademico (SENATI)
-- Sistema Académico con Módulo de Acceso (Cargo y Usuario)
-- Motor: MySQL / InnoDB
-- ============================================================

SET SQL_MODE = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS bdacademico;

CREATE DATABASE bdacademico
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE bdacademico;

-- ------------------------------------------------------------
-- 1. LIMPIEZA PREVIA DE VISTAS Y TABLAS (Orden inverso estricto)
-- ------------------------------------------------------------

DROP VIEW IF EXISTS view_usuarios;
DROP TABLE IF EXISTS horario;
DROP TABLE IF EXISTS dias;
DROP TABLE IF EXISTS aula;
DROP TABLE IF EXISTS pabellon;
DROP TABLE IF EXISTS detalle_matricula;
DROP TABLE IF EXISTS matricula;
DROP TABLE IF EXISTS turno;
DROP TABLE IF EXISTS modalidad;
DROP TABLE IF EXISTS plan_estudios;
DROP TABLE IF EXISTS semestre;
DROP TABLE IF EXISTS carrera;
DROP TABLE IF EXISTS ciclo;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS control_pagos;
DROP TABLE IF EXISTS tipo_pago;
DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS apoderado;
DROP TABLE IF EXISTS condicion;
DROP TABLE IF EXISTS procedencia;
DROP TABLE IF EXISTS genero;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS distrito;
DROP TABLE IF EXISTS provincia;
DROP TABLE IF EXISTS departamento;
DROP TABLE IF EXISTS pais;

-- ------------------------------------------------------------
-- 2. CREACIÓN DE TABLAS DE UBICACIÓN Y CATÁLOGOS BASE
-- ------------------------------------------------------------

CREATE TABLE pais (
    id_pais INT NOT NULL AUTO_INCREMENT,
    nombre_pais VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_pais),
    CONSTRAINT uk_pais_nombre UNIQUE (nombre_pais)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE departamento (
    id_departamento INT NOT NULL AUTO_INCREMENT,
    nombre_departamento VARCHAR(120) NOT NULL,
    id_pais INT NOT NULL,
    codigo_ubigeo VARCHAR(2),
    PRIMARY KEY (id_departamento),
    CONSTRAINT uk_departamento_ubigeo UNIQUE (codigo_ubigeo),
    CONSTRAINT fk_departamento_pais FOREIGN KEY (id_pais) REFERENCES pais(id_pais) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_depto_pais ON departamento(id_pais);

CREATE TABLE provincia (
    id_provincia INT NOT NULL AUTO_INCREMENT,
    nombre_provincia VARCHAR(120) NOT NULL,
    id_departamento INT NOT NULL,
    codigo_ubigeo VARCHAR(4),
    PRIMARY KEY (id_provincia),
    CONSTRAINT uk_provincia_ubigeo UNIQUE (codigo_ubigeo),
    CONSTRAINT fk_provincia_departamento FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_prov_depto ON provincia(id_departamento);

CREATE TABLE distrito (
    id_distrito INT NOT NULL AUTO_INCREMENT,
    nombre_distrito VARCHAR(120) NOT NULL,
    id_provincia INT NOT NULL,
    codigo_ubigeo VARCHAR(6),
    PRIMARY KEY (id_distrito),
    CONSTRAINT uk_distrito_ubigeo UNIQUE (codigo_ubigeo),
    CONSTRAINT fk_distrito_provincia FOREIGN KEY (id_provincia) REFERENCES provincia(id_provincia) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_dist_prov ON distrito(id_provincia);

-- ------------------------------------------------------------
-- 3. MÓDULO DE ACCESO (CARGO Y USUARIO)
-- ------------------------------------------------------------

CREATE TABLE cargo (
    id_cargo INT NOT NULL AUTO_INCREMENT,
    nombre_cargo VARCHAR(100) NOT NULL,
    estado_cargo TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_cargo),
    CONSTRAINT uk_cargo_nombre UNIQUE (nombre_cargo)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE usuario (
    id_usuario INT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(15) NOT NULL,
    password VARCHAR(255) NOT NULL,
    id_cargo INT NOT NULL,
    estado_usuario TINYINT(1) NOT NULL DEFAULT 1,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (id_usuario),
    CONSTRAINT uk_usuario_codigo UNIQUE (codigo),
    CONSTRAINT fk_usuario_cargo FOREIGN KEY (id_cargo) REFERENCES cargo(id_cargo) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT ck_usuario_estado CHECK (estado_usuario IN (0,1))
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_usuario_cargo ON usuario(id_cargo);

-- ------------------------------------------------------------
-- 4. OTROS CATÁLOGOS Y PERSONAS
-- ------------------------------------------------------------

CREATE TABLE genero (
    id_genero INT NOT NULL AUTO_INCREMENT,
    nombre_genero VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_genero),
    CONSTRAINT uk_genero_nombre UNIQUE (nombre_genero)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE procedencia (
    id_procedencia INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_procedencia),
    CONSTRAINT uk_procedencia_descripcion UNIQUE (descripcion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE condicion (
    id_condicion INT NOT NULL AUTO_INCREMENT,
    nombre_condicion VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_condicion),
    CONSTRAINT uk_condicion_nombre UNIQUE (nombre_condicion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE apoderado (
    id_apoderado INT NOT NULL AUTO_INCREMENT,
    dni CHAR(8) NOT NULL,
    nombres VARCHAR(150) NOT NULL,
    apellidos VARCHAR(200) NOT NULL,
    direccion_actual VARCHAR(255),
    correo VARCHAR(150),
    id_genero INT,
    otro_contacto VARCHAR(200),
    PRIMARY KEY (id_apoderado),
    CONSTRAINT uk_apoderado_dni UNIQUE (dni),
    CONSTRAINT fk_apoderado_genero FOREIGN KEY (id_genero) REFERENCES genero(id_genero) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE estudiante (
    id_estudiante INT NOT NULL AUTO_INCREMENT,
    id_distrito INT NOT NULL,
    dni CHAR(8) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(130) NOT NULL,
    id_genero INT NOT NULL,
    fecha_nacimiento DATE,
    correo1 VARCHAR(150),
    correo2 VARCHAR(150),
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion DATETIME ON UPDATE CURRENT_TIMESTAMP,
    telefono1 VARCHAR(20),
    telefono2 VARCHAR(20),
    id_procedencia INT,
    id_condicion INT,
    estado TINYINT(1) DEFAULT 1 NOT NULL,
    id_apoderado INT,
    PRIMARY KEY (id_estudiante),
    CONSTRAINT uk_estudiante_dni UNIQUE (dni),
    CONSTRAINT fk_estudiante_distrito FOREIGN KEY (id_distrito) REFERENCES distrito(id_distrito) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_estudiante_genero FOREIGN KEY (id_genero) REFERENCES genero(id_genero) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_estudiante_procedencia FOREIGN KEY (id_procedencia) REFERENCES procedencia(id_procedencia) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_estudiante_condicion FOREIGN KEY (id_condicion) REFERENCES condicion(id_condicion) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_estudiante_apoderado FOREIGN KEY (id_apoderado) REFERENCES apoderado(id_apoderado) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT ck_estudiante_estado CHECK (estado IN (0,1))
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_estudiante_distrito ON estudiante(id_distrito);

-- ------------------------------------------------------------
-- 5. PAGOS Y ESTRUCTURA ACADÉMICA
-- ------------------------------------------------------------

CREATE TABLE tipo_pago (
    id_tipo_pago INT NOT NULL AUTO_INCREMENT,
    concepto_pago VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_tipo_pago),
    CONSTRAINT uk_tipo_pago_concepto UNIQUE (concepto_pago)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE control_pagos (
    id_control_pagos INT NOT NULL AUTO_INCREMENT,
    id_tipo_pago INT NOT NULL,
    concepto VARCHAR(200),
    numero_operacion VARCHAR(60),
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion DATETIME ON UPDATE CURRENT_TIMESTAMP,
    importe DECIMAL(12,2) NOT NULL,
    total DECIMAL(12,2) NOT NULL,
    observaciones VARCHAR(500),
    id_estudiante INT NOT NULL,
    PRIMARY KEY (id_control_pagos),
    CONSTRAINT fk_pago_tipo FOREIGN KEY (id_tipo_pago) REFERENCES tipo_pago(id_tipo_pago) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_pago_estudiante FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE curso (
    id_curso INT NOT NULL AUTO_INCREMENT,
    nombre_curso VARCHAR(200) NOT NULL,
    descripcion VARCHAR(255),
    PRIMARY KEY (id_curso),
    CONSTRAINT uk_curso_nombre UNIQUE (nombre_curso)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE ciclo (
    id_ciclo INT NOT NULL AUTO_INCREMENT,
    nombre_ciclo VARCHAR(80) NOT NULL,
    PRIMARY KEY (id_ciclo),
    CONSTRAINT uk_ciclo_nombre UNIQUE (nombre_ciclo)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE carrera (
    id_carrera INT NOT NULL AUTO_INCREMENT,
    nombre_carrera VARCHAR(255) NOT NULL,
    descripcion VARCHAR(200),
    PRIMARY KEY (id_carrera),
    CONSTRAINT uk_carrera_nombre UNIQUE (nombre_carrera)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE semestre (
    id_semestre INT NOT NULL AUTO_INCREMENT,
    nombre_semestre VARCHAR(60) NOT NULL,
    PRIMARY KEY (id_semestre),
    CONSTRAINT uk_semestre_nombre UNIQUE (nombre_semestre)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE plan_estudios (
    id_plan_estudios INT NOT NULL AUTO_INCREMENT,
    id_curso INT NOT NULL,
    id_carrera INT NOT NULL,
    id_ciclo INT NOT NULL,
    id_semestre INT NOT NULL,
    numero_semanas INT,
    horas_tecnologia INT,
    horas_taller INT,
    creditos DECIMAL(3,1),
    observaciones VARCHAR(500),
    PRIMARY KEY (id_plan_estudios),
    CONSTRAINT fk_plan_curso FOREIGN KEY (id_curso) REFERENCES curso(id_curso) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_plan_carrera FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_plan_ciclo FOREIGN KEY (id_ciclo) REFERENCES ciclo(id_ciclo) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_plan_semestre FOREIGN KEY (id_semestre) REFERENCES semestre(id_semestre) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE modalidad (
    id_modalidad INT NOT NULL AUTO_INCREMENT,
    nombre_modalidad VARCHAR(180) NOT NULL,
    PRIMARY KEY (id_modalidad),
    CONSTRAINT uk_modalidad_nombre UNIQUE (nombre_modalidad)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE turno (
    id_turno INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(120) NOT NULL,
    PRIMARY KEY (id_turno),
    CONSTRAINT uk_turno_descripcion UNIQUE (descripcion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ------------------------------------------------------------
-- 6. MATRÍCULA Y HORARIOS
-- ------------------------------------------------------------

CREATE TABLE matricula (
    id_matricula INT NOT NULL AUTO_INCREMENT,
    estado_pago TINYINT(1) DEFAULT 0 NOT NULL,
    fecha_matricula DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_estudiante INT NOT NULL,
    numero_operacion VARCHAR(32),
    id_carrera INT NOT NULL,
    id_turno INT NOT NULL,
    id_semestre INT NOT NULL,
    id_ciclo INT NOT NULL,
    id_modalidad INT NOT NULL,
    detalles VARCHAR(200),
    PRIMARY KEY (id_matricula),
    CONSTRAINT fk_matricula_estudiante FOREIGN KEY (id_estudiante) REFERENCES estudiante(id_estudiante) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_matricula_carrera FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_matricula_turno FOREIGN KEY (id_turno) REFERENCES turno(id_turno) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_matricula_semestre FOREIGN KEY (id_semestre) REFERENCES semestre(id_semestre) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_matricula_ciclo FOREIGN KEY (id_ciclo) REFERENCES ciclo(id_ciclo) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_matricula_modalidad FOREIGN KEY (id_modalidad) REFERENCES modalidad(id_modalidad) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT ck_matricula_estado_pago CHECK (estado_pago IN (0,1))
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE detalle_matricula (
    id_detalle_matricula INT NOT NULL AUTO_INCREMENT,
    id_matricula INT NOT NULL,
    id_plan_estudios INT NOT NULL,
    estado TINYINT(1) DEFAULT 1 NOT NULL,
    observaciones VARCHAR(45),
    PRIMARY KEY (id_detalle_matricula),
    CONSTRAINT fk_detalle_matricula FOREIGN KEY (id_matricula) REFERENCES matricula(id_matricula) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_detalle_plan FOREIGN KEY (id_plan_estudios) REFERENCES plan_estudios(id_plan_estudios) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT ck_detalle_estado CHECK (estado IN (0,1))
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE pabellon (
    id_pabellon INT NOT NULL AUTO_INCREMENT,
    nombre_pabellon VARCHAR(120) NOT NULL,
    PRIMARY KEY (id_pabellon),
    CONSTRAINT uk_pabellon_nombre UNIQUE (nombre_pabellon)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE aula (
    id_aula INT NOT NULL AUTO_INCREMENT,
    numero INT NOT NULL,
    PRIMARY KEY (id_aula),
    CONSTRAINT uk_aula_numero UNIQUE (numero)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE dias (
    id_dia INT NOT NULL AUTO_INCREMENT,
    nombre_dia VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_dia),
    CONSTRAINT uk_dias_nombre UNIQUE (nombre_dia)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

CREATE TABLE horario (
    id_horario INT NOT NULL AUTO_INCREMENT,
    id_detalle_matricula INT NOT NULL,
    id_pabellon INT NOT NULL,
    id_aula INT NOT NULL,
    id_dia INT NOT NULL,
    fecha DATE,
    hora_inicio TIME,
    hora_fin TIME,
    total_horas DECIMAL(10,2),
    descripcion VARCHAR(200),
    PRIMARY KEY (id_horario),
    CONSTRAINT fk_horario_detalle FOREIGN KEY (id_detalle_matricula) REFERENCES detalle_matricula(id_detalle_matricula) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_horario_pabellon FOREIGN KEY (id_pabellon) REFERENCES pabellon(id_pabellon) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_horario_aula FOREIGN KEY (id_aula) REFERENCES aula(id_aula) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_horario_dia FOREIGN KEY (id_dia) REFERENCES dias(id_dia) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

-- ------------------------------------------------------------
-- 7. VISTA PARA EL LOGIN EN NETBEANS
-- ------------------------------------------------------------

CREATE VIEW view_usuarios AS
SELECT 
    u.id_usuario,
    u.codigo,
    u.password,
    c.nombre_cargo,
    u.estado_usuario
FROM usuario u
INNER JOIN cargo c ON u.id_cargo = c.id_cargo;

-- ------------------------------------------------------------
-- 8. RESTAURAR CONFIGURACIÓN Y VERIFICACIÓN
-- ------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 1;

SHOW TABLES;

-- ============================================================
-- 9. INSERCIÓN DE REGISTROS 
-- ============================================================
-- 1.-PAIS (1 REGISTRO)
-- ============================================================

INSERT INTO pais (id_pais, nombre_pais) VALUES (1, 'Perú');

-- ============================================================
-- 2.-DEPARTAMENTO (25 REGISTROS)
-- ============================================================

INSERT INTO departamento VALUES (1,'Áncash',1,'02');
INSERT INTO departamento VALUES (2,'Lima',1,'15');
INSERT INTO departamento VALUES (3,'La Libertad',1,'13');
INSERT INTO departamento VALUES (4,'Arequipa',1,'04');
INSERT INTO departamento VALUES (5,'Cusco',1,'08');
INSERT INTO departamento VALUES (6,'Piura',1,'20');
INSERT INTO departamento VALUES (7,'Junín',1,'12');
INSERT INTO departamento VALUES (8,'Cajamarca',1,'06');
INSERT INTO departamento VALUES (9,'Ica',1,'11');
INSERT INTO departamento VALUES (10,'Loreto',1,'16');
INSERT INTO departamento VALUES (11,'Puno',1,'21');
INSERT INTO departamento VALUES (12,'Tacna',1,'23');
INSERT INTO departamento VALUES (13,'Moquegua',1,'18');
INSERT INTO departamento VALUES (14,'Tumbes',1,'24');
INSERT INTO departamento VALUES (15,'Lambayeque',1,'14');
INSERT INTO departamento VALUES (16,'Amazonas',1,'01');
INSERT INTO departamento VALUES (17,'Apurímac',1,'03');
INSERT INTO departamento VALUES (18,'Ayacucho',1,'05');
INSERT INTO departamento VALUES (19,'Huancavelica',1,'09');
INSERT INTO departamento VALUES (20,'Huánuco',1,'10');
INSERT INTO departamento VALUES (21,'Pasco',1,'19');
INSERT INTO departamento VALUES (22,'San Martín',1,'22');
INSERT INTO departamento VALUES (23,'Ucayali',1,'25');
INSERT INTO departamento VALUES (24,'Madre de Dios',1,'17');
INSERT INTO departamento VALUES (25,'Callao',1,'07');

-- ============================================================
-- 3.-PROVINCIA (25 REGISTROS)
-- ============================================================

INSERT INTO provincia VALUES (1,'Santa',1,'0201');
INSERT INTO provincia VALUES (2,'Lima',2,'1501');
INSERT INTO provincia VALUES (3,'Trujillo',3,'1301');
INSERT INTO provincia VALUES (4,'Arequipa',4,'0401');
INSERT INTO provincia VALUES (5,'Cusco',5,'0801');
INSERT INTO provincia VALUES (6,'Piura',6,'2001');
INSERT INTO provincia VALUES (7,'Huancayo',7,'1201');
INSERT INTO provincia VALUES (8,'Cajamarca',8,'0601');
INSERT INTO provincia VALUES (9,'Ica',9,'1101');
INSERT INTO provincia VALUES (10,'Maynas',10,'1601');
INSERT INTO provincia VALUES (11,'Puno',11,'2101');
INSERT INTO provincia VALUES (12,'Tacna',12,'2301');
INSERT INTO provincia VALUES (13,'Mariscal Nieto',13,'1801');
INSERT INTO provincia VALUES (14,'Tumbes',14,'2401');
INSERT INTO provincia VALUES (15,'Chiclayo',15,'1401');
INSERT INTO provincia VALUES (16,'Chachapoyas',16,'0101');
INSERT INTO provincia VALUES (17,'Abancay',17,'0301');
INSERT INTO provincia VALUES (18,'Huamanga',18,'0501');
INSERT INTO provincia VALUES (19,'Huancavelica',19,'0901');
INSERT INTO provincia VALUES (20,'Huánuco',20,'1001');
INSERT INTO provincia VALUES (21,'Pasco',21,'1901');
INSERT INTO provincia VALUES (22,'Moyobamba',22,'2201');
INSERT INTO provincia VALUES (23,'Coronel Portillo',23,'2501');
INSERT INTO provincia VALUES (24,'Tambopata',24,'1701');
INSERT INTO provincia VALUES (25,'Callao',25,'0701');

-- ============================================================
-- 4.-DISTRITO (25 REGISTROS)
-- ============================================================

INSERT INTO distrito VALUES (1,'Chimbote',1,'020101');
INSERT INTO distrito VALUES (2,'Nuevo Chimbote',1,'020105');
INSERT INTO distrito VALUES (3,'Los Olivos',2,'150117');
INSERT INTO distrito VALUES (4,'San Martín de Porres',2,'150135');
INSERT INTO distrito VALUES (5,'Trujillo',3,'130101');
INSERT INTO distrito VALUES (6,'Arequipa',4,'040101');
INSERT INTO distrito VALUES (7,'Cusco',5,'080101');
INSERT INTO distrito VALUES (8,'Piura',6,'200101');
INSERT INTO distrito VALUES (9,'Huancayo',7,'120101');
INSERT INTO distrito VALUES (10,'Cajamarca',8,'060101');
INSERT INTO distrito VALUES (11,'Ica',9,'110101');
INSERT INTO distrito VALUES (12,'Iquitos',10,'160101');
INSERT INTO distrito VALUES (13,'Puno',11,'210101');
INSERT INTO distrito VALUES (14,'Tacna',12,'230101');
INSERT INTO distrito VALUES (15,'Moquegua',13,'180101');
INSERT INTO distrito VALUES (16,'Tumbes',14,'240101');
INSERT INTO distrito VALUES (17,'Chiclayo',15,'140101');
INSERT INTO distrito VALUES (18,'Chachapoyas',16,'010101');
INSERT INTO distrito VALUES (19,'Abancay',17,'030101');
INSERT INTO distrito VALUES (20,'Ayacucho',18,'050101');
INSERT INTO distrito VALUES (21,'Huancavelica',19,'090101');
INSERT INTO distrito VALUES (22,'Huánuco',20,'100101');
INSERT INTO distrito VALUES (23,'Yanacancha',21,'190101');
INSERT INTO distrito VALUES (24,'Moyobamba',22,'220101');
INSERT INTO distrito VALUES (25,'Callería',23,'250101');

/* ============================================================
   5. CARGO - 15 REGISTROS
   ============================================================ */

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (1, 'Administrador', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (2, 'Secretaria', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (3, 'Coordinador Academico', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (4, 'Director', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (5, 'Docente', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (6, 'Auxiliar', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (7, 'Contador', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (8, 'Tesorero', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (9, 'Recepcionista', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (10, 'Soporte Tecnico', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (11, 'Analista Academico', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (12, 'Asistente Administrativo', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (13, 'Jefe de Area', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (14, 'Bibliotecario', 1);

INSERT INTO cargo (id_cargo, nombre_cargo, estado_cargo)
VALUES (15, 'Supervisor', 1);


/* ============================================================
   6. USUARIO - 15 REGISTROS
   ============================================================ */

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(1, 'USR01', 'clave01123', 1, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(2, 'USR02', 'clave02123', 2, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(3, 'USR03', 'clave03123', 3, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(4, 'USR04', 'clave04123', 4, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(5, 'USR05', 'clave05123', 5, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(6, 'USR06', 'clave06123', 6, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(7, 'USR07', 'clave07123', 7, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(8, 'USR08', 'clave08123', 8, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(9, 'USR09', 'clave09123', 9, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(10, 'USR10', 'clave10123', 10, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(11, 'USR11', 'clave11123', 11, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(12, 'USR12', 'clave12123', 12, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(13, 'USR13', 'clave13123', 13, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(14, 'USR14', 'clave14123', 14, 1);

INSERT INTO usuario
(id_usuario, codigo, password, id_cargo, estado_usuario)
VALUES
(15, 'USR15', 'clave15123', 15, 1);


/* ============================================================
   7. GENERO - SOLO 2 REGISTROS
   ============================================================ */

INSERT INTO genero (id_genero, nombre_genero)
VALUES (1, 'Masculino');

INSERT INTO genero (id_genero, nombre_genero)
VALUES (2, 'Femenino');


/* ============================================================
   8. PROCEDENCIA - 15 REGISTROS
   SOLO COLEGIO ESTATAL O PRIVADO
   ============================================================ */

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (1, 'Colegio Estatal San Martin');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (2, 'Colegio Privado San Ignacio');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (3, 'Colegio Estatal Miguel Grau');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (4, 'Colegio Privado Santa Maria');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (5, 'Colegio Estatal Jose Maria Arguedas');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (6, 'Colegio Privado San Jose');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (7, 'Colegio Estatal Túpac Amaru');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (8, 'Colegio Privado Los Angeles');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (9, 'Colegio Estatal Simon Bolivar');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (10, 'Colegio Privado Santo Domingo');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (11, 'Colegio Estatal Nuestra Señora de Guadalupe');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (12, 'Colegio Privado El Nazareno');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (13, 'Colegio Estatal Santa Rosa');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (14, 'Colegio Privado Nuestra Señora del Carmen');

INSERT INTO procedencia (id_procedencia, descripcion)
VALUES (15, 'Colegio Estatal Maria Parado de Bellido');


/* ============================================================
   9. CONDICION - 15 REGISTROS
   ============================================================ */

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (1, 'Regular');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (2, 'Becado');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (3, 'Trabajador');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (4, 'Reingresante');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (5, 'Traslado Interno');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (6, 'Traslado Externo');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (7, 'Convenio');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (8, 'Practicante');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (9, 'Egresado');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (10, 'Reserva de Matricula');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (11, 'Primera Matricula');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (12, 'Segunda Matricula');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (13, 'Tercera Matricula');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (14, 'Retirado');

INSERT INTO condicion (id_condicion, nombre_condicion)
VALUES (15, 'Observado');


/* ============================================================
   10. APODERADO - 15 REGISTROS
   ============================================================ */

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(1, '70000001', 'Carlos', 'Quispe Torres', 'Av. Principal 101', 'carlos01@gmail.com', 1, '987000001');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(2, '70000002', 'Maria', 'Flores Sanchez', 'Av. Principal 102', 'maria02@gmail.com', 2, '987000002');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(3, '70000003', 'Jose', 'Vasquez Ruiz', 'Av. Principal 103', 'jose03@gmail.com', 1, '987000003');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(4, '70000004', 'Rosa', 'Garcia Lopez', 'Av. Principal 104', 'rosa04@gmail.com', 2, '987000004');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(5, '70000005', 'Luis', 'Perez Mendoza', 'Av. Principal 105', 'luis05@gmail.com', 1, '987000005');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(6, '70000006', 'Ana', 'Ramirez Soto', 'Av. Principal 106', 'ana06@gmail.com', 2, '987000006');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(7, '70000007', 'Pedro', 'Castillo Ramos', 'Av. Principal 107', 'pedro07@gmail.com', 1, '987000007');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(8, '70000008', 'Lucia', 'Fernandez Soto', 'Av. Principal 108', 'lucia08@gmail.com', 2, '987000008');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(9, '70000009', 'Miguel', 'Paredes Cruz', 'Av. Principal 109', 'miguel09@gmail.com', 1, '987000009');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(10, '70000010', 'Carmen', 'Morales Diaz', 'Av. Principal 110', 'carmen10@gmail.com', 2, '987000010');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(11, '70000011', 'Jorge', 'Huaman Leon', 'Av. Principal 111', 'jorge11@gmail.com', 1, '987000011');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(12, '70000012', 'Patricia', 'Rojas Silva', 'Av. Principal 112', 'patricia12@gmail.com', 2, '987000012');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(13, '70000013', 'Ricardo', 'Torres Campos', 'Av. Principal 113', 'ricardo13@gmail.com', 1, '987000013');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(14, '70000014', 'Elena', 'Salazar Vega', 'Av. Principal 114', 'elena14@gmail.com', 2, '987000014');

INSERT INTO apoderado
(id_apoderado, dni, nombres, apellidos, direccion_actual, correo, id_genero, otro_contacto)
VALUES
(15, '70000015', 'Fernando', 'Mendoza Ruiz', 'Av. Principal 115', 'fernando15@gmail.com', 1, '987000015');


/* ============================================================
   11. ESTUDIANTE - 15 REGISTROS
   ============================================================
   IMPORTANTE:
   id_distrito = 1 al 15
   Esos distritos deben existir previamente.
   ============================================================ */

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(1, 1, '71000001', 'Andres', 'Torres Diaz', 1, '2005-01-15', 'andres01@gmail.com', 'andres01@senati.pe', '988000001', '989000001', 1, 1, 1, 1);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(2, 2, '71000002', 'Beatriz', 'Flores Garcia', 2, '2005-02-20', 'beatriz02@gmail.com', 'beatriz02@senati.pe', '988000002', '989000002', 2, 2, 1, 2);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(3, 3, '71000003', 'Carlos', 'Sanchez Ruiz', 1, '2004-03-10', 'carlos03@gmail.com', 'carlos03@senati.pe', '988000003', '989000003', 3, 3, 1, 3);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(4, 4, '71000004', 'Daniela', 'Mendoza Lopez', 2, '2005-04-12', 'daniela04@gmail.com', 'daniela04@senati.pe', '988000004', '989000004', 4, 4, 1, 4);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(5, 5, '71000005', 'Eduardo', 'Castro Perez', 1, '2004-05-18', 'eduardo05@gmail.com', 'eduardo05@senati.pe', '988000005', '989000005', 5, 5, 1, 5);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(6, 6, '71000006', 'Fiorella', 'Ramos Silva', 2, '2005-06-22', 'fiorella06@gmail.com', 'fiorella06@senati.pe', '988000006', '989000006', 6, 6, 1, 6);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(7, 7, '71000007', 'Gabriel', 'Vega Torres', 1, '2004-07-14', 'gabriel07@gmail.com', 'gabriel07@senati.pe', '988000007', '989000007', 7, 7, 1, 7);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(8, 8, '71000008', 'Helena', 'Gomez Rojas', 2, '2005-08-25', 'helena08@gmail.com', 'helena08@senati.pe', '988000008', '989000008', 8, 8, 1, 8);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(9, 9, '71000009', 'Ivan', 'Paredes Soto', 1, '2004-09-17', 'ivan09@gmail.com', 'ivan09@senati.pe', '988000009', '989000009', 9, 9, 1, 9);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(10, 10, '71000010', 'Juliana', 'Navarro Cruz', 2, '2005-10-09', 'juliana10@gmail.com', 'juliana10@senati.pe', '988000010', '989000010', 10, 10, 1, 10);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(11, 11, '71000011', 'Kevin', 'Herrera Leon', 1, '2004-11-11', 'kevin11@gmail.com', 'kevin11@senati.pe', '988000011', '989000011', 11, 11, 1, 11);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(12, 12, '71000012', 'Laura', 'Quispe Vargas', 2, '2005-12-03', 'laura12@gmail.com', 'laura12@senati.pe', '988000012', '989000012', 12, 12, 1, 12);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(13, 13, '71000013', 'Marco', 'Salazar Diaz', 1, '2004-02-08', 'marco13@gmail.com', 'marco13@senati.pe', '988000013', '989000013', 13, 13, 1, 13);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(14, 14, '71000014', 'Natalia', 'Cardenas Flores', 2, '2005-03-19', 'natalia14@gmail.com', 'natalia14@senati.pe', '988000014', '989000014', 14, 14, 1, 14);

INSERT INTO estudiante
(id_estudiante, id_distrito, dni, nombres, apellidos, id_genero, fecha_nacimiento, correo1, correo2, telefono1, telefono2, id_procedencia, id_condicion, estado, id_apoderado)
VALUES
(15, 15, '71000015', 'Oscar', 'Morales Perez', 1, '2004-04-21', 'oscar15@gmail.com', 'oscar15@senati.pe', '988000015', '989000015', 15, 15, 1, 15);


/* ============================================================
   12. TIPO_PAGO - 15 REGISTROS
   ============================================================ */

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (1, 'Matricula');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (2, 'Mensualidad');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (3, 'Certificado');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (4, 'Constancia');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (5, 'Carne Estudiantil');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (6, 'Seguro Estudiantil');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (7, 'Curso de Recuperacion');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (8, 'Examen Sustitutorio');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (9, 'Convalidacion');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (10, 'Duplicado de Carne');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (11, 'Certificado de Estudios');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (12, 'Derecho de Graduacion');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (13, 'Idioma');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (14, 'Taller');

INSERT INTO tipo_pago (id_tipo_pago, concepto_pago)
VALUES (15, 'Otros Derechos Academicos');


/* ============================================================
   13. CONTROL_PAGOS - 15 REGISTROS
   ============================================================ */

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(1, 1, 'Matricula', 'OP20260001', 150.00, 150.00, 'Pago de prueba 1', 1);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(2, 2, 'Mensualidad', 'OP20260002', 160.00, 160.00, 'Pago de prueba 2', 2);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(3, 3, 'Certificado', 'OP20260003', 170.00, 170.00, 'Pago de prueba 3', 3);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(4, 4, 'Constancia', 'OP20260004', 180.00, 180.00, 'Pago de prueba 4', 4);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(5, 5, 'Carne Estudiantil', 'OP20260005', 190.00, 190.00, 'Pago de prueba 5', 5);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(6, 6, 'Seguro Estudiantil', 'OP20260006', 200.00, 200.00, 'Pago de prueba 6', 6);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(7, 7, 'Curso de Recuperacion', 'OP20260007', 210.00, 210.00, 'Pago de prueba 7', 7);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(8, 8, 'Examen Sustitutorio', 'OP20260008', 220.00, 220.00, 'Pago de prueba 8', 8);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(9, 9, 'Convalidacion', 'OP20260009', 230.00, 230.00, 'Pago de prueba 9', 9);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(10, 10, 'Duplicado de Carne', 'OP20260010', 240.00, 240.00, 'Pago de prueba 10', 10);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(11, 11, 'Certificado de Estudios', 'OP20260011', 250.00, 250.00, 'Pago de prueba 11', 11);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(12, 12, 'Derecho de Graduacion', 'OP20260012', 260.00, 260.00, 'Pago de prueba 12', 12);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(13, 13, 'Idioma', 'OP20260013', 270.00, 270.00, 'Pago de prueba 13', 13);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(14, 14, 'Taller', 'OP20260014', 280.00, 280.00, 'Pago de prueba 14', 14);

INSERT INTO control_pagos
(id_control_pagos, id_tipo_pago, concepto, numero_operacion, importe, total, observaciones, id_estudiante)
VALUES
(15, 15, 'Otros Derechos Academicos', 'OP20260015', 290.00, 290.00, 'Pago de prueba 15', 15);


/* ============================================================
   14. CURSO - 15 REGISTROS
   ============================================================ */

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (1, 'Matematica Basica', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (2, 'Comunicacion', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (3, 'Fundamentos de Programacion', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (4, 'Base de Datos', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (5, 'Redes de Computadoras', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (6, 'Sistemas Operativos', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (7, 'Algoritmos', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (8, 'Desarrollo Web', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (9, 'Ingles Tecnico', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (10, 'Seguridad Informatica', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (11, 'Analisis de Sistemas', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (12, 'Diseño de Interfaces', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (13, 'Arquitectura de Computadoras', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (14, 'Gestion de Proyectos', 'Curso de prueba');

INSERT INTO curso (id_curso, nombre_curso, descripcion)
VALUES (15, 'Etica Profesional', 'Curso de prueba');


/* ============================================================
   15. CICLO - 10 REGISTROS
   ============================================================ */

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (1, 'Ciclo 1');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (2, 'Ciclo 2');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (3, 'Ciclo 3');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (4, 'Ciclo 4');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (5, 'Ciclo 5');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (6, 'Ciclo 6');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (7, 'Ciclo 7');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (8, 'Ciclo 8');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (9, 'Ciclo 9');

INSERT INTO ciclo (id_ciclo, nombre_ciclo)
VALUES (10, 'Ciclo 10');


/* ============================================================
   16. CARRERA - 15 REGISTROS
   ============================================================ */

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (1, 'Desarrollo de Sistemas de Informacion', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (2, 'Administracion de Empresas', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (3, 'Contabilidad', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (4, 'Mecatronica', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (5, 'Electronica', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (6, 'Mecanica Automotriz', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (7, 'Electricidad Industrial', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (8, 'Logistica', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (9, 'Diseño Grafico', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (10, 'Marketing', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (11, 'Seguridad de la Informacion', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (12, 'Redes y Comunicaciones', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (13, 'Produccion Industrial', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (14, 'Gestion de Recursos Humanos', 'Carrera de prueba');

INSERT INTO carrera (id_carrera, nombre_carrera, descripcion)
VALUES (15, 'Mantenimiento Industrial', 'Carrera de prueba');


/* ============================================================
   17. SEMESTRE - 6 REGISTROS
   ============================================================ */

INSERT INTO semestre (id_semestre, nombre_semestre)
VALUES (1, 'Semestre 1');

INSERT INTO semestre (id_semestre, nombre_semestre)
VALUES (2, 'Semestre 2');

INSERT INTO semestre (id_semestre, nombre_semestre)
VALUES (3, 'Semestre 3');

INSERT INTO semestre (id_semestre, nombre_semestre)
VALUES (4, 'Semestre 4');

INSERT INTO semestre (id_semestre, nombre_semestre)
VALUES (5, 'Semestre 5');

INSERT INTO semestre (id_semestre, nombre_semestre)
VALUES (6, 'Semestre 6');


/* ============================================================
   18. PLAN_ESTUDIOS - 15 REGISTROS
   ============================================================ */

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(1, 1, 1, 1, 1, 16, 4, 2, 3.0, 'Plan de prueba 1');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(2, 2, 2, 2, 2, 16, 4, 2, 3.0, 'Plan de prueba 2');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(3, 3, 3, 3, 3, 16, 5, 2, 3.5, 'Plan de prueba 3');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(4, 4, 4, 4, 4, 16, 5, 3, 4.0, 'Plan de prueba 4');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(5, 5, 5, 5, 5, 16, 4, 3, 3.5, 'Plan de prueba 5');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(6, 6, 6, 6, 6, 16, 5, 2, 4.0, 'Plan de prueba 6');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(7, 7, 7, 7, 1, 16, 4, 2, 3.0, 'Plan de prueba 7');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(8, 8, 8, 8, 2, 16, 5, 3, 4.0, 'Plan de prueba 8');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(9, 9, 9, 9, 3, 16, 4, 2, 3.0, 'Plan de prueba 9');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(10, 10, 10, 10, 4, 16, 5, 3, 4.0, 'Plan de prueba 10');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(11, 11, 11, 1, 5, 16, 4, 2, 3.0, 'Plan de prueba 11');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(12, 12, 12, 2, 6, 16, 5, 3, 4.0, 'Plan de prueba 12');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(13, 13, 13, 3, 1, 16, 4, 2, 3.0, 'Plan de prueba 13');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(14, 14, 14, 4, 2, 16, 5, 3, 4.0, 'Plan de prueba 14');

INSERT INTO plan_estudios
(id_plan_estudios, id_curso, id_carrera, id_ciclo, id_semestre, numero_semanas, horas_tecnologia, horas_taller, creditos, observaciones)
VALUES
(15, 15, 15, 5, 3, 16, 4, 2, 3.0, 'Plan de prueba 15');


/* ============================================================
   19. MODALIDAD - 15 REGISTROS
   ============================================================ */

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (1, 'Presencial');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (2, 'Virtual');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (3, 'Semipresencial');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (4, 'A Distancia');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (5, 'Ejecutiva');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (6, 'Intensiva');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (7, 'Regular');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (8, 'Nocturna');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (9, 'Diurna');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (10, 'Fin de Semana');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (11, 'Hibrida');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (12, 'Modular');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (13, 'Especial');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (14, 'Corporativa');

INSERT INTO modalidad (id_modalidad, nombre_modalidad)
VALUES (15, 'Personalizada');


/* ============================================================
   20. TURNO - 15 REGISTROS
   ============================================================ */

INSERT INTO turno (id_turno, descripcion)
VALUES (1, 'Mañana');

INSERT INTO turno (id_turno, descripcion)
VALUES (2, 'Tarde');

INSERT INTO turno (id_turno, descripcion)
VALUES (3, 'Noche');

INSERT INTO turno (id_turno, descripcion)
VALUES (4, 'Mañana A');

INSERT INTO turno (id_turno, descripcion)
VALUES (5, 'Mañana B');

INSERT INTO turno (id_turno, descripcion)
VALUES (6, 'Tarde A');

INSERT INTO turno (id_turno, descripcion)
VALUES (7, 'Tarde B');

INSERT INTO turno (id_turno, descripcion)
VALUES (8, 'Noche A');

INSERT INTO turno (id_turno, descripcion)
VALUES (9, 'Noche B');

INSERT INTO turno (id_turno, descripcion)
VALUES (10, 'Fin de Semana A');

INSERT INTO turno (id_turno, descripcion)
VALUES (11, 'Fin de Semana B');

INSERT INTO turno (id_turno, descripcion)
VALUES (12, 'Intensivo A');

INSERT INTO turno (id_turno, descripcion)
VALUES (13, 'Intensivo B');

INSERT INTO turno (id_turno, descripcion)
VALUES (14, 'Mixto A');

INSERT INTO turno (id_turno, descripcion)
VALUES (15, 'Mixto B');


/* ============================================================
   21. MATRICULA - 15 REGISTROS
   ============================================================ */

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(1, 1, '2026-03-01 08:30:00', 1, 'MAT20260001', 1, 1, 1, 1, 1, 'Matricula de prueba 1');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(2, 0, '2026-03-02 08:30:00', 2, 'MAT20260002', 2, 2, 2, 2, 2, 'Matricula de prueba 2');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(3, 1, '2026-03-03 08:30:00', 3, 'MAT20260003', 3, 3, 3, 3, 3, 'Matricula de prueba 3');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(4, 0, '2026-03-04 08:30:00', 4, 'MAT20260004', 4, 4, 4, 4, 4, 'Matricula de prueba 4');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(5, 1, '2026-03-05 08:30:00', 5, 'MAT20260005', 5, 5, 5, 5, 5, 'Matricula de prueba 5');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(6, 0, '2026-03-06 08:30:00', 6, 'MAT20260006', 6, 6, 6, 6, 6, 'Matricula de prueba 6');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(7, 1, '2026-03-07 08:30:00', 7, 'MAT20260007', 7, 7, 1, 7, 7, 'Matricula de prueba 7');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(8, 0, '2026-03-08 08:30:00', 8, 'MAT20260008', 8, 8, 2, 8, 8, 'Matricula de prueba 8');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(9, 1, '2026-03-09 08:30:00', 9, 'MAT20260009', 9, 9, 3, 9, 9, 'Matricula de prueba 9');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(10, 0, '2026-03-10 08:30:00', 10, 'MAT20260010', 10, 10, 4, 10, 10, 'Matricula de prueba 10');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(11, 1, '2026-03-11 08:30:00', 11, 'MAT20260011', 11, 11, 5, 1, 11, 'Matricula de prueba 11');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(12, 0, '2026-03-12 08:30:00', 12, 'MAT20260012', 12, 12, 6, 2, 12, 'Matricula de prueba 12');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(13, 1, '2026-03-13 08:30:00', 13, 'MAT20260013', 13, 13, 1, 3, 13, 'Matricula de prueba 13');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(14, 0, '2026-03-14 08:30:00', 14, 'MAT20260014', 14, 14, 2, 4, 14, 'Matricula de prueba 14');

INSERT INTO matricula
(id_matricula, estado_pago, fecha_matricula, id_estudiante, numero_operacion, id_carrera, id_turno, id_semestre, id_ciclo, id_modalidad, detalles)
VALUES
(15, 1, '2026-03-15 08:30:00', 15, 'MAT20260015', 15, 15, 3, 5, 15, 'Matricula de prueba 15');


/* ============================================================
   22. DETALLE_MATRICULA - 15 REGISTROS
   ============================================================ */

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(1, 1, 1, 1, 'Detalle de prueba 1');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(2, 2, 2, 1, 'Detalle de prueba 2');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(3, 3, 3, 1, 'Detalle de prueba 3');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(4, 4, 4, 1, 'Detalle de prueba 4');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(5, 5, 5, 1, 'Detalle de prueba 5');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(6, 6, 6, 1, 'Detalle de prueba 6');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(7, 7, 7, 1, 'Detalle de prueba 7');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(8, 8, 8, 1, 'Detalle de prueba 8');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(9, 9, 9, 1, 'Detalle de prueba 9');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(10, 10, 10, 1, 'Detalle de prueba 10');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(11, 11, 11, 1, 'Detalle de prueba 11');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(12, 12, 12, 1, 'Detalle de prueba 12');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(13, 13, 13, 1, 'Detalle de prueba 13');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(14, 14, 14, 1, 'Detalle de prueba 14');

INSERT INTO detalle_matricula
(id_detalle_matricula, id_matricula, id_plan_estudios, estado, observaciones)
VALUES
(15, 15, 15, 1, 'Detalle de prueba 15');


/* ============================================================
   23. PABELLON - 15 REGISTROS
   ============================================================ */

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (1, 'Pabellon A');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (2, 'Pabellon B');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (3, 'Pabellon C');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (4, 'Pabellon D');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (5, 'Pabellon E');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (6, 'Pabellon F');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (7, 'Pabellon G');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (8, 'Pabellon H');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (9, 'Pabellon I');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (10, 'Pabellon J');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (11, 'Pabellon K');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (12, 'Pabellon L');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (13, 'Pabellon M');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (14, 'Pabellon N');

INSERT INTO pabellon (id_pabellon, nombre_pabellon)
VALUES (15, 'Pabellon O');


/* ============================================================
   24. AULA - 15 REGISTROS
   ============================================================ */

INSERT INTO aula (id_aula, numero) VALUES (1, 101);
INSERT INTO aula (id_aula, numero) VALUES (2, 102);
INSERT INTO aula (id_aula, numero) VALUES (3, 103);
INSERT INTO aula (id_aula, numero) VALUES (4, 104);
INSERT INTO aula (id_aula, numero) VALUES (5, 105);
INSERT INTO aula (id_aula, numero) VALUES (6, 106);
INSERT INTO aula (id_aula, numero) VALUES (7, 107);
INSERT INTO aula (id_aula, numero) VALUES (8, 108);
INSERT INTO aula (id_aula, numero) VALUES (9, 109);
INSERT INTO aula (id_aula, numero) VALUES (10, 110);
INSERT INTO aula (id_aula, numero) VALUES (11, 111);
INSERT INTO aula (id_aula, numero) VALUES (12, 112);
INSERT INTO aula (id_aula, numero) VALUES (13, 113);
INSERT INTO aula (id_aula, numero) VALUES (14, 114);
INSERT INTO aula (id_aula, numero) VALUES (15, 115);


/* ============================================================
   25. DIAS - 7 REGISTROS
   ============================================================ */

INSERT INTO dias (id_dia, nombre_dia) VALUES (1, 'Lunes');
INSERT INTO dias (id_dia, nombre_dia) VALUES (2, 'Martes');
INSERT INTO dias (id_dia, nombre_dia) VALUES (3, 'Miercoles');
INSERT INTO dias (id_dia, nombre_dia) VALUES (4, 'Jueves');
INSERT INTO dias (id_dia, nombre_dia) VALUES (5, 'Viernes');
INSERT INTO dias (id_dia, nombre_dia) VALUES (6, 'Sabado');
INSERT INTO dias (id_dia, nombre_dia) VALUES (7, 'Domingo');


/* ============================================================
   26. HORARIO - 15 REGISTROS
   ============================================================ */

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(1, 1, 1, 1, 1, '2026-04-01', '08:00:00', '10:00:00', 2.00, 'Horario de prueba 1');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(2, 2, 2, 2, 2, '2026-04-02', '09:00:00', '11:00:00', 2.00, 'Horario de prueba 2');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(3, 3, 3, 3, 3, '2026-04-03', '10:00:00', '12:00:00', 2.00, 'Horario de prueba 3');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(4, 4, 4, 4, 4, '2026-04-04', '11:00:00', '13:00:00', 2.00, 'Horario de prueba 4');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(5, 5, 5, 5, 5, '2026-04-05', '08:00:00', '10:00:00', 2.00, 'Horario de prueba 5');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(6, 6, 6, 6, 6, '2026-04-06', '09:00:00', '11:00:00', 2.00, 'Horario de prueba 6');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(7, 7, 7, 7, 7, '2026-04-07', '10:00:00', '12:00:00', 2.00, 'Horario de prueba 7');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(8, 8, 8, 8, 1, '2026-04-08', '11:00:00', '13:00:00', 2.00, 'Horario de prueba 8');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(9, 9, 9, 9, 2, '2026-04-09', '08:00:00', '10:00:00', 2.00, 'Horario de prueba 9');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(10, 10, 10, 10, 3, '2026-04-10', '09:00:00', '11:00:00', 2.00, 'Horario de prueba 10');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(11, 11, 11, 11, 4, '2026-04-11', '10:00:00', '12:00:00', 2.00, 'Horario de prueba 11');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(12, 12, 12, 12, 5, '2026-04-12', '11:00:00', '13:00:00', 2.00, 'Horario de prueba 12');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(13, 13, 13, 13, 6, '2026-04-13', '08:00:00', '10:00:00', 2.00, 'Horario de prueba 13');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(14, 14, 14, 14, 7, '2026-04-14', '09:00:00', '11:00:00', 2.00, 'Horario de prueba 14');

INSERT INTO horario
(id_horario, id_detalle_matricula, id_pabellon, id_aula, id_dia, fecha, hora_inicio, hora_fin, total_horas, descripcion)
VALUES
(15, 15, 15, 15, 1, '2026-04-15', '10:00:00', '12:00:00', 2.00, 'Horario de prueba 15');


