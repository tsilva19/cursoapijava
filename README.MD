# CursoAPI

CursoAPI é uma API fictícia desenvolvida para gerenciar cursos de programação. A API permite a criação, listagem, atualização e remoção de cursos. Além disso, permite ativar e desativar cursos.

## Funcionalidades

A API possui as seguintes funcionalidades:

- **Criação de um novo curso**
- **Listagem de todos os cursos**
- **Atualização de um curso pelo ID**
- **Remoção de um curso pelo ID**
- **Ativação/desativação de um curso**

## Estrutura do Curso

Cada curso possui as seguintes propriedades:

- `id`: Identificador único de cada curso
- `name`: Nome do curso
- `category`: Categoria do curso
- `active`: Define se o curso está ativo ou não
- `created_at`: Data de criação do curso
- `updated_at`: Data da última atualização do curso

## Endpoints

### Criar um Novo Curso

- **Rota**: `POST /cursos`
- **Descrição**: Cria um novo curso no banco de dados.
- **Parâmetros**: 
  - `name` (String): Nome do curso (obrigatório)
  - `category` (String): Categoria do curso (obrigatório)
- **Resposta**: O curso criado.

### Listar Todos os Cursos

- **Rota**: `GET /cursos`
- **Descrição**: Lista todos os cursos salvos no banco de dados.
- **Resposta**: Lista de cursos.

### Buscar Cursos

- **Rota**: `GET /cursos/buscar`
- **Descrição**: Busca cursos filtrando por nome e categoria.
- **Parâmetros**:
  - `name` (String): Nome do curso (opcional)
  - `category` (String): Categoria do curso (opcional)
- **Resposta**: Lista de cursos que correspondem aos filtros.

### Atualizar um Curso pelo ID

- **Rota**: `PUT /cursos/{id}`
- **Descrição**: Atualiza um curso pelo ID.
- **Parâmetros**:
  - `name` (String): Nome do curso (opcional)
  - `category` (String): Categoria do curso (opcional)
- **Resposta**: O curso atualizado.

### Remover um Curso pelo ID

- **Rota**: `DELETE /cursos/{id}`
- **Descrição**: Remove um curso pelo ID.
- **Resposta**: Confirmação de remoção.

### Ativar/Desativar um Curso

- **Rota**: `PATCH /cursos/{id}/active`
- **Descrição**: Altera o estado de ativação do curso.
- **Parâmetros**:
  - `active` (boolean): Novo estado de ativação (true para ativo, false para inativo)
- **Resposta**: O curso atualizado.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- Maven
- MySQL (ou qualquer outro banco de dados compatível com JPA)

## Como Executar o Projeto

### Pré-requisitos

- JDK 11+
- Maven
- MySQL (ou outro banco de dados)

### Passos para Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/usuario/cursoapi.git
   cd cursoapi

2. **Configure o banco de dados:**

    - Crie um banco de dados no MySQL.
    - Atualize o arquivo application.properties com as informações do seu banco de dados:
        ```
            spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
            spring.datasource.username=seu_usuario
            spring.datasource.password=sua_senha
            spring.jpa.hibernate.ddl-auto=update

2. **Compile e execute a aplicação:**

    - na aplicação.
        ```
            mvn clean install
            mvn spring-boot:run

### Endpoints

A API estará disponível em http://localhost:8080/cursos

