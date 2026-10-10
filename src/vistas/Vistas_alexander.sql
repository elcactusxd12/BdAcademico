USE bdcademico;
-- ============================================================
-- VISTAS HECHAS POR ALEXANDER
-- ============================================================


-- 14. CURSOS
CREATE OR REPLACE VIEW vista_cursos AS
SELECT
    id_curso AS codigo,
    nombre_curso AS curso,
    descripcion
FROM curso;


-- 15. CICLOS
CREATE OR REPLACE VIEW vista_ciclos AS
SELECT
    id_ciclo AS codigo,
    nombre_ciclo AS ciclo
FROM ciclo;


-- 16. CARRERAS / ESCUELAS PROFESIONALES
CREATE OR REPLACE VIEW vista_carreras AS
SELECT
    id_carrera AS codigo,
    nombre_carrera AS carrera,
    descripcion
FROM carrera;


-- 17. SEMESTRES
CREATE OR REPLACE VIEW vista_semestres AS
SELECT
    id_semestre AS codigo,
    nombre_semestre AS semestre
FROM semestre;


-- 18. PLAN DE ESTUDIOS
CREATE OR REPLACE VIEW vista_plan_estudios AS
SELECT
    id_plan_estudios AS codigo,
    id_curso,
    id_carrera,
    id_ciclo,
    id_semestre,
    numero_semanas,
    horas_tecnologia,
    horas_taller,
    creditos,
    observaciones
FROM plan_estudios;


-- 19. MODALIDADES
CREATE OR REPLACE VIEW vista_modalidades AS
SELECT
    id_modalidad AS codigo,
    nombre_modalidad AS modalidad
FROM modalidad;


-- 20. TURNOS
CREATE OR REPLACE VIEW vista_turnos AS
SELECT
    id_turno AS codigo,
    descripcion AS turno
FROM turno;


-- 21. MATRÍCULAS


CREATE OR REPLACE VIEW vista_matriculas AS
SELECT
    m.id_matricula,
    CONCAT(e.nombres, ' ', e.apellidos) AS estudiante,
    c.nombre_carrera AS carrera,
    t.descripcion AS turno,
    s.nombre_semestre AS semestre,
    ci.nombre_ciclo AS ciclo,
    mo.nombre_modalidad AS modalidad,
    DATE_FORMAT(m.fecha_matricula, '%Y-%m-%d') AS fecha_matricula,
    m.numero_operacion,
    CASE
        WHEN m.estado_pago = 1 THEN 'Pagado'
        ELSE 'Debiendo'
    END AS estado_pago,
    m.detalles
FROM matricula m
INNER JOIN estudiante e
    ON m.id_estudiante = e.id_estudiante
INNER JOIN carrera c
    ON m.id_carrera = c.id_carrera
INNER JOIN turno t
    ON m.id_turno = t.id_turno
INNER JOIN semestre s
    ON m.id_semestre = s.id_semestre
INNER JOIN ciclo ci
    ON m.id_ciclo = ci.id_ciclo
INNER JOIN modalidad mo
    ON m.id_modalidad = mo.id_modalidad;


-- 22. DETALLE DE MATRÍCULA
CREATE OR REPLACE VIEW vista_detalle_matricula AS
SELECT
    id_detalle_matricula AS codigo,
    id_matricula,
    id_plan_estudios,
    estado,
    observaciones
FROM detalle_matricula;


-- 23. PABELLONES
CREATE OR REPLACE VIEW vista_pabellones AS
SELECT
    id_pabellon AS codigo,
    nombre_pabellon AS pabellon
FROM pabellon;


-- 24. AULAS
CREATE OR REPLACE VIEW vista_aulas AS
SELECT
    id_aula AS codigo,
    numero AS aula
FROM aula;


-- 25. DÍAS
CREATE OR REPLACE VIEW vista_dias AS
SELECT
    id_dia AS codigo,
    nombre_dia AS dia
FROM dias;


-- 26. HORARIOS
CREATE OR REPLACE VIEW vista_horarios AS
SELECT
    id_horario AS codigo,
    id_detalle_matricula,
    id_pabellon,
    id_aula,
    id_dia,
    fecha,
    hora_inicio,
    hora_fin,
    total_horas,
    descripcion
FROM horario;
