# 🏥 Hospital Management System

A backend REST API application for managing hospital operations such as patients, doctors, visits, and user authentication.

Built using **Java, Spring Boot, Spring Data JPA, MySQL, and Spring Security with JWT authentication**.

## 🚀 Features

* Patient management

  * Add, view, update, and delete patients
* Doctor management

  * Add, view, update, and delete doctors
* Visit management

  * Create and manage patient-doctor visits
* User authentication

  * Login using username and password
  * JWT-based authentication
* Role-based authorization
* Password encryption using BCrypt
* Global exception handling
* MySQL database integration
* RESTful APIs
* Swagger/OpenAPI API documentation

## 🛠️ Tech Stack

| Technology        | Usage                            |
| ----------------- | -------------------------------- |
| Java 17           | Programming language             |
| Spring Boot 3.3.9 | Backend framework                |
| Spring Data JPA   | Database persistence             |
| Hibernate         | ORM                              |
| Spring Security   | Authentication and authorization |
| JWT               | Token-based authentication       |
| BCrypt            | Password encryption              |
| MySQL             | Database                         |
| Maven             | Build and dependency management  |
| Swagger/OpenAPI   | API documentation                |
| Postman           | API testing                      |

## 📂 Project Structure

```text
src/main/java/com/codegnan
│
├── controller
│   ├── AuthController
│   ├── DoctorController
│   ├── PatientController
│   └── VisitController
│
├── entity
│   ├── Doctor
│   ├── Patient
│   ├── Person
│   ├── User
│   └── Visit
│
├── repo
│   ├── DoctorRepo
│   ├── PatientRepo
│   ├── PersonRepo
│   ├── UserRepository
│   └── VisitRepo
│
├── service
│   ├── DoctorService
│   ├── PatientService
│   ├── VisitService
│   ├── JwtService
│   └── UserDetailsServiceImpl
│
├── security
│   ├── JwtAuthenticationFilter
│   └── SecurityConfig
│
└── exception
    ├── CustomExceptionHandler
    ├── ErrorResponse
    └── Custom Exceptions
```

## 🔐 Authentication Flow

The application uses JWT-based authentication.

```text
User Login
    ↓
AuthController
    ↓
User Authentication
    ↓
BCrypt Password Verification
    ↓
JWT Token Generated
    ↓
Client Sends JWT with API Requests
    ↓
JwtAuthenticationFilter
    ↓
Request Authorized
```

## 🗄️ Database

The application uses **MySQL** as the relational database.

Configure your local database in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

> Replace `YOUR_PASSWORD` with your local MySQL password.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/saboorshaik048/Hospital-Management-System.git
```

### 2. Open the project

Open the project in **Eclipse** or another Java IDE.

### 3. Configure MySQL

Create a database named:

```sql
CREATE DATABASE hospital;
```

Update the MySQL username and password in `application.properties`.

### 4. Run the application

Run:

```text
HospitalManagemantApplication.java
```

The Spring Boot application will start on the default port:

```text
http://localhost:8080
```

## 📖 API Documentation

After starting the application, Swagger UI can be accessed at:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger can be used to view and test the available REST APIs.

## 🧪 API Testing

The APIs were tested using **Postman**.

Authentication-protected endpoints require a valid JWT token in the request.

```text
Authorization: Bearer <JWT_TOKEN>
```

## 🎯 Learning Outcomes

Through this project, I worked with:

* Spring Boot REST API development
* JPA entity relationships
* Repository and service layers
* MySQL database integration
* Spring Security
* JWT authentication
* BCrypt password encryption
* Role-based authorization
* Exception handling
* API testing with Postman
* Swagger/OpenAPI documentation

## 👨‍💻 Author

**Saboor Shaik**

B.Tech Computer Science & Engineering
