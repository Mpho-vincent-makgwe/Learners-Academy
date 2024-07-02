<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
</head>
<body>
    <h1>Classes</h1>
    <form action="classes" method="post">
        Name: <input type="text" name="name" required>
        <input type="submit" value="Add Class">
    </form>
    <h2>List of Classes</h2>
    <ul>
        <c:forEach var="clazz" items="${listClasses}">
            <li>${clazz.name}</li>
        </c:forEach>
    </ul>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
