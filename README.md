# 🍽️ Restaurant Management System (Spring Boot + Angular)

## 🏗️ Full-Stack Architecture

![Architecture Diagram](architecture.png)

## 🎯 Overview

A complete **Restaurant Management System** built using **Spring Boot**
for the backend and **Angular** for the frontend.\
Includes JWT authentication, role-based access, product/category
management, and modular clean architecture.

## 🚀 Features

-   🔐 **JWT Authentication** (Login + Register)
-   👥 **Role-Based Authorization** (Admin / Manager / Customer)
-   🍽️ **Category Management**
-   🛒 **Product Management**
-   📦 **DTO + MapStruct Mapping**
-   🌐 **REST APIs**
-   🗄️ **Oracle / H2 DB Support**
-   🎨 **Angular Frontend**
-   🐳 **Docker (coming soon)**

## 📂 Backend Structure

    src/main/java/com/restaurant/
     ├─ controller/
     ├─ service/
     │   └─ impl/
     ├─ repository/
     ├─ dto/
     ├─ mapper/
     ├─ model/
     └─ security/
          ├─ JWTFilter
          ├─ JWTUtil
          └─ SecurityConfig

## 📂 Frontend Structure (Angular)

    src/app/
     ├─ services/
     ├─ components/
     │   ├─ products/
     │   └─ categories/
     ├─ guards/
     ├─ models/
     └─ pages/

## 🔧 Run Backend

    mvn spring-boot:run

## 🔧 Run Frontend

    npm install
    ng serve -o

## 🔐 Authentication Flow

1.  User logs in → receives JWT\
2.  Angular stores token (localStorage)\
3.  Each API call includes:

```{=html}
<!-- -->
```
    Authorization: Bearer <token>

## 📝 Future Work

-   Orders Module\
-   Invoice Module\
-   Docker Deployment

------------------------------------------------------------------------

Built with ❤️ by **Islam El‑alia**
