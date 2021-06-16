CREATE TABLE estado_civil (
	id bigint NOT NULL DEFAULT NEXTVAL('estado_civil_id_seq'::regclass),
    estado_civil CHARACTER VARYING,

    PRIMARY KEY (id)
);