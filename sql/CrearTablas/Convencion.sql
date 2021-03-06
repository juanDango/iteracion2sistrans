--------------------------------------------------------
--  File created - Tuesday-April-16-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CONVENCION
--------------------------------------------------------

  CREATE TABLE CONVENCION 
   (	IDCONVENCION NUMBER, 
	IDHOTEL NUMBER, 
	NUMPARTICIPANTES NUMBER, 
	NOMBRECONVENCION VARCHAR2(30 BYTE), 
	IDHORARIO NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD ;
--------------------------------------------------------
--  DDL for Index CONVENCION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX CONVENCION_PK ON CONVENCION (IDCONVENCION) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD ;
--------------------------------------------------------
--  Constraints for Table CONVENCION
--------------------------------------------------------

  ALTER TABLE CONVENCION MODIFY (NUMPARTICIPANTES NOT NULL ENABLE);
  ALTER TABLE CONVENCION MODIFY (IDHOTEL NOT NULL ENABLE);
  ALTER TABLE CONVENCION MODIFY (IDCONVENCION NOT NULL ENABLE);
  ALTER TABLE CONVENCION ADD CONSTRAINT CONVENCION_PK PRIMARY KEY (IDCONVENCION)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE TBSPROD  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CONVENCION
--------------------------------------------------------

  ALTER TABLE CONVENCION ADD CONSTRAINT FK_HOTELCONVENCION FOREIGN KEY (IDHOTEL)
	  REFERENCES HOTEL (IDHOTEL) ENABLE;
