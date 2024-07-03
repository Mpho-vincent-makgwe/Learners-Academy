<%@ page import="com.learnersacademy.model.Admin" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin List</title>
</head>
<body>
    <h1>Admin List</h1>
    <c:choose>
        <c:when test="${empty admins}">
            <p>No admins found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="admin" items="${admins}">
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
