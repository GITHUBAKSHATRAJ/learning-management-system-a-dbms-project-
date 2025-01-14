package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.user.model.Submissions;

public class SubmissionsDAO {
    private Connection connection;

    public SubmissionsDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Submissions> getAllSubmissions() throws SQLException {
        List<Submissions> submissions = new ArrayList<>();
        String query = "SELECT * FROM submissions";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Submissions submission = new Submissions();
                submission.setSubmissionId(rs.getInt("submission_id"));
                submission.setAssignmentId(rs.getInt("assignment_id"));
                submission.setUserId(rs.getInt("user_id"));
                submission.setUserName(rs.getString("user_name"));
                submission.setUrl(rs.getString("url"));
                submission.setSubmittedAt(rs.getString("submitted_at"));
                submissions.add(submission);
            }
        }
        return submissions;
    }

    public static void main(String[] args) {
        // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/lms"; // Replace with your database name
        String dbUser = "root"; // Replace with your database username
        String dbPassword = "akshat@123"; // Replace with your database password

        try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            // Instantiate the DAO
            SubmissionsDAO submissionsDAO = new SubmissionsDAO(connection);

            // Fetch submissions and print them
            List<Submissions> submissions = submissionsDAO.getAllSubmissions();
            for (Submissions submission : submissions) {
                System.out.println("Submission ID: " + submission.getSubmissionId());
                System.out.println("Assignment ID: " + submission.getAssignmentId());
                System.out.println("User ID: " + submission.getUserId());
                System.out.println("User Name: " + submission.getUserName());
                System.out.println("URL: " + submission.getUrl());
                System.out.println("Submitted At: " + submission.getSubmittedAt());
                System.out.println("---------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
