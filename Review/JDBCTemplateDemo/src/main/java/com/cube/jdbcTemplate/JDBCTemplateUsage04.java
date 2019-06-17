package com.cube.jdbcTemplate;

import com.cube.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cube
 * @className JDBCTemplateUsage04
 * @description
 * @date 2019-06-14 16:20
 */
public class JDBCTemplateUsage04 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao.findAccountById(9));
    }
}
