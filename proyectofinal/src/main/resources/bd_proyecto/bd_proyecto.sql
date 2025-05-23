CREATE DATABASE IF NOT EXISTS `educaplus`;

USE `educaplus`;

CREATE TABLE maestros (
    login VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE asignaturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    login_maestro VARCHAR(50),
    FOREIGN KEY (login_maestro) REFERENCES maestros(login) ON DELETE CASCADE
);

CREATE TABLE temas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    id_asignatura INT,
    FOREIGN KEY (id_asignatura) REFERENCES asignaturas(id) ON DELETE CASCADE
);

CREATE TABLE actividades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    objetivos TEXT,
    id_tema INT,
    fechaActividad DATE DEFAULT NULL,
    FOREIGN KEY (id_tema) REFERENCES temas(id) ON DELETE CASCADE
);

CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE alumno_maestro (
    id_alumno INT,
    login_maestro VARCHAR(50),
    PRIMARY KEY (id_alumno, login_maestro),
    FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
    FOREIGN KEY (login_maestro) REFERENCES maestros(login)
);

DROP USER IF EXISTS 'educa'@'localhost';
CREATE USER 'educa'@'localhost' IDENTIFIED BY 'educa';
GRANT ALL PRIVILEGES ON `educaplus`.* TO 'educa'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;


