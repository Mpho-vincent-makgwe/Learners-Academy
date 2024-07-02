package com.learnersacademy.servlets;

import com.learnersacademy.dao.StudentDao;
import com.learnersacademy.model.Student;
import com.learnersacademy.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
	private StudentDao studentDao = new StudentDao();
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<com.learnersacademy.entities.Student> students = studentDao.getAllStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        Student student = new Student(name, email);
        studentService.addStudent(student);

        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
