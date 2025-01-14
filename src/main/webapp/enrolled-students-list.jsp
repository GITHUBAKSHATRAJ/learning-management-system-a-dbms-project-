<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enrolled Students</title>
</head>
<body>
    <h1>Enrolled Students</h1>

    <!-- Display error message if exists -->
    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <% 
        }

        // Display success message if exists
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p style="color: green;"><%= message %></p>
    <% 
        }

        // Display list of enrollments if available
        List<Enrollment> enrollments = (List<Enrollment>) request.getAttribute("enrollments");
        if (enrollments != null && !enrollments.isEmpty()) {
    %>
        <table border="1">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Course ID</th>
                </tr>
            </thead>
            <tbody>
                <% for (Enrollment enrollment : enrollments) { %>
                    <tr>
                        <td><%= enrollment.getStudentId() %></td>
                        <td><%= enrollment.getCourseId() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% 
        } else {
    %>
        <p>No enrollments found for this course.</p>
    <% 
        }
    %>
</body>
</html>
