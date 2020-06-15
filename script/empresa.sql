CREATE TABLE empresa (
    id serial PRIMARY KEY,
    nome varchar (200) NOT NULL,
    descricao varchar (4000)
);

CREATE TABLE marca (
    id serial PRIMARY KEY,
    nome varchar (200) NOT NULL UNIQUE
);

CREATE TABLE patrimonio (
  id serial,
  marca_id int NOT NULL,
  nome varchar (200),
  descricao varchar (4000),
  numero_tombo integer UNIQUE,
  FOREIGN KEY (marca_id) REFERENCES marca(id) ON DELETE CASCADE
);

CREATE TABLE usuario (
    id serial PRIMARY KEY,
    nome varchar (200) NOT NULL,
    email varchar (200) NOT NULL UNIQUE,
    senha varchar (200) NOT NULL
);

INSERT INTO usuario(nome, email, senha) VALUES ('rhandy', 'rhandy@teste.com', '123456');

