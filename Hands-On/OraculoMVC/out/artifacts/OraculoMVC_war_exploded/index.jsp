<%--
  Created by IntelliJ IDEA.
  User: George Alan
  Date: 12/01/2020
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
  <head>
    <title>Oraculo Mineiro</title>
  </head>
  <body>
    <h1>Que tipo de produto você quer saber os melhores?</h1>
    <form action="oraculoController">
      <select name="produto">
        <option value="doce de leite">Doce de leite</option>
        <option value="queijo mineiro">Queijo mineiro</option>
      </select>
      <input type="submit" value="Perguntar" />
    </form>
  </body>
</html>
