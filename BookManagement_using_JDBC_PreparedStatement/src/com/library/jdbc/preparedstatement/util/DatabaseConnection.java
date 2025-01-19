package com.library.jdbc.preparedstatement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Database Connection: Handled by DatabaseConnection class, which establishes a connection to the MySQL database.
public class DatabaseConnection {

    // JDBC connection details
    private static final String URL = "jdbc:mysql://localhost:3306/library_prepared_db";
    private static final String USER = "root";  
    private static final String PASSWORD = "root";  

    // SQL query to create the books table
    private static final String CREATE_BOOKS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS books ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "
            + "isbn VARCHAR(20) UNIQUE NOT NULL, "
            + "title VARCHAR(100) NOT NULL, "
            + "author VARCHAR(100) NOT NULL, "
            + "publisher VARCHAR(50), "
            + "quantity INT NOT NULL"
            + ")";

	/*
	 * // SQL query to create the users table private static final String
	 * CREATE_USERS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS users (" +
	 * "id INT AUTO_INCREMENT PRIMARY KEY, " +
	 * "username VARCHAR(50) UNIQUE NOT NULL, " + "password VARCHAR(100) NOT NULL, "
	 * + "email VARCHAR(50) NOT NULL" + ")";
	 */
  
    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to create the books and users tables if they don't exist
    public static void createTables() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            // Execute the SQL queries to create the tables if they don't exist
            stmt.executeUpdate(CREATE_BOOKS_TABLE_SQL);
            //stmt.executeUpdate(CREATE_USERS_TABLE_SQL);
            System.out.println("The 'books' tables are ready.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
