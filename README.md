# Badminton Slot Booking System

A Spring Boot application for a badminton booking system where players can register and book slots for playing badminton. Admins can enter booking information and view existing bookings.

## Features

- **User Registration and Authentication**: Players can register, log in, and manage their profiles.
- **Booking Management**: Players can book slots for playing badminton.
- **Admin Panel**: Admins can enter and view booking information.
- **API Documentation**: Integrated Swagger UI for API documentation.
- **H2 Database**: Uses an in-memory H2 database for development.

## Prerequisites

- JDK 17 or higher
- Maven or Gradle
- Docker (for deployment)
- AWS CLI (for AWS deployment)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/badminton-booking-system.git
cd badminton-booking-system
```
# Build and Run the Application

## Using Gradle

```bash
./gradlew clean build
./gradlew bootRun
```
## Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

## Accessing the Application

- Swagger UI: http://localhost:8080/swagger-ui/
- H2 Console: http://localhost:8080/h2-console/

## Default Credentials
If you have Spring Security enabled, use the default credentials:

- Username: user
- Password: Check the console output for the generated password.

# Configuration
## Application Properties
The application uses `application.properties` for configuration. Below are some key properties:
```bash
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Swagger Configuration
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui

```

## Security Configuration
Spring Security is configured to protect the API endpoints. The security configuration can be found in the `SecurityConfig` class.


# Deployment
## Docker
Build the Docker image:
```bash
./gradlew bootBuildImage --imageName=badminton-booking-system
```
Run the Docker container:
```bash
docker run -p 8080:8080 badminton-booking-system
```

# API Documentation
The API documentation is available via Swagger UI:

- Swagger UI: http://localhost:8080/swagger-ui/
- OpenAPI JSON: http://localhost:8080/api-docs

# Contributing
- Fork the repository
- Create a new branch (git checkout -b feature/your-feature)
- Commit your changes (git commit -am 'Add some feature')
- Push to the branch (git push origin feature/your-feature)
- Create a new Pull Request






