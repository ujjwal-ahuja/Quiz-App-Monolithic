# 📌 Quiz-App-Monolithic

## 📜 Description

Quiz-App-Monolithic is a Spring Boot-based monolithic application for creating and managing quizzes. Users can create questions, compile them into quizzes, and submit answers to receive scores.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Architecture & Design](#architecture--design)
- [Installation & Setup](#installation--setup)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Future Enhancements](#future-enhancements)
- [License](#license)
- [Contributing](#contributing)
- [Contact](#contact)

## Features

- **Dynamic Quiz Creation:** Generate quizzes based on a specified category with a configurable number of random questions.
- **Question Management:** Add, retrieve, and filter questions by category.
- **Quiz Execution:** Submit quiz responses and receive real-time results.
- **Robust Error Handling:** Detailed error responses and exception management for better debugging.
- **Database Integration:** Uses PostgreSQL with Spring Data JPA for data persistence.
- **Clean Code Practices:** Uses Lombok to reduce boilerplate code and enhance readability.

## Technologies

- **Java 23**
- **Spring Boot 3.4.2**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**

## Architecture--Design

Quiz-App-Monolithic follows a layered architecture which separates concerns into the following layers:

- **Controller Layer:** Handles HTTP requests and maps them to the service layer.
- **Service Layer:** Contains business logic for managing questions and quizzes.
- **Data Access Layer (DAO):** Uses Spring Data JPA repositories for database interactions.
- **Model Layer:** Defines entities like `Question` and `Quiz` using JPA annotations.

The application demonstrates best practices in building a RESTful API, managing database relationships, and structuring a monolithic project in Java.

## Installation--Setup

### Prerequisites

- Java 23 or higher installed
- Maven installed
- PostgreSQL database server

### Steps

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/ujjwal-ahuja/Quiz-App-Monolithic.git
   cd Quiz-App-Monolithic

2. **🚀 Configure the Database**

Update the `application.properties` file located in `src/main/resources/` with your PostgreSQL credentials:

```properties
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
spring.datasource.username=postgres
spring.datasource.password=0000
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
3. **🚀 Build the Project**

Run Maven to build the project:

```bash
mvn clean install
```
4. **🚀 Run the Application**

Start the application using Maven:

```bash
mvn spring-boot:run
```
## 📌 API Endpoints

### 🎯 Question API

- **GET** `/question/`  
  *Description:* Home endpoint to trigger initial loading (can be extended).

- **GET** `/question/allQuestions`  
  *Description:* Retrieve all available questions.

- **GET** `/question/category/{category}`  
  *Description:* Retrieve questions by category.

- **POST** `/question/add`  
  *Description:* Add a new question by passing a JSON payload.

### 🎯 Quiz API

- **POST** `/quiz/create?category={category}&numQ={numQuestions}&title={quizTitle}`  
  *Description:* Create a new quiz based on a category.

- **GET** `/quiz/get/{id}`  
  *Description:* Retrieve quiz questions wrapped in a user-friendly format.

- **POST** `/quiz/submit/{id}`  
  *Description:* Submit quiz responses and calculate the result.
  
 ## 📂 Project Structure

```plaintext
Quiz-App-Monolithic/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ujjwal/
│   │   │           └── quizapp/
│   │   │               ├── controller/          # REST controllers for questions and quizzes
│   │   │               ├── dao/                 # Data Access Objects using Spring Data JPA
│   │   │               ├── model/               # Entity and model classes (Question, Quiz, etc.)
│   │   │               └── service/             # Business logic for handling operations
│   │   └── resources/
│   │       ├── application.properties  # Application configuration
│   │       └── static/              # Static resources (if any)
│   └── test/
│       └── java/                    # Unit and integration tests
├── pom.xml                          # Maven configuration
└── README.md                        # This file
```

## Future Enhancements

- **User Authentication:** Integrate security to manage quiz takers and administrators.
- **Frontend Integration:** Develop a user interface using frameworks like React or Angular.
- **Advanced Analytics:** Provide detailed analytics and reporting for quiz performance.

## 📜 License

This project is licensed under the MIT License. For full details, please visit [opensource.org/licenses/MIT](https://opensource.org/licenses/MIT).

## 🤝 Contributing

Contributions are welcome! Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## 📫 Contact

- **Email**: [ujjwal1398@gmail.com](mailto:ujjwal1398@gmail.com)
- **GitHub**: [github.com/ujjwal-ahuja](https://github.com/ujjwal-ahuja)
- **LinkedIn**: [linkedin.com/in/ujjwalahuja1398](https://www.linkedin.com/in/ujjwalahuja1398/)
