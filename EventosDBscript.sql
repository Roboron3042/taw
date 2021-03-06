-- -----------------------------------------------------
-- Schema EventosDB
-- -----------------------------------------------------

DROP TABLE Etiqueta_has_Eventos;
DROP TABLE Etiqueta;
DROP TABLE Eventos_has_Usuario;
DROP TABLE Chat_has_Mensaje;
DROP TABLE Chat;
DROP TABLE Mensaje;
DROP TABLE Estudio;
DROP TABLE Usuario;
DROP TABLE Asientos;
DROP TABLE Eventos;

-- -----------------------------------------------------
-- Table Eventos
-- -----------------------------------------------------
CREATE TABLE Eventos (
  idEventos INT NOT NULL,
  titulo VARCHAR(50),
  descripcion VARCHAR(255),
  fecha INT,
  fechalim INT,
  coste FLOAT,
  aforo INT,
  nmaxentradas INT,
  asientos VARCHAR(50),
  PRIMARY KEY (idEventos));

-- -----------------------------------------------------
-- Table Asientos
-- -----------------------------------------------------
CREATE TABLE Asientos (
  idAsientos INT NOT NULL,
  filas INT,
  columna INT,
  disp INT,
  idEventos INT NOT NULL,
  PRIMARY KEY (idAsientos, idEventos),
  CONSTRAINT fk_Asientos_Eventos1
    FOREIGN KEY (idEventos)
    REFERENCES Eventos (idEventos)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table Usuario
-- -----------------------------------------------------
CREATE TABLE Usuario (
  correo VARCHAR(50) NOT NULL,
  nombre VARCHAR(50),
  apellidos VARCHAR(50),
  domicilio VARCHAR(50),
  residencia VARCHAR(50),
  edad INT,
  sexo VARCHAR(50),
  rol VARCHAR(50),
  password VARCHAR(50),
  PRIMARY KEY (correo));


-- -----------------------------------------------------
-- Table Estudio
-- -----------------------------------------------------
CREATE TABLE Estudio (
  idEstudio INT NOT NULL,
  "year" INT,
  evento VARCHAR(50),
  usuarios VARCHAR(50),
  titulo VARCHAR(50),
  PRIMARY KEY (idEstudio));


-- -----------------------------------------------------
-- Table Mensaje
-- -----------------------------------------------------
CREATE TABLE Mensaje (
  Idmensaje INT NOT NULL UNIQUE,
  fecha INT,
  contenido VARCHAR(255),
  idUsuario VARCHAR(50) NOT NULL,
  PRIMARY KEY (Idmensaje, idUsuario),
  CONSTRAINT fk_Mensaje_Usuario1
    FOREIGN KEY (idUsuario)
    REFERENCES Usuario (correo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table Chat
-- -----------------------------------------------------
CREATE TABLE Chat (
  idChat INT NOT NULL,
  PRIMARY KEY (idChat));

-- -----------------------------------------------------
-- Table Chat_has_Mensaje
-- -----------------------------------------------------
CREATE TABLE Chat_has_Mensaje (
  idChat INT NOT NULL,
  Idmensaje INT NOT NULL,
  PRIMARY KEY (idChat, Idmensaje),
  CONSTRAINT fk_Chat_has_Mensaje_Chat
    FOREIGN KEY (idChat)
    REFERENCES Chat (idChat)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Chat_has_Mensaje_Mensaje1
    FOREIGN KEY (Idmensaje)
    REFERENCES Mensaje (Idmensaje)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table Eventos_has_Usuario
-- -----------------------------------------------------
CREATE TABLE Eventos_has_Usuario (
  idEventos INT NOT NULL,
  idUsuario VARCHAR(50) NOT NULL,
  PRIMARY KEY (idEventos, idUsuario),
  CONSTRAINT fk_Eventos_has_Usuario_Eventos1
    FOREIGN KEY (idEventos)
    REFERENCES Eventos (idEventos)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Eventos_has_Usuario_Usuario1
    FOREIGN KEY (idUsuario)
    REFERENCES Usuario (correo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table Etiqueta
-- -----------------------------------------------------
CREATE TABLE Etiqueta (
  idEtiqueta INT NOT NULL,
  etiqueta VARCHAR(50),
  PRIMARY KEY (idEtiqueta));


-- -----------------------------------------------------
-- Table Etiqueta_has_Eventos
-- -----------------------------------------------------
CREATE TABLE Etiqueta_has_Eventos (
  idEtiqueta INT NOT NULL,
  idEventos INT NOT NULL,
  PRIMARY KEY (idEtiqueta, idEventos),
  CONSTRAINT fk_Etiqueta_has_Eventos_Etiqueta1
    FOREIGN KEY (idEtiqueta)
    REFERENCES Etiqueta (idEtiqueta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Etiqueta_has_Eventos_Eventos1
    FOREIGN KEY (idEventos)
    REFERENCES Eventos (idEventos)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
