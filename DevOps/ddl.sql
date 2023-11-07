CREATE TABLE Usuario (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE Roupa (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(255),
    preco DECIMAL(19, 2),
    cor VARCHAR(255),
    tamanho INT
);
CREATE TABLE Experimentar (
    id BIGINT PRIMARY KEY,
    data DATE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    cor VARCHAR(255),
    tamanho INT,
    roupa_id BIGINT NOT NULL,
    FOREIGN KEY (roupa_id) REFERENCES Roupa(id)
);