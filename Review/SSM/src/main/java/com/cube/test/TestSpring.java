package com.cube.test;

import com.cube.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * TODO：
 * author：Cube
 * create：2019-06-30 09:14
 */
public class TestSpring {
    @Test
    public void testService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.findAll();
    }

}
