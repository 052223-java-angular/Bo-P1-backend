# P1- Flashpoints


## Introduction
Flashpoints is an application that utilizes Spring Boot, a frontend written in Angular, and a PostgreSQL database to allow users to explore important moments in history.

## User Stories
In Flashpoints there are three types of users: 
Non-registered users, Writers of History, and
Makers of History.

As a **non-registered user**: 

 - I can browse all the articles
 - I can read all the comments about the articles
 - I can search for articles by their tags
 - I can register to become a Writer of History
 - I will be exposed to advertisements

As a **Writer of History**:

 - I can do all of the above besides registering again
 - I can log into my account
 - I can leave comments about the articles and engage in healthy historical debate with other Writers and Makers
 - I can write articles
 - I can edit my own articles
 
 As a **Maker of History**:
 - I can do all of the above besides registering again
 - I can ban problematic Writers
 - I can edit other's articles
 - I can delete articles

## MVP (Minimum Viable Product)

 - Non-registered users can explore the site and its articles and comment sections
 - Non-registered users can register to become a Writer
 - Writers can write new articles
 - Writers can edit their articles
 - Writers can leave comments
 - Makers can manipulate all articles
 - Makers can ban Writers
 - Makers can delete articles

## Stretch Goals

 - Makers can create new tags
 - Profile system that displays when a user makes a comment (different roles have different colors, show the number of comments the user has, etc.)
 - Makers can promote Writers to Makers


## Tech Stacks
-   **Java**: The main programming language used for building the application.
-   **PostgreSQL**: Used as the database to store user, product, and order data.
-   **Maven or Gradle**: Used for managing project dependencies.
-   **JUnit**: A testing framework for Java applications, used to ensure our code works as expected.
-   **Log4j**: A logging utility for debugging purposes.
-   **BCrypt**: A Java library for hashing and checking passwords for security.
-   **JUnit, Mockito, and PowerMock**: Used for unit and integration testing.
-   **Git and GitHub**: Used for version control.
- **Spring Boot**: To build the API
- **Angular**: To build the front end
- **Google Maps API**: To point out where events took place


# Requirements

-   **Clean Codebase**: All code should be clean and well-documented. The repository should not include any unnecessary files or folders such as the  `target/`,  `.DS_Store`, etc. All files and directories should be appropriately named and organized.
    
-   **Database Design**: The database should be designed following the principles of the 3rd Normal Form (3NF) to ensure data integrity and efficiency. An Entity Relationship Diagram (ERD) should be included in the documentation.
    
-   **Secure**: All sensitive user data such as passwords must be securely hashed before storing it in the database. The application should not display any sensitive information in error messages.
    
-   **Error Handling**: The application should handle potential errors gracefully and provide clear and helpful error messages to the users.
    
-   **Testing**: The application should have a high test coverage. Unit tests and integration tests should be implemented using JUnit, Mockito, and PowerMock.
    
-   **Version Control**: The application should be developed using a version control system, preferably Git, with regular commits denoting progress.
    
-   **Documentation**: The repository should include a README file with clear instructions on how to run the application. Code should be well-commented to allow for easy understanding and maintenance.
    
-   **Scalable**: The design of the application should be scalable, allowing for easy addition of new features or modifications in the future.
