package com.user.dao;

import com.user.model.CourseManagement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseManagementDAO {
    private Connection connection;

    public CourseManagementDAO(Connection connection) {
        this.connection = connection;
    }

    public List<CourseManagement> getAllCourses() {
        List<CourseManagement> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CourseManagement course = new CourseManagement();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDescription(rs.getString("description"));
                course.setCreatedAt(rs.getTimestamp("created_at"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public CourseManagement getCourseById(int courseId) {
        String query = "SELECT * FROM courses WHERE course_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CourseManagement course = new CourseManagement();
                    course.setCourseId(rs.getInt("course_id"));
                    course.setCourseName(rs.getString("course_name"));
                    course.setDescription(rs.getString("description"));
                    course.setCreatedAt(rs.getTimestamp("created_at"));
                    return course;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createCourse(CourseManagement course) {
        String query = "INSERT INTO courses (course_name, description, created_at) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getDescription());
            stmt.setTimestamp(3, new Timestamp(course.getCreatedAt().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(CourseManagement course) {
        String query = "UPDATE courses SET course_name = ?, description = ?, created_at = ? WHERE course_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getDescription());
            stmt.setTimestamp(3, new Timestamp(course.getCreatedAt().getTime()));
            stmt.setInt(4, course.getCourseId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int courseId) {
        String query = "DELETE FROM courses WHERE course_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
