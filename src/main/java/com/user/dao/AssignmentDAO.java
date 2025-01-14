package com.user.dao;

import com.user.model.Assignment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDAO {
    private final Connection connection;

    public AssignmentDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createAssignment(Assignment assignment) {
        String sql = "INSERT INTO assignmenttable (course_id, course_name, assignment, last_date) " +
                     "SELECT ?, course_name, ?, ? FROM courses WHERE course_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, assignment.getCourseId());
            stmt.setString(2, assignment.getAssignment());
            stmt.setDate(3, assignment.getLastDate());
            stmt.setInt(4, assignment.getCourseId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Assignment> getAllAssignments() {
        String sql = "SELECT * FROM assignmenttable";
        List<Assignment> assignments = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Assignment assignment = new Assignment();
                assignment.setAssignmentId(rs.getInt("assignment_id"));
                assignment.setCourseId(rs.getInt("course_id"));
                assignment.setCourseName(rs.getString("course_name"));
                assignment.setAssignment(rs.getString("assignment"));
                assignment.setCreatedDate(rs.getDate("created_date"));
                assignment.setLastDate(rs.getDate("last_date"));
                assignments.add(assignment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignments;
    }
}
