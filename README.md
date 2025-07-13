# Simple Networking App

A simple networking application built with Java Spring Boot, SQL (H2), REST API, and HTML/JS/CSS frontend.

## Features
- User registration
- List all users
- Send and accept/reject connection requests
- View your connections
- Send and view messages between users

## Tech Stack
- Java 17, Spring Boot
- Spring JDBC (no JPA)
- H2 in-memory database (easy to switch to MySQL/Postgres/Oracle)
- REST API controllers
- HTML, JavaScript, CSS (frontend)

## Project Structure
```
simplenetworkingapp/
├── pom.xml
├── README.md
├── src/
│   └── main/
│       ├── java/com/simplenetworkingapp/
│       │   ├── model/
│       │   │   ├── User.java
│       │   │   ├── Connection.java
│       │   │   ├── Message.java
│       │   │   ├── UserRowMapper.java
│       │   │   ├── ConnectionRowMapper.java
│       │   │   └── MessageRowMapper.java
│       │   ├── service/
│       │   │   ├── UserService.java
│       │   │   ├── ConnectionService.java
│       │   │   └── MessageService.java
│       │   └── controller/
│       │       ├── UserController.java
│       │       ├── ConnectionController.java
│       │       └── MessageController.java
│       └── resources/
│           ├── application.properties
│           ├── schema.sql
│           └── static/
│               ├── index.html
│               ├── register.html
│               ├── login.html
│               ├── dashboard.html
│               ├── style.css
│               └── main.js
```

## Setup Instructions

1. **Clone or copy the project into your workspace.**
2. **Build and run the app:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. **Access the app:**
   - Open [http://localhost:8080/static/index.html](http://localhost:8080/static/index.html) in your browser.
   - Use the Register and Login pages to create and access users.

## Database
- Uses H2 in-memory database by default (see `application.properties` and `schema.sql`).
- To use another SQL database, update the datasource properties and SQL dialect as needed.

## API Endpoints
- `/api/users` — List all users
- `/api/users/register` — Register a new user
- `/api/users/{username}` — Get user by username
- `/api/connections/request` — Send connection request
- `/api/connections/accept/{id}` — Accept connection
- `/api/connections/reject/{id}` — Reject connection
- `/api/connections/user/{userId}` — List user’s connections
- `/api/connections/incoming/{userId}` — List incoming requests
- `/api/messages/send` — Send a message
- `/api/messages/between` — Get messages between two users
- `/api/messages/user/{userId}` — Get all messages for a user

## Frontend
- All static files are in `src/main/resources/static/`
- Main pages: `index.html`, `register.html`, `login.html`, `dashboard.html`
- Basic JS for registration (see `main.js`). Extend as needed for login, dashboard, etc.

---

For questions or further customization, just ask! 