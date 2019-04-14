CREATE TABLE DOTACION 
   (	IDDOTACION NUMBER, 
	NOMBREOBJETO VARCHAR2(30 BYTE), 
	ESCOBRABLE CHAR(1 BYTE), 
	VALOROBJETO NUMBER, 
	IDHABITACION NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX DOTACION_PK ON DOTACION (IDDOTACION) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE DOTACION MODIFY (VALOROBJETO NOT NULL ENABLE);
  ALTER TABLE DOTACION MODIFY (ESCOBRABLE NOT NULL ENABLE);
  ALTER TABLE DOTACION MODIFY (NOMBREOBJETO NOT NULL ENABLE);
  ALTER TABLE DOTACION MODIFY (IDDOTACION NOT NULL ENABLE);
  ALTER TABLE DOTACION ADD CONSTRAINT DOTACION_PK PRIMARY KEY (IDDOTACION)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;

  ALTER TABLE DOTACION ADD CONSTRAINT FK_HABITACIONDOTACION FOREIGN KEY (IDHABITACION)
	  REFERENCES HABITACION (IDHABITACION) ENABLE;
  ALTER TABLE DOTACION ADD CONSTRAINT FK_HOTE FOREIGN KEY (IDDOTACION)
	  REFERENCES SERVICIOHOTELCOMPLEMENTARIO (IDSCOMPLEMENTARIO) ENABLE;