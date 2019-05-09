## IDEA搭建Servlet环境

[搭建教程](https://blog.csdn.net/wangxiaoan1234/article/details/76409210)

### Tomcat终端中文乱码问题

Tomcat终端乱码分两种情况

- cmd终端运行输出乱码：控制面板-时钟和区域-区域-管理-更改系统区域设置，勾选使用Unicode utf-8提供全球语言支持;

- 页面乱码：`request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8");`

- IDEA终端乱码：[IDEA乱码](https://blog.csdn.net/nan_cheung/article/details/79337273);在VM options填写-Dfile.encoding=UTF-8

## Tomcat部署与解析

[Tomcat部署与配置解析](https://www.cnblogs.com/kismetv/p/7228274.html)
[相关视频](https://www.bilibili.com/video/av14548279)


## 浏览器访问流程

1. 浏览器通过http协议发送请求到服务器；

2. 服务器根据浏览器url地址解析请求；

3. 根据url地址直接找请求资源，比如请求一个html页面服务器直接返回该页面，如果有响应资源，直接返回响应资源；

4. 如果请求没有找到，则去web.xml中查找响应的请求，根据url-pattern匹配响应的请求（**url-pattern：必须是用/开头**），如果对象的servlet-class里的对象实例已经存在，直接提供服务；

5. 如果没有找到响应的servlet-class对象实例，则服务器自动调用servlet的无参构造器创建对象，调用对象的service方法处理请求；

## Servlet生命周期

所有的Servlet对象实例是由tomcat服务器创建，不需要手动创建，service()方法也是服务器在特定情况（用户访问相应服务）下调用，对象销毁也是由服务器执行

**Servlet生命周期**：对象的创建到销毁过程就是生命周期；对象存在时由服务器自动调用的方法（不是我们手动调用的方法）叫做生命周期方法；

1. 构造器：第一次访问Servlet服务，服务器会创建该Servlet对象实例，并且只创建一个（单例对象）；

2. init()生命周期方法：构造器调用后，服务器会立刻调用init()方法，服务器会传入一个ServletConfig接口对象，可以在此方法中完成一些初始化操作，并且init()在一个Servlet对象生命周期中只会被调用一次；

    ServletConfig：服务器创建传入，可以直接使用；

        代表：Servlet的配置信息，每个Servlet都有一个唯一的ServletConfig对象；

        作用：
            1. 获取Servlet服务别名（servlet-name）；

            2. 获取Servlet的初始化参数：通过servletConfig.getInitParameter(ParameterName)获取web.xml中<init-param>的配置信息；

            3. 获取全局上下文对象；
            

3. service()方法：每次用户访问，service都会被调用一次。这个方法用于处理用户请求，响应用户；

4. destroy()方法：正常关闭服务器，服务器调用这个方法；

## service()

### HttpServletRequest和HttpServletResponse

    - HttpServletRequest：请求报文
        - 概念：浏览器到服务器的请求报文，请求到达服务器，服务器将报文解析封装为这个对象；
        - 作用：请求到达服务器时，服务器直接创建然后传入到service()方法中，最终传入到doGet、doPost中

    - HttpServletResponse：响应报文
        - 概念：服务器给浏览器的响应报文，请求到服务器，服务器将服务器信息封装起来创建为此对象；
        - 作用：请求到达服务器，服务器创建此对象传入到service中，最终传入到doGet、doPost中

## 请求转发和重定向

项目|请求转发|重定向
:--:|:--:|:--:|
使用对象|HttpServletRequest|HttpServletResponse
发起者（执行者）|服务器|浏览器
浏览器请求次数|1|2
浏览器是否知道|否|是
浏览器获取响应次数|1|2
url地址是否改变|否|是

## 相对路径和绝对路径

假设访问地址为`http://127.0.0.1:8080/WebDemo/servlet1`

相对路径相对于当前所在位置，相对路径不加'/'，在一个servlet1页面中`<a href="servlet2">Link2</a>;`如果需要访问Link2，那么相对的路径是`http://127.0.0.1:8080/WebDemo/`;但由于在请求转发中，浏览器不发生跳转，可能会造成相对路径出错；

绝对路径：绝对路径需要看访问的对象是浏览器还是服务器；在web项目中绝对路径是以/开头的路径；

    浏览器：在浏览器端解析的地址：默认会在前面添加`http://127.0.0.1:8080`,所以如果需要在servlet1中访问servlet2，需要改成`<a href="/WebDemo/servlet2">Link2</a>`;

    服务器：
        - 请求转发：转发由服务器执行，服务器知道自己所处项目，不需要添加项目名称，默认会在前面添加`http://127.0.0.1:8080/项目名`。比如`request.getRequestDispatcher("/succeed.html").forward(request,response)`;
        
        - 重定向：因为重定向是由服务器发送新的地址给浏览器重新访问，所以需要添加项目名称；比如重定向servlet2`response.sendRedirect("/WebDemo/servelt2")`


