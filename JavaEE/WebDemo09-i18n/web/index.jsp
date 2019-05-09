<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/30
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%
        Locale locale = request.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        String username = bundle.getString("username");
        String password = bundle.getString("password");
        String login = bundle.getString("login");
        String reset = bundle.getString("reset");
        String quit = bundle.getString("quit");

    %>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><%=username%>：
            </td>
            <td><label>
                <input type="text" name="username">
            </label></td>
        </tr>
        <tr>
            <td><%=password%>：
            </td>
            <td><label>
                <input type="password" name="password">
            </label></td>
        </tr>
        <tr>
            <td>
                <button type="reset"><%=reset%>
                </button>
            </td>
            <td>
                <button type="submit"><%=login%>
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
