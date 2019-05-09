## JSP简介

- JSP全称Java Server Pages，顾名思义就是运行在java服务器中的页面，也就是在我们JavaWeb中的动态页面，其本质就是一个Servlet。

- 其本身是一个动态网页技术标准，它的主要构成有HTML网页代码、Java代码片段、JSP标签几部分组成，后缀是.jsp。

- JSP相比HTML页面来说，最直观的功能就是可以在页面中使用变量，这些变量一般都是从域对象中获取。有了变量的好处就是我们的页面可以动态的显示信息。

- 相比于Servlet，JSP更加善于处理显示页面，而Servlet跟擅长处理业务逻辑，两种技术各有专长，所以一般我们会将Servlet和JSP结合使用，Servlet负责业务，JSP负责显示。

## JSP基本格式

- JSP的基本格式和HTML页面相似，不同之处就是使用JSP时页面的顶部必须使用JSP指令声明一些JSP相关的信息。如上图JSP文件，首行使用一条page指令声明了JSP的相关信息，关于JSP指令我们在这里先不过多讲解，目前可以把它当成一种固定格式。

- 在首行的JSP指令下边就可以来编辑我们的HTML代码了，从上边的文件中也可以看出实际上就是原封不动的HTML代码。

- 如上这面的JSP文件，我们如果不需要加入动态代码，就可以直接来编写HTML代码，语法是一模一样的。

- 代码编辑完成后启动服务器，访问JSP页面（和访问HTML页面一样，直接输入地址），会看到页面正常显示和普通HTML一样。

- 注意：JSP文件的运行依赖于WEB服务器，也就是说如果不是通过WEB服务器，浏览器是不能直接打开JSP文件的。

## JSP脚本元素

- 在JSP中我们主要通过脚本元素来编写Java代码，这些Java代码一般会在页面被访问时调用。

- JSP脚本元素主要分三种：**脚本片段、表达式、声明**。

### 脚本片段

1. 脚本片段是嵌入到JSP中Java代码段，格式以<%开头，%>结尾，两个%号之间就可以编写Java代码了。如：`<% System.out.println("Hello World");%>`

2. 上边就是一个JSP的脚本片段，片段中的Java代码使我们非常熟悉的内容，`这条语句会在JSP页面被访问时向页面中(IDEA终端控制台)打印一条“Hello World”`。

3. 通过这种方式我们可以在JSP中完成大量的Java代码，甚至写一些业务逻辑，但是并不建议这么做。

4. 这种方式编写的Java代码，会放到Servlet的service方法中执行，既然是写在一个方法中的代码那就对我们就不能随便的去写。比如：不能定义成员变量、不能定义方法、不能定义类。

### JSP表达式

1. JSP表达式用来直接将Java变量输出到页面中，格式以<%=开头，以%>结尾，中间是我们要输出的内容。如：`<%=str %>`

2. 上边语句中的str是JSP中的一个String型的变量，通过这种方式`可以将该变量输出到页面中`。

### JSP声明（了解）

1. JSP声明中的内容会被直接写到类中，格式以<%!开头，以%>结尾，中间是Java代码。如：`<%! private int a = 0; %>`

2. 上边这条语句相当于在类中声明了一个成员变量，由于JSP声明中的代码会被写在类中，所以在类中可以编写的内容在JSP声明中都可以编写。如：`定义成员变量、定义方法、构造器、构造代码块、静态代码块。`

3. JSP声明使用的机会并不是很多，所以知道即可。

## JSP隐含对象

## JSTL标签库

