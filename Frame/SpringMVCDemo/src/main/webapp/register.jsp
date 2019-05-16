<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/10
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="user/register">
    <span>姓名：</span><input type="text" name="username"><br>
    <span>年龄：</span><input type="text" name="age"><br>
    <button type="reset">重置</button>
    <button type="submit">提交</button>
</form>
<hr>
<form method="post" action="user/register02">
    <span>姓名：</span><input type="text" name="username"><br>
    <span>年龄：</span><input type="text" name="age"><br>
    <button type="reset">重置</button>
    <button type="submit">提交</button>
</form>
</body>
</html>
