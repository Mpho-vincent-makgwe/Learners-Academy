package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.dao.ClassDao;
import com.learnersacademy.model.Class;
/**
 * Servlet implementation class ClassServlet1
 */
@WebServlet(name = "ClassServlet", urlPatterns = { "/class" })
public class ClassServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClassDao schoolClassDao = new ClassDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Class> schoolClasses = schoolClassDao.getAllClasses();
        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("schoolclasses.jsp").forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String name = request.getParameter("name");
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademy", "root", "kHing$!x6");
            PreparedStatement ps = con.prepareStatement("INSERT INTO classes (name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        response.sendRedirect("class");
	}

}
