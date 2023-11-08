# Solução 
- Desenvolvimento de um sistema de provador virtual baseado em tecnologia de realidade aumentada que permitirá que os clientes experimentem virtualmente as roupas antes de fazer a compra.
- Objetivo do projeto: Reduzir a necessidade de trocas e aumentar a satisfação dos clientes ao realizar a compra do produto, permitindo que eles saibam como a roupa ficará neles antes da compra.
- Problema comum na indústria da moda: a insatisfação dos clientes com suas compras devido ao tamanho ou ao caimento da roupa. Essa insatisfação muitas vezes leva à necessidade de trocas, o que pode ser uma experiência frustrante tanto para o cliente quanto para a empresa.
- Benefícios para os clientes: os clientes poderão visualizar como a roupa ficará em seu corpo em tempo real, o que reduzirá a incerteza e a necessidade de trocas, aumentando a satisfação com suas compras.
- Benefícios para a empresa: a solução inovadora reduzirá o impacto ambiental das devoluções de produtos, melhora a eficiência e rentabilidade da empresa e pode levar a um aumento no número de vendas de certos produtos. Uma API para o sistema de controle de gastos pessoais.
<img src="../sprint4.drawio.png"/>

# How To

- 1º Você irá acessar o seu Azure DevOps 
- 2º Em Repos, você irá importar o repositório que está sua aplicação.

## Para importar 
- 1º Na parte superior você irá encontrar o nome da equipe que você criou, ao clicar irá aparecer algumas opções e você irá em `Import Repository`
- 2º Você irá adicionar o link do repositório do GitHub onde está sua aplicação e apertara em importar. Após importar nós iremos para criação da pipeline

## Pipelines
- 1º Você irá apertar na opção de `New Pipeline` e irá na última opção escrita `Use the classic editor`
- 2º Você irá dizer qual o repositório e branch você estará fazendo o build
- 3º Irá selecionar o template do seu projeto, no nosso caso iremos utilizar Maven e ali iremos configurar nossa Pipeline conforme está no nosso arquivo <a href="https://github.com/lucasmoraisnt/WeAr-Digital/blob/main/DevOps/pipeline.yaml">YAML</a>
- 4º Após finalizar as configurações você irá salvar e rodar o build
