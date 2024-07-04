package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
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
import com.learnersacademy.util.DBUtil;

@WebServlet(name = "StudentServlet1", urlPatterns = { "/students" })
public class StudentServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StudentServlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setClassId(resultSet.getLong("class_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
