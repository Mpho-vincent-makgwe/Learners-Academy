<%@ page import="com.learnersacademy.model.Class" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>School Classes List</title>
</head>
<body>
    <h1>School Classes List</h1>
    <c:choose>
        <c:when test="${empty classes}">
            <p>No school classes found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Teacher</th>
                </tr>
                <c:forEach var="classes" items="${classes}">
                    <tr>
                        <td>${class.id}</td>
                        <td>${class.name}</td>
                        <td>${class.teacher}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>

        