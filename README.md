## PROJETO DE AUTOMAÇÃO DA API JSONPlaceholder
---
Projeto desenvolvido para demonstrar os conhecimentos adquiridos na realização de testes de API REST.
---

PRÉ-REQUISTOS
----
Requisitos de software e hardware necessários para executar esse projeto de automação:
  - Java 14 SDK
  - Eclipse IDE ou IntelliJ IDE
  - Maven 3.0
  - Rest Assured
  - JUnit 
  - Plugins:
      - Cucumber Eclipse Plugin
      - Cucumber for Java + Gherkin (IntelliJ)
      - Lombok
  - Postman
  
ESTRUTURA DO PROJETO
---
 
 | Diretório                         | Finalidade                                                                                   |
 ------                              |--------                                                                                      |
 | src\test\java\api                 | Local em que devem ser criados os objetos que configuram requisições e validações da api     |
 | src\test\java\pojo                | Local onde são criados construtores e métodos para interação da página web com as steps      |
 | src\test\java\runner              | Local com as configurações da Cucumber Runner                                                |
 | src\test\java\steps               | Métodos que executam os passos das funcionalidades criadas com o BDD                         |
 | src\test\java\utils               | Local em que são são criados métodos utils para serem utilizados como apoio a outras classes |
 | src\test\resources\features       | Funcionalidade e cenários de teste escritos em linguagem DSL (Gherkin language)              |
 | src\target\report                 | Local com pastas das evidências e relatórios gerados após cada execução dos testes           |

 FRAMEWORKS UTILIZADOS
 ------
 Abaixo estão os frameworks utilizados nesse projeto:
  - Cucumber: Responsável pela especificação executável dos cenários;
  - Rest Assured - Responsável pelos interação com a camada HTTP para teste de API (Json, Soap, Xml);
  - JUnit: Responsável pela execução dos testes unitários junto ao Cucumber.
  
 AUTORES
 -------
  - Alana Mendes - analista de automação de testes.