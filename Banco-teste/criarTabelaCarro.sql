--
-- Tabela carro
--
--

CREATE TABLE IF NOT EXISTS Carro(

    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(45) NOT NULL,
    cor VARCHAR(35) NOT NULL,
    valor DECIMAL(6,2) UNSIGNED NOT NULL,
    ano INT UNSIGNED NOT NULL,
    montadora_id int UNSIGNED NOT NULL,
    marca_id int UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(montadora_id) REFERENCES Montadora(id),
    FOREIGN KEY(marca_id) REFERENCES Marca(id)

);

desc Carro;
drop table Carro;