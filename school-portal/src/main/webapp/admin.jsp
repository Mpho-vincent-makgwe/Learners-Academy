<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.learnersacademy.model.Admin" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin List</title>
</head>
<body>
    <h1>Admin List</h1>
    <c:choose>
        <c:when test="${empty requestScope.admins}">
            <p>No admins found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="admin" items="${requestScope.admins}">
                    <tr>
                        <td>${admin.id}</td>
                        <td>${admin.username}</td>
                        <td>${admin.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
