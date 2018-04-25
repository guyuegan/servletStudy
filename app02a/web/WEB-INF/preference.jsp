<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25 0025
  Time: 上午 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>preference</title>
    <meta charset="utf-8"/>
</head>
<body>
<a href="cookieClass">cookieClass</a>&nbsp;&nbsp;
<a href="cookieInfo">cookieInfo</a>&nbsp;&nbsp;
<a href="preference">preference</a>&nbsp;&nbsp;
<p>选择下面的值:</p>
<form method="post">
    <table>
        <tr>
            <td>标题大小</td>
            <td>
                <select name="titleFontSize">
                    <option value="large">large</option>
                    <option value="x-large">x-large</option>
                    <option value="xx-large">xx-large</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>标题样式和粗细</td>
            <td>
                <select name="titleStyleAndWeight" multiple>
                    <option value="italic">italic</option>
                    <option value="bold">bold</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>表中最大记录</td>
            <td>
                <select name="maxRecords">
                    <option value="5">5</option>
                    <option value="10">10</option>
                </select>
            </td>
        </tr>
        <tr><td><input type="submit" value="set"/></td></tr>
    </table>
</form>
</body>
</html>


