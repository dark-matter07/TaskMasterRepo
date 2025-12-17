# TaskMaster - Todo REST API

A clean, production-ready Todo application built with **Spring Boot 3**, **Spring Data JPA**, and **PostgreSQL**.

## Features
- Full CRUD operations for tasks
- DTOs for clean API contracts (no direct entity exposure)
- Input validation & proper HTTP status codes
- Layered architecture (Controller → Service → Repository → Entity)
- Auto timestamps with Hibernate
- Global exception handling (optional extension)

## Endpoints
Base URL: `/api/tasks`

| Method | Endpoint                  | Description                     | Status Codes     |
|--------|---------------------------|---------------------------------|------------------|
| POST   | /                         | Create a new task               | 201 Created     |
| GET    | /                         | Get all tasks                   | 200 OK          |
| GET    | /{id}                     | Get task by ID                  | 200 OK / 404    |
| PUT    | /{id}                     | Fully update task               | 200 OK / 404    |
| DELETE | /{id}                     | Delete task                     | 204 No Content / 404 |
| PATCH  | /{id}/complete            | Mark task as completed          | 200 OK / 404    |

## Tech Stack
- Java 17+
- Spring Boot 3
- Spring Data JPA + Hibernate
- PostgreSQL (production database)
- Docker + Docker Compose (for running PostgreSQL)
- Lombok
- Maven

## Local Setup (Development)
For quick testing without Docker:
1. Have PostgreSQL installed locally.
2. Update `src/main/resources/application.properties` (or use profiles) with your local DB credentials.
3. Run: `./mvnw spring-boot:run`

## Docker Setup (Recommended - PostgreSQL via Docker)
The database runs in a Docker container using Docker Compose — perfect for consistent, isolated environment.

