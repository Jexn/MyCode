<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/12
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="upload01" enctype="multipart/form-data" method="post">
        <span>${msg}</span><br>
        <span>图片</span><label><input type="file" name="photo"></label><br>
        <button type="submit">上传</button>
    </form>
</body>
</html>
