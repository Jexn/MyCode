<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/25
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>if判断</title>
</head>
<body>

    <h2>c:if</h2>
    <c:if test="${empty param.username}">
        <h4>游客,请登录</h4>
    </c:if>
    <c:if test="${!empty param.username}">
        <h4>欢迎,<span style="color: darkgreen">${param.username}</span></h4>
    </c:if>

    <hr>
    <h2>c:if-else</h2>
    <c:choose>
        <c:when test="${param.score >= 90}">
            <h3>成绩:A</h3>
        </c:when>
        <c:when test="${param.score >= 80 && param.score < 90}">
            <h3>成绩:B</h3>
        </c:when>
        <c:when test="${param.score >= 70 && param.score < 80}">
            <h3>成绩:C</h3>
        </c:when>
        <c:when test="${param.score >=60 && param.score < 70}">
            <h3>成绩:D</h3>
        </c:when>
        <c:otherwise>
            <h3>成绩:E</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
