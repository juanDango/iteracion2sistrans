CREATE TABLE  SERVICIOALOJAMIENTO 
   (	IDSERVICIOALOJAMIENTO NUMBER, 
	CANTIDADPERSONAS NUMBER, 
	IDCUENTA NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX  SERVICIOALOJAMIENTO_PK ON  SERVICIOALOJAMIENTO (IDSERVICIOALOJAMIENTO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE  SERVICIOALOJAMIENTO MODIFY (IDCUENTA NOT NULL ENABLE);
  ALTER TABLE  SERVICIOALOJAMIENTO MODIFY (IDSERVICIOALOJAMIENTO NOT NULL ENABLE);
  ALTER TABLE  SERVICIOALOJAMIENTO ADD CONSTRAINT SERVICIOALOJAMIENTO_PK PRIMARY KEY (IDSERVICIOALOJAMIENTO)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;
  ALTER TABLE  SERVICIOALOJAMIENTO ADD CONSTRAINT CK_CANTPERSONAS CHECK (cantidadPersonas > 0) ENABLE;


  ALTER TABLE  SERVICIOALOJAMIENTO ADD CONSTRAINT FK_CUENTA FOREIGN KEY (IDCUENTA)
	  REFERENCES  CUENTA (IDCUENTA) ENABLE;