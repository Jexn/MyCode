<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/11
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StringForward</title>
</head>
<body>
    <h3>String返回的请求转发</h3>
    <p>String类型数据：${param.name}</p>
    <P>Object对象：${school.school_name} ${requestScope.school.local}</P>
</body>
</html>
