## Antes de realizar o deploy
Para você realizar o deploy você primeiro irá precisar criar um bd SQL na azure configurar o JDBC aqui dentro da API Spring, lá no properties, depois que você colocar o link do seu bd
você irá precisar colocar suas credenciais do bd.
Depois que finalizar a criação de configuração do BD nós vamos para o aplicativo de serviço onde nós vamos criar um serviço web, informando a **Runtime Stack** com **Java 17**. Logo ao
finalizar a criação nós iremos para o repositório Git onde se encontra a API Spring e entraremos na aba Actions para ver o build e deploy funcionando.

## DDL

### Tabela de Usuário
```
CREATE TABLE Usuario (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);
```

### Tabela de Roupa
```
CREATE TABLE Roupa (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(255),
    preco DECIMAL(19, 2),
    cor VARCHAR(255),
    tamanho INT
);
```

### Tabela de Experimentar
```
CREATE TABLE Experimentar (
    id BIGINT PRIMARY KEY,
    data DATE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    cor VARCHAR(255),
    tamanho INT,
    roupa_id BIGINT NOT NULL,
    FOREIGN KEY (roupa_id) REFERENCES Roupa(id)
);
```

## Movimentações nas tabelas

### Inserir dados na tabela Usuario
```
INSERT INTO Usuario (nome, email, senha)
VALUES
    ('João Silva', 'joao@email.com', 'senha123'),
    ('Maria Santos', 'maria@email.com', 'senha456'),
    ('Pedro Oliveira', 'pedro@email.com', 'senha789'),
    ('Ana Pereira', 'ana@email.com', 'senha1011'),
    ('Carlos Rodrigues', 'carlos@email.com', 'senha1213');
```

### Inserir dados na tabela Roupa
```
INSERT INTO Roupa (nome, codigo, preco, cor, tamanho)
VALUES
    ('Camiseta Azul', 'CAM123', 29.99, 'Azul', 42),
    ('Calça Jeans', 'CAL456', 49.99, 'Azul', 34),
    ('Vestido Floral', 'VES789', 69.99, 'Floral', 38),
    ('Tênis Branco', 'TEN1011', 79.99, 'Branco', 40),
    ('Casaco de Inverno', 'CAS1213', 89.99, 'Preto', 36);
```

### Inserir dados na tabela Experimentar
```
INSERT INTO Experimentar (data, descricao, cor, tamanho, roupa_id)
VALUES
    ('2023-09-01', 'Experimentando camiseta azul', 'Azul', 42, 1),
    ('2023-09-02', 'Experimentando calça jeans', 'Azul', 34, 2),
    ('2023-09-03', 'Experimentando vestido floral', 'Floral', 38, 3),
    ('2023-09-04', 'Experimentando tênis branco', 'Branco', 40, 4),
    ('2023-09-05', 'Experimentando casaco de inverno', 'Preto', 36, 5);
```

### JSON

```
{
  "Usuario": [
    {
      "nome": "João Silva",
      "email": "joao@email.com",
      "senha": "senha123"
    },
    {
      "nome": "Maria Santos",
      "email": "maria@email.com",
      "senha": "senha456"
    },
    {
      "nome": "Pedro Oliveira",
      "email": "pedro@email.com",
      "senha": "senha789"
    },
    {
      "nome": "Ana Pereira",
      "email": "ana@email.com",
      "senha": "senha1011"
    },
    {
      "nome": "Carlos Rodrigues",
      "email": "carlos@email.com",
      "senha": "senha1213"
    }
  ],
  "Roupa": [
    {
      "nome": "Camiseta Azul",
      "codigo": "CAM123",
      "preco": 29.99,
      "cor": "Azul",
      "tamanho": 42
    },
    {
      "nome": "Calça Jeans",
      "codigo": "CAL456",
      "preco": 49.99,
      "cor": "Azul",
      "tamanho": 34
    },
    {
      "nome": "Vestido Floral",
      "codigo": "VES789",
      "preco": 69.99,
      "cor": "Floral",
      "tamanho": 38
    },
    {
      "nome": "Tênis Branco",
      "codigo": "TEN1011",
      "preco": 79.99,
      "cor": "Branco",
      "tamanho": 40
    },
    {
      "nome": "Casaco de Inverno",
      "codigo": "CAS1213",
      "preco": 89.99,
      "cor": "Preto",
      "tamanho": 36
    }
  ],
  "Experimentar": [
    {
      "data": "2023-09-01",
      "descricao": "Experimentando camiseta azul",
      "cor": "Azul",
      "tamanho": 42,
      "roupa_id": 1
    },
    {
      "data": "2023-09-02",
      "descricao": "Experimentando calça jeans",
      "cor": "Azul",
      "tamanho": 34,
      "roupa_id": 2
    },
    {
      "data": "2023-09-03",
      "descricao": "Experimentando vestido floral",
      "cor": "Floral",
      "tamanho": 38,
      "roupa_id": 3
    },
    {
      "data": "2023-09-04",
      "descricao": "Experimentando tênis branco",
      "cor": "Branco",
      "tamanho": 40,
      "roupa_id": 4
    },
    {
      "data": "2023-09-05",
      "descricao": "Experimentando casaco de inverno",
      "cor": "Preto",
      "tamanho": 36,
      "roupa_id": 5
    }
  ]
}
```
