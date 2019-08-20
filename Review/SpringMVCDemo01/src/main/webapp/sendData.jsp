<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/6/19
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送参数请求</title>
</head>
<body>
    <h3>参数请求</h3>
    <a href="param/request1?username=老王">跳转</a>
    <form action="param/saveAccount" method="post">
        <span>姓名：</span><input type="text" name="username"><br>
        <span>密码：</span><input type="text" name="password"><br>
        <span>金额：</span><input type="text" name="money"><br>
        <span>用户姓名：</span><input type="text" name="user.name"><br>
        <span>用户年龄：</span><input type="text" name="user.age"><br>
        <button type="reset">重置</button>
        <button type="submit">提交</button>
    </form>
</body>
</html>
