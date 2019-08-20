<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/6/30
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有账户信息</title>
</head>
<body>
    <h3>所有账户</h3>
    <c:forEach items="${list}" var="account">
        ${account.id} ${account.name} ${account.money}
    </c:forEach>
</body>
</html>
