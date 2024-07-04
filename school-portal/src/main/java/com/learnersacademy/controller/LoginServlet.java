package com.learnersacademy.controller;

import com.learnersacademy.util.DBUtil;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        printAllAdmins();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void printAllAdmins() {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM admins");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String adminUsername = resultSet.getString("username");
                String adminEmail = resultSet.getString("email");
                System.out.println("Admin: " + adminUsername + ", Email: " + adminEmail);
            }

        } catch (SQLException e) {
        	System.out.print("Error From LoginServlet: " + e);
            e.printStackTrace();
        }
    }
}
