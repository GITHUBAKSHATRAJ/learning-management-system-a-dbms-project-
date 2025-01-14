package com.user.dao;

import java.sql.Connection;
import java.util.Scanner;

import com.user.utility.DBConnection;

public class TestUserDAO {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter email:");
            String email = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            Connection connection = DBConnection.getConnection();
            UserDAO userDAO = new UserDAO(connection);

            boolean isValid = userDAO.validateUser(email, password);

            if (isValid) {
                System.out.println("User validated successfully.");
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
