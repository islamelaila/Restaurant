# 🍽️ Restaurant Management System (RMS)

## Motivation 🌟
**The Power of Technology: Simplifying Restaurant Operations & Enhancing User Experience**

Running a restaurant involves countless small tasks—from organizing categories and managing products to ensuring smooth operations for staff and customers. Here comes the power of technology. 🚀

This project aims to modernize restaurant management by providing a clean, efficient, and scalable digital system. By using interactive dashboards and structured API operations, restaurant owners can visualize, control, and optimize their workflow.

Just like imagination fuels innovation, structured software helps businesses grow, automate, and succeed.  
This project represents that bridge between simplicity and efficiency — the foundation that motivated us to build this Restaurant Management System. 🍽️💡

---

## Objective 🎯
The Restaurant Management System (RMS) is designed to deliver a powerful, modular, and user-friendly environment for handling restaurants digitally.  

The system focuses on:

- Simplifying product & category management
- Providing secure role-based access
- Offering a fast and interactive Angular UI
- Delivering scalable, maintainable Spring Boot backend services
- Preparing the system for future modules like orders, invoices, staff management, and reports

Our goal is to build a complete full-stack solution that is clean, efficient, and production-ready. 🚀✨

---

## 🚀 Features

### Backend
- 🔐 **JWT Authentication**: Login, register, secure endpoints
- **Role-based access control**: Admin, Manager, Customer
- 🍽️ **Category Management**: Add, update, list categories
- 🛒 **Product Management**: CRUD operations linked with categories
- 📄 **DTO + Mapping**: Using MapStruct
- 🌐 **RESTful APIs**: Built with Spring Boot

### Frontend (Angular)
- 👨‍💻 **Dynamic interface** (in progress)
- Display product cards with images (future)
- Integration with backend APIs

### Future Features
- Order & Invoice module
- Docker setup for easy deployment

---

## 🛠️ Tech Stack

| Layer      | Technology                       |
|------------|----------------------------------|
| Backend    | Spring Boot, Spring Security, JWT |
| Frontend   | Angular                           |
| Database   | Oracle / H2                       |
| Mapping    | MapStruct                         |
| Dependencies | Lombok, JPA                     |

---

## 📂 Folder Structure

### Backend
```
restaurant-backend/
│
├── src/
│   ├── main/
│   │   ├── java/com/restaurant/
│   │   │   ├── controller/         # REST controllers (Product, Category, Auth)
│   │   │   ├── service/            # Service interfaces
│   │   │   ├── service/impl/       # Service implementations
│   │   │   ├── repository/         # JPA repositories
│   │   │   ├── model/              # Entities: Product, Category, User
│   │   │   ├── dto/                # DTOs for API requests/responses
│   │   │   ├── mapper/             # MapStruct mappers
│   │   │   └── security/           # JWTFilter, JWTUtil, SecurityConfig
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql            # Optional initial data
│   └── test/
│       └── java/com/restaurant/    # Unit tests for services and controllers
│
├── pom.xml
└── README.md
```

### Frontend
```
restaurant-frontend/
│
├── src/
│   ├── app/
│   │   ├── components/
│   │   │   ├── product/
│   │   │   │   ├── product-list/
│   │   │   │   ├── product-card/   # Future: display product with image
│   │   │   │   └── product-form/
│   │   │   ├── category/
│   │   │   │   ├── category-list/
│   │   │   │   └── category-form/
│   │   │   └── shared/             # Shared UI components
│   │   ├── services/                # API service calls
│   │   ├── models/                  # TypeScript interfaces
│   │   └── app.module.ts
│   └── assets/                      # Images, styles, icons
│
├── angular.json
├── package.json
└── README.md
```

---

## 🔧 How to Run

### Backend
```bash
git clone https://github.com/islamelaila/Restaurant.git
cd Restaurant
mvn spring-boot:run
```
- Configure `application.properties` for your database (Oracle or H2)
- Backend runs on default port 8080

### Frontend
```bash
cd restaurant-frontend
npm install
ng serve
```
- Open in browser: [http://localhost:4200](http://localhost:4200)

---

## 🔐 Authentication (JWT)
1. Send email + password to `/auth/login`
2. Receive JWT token
3. Include token in headers for protected endpoints:
```
Authorization: Bearer <token>
```

---

## 🎬 Demo
- Frontend
- Product Operations
- Category Operations


---

## 💡 Contribution
Fork the repo, make your changes, and create a pull request.  
Suggestions and improvements are welcome!

---

## 📧 Contact
Developed with ❤️ by **Islam El-alia**

