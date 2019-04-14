CREATE TABLE CUENTASERVICIO 
   (	IDCUENTA NUMBER, 
	IDSERVICIOCOMPLEMENTARIO NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX CUENTASERVICIO_PK ON CUENTASERVICIO (IDCUENTA, IDSERVICIOCOMPLEMENTARIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD ;


  ALTER TABLE CUENTASERVICIO MODIFY (IDSERVICIOCOMPLEMENTARIO NOT NULL ENABLE);
  ALTER TABLE CUENTASERVICIO MODIFY (IDCUENTA NOT NULL ENABLE);
  ALTER TABLE CUENTASERVICIO ADD CONSTRAINT CUENTASERVICIO_PK PRIMARY KEY (IDCUENTA, IDSERVICIOCOMPLEMENTARIO)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD  ENABLE;


  ALTER TABLE CUENTASERVICIO ADD CONSTRAINT FK_IDCUENTASERVICIO FOREIGN KEY (IDCUENTA)
	  REFERENCES CUENTA (IDCUENTA) ENABLE;
  ALTER TABLE CUENTASERVICIO ADD CONSTRAINT FK_IDSERVICIOCOMPLEMENTARIO FOREIGN KEY (IDSERVICIOCOMPLEMENTARIO)
	  REFERENCES SERVICIOHOTELCOMPLEMENTARIO (IDSCOMPLEMENTARIO) ENABLE;