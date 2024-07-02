package com.learnersacademy.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.learnersacademy.dao.ClassDao;
import com.learnersacademy.model.Class;

@WebServlet("/class")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClassDao schoolClassDao = new ClassDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Class> schoolClasses = schoolClassDao.getAllClasses();
        request.setAttribute("schoolClasses", schoolClasses);
        request.getRequestDispatcher("schoolclasses.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
