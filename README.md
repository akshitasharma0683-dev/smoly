# 🚀 Smoly – URL Shortener & Certificate Verification Platform

Smoly is a Spring Boot based platform that combines a **URL Shortener** and a **Certificate Generation & Verification System** into a single application.

The platform allows users to create shortened URLs, generate professional PDF certificates, and verify certificate authenticity using QR codes and unique verification codes.

The goal of Smoly is to solve real-world problems related to certificate authenticity, document verification, and link management while demonstrating practical backend engineering concepts.

🔗 **Live Demo:** https://smoly.onrender.com/

---

# 🎯 Problem Statement

Organizations, educational institutions, training providers, and event organizers frequently issue certificates as proof of achievement, participation, or contribution.

Traditional certificates can be:

* Easily forged
* Modified without authorization
* Difficult to verify
* Time-consuming to validate manually

Smoly addresses this challenge by generating unique verification codes and QR codes for every certificate. Each certificate is linked to a database record, allowing anyone to instantly verify its authenticity.

In addition, Smoly includes a URL shortening service that enables users to generate compact, shareable links while tracking usage statistics.

---

# ✨ Features

## 🔗 URL Shortener

* Convert long URLs into short shareable links
* Unique short code generation
* Instant redirection
* Click tracking
* Database persistence
* Fast lookup using Spring Data JPA

---

## 🎓 Certificate Generation

* Create certificates dynamically
* Generate unique Certificate IDs
* Generate unique Verification Codes
* Store certificate information in PostgreSQL
* Generate professional PDF certificates
* Dynamic certificate rendering
* Personalized certificate generation

---

## ✅ Certificate Verification

* QR Code based verification
* Verification code lookup
* Certificate authenticity validation
* Instant verification through REST APIs
* Database-backed verification records

---

# 💡 Key Technical Challenges

## Certificate Authenticity

One of the major challenges was preventing certificate forgery and enabling easy verification.

To solve this, each certificate is assigned:

* Unique Certificate ID
* Unique Verification Code
* Embedded QR Code

The QR code links directly to the certificate verification endpoint, allowing users to verify certificate authenticity instantly.

---

## Dynamic PDF Generation

Instead of generating static certificates, Smoly dynamically creates personalized PDF certificates using certificate information stored in the database.

The PDF generation process includes:

* Recipient Name
* Certificate Title
* Organization Name
* Certificate ID
* Issue Date
* Embedded QR Code

The certificates are generated using Apache PDFBox.

---

## URL Mapping & Redirection

The URL shortener module generates unique short codes and stores mappings between short and original URLs.

The application handles:

* URL storage
* Redirection
* Click counting
* Database persistence

while maintaining fast response times.

---

# 🛠 Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate

## Database

* PostgreSQL

## PDF Generation

* Apache PDFBox

## QR Code Generation

* ZXing

## Frontend

* HTML
* CSS
* JavaScript

## Deployment

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
 │   PostgreSQL
 │       │
 │       ▼
 │   PDF Generator
 │       │
 │       ▼
 │   QR Generator
 │       │
 │       ▼
 │  PDF Certificate
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

# 🔗 URL Shortener Workflow

```text
Long URL
    ↓
Generate Short Code
    ↓
Store Mapping
    ↓
Short URL
    ↓
User Access
    ↓
Redirect to Original URL
```

---

# 📌 API Endpoints

## Create Certificate

```http
POST /certificate/create
```

Request Body:

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

## Generate PDF Certificate

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

# 📁 Project Structure

```text
smoly/
├── controller/
│   ├── CertificateController
│   ├── QrCodeController
│   └── UrlController
│
├── service/
│   ├── CertificateService
│   ├── PdfService
│   ├── QrCodeService
│   └── UrlService
│
├── repository/
│   ├── CertificateRepository
│   └── UrlRepository
│
├── entity/
│   ├── Certificate
│   └── UrlMapping
│
├── resources/
│   ├── static/
│   │   └── certificate-template.png
│   └── application.properties
│
└── Dockerfile
```

---

# 🚀 Run Locally

## Clone Repository

```bash
git clone https://github.com/akshitasharma0683-dev/smoly.git
cd smoly
```

## Configure Database

Update:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

## Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

# 🐳 Docker Setup

## Build Image

```bash
docker build -t smoly .
```

## Run Container

```bash
docker run -p 8080:8080 smoly
```

---

# 🎯 Future Enhancements (V2)

* JWT Authentication
* Role Based Access Control
* Multiple Certificate Templates
* Certificate Download API
* Email Certificate Delivery
* Admin Dashboard
* Organization Management
* Analytics Dashboard
* Cloud Storage Integration

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
