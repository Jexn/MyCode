## Get和Post请求区别

1. Get请求没有请求体和空行，因为提交的参数是在url地址上拼接的
2. Post请求有请求体和空行，因为提交的参数是在请求体中携带的
3. Get请求相对不安全，Post请求相对安全
4. Get请求参数在地址栏后携带，url地址栏数据大小为255个字符，所以Get请求参数大小有限制
5. Post请求参数大小没有限制，所以上传文件需要使用Post请求
6. Post携带了与参数相关的参数，比如Content-Length、Content-Type

```
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
```

```
    Post请求

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
```

## 相应报文
```
    Request URL: http://localhost:8080/WebDemo01/succeed.jsp
    Request Method: POST
    Status Code: 200
    Remote Address: [::1]:8080
    Referrer Policy: no-referrer-when-downgrade
```

响应报文包含：响应首行（协议版本 响应状态码）、响应时间、响应类型、响应内容（请求的网页之类）

响应状态码：200响应成功，300重定向，400请求错误，500服务器错误([参考](https://blog.51cto.com/lihongweibj/1662478))