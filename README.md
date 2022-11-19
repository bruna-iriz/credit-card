## API CREDIT CARD

API de autorização de transações bancárias para cartão de crédito/benefícios.

### Tecnologias utilizadas

- Linguagens [Java 11]
- Frameworks [SpringBoot, SpringMVC, Maven]
- Banco de dados [MySQL]
- Documentação [Swagger]
- Testes unitários [JUnit 5]
- Coverage [Jacoco]

### Execução da API

Realizar o clone do projeto:

### Build Local
```sh
$ git clone https://github.com/bruna-iriz/credit-card.git
```
Acessar o diretório do projeto e compilar com o maven:
```sh
$ mvn clean install
```
Rodar o projeto:
```sh
$ mvn spring-boot:run
```
### Via Docker

Acessar o diretório do projeto e compilar com o maven:
```sh
$ mvn clean install
```
```sh
$ mvn clean package
```
```sh
$ docker-compose up --build
```
*ps.: (sigo testando se executa corretamente, pois o build via do docker apresentou instabilidade)

### Documentação da API

Endpoints:

| HTTP | ENDPOINT   | DESCRIÇÃO |
| ------     | ------ | ------ |
|GET    |http://localhost:8080/accounts/ | Listar todas as contas de clientes |
|POST   |http://localhost:8080/accounts | Cadastrar uma nova conta de cliente |
|GET    |http://localhost:8080/accounts/{id} | Buscar uma conta de cliente através do id |
|GET    |http://localhost:8080/merchants/{id} | Listar todos os comerciantes |
|POST   |http://localhost:8080/merchants | Cadastrar um novo comerciante com o nome customizado|
|GET    |http://localhost:8080/merchants/{id} | Buscar um comerciante através do id|
|DELETE |http://localhost:8080/merchants/{id} | Deletar um comerciante através do id |
|GET    |http://localhost:8080/transactions/ | Listar todas as transações |
|POST   |http://localhost:8080/transactions| Efetivar transação para um cliente existente |


### Swagger

| Descrição |  Link |
| ------     | ------ |
| Account | http://localhost:8080/swagger-ui.html#/account-controller |
| Merchant | http://localhost:8080/swagger-ui.html#/merchant-controller |
| Transactions | http://localhost:8080/swagger-ui.html#/transaction-controller |

- A coleção com as chamadas através do Postman está no diretório: ```./creditcard/postman```

### Coverage

Execute a linha de comando maven:
```sh
mvn clean verify
```

| Descrição | Link | Status |
| ------     | ------ | ------ |
| Relatório de cobertura de testes | target/site/jacoco/index.html | (testes em andamento)

### :soon: Backlog/Melhorias

- **API/Código:**
    - Melhorias no tratamento de erros
    - Refatoração para deixar o código mais limpo e performático
    - Criar ListAll paginado


- **TESTES | QUALIDADE:**
    - Arquitetura de código [ArchUnit]
    - Qualidade de código [SonarQube]
    - Criar novos cenários de testes e aumentar o coverage
  

### Open Question
L4. Acredito que poderiamos levar essa responsabilidade para o banco de dados e aplicar os conceitos do ACID.
Garantindo a execução completa de uma transação, a consistência de estado entre as operações, persistência e demais características dessa abordagem.

Estudaria qual melhor plano para atender o caso, de preferência que evite cascata para não ter que desafazer várias operações.
Aplicando o protocolo de transação garantindo o Rollback quando necessário.

Em conjunto, investiria em técnicas de código e ferramentas para melhor garantia de performance, resiliência e escalabilidade da aplicação.

### EM BREVE
> :construction: Projeto em construção :construction:
