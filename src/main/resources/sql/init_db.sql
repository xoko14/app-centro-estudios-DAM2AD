CREATE TABLE `alumnos`(
    `num_exp` INT UNSIGNED NOT NULL,
    `dni` CHAR(9) NOT NULL,
    `nombre` VARCHAR(255) NOT NULL,
    `apellidos` VARCHAR(255) NOT NULL,
    `fecha_nac` DATE NOT NULL
);
ALTER TABLE
    `alumnos` ADD PRIMARY KEY `alumnos_num_exp_primary`(`num_exp`);
CREATE TABLE `asignaturas`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `asignaturas` ADD PRIMARY KEY `asignaturas_id_primary`(`id`);
CREATE TABLE `departamentos`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `departamentos` ADD PRIMARY KEY `departamentos_id_primary`(`id`);
CREATE TABLE `profesores`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `dni` CHAR(9) NOT NULL,
    `nombre` VARCHAR(255) NOT NULL,
    `apellidos` VARCHAR(255) NOT NULL,
    `departamento` INT NOT NULL
);
ALTER TABLE
    `profesores` ADD PRIMARY KEY `profesores_id_primary`(`id`);
CREATE TABLE `imparten`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `profesor` INT NOT NULL,
    `asignatura` INT NOT NULL,
    `alumno` INT NOT NULL,
    `curso` INT NOT NULL
);
ALTER TABLE
    `imparten` ADD PRIMARY KEY `imparten_id_primary`(`id`);
ALTER TABLE
    `imparten` ADD PRIMARY KEY `imparten_profesor_primary`(`profesor`);
ALTER TABLE
    `imparten` ADD PRIMARY KEY `imparten_asignatura_primary`(`asignatura`);
ALTER TABLE
    `imparten` ADD PRIMARY KEY `imparten_alumno_primary`(`alumno`);
ALTER TABLE
    `imparten` ADD PRIMARY KEY `imparten_curso_primary`(`curso`);
ALTER TABLE
    `profesores` ADD CONSTRAINT `profesores_departamento_foreign` FOREIGN KEY(`departamento`) REFERENCES `departamentos`(`id`);