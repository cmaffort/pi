-- CREATE DATABASE sislocdb;

DROP TABLE IF EXISTS categoria CASCADE;
DROP TABLE IF EXISTS cidade CASCADE;
DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS estado CASCADE;
DROP TABLE IF EXISTS marca CASCADE;
DROP TABLE IF EXISTS modelo CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS veiculo CASCADE;
DROP TABLE IF EXISTS veiculocliente CASCADE;

CREATE TABLE categoria (
    id bigserial CONSTRAINT categoria_pkey PRIMARY KEY,
    descricao text
);

CREATE TABLE marca (
    id bigserial CONSTRAINT marca_pkey PRIMARY KEY,
    descricao text
);

CREATE TABLE modelo (
    id bigserial CONSTRAINT modelo_pkey PRIMARY KEY,
    descricao text
);

CREATE TABLE usuario (
    id bigserial CONSTRAINT usuario_pkey PRIMARY KEY,
    nome text,
    senha text,
    nomecompleto text,
    email text
);

CREATE TABLE estado (
    id bigserial CONSTRAINT estado_pkey PRIMARY KEY,
    sigla varchar(2),
    nome text
);

CREATE TABLE cidade (
    id bigserial CONSTRAINT cidade_pkey PRIMARY KEY,
    nome text,
    estado_id bigint
);

ALTER TABLE cidade ADD CONSTRAINT fk_cidade_estado FOREIGN KEY (estado_id) 
      REFERENCES estado (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE cliente (
    id bigserial CONSTRAINT cliente_pkey PRIMARY KEY,
    nome text,
    cpf text,
    datanasc date,
    endereco text,
    bairro text,
    cidade_id bigint,
    fone text,
    email text
);

ALTER TABLE cliente ADD CONSTRAINT fk_cliente_cidade FOREIGN KEY (cidade_id) 
      REFERENCES cidade (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE veiculo (
    id bigserial CONSTRAINT veiculo_pkey PRIMARY KEY,
    placa text,
    modelo_id bigint,
    marca_id bigint,
    categoria_id bigint,
    descricao text
);

ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) 
      REFERENCES modelo (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_marca FOREIGN KEY (marca_id) 
      REFERENCES marca (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_categoria FOREIGN KEY (categoria_id) 
      REFERENCES categoria (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE veiculocliente (
    id bigserial CONSTRAINT veiculocliente_pkey PRIMARY KEY,
    cliente_id bigint,
    veiculo_id bigint
);

ALTER TABLE veiculocliente ADD CONSTRAINT fk_veiculocliente_modelo FOREIGN KEY (cliente_id) 
      REFERENCES cliente (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE veiculocliente ADD CONSTRAINT fk_veiculocliente_veiculo FOREIGN KEY (veiculo_id) 
      REFERENCES veiculo (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

INSERT INTO usuario(id, nome, senha, nomecompleto, email) VALUES (1, 'admin', md5('admin'), 'Administrador do Sistema', 'admin@sisloc.cefetmg.com');
ALTER SEQUENCE usuario_id_seq RESTART WITH 2;

INSERT INTO estado(id, sigla, nome) VALUES (1, 'MG', 'Minas Gerais');
ALTER SEQUENCE estado_id_seq RESTART WITH 2;

INSERT INTO cidade(id, nome, estado_id) VALUES(1, 'Belo Horizonte', 1);
ALTER SEQUENCE cidade_id_seq RESTART WITH 2;

INSERT INTO categoria(id, descricao) VALUES(1, 'Hatch');
ALTER SEQUENCE categoria_id_seq RESTART WITH 2;

INSERT INTO marca(id, descricao) VALUES(1, 'Fiat');
ALTER SEQUENCE marca_id_seq RESTART WITH 2;

INSERT INTO modelo(id, descricao) VALUES(1, 'ELX 1.4');
ALTER SEQUENCE modelo_id_seq RESTART WITH 2;

INSERT INTO cliente(id, nome, cpf, datanasc, endereco, bairro, cidade_id, fone, email) VALUES(1,'José da Silva Sauro','123.456.789.98','1979-08-20','Rua dos Dinossauros, 210', 'Small Ville', 1, '(31) 3319-6871', 'jose@sauro.com.br');
ALTER SEQUENCE cliente_id_seq RESTART WITH 2;

INSERT INTO veiculo(id, placa, modelo_id, marca_id, categoria_id, descricao) VALUES (1, 'HKC-2455', 1, 1, 1, 'Trovão das sombras');
ALTER SEQUENCE veiculo_id_seq RESTART WITH 2;

INSERT INTO veiculocliente(id, cliente_id, veiculo_id) VALUES(1, 1, 1);
ALTER SEQUENCE veiculocliente_id_seq RESTART WITH 2;
