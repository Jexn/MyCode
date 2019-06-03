package com.cube.test;

import com.cube.bean.User;
import com.cube.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-05-20 09:16
 */
public class MyTest {

    @Test
    public void DI01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.showUser();
    }

    @Test
    public void DI02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.showUser();
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }

    @Test
    public void DI03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        UserService userService1 = (UserService) context.getBean("userService");
        System.out.println(userService);
        System.out.println(userService1);
        System.out.println(userService == userService1);
    }
}
