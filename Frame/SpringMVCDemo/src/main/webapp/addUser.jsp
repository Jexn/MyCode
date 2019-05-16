<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/11
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        form {
            display: grid;
            grid-template-columns: 60px 100px;
            grid-template-rows: auto;
        }

        div {
            margin: 5px;
        }
    </style>
</head>
<body>
<form action="user/register03" method="post">
    <div><span>姓名：</span></div>
    <div>
        <input type="text" name="name">
    </div>
    <div><span>性别：</span></div>
    <div><input type="text" name="sex"></div>
    <div><span>年龄：</span></div>
    <div><input type="text" name="age"></div>
    <div><span>邮箱：</span></div>
    <div><input type="text" name="email"></div>
    <div><span>手机：</span></div>
    <div><input type="text" name="phone"></div>
    <div class="button">
        <button type="reset">重置</button>
    </div>
    <div class="button">
        <button type="submit">提交</button>
    </div>
</form>

<form action="user/register04" method="post">
    <div>
        <span>姓名：</span>
    </div>
    <div>
        <input type="text" name="name">
    </div>
    <div>
        <span>年龄：</span>
    </div>
    <div>
        <input type="text" name="age">
    </div>
    <div>
        <span>国籍：</span>
    </div>
    <div>
        <input type="text" name="location.name">
    </div>
    <div>
        <span>省份：</span>
    </div>
    <div>
        <input type="text" name="location.localInfo">
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
