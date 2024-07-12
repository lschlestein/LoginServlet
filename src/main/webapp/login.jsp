<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 07/07/2024
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Servlet</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required />
    <br/>
    <button type="submit">Login</button>
</form>
<a href="/index">Home</a>
</body>
</html>
