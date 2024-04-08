DROP DATABASE IF EXISTS elex;

-- Creamos la Base de Datos

CREATE DATABASE IF NOT EXISTS elex
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_spanish_ci;

-- Seleccionamos la base de datos

USE elex;

-- Tabla User

CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR(64),
  role ENUM('ADMIN', 'USER') NOT NULL,
  UNIQUE (username)
);



-- Tabla tipoExpediente

CREATE TABLE IF NOT EXISTS tipo_expediente (
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
    consejeria VARCHAR(100),
    FOREIGN KEY (expediente) REFERENCES tipo_expediente(id)
);

-- Tabla Actuaciones

CREATE TABLE IF NOT EXISTS actuaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    fecha DATE,
    descripcion TEXT,
    estado BOOLEAN DEFAULT 1,
    codigo_expediente INT,
    FOREIGN KEY (codigo_expediente) REFERENCES expedientes(id)
);

-- Tabla Documentos

CREATE TABLE IF NOT EXISTS documentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha DATE,
    archivo BLOB,
    tipo INT,
    FOREIGN KEY (tipo) REFERENCES actuaciones(id)
);


-- INSERTAMOS VALORES
INSERT INTO user (username, password)
VALUES ('soltel', '$2a$10$4S3vjMt4xSMsUK9AlX1qPOecQiSxr/2WqjsL9YMIOf42MRVraMgoe');

        
INSERT INTO tipo_expediente (nombre)
VALUES
        ('ASI'),
        ('INF'),
        ('MO'),
        ('JUD');
        
INSERT INTO expedientes (expediente, fecha, numero, materia, responsable, responsable2, condicion, precio, consejeria, descripcion)
VALUES
    (1, '2023-05-15', '0001-2023-0-1525-FL-AD-01', 'ACTO ADMINISTRATIVO', 'Laura Martinez', 'Juan Perez', 'en seguimiento', 20.5, 'Interior', 'Revisión de documentos relacionados con el acto administrativo.'),
    (4, '2024-04-02', '0001-2023-0-1525-FB-RJ-01', 'RESOLUCIONES JUDICIALES', 'Juan Perez', NULL, 'urgente', 50, 'Justicia y Administracion Local', 'Resolución de un caso judicial complejo.'),
    (1, '2023-05-15', '0001-2023-0-1568-JP-SC-01', 'SUJETOS COLECTIVOS', 'Rodrigo Fernandez', NULL, 'en seguimiento', 15.5, 'Empleo', 'Investigación sobre la situación de los sujetos colectivos.'),
    (4, '2024-06-20', '0002-2023-0-1789-LP-EP-01', 'EMPLEADOS PUBLICOS', 'Maria Lopez', NULL, 'confidencial', 30, 'Presidencia', 'Proceso administrativo para contratación de empleados públicos.'),
    (2, '2024-07-10', '0003-2023-0-1905-PS-SC-02', 'SUJETOS COLECTIVOS', 'Jaime Sanchez', 'Daniel Perez', 'en seguimiento', 25, 'Trabajo y Economía Social', 'Estudio sobre los derechos de los sujetos colectivos.'),
    (4, '2024-04-05', '0004-2023-0-2021-LP-RJ-03', 'RESOLUCIONES JUDICIALES', 'Ana Garcia', NULL, 'urgente', 45, 'Justicia y Administracion Local', 'Apelación de una resolución judicial.'),
    (3, '2024-09-15', '0005-2023-0-2145-PF-EN-04', 'ENERGIA', 'David Fernandez', NULL, 'confidencial', 35.5, 'Energía y Medio Ambiente', 'Estudio de medidas para mejorar la eficiencia energética.'),
    (4, '2024-10-02', '0006-2023-0-2267-JP-EN-02', 'ENSEÑANZA', 'Laura Martinez', NULL, 'urgente', 55, 'Educación y Deporte', 'Desarrollo de un nuevo plan de estudios.'),
    (3, '2024-11-18', '0007-2023-0-2389-SJ-EF-01', 'EXPROPIACION FORZOSA', 'Manuel Gonzalez', NULL, 'en seguimiento', 40, 'Fomento y Vivienda', 'Evaluación de terrenos para expropiación.'),
    (3, '2024-12-07', '0008-2023-0-2503-JP-AD-05', 'CONTRATOS ADMINISTRATIVOS', 'Sara Ruiz', 'Laura Martinez', 'confidencial', 27, 'Hacienda y Financiación Europea', 'Revisión de contratos administrativos vigentes.'),
    (4, '2024-01-22', '0009-2024-0-2625-CP-CI-01', 'CIVIL', 'Daniel Perez', NULL, 'en seguimiento', 60.5, 'Justicia y Administracion Local', 'Estudio de un caso civil complejo.'),
    (2, '2024-02-10', '0010-2024-0-2748-PD-PA-01', 'PATRIMONIO', 'Elena Gomez', 'Maria Lopez', 'urgente', 70, 'Cultura y Patrimonio Histórico', 'Valoración de patrimonio cultural para protección y conservación.');


