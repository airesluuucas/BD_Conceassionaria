--
--
-- Criar Tabela Montadora_Responsavel

CREATE TABLE IF NOT EXISTS Montadora_Responsavel(

    montadora_id INT UNSIGNED NOT NULL,
    responsavel_id INT UNSIGNED NOT NULL,

    FOREIGN KEY(montadora_id) REFERENCES Montadora(id),
    FOREIGN KEY(responsavel_id) REFERENCES Responsavel(id)

);
desc Montadora_Responsavel
DROP table IF EXISTS Montadora_Responsavel;