<%@ page import="java.util.Map" %>
<%@ page import="Bean.Book" %>
<%@ page import="Dao.BookUtil" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/5
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>书城</title>
</head>
<%
    Map<Integer, Book> books = BookUtil.getAllBook();
    for (Map.Entry<Integer, Book> book : books.entrySet()) {
        System.out.println(book);
    }
    pageContext.setAttribute("books", books);

//    初始化一个购物车
    Map<String, Integer> shoppingCart = new HashMap<>();
    session.setAttribute("shoppingCart", shoppingCart);
%>
<body>
<h3>商城书籍</h3>
<c:forEach items="${books}" var="book">
    <a href="/ShoppingCart/addBook?id=${book.value.id}}"> <c:out value="${book.value.name}"/></a></br>
</c:forEach>
<a href="shoppingCart.jsp">查看购物车</a>
</body>
</html>
