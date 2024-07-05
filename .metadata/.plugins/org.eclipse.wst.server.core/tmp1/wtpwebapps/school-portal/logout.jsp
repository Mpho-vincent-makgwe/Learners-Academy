<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionToInvalidate = request.getSession(false);
    if (sessionToInvalidate != null) {
        sessionToInvalidate.invalidate();
    }
    response.sendRedirect("login.jsp");
%>
