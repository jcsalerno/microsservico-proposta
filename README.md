<div align="center">
 <h1>📦 Sistema de Propostas - Microsserviços </h1>
  <img src="microsservico-matheus.png" style="width: 320px; height: 320px; object-fit: cover;" />
</div>



Este projeto faz parte do curso ministrado por Matheus Pieropan na Udemy e tem como objetivo a construção de uma aplicação completa com backend em **Spring Boot** e frontend em **Angular**, utilizando contêineres Docker.

## 🔧 Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Jakarta Validation
- Lombok
- MapStruct
- PostgreSQL
- Docker

## 🐳 Docker Como executar

### 1. Subir o front-end

Para iniciar o frontend em Docker, execute:

```bash
docker run -d -p 80:80 --name proposta-web-container matheuspieropan/proposta-web
```
# 🧪 Execução da Aplicação

A aplicação estará disponível em: [http://localhost](http://localhost)

## ▶️ Executar o Backend

Certifique-se de estar com o **Java 21** instalado e rode o backend com o Spring Boot:

```bash
./mvnw spring-boot:run

```
# 🗃️ Configuração do Banco de Dados

## Criar Banco de Dados Manualmente (PostgreSQL)

```bash
psql -U postgres -h localhost -c "CREATE DATABASE propostadb;"
```


## 📄 Endpoints da API

| Método | Rota        | Descrição                                              |
|--------|-------------|--------------------------------------------------------|
| POST   | `/proposta` | Cria uma nova proposta com base nos dados do usuário. |
| GET    | `/proposta` | Lista todas as propostas cadastradas.                 |

---

## 📚 Funcionalidades

- ✅ Criar uma nova proposta
- 📋 Listar todas as propostas existentes

---

## 🧠 Estrutura do Projeto

```text
controller/   -> Camada responsável por expor os endpoints REST.  
dto/          -> Objetos de transferência de dados (entrada e saída da API).  
entity/       -> Mapeamento das entidades persistidas no banco de dados.  
mapper/       -> Conversão entre entidades e DTOs usando MapStruct.  
service/      -> Lógica de negócio central da aplicação.  
config/       -> Configurações do projeto (ex: CORS).  
```

[![Java 21](https://img.shields.io/badge/java-21-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/spring--boot-3.2.0-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-lightgrey.svg)](LICENSE)
[![Build](https://img.shields.io/badge/build-Maven-blue)](https://maven.apache.org/)
[![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)]()

---

### 🧾 Créditos

Este projeto foi desenvolvido com base no conteúdo e curso do [Matheus Pieropan](https://github.com/matheuspieropan)
