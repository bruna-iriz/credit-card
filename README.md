## API Simple Bank

API de autorização de transações bancárias para cartão de crédito.

### Tecnologias utilizadas

- Linguagens [Java 11]
- Frameworks [SpringBoot, SpringMVC, Maven]
- Banco de dados [MySQL]
- Documentação [Swagger]
- Testes unitários [JUnit 5]
- Coverage [Jacoco]

### Execução da API

Realizar o clone do projeto:

```sh
$ git clone https://github.com/bruna-iriz/credit-card.git
```
Executar o clean e instalação do Maven na pasta do projeto:

```sh
$ mvn clean install
```
```sh
$ mvn clean package
```
```sh
$ docker-compose up --build
```

### Documentação da API

Endpoints:

| HTTP | ENDPOINT   | DESCRIÇÃO |
| ------     | ------ | ------ |
|GET    |http://localhost:8080/accounts/ | Listar todas as contas de clientes |
|POST   |http://localhost:8080/accounts | Cadastrar uma nova conta de cliente |
|GET    |http://localhost:8080/accounts/{id} | Buscar uma conta de cliente através do id |
|GET    |http://localhost:8080/merchants/{id} | Listar todos os comerciantes |
|POST   |http://localhost:8080/merchants | Cadastrar um novo comerciante |
|GET    |http://localhost:8080/merchants/{id} | Buscar um comerciante através do id|
|DELETE |http://localhost:8080/merchants/{id} | Deletar um comerciante através do id |
|GET    |http://localhost:8080/transactions/ | Listar todas as transações |
|POST   |http://localhost:8080/transactions| Efetivar transações para um cliente existente |
|GET    |http://localhost:8080/transactions/{id} | Buscar uma transação através do id |

### Swagger

| Descrição |  Link |
| ------     | ------ |
| Swagger - Account | http://localhost:8080/swagger-ui.html#/account-controller |
| Swagger - Transactions | http://localhost:8080/swagger-ui.html#/transaction-controller |

- A coleção com as chamadas através do Postman está no diretório: ```./creditcard/postman```

### Coverage

Execute a linha de comando maven:
```sh
mvn clean verify
```

| Descrição | Link | Status |
| ------     | ------ | ------ |
| Relatório de cobertura de testes | target/site/jacoco/index.html | (testes em andamento)

 

> :construction: Projeto em construção :construction: