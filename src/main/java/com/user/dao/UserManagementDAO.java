package com.user.dao;

import com.user.model.UserManagement;
import com.user.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagementDAO {

    private Connection connection;

    // Constructor
    public UserManagementDAO() {
        connection = DBConnection.getConnection();
    }

    // Add a new user
    public boolean addUser(UserManagement user) {
        String query = "INSERT INTO users (name, email, password, profile_details) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getProfileDetails());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all users
    public List<UserManagement> getAllUsers() {
        List<UserManagement> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                UserManagement user = new UserManagement();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setProfileDetails(resultSet.getString("profile_details"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update an existing user
    public boolean updateUser(UserManagement user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ?, profile_details = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getProfileDetails());
            preparedStatement.setInt(5, user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a user
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserManagement getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        UserManagement user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new UserManagement();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setProfileDetails(resultSet.getString("profile_details"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user; // Return the user, or null if not found
    }
}
