--
-- DECIMAL(9,2) NOT NULL = exe: 1 000 000,00 na casa de mil = 1 trilhão
-- 

CREATE TABLE if NOT EXISTS Marca(
    id INT UNSIGNED NOT NULL  AUTO_INCREMENT, 
    nome VARCHAR(50) NOT NULL,
    sede VARCHAR(50) NOT NULL,
    valor DECIMAL(9,2) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE KEY(nome)

);
drop table Marca;
desc Marca;
