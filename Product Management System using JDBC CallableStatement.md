
# 📦 Product Management System using JDBC CallableStatement

## 🌟 Project Overview

The **Product Management using JDBC CallableStatement** project demonstrates the use of Java Database Connectivity (JDBC) for managing product data in a database using stored procedures. This project is built with a layered architecture and showcases how to securely and efficiently execute stored procedures using JDBC's `CallableStatement`.

### 🔑 Key Features:
- **CRUD Operations**: Perform Create, Read, Update, and Delete operations on product records using JDBC's `CallableStatement` to interact with stored procedures.
- **Database Interaction**: Use `CallableStatement` for executing stored procedures, ensuring secure and optimized database interactions.
- **Layered Architecture**: The project follows a well-structured approach with separate layers:
  - **DAO Layer**: Contains the `daoI` (interface) and `daoImpl` (implementation) for interacting with the database.
  - **Model Layer**: Represents the `Product` entity with attributes such as name, category, and price.
  - **Service Layer**: Encapsulates business logic related to products, implemented in `serviceI` and `serviceImpl`.
  - **UI Layer**: Provides a user interface for managing products.
  - **Utility Layer**: Contains utility classes for database connections and other common tasks.

## 🛠️ Technologies Used:
- **Java 8**: For building the core logic.
- **JDBC (CallableStatement Interface)**: For executing stored procedures in the database.
- **MySQL**: The relational database used to store product information.

## 📂 Folder Structure:

```
com.sms.jdbc.callableStatement
│
├── daoI                # DAO Interface for database operations
├── daoImpl             # DAO Implementation for database operations
├── model               # Model representing Product entity
├── serviceI            # Service Interface for business logic
├── serviceImpl         # Service Implementation for business logic
├── ui                  # User Interface classes for interaction
└── util                # Utility classes for common tasks (e.g., database connection)
```

## 🚀 Installation:

1. Clone the repository:
   ```bash
   git clone github.com/thevishalchothe/JDBC-Database-Management-Systems.git
   ```

2. Set up MySQL database:
   - Create a database (e.g., `product_management`).
   - Configure the database connection settings in the `util` class.

3. Run the project:
   - Compile and run the project using your preferred IDE or command-line tools.

## 📝 Usage:
- Perform CRUD operations on product records via the UI, leveraging stored procedures for efficient database operations.
- Modify `serviceImpl` to extend business logic or add new functionality.
