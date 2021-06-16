CREATE TABLE pessoa (
	id bigint NOT NULL DEFAULT NEXTVAL('pessoa_id_seq'::regclass),
    nome varchar(100) NOT NULL,
    data_nascimento TIMESTAMP,
    estado_civil CHARACTER VARYING,
    
    PRIMARY KEY (id)
);