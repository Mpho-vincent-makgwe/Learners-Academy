<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
</head>
<body>
    <h2>Classes</h2>
    <form action="classes" method="post">
        Name: <input type="text" name="name" required>
        <input type="submit" value="Add Class">
    </form>
    <h3>Class List</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="classObj" items="${classes}">
            <tr>
                <td>${classObj.id}</td>
                <td>${classObj.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
