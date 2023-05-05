--
--
-- Inserir carros

INSERT INTO Carro(Modelo, cor, valor, ano, montadora_id, marca_id)
    VALUES('BMW X6', 'Verde', 744.95, 2023, (select id from Montadora where nome = 'Auto Motion'), 
    (select id from Marca where nome = 'BMW')),
    ('Sportage', 'Branco', 61.90, 2012, (select id from Montadora where nome = 'Carro Connection'),
    (select id from Marca where nome = 'Kia')), 
    ('Honda Civic', 'Preto',39.90, 2008,(select id from Montadora where nome = 'Carro Inside'),
    (select id from Marca where nome = 'Honda')),
    ('Ferrari 812', 'Vermelho', 6800.00, 2021, (select id from Montadora where nome = 'Diamond Car'),
    (select id from Marca where nome = 'Ferrari')),
    ('EcoSport', 'Patra', 53.98, 2014, (select id from Montadora where nome = 'Urbano Drive'),
    (select id from Marca where nome = 'Ford')),
    ('Volvo S60', 'Branco', 79.89, 2015, (select id from Montadora where nome = 'Carro Connection'),
    (select id from Marca where nome = 'Volvo'));
    
DELETE  FROM Carro
select * from Carro
select * from Marca
select * from montadora