package com.user.controller;

import com.user.dao.EnrollmentDAO;
import com.user.model.Enrollment;
import com.user.utility.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet("/viewEnrollmentsByCourseId")
public class EnrollmentManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseIdParam = request.getParameter("courseId");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (courseIdParam == null || courseIdParam.isEmpty()) {
            out.write("{\"error\": \"Course ID is required\"}");
            return;
        }

        int courseId;
        try {
            courseId = Integer.parseInt(courseIdParam);
        } catch (NumberFormatException e) {
            out.write("{\"error\": \"Invalid Course ID\"}");
            return;
        }

        try (Connection connection = DatabaseConnection.initializeDatabase()) {
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO(connection);
            List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByCourseId(courseId);

            if (enrollments.isEmpty()) {
                out.write("{\"message\": \"No enrollments found for this course\"}");
            } else {
                StringBuilder jsonResponse = new StringBuilder("[");
                for (Enrollment enrollment : enrollments) {
                    jsonResponse.append("{")
                        .append("\"id\": ").append(enrollment.getId()).append(",")
                        .append("\"courseId\": ").append(enrollment.getCourseId()).append(",")
                        .append("\"studentId\": ").append(enrollment.getStudentId())
                        .append("},");
                }
                jsonResponse.setLength(jsonResponse.length() - 1); // Remove trailing comma
                jsonResponse.append("]");
                out.write(jsonResponse.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.write("{\"error\": \"An error occurred while fetching enrollments\"}");
        }
    }
}
