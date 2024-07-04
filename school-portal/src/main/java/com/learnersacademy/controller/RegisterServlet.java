package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learnersacademy.util.DBUtil;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admins (username, email, password) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("errorMessage", "Registration failed, please try again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
