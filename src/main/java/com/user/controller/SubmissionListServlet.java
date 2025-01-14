package com.user.controller;

import java.io.IOException;
import java.sql.Connection;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.SubmissionsDAO;
import com.user.model.Submissions;

@WebServlet("/ViewSubmissionServlet")
public class SubmissionListServlet extends HttpServlet {
    private SubmissionsDAO submissionsDAO;

    @Override
    public void init() throws ServletException {
        try {
            // Establish database connection using utility class
            Connection connection = com.user.utility.DBConnection.getConnection();
            submissionsDAO = new SubmissionsDAO(connection);
        } catch (Exception e) {
            throw new ServletException("Failed to initialize DAO", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Fetch all submissions
            List<Submissions> submissions = submissionsDAO.getAllSubmissions();

            // Set submissions as a request attribute
            request.setAttribute("submissions", submissions);

            // Forward request to JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin-submissions-list.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Failed to fetch submissions", e);
        }
    }
}
