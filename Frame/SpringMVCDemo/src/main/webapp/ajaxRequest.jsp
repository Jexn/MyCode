<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/11
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax请求</title>
    <script rel="javascript" type="text/javascript" src="JavaScript/jquery-3.4.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    method: "POST",
                    url: "${pageContext.request.contextPath}/returnResult/ajax",
                    data: {"name": "老王", "age": 23},
                    dataType: "JSON",
                    success: function (result) {
                        console.log(result);
                        $("#content").text("姓名：" + result.name + ",年龄：" + result.age);
                    }
                });
            });
            $("#obj").click(function () {
                $.ajax({
                    method: "post",
                    url: "${pageContext.request.contextPath}/returnResult/object",
                    success: function (result) {
                        $("#objContent").text(result);
                    }
                });
            });

            $("#map").click(function () {
                $.ajax({
                    method:"post",
                    url:"${pageContext.request.contextPath}/returnResult/map",
                    success:function (result) {
                        $("#mapData").text(result.hello);
                    }
                })
            })
        })
    </script>
</head>
<body>
<div>
    <button type="button" id="btn">使用Ajax传递数据</button>
    <br>
    <p id="content"></p>
</div>

<div>
    <button type="button" id="obj">返回Object对象</button>
    <p id="objContent"></p>
</div>

<div>
    <button type="button" id="map">返回Map</button>
    <p id="mapData"></p>
</div>
</body>
</html>
