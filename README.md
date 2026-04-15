
# 🚀 Smoly – URL Shortener & Certificate Generator

Smoly is a full-stack web application that combines a **URL shortener** and a **certificate generator** into one seamless platform.
It focuses on simplicity, performance, and real-world usability.

🔗 Live Demo: https://smoly.onrender.com/

---

## ✨ Features

### 🔗 URL Shortener

* Convert long URLs into short, shareable links
* Unique short code generation
* Instant redirection
* Click tracking (analytics)

### 🎓 Certificate Generator

* Generate certificates instantly using user input
* Dynamic rendering using HTML5 Canvas
* Download certificates in image format
* No database required for certificate storage

---

## 🛠 Tech Stack

**Backend**

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL

**Frontend**

* HTML
* CSS
* JavaScript

**Deployment**

* Docker
* Render

---

## ⚙️ How It Works

### 🔗 URL Shortener Flow

1. User submits a long URL
2. Backend generates a unique short code
3. Mapping is stored in the database
4. Visiting short URL redirects to original link
5. Click count is updated

### 🎓 Certificate Generator Flow

1. User enters name, course, date, signature
2. Canvas dynamically generates certificate
3. Image is exported and downloaded instantly

---

## 📁 Project Structure

```
smoly/
├── controller/
├── service/
├── repository/
├── entity/
├── DTO/
├── resources/
│   ├── static/
│   └── application.properties
```

---

## 🚀 Run Locally

### 1. Clone Repository

```
git clone https://github.com/akshitasharma0683-dev/smoly
cd smoly
```

### 2. Configure Database

Update `application.properties`:

```
spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 3. Run Application

```
mvn spring-boot:run
```

---

## 🐳 Docker Setup

### Build Image

```
docker build -t smoly-app .
```

### Run Container

```
docker run -p 8080:8080 smoly-app
```

---

## 🎯 Future Improvements

* User authentication & dashboard
* Advanced analytics (geo, device tracking)
* Custom short URLs
* Multiple certificate templates

---

## 👩‍💻 Author

**Akshita Sharma**

* GitHub: https://github.com/akshitasharma0683-dev
* LinkedIn: https://www.linkedin.com/in/akshita-sharma-188773219/

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!

