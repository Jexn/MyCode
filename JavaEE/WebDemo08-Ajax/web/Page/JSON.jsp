<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/29
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSON</title>
    <script>
        window.onload = function () {

            // Javascript对象
            var jsObj = {username: "admin", age: "20"};

            // Javascript字符串
            var jsStr = '{username:"admin",age:"20"}';

            // JSON对象：对象属性名都需要使用引号括起。JSON语法和Javascript对象语法大致相同，都可以使用对象名.属性名引用
            var jsonObj = {"username": "root", "sex": "man"};

            alert("jsObj:" + jsObj.username);
            alert("jsStr:"+jsStr);
            alert("jsonObj:" + jsonObj.username);

            // JSON转字符串
            var jsonToString = JSON.stringify(jsonObj);
            console.log(jsonToString);

            // 字符串转JSON对象
            var stringToJSON = JSON.parse(jsonToString);
            console.log(stringToJSON.username);

            var btn = document.getElementById("btn");
            var content = document.getElementById("content");
            btn.onclick = function () {
                var xhr = new XMLHttpRequest();
                xhr.open("POST","${pageContext.request.contextPath}/getJSON");
                xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                xhr.send("username=root&&password=root");
                xhr.onreadystatechange = function () {
                    if (xhr.status == 200 && xhr.readyState == 4){
                        var json = xhr.responseText;
                        console.log(json);

                        // JSON字符串必须使用双引号，不能使用单引号
                        var getJsonObj = JSON.parse(json);
                        console.log(getJsonObj.info);
                        content.innerText = "姓名："+getJsonObj.name +"权限："+ getJsonObj.info;
                    }
                }

            }
        }
    </script>
</head>
<body>
<h1>JSON测试</h1>
<button id="btn">通过JSON接收数据</button>
<div id="content"></div>
</body>
</html>
