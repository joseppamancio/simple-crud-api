[English](README.md) | [Português](README.pt.md)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Flyway](https://img.shields.io/badge/Flyway-fa023c?style=for-the-badge&logo=flyway&logoColor=white)](https://flywaydb.org/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)

# API Simple Crud
## 📝 Descripción
Este proyecto es una API Restful desarrollada en Java con Spring Boot, Hibernate y Postgres, con el objetivo de realizar operaciones CRUD en una tabla de base de datos.

## ⚙️ Tecnologías
- Java 11
- Spring Boot
- Hibernate
- Postgres
- Flyway

## 📦 Instalación
1. Clona el repositorio
2. Importa el proyecto en tu IDE
3. Ejecuta el proyecto
4. Accede a la URL `http://localhost:8080/`

## 🚀 Uso
- Al ejecutar el proyecto, las tablas se crearán en la base de datos a través del Flyway, y también se realizará una carga de datos para pruebas.
- Para probar los Endpoints, importa la Colección JSON en Postman - 'java-test.postman_collection.json'.
- El proyecto incluye scripts que generan las tablas en una base de datos Postgres.
- Una precarga de datos es generada por el script 'V007__carga-de-tabelas.sql' para realizar pruebas de consulta.
