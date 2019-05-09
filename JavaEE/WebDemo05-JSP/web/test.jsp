<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/25
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetIP</title>
</head>
<body>
    <h1>你的IP地址：</h1>
    <%="Your IP address is " + request.getRemoteAddr()%>
</body>
</html>
