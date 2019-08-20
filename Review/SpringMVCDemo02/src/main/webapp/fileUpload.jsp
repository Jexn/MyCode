<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/6/28
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>文件上传</h3>
    <form action="fileUpload/file01" method="post" enctype="multipart/form-data">
        <span>选择文件：</span><input type="file" name="upload"><br>
        <button type="submit">上传</button>
    </form>

    <h3>SpringMVC上传文件</h3>
    <form action="fileUpload/file02" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="photo"><br>
        <button type="submit">上传</button>
    </form>
</body>
</html>
