<%@ page import="com.learnersacademy.model.Class" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>School Classes List</title>
</head>
<body>
    <h1>School Classes List</h1>
    <c:choose>
        <c:when test="${empty schoolClasses}">
            <p>No school classes found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Teacher</th>
                </tr>
                <c:forEach var="schoolClass" items="${schoolClasses}">
                    <tr>
                        <td>${schoolClass.id}</td>
                        <td>${schoolClass.name}</td>
                        <td>${schoolClass.teacher}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>

        