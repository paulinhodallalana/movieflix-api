# 🎬 MovieFlix API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de filmes, categorias, plataformas de streaming e usuários.

O projeto simula uma plataforma de catálogo de filmes, permitindo gerenciamento de conteúdo, autenticação de usuários e controle de acesso seguro.

A aplicação foi construída seguindo boas práticas de desenvolvimento Back-end, utilizando arquitetura em camadas, DTOs, Mapper, Spring Security com JWT, banco PostgreSQL, migrations com Flyway e ambiente containerizado com Docker.

---

# 🚀 Tecnologias utilizadas

## ☕ Back-end

* Java 25
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* Spring Security
* JWT (JSON Web Token)
* BCrypt Password Encoder
* Bean Validation
* Swagger / OpenAPI
* Lombok
* Maven

## 🗄 Banco de Dados

* PostgreSQL
* Flyway para versionamento das migrations

## 🐳 Ambiente

* Docker
* Docker Compose
* IntelliJ IDEA

---

# 📌 Funcionalidades

## 🎥 Filmes

* Cadastro de filmes
* Listagem de filmes
* Busca de filmes
* Atualização de filmes
* Exclusão de filmes
* Associação entre filmes e categorias
* Associação entre filmes e plataformas de streaming

## 🎭 Categorias

* Cadastro de categorias
* Listagem de categorias
* Atualização
* Exclusão

## 📺 Plataformas de Streaming

* Cadastro de serviços de streaming
* Consulta
* Atualização
* Remoção

## 👤 Usuários

* Cadastro de usuários
* Login com autenticação JWT
* Criptografia de senha utilizando BCrypt
* Controle de acesso utilizando Spring Security

---

# 🏗 Arquitetura do Projeto

O projeto utiliza arquitetura em camadas:

```
Controller
     |
     ↓
Service
     |
     ↓
Repository
     |
     ↓
Entity
```

Separação das responsabilidades:

```
src/main/java/com/movieflix/movieflix

├── Config
│   ├── SecurityConfig
│   └── TokenService
│
├── Controller
│
├── Controller.request
│   └── DTOs de entrada
│
├── Controller.response
│   └── DTOs de saída
│
├── Entity
│
├── Mapper
│
├── Repository
│
├── Service
│
├── Exception
│
└── resources
    └── db/migration
```

---

# 🐳 Docker

O projeto utiliza Docker para criar o ambiente do banco de dados PostgreSQL.

Com Docker, o banco pode ser iniciado rapidamente sem a necessidade de instalação manual.

## Estrutura do ambiente

```
MovieFlix API

Spring Boot
     |
     |
     ↓
PostgreSQL Container
     |
     |
     ↓
Docker
```

---

# 📦 Docker Compose

Arquivo utilizado:

```
docker-compose.yml
```

Exemplo de configuração:

```yaml
services:

  postgres:
    image: postgres:latest
    container_name: postgres-movieflix
    restart: always

    environment:
      POSTGRES_DB: movieflix
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres

    ports:
      - "5433:5432"

    volumes:
      - postgres_data:/var/lib/postgresql/data


volumes:
  postgres_data:
```

---

# ▶️ Executando o projeto com Docker

## 1 - Subir o container PostgreSQL

Na raiz do projeto:

```bash
docker compose up -d
```

---

## 2 - Verificar o container

```bash
docker ps
```

Exemplo:

```
postgres-movieflix
PORT 5433->5432
```

---

## 3 - Parar o ambiente

```bash
docker compose down
```

---

# 🗄 Banco de Dados

Banco utilizado:

```
PostgreSQL
```

Configuração da aplicação:

```
jdbc:postgresql://localhost:5433/movieflix
```

O gerenciamento das alterações do banco é realizado através do Flyway.

Estrutura:

```
src/main/resources/db/migration

V1__create_tables.sql

V2__insert_categories.sql

V3__insert_streamings.sql

V4__create_relationships.sql

...
```

---

# 🔄 Migrations com Flyway

O Flyway permite:

* Controle de versão do banco
* Histórico das alterações
* Criação automática das tabelas
* Organização da evolução do banco

Ao iniciar a aplicação:

```
Spring Boot
      |
      ↓
Flyway verifica migrations
      |
      ↓
Atualiza PostgreSQL
```

---

# 🔗 Relacionamentos JPA

## Filme e Categoria

Relacionamento:

```
Movie

@ManyToMany

Category
```

Tabela intermediária:

```
movie_category
```

---

## Filme e Streaming

Relacionamento:

```
Movie

@ManyToMany

Streaming
```

Tabela intermediária:

```
movie_streaming
```

---

# 🔐 Segurança

A autenticação foi implementada utilizando:

* Spring Security
* JWT
* BCrypt

## Fluxo de autenticação

```
Usuário

↓

Login

↓

Validação email e senha

↓

Geração JWT Token

↓

Acesso aos endpoints protegidos
```

---

# 📚 Documentação Swagger

A API possui documentação utilizando Swagger/OpenAPI.

Após iniciar a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

A documentação apresenta:

* Endpoints disponíveis
* Request Models
* Response Models
* Parâmetros
* Testes da API

---

# 📌 Endpoints principais

## Autenticação

```
POST /auth/login
```

Realiza login e retorna o token JWT.

---

## Filmes

Listar filmes:

```
GET /movies
```

Cadastrar filme:

```
POST /movies
```

Atualizar filme:

```
PUT /movies/{id}
```

Excluir filme:

```
DELETE /movies/{id}
```

---

## Categorias

```
GET /categories

POST /categories

PUT /categories/{id}

DELETE /categories/{id}
```

---

## Streamings

```
GET /streamings

POST /streamings

PUT /streamings/{id}

DELETE /streamings/{id}
```

---

# 🛡 Tratamento de Erros

Implementado:

* Bean Validation
* @Valid
* Exceptions personalizadas
* Controller Advice global

---

# 🧩 Padrões e boas práticas aplicadas

* Arquitetura em camadas
* DTO Pattern
* Mapper Pattern
* Repository Pattern
* Separação de responsabilidades
* Código organizado por domínio
* Controle de exceções
* Segurança baseada em token

---

# 🎯 Objetivo do Projeto

Projeto desenvolvido para aprimorar conhecimentos em desenvolvimento Back-end Java utilizando tecnologias presentes no mercado.

Aplicando conceitos de:

* APIs REST
* Spring Boot
* Segurança de aplicações
* Banco de dados relacional
* ORM
* Docker
* Versionamento de banco
* Boas práticas de desenvolvimento

---

# 👨‍💻 Desenvolvedor

**Paulo Roberto Pereira Dalla Lana**

Java Back-end Developer em formação

Principais tecnologias:

```
Java
Spring Boot
PostgreSQL
Docker
JWT
Hibernate
REST API
```
