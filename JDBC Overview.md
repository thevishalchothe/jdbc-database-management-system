# JDBC (Java Database Connectivity) - Overview & Usage 📑🚀

**JDBC** is a Java API that facilitates communication between Java applications and database systems. 📚 

- **JDBC** stands for **Java Database Connectivity**.
- **API** stands for **Application Programming Interface**.
- The JDBC API contains **classes, methods, and interfaces** used for **database communication**.
- JDBC is used for communication between **Java applications** and **database applications**.
- JDBC API allows you to **connect to databases** and **execute SQL queries**.
- JDBC is a **specification** defined by Java vendors, and it is implemented by various database vendors like **MySQL**, **Oracle**, etc.
- JDBC is a **database-independent** API, enabling connections to any **relational database**.
- The JDBC API is written in **Java**.
- We will use **JDBC Type-4 driver**, which is fully written in Java.
- JDBC is used to perform **CRUD operations** on databases: **Creating** (Inserting), **Reading** (Retrieving), **Updating**, **Deleting**.

--- 

## Why Use JDBC? 🤔

JDBC offers several advantages for connecting Java applications to databases:

- 📂 **Efficient data storage and management** compared to file systems.
- 📊 **Store and manage large amounts of data** in relational tables.
- 🔗 **Maintain relationships** between Java objects and database tables.
- 🧑‍💻 **Efficient querying and sorting** of data.

## Key JDBC Interfaces and Classes ⚙️

JDBC provides the following important components for database interaction:

- **DriverManager**: Manages a list of database drivers.
- **Connection**: Provides methods for establishing a connection to the database.
- **Statement**: Used to submit SQL queries to the database.
- **ResultSet**: Holds data retrieved from the database after executing an SQL query.

### Types of Statements in JDBC 💬

JDBC supports three types of statements for executing queries:

1. **Statement**
2. **PreparedStatement**
3. **CallableStatement**

#### 1) Statement 📜

The `Statement` interface is part of the `java.sql` package and provides methods for executing static SQL queries. These queries do not contain any parameters and are executed as-is.

**How to Create a Statement Object**:

```java
Statement smt = con.createStatement();
```

##### Methods of Statement Interface:

- **`executeQuery(String sql)`**: Executes SELECT queries and returns a `ResultSet` containing the results.
  ```java
  ResultSet rs = smt.executeQuery("SELECT * FROM students");
  ```

- **`executeUpdate(String sql)`**: Executes non-SELECT queries (INSERT, UPDATE, DELETE) and returns an integer indicating the number of rows affected.
  ```java
  int rowsAffected = smt.executeUpdate("INSERT INTO students (rno, name) VALUES (1, 'Vishal')");
  ```

- **`execute(String sql)`**: Executes any SQL query and returns a boolean indicating whether the query returned a `ResultSet`.
  ```java
  boolean isResultSet = smt.execute("SELECT * FROM students");
  ```

#### 2) PreparedStatement 📝

`PreparedStatement` is an extension of `Statement` that allows the execution of **pre-compiled SQL queries** with **parameterized queries**. This improves performance and security by avoiding repeated compilation of the same query.

**Example of Using PreparedStatement**:

```java
String sql = "INSERT INTO student(column1, column2, column3) VALUES (?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, 101);   // Set first parameter value
pstmt.setString(2, "Vishal");
pstmt.setString(3, "Chothe");
pstmt.executeUpdate();  // Execute the query
```

### Difference Between `Statement` and `PreparedStatement` ⚖️

| **Statement**                                             | **PreparedStatement**                                    |
|-----------------------------------------------------------|----------------------------------------------------------|
| Executes multiple queries with one object.                | Executes only one query per object.                      |
| SQL query is compiled each time it's executed.            | SQL query is compiled once and reused.                   |
| Requires string concatenation to include parameters.      | Uses placeholders (`?`) for parameters, improving security. |
| Less efficient when executing the same query multiple times. | More efficient due to pre-compilation and reuse of the query plan. |


