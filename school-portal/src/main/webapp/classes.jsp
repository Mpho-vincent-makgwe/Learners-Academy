<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
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
        <c:forEach var="class" items="${classes}">
            <tr>
                <td>${class.id}</td>
                <td>${class.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
