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
            <script>
                console.log("Teachers retrieved:");
                <c:forEach var="teacher" items="${requestScope.teachers}">
                    console.log("ID: ${teacher.id}, Name: ${teacher.name}");
                </c:forEach>
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>
