<%--
  Created by IntelliJ IDEA.
  User: sfles
  Date: 14/03/2022
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title></title>
</head>
<body>
<h1>Form di registrazione</h1>
<jsp:useBean id="campi" class="psw.beans.RegisterBean" scope="request">
    <jsp:setProperty name="campi" property="*" />
</jsp:useBean>
<form name="register" action="register.jsp" method="GET">
    <table width="100%" border="1">
        <tbody>
        <tr>
            <td>userid</td>
            <td><input name="myid" size="10" maxlength="20" type="text" value="<%=(campi.getMyid()!=null)?campi.getMyid():""%>"><br>
            </td>
        </tr>
        <tr>
            <td>cognome</td>
            <td><input name="cognome" size="15" maxlength="30" type="text" value="<%=(campi.getCognome()!=null)?campi.getCognome():""%>"><br>
            </td>
        </tr>
        <tr>
            <td>nome</td>
            <td><input name="nome"  size="15" maxlength="30" type="text" value="<%=(campi.getNome()!=null)?campi.getNome():""%>"><br>
            </td>
        </tr>
        <tr>
            <td>enail</td>
            <td><input name="email" size="20" maxlength="40" type="text" value="<%=(campi.getEmail()!=null)?campi.getEmail():""%>"><br>
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td><input name="passwd" size="10" maxlength="20" type="password"><br>
            </td>
        </tr>
        <tr>
            <td style="width: 158.483px;">conferma password</td>
            <td style="width: 364.517px;"><input name="confpswd" size="10" maxlength="20"
                                                 type="password"><br>
            </td>
        </tr>
        </tbody>
    </table>
    <input type="submit"/>
</form>
</body>
</html>
