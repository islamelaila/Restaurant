# 🍽️ Restaurant Management System

## 🎯 Overview

This is a **Restaurant Management System** developed using **Spring Boot (Java)** for the backend and **Angular** for the frontend.  
The project includes role-based access control, JWT-secured authentication, product and category management, and more.

---

## 🚀 Features

- 🔐 **JWT Authentication** (Completed)
  - Login, register, secure endpoints
  - Role-based access (Admin, Manager, Customer)
- 🍽️ **Category Management**
  - Add, update, list categories
- 🛒 **Product Management**
  - CRUD operations, linked with categories
- 📄 **DTO + Mapping using MapStruct**
- 🌐 **RESTful APIs** with Spring Boot
- 🗄️ **ORCALE / H2 Database**
- 👨‍💻 **Angular Frontend** (in progress)

---

## 🛠️ Tech Stack

| Layer        | Technology                       |
|--------------|-----------------------------------|
| Backend      | Spring Boot, Spring Security, JWT |
| Frontend     | Angular                          |
| Database     | ORCALE / H2                       |
| Mapping      | MapStruct                        |
| Dependencies | Lombok, JPA                      |

---

## 📂 Project Structure (Backend)

```
src/
 └─ main/
    └─ java/com/restaurant/
       ├─ controller/
       ├─ service/
       │   ├─ impl/
       ├─ repository/
       ├─ model/
       ├─ dto/
       ├─ mapper/
       └─ security/
           ├─ JWTFilter
           ├─ JWTUtil
           └─ SecurityConfig
```

---

## 🔧 How to Run (Backend)

1. Clone the project:
   ```bash
   git clone https://github.com/islamelaila/Restaurant.git
   ```

2. Open in your IDE (e.g., IntelliJ IDEA)

3. Create the database (if using ORCALE)

4. Configure database settings in `application.properties`

5. Run the project:
   ```bash
   mvn spring-boot:run
   ```

---

## 🔐 Authentication (JWT)

- Send email + password to `/auth/login`
- Receive JWT token
- Include token in header:
  ```
  Authorization: Bearer <token>
  ```

- Backend uses Spring Security and custom JWT filters to secure endpoints.

---

## 📌 Work in Progress

- Angular frontend integration
- Order & Invoice module
- Docker configuration

---

## 💡 Contribution

Fork the repo, make your changes, and create a pull request.  
Suggestions and improvements are welcome!

---

### 📧 Contact

Developed with ❤️ by **Islam El-alia**

[GitHub Profile](https://github.com/islamelaila)
