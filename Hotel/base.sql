USE sistema_hotel;

INSERT INTO plan (nombre,precio,caracteristica) VALUES ('simple',500,'asd');

INSERT INTO estadoMembresia (id,nombre) VALUES (1,'activa');
INSERT INTO estadoMembresia (id,nombre) VALUES (2,'aviso');
INSERT INTO estadoMembresia (id,nombre) VALUES (3,'prueba');
INSERT INTO estadoMembresia (id,nombre) VALUES (4,'vencida');

INSERT INTO estadoPago (id,nombre) VALUES (1,'pendiente');
INSERT INTO estadoPago (id,nombre) VALUES (2,'confirmado');
INSERT INTO estadoPago (id,nombre) VALUES (3,'incompleto');
INSERT INTO estadoPago (id,nombre) VALUES (4,'anulado');

INSERT INTO tipoUsuario (nombre) VALUES ('root');
INSERT INTO tipoUsuario (nombre) VALUES ('owner');
INSERT INTO tipoUsuario (nombre) VALUES ('user');

INSERT INTO sexo (nombre) VALUES ('masculino');
INSERT INTO sexo (nombre) VALUES ('femenino');

INSERT INTO pais (nombre) VALUES ('argentina');

INSERT INTO tipoDocumento (nombre) VALUES ('du');

INSERT INTO membresia (fechaActivacion,fechaVencimiento,fechaAviso,id_estadoMembresia) VALUES ('2016-01-30', '2016-02-21', '2016-02-14', 3);
INSERT INTO hotel (nombre,id_owner,id_membresia,id_plan) VALUES ('Hotel Palace',null,1,1);
INSERT INTO usuario (clave,email,nick,id_tipoUsuario,id_hotel,orden) VALUES ('daa4699d635fac8f363e6406d815d7a1','test@test.com','test',1,2,1);
INSERT INTO persona (DISC,apellido,email,nombre,telefono,fechaNacimiento, id_sexo, id_pais, id_tipoDocumento,id_domicilio,id_usuario, cuil, id_vehiculo)
    VALUES ('owner','garcia','garcia@asd.com','pepe',null,null,1,1,1,null,1,null,null);
UPDATE hotel SET id_owner = 1 WHERE id = 1;

UPDATE membresia SET id_estadoMembresia = 4 WHERE id = 1;