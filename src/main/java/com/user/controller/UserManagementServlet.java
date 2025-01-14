package com.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserManagementDAO;
import com.user.model.UserManagement;

@WebServlet("/userManagement")
public class UserManagementServlet extends HttpServlet {

    private UserManagementDAO userManagementDAO;

    @Override
    public void init() {
        userManagementDAO = new UserManagementDAO();
    }

    // Handle GET requests for user management
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<UserManagement> users = userManagementDAO.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("user-list.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            UserManagement user = userManagementDAO.getUserById(userId);
            request.setAttribute("user", user);
            request.getRequestDispatcher("update-user.jsp").forward(request, response);
        } else {
            response.sendRedirect("user-management.jsp");
        }
    }

    // Handle POST requests for adding, updating, or deleting users
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            UserManagement user = new UserManagement();
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setProfileDetails(request.getParameter("profileDetails"));
            userManagementDAO.addUser(user);
        } else if ("update".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            UserManagement user = new UserManagement();
            user.setId(userId);
            user.setName(request.getParameter("name"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setProfileDetails(request.getParameter("profileDetails"));
            userManagementDAO.updateUser(user);
        } else if ("delete".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("id"));
            userManagementDAO.deleteUser(userId);
        }

        // After the action is performed, redirect to the list of users
        response.sendRedirect("userManagement?action=list");
    }
}
