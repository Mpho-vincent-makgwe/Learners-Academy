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

@WebServlet("/class")
public class ClassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Classes</h1>");
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LearnersAcademy", "root", "kHing$!x6");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM classes");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                out.println("<p>" + rs.getString("name") + "</p>");
            }
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error retrieving classes</p>");
        }
        
        out.println("</body></html>");
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
