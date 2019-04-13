CREATE TABLE PRODUCTOSERVICIO 
   (	IDPRODUCTO NUMBER, 
	IDSERVICIO NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX PRODUCTOSERVICIO_PK ON PRODUCTOSERVICIO (IDPRODUCTO, IDSERVICIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE PRODUCTOSERVICIO MODIFY (IDSERVICIO NOT NULL ENABLE);
  ALTER TABLE PRODUCTOSERVICIO MODIFY (IDPRODUCTO NOT NULL ENABLE);
  ALTER TABLE PRODUCTOSERVICIO ADD CONSTRAINT PRODUCTOSERVICIO_PK PRIMARY KEY (IDPRODUCTO, IDSERVICIO)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;


  ALTER TABLE PRODUCTOSERVICIO ADD CONSTRAINT FK_PRODUCTO FOREIGN KEY (IDPRODUCTO)
	  REFERENCES PRODUCTO (IDPRODUCTO) ENABLE;
  ALTER TABLE PRODUCTOSERVICIO ADD CONSTRAINT FK_SERVICIO FOREIGN KEY (IDSERVICIO)
	  REFERENCES SERVICIOHOTELCOMPLEMENTARIO (IDSCOMPLEMENTARIO) ENABLE;
