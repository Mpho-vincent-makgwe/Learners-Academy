<%@ page import="com.learnersacademy.model.Teacher" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teachers</title>
</head>
<body>
    <h1>Teachers</h1>
    <ul>
        <c:forEach var="teacher" items="${teachers}">
            <li>${teacher.name} (${teacher.email})</li>
        </c:forEach>
    </ul>
    <form action="teacher" method="post">
        <input type="text" name="name" placeholder="Teacher Name" required>
        <input type="email" name="email" placeholder="Teacher Email" required>
        <button type="submit">Add Teacher</button>
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
