<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/13
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        form{
            display: grid;
            grid-template-columns: 80px 150px ;
            grid-template-rows: auto;
        }
        div{
            margin: 5px;
        }
    </style>
</head>
<body>
    <form action="checkUser" method="post">
        <div>
            <span>用户名：</span>
        </div>
        <div>
            <input type="text" name="username">
        </div>
        <div>
            <span>密码：</span>
        </div>
        <div>
            <input type="text" name="password">
        </div>
        <div>
            <button type="reset">重置</button>
        </div>
        <div>
            <button type="submit">登录</button>
        </div>
        <p style="color: red">${msg}</p>
    </form>
</body>
</html>
