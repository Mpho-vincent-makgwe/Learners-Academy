<!-- teachers.jsp -->

<%@ page import="java.util.List" %>
<%@ page import="com.learnersacademy.model.Teacher" %>

<html>
<head>
    <title>Teacher List</title>
</head>
<body>
    <h1>Teacher List</h1>
    
    <c:choose>
        <c:when test="${empty teachers}">
            <p>No teachers found.</p>
        </c:when>
        <c:otherwise>
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
        </c:otherwise>
    </c:choose>

    <form action="TeacherS" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <input type="submit" value="Add Teacher">
    </form>
</body>
</html>
