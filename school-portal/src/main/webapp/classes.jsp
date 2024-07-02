<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Classes</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="class" items="${classes}">
        <tr>
            <td>${cls.id}</td>
            <td>${cls.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
