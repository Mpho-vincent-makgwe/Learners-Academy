package com.learnersacademy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import com.learnersacademy.model.Admin;
import com.learnersacademy.service.AdminService;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminService();

    private static final Logger logger = Logger.getLogger(AdminServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Admin> admins = adminService.getAllAdmins();
            req.setAttribute("admins", admins);
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        } catch (Exception e) {
            logger.severe("Database connection error: " + e.getMessage());
            req.setAttribute("errorMessage", "Database connection error. Please try again later.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Admin admin = new Admin(username, password);
        adminService.addAdmin(admin);
        resp.sendRedirect("admin");
    }
}
