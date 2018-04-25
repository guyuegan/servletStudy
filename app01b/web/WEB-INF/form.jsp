<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/22 0022
  Time: 上午 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String APP_PATH = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath();

    request.setAttribute("APP_PATH", APP_PATH);
%>
<html>
<head>
    <title>form</title>
</head>
<body>
<%--<form action="<%=APP_PATH%>/form" method="post">--%>
<%=APP_PATH%>
${APP_PATH}
<form action="${APP_PATH}/form" method="post">
    username: <input type="text" name="username"/><br>
    password: <input type="password" name="password"/><br>
    instructions: <br><textarea name="instructions" cols="30" rows="10"></textarea><br>
                      <textarea name="instructions" cols="30" rows="10"></textarea><br>
    hobbies: <input type="checkBox" name="bobbies" value="basketball"/>篮球
             <input type="checkBox" name="bobbies" value="football"/>足球
             <input type="checkBox" name="bobbies" value="table tennies"/>台球<br>

    <input type="submit" value="提交">
</form>
</body>
</html>
