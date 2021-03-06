CREATE TABLE SERVICIORESERVADO 
   (	IDSERVICIO NUMBER, 
	NOMBREESPECIFICO VARCHAR2(30 BYTE), 
	TIPO VARCHAR2(20 BYTE), 
	DURACION NUMBER, 
	NOMBRESERVICIO VARCHAR2(30 BYTE), 
	DESCRIPCION VARCHAR2(200 BYTE), 
	IDHORARIO NUMBER, 
	COSTO NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX SERVICIORESERVADO_PK ON SERVICIORESERVADO (IDSERVICIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD ;


  ALTER TABLE SERVICIORESERVADO MODIFY (IDHORARIO NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO MODIFY (DESCRIPCION NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO MODIFY (NOMBRESERVICIO NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO MODIFY (DURACION NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO MODIFY (TIPO NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO MODIFY (NOMBREESPECIFICO NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO MODIFY (IDSERVICIO NOT NULL ENABLE);
  ALTER TABLE SERVICIORESERVADO ADD CONSTRAINT SERVICIORESERVADO_PK PRIMARY KEY (IDSERVICIO)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD  ENABLE;
  ALTER TABLE SERVICIORESERVADO ADD CONSTRAINT CK_DURACION CHECK (DURACION > 0) ENABLE;


  ALTER TABLE SERVICIORESERVADO ADD CONSTRAINT FKPK FOREIGN KEY (IDSERVICIO)
	  REFERENCES SERVICIOHOTELCOMPLEMENTARIO (IDSCOMPLEMENTARIO) ENABLE;
  ALTER TABLE SERVICIORESERVADO ADD CONSTRAINT FK_HORARIO FOREIGN KEY (IDHORARIO)
	  REFERENCES HORARIO (IDHORARIO) ENABLE;
