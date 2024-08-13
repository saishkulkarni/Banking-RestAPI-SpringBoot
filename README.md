# Banking-RestAPI-SpringBoot

This project is a Banking REST API built using Spring Boot. It demonstrates a simple banking system with user management, account operations, and transaction handling.

## Features

- User registration and management
- Account creation and management
- Transaction processing (deposit, withdraw, transfer)
- Balance enquiry

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven

## Project Structure

The project follows a standard Spring Boot application structure:

- `src/main/java/org/jsp/bankingrestapi`: Contains the Java source code
  - `controller`: REST API endpoints
  - `dao`: Data Access Objects for database operations
  - `dto`: Data Transfer Objects (User, BankAccount, BankTransaction)
  - `exception`: Custom exception handling
  - `repository`: JPA repository interfaces
  - `service`: Business logic layer

## Setup and Installation

1. Clone the repository:

2. Navigate to the project directory:

3. Update the `application.properties` file in `src/main/resources` with your MySQL database configuration.

4. Build the project:

5. Run the application:

The application will start running at `http://localhost:8080`.

## API Endpoints

### User Management
- POST `/users`: Register a new user
- POST `/users/verify-otp`: Verify user OTP
- POST `/users/login`: User login
- GET `/users`: Get all users (admin only)
- GET `/users/{id}`: Get user by ID
- PUT `/users/{id}`: Update user
- DELETE `/users/{id}`: Delete user

### Account Management
- POST `/accounts`: Create a new bank account
- GET `/accounts`: Get all accounts (admin only)
- GET `/accounts/{id}`: Get account by ID
- PUT `/accounts/{id}`: Update account
- DELETE `/accounts/{id}`: Delete account

### Transaction Operations
- POST `/transactions/deposit`: Deposit money
- POST `/transactions/withdraw`: Withdraw money
- POST `/transactions/transfer`: Transfer money
- GET `/transactions`: Get all transactions (admin only)
- GET `/transactions/{accountId}`: Get transactions for an account

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the [MIT License](LICENSE).
