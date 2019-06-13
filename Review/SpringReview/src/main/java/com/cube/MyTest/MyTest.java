package com.cube.MyTest;

import com.cube.Service.IAccountService;
import com.cube.bean.Person;
import com.cube.dao.IAccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-06-12 16:38
 */
public class MyTest {
    @Test
    public void method01() {
        /**
         * ApplicationContext的三个常用实现类
         *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。否则无法加载
         *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须要有访问权限）
         *      AnnotationConfigApplicationContext：读取注解创建容器
         *
         * 核心容器的两个接口引出的问题
         * ApplicationContext：
         *      它在构建核心容器时，创建对象采用的策略是采用立即加载的方式。也就是说，只要一读取完配置文件，马上就会创建配置文件中的对象。可以使用构造器验证
         * BeanFactory：
         *      它在构建核心容器时，创建对象采用的策略是采用延迟加载的方式，什么时候根据id获取对象，什么时候才真正的创建对象
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountDao.saveAccount();
        accountService.saveAccount();
    }

    @Test
    public void getBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "bean.xml");
        Person person = (Person) applicationContext.getBean("personFactoryBean");
        System.out.println(person);
    }

    @Test
    public void staticFactoryBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "bean.xml");
        Person person = (Person) applicationContext.getBean("staticFactoryBean");
        System.out.println(person);
    }

    @Test
    public void scopeBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "bean.xml");

        // 多例：scope = "prototype"
        Person person = (Person) applicationContext.getBean("personScope");
        Person person1 = (Person) applicationContext.getBean("personScope");
        System.out.println(person == person1);
    }

    @Test
    public void beanLift() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "bean.xml");
        Person person = (Person) applicationContext.getBean("personLift");
        System.out.println(person);

        // 手动关闭
        applicationContext.close();
    }
}
