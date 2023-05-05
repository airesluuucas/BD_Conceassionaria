--
--
--
select c.nome as cidade, e.sigla Sigla from Cidade c, Estado e where c.estado_id = e.id;

INSERT INTO Montadora (nome, cidade_id)
    VALUES('Carro Inside', (select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'São Paulo')),
        ('Auto Motion',(select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'Olinda')),
        ('Urbano Drive', (select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'Gramado')),
        ('Carro Connection',(select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'Rio de Janeiro')),
        ('Signature Carro',(select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'São Paulo')),
        ('Diamond Car',(select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'Diamantina'));

select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and e.sigla = 'DF';
select c.id from Cidade c, Estado e WHERE c.estado_id = e.id and c.nome = 'Brasilia';
select * from Montadora;
delete from montadora;

