# Projeto {VetLove} - Backend (trabalho-api)

## Descrição

{Descrição do projeto com o objetivo principal}

O sistema tem como objetivo facilitar o agendamento de consultas, gerir estoques de medicamentos e insumos veterinários.

## Tecnologias Utilizadas

- Java {17}
- Spring Boot {3.3.4}
- H2 Database
- Lombok
- MapStruct {1.6.2}
- SpringDoc OpenAPI {2.6.0}
- Therapi {0.15.0}

## Pré-requisitos

- JDK {17}

## Instalação

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/DeniseSS/VetLove.git
   ```

2. **Navegue até o diretório do projeto:**

   ```bash
   cd C:/developer/trabalho-api-main
   ```

3. **Configure o banco de dados:**

   Edite o arquivo [application.yaml](src/main/resources/application.yaml) com as configurações do seu banco de dados.

4. **Compile e execute o projeto:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   A API estará disponível em `http://localhost:8080`.

## Documentação da API (Swagger)

A documentação da API pode ser acessada por meio do Swagger. Após iniciar o backend, você pode acessar a documentação por meio da seguinte URL:

[/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Endpoints

Abaixo está a descrição dos principais endpoints da API:

### **1. GET /pets**

- **Descrição:** Retorna uma lista de animais cadastrados.
- **Parâmetros de Consulta:**
  - `page` (opcional): Número da página.
  - `size` (opcional): Número de itens por página.
- **Resposta:**

  - **200 OK**
    ```json
    [
    {
    "id": 1,
    "name": "Bob",
    "species": "dog",
    "vaccinated": true,
    "age": 2,
    "owner": "Jay",
    "weight": 5.5,
    "gender": "male"
    },
    {
    "id": 2,
    "name": "Leslie",
    "species": "Dog",
    "vaccinated": true,
    "age": 2,
    "owner": "Michel",
    "weight": 2,
    "gender": "Famale"
    }
    ]

  ```

  ```

### **2. POST /pets**

- **Descrição:** Cadastra um novo Animal.
- **Corpo da Requisição:**
  ```json
  {
    "id": 2,
    "name": "Leslie",
    "species": "Cat",
    "vaccinated": true,
    "age": 1,
    "owner": "Michel",
    "weight": 2,
    "gender": "Female"
  }
  ```
- **Resposta:**
  - **201 Created**
    ```json
    {
      "id": 2,
      "name": "Leslie",
      "species": "Cat",
      "vaccinated": true,
      "age": 1,
      "owner": "Michel",
      "weight": 2,
      "gender": "Female"
    }
    ```

### **3. GET /pets/{id}**

- **Descrição:** Retorna um Animal específico pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do Animal.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 1,
      "name": "Bob",
      "species": "dog",
      "vaccinated": true,
      "age": 2,
      "owner": "Alice",
      "weight": 5.5,
      "gender": "Male"
    }
    ```
  - **404 Not Found** (se o Animal não for encontrado)

### **4. PUT /pets/{id}**

- **Descrição:** Atualiza um Animal existente.
- **Corpo da Requisição:**
  ```json
  {
    "id": 2,
    "name": "Leslie",
    "species": "Dog",
    "vaccinated": true,
    "age": 2,
    "owner": "Michel",
    "weight": 2,
    "gender": "Famale"
  }
  ```
- **Parâmetros de Caminho:**
  - `id`: ID do Animal.
- **Resposta:**
  - **200 OK**
    ```json
    {
      "id": 2,
      "name": "Leslie",
      "species": "Dog",
      "vaccinated": true,
      "age": 2,
      "owner": "Michel",
      "weight": 2,
      "gender": "Famale"
    }
    ```
  - **404 Not Found** (se o Animal não for encontrado)

### **5. DELETE /pets/{id}**

- **Descrição:** Remove um Animal pelo ID.
- **Parâmetros de Caminho:**
  - `id`: ID do Animal.
- **Resposta:**
  - **204 No Content**
  - **404 Not Found** (se o Animal não for encontrado)
