# 🛒 Monster Shop – Backend

Welcome to the backend of **Monster Shop**, a simple e-commerce platform where users can browse products, leave reviews, and see average ratings.

This REST API is built with **Java 21**, **Spring Boot**, **Spring Data JPA**, and **MySQL**.

---

## 🚀 Getting Started

### 🧰 Prerequisites

- Java 21+
- Maven
- MySQL (database: `monster_shop`)

### 📦 Run locally

```bash
# Clone repository
git clone https://github.com/roz-mari/MonsterShop-backend.git
cd MonsterShop-backend

# Start Spring Boot
mvn spring-boot:run

The backend will be available at:
👉 http://localhost:8080

⸻

📖 API Overview

📦 Products

Method	Endpoint	Description
GET	/api/products	List all products
GET	/api/products/{id}	Get product by ID
POST	/api/products	Create new product
PUT	/api/products/{id}	Update existing product
DELETE	/api/products/{id}	Delete a product

✍️ Reviews

Method	Endpoint	Description
GET	/api/reviews/{productId}	List all reviews for product
POST	/api/reviews?productId=x	Create review for product



⸻

🛠️ Technologies
	•	Java 21
	•	Spring Boot 3
	•	Spring Data JPA
	•	Maven
	•	MySQL 8+
	•	IntelliJ IDEA

⸻

📁 Project Structure

src/
  main/
    java/com/monstershop/backend/
      models/
      repositories/
      services/
      controllers/
    resources/
pom.xml


⸻

👩‍💻 Author

Developed by Mariia Sycheva

⸻

