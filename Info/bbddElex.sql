DROP DATABASE IF EXISTS elex;

-- Creamos la Base de Datos con el nombre hyundauto

CREATE DATABASE IF NOT EXISTS elex
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_spanish_ci;

-- Seleccionamos la base de datos

USE elex;

-- Tabla tipoExpediente
CREATE TABLE IF NOT EXISTS tipoExpediente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla Expedientes
CREATE TABLE IF NOT EXISTS expedientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    expediente INT,
    fecha DATE,
    numero VARCHAR(50) NOT NULL,
    materia VARCHAR(100) NOT NULL,
    estado BOOLEAN DEFAULT 1,
    responsable VARCHAR(100) NOT NULL,
    responsable2 VARCHAR(100),
    descripcion TEXT,
    condicion ENUM('confidencial', 'urgente', 'en seguimiento'),
    precio DECIMAL(10, 2),
    consejeria VARCHAR(100)
);

-- Tabla Actuaciones
CREATE TABLE IF NOT EXISTS actuaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha DATE,
    descripcion TEXT,
    estado BOOLEAN DEFAULT 1,
    codigoExpediente INT,
    FOREIGN KEY (codigoExpediente) REFERENCES expedientes(id)
);

-- Tabla Documentos
CREATE TABLE IF NOT EXISTS documentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ruta VARCHAR(255),
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha DATE,
    tipo INT,
    FOREIGN KEY (tipo) REFERENCES actuaciones(id)
);


-- INSERTAMOS VALORES


INSERT INTO tipoExpediente (nombre)
VALUES
        ('ASI'),
        ('INF'),
        ('MO'),
        ('JUD');