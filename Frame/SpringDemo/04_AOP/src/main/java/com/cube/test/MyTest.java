package com.cube.test;

import com.cube.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-05-21 11:49
 */
public class MyTest {
    @Test
    public void notifyAop() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.addUser();

        // userService.deleteUser();

        // userService.selectUser();

        // userService.selectUserById(0);

        // userService.updateUser();
    }
}
