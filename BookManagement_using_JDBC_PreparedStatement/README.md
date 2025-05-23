# Book Management System (JDBC PreparedStatement) 🌐

The `Book Management System` project example demonstrate the use of Java Database Connectivity (JDBC) for managing book data in a database. The project is built using a layered architecture, focusing on the `PreparedStatement` interface for secure and efficient interaction with the database.


### Key Features: 🔑
- **CRUD Operations**: Perform Create, Read, Update, and Delete operations on book records using JDBC's `PreparedStatement`.
- **Database Interaction**: Use `PreparedStatement` to interact with the database, ensuring protection against SQL injection attacks.
- **Layered Architecture**: The project is organized into separate layers for better code management:
  - **DAO Layer**: Contains the `daoI` (interface) and `daoImpl` (implementation) for database operations.
  - **Model Layer**: Represents the `Book` entity with properties such as title, author, and ISBN.
  - **Service Layer**: Implements business logic for managing books, encapsulated in `serviceI` and `serviceImpl`.
  - **UI Layer**: Provides a user interface for interacting with the book management system.
  - **Utility Layer**: Contains helper classes for database connection and other utility functions.

## Technologies Used: 🛠️ 
- **Java**: For building the core logic.
- **JDBC (PreparedStatement Interface)**: For secure interaction with the database.
- **MySQL**: The relational database for storing book information.

## Folder Structure: 📂 

```
com.sms.jdbc.preparedStatement
│
├── daoI                # DAO Interface for database operations
├── daoImpl             # DAO Implementation for database operations
├── model               # Model representing Book entity
├── serviceI            # Service Interface for business logic
├── serviceImpl         # Service Implementation for business logic
├── ui                  # User Interface classes for interaction
└── util                # Utility classes for common tasks (e.g., database connection)
```

## Installation: 🚀

1. Clone the repository:
   ```bash
   git clone github.com/thevishalchothe/JDBC-Database-Management-Systems.git
   ```

2. Set up MySQL database:
   - Create a database (e.g., `book_management`).
   - Configure the database connection settings in the `util` class.

3. Run the project:
   - Compile and run the project using your preferred IDE or command-line tools.

## Usage: 📝
- Perform CRUD operations on book records through the UI.
- Modify `serviceImpl` to add additional business logic or functionality.
