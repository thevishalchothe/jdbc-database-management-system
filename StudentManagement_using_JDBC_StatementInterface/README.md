# Student Management System (JDBC Statement Interface) 🌐

The `Student Management System` project example demonstrate the use of Java Database Connectivity (JDBC) for managing student data in a database. This project is built using a layered architecture, with separate layers for DAO (Data Access Object), Service, Model, UI, and Utility, ensuring clear separation of concerns and maintainability.

### Key Features: 🔑
- **CRUD Operations**: Perform Create, Read, Update, and Delete operations on student data using JDBC's `Statement` interface.
- **Database Interaction**: Utilize JDBC for connecting to a relational database and executing SQL queries.
- **Layered Architecture**: The project is organized into layers for easy maintenance and scalability:
  - **DAO Layer**: Contains the `daoI` (interface) and `daoImpl` (implementation) for interacting with the database.
  - **Model Layer**: Represents the `Student` entity with attributes and getter/setter methods.
  - **Service Layer**: Defines business logic for managing student operations, implemented in `serviceI` and `serviceImpl`.
  - **UI Layer**: Provides a user interface (command-line or basic UI) for interacting with the system.
  - **Utility Layer**: Contains helper classes for database connection and other common tasks.

## Technologies Used: 🛠️
- **Java**: For building the core functionality.
- **JDBC (Statement Interface)**: For connecting and interacting with the database.
- **MySQL**: For the relational database used in the project.

## Folder Structure: 📂 

```
com.sms.jdbc.statementInterface
│
├── daoI                # DAO Interface for database operations
├── daoImpl             # DAO Implementation for database operations
├── model               # Model representing Student entity
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
   - Create a database (e.g., `student_management`).
   - Configure the database connection settings in the `util` class.

3. Run the project:
   - Compile and run the project using your preferred IDE or command-line tools.

## Usage: 📝 
- You can perform CRUD operations on student records through the UI.
- Modify the `serviceImpl` classes to add more business logic if needed.
