<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teachers</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Teachers</h2>
    <form action="teachers" method="post">
        Name: <input type="text" name="name" required>
        Email: <input type="email" name="email" required>
        <input type="submit" value="Add Teacher">
    </form>
    <h3>Teacher List</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <c:forEach var="teacher" items="${teachers}">
            <tr>
                <td>${teacher.id}</td>
                <td>${teacher.name}</td>
                <td>${teacher.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
