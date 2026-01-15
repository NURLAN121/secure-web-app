\# Lab 10 – HTTP with Spring Boot



\## About

This is a simple Spring Boot application.

It shows basic HTTP endpoints in Java.



\## How to run

1\. Open the project in IntelliJ

2\. Run SecureWebAppApplication

3\. Open browser: http://localhost:8080



\## Endpoints



\### GET /hello

Returns simple text.



Response:

OK



\### GET /agent

Returns the User-Agent header from the request.



\### POST /users

Creates a user using JSON request body.



Example request:

```json

{

 "username": "testUser",

 "email": "test@email.com",

 "password": "Strong123"

}

```



If input data is invalid, the server returns HTTP 400.



\## Note

This project is created for Lab 10.

Security is disabled for simplicity.

