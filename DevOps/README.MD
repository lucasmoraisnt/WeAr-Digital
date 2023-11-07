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
