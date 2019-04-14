CREATE TABLE  PLAN 
   (	IDPLAN NUMBER, 
	NOMBREPLAN VARCHAR2(50 BYTE), 
	TIPO VARCHAR2(20 BYTE), 
	FECHAINICIAL DATE, 
	FECHAFINAL DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX  PLAN_PK ON  PLAN (IDPLAN) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE  PLAN MODIFY (FECHAFINAL );
  ALTER TABLE  PLAN MODIFY (FECHAINICIAL );
  ALTER TABLE  PLAN MODIFY (TIPO NOT NULL ENABLE);
  ALTER TABLE  PLAN MODIFY (NOMBREPLAN NOT NULL ENABLE);
  ALTER TABLE  PLAN MODIFY (IDPLAN NOT NULL ENABLE);
  ALTER TABLE  PLAN ADD CONSTRAINT PLAN_PK PRIMARY KEY (IDPLAN)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOLOGGING 
  TABLESPACE TBSPROD  ENABLE;