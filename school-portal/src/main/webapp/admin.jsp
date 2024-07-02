<%@ page import="com.learnersacademy.model.Admin" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admins</title>
</head>
<body>
    <h1>Admins</h1>
    <ul>
        <c:forEach var="admin" items="${admins}">
            <li>${admin.username}</li>
        </c:forEach>
    </ul>
    <form action="admin" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Add Admin</button>
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
