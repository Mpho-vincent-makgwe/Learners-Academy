package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.TeacherDao;
import com.learnersacademy.model.Teacher;

/**
 * Servlet implementation class TeacherServlet1
 */

@WebServlet(name = "TeacherServlet", urlPatterns = { "/teacher" })
public class TeacherServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private TeacherDao teacherDao = new TeacherDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 List<Teacher> teachers = teacherDao.getAllTeachers();
	        request.setAttribute("teachers", teachers);
	        request.getRequestDispatcher("teachers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        Teacher teacher = new Teacher(name, email);
        teacherDao.saveTeacher(teacher);
        response.sendRedirect("teacher");
	}

}
