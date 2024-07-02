package com.learnersacademy.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.learnersacademy.model.Class;
import com.learnersacademy.service.ClassService;

@WebServlet("/classes")
public class ClassServlet extends HttpServlet {
    private ClassService classService = new ClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Class> classes = classService.getAllClasses();
        req.setAttribute("classes", classes);
        req.getRequestDispatcher("classes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Class classObj = new Class(name);
        classService.addClass(classObj);
        resp.sendRedirect("classes");
    }
}