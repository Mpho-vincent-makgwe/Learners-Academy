<%@ page import="com.learnersacademy.model.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
<% Boolean loading = (Boolean) request.getAttribute("loading"); %>

<% if (loading != null && loading) { %>
    <p>Loading students, please wait...</p>
<% } else { %>
    <% List<Student> students = (List<Student>) request.getAttribute("students"); %>
    <% if (students != null && !students.isEmpty()) { %>
        <table>
            <!-- Your table headers and rows here -->
        </table>
    <% } else { %>
        <p>No students found.</p>
    <% } %>
<% } %>

</body>
</html>
