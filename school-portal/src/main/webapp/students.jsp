<%@ page import="com.learnersacademy.model.Student" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <c:choose>
        <c:when test="${empty students}">
            <p>No students found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Class ID</th>
                </tr>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.classId}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
