# Secure Web Application – Spring Boot Security Project

## Overview

This project is a **session-based MVC web application** built with **Spring Boot and Spring Security**.
It was developed for a university security lab to demonstrate **web application security features live in the browser**.

Users can register, log in, and manage their own notes securely.

---

## Author

| Name | Nurlan |
|------|--------|
| Field | Cybersecurity |
| Type | University Lab Project |

---

## Architecture

- Controller → Service → Repository
- Separate Security and Validation layers
- MVC with Thymeleaf templates

Main entities:
- User
- Note

---

## Security Features

### Authentication
- User registration with server-side validation
- Password hashing using BCrypt
- Form-based login with HTTP session
- Login success and failure handling

### Authorization and User Isolation
- Protected routes require authentication
- Users can access **only their own data**
- Data isolation enforced via `user_id` foreign key and user-based queries

### Session Management
- Session cookie (`JSESSIONID`)
- Logout invalidates the session
- Refresh after logout keeps the user logged out

### Input Validation
- DTO validation
- Custom password validator
- Safe error messages (no stack traces)

### HTTP Security
- X-Content-Type-Options
- X-Frame-Options
- Content-Security-Policy
- Referrer-Policy
- HttpOnly and SameSite cookies

### Database Security
- Foreign key enforcement (`user_id`)
- Prepared statements (JdbcTemplate)
- SQL injection protection

### Logging
- Failed login attempts logged
- Unauthorized access attempts logged
- No passwords or sensitive data logged

---

## Testing

- Unit tests
- Service tests
- Security integration tests (MockMvc)

All tests pass successfully.

---

## How to Run

```bash
mvn spring-boot:run

## Open:
http://localhost:8080

