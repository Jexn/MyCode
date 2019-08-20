## Spring IOC

### Spring加载方式

**本地项目**

- AnnotationConfigApplicationContext：从一个或多个基于Java的配置类中加载Spring应用上下文。

- ClassPathXmlApplicationContext：从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源。

- FileSystemXmlapplicationcontext：从文件系统下的一个或多个XML配置文件中加载上下文定义。

**Web项目**

- AnnotationConfigWebApplicationContext：从一个或多个基于Java的配置类中加载Spring Web应用上下文。

- XmlWebApplicationContext：从Web应用下的一个或多个XML配置文件中加载上下文定义。

### Spring Bean

### Bean的生命周期

```XML
    <!--  bean对象的作用范围  -->
    <!--  默认的bean的作用范围是单例的  -->
    <!--  bean标签的scope属性：
            作用：用于指定bean的作用范围
            value: singleton：默认，单例
                   prototype：多例
                   request：作用于web应用的请求范围
                   session：作用web应用的会话范围
                   global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境，它就是session
      -->
    <bean id="personScope" class="com.cube.bean.Person" scope="prototype"/>
```
**单例对象：scope="singleton" 一个应用只有一个对象的实例。它的作用范围就是整个引用。**

生命周期： 
1. 对象出生：当应用加载，创建容器时，对象就被创建了。 
2. 对象活着：只要容器在，对象一直活着。 
3. 对象死亡：当应用卸载，销毁容器时，对象就被销毁了。 

**多例对象：scope="prototype" 每次访问对象时，都会重新创建对象实例。**

生命周期：
1. 对象出生：当使用对象时，创建新的对象实例。 
2. 对象活着：只要对象在使用中，就一直活着。 
3. 对象死亡：当对象长时间不用时，被java的垃圾回收器回收了。

### Bean的装配方式

```XML
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- spring中的依赖注入
        依赖注入：
            Dependency Injection
        IOC的作用：
            降低程序间的耦合（依赖关系）
        依赖关系的管理：
            以后都交给spring来维护
        在当前类需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明
        依赖关系的维护：
            就称之为依赖注入。
         依赖注入：
            能注入的数据：有三类
                基本类型和String
                其他bean类型（在配置文件中或者注解配置过的bean）
                复杂类型/集合类型
             注入的方式：有三种
                第一种：使用构造函数提供
                第二种：使用set方法提供
                第三种：使用注解提供（明天的内容）
     -->


    <!--构造函数注入：
        使用的标签:constructor-arg
        标签出现的位置：bean标签的内部
        标签中的属性
            type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型
            index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始
            name：用于指定给构造函数中指定名称的参数赋值                                        常用的
            =============以上三个用于指定给构造函数中哪个参数赋值===============================
            value：用于提供基本类型和String类型的数据
            ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象

        优势：
            在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
        弊端：
            改变了bean对象的实例化方式，使我们在创建对象时，如果用不到这些数据，也必须提供。
     -->

    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl">
        <constructor-arg name="name" value="泰斯特"></constructor-arg>
        <constructor-arg name="age" value="18"></constructor-arg>
        <constructor-arg name="birthday" ref="now"></constructor-arg>
    </bean>-->

    <!-- 配置一个日期对象 -->
    <bean id="now" class="java.util.Date"></bean>


    <!-- set方法注入                更常用的方式
        涉及的标签：property
        出现的位置：bean标签的内部
        标签的属性
            name：用于指定注入时所调用的set方法名称
            value：用于提供基本类型和String类型的数据
            ref：用于指定其他的bean类型数据。它指的就是在spring的Ioc核心容器中出现过的bean对象
        优势：
            创建对象时没有明确的限制，可以直接使用默认构造函数
        弊端：
            如果有某个成员必须有值，则获取对象是有可能set方法没有执行。
    -->
    <bean id="accountService2" class="com.itheima.service.impl.AccountServiceImpl2">
        <property name="name" value="TEST"></property>
        <property name="age" value="21"></property>
        <property name="birthday" ref="now"></property>
    </bean>-->


    <!-- 复杂类型的注入/集合类型的注入
        用于给List结构集合注入的标签：
            list array set
        用于个Map结构集合注入的标签:
            map  props
        结构相同，标签可以互换
    -->
        <bean id="accountService3" class="com.itheima.service.impl.AccountServiceImpl3">
            <property name="myStrs">
                <set>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </set>
            </property>

            <property name="myList">
                <array>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </array>
            </property>

            <property name="mySet">
                <list>
                    <value>AAA</value>
                    <value>BBB</value>
                    <value>CCC</value>
                </list>
            </property>

            <property name="myMap">
                <props>
                    <prop key="testC">ccc</prop>
                    <prop key="testD">ddd</prop>
                </props>
            </property>

            <property name="myProps">
                <map>
                    <entry key="testA" value="aaa"></entry>
                    <entry key="testB">
                        <value>BBB</value>
                    </entry>
                </map>
            </property>
        </bean>
</beans>
```

## Spring AOP
