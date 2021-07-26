CREATE TABLE pessoa (
	id bigint NOT NULL DEFAULT NEXTVAL('pessoa_id_seq'::regclass),
    nome varchar(150) NOT NULL,
    idade INTEGER,
    cpf varchar(11) UNIQUE NOT NULL,
    profissao varchar(150),
    data_nascimento TIMESTAMP,
    estado_civil CHARACTER VARYING,
    endereco varchar(150),
    bairro varchar(150),
    cidade varchar(150),
    estado varchar(255), 
    PRIMARY KEY (id)
);