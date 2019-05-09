<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/5/7
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax测试</title>
    <script>
        window.onload = function () {
            // 绑定按钮
            var btn01 = document.getElementById("btn01");
            var content = document.getElementById("content");
            var username = document.getElementById("username");
            var msg = document.getElementById("msg");

            btn01.onclick = function () {
                var xhr;
                if (window.XMLHttpRequest) {
                    xhr = new XMLHttpRequest();
                } else {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xhr.open("POST", "${pageContext.request.contextPath}/btn01");
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhr.send("username=root&password=root");
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4) {
                        var text = xhr.responseText;
                        console.log(text);
                        content.innerText = text;
                    }
                }
            };

            username.onblur = function () {
                var xhr = new XMLHttpRequest();
                xhr.open("POST","${pageContext.request.contextPath}/checkName");
                xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4){
                        if (xhr.responseText == "true"){
                            msg.innerHTML = "<span style='color: red;' >用户名已存在</span>";
                        }else if (xhr.responseText == "false"){
                            msg.innerText = "用户名可用！";
                        }
                    }
                };
                xhr.send("username="+this.value);

            }
        };
    </script>
</head>
<body>
<div>
    <button id="btn01">点击获取Ajax数据</button>
    <p id="content"></p>
</div>
<form >
    <span>姓名：</span>
    <input type="text" name="username" id="username"><span id="msg"></span>
</form>
</body>
</html>
