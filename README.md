# 🚀 Smoly – Certificate Verification & URL Shortener Platform

Smoly is a full-stack Java application built with Spring Boot and PostgreSQL that combines a Certificate Verification System and a URL Shortener into a single platform.

The application enables organizations, educational institutions, event organizers, and training providers to generate tamper-resistant PDF certificates containing unique verification codes and QR codes. Anyone can instantly verify certificate authenticity through a public verification endpoint.

In addition, Smoly provides a URL shortening service that converts long URLs into compact, shareable links with fast redirection and persistent storage.

The platform is fully containerized using Docker and deployed to production on Render.

🔗 **Live Demo:** https://smoly.onrender.com/

---

# 🎯 Problem Statement

Organizations frequently issue certificates as proof of achievement, participation, contribution, or course completion.

Traditional certificates present several challenges:

* Easy to forge or duplicate
* Difficult to verify manually
* Time-consuming validation process
* No centralized verification mechanism

Smoly addresses these challenges by generating:

* Unique Certificate IDs
* Unique Verification Codes
* QR-Based Verification Links
* Database-Backed Certificate Records

This allows instant authenticity verification through a secure REST API.

---

# ✨ Key Features

## 🎓 Certificate Management

* Dynamic certificate generation
* Unique Certificate ID generation
* Unique Verification Code generation
* PostgreSQL-backed certificate storage
* Professional PDF certificate creation
* Embedded QR code generation
* Automated certificate verification workflow

## ✅ Certificate Verification

* QR code based verification
* Verification code lookup
* Public authenticity validation endpoint
* Real-time certificate verification
* Database-backed verification records

## 🔗 URL Shortener

* Long URL shortening
* Unique short-code generation
* Instant URL redirection
* Persistent URL storage
* Click tracking support
* Fast lookup using Spring Data JPA

## 🔐 Authentication & Security

* JWT Authentication
* Stateless Security Configuration
* Protected API Endpoints
* Spring Security Integration

---

# 🛠 Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Security
* Spring Data JPA
* Hibernate

## Database

* PostgreSQL

## Authentication

* JWT (JSON Web Tokens)

## PDF Generation

* Apache PDFBox

## QR Code Generation

* ZXing

## Frontend

* HTML
* CSS
* JavaScript

## DevOps & Deployment

* Docker
* Render

---

# 🏗 System Architecture

```text
User
 │
 ├── Create Certificate
 │       │
 │       ▼
 │   Spring Boot API
 │       │
 │       ▼
 │   PostgreSQL
 │       │
 │       ▼
 │   PDF Generator
 │       │
 │       ▼
 │   QR Generator
 │       │
 │       ▼
 │  Download PDF
 │
 └── Scan QR Code
         │
         ▼
   Verification API
         │
         ▼
   Certificate Details
```

---

# 📋 Certificate Workflow

```text
Create Certificate
        ↓
Generate Certificate ID
        ↓
Generate Verification Code
        ↓
Save Certificate
        ↓
Generate PDF
        ↓
Embed QR Code
        ↓
Download Certificate
        ↓
Scan QR Code
        ↓
Verify Certificate
```

---

# 📌 REST API Endpoints

## Create Certificate

```http
POST /certificate/create
```

Request:

```json
{
  "recipientName": "Akshita Sharma",
  "certificateTitle": "Reviewer Certificate",
  "organizationName": "Granthaalyah Publications"
}
```

---

## Verify Certificate

```http
GET /certificate/verify/{verificationCode}
```

Example:

```http
GET /certificate/verify/a24216e678d3
```

---

## Download PDF Certificate

```http
GET /certificate/pdf/{id}
```

Example:

```http
GET /certificate/pdf/2
```

---

## Generate QR Code

```http
GET /qr/generate?text=HelloWorld
```

---

# 🚀 Running Locally

## Clone Repository

```bash
git clone https://github.com/akshitasharma0683-dev/smoly.git
cd smoly
```

## Configure Environment

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

## Run Application

```bash
mvn spring-boot:run
```

---

# 🐳 Docker

Build Image:

```bash
docker build -t smoly .
```

Run Container:

```bash
docker run -p 8080:8080 smoly
```

---

# 🎯 Future Enhancements

* Role Based Access Control (RBAC)
* Multiple Certificate Templates
* Email Certificate Delivery
* Admin Dashboard
* Organization Management
* Analytics Dashboard
* Cloud Storage Integration
* Certificate Expiration & Revocation
* Certificate Download History

---

# 👩‍💻 Author

**Akshita Sharma**

Java Backend Developer

GitHub:
https://github.com/akshitasharma0683-dev

LinkedIn:
https://www.linkedin.com/in/akshita-sharma-188773219/

---

# ⭐ Support

If you found this project useful, consider giving it a star on GitHub.
