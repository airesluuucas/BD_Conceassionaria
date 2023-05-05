--
--
--
-- Consultar Marcas

select * from Marca
select * from Carro

-- Busca de dados da marca que contem carro ordenado por valor da marca
select * from Marca m, Carro c Where c.marca_id = m.id ORDER BY m.valor desc

-- Busca de dados da marca que contem carro ordenado por valor da marca usando o Join

select m.id as ID, m.nome as Nome, m.sede as Sede, m.valor as Valor 
from Marca m inner join Carro c on c.marca_id = m.id ORDER BY m.valor desc

-- 

select *
from Marca m inner join Carro c on c.marca_id = m.id  
inner join Montadora mont on c.montadora_id = mont.id ORDER BY c.montadora_id;
select * from Montadora;
