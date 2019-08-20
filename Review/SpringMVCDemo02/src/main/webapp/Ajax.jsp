<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/6/28
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax异步请求</title>
    <script src="script/jquery-3.4.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"ajax/ajax01",
                    type:"post",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"刘德华","password":"ldh","age":30}',
                    datatype:"JSON",
                    success:function (data) {
                        console.log(data);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <h3>异步请求</h3>
    <p id="content"></p>
    <button id="btn">发送异步请求</button>
</body>
</html>
