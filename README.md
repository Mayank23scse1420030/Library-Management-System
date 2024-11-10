Library Management System
This is a Library Management System built using Java (with Spring Boot for the back-end), MySQL (for database), and a front-end using HTML, CSS, and JavaScript. The application allows users to manage books, members, and transactions (book issue and return) for a library.

Features
Add Books: Admins can add new books to the library.
View Books: Users can view the list of available books in the library.
Issue Books: Members can issue books from the library.
Return Books: Members can return books to the library.
View Transactions: The library keeps track of the transactions for book issues and returns.
Technologies Used
Java: Programming language used for back-end development.
Spring Boot: A Java framework used to build the back-end REST API.
MySQL: Relational database used to store books, members, and transactions data.
HTML/CSS: Front-end design and structure of the web application.
JavaScript: For asynchronous interactions between front-end and back-end (via API calls).
JDBC: Java Database Connectivity (JDBC) for interacting with the MySQL database.
Prerequisites
Before running this project, ensure you have the following installed:

Java: Version 8 or higher.
MySQL: Database server installed and running.
Maven: For building the Spring Boot project (optional if using an IDE like IntelliJ IDEA or Eclipse).
Node.js: For running the front-end JavaScript code (optional if needed).
IDE: IntelliJ IDEA, Eclipse, or Visual Studio Code for Java development.
Setting Up the Project
1. Set Up the MySQL Database
Create the database and tables in MySQL by running the following SQL queries:
2. Clone the Repository
Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/your-username/library-management-system.git
cd library-management-system
3. Configure the Database Connection in Spring Boot
Open src/main/resources/application.properties and update the MySQL connection details:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
4. Build the Project
If you're using Maven and an IDE, you can build and run the Spring Boot application directly. Alternatively, from the command line, run:

bash
Copy code
mvn clean install
mvn spring-boot:run
The Spring Boot server should now be running at http://localhost:8080.

5. Running the Front-End
The front-end code (HTML, CSS, and JS) is designed to interact with the Spring Boot API.

Open the index.html file in your browser or serve it using a simple HTTP server.
The front-end will interact with the Spring Boot backend to add books, issue books, and list books.
6. API Endpoints
POST /api/addBook: Add a new book to the library. You need to send a JSON object with title, author, and genre.

Example request body:

json
Copy code
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "genre": "Fiction"
}
GET /api/getBooks: Get a list of all books in the library.

Example response:

json
Copy code
[
  {
    "book_id": 1,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "genre": "Fiction",
    "available": 1
  },
  ...
]
7. Front-End Interactions
Add Book: Fill out the form and click "Add Book" to add a new book to the database. This will make a POST request to /api/addBook.
View Books: The list of books is displayed on the right side of the page, fetched via a GET request to /api/getBooks.
8. How to Use
Admin: As an admin, you can add new books to the library and manage the book collection via the front-end interface.
User: Users can view available books and issue or return them (though issue/return functionality is simplified in this front-end version).
Screenshots
Add Book Form

Available Books

Project Structure
perl
Copy code
library-management-system/
│
├── backend/                # Spring Boot back-end (Java)
│   ├── src/
│   ├── pom.xml             # Maven build configuration
│   ├── application.properties
│
├── frontend/               # HTML, CSS, JS files
│   ├── index.html
│   ├── styles.css
│   ├── app.js
│
└── README.md               # Project documentation
Contributing
Fork this repository.
Create a new branch: git checkout -b feature/your-feature.
Commit your changes: git commit -m 'Add new feature'.
Push to the branch: git push origin feature/your-feature.
Open a pull request.
