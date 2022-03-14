<%--
  Created by IntelliJ IDEA.
  User: sfles
  Date: 19/03/2020
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="psw.model.*" %>
<jsp:useBean id="clienti" scope="request" class="java.util.LinkedList<Cliente>" />
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="miostile.css">
</head>
<body>
<h1>I clienti ne db sono i seguenti</h1>
<table border="1">
    <tr>
        <th>id</th>
        <th>nome</th>
    </tr>
 <% for(Cliente c:clienti)   { %>
    <tr>
        <td><%=c.getId()%></td>
        <td><%=c.getNome()%></td>
    </tr>
    <% }%>
</table>
</body>
</html>
