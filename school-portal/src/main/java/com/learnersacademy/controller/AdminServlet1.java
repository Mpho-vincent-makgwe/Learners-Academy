package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.AdminDao;
import com.learnersacademy.model.Admin;

/**
 * Servlet implementation class AdminServlet1
 */
@WebServlet(name = "AdminServlet", urlPatterns = { "/admin" })
public class AdminServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao;
	
    public void init() throws ServletException {
        adminDao = new AdminDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Admin> admins = adminDao.getAllAdmins();
        request.setAttribute("admins", admins);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin(username, password);
        adminDao.saveAdmin(admin);
        response.sendRedirect("admin");
    }

}
