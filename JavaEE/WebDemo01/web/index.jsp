<%--
  Created by IntelliJ IDEA.
  User: Cube
  Date: 2019/4/21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%--
    Get请求

    Request URL: http://localhost:8080/WebDemo01/succeed.jsp?username=cubetoo&password=asdasd
    Request Method: GET
    Status Code: 200
    Remote Address: [::1]:8080
    Referrer Policy: no-referrer-when-downgrade

    响应头
    Content-Length: 115
    Content-Type: text/html;charset=UTF-8
    Date: Sun, 21 Apr 2019 07:01:15 GMT

    请求头
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
    Accept-Encoding: gzip, deflate, br
    Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
    Connection: keep-alive
    Cookie: JSESSIONID=D0ADA2BCB13740886874060394C5F954
    DNT: 1
    Host: localhost:8080
    Referer: http://localhost:8080/WebDemo01/
    Upgrade-Insecure-Requests: 1
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36

    请求参数
    username: cubetoo
    password: asdasd
--%>


<%--
    Request URL: http://localhost:8080/WebDemo01/succeed.jsp
    Request Method: POST
    Status Code: 200
    Remote Address: [::1]:8080
    Referrer Policy: no-referrer-when-downgrade

    响应头
    Content-Length: 115
    Content-Type: text/html;charset=UTF-8
    Date: Sun, 21 Apr 2019 07:37:21 GMT

    请求头
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
    Accept-Encoding: gzip, deflate, br
    Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
    Cache-Control: max-age=0
    Connection: keep-alive

    // 请求头
    Content-Length: 31
    Content-Type: application/x-www-form-urlencoded

    Cookie: JSESSIONID=E94AFD5BE071D898670F7FDAA0D8C5CC
    DNT: 1
    Host: localhost:8080
    Origin: http://localhost:8080
    Referer: http://localhost:8080/WebDemo01/
    Upgrade-Insecure-Requests: 1
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36

    请求参数
    username: cubetoo
    password: asasd
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Web</title>
</head>
<body>
<form action="succeed.jsp" method="post">
    <table>
        <tr>
            <td><span>用户名：</span></td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td><span>密码：</span></td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td>
                <button type="reset">重置</button>
            </td>
            <td>
                <button type="submit" id="submit">登录</button>
            </td>
        </tr>
    </table>
    <br>
</form>
</body>
</html>
