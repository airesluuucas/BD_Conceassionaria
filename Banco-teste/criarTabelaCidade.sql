--
-- FOREIGN KEY == chave estrangeira
-- FOREIGN KEY(estado_id) REFERENCES Estado (id) chave estrangeira referencia o id da tabela estado
--

CREATE TABLE if NOT EXISTS Cidade(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    estado_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (nome), 
    FOREIGN KEY(estado_id) REFERENCES Estado (id)
);
DROP table IF EXISTS Cidade;
