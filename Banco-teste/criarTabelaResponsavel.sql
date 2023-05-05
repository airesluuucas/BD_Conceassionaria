--
-- Tabela Responsavel
--
--

CREATE TABLE IF NOT EXISTS Responsavel(

    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    passe INT UNSIGNED NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY(PASSE)

);
desc Responsavel;