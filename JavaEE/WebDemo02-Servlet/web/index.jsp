<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/21
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="succeed" method="post">
    <table>
        <tr>
            <td>
                <span>用户名：</span>
            </td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>

        <tr>
            <td>
                <span>密码：</span>
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>

        <tr>
            <td>
                <button type="reset">重置</button>
            </td>
            <td>
                <button type="submit">登录</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
