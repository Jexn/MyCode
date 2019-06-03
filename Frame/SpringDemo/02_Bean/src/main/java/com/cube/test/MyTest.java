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

    @Test
    public void springBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 在读取spring配置文件时就已经创建bean对象
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.study();
    }

    @Test
    public void initAndDestroy(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");

        studentService.study();

        ((ClassPathXmlApplicationContext)applicationContext).close();
    }

}
