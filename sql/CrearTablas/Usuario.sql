CREATE TABLE  USUARIO 
   (	TIPODOCUMENTO VARCHAR2(20 BYTE), 
	NUMERODOCUMENTO NUMBER, 
	CORREOELECTRONICO VARCHAR2(50 BYTE), 
	ROL VARCHAR2(20 BYTE), 
	IDUSUARIO NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS NOLOGGING
  TABLESPACE TBSPROD ;


  CREATE UNIQUE INDEX  USUARIO_PK ON  USUARIO (IDUSUARIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE TBSPROD ;


  ALTER TABLE  USUARIO ADD CONSTRAINT USUARIO_PK PRIMARY KEY (IDUSUARIO)
  USING INDEX (CREATE UNIQUE INDEX  USUARIO_PK ON  USUARIO (IDUSUARIO) 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS NOLOGGING 
  TABLESPACE TBSPROD )  ENABLE;
  ALTER TABLE  USUARIO MODIFY (IDUSUARIO NOT NULL ENABLE);
  ALTER TABLE  USUARIO MODIFY (ROL NOT NULL ENABLE);
  ALTER TABLE  USUARIO MODIFY (CORREOELECTRONICO NOT NULL ENABLE);
  ALTER TABLE  USUARIO MODIFY (NUMERODOCUMENTO NOT NULL ENABLE);
  ALTER TABLE  USUARIO MODIFY (TIPODOCUMENTO NOT NULL ENABLE);
  ALTER TABLE  USUARIO ADD CONSTRAINT CK_ROL CHECK (ROL IN ('Cliente', 'Recepcionista', 'Empleado', 'Administrador','Gerente')) ENABLE;
