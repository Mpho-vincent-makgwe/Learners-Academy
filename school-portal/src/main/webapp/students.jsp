<%@ page import="com.learnersacademy.model.Student" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <h1>Students</h1>
    <ul>
        <c:forEach var="student" items="${students}">
            <li>${student.name} (${student.email})</li>
        </c:forEach>
    </ul>
    <form action="student" method="post">
        <input type="text" name="name" placeholder="Student Name" required>
        <input type="email" name="email" placeholder="Student Email" required>
        <button type="submit">Add Student</button>
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
