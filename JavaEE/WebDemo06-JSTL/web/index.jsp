<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/25
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--uri:指定引入标签库的内容 prefix:自定义标签库名字--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签库</title>
</head>
<body>
    <h1>JSTL使用</h1>

    <%
        request.setAttribute("username","admin");
        request.setAttribute("code","<script>alert('JSTL输出代码')</script>");
    %>

    <c:out value="<h2>c:out向页面输出内容</h2>" escapeXml="false"></c:out>
    <c:out value="${username}" default="如果EL表达式为空,则显示default的值"></c:out><br>
    <c:out value="${code}"></c:out><br>
    <c:out value="<h3>JSTL默认转译</h3>"></c:out>
    <c:out value="<h3>escapeXml设置不转译</h3>" escapeXml="false"></c:out>

    <hr>

    <h2>c:set设置域属性</h2>
    <c:set var="cset" value="来自c:set的域属性" scope="request"></c:set>
    <c:out value="${cset}"></c:out>

    <h3>c:set默认存值在pageContext中,也可以通过scope设置指定的存值区域</h3>
    <ul>
        <li>pageScope:${pageScope.cset}</li>
        <li>requestScope:${requestScope.cset}</li>
        <li>sessionScope:${sessionScope.cset}</li>
        <li>applicationScope:${applicationScope.cset}</li>
    </ul>

    <hr>
    <h3>c:remove移除属性值</h3>
    <c:set var="remove" value="remove移除"></c:set>
    <c:remove var="remove"></c:remove>
    <c:out value="${remove}" default="移除显示,未移除显示remove的值"></c:out>

    <%
        // page.setAttribute("all","page");
        request.setAttribute("all","request");
        session.setAttribute("all","session");
        application.setAttribute("all","application");
    %>

    <h4>c:remove会移除与var="key"所有相匹配的值</h4>
    <c:remove var="all" scope="page"></c:remove>
    <ul>
        <li>pageScope:${pageScope.all}</li>
        <li>requestScope:${requestScope.all}</li>
        <li>sessionScope:${sessionScope.all}</li>
        <li>applicationScope:${applicationScope.all}</li>
    </ul>
</body>
</html>
