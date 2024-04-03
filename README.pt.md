[English](README.md) | [Español](README.es.md)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Flyway](https://img.shields.io/badge/Flyway-fa023c?style=for-the-badge&logo=flyway&logoColor=white)](https://flywaydb.org/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)

# Simple Crud API
## 📝 Descrição
Este projeto é uma API Restful desenvolvida em Java com Spring Boot, Hibernate e Postgres, com o objetivo de realizar operações CRUD em uma tabela de banco de dados.

## ⚙️ Tecnologias
- Java 11
- Spring Boot
- Hibernate
- Postgres
- Flyway

## 📦 Instalação
1. Clone o repositório
2. Importe o projeto para sua IDE
3. Execute o projeto
4. Acesse a URL `http://localhost:8080/`

## 🚀 Uso
- Ao executar o projeto, as tabelas serão criadas no banco de dados através do Flyway, e também será realizada uma carga de dados para testes.
- Para testar os Endpoints, importe a Collection JSON para o Postman - 'java-test.postman_collection.json'.
- O projeto inclui scripts que geram as tabelas em um Banco de Dados Postgres.
- Uma pré-carga de dados é gerada pelo script 'V007__carga-de-tabelas.sql' para realizar testes de consulta.
