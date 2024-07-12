<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 11/07/2024
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>All Users In Database</title>
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
<h2>Users in Database</h2>
<ul>
    <c:if test="${not empty user}">
        <c:forEach items="${users}" var="user">
            <li>${user}</li>
        </c:forEach>
    </c:if>
</ul>
<a href="index.jsp">Home</a>
</body>
</html>
