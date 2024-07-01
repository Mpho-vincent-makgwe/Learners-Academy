package com.learnersacademy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.learnersacademy.model.Teacher;
import com.learnersacademy.service.TeacherService;

@WebServlet("/teachers")
public class TeacherServlet extends HttpServlet {
    private TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = teacherService.getAllTeachers();
        req.setAttribute("teachers", teachers);
        req.getRequestDispatcher("teachers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Teacher teacher = new Teacher(name, email);
        teacherService.addTeacher(teacher);
        resp.sendRedirect("teachers");
    }
}
