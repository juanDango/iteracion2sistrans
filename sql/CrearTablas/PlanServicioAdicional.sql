CREATE TABLE PLANSERVICIOADICIONAL 
   (	IDPLAN NUMBER, 
	IDCARACTERISTICA NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX PLANSERVICIOADICIONAL_PK ON PLANSERVICIOADICIONAL (IDPLAN, IDCARACTERISTICA) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE PLANSERVICIOADICIONAL MODIFY (IDCARACTERISTICA NOT NULL ENABLE);
  ALTER TABLE PLANSERVICIOADICIONAL MODIFY (IDPLAN NOT NULL ENABLE);
  ALTER TABLE PLANSERVICIOADICIONAL ADD CONSTRAINT PLANSERVICIOADICIONAL_PK PRIMARY KEY (IDPLAN, IDCARACTERISTICA)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;

  ALTER TABLE PLANSERVICIOADICIONAL ADD CONSTRAINT FK_CARACTERISTICAADICIONAL FOREIGN KEY (IDCARACTERISTICA)
	  REFERENCES CARACTERISTICAADICIONAL (IDCARACTERISTICA) ENABLE;
  ALTER TABLE PLANSERVICIOADICIONAL ADD CONSTRAINT FK_PLANSERVICIO FOREIGN KEY (IDPLAN)
	  REFERENCES PLAN (IDPLAN) ENABLE;