#### 3) CallableStatement 📞

`CallableStatement` is used to execute **stored procedures**. Stored procedures are pre-compiled SQL statements stored in the database, allowing for reusable logic and operations.

### What is a Stored Procedure in MySQL? 🗂️

A **stored procedure** is a group of pre-compiled SQL statements that are stored on the **database side**. It allows you to perform **business logic** or logical operations directly in the database. Stored procedures can be used to perform one or more **DML (Data Manipulation Language)** operations on the database, such as `INSERT`, `UPDATE`, or `DELETE`.

Key points about Stored Procedures:
- 🔄 **Code Reusability**: Stored procedures can be written once, stored, and called multiple times.
- ⚙️ **Execution on DB Server**: Stored procedures are executed directly on the database server, which can improve performance.
- 💡 **Parameterization**: Stored procedures can accept parameters, enabling dynamic behavior.

### Types of Parameters in Stored Procedures 📑

There are three types of parameters in stored procedures:

1. **IN parameter**: This is the default mode. It is used to provide input values to the stored procedure.
2. **OUT parameter**: This is used to return output values from the stored procedure.
3. **INOUT parameter**: A combination of IN and OUT parameters, which allows both input and output.

### How to Create a Stored Procedure in MySQL? 🛠️

To create a stored procedure, you can use the following syntax:

```sql
CREATE PROCEDURE procedure_name(IN parameter1 INT, OUT parameter2 VARCHAR(50))
BEGIN
    -- SQL statements
END;
```

Example:

```sql
CREATE PROCEDURE getStudentDetails(IN student_id INT, OUT student_name VARCHAR(50))
BEGIN
    SELECT name INTO student_name
    FROM students
    WHERE id = student_id;
END;
```

### How to Call a Stored Procedure from Java? 📲

To call a stored procedure from a Java application, you can use the `CallableStatement` interface. The syntax for calling a stored procedure is:

```java
{call procedure_name(?, ?)}
```

Here's an example of how to call a stored procedure from Java:

```java
CallableStatement cstmt = con.prepareCall("{call getStudentDetails(?, ?)}");
cstmt.setInt(1, 101);  // Set input parameter
cstmt.registerOutParameter(2, Types.VARCHAR);  // Register output parameter
cstmt.execute();  // Execute the stored procedure
String result = cstmt.getString(2);  // Retrieve output parameter
```

## Steps to Connect Java Application to a Database Using JDBC 🚀

### Step 1: Load the JDBC Driver 🏗️

To load the JDBC driver, use the `Class.forName()` method:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### Step 2: Establish Connection 🔗

Use `DriverManager.getConnection()` to establish a connection to the database:

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_project_db", "root", "root");
```

### Step 3: Construct the SQL Query 📝

Write the SQL query you wish to execute, such as creating a table:

```java
String sql = "CREATE TABLE student (rno INT PRIMARY KEY, name VARCHAR(20))";
```

### Step 4: Create Statement Object 🛠️

Create a `Statement` object to execute the query:

```java
Statement stmt = con.createStatement();
```

### Step 5: Execute the SQL Query ▶️

Use the `execute()` method to run the SQL query:

```java
stmt.execute(sql);
```

### Step 6: Close the Resources 🔒

Always close the resources to free up memory:

```java
stmt.close();
con.close();
```

## Example Code 💻

Here's an example of a complete JDBC program that connects to a MySQL database, creates a table, and closes the connection:

```java
import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // Step 1: Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_project_db", "root", "root");

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

- JDBC provides an interface for connecting Java applications to databases.
- It supports three types of statements: `Statement`, `PreparedStatement`, and `CallableStatement`, each for different types of SQL queries.
- `PreparedStatement` is preferred for parameterized queries due to its performance and security advantages.
- `CallableStatement` is used to call stored procedures from Java.
- Stored procedures are useful for code reusability, improving performance by executing logic directly on the database server.
