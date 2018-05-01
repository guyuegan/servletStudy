<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <b>Http headers:</b></br>
    <%
        for(Enumeration<String> e = request.getHeaderNames();
            e.hasMoreElements();){
            String headerName = e.nextElement();
            out.println(headerName+": "+request.getHeader(headerName)+"</br>");
        }
    %>
    <hr/>
    <%
        out.println("jsp real path: "+request.getSession().getServletContext().getRealPath("implicitObjects.jsp"));
        out.println("<br/>buffer size: "+response.getBufferSize());
        out.println("<br/>session id: "+session.getId());
        out.println("<br/>servlet name: "+config.getServletName());
        out.println("<br/>server info: "+application.getServerInfo());
    %>
</body>
</html>
