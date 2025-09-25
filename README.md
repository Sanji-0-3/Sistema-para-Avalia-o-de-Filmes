# Sistema de Críticas de Cinema

Este é um projeto de um sistema de gerenciamento de filmes e críticas, desenvolvido com Spring Boot, JPA, e MySQL. A aplicação oferece uma API RESTful para manipulação de filmes e análises, além de uma interface web simples para visualização e interação.

## Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias:

* **Backend**: Spring Boot 3.3.2, Spring Data JPA, MySQL Connector/J
* **Banco de Dados**: MySQL 8+
* **Servidor Web**: Apache Tomcat (embarcado)
* **Build Tool**: Apache Maven
* **Frontend**: HTML5, CSS3, JavaScript (com jQuery), Thymeleaf (para templates dinâmicos)

## Estrutura do Projeto

O projeto segue a estrutura padrão de uma aplicação Spring Boot e Maven:

* `pom.xml`: Arquivo de configuração do Maven, listando todas as dependências do projeto.
* `src/main/java/`: Contém o código-fonte Java da aplicação.
    * `br.com.cultura.cinema.model`: Classes de entidades (`Filme` e `Analise`) que mapeiam as tabelas do banco de dados.
    * `br.com.cultura.cinema.repository`: Interfaces para acesso a dados, utilizando o Spring Data JPA.
    * `br.com.cultura.cinema.controller`: Controladores REST e MVC para gerenciar as requisições HTTP.
* `src/main/resources/`: Contém os recursos da aplicação.
    * `static/`: Arquivos estáticos (HTML, CSS, JavaScript) para o frontend.
    * `templates/`: Templates HTML para renderização via Thymeleaf.
    * `application.properties`: Propriedades de configuração da aplicação, incluindo as informações de conexão com o banco de dados MySQL.

## Configuração e Execução

Para rodar o projeto localmente, siga os passos abaixo:

1.  **Pré-requisitos**: Certifique-se de ter o **JDK 17** e o **MySQL 8+** instalados.
2.  **Configuração do Banco de Dados**:
    * Crie um banco de dados MySQL com o nome `cinema`.
    * As configurações do banco de dados estão no arquivo `src/main/resources/application.properties`.
3.  **Execução da Aplicação**:
    * Navegue até o diretório raiz do projeto no seu terminal.
    * Execute o comando Maven para rodar a aplicação:
        ```bash
        mvn spring-boot:run
        ```
    * A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API RESTful

O sistema oferece os seguintes endpoints para gerenciamento de filmes e análises:

* **Filmes (`/api/filmes`)**:
    * `GET /api/filmes`: Lista todos os filmes.
    * `GET /api/filmes/{id}`: Busca um filme específico por ID.
    * `POST /api/filmes`: Cria um novo filme.
    * `PUT /api/filmes/{id}`: Atualiza um filme existente.
    * `DELETE /api/filmes/{id}`: Deleta um filme.
* **Análises (`/api/filmes/{id}/analises`)**:
    * `GET /api/filmes/{id}/analises`: Lista as análises de um filme específico.
    * `POST /api/filmes/{id}/analises`: Adiciona uma nova análise a um filme.
    * `DELETE /api/filmes/{id}/analises/{analiseId}`: Deleta uma análise de um filme.

---

Para que você possa rodar o projeto, é essencial que a conexão com o banco de dados MySQL esteja configurada corretamente. Você já criou o banco de dados? Se não, posso orientá-lo sobre como fazer isso.
