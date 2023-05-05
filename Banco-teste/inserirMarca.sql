--
--
-- Inserir Marca

desc marca;
INSERT INTO Marca(nome, sede, valor)
    VALUES('BMW', 'Alemanha', 41631.00),
    ('Audi', 'Alemanha', 14800.00),
    ('Tesla', 'EUA', 720490.00),
    ('Volvo', 'Suécia', 25363.00),
    ('Kia', 'Coreia do Sul', 6612.00),
    ('Toyota', 'Japão', 59757.00),
    ('Honda', 'Japão', 25500.00),
    ('Ford', 'EUA', 5524.00),
    ('Ferrari', 'França', 41600.00);

-- Ordenando por valor do maior para o menor
select id, nome, sede, valor from Marca ORDER BY valor desc;

-- Ordenando por valor do menor para o maior
select id, nome, sede, valor from Marca ORDER BY valor ;
