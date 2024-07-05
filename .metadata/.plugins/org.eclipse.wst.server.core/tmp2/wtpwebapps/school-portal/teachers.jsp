<%@ page import="com.learnersacademy.model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher List</title>
</head>
<body>
    <h1>Teacher List</h1>
<% Boolean loading = (Boolean) request.getAttribute("loading"); %>

<% if (loading != null && loading) { %>
    <p>Loading teachers, please wait...</p>
<% } else { %>
    <% List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers"); %>
    <% if (teachers != null && !teachers.isEmpty()) { %>
        <table>
            <!-- Your table headers and rows here -->
        </table>
    <% } else { %>
        <p>No teachers found.</p>
    <% } %>
<% } %>

</body>
</html>
