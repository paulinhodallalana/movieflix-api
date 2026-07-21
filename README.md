# 🎬 MovieFlix API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de filmes, categorias, plataformas de streaming e usuários.

O projeto simula uma plataforma de catálogo de filmes, permitindo o gerenciamento completo dos dados e autenticação segura de usuários.

---

## 🚀 Tecnologias utilizadas

* ☕ Java 25
* 🚀 Spring Boot
* 🌱 Spring Data JPA
* 🏦 Hibernate ORM
* 🔐 Spring Security
* 🔑 JWT (JSON Web Token)
* 🔒 BCrypt para criptografia de senha
* 🐘 PostgreSQL
* 🔄 Flyway (controle de migrations)
* 📖 Swagger / OpenAPI
* 📦 Maven
* 🛠 Lombok
* 💻 IntelliJ IDEA

---

# 📌 Funcionalidades

## 🎥 Filmes

* Cadastro de filmes
* Listagem de filmes
* Busca por filmes
* Atualização de filmes
* Exclusão de filmes
* Associação com categorias
* Associação com plataformas de streaming

## 🎭 Categorias

* Cadastro de categorias
* Consulta de categorias
* Atualização
* Remoção

## 📺 Streamings

* Cadastro de plataformas de streaming
* Consulta
* Atualização
* Remoção

## 👤 Usuários

* Cadastro de usuários
* Login com autenticação JWT
* Senhas armazenadas utilizando BCrypt
* Controle de acesso utilizando Spring Security

---

# 🏗 Arquitetura do projeto

O projeto foi desenvolvido seguindo uma arquitetura em camadas:

```
Controller
    ↓
Service
    ↓
Repository
    ↓
Entity
```

### Organização dos pacotes:

```
com.movieflix.movieflix

├── Config
│   ├── SecurityConfig
│   └── TokenService
│
├── Controller
│   ├── MovieController
│   ├── CategoryController
│   ├── StreamingController
│   └── AuthController
│
├── Controller.request
│   └── DTOs de entrada
│
├── Controller.response
│   └── DTOs de saída
│
├── Entity
│   ├── Movie
│   ├── Category
│   ├── Streaming
│   └── User
│
├── Mapper
│   ├── MovieMapper
│   ├── CategoryMapper
│   ├── StreamingMapper
│   └── UserMapper
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

# 🔗 Relacionamentos do Banco de Dados

### Filme e Categoria

```
Movie
  |
  | ManyToMany
  |
Category
```

### Filme e Streaming

```
Movie
  |
  | ManyToMany
  |
Streaming
```

---

# 🔐 Segurança

A autenticação foi implementada utilizando:

* Spring Security
* JWT Token
* BCrypt Password Encoder

Fluxo:

```
Usuário
   |
Login
   |
Validação das credenciais
   |
Geração do Token JWT
   |
Acesso aos endpoints protegidos
```

---

# 🗄 Banco de Dados

Banco utilizado:

```
PostgreSQL
```

As alterações do banco são controladas pelo Flyway:

```
db
 └── migration
      ├── V1__create_tables.sql
      ├── V2__insert_categories.sql
      ├── V3__insert_streamings.sql
      └── ...
```

---

# 📚 Documentação da API

A documentação foi criada utilizando Swagger/OpenAPI.

Após iniciar a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

Exemplo:

* Endpoints documentados
* Modelos de Request
* Modelos de Response
* Testes diretamente pelo navegador

---

# 📌 Exemplos de Endpoints

## Autenticação

```
POST /auth/login
```

Login do usuário e geração do token JWT.

## Filmes

```
GET /movies
```

Lista todos os filmes.

```
POST /movies
```

Cadastra um novo filme.

```
PUT /movies/{id}
```

Atualiza um filme.

```
DELETE /movies/{id}
```

Remove um filme.

---

# 🧪 Validações e tratamento de erros

Implementado:

* Bean Validation
* @Valid nos Controllers
* Exceções personalizadas
* Tratamento global com Controller Advice

---

# 🎯 Objetivo do projeto

Projeto desenvolvido para aprofundar conhecimentos em desenvolvimento **Back-end Java**, aplicando conceitos utilizados no mercado:

* APIs REST
* Segurança
* Banco de dados relacional
* ORM
* Arquitetura em camadas
* Boas práticas de código

---

## 👨‍💻 Desenvolvedor

Paulo Roberto Pereira Dalla Lana

Java Back-end Developer em formação

Tecnologias principais:

Java | Spring Boot | PostgreSQL | APIs REST | Spring Security
