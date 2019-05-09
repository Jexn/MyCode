<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/6
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <style>
        form{
            display: grid;
            grid-template-columns: 80px 150px;
            grid-template-rows: auto;
        }
        div{
            margin: 5px;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        <div>
            <span>姓名：</span>
        </div>
        <div>
            <input type="text" name="username">
        </div>
        <div>
            <span>照片：</span>
        </div>
        <div>
            <input type="file" name="photo">
        </div>
        <div>
            <button type="reset">重置</button>
        </div>
        <div>
            <button type="submit">提交</button>
        </div>
    </form>
</body>
</html>
