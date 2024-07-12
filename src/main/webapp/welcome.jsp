<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 07/07/2024
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<header>
    <c:choose>
        <c:when test="${not empty user}">
            <p>Usuário autenticado: ${user.name}</p>
            <a href="logout">Logout</a>
        </c:when>
        <c:otherwise>
            <p>Usuário não autenticado</p>
            <a href="login">Login</a>
        </c:otherwise>
    </c:choose>
</header>
<h1>Welcome ${user.name} your email is ${user.email}</h1>
<a href="/listAllUsers">See all Users</a>
</body>
</html>
