<%@ page import="Bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/25
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL取值</title>
</head>
<body>
    <%
        session.setAttribute("user",new User(9520,"祝枝山","男",22));
        request.setAttribute("user",new User(9527,"唐伯虎","男",20));
        application.setAttribute("user",new User(1000,"秋香","女",20));

    %>
    <h1>默认依次从page、request、session、application域中查询，查询到就结束</h1>
    ${user.id}
    ${user.name}
    ${user.sex}
    ${user.age}

    <h1>从指定域查询</h1>
    <h2>指定session域查询</h2>
    ${sessionScope.user.id}
    ${sessionScope.user.name}
    ${sessionScope.user.sex}
    ${sessionScope.user.age}

    <h2>指定从application域查询</h2>
    ${applicationScope.user.id}
    ${applicationScope.user.name}
    ${applicationScope.user.sex}
    ${applicationScope.user.age}
</body>
</html>
