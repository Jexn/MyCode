<%@ page import="java.util.UUID" %><%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/27
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script>
        window.onload = function () {
            var submit = document.getElementById("submitBtn");
            submit.onclick = function () {
                this.disable();
                this.parentNode.submit();
            }
            var imgCode = document.getElementById("checkCode");
            imgCode.onclick = function () {
                this.src = "checkCode.jpg";
            }
        }
    </script>
    <style>
        td{
            height: 30px;
        }
        img{
            width: 155px;
            margin: 0px;
            padding: 0px;
        }
    </style>
</head>
<body>

<%
    String token = UUID.randomUUID().toString();
    session.setAttribute("servletToken", token);
    System.out.println(token);
%>
<form action="${pageContext.request.contextPath}/registerServlet" method="post">
    <input type="hidden" name="clientToken" value="${servletToken}">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><img src="checkCode.jpg" id="checkCode"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="checkCode" placeholder="请输入验证码..."></td>
        </tr>
        <tr>
            <td>
                <button type="reset">重置</button>
            </td>
            <td>
                <button type="submit" id="submitBtn">提交</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
