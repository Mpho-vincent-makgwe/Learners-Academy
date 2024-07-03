package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ClassS
 */
@WebServlet(name = "ClassS", urlPatterns = { "/classes" })
public class ClassS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger logger = Logger.getLogger(ClassS.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Accessing Class servlet");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");

        // Example: Save to database or perform business logic
        // Example: ClassDAO.addClass(name, teacher);

        // After processing, redirect back to schoolclasses.jsp
        response.sendRedirect(request.getContextPath() + "/classes.jsp");
	}

}
