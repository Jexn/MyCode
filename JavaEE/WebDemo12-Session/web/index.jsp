<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/5
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <h1>Session设置流程</h1>
    <p>Session在首次访问的时候，服务器根据收到的数据创建一个Session会话，然后创建相应的Session对象，服务器对Session对象是以Map的形式进行管理的，每创建一个session对象，服务器都会向该Map中的 key放入一个32位长度的随机串，这个随机串称为JSessionID， 之后将该session对象的引用放入到map的value中。
        session放入到Map之后，服务器还会自动将”JSESSIONID”作为 name，32位长度的随机串作为value，放到cookie中并发送到客户端。该cookie会默认放到浏览器的缓存中，只要浏览器不关闭就一直存在。
        当浏览器第二次向服务器发送请求时会携带该cookie，服务器接收到之后会根据JSessionID从Map中找到与之对应的session对象。</p>
</body>
</html>
