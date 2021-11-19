# API Rest de consulta de cidades do Brasil

Este projeto faz parte de um Bootcamp de Java oferecido pela empresa [Digital Innovation One](https://digitalinnovation.one/). Foi desenvolvida uma API Rest de consulta de cidades do Brasil utilizando Spring Boot. São disponibilizados recursos para listar os dados de todas as cidades do Brasil, assim como obter os dados de uma única cidade informando um id. Também foi implementado um recurso que realiza o cálculo da distância entre duas cidades informando seus respectivos id's. O cálculo é realizado por uma consulta do próprio banco de dados que utiliza os valores da latitude e longitude e retorna o resultado em metros (no entanto, a resposta é exibida em quilômetros). O banco de dados foi populado com todos os países, assim como todos os estados e cidades do Brasil. Assim, também é possível obter a lista de todos os países e todos os estados brasileiros, ou buscar um registro específico informando o id. Por fim, foi feito o deploy da aplicação no Heroku.

## Tecnologias utilizadas:

* Sistema Operacional: Ubuntu 20.04.3 LTS;
* Versionamento: Git/GitHub;
* Linguagem de programação: Java 11;
* Conteinerização do banco de dados: Docker;
* Banco de dados: Postgres; 
* IDE: IntelliJ Community;
* Deploy da aplicação: Heroku CLI;
* Testes da API: Postman.

## [Spring Initializr](https://start.spring.io/):

- Project: Gradle Project;
- Spring Boot: 2.6.0;
- Packaging: Jar;
- Java: 11;
- Dependências:
  - Spring Web;
  - Lombok;
  - PostgreSQL Driver;
  - Spring Data JPA.

## Criando container postgres:

* [Postgres DockerHub](https://hub.docker.com/_/postgres)

```bash
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

## Populando o banco de dados utilizando um cliente também em forma de container:

* [Repositório com scripts](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```bash
git clone git@github.com:chinnonsantos/sql-paises-estados-cidades.git
cd sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v "$PWD":/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql
```

## Acessando o cliente do banco de dados:

```bash
psql -h localhost -U postgres_user_city cities
```

## Habilitando extensão para o cálculo da distância:

```bash
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

## Consulta SQL para retornar a distância entre duas cidades utilizando latitude e longitude:

- [Postgres Earth Distance](https://www.postgresql.org/docs/current/earthdistance.html)

- Cube-Based Earth Distances

  - ```sql
    SELECT earth_distance(
        ll_to_earth(-21.95840072631836,-47.98820114135742), 
        ll_to_earth(-22.01740074157715,-47.88600158691406)
    ) AS distance;
    ```
