<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/30
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>上传文件</title>
    <style>
        form {
            display: grid;
            grid-template-columns:80px 200px;
            grid-template-rows: auto;
        }
        div{
            margin: 5px;
        }

    </style>
</head>
<body>
<form method="post" action="register" enctype="multipart/form-data">
    <div class="content">
        <span>用户名：</span>
    </div>
    <div class="content">
        <input type="text" name="username">
    </div>

    <div class="content">
        <span>密码：</span>
    </div>
    <div class="content">
        <input type="password" name="password">
    </div>

    <div class="content">
        <span>头像</span>
    </div>
    <div class="content">
        <input type="file" name="picture">
    </div>

    <div class="content">
        <button type="reset">重置</button>
    </div>
    <div class="content">
        <button type="submit">注册</button>
    </div>
</form>
</body>
</html>
