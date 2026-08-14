# Laser Machine Innovation Hub — Backend

A REST API for a laser machine showcase platform, built with Spring Boot. Provides public endpoints for browsing use cases and submitting inquiries, and secured admin endpoints for managing content.

**Live API:** https://laser-machine-backend.onrender.com
**Frontend repo:** https://github.com/NamitaMane76/laser-machine-frontend

Built by [Namita Mane](https://github.com/NamitaMane76)

## Features

- Full CRUD REST API for laser machine use cases, with industry-based filtering
- Contact/inquiry submission endpoint
- Admin authentication using Spring Security and BCrypt password hashing
- Role-based access control — public read access, admin-only write access
- PostgreSQL database with Hibernate/JPA
- Dockerized for deployment

## Tech Stack

- Java 21, Spring Boot 4
- Spring Data JPA, Spring Security
- PostgreSQL
- Maven
- Docker
- Deployed on Render

## API Endpoints

| Method | Endpoint | Access | Description |
|--------|----------|--------|-------------|
| GET | `/api/usecases` | Public | List all use cases (optional `?industry=` filter) |
| GET | `/api/usecases/{id}` | Public | Get a single use case |
| POST | `/api/usecases` | Admin | Create a use case |
| PUT | `/api/usecases/{id}` | Admin | Update a use case |
| DELETE | `/api/usecases/{id}` | Admin | Delete a use case |
| POST | `/api/inquiries` | Public | Submit a contact inquiry |
| GET | `/api/inquiries` | Admin | List all inquiries |
| DELETE | `/api/inquiries/{id}` | Admin | Delete an inquiry |

## Running Locally

1. Clone the repo
2. Create a PostgreSQL database
3. Set the following environment variables (or edit `application.properties`):
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/your_db_name
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
4. Run with `./mvnw spring-boot:run`
5. The API will be available at `http://localhost:8080`

## What I'd Improve Next

- JWT-based authentication instead of Basic Auth
- Pagination for large result sets
- Image upload instead of external image URLs
- Automated tests