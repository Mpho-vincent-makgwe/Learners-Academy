<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students List</title>
    <!-- Include your CSS files or styles here -->
</head>
<body>
    <h1>Students List</h1>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Class ID</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over students list and display each student -->
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.classId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>