```HTML
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--uri:指定引入标签库的内容 prefix:自定义标签库名字--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签库</title>
</head>
<body>
    <h1>JSTL使用</h1>

    <%
        request.setAttribute("username","admin");
        request.setAttribute("code","<script>alert('JSTL输出代码')</script>");
    %>

    <c:out value="<h2>c:out向页面输出内容</h2>" escapeXml="false"></c:out>
    <c:out value="${username}" default="如果EL表达式为空,则显示default的值"></c:out><br>
    <c:out value="${code}"></c:out><br>
    <c:out value="<h3>JSTL默认转译</h3>"></c:out>
    <c:out value="<h3>escapeXml设置不转译</h3>" escapeXml="false"></c:out>

    <hr>

    <h2>c:set设置域属性</h2>
    <c:set var="cset" value="来自c:set的域属性" scope="request"></c:set>
    <c:out value="${cset}"></c:out>

    <h3>c:set默认存值在pageContext中,也可以通过scope设置指定的存值区域</h3>
    <ul>
        <li>pageScope:${pageScope.cset}</li>
        <li>requestScope:${requestScope.cset}</li>
        <li>sessionScope:${sessionScope.cset}</li>
        <li>applicationScope:${applicationScope.cset}</li>
    </ul>

    <hr>
    <h3>c:remove移除属性值</h3>
    <c:set var="remove" value="remove移除"></c:set>
    <c:remove var="remove"></c:remove>
    <c:out value="${remove}" default="移除显示,未移除显示remove的值"></c:out>

    <%
        // page.setAttribute("all","page");
        request.setAttribute("all","request");
        session.setAttribute("all","session");
        application.setAttribute("all","application");
    %>

    <h4>c:remove会移除与var="key"所有相匹配的值</h4>
    <c:remove var="all" scope="page"></c:remove>
    <ul>
        <li>pageScope:${pageScope.all}</li>
        <li>requestScope:${requestScope.all}</li>
        <li>sessionScope:${sessionScope.all}</li>
        <li>applicationScope:${applicationScope.all}</li>
    </ul>
</body>
</html>
```

### c:out

- c:out标签可以通过EL表达式取值输出其内容

- 通过default可以设置默认c:out的默认输出内容

- 通过escapeXml可以设置是否转译，如果输出内容有标签，默认自动转义

### c:set

- c:set设置域属性，默认存放到pageContext中

- c:set默认存值在pageContext中,也可以通过scope设置指定的存值区域

### c:remove

- c:remove可以移除指定的域属性值

- c:remove会移除与var="key"所有相匹配的值；也可以通过scope="page"移除指定的域属性值

### c:if

```Java
    <c:if test="${empty param.username}">
        <h4>游客,请登录</h4>
    </c:if>
    <c:if test="${!empty param.username}">
        <h4>欢迎,<span style="color: darkgreen">${param.username}</span></h4>
    </c:if>
```

### c:if-else

```Java
    <c:choose>
        <c:when test="${param.score >= 90}">
            <h3>成绩:A</h3>
        </c:when>
        <c:when test="${param.score >= 80 && param.score < 90}">
            <h3>成绩:B</h3>
        </c:when>
        <c:when test="${param.score >= 70 && param.score < 80}">
            <h3>成绩:C</h3>
        </c:when>
        <c:when test="${param.score >=60 && param.score < 70}">
            <h3>成绩:D</h3>
        </c:when>
        <c:otherwise>
            <h3>成绩:E</h3>
        </c:otherwise>
    </c:choose>
```

### foreach
```Java
     <%
        List list = new ArrayList();
        list.add("laowang");
        list.add("laosong");
        list.add("laozhao");
        list.add("laoliu");
        pageContext.setAttribute("list",list);

        Map<String,Integer> map = new HashMap<>();
        map.put("A",100);
        map.put("B",80);
        map.put("C",70);
        map.put("D",60);
        pageContext.setAttribute("map",map);
    %>
    <c:forEach begin="0" end="10" var="index">
        <%--var="index"会将值自动存放到page中，每次循环完删除此循环的值，再存取下一次的值--%>
        <h4>Index：${index}</h4>
    </c:forEach>

    <c:forEach items="${list}" var="item">
        <h4>${item}</h4>
    </c:forEach>

    <c:forEach items="${map}" var="item">
        <h4>${item.key} : ${item.value}</h4>
    </c:forEach>
```




