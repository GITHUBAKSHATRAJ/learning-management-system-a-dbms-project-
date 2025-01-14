<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.user.model.UserManagement" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <style>
        /* General Reset */
        body, h1, table, th, td {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Body and Container Styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fb;
            padding: 30px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            width: 80%;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
        }

        .header h1 {
            color: #333;
            text-align: center;
            font-size: 2rem;
        }

        /* Table Styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
            font-size: 1.1rem;
        }

        td {
            background-color: #f9f9f9;
        }

        tr:nth-child(even) td {
            background-color: #f1f1f1;
        }

        tr:hover td {
            background-color: #e0f7fa;
        }

        /* No Data Message */
        .no-data {
            text-align: center;
            font-size: 1rem;
            color: #888;
            font-style: italic;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .container {
                width: 100%;
                padding: 15px;
            }

            table {
                font-size: 0.9rem;
            }

            th, td {
                padding: 8px 10px;
            }
        }
    </style>
</head>
<body>

    <div class="container">
        <header class="header">
            <h1>User List</h1>
        </header>

        <div class="user-list">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Profile Details</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Object usersObj = request.getAttribute("users");
                        List<UserManagement> users = null;

                        if (usersObj instanceof List<?>) {
                            users = (List<UserManagement>) usersObj;
                        }

                        if (users != null && !users.isEmpty()) { 
                            for (UserManagement user : users) { 
                    %>
                        <tr>
                            <td><%= user.getId() %></td>
                            <td><%= user.getName() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getProfileDetails() %></td>
                        </tr>
                    <%
                            }
                        } else { 
                    %>
                        <tr>
                            <td colspan="4" class="no-data">No users available</td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
