CREATE TABLE   CARACTERISTICASERVICIO 
   (	IDCARACTERISTICA NUMBER, 
	IDSERVCIO NUMBER, 
	NOMBRECARACTERISTICA VARCHAR2(20 BYTE), 
	DESCRIPCION VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;

  CREATE UNIQUE INDEX   CARACTERISTICASERVICIO_PK ON   CARACTERISTICASERVICIO (IDCARACTERISTICA) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE   CARACTERISTICASERVICIO MODIFY (DESCRIPCION NOT NULL ENABLE);
  ALTER TABLE   CARACTERISTICASERVICIO MODIFY (NOMBRECARACTERISTICA NOT NULL ENABLE);
  ALTER TABLE   CARACTERISTICASERVICIO MODIFY (IDSERVCIO NOT NULL ENABLE);
  ALTER TABLE   CARACTERISTICASERVICIO MODIFY (IDCARACTERISTICA NOT NULL ENABLE);
  ALTER TABLE   CARACTERISTICASERVICIO ADD CONSTRAINT CARACTERISTICASERVICIO_PK PRIMARY KEY (IDCARACTERISTICA)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;


  ALTER TABLE   CARACTERISTICASERVICIO ADD CONSTRAINT FK_CARACTSERV FOREIGN KEY (IDSERVCIO)
	  REFERENCES   SERVICIOINCLUIDO (IDSERVICIO) ENABLE;
