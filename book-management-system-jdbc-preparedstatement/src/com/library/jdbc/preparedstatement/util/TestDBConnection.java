package com.library.jdbc.preparedstatement.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {

    public static void main(String[] args) {
        try {
            // Step 1: Test the database connection
            Connection connection = DatabaseConnection.getConnection();

            // Step 2: Check if the connection is successful
            if (connection != null) {
                System.out.println("Database connected successfully!");
                
                // Step 3: Optionally, test the table creation
                DatabaseConnection.createTables();  // Create the tables if they don't exist
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}
