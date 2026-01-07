# Banking Demo App

A Spring Boot application that demonstrates basic banking operations. This project provides a RESTful API for managing bank accounts, including creation, retrieval, deposits, withdrawals, and deletion.

## Features

The application exposes the following REST endpoints via the `AccountController`:

*   **Create Account**: `POST /accounts/add` - Create a new bank account.
*   **Get Account**: `GET /accounts/{id}` - Retrieve details of a specific account.
*   **List Accounts**: `GET /accounts` - Retrieve a list of all accounts.
*   **Deposit Funds**: `PUT /accounts/{id}/deposit` - Deposit a specified amount into an account.
*   **Withdraw Funds**: `PUT /accounts/{id}/withdraw` - Withdraw a specified amount from an account.
*   **Delete Account**: `DELETE /accounts/{id}` - Remove an account from the system.

## Dependencies

The project uses the following major dependencies (defined in `pom.xml`):

*   **Spring Boot Starter WebMVC**: For building the REST API.
*   **Spring Boot Starter Data JPA**: For database interaction using Hibernate and JPA.
*   **MySQL Connector J**: JDBC driver for MySQL database.
*   **Spring Dotenv**: For loading environment variables from a `.env` file.
*   **Lombok**: To reduce boilerplate code (Getters, Setters, Constructors).
*   **Spring Boot Starter Validation**: For bean validation.

**Test Dependencies:**
*   Spring Boot Starter Data JPA Test
*   Spring Boot Starter WebMVC Test

## Prerequisites

*   **Java**: JDK 25 (as configured in `pom.xml`)
*   **Maven**: (Wrapper included in project)
*   **MySQL**: A running MySQL server instance.

## Setup and Execution

Follow these steps to run the project locally:

### 1. Clone the Repository
If you haven't already, clone the repository to your local machine.

### 2. Database Setup
Ensure you have a MySQL database created. You can create one using your preferred SQL client:

```sql
CREATE DATABASE banking_app;
```

### 3. Configure Environment Variables
This project uses `spring-dotenv` to manage configuration. Create a file named `.env` in the root directory of the project (same level as `pom.xml`).

Add the following variables to the `.env` file, adjusting the values to match your local setup:

```properties
# Database Configuration
DB_URL=jdbc:mysql://localhost:3306/banking_app
DB_USERNAME=root
DB_PASSWORD=your_password

# Server Configuration (Optional, defaults to 8080)
PORT=8080
```

*Note: The `application.yml` is configured to read these values.*

### 4. Build and Run
Open a terminal in the project root directory and run the application using the Maven Wrapper:

**On macOS/Linux:**
```bash
./mvnw spring-boot:run
```

**On Windows:**
```cmd
mvnw.cmd spring-boot:run
```

The application will start and listen on port `8080` (or the port defined in your `.env` file).

### 5. Access the API
You can test the endpoints using tools like Postman or cURL.

**Example: Create an Account**
```bash
curl -X POST http://localhost:8080/accounts/add \
-H "Content-Type: application/json" \
-d '{"accountName": "John Doe", "balance": 100.0}'
```
