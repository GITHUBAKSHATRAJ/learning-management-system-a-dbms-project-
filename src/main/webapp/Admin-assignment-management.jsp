<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assignment Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            color: #333;
            margin-bottom: 30px;
        }

        .button {
            display: inline-block;
            padding: 15px 30px;
            margin: 20px;
            font-size: 16px;
            font-weight: bold;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .button:hover {
            background-color: #0056b3;
        }

        .button-container {
            display: flex;
            justify-content: center;
            gap: 20px;
        }
    </style>
</head>
<body>
    <h1>Welcome to Assignment Management</h1>
    <div class="button-container">
        <!-- Button to navigate to Create Assignment page -->
        <button class="button" onclick="window.location.href='Admin-create-assignment.jsp'">
            Create Assignment
        </button>

        <!-- Button to navigate to Show Assignments page -->
        <button class="button" onclick="window.location.href='Admin-show-assignment.jsp'">
            Show Assignments
        </button>
    </div>
</body>
</html>
