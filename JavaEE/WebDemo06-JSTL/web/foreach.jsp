<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/25
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add("laowang");
        list.add("laosong");
        list.add("laozhao");
        list.add("laoliu");
        pageContext.setAttribute("list",list);

        Map<String,Integer> map = new HashMap<>();
        map.put("A",100);
        map.put("B",80);
        map.put("C",70);
        map.put("D",60);
        pageContext.setAttribute("map",map);
    %>
    <c:forEach begin="0" end="10" var="index">
        <%--var="index"会将值自动存放到page中，每次循环完删除此循环的值，再存取下一次的值--%>
        <h4>Index：${index}</h4>
    </c:forEach>

    <c:forEach items="${list}" var="item">
        <h4>${item}</h4>
    </c:forEach>

    <c:forEach items="${map}" var="item">
        <h4>${item.key} : ${item.value}</h4>
    </c:forEach>
</body>
</html>