INSERT INTO  actuaciones (nombre, fecha, descripcion, codigo_expediente)
VALUES

	-- codigo expediente 2
	( 'Notificaciones', '2024-04-02', 'Resolución de un caso judicial complejo.', 2),
    ( 'Citacion y emplazamiento', '2024-04-03', 'Resolución de un caso judicial complejo.', 2),
    ( 'Declaraciones', '2024-04-04', 'Resolución de un caso judicial complejo.', 2),
    ( 'Informes', '2024-04-04', 'Resolución de un caso judicial complejo.', 2),
    ( 'Resoluciones judiciales', '2024-04-05', 'Resolución de un caso judicial complejo.', 2),
    -- codigo expediente 6
    ( 'Notificaciones', '2024-04-05', 'Apelación de una resolución judicial.', 6),
    ( 'Declaraciones', '2024-04-09', 'Apelación de una resolución judicial.', 6),
    ( 'Resoluciones judiciales', '2024-04-10', 'Apelación de una resolución judicial.', 6),
    -- codigo expediente 1
	('Notificaciones', '2023-05-15', 'Notificación de acciones legales a las partes involucradas en el caso.', 1),
    ('Citacion y emplazamiento', '2023-05-15', 'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 1),
    ('Declaraciones', '2024-04-04', 'Registro de declaraciones juradas de testigos o partes involucradas en el caso.', 1),
    ('Informes', '2024-04-04', 'Preparación y presentación de informes técnicos o periciales relevantes para el caso.', 1),
    ('Resoluciones judiciales', '2024-04-05', 'Emisión de resoluciones por parte del tribunal para resolver disputas legales.', 1),
    -- código de expediente 3
    ('Citacion y emplazamiento', '2024-04-02', 'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 3),
    ('Declaraciones', '2024-04-03', 'Registro de declaraciones juradas de testigos o partes involucradas en el caso.', 3),
    ('Resoluciones judiciales', '2024-04-05', 'Emisión de resoluciones por parte del tribunal para resolver disputas legales.', 3),
    -- código de expediente 4
    ('Notificaciones', '2024-07-20', 'Notificación de acciones legales a las partes involucradas en el caso.', 4),
    ('Citacion y emplazamiento', '2024-07-21', 'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 4),
    ('Informes', '2024-07-25', 'Preparación y presentación de informes técnicos o periciales relevantes para el caso.', 4),
    ('Resoluciones judiciales', '2024-07-30', 'Emisión de resoluciones por parte del tribunal para resolver disputas legales.', 4),
    -- código de expediente 5
    ('Citacion y emplazamiento', '2024-08-10', 'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 5),
    ('Declaraciones', '2024-08-15', 'Registro de declaraciones juradas de testigos o partes involucradas en el caso.', 5),
    ('Informes', '2024-08-20', 'Preparación y presentación de informes técnicos o periciales relevantes para el caso.', 5),
    ('Resoluciones judiciales', '2024-08-25', 'Emisión de resoluciones por parte del tribunal para resolver disputas legales.', 5),
    -- código de expediente 7
    ('Notificaciones', '2024-09-02', 'Notificación de acciones legales a las partes involucradas en el caso.', 7),
    ('Citacion y emplazamiento', '2024-09-05', 'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 7),
    ('Declaraciones', '2024-09-10', 'Registro de declaraciones juradas de testigos o partes involucradas en el caso.', 7),
    ('Resoluciones judiciales', '2024-09-15', 'Emisión de resoluciones por parte del tribunal para resolver disputas legales.', 7),
    -- código de expediente 8
    ('Notificaciones', '2024-10-02', 'Notificación de acciones legales a las partes involucradas en el caso.', 8),
    ('Citacion y emplazamiento', '2024-10-05', 'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 8),
    ('Informes', '2024-10-10', 'Preparación y presentación de informes técnicos o periciales relevantes para el caso.', 8),
    ('Resoluciones judiciales', '2024-10-15', 'Emisión de resoluciones por parte del tribunal para resolver disputas legales.', 8);
        
        
INSERT INTO documentos (nombre, fecha, descripcion, tipo)
VALUES
	('Documento Notificacion', '2023-05-15',  'Notificación de acciones legales a las partes involucradas en el caso.', 9),
    ('Citacion y emplazamiento', '2023-05-15',  'Citación oficial y emplazamiento a las partes para comparecer ante el tribunal.', 10);

 -- select * from documentos;
