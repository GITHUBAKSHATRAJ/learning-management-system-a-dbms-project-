// UserDAO.java
package com.user.dao;

import java.sql.Connection;
/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/

import com.user.utility.DBConnection;

/*public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to validate user login
    public boolean validateUser(String email, String password) {
        boolean status = false;
        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}*/




public class UserDAO {
    private Connection connection;

    // Constructor to initialize the connection
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to validate user login
    public boolean validateUser(String email, String password) {
        boolean status = false;
        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Initialize your database connection here
        Connection connection = DBConnection.getConnection(); // Ensure DBConnection is properly implemented
        if (connection == null) {
            System.out.println("Failed to establish database connection.");
            return;
        }

        // Create a UserDAO instance
        UserDAO userDAO = new UserDAO(connection);

        // Test with given parameters
        String email = "akshatraj879@gmail.com";
        String password = "123";
        boolean isValid = userDAO.validateUser(email, password);

        // Print result
        System.out.println("Login valid: " + isValid);

        // Close the database connection
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
