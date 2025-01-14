<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>


<%@ page import="com.user.model.Assignment" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Assignment List</title>
    <link rel="stylesheet" href="path/to/your/styles.css">
</head>
<body>
    <h1>Assignments List</h1>

    <%
        String status = request.getParameter("status");
        if (status != null) {
            if ("success".equals(status)) {
    %>
                <div class="alert alert-success">
                    <strong>Success!</strong> Assignment operation was successful.
                </div>
    <%
            } else if ("failure".equals(status)) {
    %>
                <div class="alert alert-danger">
                    <strong>Error!</strong> There was an issue with the assignment operation.
                </div>
    <%
            }
        }

        List<Assignment> assignments = (List<Assignment>) request.getAttribute("assignments");
        if (assignments != null && !assignments.isEmpty()) {
    %>
            <table border="1">
                <thead>
                    <tr>
                        <th>Assignment ID</th>
                        <th>Course ID</th>
                        <th>Assignment Description</th>
                        <th>Last Date</th>
                    </tr>
                </thead>
                <tbody>
    <%
            for (Assignment assignment : assignments) {
    %>
                <tr>
                    <td><%= assignment.getAssignmentId() %></td>

                    <td><%= assignment.getCourseId() %></td>
                    <td><%= assignment.getAssignment() %></td>
                    <td><%= assignment.getLastDate() %></td>
                </tr>
    <%
            }
    %>
                </tbody>
            </table>
    <%
        } else {
    %>
            <p>No assignments available.</p>
    <%
        }
    %>

    <a href="createAssignment.jsp">Create New Assignment</a>
</body>
</html>
