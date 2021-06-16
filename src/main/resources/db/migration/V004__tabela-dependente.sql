CREATE TABLE dependente (
	id bigint NOT NULL DEFAULT NEXTVAL('dependente_id_seq'::regclass),
	pessoa_id bigint NOT NULL,
    nome varchar(100) NOT NULL,
    data_nascimento TIMESTAMP,
    estado_civil CHARACTER VARYING,
    
    PRIMARY KEY (id,pessoa_id),
	FOREIGN KEY (pessoa_id)
      REFERENCES pessoa (id)
);