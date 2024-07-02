package com.learnersacademy.servlets;

import com.learnersacademy.dao.TeacherDao;
import com.learnersacademy.model.Teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherDao teacherDao = new TeacherDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("teachers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Teacher teacher = new Teacher(name, email);
        teacherDao.saveTeacher(teacher);
        response.sendRedirect("teacher");
    }
}
