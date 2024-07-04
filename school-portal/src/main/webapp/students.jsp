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
    <c:choose>
        <c:when test="${empty requestScope.students}">
            <p>No students found.</p>
            <script>
                console.log("No students found.");
            </script>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Class ID</th>
                </tr>
                <c:forEach var="student" items="${requestScope.students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.classId}</td>
                    </tr>
                </c:forEach>
            </table>
            <script>
                console.log("Students retrieved:");
                <c:forEach var="student" items="${requestScope.students}">
                    console.log("ID: ${student.id}, Name: ${student.name}, Class ID: ${student.classId}");
                </c:forEach>
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>
