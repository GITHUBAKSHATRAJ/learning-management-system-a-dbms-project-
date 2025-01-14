<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="List of submissions for assignments">
    <title>Submission List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .back-btn {
            display: inline-block;
            margin: 10px 0;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
        .empty-message {
            text-align: center;
            font-size: 16px;
            color: #666;
        }
    </style>
</head>
<body>
    <h1>Submission List</h1>
    <a href="Admin-assignment-management.jsp" class="back-btn">Back to Dashboard</a>

    <%
        // Fetch submissions from the request attribute
        List<com.user.model.Submissions> submissions = (List<com.user.model.Submissions>) request.getAttribute("submissions");

        if (submissions == null || submissions.isEmpty()) {
    %>
        <p class="empty-message">No submissions found</p>
    <%
        } else {
    %>
        <table>
            <thead>
                
                <tr>
                    <th>Submission ID</th>
                    <th>Assignment ID</th>
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>URL</th>
                    <th>Submitted At</th>
                </tr>
            </c:forEach>
            </thead>
            <tbody>
                <!-- <%
                    for (com.user.model.Submissions submission : submissions) {
                %> -->
                <c:forEach var = "user" items="${listuser}">
                <tr>
                    <td><%= submission.getSubmissionId() %></td>
                    <td><%= submission.getAssignmentId() %></td>
                    <td><%= submission.getUserId() %></td>
                    <td><%= submission.getUserName() %></td>
                    <td>
                        <a href="<%= submission.getUrl() %>" target="_blank" title="<%= submission.getUrl() %>">View Submission</a>
                    </td>
                    <td><%= submission.getSubmittedAt() %></td>
                </tr>
            </c:forEach>
                <!-- <%
                    }
                %> -->
            </tbody>
        </table>
    <%
        }
    %>
</body>
</html>
