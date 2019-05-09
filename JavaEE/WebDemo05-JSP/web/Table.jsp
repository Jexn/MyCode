<%@ page import="java.util.List" %>
<%@ page import="Bean.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  Bean.User: Cube
  Date: 2019/4/23
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" autoFlush="true" %>
<html>
<head>
    <title>table表格</title>
    <style>
        table{
            border: 1px solid black;
        }
        td{
            width: 100px;
            margin: 0;
            border: 1px solid black;
        }
        tr{
            margin: 0;
        }
    </style>
</head>
<body>
    <table>
        <%
            List<User> list = new ArrayList<User>();
            list.add(new User(1,"老王","男",20));
            list.add(new User(2,"老赵","男",22));
            list.add(new User(3,"翠花","女",18));
            list.add(new User(4,"老宋","男",25));
            list.add(new User(6,"老李","男",28));
            for (User user : list) {
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getName()%></td>
            <td><%=user.getSex()%></td>
            <td><%=user.getAge()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
