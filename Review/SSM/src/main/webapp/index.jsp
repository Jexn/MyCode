<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/6/30
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
    <a href="account/findAll">查询所有账户</a>
    <h3>保存测试</h3>
    <form action="account/saveAccount" method="post">
        姓名:<input type="text" name="name"/> <br>
        金额:<input type="text" name="money"/> <br>
        <button type="submit">提交</button>
    </form>
</body>
</html>
