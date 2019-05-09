<%@ page import="java.util.Map" %>
<%@ page import="Dao.BookUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/5
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前购物车</title>
</head>
<body>
<%
    Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("shoppingCart");
    pageContext.setAttribute("cart", map);
    for (Map.Entry<String, Integer> item : map.entrySet()) {
        System.out.println(item.getKey() + ":" + item.getValue());
    }
%>
</body>
<h3>当前购物车</h3>
<c:choose>
    <c:when test="${empty cart}">
        <c:out value="当前购物车为空"/>
    </c:when>
    <c:otherwise>
        <c:forEach items="${cart}" var="book">
            <p>
                <c:out value="书名：${BookUtil.findBookById(book.key).name}"/>
                <c:out value="数量：${book.value}"/>
            </p>
        </c:forEach>
    </c:otherwise>
</c:choose>

<div><a href="/ShoppingCart/clearCart">清空购物车</a></div>
</html>
