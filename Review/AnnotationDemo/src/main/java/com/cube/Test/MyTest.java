package com.cube.Test;

import com.cube.bean.Account;
import com.cube.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className MyTest
 * @description
 * @date 2019-06-13 10:55
 */
public class MyTest {
    @Test
    public void method01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        for (Account account : accountService.findAllAccount()) {
            System.out.println(account);
        }

        System.out.println("-----------findAccountById----------------");
        Account account = accountService.findAccountById(2);
        System.out.println(account);

        System.out.println("-------------saveAccount------------------");
        Account addAccount = new Account("老王",1000f);
        accountService.saveAccount(addAccount);
        for (Account account1 : accountService.findAllAccount()) {
            System.out.println(account1);
        }

        System.out.println("-------------deleteAccount------------------");
        accountService.deleteAccount(2);
        for (Account account1 : accountService.findAllAccount()) {
            System.out.println(account1);
        }

        System.out.println("-------------updateAccount------------------");
        Account updateAccountInfo = new Account(3,"周杰伦",20000f);
        accountService.updateAccount(updateAccountInfo);
        for (Account account1 : accountService.findAllAccount()) {
            System.out.println(account1);
        }

    }
}
