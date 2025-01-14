// Servlet Package
package com.user.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.AdminDAO;

import com.user.utility.DBConnection;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection = DBConnection.getConnection();
        AdminDAO adminDAO = new AdminDAO(connection);

        boolean isValid = adminDAO.validateAdmin(email, password);

        if (isValid) {
            response.sendRedirect("Admin-dashboard.jsp");
        } else {
            request.setAttribute("error", "Wrong email or password, please try again.");
            response.sendRedirect("Admin-login.jsp");
        }
    }
}
