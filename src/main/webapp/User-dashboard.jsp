
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="CSS/Admin-dashboard.css">
</head>
<body>
    <header class="dashboard-header">
        <h1>Welcome to the LMS Dashboard</h1>
        <p id="user-role">Role: <%= session.getAttribute("userRole") != null ? session.getAttribute("userRole") : "Guest" %></p>
    </header>
    <main class="dashboard-container">
        <section class="quick-links">
            <h2>Quick Links</h2>
            <div class="cards">
                <a href="User-course-management.jsp" class="card" role="button">
                    <h3>Course Management</h3>
                    <p>Manage courses you are enrolled in or created.</p>
                </a>
                <a href="Admin-enrollment-management.jsp" class="card" role="button">
                    <h3>Enrollment Management</h3>
                    <p>View and manage course enrollments.</p>
                </a>
                <a href="Admin-assignment-management.jsp" class="card" role="button">
                    <h3>Assignment Management</h3>
                    <p>View and submit assignments.</p>
                </a>
                <a href="Admin-view-submission.jsp" class="card" role="button">
                    <h3>Submission Management</h3>
                    <p>Track your submissions and feedback.</p>
                </a>
                <a href="attendance-management.jsp" class="card" role="button">
                    <h3>Attendance Management</h3>
                    <p>Check and update attendance records.</p>
                </a>
                <a href="Admin-user-management.jsp" class="card" role="button">
                    <h3>User Management</h3>
                    <p>Create, update, and delete users.</p>
                </a>
            </div>
        </section>
        <section class="user-data">
            <h2>Your Data</h2>
            <div id="user-specific-data">
                <p>Name: <%= session.getAttribute("userName") != null ? session.getAttribute("userName") : "Unknown" %></p>
                <p>Email: <%= session.getAttribute("userEmail") != null ? session.getAttribute("userEmail") : "Unknown" %></p>
            </div>
        </section>
    </main>
    <footer class="dashboard-footer">
        <p>&copy; 2024 LMS. All rights reserved.</p>
        <a href="/logout" class="logout-btn">Logout</a>
    </footer>
    <script src=""></script>
</body>
</html>
