// AdminDAO.java
package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    private Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to validate admin login
    public boolean validateAdmin(String email, String password) {
        boolean status = false;
        try {
            String query = "SELECT * FROM admins WHERE email = ? AND password = ?";
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
}
