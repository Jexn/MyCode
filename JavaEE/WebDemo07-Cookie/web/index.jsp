<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/26
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false" %>
<html>
<head>
    <title>Cookie Test</title>
</head>
<body>
<h1>Current Index</h1>
<c:out value="当前用户：${cookie.username.value}"></c:out>
</body>
</html>
