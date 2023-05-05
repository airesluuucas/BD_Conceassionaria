-- Criando a tabela estado!
--
-- UNSIGNER = SEM SINAL
-- UNIQUE KEY = NÃO REPETIR
-- PRIMARY KEY = CHAVE PRIMARIA
-- AUTO_INCREMENT 
-- desc estado == descrever a tabela estado
-- Drop table == excluir tabela
-- IF NOT EXISTS = SE NÃO EXISTIR
-- IF EXISTS = SE EXISTIR
--

create table Estado (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    sigla VARCHAR(2) NOT NULL,
    regiao ENUM('Norte','Nordeste','Centro-Oeste','Sudeste', 'Sul') NOT NULL,
    populacao DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (nome),
    UNIQUE KEY (sigla)
);
desc Estado;

DROP table IF EXISTS Estado;