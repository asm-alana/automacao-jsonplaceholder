#language: pt
#author: Alana Mendes
#version: 1.0
#enconding: UTF-8

  @regressivo
Funcionalidade: Gerenciamento de posts na api JSONPlaceholder
  Eu como administrador do sistema JSONPlaceholder
  Quero criar, atualizar e excluir posts do sistema

Contexto:
  Dado que estou no sistema JSONPlaceholder

  @post
Cenario: Cria novo post na API JSONPlaceholder
  Quando crio um post com dados validos
  Entao o post deve ser criado corretamente
  E o status code do request deve ser 201

  @get
Cenario: Busca post na API JSONPlaceholder
  Quando busco um post ja existente
  Entao os dados do post devem ser retornados
  E o status code do request deve ser 200

 @put
Cenario: Atualiza post na API JSONPlaceholder
   E existe um post na api
   Quando altero os dados do post
   Entao o post deve ser alterado com sucesso
   E o status code do request deve ser 200

  @patch
  Cenario: Atualiza um ou mais dados do post na API JSONPlaceholder
    E existe um post na api
    Quando altero um ou mais dados do post
    Entao o post deve ser alterado com sucesso
    E o status code do request deve ser 200

  @delete
  Cenario: Deleta um post na API JSONPlaceholder
    E existe um post na api
    Quando deleto esse post
    Entao o post deve ser deletado com sucesso
    E o status code do request deve ser 200

  @getSemSucesso
  Cenario: Busca por post com id invalido
    Quando busco por um post com id invalido
    Entao os dados do post nao devem ser retornados
    E o status code do request deve ser 404

  @putSemSucesso
  Cenario: Atualiza dados de post com id invalido
    Quando atualizo um post com id invalido
    Entao eh retornada a mensagem de erro "TypeError: Cannot read properties of undefined (reading 'id')"
    E o status code do request deve ser 500
