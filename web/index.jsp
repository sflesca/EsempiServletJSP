<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: sfles
  Date: 18/03/2020
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*" %>
<jsp:useBean id="testi" class="psw.beans.TestiWeb" scope="request">
  <jsp:setProperty name="testi" property="*"/>
</jsp:useBean>
<html>
  <head>
    <title><jsp:getProperty name="testi" property="title"/></title>
  </head>
  <%! private int cont1 = 0; %>
  <body>
  <jsp:include page="testata.jsp" />

  Il mio messaggio è: <jsp:getProperty name="testi" property="message"/><br/>



  Ciao a tutti, la somma di 2 + 3 è <%= 2+3%><br/>
  <%
    int cont = 0;
    cont++;
    cont1++;
  %>

  Stampa cont: <%=cont%><br>
  Stampa cont1: <%=cont1%><br>
  <ul>
    <% for(int i =0; i< 10; i++) { %>
      <li>
        <%= i %>
      </li>
    <% } %>
  </ul>

  </body>
</html>
