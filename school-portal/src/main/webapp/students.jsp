<!-- students.jsp -->

<%@ page import="java.util.List" %>
<%@ page import="com.learnersacademy.model.Student" %>

<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    
    <c:choose>
        <c:when test="${empty students}">
            <p>No students found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <form action="StudentS" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <input type="submit" value="Add Student">
    </form>
</body>
</html>
