package com.cube.Test;

import com.cube.bean.Account;
import com.cube.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-06-13 10:55
 */
public class MyTest {
    private IAccountService accountService;

    @Before
    public void before(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = (IAccountService) applicationContext.getBean("accountService");
    }

    @Test
    public void method01(){
        printAll(accountService.findAllAccount());
    }

    @Test
    public void method02(){
        Account account = accountService.findAccountById(4);
        System.out.println(account);
    }

    @Test
    public void method03(){
        Account account = new Account("吴彦祖",23333f);
        accountService.saveAccount(account);
        printAll(accountService.findAllAccount());
    }

    @Test
    public void method04(){
        Account account = new Account(1,"刘德华",66666f);
        accountService.updateAccount(account);
        printAll(accountService.findAllAccount());
    }

    @Test
    public void method05(){
        accountService.deleteAccount(4);
        printAll(accountService.findAllAccount());
    }

    private static void printAll(List<Account> list){
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
