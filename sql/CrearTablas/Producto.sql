CREATE TABLE PRODUCTO 
   (	IDPRODUCTO NUMBER, 
	NOMBREPRODUCTO VARCHAR2(30 BYTE), 
	PRECIO NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX PRODUCTO_PK ON PRODUCTO (IDPRODUCTO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE PRODUCTO MODIFY (PRECIO NOT NULL ENABLE);
  ALTER TABLE PRODUCTO MODIFY (NOMBREPRODUCTO NOT NULL ENABLE);
  ALTER TABLE PRODUCTO MODIFY (IDPRODUCTO NOT NULL ENABLE);
  ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_PK PRIMARY KEY (IDPRODUCTO)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;
  ALTER TABLE PRODUCTO ADD CONSTRAINT FK_PRECIO CHECK (PRECIO > 0) ENABLE;
