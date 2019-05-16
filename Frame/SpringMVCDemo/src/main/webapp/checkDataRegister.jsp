<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/12
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息注册</title>
    <style>
        form{
            display: grid;
            grid-template-columns: 80px 400px;
            grid-template-rows: auto;
        }
        div{
            margin: 5px;
        }
    </style>
</head>
<body>
<form action="checkData" method="post">
    <div>
        <span>姓名：</span>
    </div>
    <div>
        <input type="text" name="name">
        <span id="nameError">${nameError}</span>
    </div>
    <div>
        <span>年龄：</span>
    </div>
    <div>
        <input type="text" name="age">
        <span id="ageError">${ageError}</span>
    </div>
    <div>
        <span>手机号：</span>
    </div>
    <div>
        <input type="text" name="phone">
        <span id="phoneError">${phoneError}</span>
    </div>
    <div>
        <button type="reset">重置</button>
    </div>
    <div>
        <button type="submit">提交</button>
    </div>
</form>
</body>
</html>
