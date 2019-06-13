package com.cube.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className Main
 * @description
 * @date 2019-06-12 09:08
 */
public class Main {
    public static void main(String[] args) {
        /*
         * Spring 提供了两种类型的 IOC 容器实现.
         * BeanFactory: IOC 容器的基本实现.
         * ApplicationContext: 提供了更多的高级特性. 是 BeanFactory 的子接口.
         * BeanFactory 是 Spring 框架的基础设施，面向 Spring 本身；ApplicationContext 面向使用 Spring 框架的开发者，几乎所有的应用场合都直接使用 ApplicationContext 而非底层的 BeanFactory
         * 无论使用何种方式, 配置文件时相同的.
         */


        /*
         * ApplicationContext 的主要实现类：
         *      ClassPathXmlApplicationContext：从类路径下加载配置文件
         *      FileSystemXmlApplicationContext: 从文件系统中加载配置文件
         * ConfigurableApplicationContext 扩展于 ApplicationContext，新增加两个主要方法：refresh() 和 close()， 让 ApplicationContext 具有启动、刷新和关闭上下文的能力
         * ApplicationContext 在初始化上下文时就实例化所有单例的 Bean。
         * WebApplicationContext 是专门为 WEB 应用而准备的，它允许从相对于 WEB 根目录的路径中完成初始化工作
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello spring = (Hello) applicationContext.getBean("hello");
        spring.hello();

        Hello test = (Hello) applicationContext.getBean("hello");
        test.hello();
    }
}
