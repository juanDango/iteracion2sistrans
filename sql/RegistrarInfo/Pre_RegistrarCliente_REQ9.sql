INSERT INTO USUARIO (TIPODOCUMENTO, NUMERODOCUMENTO,CORREOELECTRONICO, ROL,IDUSUARIO)
VALUES ('Cedula',1000500088, 'elcorreo123@gmail.com', 'Cliente', 6000);

INSERT INTO HABITACION (IDHABITACION, TIPOHABITACION, costonoche,capacidadhabitacion,IDHOTEL)
VALUES (303,'Dos Sencillas',160000,2,123);

INSERT INTO HORARIO (IDHORARIO, FECHAINICIO,FECHAFINAL)
VALUES (39,TO_DATE('17/08/2019', 'DD/MM/YYYY'), TO_DATE('26/08/2019', 'DD/MM/YYYY'));

INSERT INTO RESERVA (IDRESERVA, ABONO, IDHABITACION,IDHORARIO,IDCLIENTE)
VALUES (10111,100000,303,39,6000);