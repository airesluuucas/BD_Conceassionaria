-- 
-- 
-- 

CREATE TABLE IF NOT EXISTS Montadora(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cidade_id INT UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(cidade_id) REFERENCES Cidade (id)
);

desc Montadora;
DROP table IF EXISTS Montadora;
