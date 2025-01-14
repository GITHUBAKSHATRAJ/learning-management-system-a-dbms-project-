package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.Enrollment;

public class EnrollmentDAO {
    private final Connection connection;

    public EnrollmentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Enrollment> getEnrollmentsByCourseId(int courseId) {
        String sql = "SELECT * FROM Users_courses WHERE course_1 = ? OR course_2 = ? OR course_3 = ? OR course_4 = ? OR course_5 = ?";
        List<Enrollment> enrollments = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            stmt.setInt(2, courseId);
            stmt.setInt(3, courseId);
            stmt.setInt(4, courseId);
            stmt.setInt(5, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                enrollments.add(new Enrollment(
                    rs.getInt("user_id"), // Assuming user_id corresponds to enrollment ID
                    courseId,
                    rs.getInt("user_id") // Assuming user_id corresponds to student ID
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}
