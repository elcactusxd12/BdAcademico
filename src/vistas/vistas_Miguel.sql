USE bdcademico;

-- ============================================================
-- VISTAS HECHAS POR MIGUEL
-- ============================================================


-- 1. PAÍSES
CREATE OR REPLACE VIEW vista_paises AS
SELECT
    id_pais AS codigo,
    nombre_pais AS pais
FROM pais;


-- 2. DEPARTAMENTOS
CREATE OR REPLACE VIEW vista_departamentos AS
SELECT
    id_departamento AS codigo,
    nombre_departamento AS departamento,
    id_pais,
    codigo_ubigeo AS ubigeo
FROM departamento;


-- 3. PROVINCIAS
CREATE OR REPLACE VIEW vista_provincias AS
SELECT
    id_provincia AS codigo,
    nombre_provincia AS provincia,
    id_departamento,
    codigo_ubigeo AS ubigeo
FROM provincia;


-- 4. DISTRITOS
CREATE OR REPLACE VIEW vista_distritos AS
SELECT
    id_distrito AS codigo,
    nombre_distrito AS distrito,
    id_provincia,
    codigo_ubigeo AS ubigeo
FROM distrito;


-- 5. CARGOS
CREATE OR REPLACE VIEW vista_cargos AS
SELECT
    id_cargo AS codigo,
    nombre_cargo AS cargo,
    estado_cargo AS estado
FROM cargo;


-- 6. tabla general de usuarios
CREATE OR REPLACE VIEW vista_usuarios AS
SELECT
    id_usuario AS codigo,
    codigo AS usuario,
    password,
    id_cargo,
    estado_usuario AS estado,
    fecha_registro
FROM usuario;


-- 7. GÉNEROS
CREATE OR REPLACE VIEW vista_generos AS
SELECT
    id_genero AS codigo,
    nombre_genero AS genero
FROM genero;


-- 8. PROCEDENCIAS
CREATE OR REPLACE VIEW vista_procedencias AS
SELECT
    id_procedencia AS codigo,
    descripcion AS procedencia
FROM procedencia;


-- 9. CONDICIONES
CREATE OR REPLACE VIEW vista_condiciones AS
SELECT
    id_condicion AS codigo,
    nombre_condicion AS condicion
FROM condicion;


-- 10. APODERADOS
CREATE OR REPLACE VIEW vista_apoderados AS
SELECT
    id_apoderado AS codigo,
    dni,
    nombres,
    apellidos,
    direccion_actual AS direccion,
    correo,
    id_genero,
    otro_contacto
FROM apoderado;


-- 11. ESTUDIANTES
DROP VIEW IF EXISTS vista_estudiantes_activos;

CREATE VIEW vista_estudiantes_activos AS
SELECT
    id_estudiante,
    dni,
    nombres,
    apellidos,
    id_distrito,
    id_genero,
    id_procedencia,
    id_condicion,
    id_apoderado,
    fecha_nacimiento,
    correo1,
    correo2,
    telefono1,
    telefono2,
    estado
FROM estudiante
WHERE estado = 1;

-- 12. TIPOS DE PAGO
CREATE OR REPLACE VIEW vista_tipos_pago AS
SELECT
    id_tipo_pago AS codigo,
    concepto_pago AS concepto
FROM tipo_pago;


-- 13. CONTROL DE PAGOS
CREATE OR REPLACE VIEW vista_control_pagos AS
SELECT
    id_control_pagos AS codigo,
    id_tipo_pago,
    concepto,
    numero_operacion,
    fecha_registro,
    fecha_actualizacion,
    importe,
    total,
    observaciones,
    id_estudiante
FROM control_pagos;

--14.-listar usuarios inactivos
CREATE OR REPLACE VIEW vw_listar_usuarios_inactivos AS
SELECT 
    u.IdUsuario,
    u.Codigo,
    u.Password,
    c.NombreCargo,
    CASE 
        WHEN u.EstadoUsuario = 1 THEN 'Activo'
        ELSE 'Inactivo'
    END AS EstadoUsuario
FROM Usuario u
INNER JOIN Cargo c ON u.CodigoCargo = c.CodigoCargo
WHERE u.EstadoUsuario = 0;
--vista para Plan de estudios

CREATE OR REPLACE VIEW vw_planestudios AS
SELECT
    p.id_plan_estudios,
    c.nombre_carrera AS NombreCarrera,
    cu.nombre_curso AS NombreCurso,
    ci.nombre_ciclo AS NombreCiclo,
    s.nombre_semestre AS NombreSemestre,
    p.numero_semanas,
    p.creditos,
    p.observaciones,
    p.HorasTeoricas,
    p.HorasPracticas,
    p.HorasLaboratorio,
    p.HorasSemal,
    p.TotalHoras,
    CASE
        WHEN p.EstadoPlanEstudios = 1 THEN 'Activo'
        ELSE 'Inactivo'
    END AS EstadoPlanEstudios
FROM plan_estudios p
INNER JOIN carrera c
    ON p.id_carrera = c.id_carrera
INNER JOIN curso cu
    ON p.id_curso = cu.id_curso
INNER JOIN ciclo ci
    ON p.id_ciclo = ci.id_ciclo
INNER JOIN semestre s
    ON p.id_semestre = s.id_semestre;

