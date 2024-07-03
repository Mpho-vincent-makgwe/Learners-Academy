package com.learnersacademy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.model.Admin;
/**
 * Servlet implementation class AdminServlet1
 */
@WebServlet(name = "AdminServlet1", urlPatterns = { "/admin" })
public class AdminServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnersacademy";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "kHing$!x6";   
	
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Admin> admins = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM admins");
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setUsername(resultSet.getString("name"));
                admin.setEmail(resultSet.getString("email"));
                admins.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the error
        }

        request.setAttribute("admins", admins);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);

        // Logging results to console
        System.out.println("Admins retrieved:");
        for (Admin admin : admins) {
            System.out.println(admin.getId() + " | " + admin.getUsername() + " | " + admin.getEmail());
        }
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
