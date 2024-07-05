package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.util.DBUtil;
import com.learnersacademy.util.PasswordUtil;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Connection connection = DBUtil.getConnection();
            
            // Prepare statement
            String sql = "SELECT password FROM admins WHERE username=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                
                // Execute query
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String storedHash = resultSet.getString("password");
                    if (PasswordUtil.verifyPassword(password, storedHash)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username); // Set username in session
                        response.sendRedirect("index.jsp");
                    } else {
                        handleError(request, response, "Invalid username or password");
                    }
                } else {
                    handleError(request, response, "Invalid username or password");
                }
            }
        } catch (SQLException e) {
            log("Database error during login: " + e.getMessage(), e);
            handleError(request, response, "Database error: " + e.getMessage());
        }
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
