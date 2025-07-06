# Promotion Engine

A Spring Boot application that calculates the checkout total of a cart by applying modular promotions. No database is used; prices and promotions are in-memory.

## Key Features
- Apply fixed-quantity promotions (e.g., 3 A's for 130)
- Apply combo promotions (e.g., C + D = 30)
- Easily extendable for future promotion types
- TDD unit tests



## Technologies
- Java 17
- Spring Boot
- JUnit 5
- Lombok

## API Endpoints

| Method | Endpoint                    | Description                          |
|--------|-----------------------------|--------------------------------------|
| POST    | /api/checkout              | Calculate total price from item list | 

## API
**POST** `/api/checkout`
```json
[
  {"sku": {"id": "A", "unitPrice": 50}, "quantity": 3},
  {"sku": {"id": "B", "unitPrice": 30}, "quantity": 5},
  {"sku": {"id": "C", "unitPrice": 20}, "quantity": 1},
  {"sku": {"id": "D", "unitPrice": 15}, "quantity": 1}
]
```
Returns:
```json
280
```

## Pre-requisites

1. Java 21+
2. Gradle (or use the Gradle wrapper provided in the project)


## Installation

##### 1. Clone the repository:
```bash
git clone https://github.com/NiveditaBac/Godash-Assignment-Promotion-Engine.git
cd your-repo-name
```


##### 2. Build and Run the Service:

Use Gradle to build and run the application
``
./gradlew bootRun
``

##### 3. Access the Application:

By default, the application will run at:
> http://localhost:8080