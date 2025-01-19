# JDBC-Database-Management-Systems 📡

**JDBC-Database-Management-Systems** is a collection of projects demonstrating JDBC operations in Java. It includes:

- **Student Management** using the `Statement` Interface.
- **Book Management** using `PreparedStatement`.
- **Product Management** with `CallableStatement`.

These projects showcase various approaches for interacting with databases securely and efficiently.

## Overview 🔍

JDBC (Java Database Connectivity) is a Java API that enables communication between Java applications and database applications. It provides a set of classes, methods, and interfaces that facilitate connecting to a database, executing SQL queries, and retrieving results.

JDBC is a **database-independent** API, meaning you can use it to connect to any relational database like MySQL, Oracle, etc. JDBC is written in Java and typically works with **Type-4 JDBC drivers**, which are fully implemented in Java.

JDBC is used for performing **CRUD (Create, Read, Update, Delete)** operations on databases, such as inserting, deleting, updating, and retrieving data.

## Why Use JDBC? 🤔

Using JDBC in Java provides several benefits:

- 📂 **Efficient data storage and management** compared to using file systems.
- 📊 **Store and manage large amounts of data** in relational tables.
- 🔗 **Maintain relationships** between Java objects and relational database tables.
- 🧑‍💻 **Efficient querying and sorting** of data.

## Key JDBC Interfaces and Classes ⚙️

JDBC provides the following important interfaces and classes for interacting with databases:

- **DriverManager**: Manages a list of database drivers.
- **Connection**: Interface that provides methods for contacting a database.
- **Statement**: Interface used to submit SQL queries to the database.
- **ResultSet**: Interface that holds data retrieved from the database after executing an SQL query using Statement objects.

## Steps to Connect Java Application to a Database Using JDBC 🚀

### Step 1: Load the JDBC Driver 🏗️

To load the JDBC driver, you can use the `Class.forName()` method. This dynamically loads the driver class required to establish a connection to the database.

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### Step 2: Establish Connection with the Database 🔗

After loading the driver, use the `DriverManager.getConnection()` method to establish a connection to the database by providing the database URL, username, and password.

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
```

### Step 3: Construct the SQL Query 📝

Write the SQL query that you want to execute. For example, to create a table:

```java
String sql = "CREATE TABLE student (rno INT PRIMARY KEY, name VARCHAR(20))";
```

### Step 4: Create Statement Object 🛠️

To execute the SQL query, create a `Statement` object from the `Connection` object.

```java
Statement stmt = con.createStatement();
```

### Step 5: Execute the SQL Query ▶️

Use the `execute()` method of the `Statement` object to execute the SQL query.

```java
stmt.execute(sql);
```

### Step 6: Close the Resources 🔒

Finally, close the `Statement` and `Connection` objects to release resources.

```java
stmt.close();
con.close();
```

## Example Code 💻

Here’s an example of a complete JDBC program that connects to a MySQL database, creates a table, and closes the connection.

```java
import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // Step 1: Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

            // Step 3: Construct SQL Query
            String sql = "CREATE TABLE student (rno INT PRIMARY KEY, name VARCHAR(20))";

            // Step 4: Create Statement
            Statement stmt = con.createStatement();

            // Step 5: Execute SQL Query
            stmt.execute(sql);

            System.out.println("Table 'student' created successfully! 🎉");

            // Step 6: Close Resources
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Summary 📑

- JDBC enables communication between Java applications and databases.
- It provides interfaces and classes for connecting, executing queries, and retrieving results.
- The process to connect to a database involves loading the driver, establishing a connection, executing SQL queries, and closing resources.
