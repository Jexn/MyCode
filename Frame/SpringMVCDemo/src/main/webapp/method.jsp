<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/10
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求设置</title>
</head>
<body>
    <form method="post" action="test/postRequest">
        <input type="submit" value="Post请求">
    </form>

    <form method="get" action="test/getRequest">
        <span>姓名：</span><input type="text" name="name"><br>
        <span>年龄：</span><input type="text" name="age"><br>
        <input type="submit" value="Get请求">
    </form>
</body>
</html>
