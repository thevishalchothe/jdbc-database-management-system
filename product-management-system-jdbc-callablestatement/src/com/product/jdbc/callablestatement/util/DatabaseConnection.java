package com.product.jdbc.callablestatement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

// Database Connection: Handled by DatabaseConnection class, which establishes a connection to the MySQL database.
public class DatabaseConnection {

    // JDBC connection details
    private static final String URL = "jdbc:mysql://localhost:3306/product_collable_db"; // Database name
    private static final String USER = "root";  // Database username
    private static final String PASSWORD = "root";  // Database password

    // Stored procedure name for creating the table
    private static final String CREATE_TABLE_PROCEDURE = "{CALL CreateProductsTable()}";

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to invoke the stored procedure for creating the table
    public static void createTables() {
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(CREATE_TABLE_PROCEDURE)) {

            // Execute the stored procedure
            callableStatement.execute();
            System.out.println("The 'products' table is ready using CallableStatement.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
