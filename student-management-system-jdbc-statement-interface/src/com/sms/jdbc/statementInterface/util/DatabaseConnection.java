package com.sms.jdbc.statementInterface.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

//Database Connection: Handled by DatabaseConnection class, which establishes a connection to the MySQL database.
public class DatabaseConnection {

    // JDBC connection details
    private static final String URL = "jdbc:mysql://localhost:3306/student_jdbc_db";
    private static final String USER = "root";  // Change to your MySQL username
    private static final String PASSWORD = "root";  // Change to your MySQL password

    // SQL query to create the students table
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS students ("
            + "id INT AUTO_INCREMENT PRIMARY KEY, "  // Make id auto-increment
    		+"roll_no VARCHAR(20) UNIQUE NOT NULL, "
    		+ "name VARCHAR(50) NOT NULL, "
            + "email VARCHAR(50) NOT NULL, "
            + "course VARCHAR(50) NOT NULL"
            + ")";

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to create the students table if it doesn't exist
    public static void createTable() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            // Execute the SQL query to create the table if it doesn't exist
            stmt.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("The 'students' table is ready.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
