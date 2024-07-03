package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.StudentDao;
import com.learnersacademy.model.Student;

/**
 * Servlet implementation class StudentServlet1
 */

@WebServlet(name = "StudentServlet", urlPatterns = { "/student" })
public class StudentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDao studentDao = new StudentDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> students = studentDao.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("students.jsp").forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        Student student = new Student(name, email);
	        studentDao.saveStudent(student);
	        response.sendRedirect("student");
	    }

}
