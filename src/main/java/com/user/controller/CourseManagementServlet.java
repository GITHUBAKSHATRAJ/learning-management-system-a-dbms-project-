package com.user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.user.dao.CourseManagementDAO;
import com.user.model.CourseManagement;
import com.user.utility.DBConnection;

@WebServlet("/course")
public class CourseManagementServlet extends HttpServlet {
    private CourseManagementDAO courseManagementDAO;

    @Override
    public void init() throws ServletException {
        Connection connection = DBConnection.getConnection();
        courseManagementDAO = new CourseManagementDAO(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            // Default action: list all courses
            List<CourseManagement> courses = courseManagementDAO.getAllCourses();
            request.setAttribute("courses", courses);
            
            request.getRequestDispatcher("course-list.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            CourseManagement course = courseManagementDAO.getCourseById(courseId);
            request.setAttribute("course", course);
            request.getRequestDispatcher("course-form.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            courseManagementDAO.deleteCourse(courseId);
            response.sendRedirect("course");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            CourseManagement course = new CourseManagement();
            course.setCourseName(request.getParameter("courseName"));
            course.setDescription(request.getParameter("description"));
            course.setCreatedAt(new java.util.Date());
            courseManagementDAO.createCourse(course);

            

            response.sendRedirect("course");
        } else if ("update".equals(action)) {
            CourseManagement course = new CourseManagement();
            course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
            course.setCourseName(request.getParameter("courseName"));
            course.setDescription(request.getParameter("description"));
            course.setCreatedAt(new java.util.Date());
            courseManagementDAO.updateCourse(course);
            response.sendRedirect("course");
        } else if ("delete".equals(action)) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            courseManagementDAO.deleteCourse(courseId); // Pass courseId directly to the deleteCourse method
            response.sendRedirect("course");
        }
    }
}
