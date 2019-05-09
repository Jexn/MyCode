<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/29
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajax测试</title>
    <script>
        window.onload = function () {
            var btn = document.getElementById("btn");
            var btn01 = document.getElementById("btn01");

            var receive = document.getElementById("receive");
            var receive01 = document.getElementById("receive01");
            btn.onclick = function () {
                var xhr = new XMLHttpRequest();
                // 设置参数
                xhr.open("GET", "${pageContext.request.contextPath}/getAjax?username=root&password=root");
                // 发送请求
                xhr.send();
                // 接收数据
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4) {
                        receive.innerText = xhr.responseText;
                    }
                }
            };

            btn01.onclick = function () {
                var xhr = new XMLHttpRequest();
                xhr.open("POST", "${pageContext.request.contextPath}/postAjax");

                // 因为Ajax默认使用Get方式发送，而Get方式没有请求体，Post请求需要请求体，所以需要设置请求头
                xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                // Post方式发送请求，需要把参数写到Send中
                xhr.send("username=laowang&age=20");
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4) {
                        receive01.innerText = xhr.responseText;
                    }
                }
            }

        }
    </script>
</head>
<body>
<button id="btn">点击发送Ajax请求</button>
<div id="receive"></div>
<button id="btn01">Post请求</button>
<div id="receive01"></div>
</body>
</html>
