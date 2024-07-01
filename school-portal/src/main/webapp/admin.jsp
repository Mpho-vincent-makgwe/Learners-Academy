<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h2>Admin</h2>
    <form action="admin" method="post">
        Username: <input type="text" name="username" required>
        Password: <input type="password" name="password" required>
        <input type="submit" value="Add Admin">
    </form>
    <h3>Admin List</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
        </tr>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td>${admin.id}</td>
                <td>${admin.username}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
