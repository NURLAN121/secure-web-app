# Secure Web Application

This project is a simple secure web application built with **Java Spring Boot**.
It demonstrates basic concepts of **HTTP**, **authentication**, and **authorization**.

---

## Features

- User authentication with Spring Security
- Session-based login and logout
- Role-based access control
- Secure notes CRUD
- Users can access only their own notes
- CSRF protection enabled
- Password hashing and validation

---

## Technologies

- Java
- Spring Boot
- Spring Security
- JDBC Template
- Thymeleaf
- H2 Database
- Flyway
- Maven

---

## Security

- Each note is linked to its owner (`user_id`)
- Ownership checks prevent access to other users’ data
- Prepared statements protect against SQL injection
- Input validation and global exception handling

---

## How to Run

1. Clone the repository
2. Run the Spring Boot application
3. Open:

http://localhost:8080/login


---

## Author

Nurlan

