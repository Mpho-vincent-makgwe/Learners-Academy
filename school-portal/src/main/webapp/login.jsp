<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Learners Academy</title>
</head>
<body>
    <h1>Login</h1>
    <%-- Display registration confirmation --%>
    <% if (request.getAttribute("registeredUsername") != null) { %>
        <p>Registration Successful!</p>
        <p>Username: ${registeredUsername}</p>
        <p>Email: ${registeredEmail}</p>
    <% } %>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Login</button>
    </form>
    <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
</body>
</html>
