<%--
  Created by IntelliJ IDEA.
  User: George Alan
  Date: 12/01/2020
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html lang="pt-br">
<head>
    <title>Resposta melhores produtos</title>
</head>
<body>
    <h1>Os melhores produtos do tipo # ${param.produto} # são:</h1>

    <ul>
        <c:forEach var="item" items="${produtos}">
        <li>${item}</li>
        </c:forEach>
    </ul>
</body>
</html>
