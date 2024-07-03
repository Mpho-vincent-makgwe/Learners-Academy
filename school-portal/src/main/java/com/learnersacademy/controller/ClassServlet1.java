package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.model.Class;

@WebServlet(name = "ClassServlet1", urlPatterns = { "/schoolclasses" })
public class ClassServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnersacademy";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kHing$!x6";

    public ClassServlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Class> classes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM classes");
            while (resultSet.next()) {
                Class classObj = new Class();
                classObj.setId(resultSet.getLong("id"));
                classObj.setName(resultSet.getString("name"));
                classObj.setTeacherId(resultSet.getLong("teacher_id"));
                classes.add(classObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the error
        }

        request.setAttribute("classes", classes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/schoolclasses.jsp");
        dispatcher.forward(request, response);

        // Logging results to console
        System.out.println("Classes retrieved:");
        for (Class classObj : classes) {
            System.out.println(classObj.getId() + " | " + classObj.getName() + " | Teacher ID: " + classObj.getTeacherId());
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
