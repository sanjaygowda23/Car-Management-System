<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sanjay.project.User" %> <!-- Import statement for User class -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    <%
        User user = (User) session.getAttribute("user");
        if (user != null) {
    %>
        <p>User-name: <%= user.getUsername() %></p>
        <p>Email: <%= user.getEmail() %></p>
        <p>Name: <%= user.getName() %></p>
    <% } else { %>
        <p>You need to <a href="login.jsp">login</a>.</p>
    <% } %>
</body>
</html>
