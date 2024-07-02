<%@ page import="com.learnersacademy.model.Class" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Classes</title>
</head>
<body>
    <h1>Classes</h1>
    <ul>
        <c:forEach var="clazz" items="${classes}">
            <li>${clazz.name}</li>
        </c:forEach>
    </ul>
    <form action="class" method="post">
        <input type="text" name="name" placeholder="Class Name" required>
        <button type="submit">Add Class</button>
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
        