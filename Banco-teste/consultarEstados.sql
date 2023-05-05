--
--
-- Consultar Estados 

select * from Estado;

-- Buscar estado por sigla mostrando todos os dados

select id as ID, nome as Estado, sigla as Sigla, regiao as Região, populacao as População from Estado 
where sigla = 'RJ'

-- Buscar estados por região mostrando todos os dados

select id as ID, nome as Estado, sigla as Sigla, regiao as Região, populacao as População from Estado 
where regiao = 'Norte'

select id as ID, nome as Estado, sigla as Sigla, regiao as Região, populacao as População from Estado 
where regiao = 'Sul'

-- Ordenar por população maior igual a 5 em ordem decrescente

select * from Estado Where populacao >= 5 ORDER BY populacao desc

-- Ordenar por população maior igual a 5 em ordem decrescente

select * from Estado Where populacao >= 5 ORDER BY populacao 

-- Ordenar por população maior igual a 5 em ordem crescente apresentando Nome, Sigla e População

select nome as Estado,
     sigla as Sigla,
     populacao as População from Estado
 Where populacao >= 5 ORDER BY populacao desc

-- Ordenar por região apresentando Nome, Sigla, Região e População

select nome as Estado,
     sigla as Sigla,
     populacao as População, regiao as Região
     from Estado

 ORDER BY regiao

 select * from Estado;