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
        <c:when test="${not empty client}">
            <p>Current Client: ${client.name}</p>
            <a href="logout">Logout</a>
        </c:when>
        <c:otherwise>
            <p>Client not logged:</p>
            <a href="login">Login</a>
        </c:otherwise>
    </c:choose>
</header>
<h1>Welcome ${client.name} your email is ${client.email}</h1>
<a href="/listAllClients">See all Clients</a>
</body>
</html>
