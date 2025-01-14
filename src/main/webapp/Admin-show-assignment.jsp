<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.user.model.Assignment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Assignments</title>
    <style>
        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }

        /* Button styling */
        .button {
            display: inline-block;
            padding: 8px 12px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
        }
        .button:hover {
            background-color: #0056b3;
        }

        /* Message styling */
        .message {
            color: red;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>All Assignments</h1>

    <!-- Display Message -->
    <% String message = (String) request.getAttribute("message"); %>
    <% if (message != null) { %>
        <p class="message"><%= message %></p>
    <% } %>

    <!-- Assignments Table -->
    <table>
        <thead>
            <tr>
                <th>Assignment ID</th>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Assignment</th>
                <th>Created Date</th>
                <th>Last Date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
              
                List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments");

                
                if (assignments == null || assignments.isEmpty()) { 
            %>
            <tr>
                <td colspan="7">No assignments found.</td>
            </tr>
            <% } else { 
              
                for (Assignment assignment : assignments) { 
            %>
            <tr>
                <td><%= assignment.getAssignmentId() %></td>
                <td><%= assignment.getCourseId() %></td>
                <td><%= assignment.getCourseName() %></td>
                <td><%= assignment.getAssignment() %></td>
                <td><%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(assignment.getCreatedDate()) %></td>
                <td><%= new java.text.SimpleDateFormat("dd-MM-yyyy").format(assignment.getLastDate()) %></td>
                <td>
                    <a href="viewAssignments?id=<%= assignment.getAssignmentId() %>" class="button">View Assignment</a>
                </td>
            </tr>
            <% 
                } 
            } 
            %>
        </tbody>
    </table>
</body>
</html>
