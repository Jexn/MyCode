package com.cube.service;

import com.cube.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Cube
 * @className AccountServiceImpl
 * @description
 * @date 2019-06-13 08:25
 */

/**
 * 曾经的XML配置
 * <bean id="accountService" class="com.cube.service.AccountServiceImpl" scope="" init-method="" destroy-method="">
 *      <property name="" value="" | ref=""></property>
 * </bean>
 *
 * 注解分类：
 *      1.用于创建对象的：XML中的<bean>标签
 *           @Component:
 *              作用：用于把当前对象存入Spring容器中
 *              属性：
 *                  value:用于指定bean的id。当我们不写时，它的默认值时当前类名，且首字母改小写
 *          @Controller：一般用在表现层
 *          @Service：一般用于业务层
 *          @Repository：一般用于持久层
 *          以上三个注解他们的作用和属性与Component一模一样。他们三个是Spring框架为我们提供明确的三层使用的注解，是我们的三层对象更加清晰
 *      2.用于注入数据的：<bean>标签中的<property>标签
 *          @Autowired:
 *              作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
 *              出现位置：可以在变量上，也可以在方法上
 *              细节：在使用注解注入时，set方法不是必须的。另外Autowired会自动在Spring容器中寻找与类型相匹配的实例，如果有多个可以匹配的实例，则根据成员变量名称匹配。如果都无法匹配，则会报错
 *          @Qualifier：
 *              作用：在按照类中注入的基础之上再按照名称注入。他在给类成员注入时不能单独使用。但是在方法参数注入时可以。
 *              属性：
 *                  value:用于指定注入bean的id
 *          @Resource：
 *              作用：直接按照bean的id注入，可以单独使用
 *              属性：
 *                  name:用于指定bean的id。
 *          以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *          另外，集合类型注入只能通过XML实现。
 *          @Value：
 *              作用：用于注入基本类型和String类型的数据
 *              属性：
 *                  value:用于指定数据的值。它可以使用Spring中SpEL（Spring的el表达式）
 *                        SpEL写法：${表达式}
 *      3.用于改变作用范围的：scope属性
 *          @Scope
 *              作用：用于改变作用范围和bean标签中的scope属性实现的功能一样
 *              属性：指定范围的取值。常用取值：singleton，prototype
 *      4.和生命周期相关的：init-method和destroy-method属性（了解）
 *          @PreDestroy:
 *              作用：用于指定销毁方法
 *          @PostConstruct:
 *              作用：用于指定初始化方法
 */
@Component(value = "accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService{
    // @Autowired
    // @Qualifier("accountDao")   // 给类成员注入时不能单独使用

    @Resource(name = "accountDao")
    private IAccountDao accountDao;
    @Value("测试")
    private String name;

    public String getName() {
        return name;
    }

    public AccountServiceImpl() {
        System.out.println("对象已创建");
    }

    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法");
    }
}
