<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Assignment Submissions</title>
    <style>
        /* Your existing CSS styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px 15px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        td a {
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }
        td a:hover {
            text-decoration: underline;
        }
        .container {
            text-align: center;
            margin-top: 20px;
        }
        .filter-form {
            width: 80%;
            margin: 0 auto;
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .filter-form input[type="text"], .filter-form input[type="number"], .filter-form button {
            padding: 10px;
            margin: 5px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .filter-form button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            border: none;
        }
        .filter-form button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Assignment Submissions</h1>

    <div class="container">
        <form class="filter-form" method="post" action="ViewSubmissionServlet">
            <label for="course_id">Course ID:</label>
            <input type="number" id="course_id" name="course_id" required>
            <label for="assignment_id">Assignment ID:</label>
            <input type="number" id="assignment_id" name="assignment_id" required>
            <button type="submit">Filter Submissions</button>
        </form>
    </div>

    <table>
        <thead>
            <tr>
                <th><c:out value="User ID" /></th>
                <th><c:out value="Assignment ID" /></th>
                <th><c:out value="Course ID" /></th>
                <th><c:out value="Assignment" /></th>
                <th><c:out value="Assignment Link" /></th>
                <th><c:out value="Created Date" /></th>
                <th><c:out value="Last Date" /></th>
                <th><c:out value="Submitted Date" /></th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${empty submissions}">
                <tr>
                    <td colspan="8">No submissions found.</td>
                </tr>
            </c:if>
            <c:forEach var="submission" items="${submissions}">
                <tr>
                    <td><c:out value="${submission.userId}" /></td>
                    <td><c:out value="${submission.assignmentId}" /></td>
                    <td><c:out value="${submission.courseId}" /></td>
                    <td><c:out value="${submission.assignment}" /></td>
                    <td><a href="${submission.assignmentLink}" target="_blank">View</a></td>
                    <td><c:out value="${submission.createdDate}" /></td>
                    <td><c:out value="${submission.lastDate}" /></td>
                    <td><c:out value="${submission.submittedDate}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
