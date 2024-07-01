package com.learnersacademy.controller;

import com.learnersacademy.model.Class;
import com.learnersacademy.service.ClassService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
