# Workshop Spring Boot MongoDB

Este repositório contém o código-fonte para um workshop prático de Spring Boot com integração ao MongoDB. O objetivo deste projeto é demonstrar como criar uma aplicação web RESTful utilizando Spring Boot e MongoDB.

## Visão Geral

Esta aplicação simula um sistema de gerenciamento de usuários e posts. Utilizando o MongoDB como banco de dados, a aplicação permite a criação, leitura, atualização e exclusão (CRUD) de dados de usuários e seus posts.

## Tecnologias Utilizadas

- **Java 11**: Linguagem de programação utilizada.
- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data MongoDB**: Módulo do Spring para integração com MongoDB.
- **MongoDB**: Banco de dados NoSQL utilizado.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.

## Estrutura do Projeto

A estrutura do projeto segue uma organização padrão do Spring Boot:

```
src/main/java/com/example/workshopmongo
│
├── config
│   └── Instantiation.java
│
├── domain
│   ├── Post.java
│   └── User.java
│
├── dto
│   ├── AuthorDTO.java
│   ├── CommentDTO.java
│   └── UserDTO.java
│
├── repository
│   ├── PostRepository.java
│   └── UserRepository.java
│
├── resources
│   ├── UserResource.java
│   └── PostResource.java
│
├── services
│   ├── UserService.java
│   └── PostService.java
│
└── WorkshopmongoApplication.java
```

## Funcionalidades

- **Gerenciamento de Usuários**: 
  - Criação de novos usuários
  - Recuperação de informações de usuários
  - Atualização de informações de usuários
  - Exclusão de usuários

- **Gerenciamento de Posts**: 
  - Criação de novos posts
  - Recuperação de posts por usuário
  - Adição de comentários em posts
  - Exclusão de posts

## Como Executar o Projeto

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/WMBarbosa/workshop-spring-boot-mongodb.git
    ```

2. **Navegue até o diretório do projeto**:
    ```bash
    cd workshop-spring-boot-mongodb
    ```

3. **Execute o projeto utilizando o Maven**:
    ```bash
    mvn spring-boot:run
    ```

4. **Acesse a aplicação**:
    A aplicação estará disponível em `http://localhost:8080`.

## Exemplos de Endpoints

- **Usuários**:
  - `GET /users`: Retorna todos os usuários
  - `GET /users/{id}`: Retorna um usuário específico
  - `POST /users`: Cria um novo usuário
  - `PUT /users/{id}`: Atualiza um usuário existente
  - `DELETE /users/{id}`: Remove um usuário

- **Posts**:
  - `GET /posts`: Retorna todos os posts
  - `GET /posts/{id}`: Retorna um post específico
  - `POST /posts`: Cria um novo post
  - `POST /posts/{id}/comments`: Adiciona um comentário a um post
  - `DELETE /posts/{id}`: Remove um post
