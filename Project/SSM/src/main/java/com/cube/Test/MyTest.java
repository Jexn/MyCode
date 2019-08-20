package com.cube.Test;

import com.cube.bean.Account;
import com.cube.dao.AccountDao;
import com.cube.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void serviceTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.findAllAccount();
    }

    @Test
    public void MyBatisTest() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("MyBatis-Config.xml");
        // 创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        // 查询
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

        sqlSession.close();
        in.close();
    }

    @Test
    public void saveAccount() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("MyBatis-Config.xml");
        // 创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        // 保存
        Account account = new Account();
        account.setName("陈友谅");
        account.setMoney(800.05);
        accountDao.addAccount(account);

        // 增删改必须提交事务
        sqlSession.commit();

        // 关闭
        sqlSession.close();
        in.close();
    }
}
