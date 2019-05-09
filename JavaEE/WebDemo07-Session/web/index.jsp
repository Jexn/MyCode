<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/27
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>欢迎，<span>${sessionScope.get("username")}</span></h1>
  </body>
</html>
