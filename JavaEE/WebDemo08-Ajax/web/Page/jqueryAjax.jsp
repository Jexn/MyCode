<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/29
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery Ajax</title>
    <script src="Script/jquery-3.4.0.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                // 发送地址
                var url = "${pageContext.request.contextPath}/jQueryAjax";
                // 发送数据
                var data = {"username": "btn", "type": "get"};
                // 响应数据
                var callback = function (result) {
                    console.log(result.name);
                    console.log(result.privilege);
                    $("#content").text("用户名：" + result.name + "权限：" + result.privilege);
                };
                // 响应的数据类型
                var type = "json";
                $.get(url, data, callback, type);
            });

            $("#btn1").click(function () {
                var url = "${pageContext.request.contextPath}/jQueryAjax";
                // 发送数据
                var data = {"username": "btn1", "type": "getJSON"};
                // 响应数据
                var callback = function (result) {
                    console.log(result.name);
                    console.log(result.privilege);
                    $("#content1").text("用户名：" + result.name + "权限：" + result.privilege);
                };
                $.getJSON(url,data,callback);
            });

            $("#btn2").click(function () {
                var url = "${pageContext.request.contextPath}/jQueryAjax";
                // 发送数据
                var data = {"username": "btn2", "type": "post"};
                // 响应数据
                var callback = function (result) {
                    console.log(result.name);
                    console.log(result.privilege);
                    $("#content2").text("用户名：" + result.name + "权限：" + result.privilege);
                };
                $.post(url,data,callback,"JSON");
            });
        });
    </script>
</head>
<body>
<button id="btn">jQuery使用get()实现Ajax</button>
<div id="content"></div>

<button id="btn1">jQuery使用getJson()实现Ajax</button>
<div id="content1"></div>

<button id="btn2">jQuery使用post()实现Ajax</button>
<div id="content2"></div>
</body>
</html>
