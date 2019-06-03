package com.cube.test;

import com.cube.service.StudentService;
import com.cube.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-05-20 09:16
 */
public class MyTest {
    /**
     * 以前的写法
     */
    @Test
    public void springTest01(){
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.study();
    }

    /**
     * Spring写法
     */
    @Test
    public void springTest02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 在读取spring配置文件时就已经创建bean对象
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.study();
    }

    /**
     * BeanFactory和ApplicationContext区别：
     * 1. ApplicationContext在使用时会将applicationContext.xml容器中的对象先创建好；
     * 2. BeanFactory只在你使用的时候创建对象；
     */
    @Test
    public void beanFactory(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new FileSystemResource("F:\\MyCode\\Frame\\SpringDemo\\01_FirstSpringDemo\\src\\main\\resources\\applicationContext.xml"));

        // 在使用bean时才会创建对象
        StudentService studentService = (StudentService) factory.getBean("studentService");
        studentService.study();
    }
}
