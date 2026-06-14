# 🚀 Smoly – URL Shortener & Certificate Verification Platform

Smoly is a full-stack web application built with Java and Spring Boot that combines two practical business solutions into a single platform:

* A URL Shortener for creating compact, shareable links
* A Certificate Generation & Verification System for issuing and validating digital certificates

The project was designed to address a common challenge faced by organizations, educational institutions, and event organizers: ensuring that issued certificates are authentic and cannot be easily forged.

Each generated certificate is assigned a unique Certificate ID and Verification Code, stored securely in PostgreSQL, and embedded into a downloadable PDF along with a QR code. Anyone can verify the authenticity of a certificate instantly by scanning the QR code or entering the verification code through the verification portal.

In addition to certificate verification, Smoly also provides URL shortening capabilities with unique short-code generation, database persistence, and redirection support.

## ✨ Key Features

### 🔗 URL Shortener

* Convert long URLs into short, shareable links
* Generate unique short codes automatically
* Redirect users to original URLs instantly
* Track link usage and clicks
* Store mappings securely in PostgreSQL

### 🎓 Certificate Generation

* Create certificates dynamically through a web interface
* Generate unique Certificate IDs
* Generate unique Verification Codes
* Store certificate records for future verification
* Generate professional PDF certificates
* Embed QR codes directly into certificates

### ✅ Certificate Verification

* Verify certificates using verification codes
* Scan QR codes for instant validation
* Retrieve certificate details from the database
* Prevent unauthorized certificate duplication and forgery

## 🏗️ System Architecture

```text
Client
   ↓
Spring Boot Application
   ↓
Controller Layer
   ↓
Service Layer
   ↓
Repository Layer
   ↓
PostgreSQL Database
```

The application follows a layered architecture that separates business logic, API handling, and persistence concerns, making the codebase easier to maintain and extend.

## 💡 Key Engineering Decisions

### QR-Based Certificate Verification

Instead of relying solely on certificate documents, each certificate contains a QR code that links directly to the verification endpoint.

Benefits:

* Faster verification
* Improved user experience
* Reduced manual errors

### Database-Backed Verification

Certificate information is stored permanently in PostgreSQL and validated against database records during verification.

Benefits:

* Reliable authenticity checks
* Historical record tracking
* Protection against forged certificates

### Unique Verification Codes

Every certificate receives a unique verification code.

Benefits:

* Simplified certificate lookup
* Secure validation process
* Prevention of duplicate records

## 🚧 Challenges Solved

### Certificate Authenticity

Challenge:
Organizations need a reliable way to prove that issued certificates are genuine.

Solution:
Implemented verification codes and QR-based validation backed by persistent database records.

### Dynamic PDF Generation

Challenge:
Generating professional certificates with dynamic user data.

Solution:
Used Apache PDFBox to generate customized PDF certificates programmatically while embedding verification information and QR codes.

### Multi-Service Integration

Challenge:
Combining URL shortening, certificate generation, PDF creation, QR generation, and verification into a single application.

Solution:
Designed a modular service-based architecture where each feature is handled independently while remaining easy to maintain and scale.
