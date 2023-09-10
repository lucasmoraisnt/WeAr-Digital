INSERT INTO Usuario (nome, email, senha)
VALUES
    ('João Silva', 'joao@email.com', 'senha123'),
    ('Maria Santos', 'maria@email.com', 'senha456'),
    ('Pedro Oliveira', 'pedro@email.com', 'senha789'),
    ('Ana Pereira', 'ana@email.com', 'senha1011'),
    ('Carlos Rodrigues', 'carlos@email.com', 'senha1213');


INSERT INTO Roupa (nome, codigo, preco, cor, tamanho)
VALUES
    ('Camiseta Azul', 'CAM123', 29.99, 'Azul', 42),
    ('Calça Jeans', 'CAL456', 49.99, 'Azul', 34),
    ('Vestido Floral', 'VES789', 69.99, 'Floral', 38),
    ('Tênis Branco', 'TEN1011', 79.99, 'Branco', 40),
    ('Casaco de Inverno', 'CAS1213', 89.99, 'Preto', 36);


INSERT INTO Experimentar (data, descricao, cor, tamanho, roupa_id)
VALUES
    ('2023-09-01', 'Experimentando camiseta azul', 'Azul', 42, 1),
    ('2023-09-02', 'Experimentando calça jeans', 'Azul', 34, 2),
    ('2023-09-03', 'Experimentando vestido floral', 'Floral', 38, 3),
    ('2023-09-04', 'Experimentando tênis branco', 'Branco', 40, 4),
    ('2023-09-05', 'Experimentando casaco de inverno', 'Preto', 36, 5);