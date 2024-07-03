package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TeacherS
 */
@WebServlet(name = "TeacherS", urlPatterns = { "/teachers" })
public class TeacherS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger logger = Logger.getLogger(ClassS.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		logger.info("Accessing Class servlet");
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");

	        // Example: Save to database or perform business logic
	        // Example: TeacherDAO.addTeacher(name, email);

	        // After processing, redirect back to teachers.jsp
	        response.sendRedirect(request.getContextPath() + "/teachers.jsp");
	}

}
