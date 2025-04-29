# ServiceTrack Backend

The **service-track-backend** is the server-side component of the Service Track application. 
It's built using Java Spring Boot, and it's designed to manage and track service requests or work orders.

## Project Structure

### Modular Architecture
The project follows a modular architecture, which means the codebase is organized into independent, reusable modules.
This approach offers improved maintainability, enhanced scalability, increased reusability and better organization.

The architecture include modules like:

- `client/` – Client-related operations.
- `common/` – Shared utilities and domain logic.
- `docs/openapi/` – OpenAPI (Swagger) API documentation.
- `main-web/` – Web entry points.
- `serviceorder/` – Service orders management.
- `technician/` – Technicians management.
- `user/` – User authentication and management.

## Technologies Used

- Java 17+
- Spring Boot
- PostgreSQL
- Docker
- Maven
- Liquibase

## Getting started

Running the project locally requires additional steps.

### Environmental variables
To run the project you need to provide a series of environmental variables.

Environmental variables needed for the project to run locally:

```env
JWT_SECRET_KEY={JWT_SECRET_KEY};
SPRING_DATASOURCE_URL={SPRING_DATASOURCE_URL};
SPRING_DATASOURCE_USERNAME={SPRING_DATASOURCE_USERNAME};
SPRING_DATASOURCE_PASSWORD={SPRING_DATASOURCE_PASSWORD};
```

### Running Locally

#### Using Maven
```
./mvnw clean install
./mvnw spring-boot:run
```

#### Using Docker
```
docker build -t service-track-backend .

docker run -p 8080:8080 --env-file .env service-track-backend
```

## Migration management
The project uses Liquibase for managing database migrations. Liquibase enables database version control, ensuring consistency across environments and enabling smooth schema updates.

### Key files
`main-web/src/main/resources/db/changelog/db.changelog-master.yaml`:  The root changelog, which aggregates all other changelog files from various modules.

Each module contains its own changelog file that organizes the migrations for that module, for example: 
`serviceorder/serviceorder-repository/src/main/resources/db/serviceorder/changelog/db.serviceorder.yaml`: root changelog file of service order domain containing all the migrations in the domain


Individual migration files within a module's migration directory define the specific database changes.  
These files contain the instructions to create objects.
`serviceorder/serviceorder-repository/src/main/resources/db/serviceorder/migration/00_init_serviceorder_schema.yaml` - migration used to create service order database schema.

## Workflows
The project contain workflow:
- `maven.yml` - workflow responsible for building the application and building Docker image.
