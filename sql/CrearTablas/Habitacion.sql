CREATE TABLE HABITACION 
   (	IDHABITACION NUMBER, 
	TIPOHABITACION VARCHAR2(20 BYTE), 
	COSTONOCHE NUMBER, 
	CAPACIDADHABITACION NUMBER, 
	IDHOTEL NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX HABITACION_PK ON HABITACION (IDHABITACION) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE HABITACION MODIFY (IDHOTEL NOT NULL ENABLE);
  ALTER TABLE HABITACION MODIFY (CAPACIDADHABITACION NOT NULL ENABLE);
  ALTER TABLE HABITACION MODIFY (COSTONOCHE NOT NULL ENABLE);
  ALTER TABLE HABITACION MODIFY (TIPOHABITACION NOT NULL ENABLE);
  ALTER TABLE HABITACION MODIFY (IDHABITACION NOT NULL ENABLE);
  ALTER TABLE HABITACION ADD CONSTRAINT PK_IDHABITACION PRIMARY KEY (IDHABITACION)
  USING INDEX (CREATE UNIQUE INDEX HABITACION_PK ON HABITACION (IDHABITACION) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD )  ENABLE;
  ALTER TABLE HABITACION ADD CONSTRAINT FK_CAPACIDAD CHECK (CAPACIDADHABITACION > 0) ENABLE;
  ALTER TABLE HABITACION ADD CONSTRAINT CK_COSTONOCHE CHECK (COSTONOCHE > 0) ENABLE;


  ALTER TABLE HABITACION ADD CONSTRAINT FK_HABHOTEL FOREIGN KEY (IDHOTEL)
	  REFERENCES HOTEL (IDHOTEL) ENABLE;
  ALTER TABLE HABITACION ADD CONSTRAINT FK_TIPOHABITACION FOREIGN KEY (TIPOHABITACION)
	  REFERENCES TIPOHABITACION (NOMBRETIPO) ENABLE;
