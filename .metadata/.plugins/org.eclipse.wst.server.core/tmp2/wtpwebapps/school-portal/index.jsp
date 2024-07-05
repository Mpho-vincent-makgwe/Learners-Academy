<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Learners Academy</title>
</head>
<body>
    <h1>Welcome to Learners Academy</h1>
    <h2>Hello, <%= session.getAttribute("name") %></h2>
    <nav>
        <ul>
            <li><a href="schoolclasses.jsp">Classes</a></li>
            <li><a href="students.jsp">Students</a></li>
            <li><a href="teachers.jsp">Teachers</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </nav>
    <h1>Admin List</h1>
    <c:choose>
        <c:when test="${empty admins}">
            <p>No admins found.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="admin" items="${admins}">
                    <tr>
                        <td>${admin.id}</td>
                        <td>${admin.username}</td>
                        <td>${admin.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
