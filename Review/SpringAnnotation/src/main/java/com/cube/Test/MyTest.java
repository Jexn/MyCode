package com.cube.Test;

import com.cube.dao.AccountDaoImpl;
import com.cube.dao.IAccountDao;
import com.cube.service.AccountServiceImpl;
import com.cube.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-06-13 08:30
 */
public class MyTest {
    @Test
    public void method01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        accountService.saveAccount();
        System.out.println(accountService.getName());
        // System.out.println(accountService);
        // IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
        // accountDao.saveAccount();
    }

    @Test
    public void method02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        AccountServiceImpl accountService1 = (AccountServiceImpl) applicationContext.getBean("accountService");
        System.out.println(accountService == accountService1);
    }

    @Test
    public void method03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) applicationContext.getBean("accountService");
        accountService.saveAccount();
        applicationContext.close();
    }
}
