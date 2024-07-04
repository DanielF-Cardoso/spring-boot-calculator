## Overview
This project is a simple API developed using Spring Boot 3.2.7, designed to perform basic arithmetic operations such as addition, subtraction, multiplication, division, mean calculation, and square root. It serves as an example of how to create and manage APIs in Spring Boot, showcasing exception handling and custom error responses.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white)

## Features
The API provides the following endpoints for arithmetic operations:

- **Addition**: `/sum/{numberOne}/{numberTwo}`
- **Subtraction**: `/subtraction/{numberOne}/{numberTwo}`
- **Multiplication**: `/multiplication/{numberOne}/{numberTwo}`
- **Division**: `/division/{numberOne}/{numberTwo}`
- **Mean**: `/mean/{numberOne}/{numberTwo}`
- **Square Root**: `/squareRoot/{number}`

Each endpoint accepts two numbers as path variables, except for the square root, which only requires one number. The API is designed to handle invalid inputs and division by zero scenarios gracefully, returning meaningful error messages in JSON format.

## Getting Started

### Prerequisites
- JDK 17 or later
- Maven 3.2+

### Running the Application
1. Clone the repository to your local machine.
   ```sh
   git clone https://github.com/DanielF-Cardoso/spring-boot-calculator.git
   ```
2. Run the following command to build the project:
   ```sh
   mvn clean install
   ```
3. Once the build is successful, start the application with:
   ```sh
   mvn spring-boot:run
   ```
The application will start running on http://localhost:8080.

### Accessing the Endpoints
You can access the API endpoints using any HTTP client such as Postman
   ```sh
   http://localhost:8080/sum/1/2
   ```
Replace /sum/1/2 with the desired endpoint and input values accordingly.      
