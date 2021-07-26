INSERT INTO public.pessoa(
	nome, idade, cpf, profissao, data_nascimento, estado_civil, endereco, bairro, cidade, estado)
	VALUES ('Jorge Luiz Almeida', 29, 39987311806, 'Técnico Eletrônico', '1992-05-23 00:00:00', 2, 'Rua São Germano, 456', 'Jardim São Judas Tadeu', 'São José dos Campos', 'São Paulo');
	
INSERT INTO public.pessoa(
		nome, idade, cpf, profissao, data_nascimento, estado_civil, endereco, bairro, cidade, estado)
	VALUES ('Graziela Aparecida de Souza', 28, 51423617843, 'Recepcionista', '1993-05-08 00:00:00', 1, 'Avenida Andrômeda, 1506', 'Cidade Jardim', 'São José dos Campos', 'São Paulo');
	
		
INSERT INTO public.pessoa(
		nome, idade, cpf, profissao, data_nascimento, estado_civil, endereco, bairro, cidade, estado)
	VALUES ('Wilma Soares da Silva', 40, 47602772776, 'Gerente de Projetos', '1981-03-13 00:00:00', 3, 'Rua Antônio da Gomes, 897', 'Laranjeiras', 'Rio de Janeiro', 'Rio de Janeiro');
	
		
INSERT INTO public.pessoa(
		nome, idade, cpf, profissao, data_nascimento, estado_civil, endereco, bairro, cidade, estado)
	VALUES ('Lucas da Silva Santos', 30, 38006979804, 'Analista de Suporte', '1990-07-27 00:00:00', 3, 'Avenida das Letras, 618','Vila Branca','Jacareí','São Paulo');
	
		
INSERT INTO public.pessoa(
		nome, idade, cpf, profissao, data_nascimento, estado_civil, endereco, bairro, cidade, estado)
	VALUES ('Eduardo Oliveira', 28, 55831447855, 'Engenheiro de Redes', '1993-10-08 00:00:00', 1, 'Rua São Francisco, 311', 'Bosque dos Ipês', 'São José dos Campos', 'São Paulo');
	
	
INSERT INTO public.dependente(pessoa_id, nome, idade, data_nascimento, estado_civil)
	VALUES (1, 'Hygor Batista de Campos', 10, '2010-11-16 00:00:00', 0);

INSERT INTO public.dependente(pessoa_id, nome, idade, data_nascimento, estado_civil)
	VALUES (2, 'Matheus Oliveira Silva', 30, '1990-06-27 00:00:00', 1);

	
INSERT INTO public.estado_civil(id, estado_civil) VALUES (0, 'SOLTEIRO (A)');

INSERT INTO public.estado_civil(id, estado_civil) VALUES (1, 'UNIÃO ESTÁVEL');

INSERT INTO public.estado_civil(id, estado_civil) VALUES (2, 'CASADO (A)');

INSERT INTO public.estado_civil(id, estado_civil) VALUES (3, 'DIVORCIADO (A)');

INSERT INTO public.estado_civil(id, estado_civil) VALUES (4, 'VIÚVO (A)');