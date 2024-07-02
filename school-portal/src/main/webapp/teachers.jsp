<%@ page import="com.learnersacademy.model.Teacher" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher List</title>
</head>
<body>
    <h1>Teacher List</h1>
    <c:choose>
        <c:when test="${empty teachers}">
            <p>No teachers found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Subject</th>
                </tr>
                <c:forEach var="teacher" items="${teachers}">
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.subject}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>

