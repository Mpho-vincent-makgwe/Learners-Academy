<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form action="register" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <input type="submit" value="Register">
    </form>
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>