
INSERT INTO Cidade(Nome, estado_id)
    VALUES ('Fortaleza', (select id from Estado where sigla = 'CE'));

INSERT INTO Cidade(Nome, estado_id)
    VALUES ('Brasilia', (select id from Estado where sigla = 'DF')),
     ('Blumenal', (select id from Estado where sigla = 'SC')),
     ('Olinda', (select id from Estado where sigla = 'PE')),
     ('Salvador', (select id from Estado where sigla = 'BA')),
     ('Gramado', (select id from Estado where sigla = 'RS')),
     ('Rio de Janeiro', (select id from Estado where sigla = 'RJ')),
     ('Diamantina', (select id from Estado where sigla = 'MG')),
     ('São Paulo', (select id from Estado where sigla = 'SP'));

     select * from Cidade;