CREATE DATABASE POO_GRUPO3;
CREATE SCHEMA POO_Grupo3;
SET search_path TO POO_Grupo3;

-------------------------------- CRIAÇÃO DAS TABELAS E CONEXÕES --------------------------------

CREATE TYPE estado as ENUM ('ATIVO', 'DESATIVADO', 'FERIAS', 'AFASTADO', 'DEPENDENTE');

CREATE TABLE funcionario
(
 id_funcionario SERIAL PRIMARY KEY,
 nome VARCHAR NOT NULL,
 data_nasc DATE NOT NULL,
 CPF VARCHAR NOT NULL UNIQUE,
 salario_bruto NUMERIC(10,2) NOT NULL,
 situacao estado NOT NULL DEFAULT 'ATIVO'
);

CREATE INDEX idx_funcionario_cpf 
ON funcionario (CPF);

CREATE TABLE dependente
(
 id_dependente SERIAL PRIMARY KEY,
 nome VARCHAR NOT NULL,
 data_nasc DATE NOT NULL,
 CPF VARCHAR NOT NULL UNIQUE,
 id_funcionario INT NOT NULL,
 parentesco VARCHAR NOT NULL
);
ALTER TABLE dependente ADD FOREIGN KEY(id_funcionario) REFERENCES funcionario (id_funcionario)
ON DELETE CASCADE;

CREATE INDEX idx_dependente_cpf
ON dependente (CPF);

CREATE TABLE folha_de_pagamento
( 
 codigo SERIAL PRIMARY KEY,
 data_pagamento DATE NOT NULL,
 descontoINSS FLOAT NOT NULL,
 descontoIR FLOAT NOT NULL,
 salario_Liquido FLOAT NOT NULL,
 id_funcionario INT NOT NULL
);
ALTER TABLE folha_de_pagamento ADD FOREIGN KEY(id_funcionario) REFERENCES funcionario (id_funcionario)
ON DELETE RESTRICT;