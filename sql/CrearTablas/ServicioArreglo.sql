CREATE TABLE SERVICIOARREGLO 
   (	IDSERVICIO NUMBER, 
	TIPOARREGLO VARCHAR2(30 BYTE), 
	IDHABITACION NUMBER, 
	IDSERVICIOASIGNADO NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX TABLE1_PK1 ON SERVICIOARREGLO (IDSERVICIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE SERVICIOARREGLO ADD CONSTRAINT TABLE1_PK PRIMARY KEY (IDSERVICIO)
  USING INDEX (CREATE UNIQUE INDEX TABLE1_PK1 ON SERVICIOARREGLO (IDSERVICIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD )  ENABLE;
  ALTER TABLE SERVICIOARREGLO MODIFY (IDSERVICIO NOT NULL ENABLE);

  ALTER TABLE SERVICIOARREGLO ADD CONSTRAINT FKHABI FOREIGN KEY (IDHABITACION)
	  REFERENCES HABITACION (IDHABITACION) ENABLE;
  ALTER TABLE SERVICIOARREGLO ADD CONSTRAINT SERVICIOAARREGLAR FOREIGN KEY (IDSERVICIOASIGNADO)
	  REFERENCES SERVICIOHOTELCOMPLEMENTARIO (IDSCOMPLEMENTARIO) ENABLE;
  ALTER TABLE SERVICIOARREGLO ADD CONSTRAINT SERVICIOFKHERENCIA FOREIGN KEY (IDSERVICIO)
	  REFERENCES SERVICIOHOTELCOMPLEMENTARIO (IDSCOMPLEMENTARIO) ENABLE;
