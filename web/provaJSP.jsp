<%--
  Created by IntelliJ IDEA.
  User: sfles
  Date: 09/03/2021
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/plain;charset=UTF-8" language="java" %>
<html><head>
    <title>Title</title>
</head>
<body>
<h1>Ciao a tutti<%= new java.util.Date()%></h1>
<% for(int i=0; i<10;i++) { %>

la richiesta proviene da: <%= request.getRemoteHost()%><br>

<% } %>
</body>
</html>
