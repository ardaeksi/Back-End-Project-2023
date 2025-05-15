# WebApp Project

## Back-End of E-Commerce Site

This project is the back-end of an e-commerce website, developed using **Spring Boot** and deployed with **Apache Tomcat**. It provides RESTful APIs to support functionalities such as product management, user authentication, order processing, and more.

Technologies used:
- Java
- Spring Boot
- Tomcat
- Maven
- SQLite / MySQL (or specify your DB)
- RESTful APIs

> This backend is designed to integrate with a React-based frontend, enabling a full-stack web application experience.

# Backend API Documentation

## 🔐 AUTHENTICATION

### POST `/login`
Login user using credentials  
**Request Body:**
```json
{
  "userName": "johnDoe",
  "password": "examplePassword"
}
```

**Response:**
```json
{
  "id": 1,
  "role": "user",
  "token": "abc123token"
}
```

---

### POST `/register`
Register a new user  
**Request Body:**
```json
{
  "userName": "johnDoe",
  "password": "examplePassword",
  "wallet": {
    "card": "1234123412341234",
    "month": "07",
    "year": "2026",
    "cvv": "123"
  }
}
```

**Response:**
```json
{
  "id": 1,
  "role": "user",
  "token": "abc123token"
}
```

---

## 👤 USER ENDPOINTS

### POST `/getUser`
Fetch user information  
**Request Body:**
```json
{
  "sessionToken": "abc123token"
}
```

**Response:**
```json
{
  "userName": "johnDoe",
  "wallet": {
    "card": "**** **** **** 1234",
    "month": "07",
    "year": "2026",
    "cvv": "***"
  }
}
```

---

### PUT `/updateUser`
Update user account info  
**Request Body:**
```json
{
  "sessionToken": "abc123token",
  "userName": "johnUpdated",
  "password": "newPassword",
  "wallet": {
    "card": "1111222233334444",
    "month": "11",
    "year": "2028",
    "cvv": "456"
  }
}
```

**Response:**
```json
{
  "id": 1,
  "role": "user",
  "token": "abc123token"
}
```

---

### POST `/getUserOrder`
Get all orders for logged-in user  
**Request Body:**
```json
{
  "sessionToken": "abc123token"
}
```

**Response:**
```json
[
  {
    "orderID": 1,
    "total": 59.99,
    "cartList": [
      {
        "id": 2,
        "name": "Keyboard",
        "price": 29.99,
        "img": "img/url.jpg"
      },
      {
        "id": 3,
        "name": "Mouse",
        "price": 30.00,
        "img": "img/url2.jpg"
      }
    ]
  }
]
```

---

### POST `/checkOut`
Place an order for the current cart  
**Request Body:**
```json
{
  "sessionToken": "abc123token",
  "cartList": [
    { "id": 1 },
    { "id": 2 }
  ],
  "total": 75.50,
  "wallet": {
    "card": "1234567812345678",
    "month": "07",
    "year": "2026",
    "cvv": "123"
  }
}
```

**Response:** `HTTP 200 OK` (No body)

---

## 🛒 PRODUCT ENDPOINTS

### GET `/products`
Get all available products  
**Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 999.99,
    "img": "img/laptop.jpg",
    "description": "High performance laptop",
    "rating": 4.8
  }
]
```

---

### GET `/products/{id}`
Get product details by ID  
**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99,
  "img": "img/laptop.jpg",
  "description": "High performance laptop",
  "rating": 4.8
}
```

---

## 🔐 ADMIN ENDPOINTS

### POST `/admin/getAllUserOrder`
Return all users' orders  
**Request Body:**
```json
{
  "sessionToken": "adminToken123"
}
```

---

### DELETE `/admin/deleteOrder`
Admin deletes any user's order  
**Request Body:**
```json
{
  "sessionToken": "adminToken123",
  "orderId": 10
}
```

---

## ⚠️ ERROR CODES

| Code | Meaning |
|------|---------|
| 401 | Unauthorized (Invalid or missing token) |
| 403 | Forbidden (No permission) |
| 400 | Bad Request (Validation failed) |
| 404 | Not Found (Invalid resource) |

