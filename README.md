# Inditex Pricing API

This project is a Spring Boot application that provides a REST endpoint to query the final prices of products based on the application date, product identifier, and brand identifier. It uses an H2 in-memory database and is initialized with sample data.

## Choice of Hexagonal Architecture

This project has been designed using hexagonal architecture for the following reasons:

### Separation of Concerns

Hexagonal architecture allows a clear separation of concerns. Business logic and domain rules reside in the central layer, while implementation details (adapters) are in the external layers. This facilitates code understanding and long-term maintenance.

### Flexibility and Unit Testing

The separation of layers makes it easy to substitute implementations without affecting the business logic. Furthermore, this architecture facilitates unit testing, as external layers can be easily simulated or replaced with test implementations.

### Adaptability to Changes

Hexagonal architecture provides greater adaptability to changes in requirements and technologies. External layers act as adapters, making it easy to introduce new technologies or modify implementations without affecting the core of the application.

### Improvement of Maintainability

The clear separation of responsibilities and ease of performing unit tests contribute to the improvement of code maintainability. This is especially valuable in environments where code evolution is expected over time.

It was done this way for efficiency in code modularity, clarity, and maintainability.

## Project Execution

- Run the application using Maven:

  ```bash
  mvn spring-boot:run
  
The application will run at http://localhost:8080.

## API Documentation

### Endpoints
- Query Prices
- URL: /prices
- Método: GET
### Query Parameters:

``` 
 - brandId (Brand identifier)
 - productId (Product identifier)
 - date (Application date format, for example, "2020-06-14T16:00:00Z")
  ``` 
### Successful Response:

  ``` 
 - Status Code: 200 (OK)
 - Response Body: JSON with price details.
  ``` 

## Ejemplos de uso

Test 1: Request at 10:00 on the 14th day for product 35455 for brand 1 (ZARA)
```
curl -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-14T10:00:00Z"
```

Test 2: Request at 16:00 on the 14th day for product 35455 for brand 1 (ZARA)
```
curl -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-14T16:00:00Z"
```

Test 3: Request at 21:00 on the 14th day for product 35455 for brand 1 (ZARA)
```
curl -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-14T21:00:00Z"
```
Test 4: Request at 10:00 on the 15th day for product 35455 for brand 1 (ZARA)
```
curl -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-15T10:00:00Z"
```

Test 5: Request at 21:00 on the 16th day for product 35455 for brand 1 (ZARA)

```
curl -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-16T21:00:00Z"
```
