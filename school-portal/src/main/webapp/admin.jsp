<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <%
        // Check if the session is valid
        if (session == null || session.getAttribute("admin") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>

    <h1>Welcome, Admin</h1>
    <nav>
        <ul>
            <li><a href="admin">Admins</a></li>
            <li><a href="schoolclasses">Classes</a></li>
            <li><a href="students">Students</a></li>
            <li><a href="teachers">Teachers</a></li>
        </ul>
    </nav>

    <!-- Content for the admin page -->
</body>
</html>
