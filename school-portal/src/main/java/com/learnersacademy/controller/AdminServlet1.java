package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.model.Admin;

@WebServlet(name = "AdminServlet1", urlPatterns = { "/index" })
public class AdminServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnersacademy";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kHing$!x6";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> admins = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM admins";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setId(resultSet.getInt("id"));
                    admin.setUsername(resultSet.getString("username"));
                    admin.setEmail(resultSet.getString("email"));
                    admins.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("admins", admins);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
