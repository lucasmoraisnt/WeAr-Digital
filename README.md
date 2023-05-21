# WeAr

## Solução e Escopo

- Desenvolvimento de um sistema de provador virtual baseado em tecnologia de realidade aumentada que permitirá que os clientes experimentem virtualmente as roupas antes de fazer a compra.
- Objetivo do projeto: Reduzir a necessidade de trocas e aumentar a satisfação dos clientes ao realizar a compra do produto, permitindo que eles saibam como a roupa ficará neles antes da compra.
- Problema comum na indústria da moda: a insatisfação dos clientes com suas compras devido ao tamanho ou ao caimento da roupa. Essa insatisfação muitas vezes leva à necessidade de trocas, o que pode ser uma experiência frustrante tanto para o cliente quanto para a empresa.
- Benefícios para os clientes: os clientes poderão visualizar como a roupa ficará em seu corpo em tempo real, o que reduzirá a incerteza e a necessidade de trocas, aumentando a satisfação com suas compras.
- Benefícios para a empresa: a solução inovadora reduzirá o impacto ambiental das devoluções de produtos, melhora a eficiência e rentabilidade da empresa e pode levar a um aumento no número de vendas de certos produtos. Uma API para o sistema de controle de gastos pessoais.

## Arquitetura da solução

![image](https://github.com/Daniel-lpj/WeAr/assets/106287851/7f82db36-ec6c-46cb-9a63-4c357e925ea7)


## Endpoints
- Experimentar
    - [Cadastrar](#cadastrar-experimentar)
    - Listar todas
    - Apagar
    - Alterar
    - [Mostrar os detalhes](#detalhar-experimentar)
- Roupa
    - [Cadastrar](#cadastrar-roupa)
    - Listar todas
    - Apagar
    - Alterar
   - [Mostrar os detalhes](#detalhar-roupa)

---

### Cadastrar Experimentar
`POST` /wear/api/experimentar

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| roupa_id | int | sim | é o id de uma roupa previamente cadastrada
| data | data | sim | é data do cadastro de experimentar
| descricao | texto | não | uma descrição com no máximo 255 caracteres
| cor | lista | não | são as cores disponíveis para a roupa
| tamanho | lista | não | são os tamanhos disponíveis para a roupa

**Exemplo de corpo do request**

```js
{
    "roupa_id" : 1,
    "data": "2023-01-01",
    "descricao": "Calça camuflada",
    "cor": ["Azul", "Preto"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 201 | experimentar cadastrado com sucesso
| 400 | erro na validação dos dados da requisição

---

### Detalhar Experimentar
`GET` /wear/api/experimentar/{id}

**Exemplo de corpo da resposta**

```js
{
    "roupa": {
        "roupa_id" : 1,
        "nome": "Camiseta"
    },
    "data": "2023-01-27",
    "descricao": "camiseta de praticar esportes",
    "cor": ["Branca", "Preto", "Azul"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrada roupa com o id informado

---


### Cadastrar Roupa
`POST` /wear/api/ropupa

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|--
| id | int | sim | é o id de uma roupa
| nome | texto | sim | é o nome da roupa
| codigo | texto | sim | é o código da roupa
| preco | int | sim | é o preço da roupa
| cor | lista | não | são as cores disponíveis para a roupa
| tamanho | lista | não | são os tamanhos disponíveis para a roupa

**Exemplo de corpo do request**

```js
{
    "id" : 1,
    "nome": "Camiseta",
    "codigo": "123"
    "preco": 50,00,
    "cor": ["Azul", "Preto"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 201 | experimentar cadastrado com sucesso
| 400 | erro na validação dos dados da requisição

---

### Detalhar Roupa
`GET` /wear/api/roupa/{id}

**Exemplo de corpo da resposta**

```js
{
    "roupa": {
        "id" : 1,
        "nome": "Camiseta"
    },
    "codigo": "123"
    "preco": 50,00,
    "cor": ["Azul", "Preto"],
    "tamanho": ["P", "M", "G"]
}
```

**Códigos de Resposta**

| código | descrição 
|-|-
| 200 | dados retornados no corpo da resposta
| 404 | não foi encontrada roupa com o id informado
