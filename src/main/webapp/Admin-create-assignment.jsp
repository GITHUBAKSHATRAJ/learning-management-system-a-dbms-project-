<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Assignment</title>
    <link rel="stylesheet" href="CSS/Admin-assignment-management.css">
    <style>
        /* Add form-specific styles */
        form {
            margin: 20px 0;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input, textarea, button {
            padding: 10px;
            margin-bottom: 10px;
            width: 100%;
            max-width: 400px;
        }
        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Create Assignment</h1>

    <!-- Success or Error Messages -->
    <div>
        <% 
            String message = (String) request.getAttribute("message");
            if (message != null) { 
        %>
        <p class="message"><%= message %></p>
        <% 
            } 
        %>
    </div>

    <form action="createAssignment" method="post">
        <label for="courseId">Course ID:</label>
        <input type="number" id="courseId" name="courseId" required>
        
        <label for="assignment">Assignment:</label>
        <textarea id="assignment" name="assignment" required></textarea>
        
        <label for="lastDate">Last Date:</label>
        <input type="date" id="lastDate" name="lastDate" required>
        
        <button type="submit">Create Assignment</button>
    </form>
</body>
</html>
