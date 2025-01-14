// Simulated user data for demo purposes
const userRole = "Admin"; // Can be "student" or "teacher"
const userSpecificData = {
    student: {
        enrolledCourses: ["Math 101", "Science Basics", "History of Art"],
    },
    teacher: {
        createdCourses: ["Advanced Physics", "Introduction to AI"],
    },
};

// Update user role in the header
document.getElementById("user-role").innerText = `Role: ${userRole.charAt(0).toUpperCase() + userRole.slice(1)}`;

// Populate user-specific data
const userDataContainer = document.getElementById("user-specific-data");
if (userRole === "Admin") {
    userDataContainer.innerHTML = `
        <h3>Enrolled Courses</h3>
        <ul>${userSpecificData.student.enrolledCourses.map(course => `<li>${course}</li>`).join('')}</ul>
    `;
} else if (userRole === "teacher") {
    userDataContainer.innerHTML = `
        <h3>Created Courses</h3>
        <ul>${userSpecificData.teacher.createdCourses.map(course => `<li>${course}</li>`).join('')}</ul>
    `;
}
