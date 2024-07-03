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

import com.learnersacademy.model.Student;

@WebServlet(name = "StudentServlet1", urlPatterns = { "/students" })
public class StudentServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnersacademy";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kHing$!x6";

    public StudentServlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            // Process ResultSet
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setClassId(resultSet.getInt("class_id"));
                students.add(student);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        } finally {
            // Close resources in reverse order
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Print students to console using overridden toString() method
        System.out.println("Students retrieved:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Proceed with servlet logic (forwarding to JSP, etc.)
        // request.setAttribute("students", students);
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
        // dispatcher.forward(request, response);
        
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
