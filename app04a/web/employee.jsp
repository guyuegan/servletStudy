<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/1
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    accept-language: ${header['accept-language']}<br>
    session id: ${pageContext.session.id}<br>
    employee: ${requestScope.employee.name}, ${employee.address.city}<br>
    capital: ${requestScope.capitals['Canada']}
</body>
</html>
