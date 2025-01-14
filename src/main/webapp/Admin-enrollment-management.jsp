<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %> <!-- Add this import statement -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Enrollment by Course ID</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        input[type="text"], input[type="submit"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            cursor: pointer;
            border: none;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            text-align: center;
        }
        .enrollment-box {
            margin-top: 20px;
            max-height: 300px;
            overflow-y: auto;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 10px;
            background-color: #f9f9f9;
        }
        .student {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .student:last-child {
            border-bottom: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>View Enrollment by Course ID</h1>
        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) { 
        %>
            <p class="error"><%= error %></p>
        <% 
            } 
        %>
        <form action="viewEnrollmentsByCourseId" method="get">
            <label for="courseId">Enter Course ID:</label>
            <input type="text" id="courseId" name="courseId" placeholder="Enter Course ID" required>
            <input type="submit" value="View Enrollments">
        </form>

        <% 
            // Example list of enrolled students for display
            List<String> students = (List<String>) request.getAttribute("students");
            if (students != null && !students.isEmpty()) { 
        %>
            <div class="enrollment-box">
                <% for (String student : students) { %>
                    <div class="student">
                        <%= student %>
                    </div>
                <% } %>
            </div>
        <% 
            } else if (request.getAttribute("students") != null) { 
        %>
            <p>No students enrolled in this course.</p>
        <% 
            } 
        %>
    </div>
</body>
</html>
