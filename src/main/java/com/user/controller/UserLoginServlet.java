// Servlet Package
package com.user.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDAO;

import com.user.utility.DBConnection;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection = DBConnection.getConnection();
        UserDAO UserDAO = new UserDAO(connection);

        boolean isValid = UserDAO.validateUser(email, password);

        if (isValid) {
            response.sendRedirect("User-dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }
}
