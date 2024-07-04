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

import com.learnersacademy.model.Teacher;
import com.learnersacademy.util.DBUtil;

@WebServlet(name = "TeacherServlet1", urlPatterns = { "/teachers" })
public class TeacherServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TeacherServlet1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teacher> teachers = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM teachers");
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("teachers", teachers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
