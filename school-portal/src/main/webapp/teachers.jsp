<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.learnersacademy.model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher List</title>
</head>
<body>
    <h1>Teacher List</h1>
    <c:choose>
        <c:when test="${empty requestScope.teachers}">
            <p>No teachers found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                <c:forEach var="teacher" items="${requestScope.teachers}">
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
