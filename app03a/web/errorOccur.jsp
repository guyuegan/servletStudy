<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorHandle.jsp" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
deliberately throw an exception
<%
    Integer.parseInt("Throw me");
%>
</body>
</html>
