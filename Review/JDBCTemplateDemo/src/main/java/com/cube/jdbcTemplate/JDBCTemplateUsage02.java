package com.cube.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Cube
 * @className JDBCTemplateUsage02
 * @description
 * @date 2019-06-14 15:33
 */
public class JDBCTemplateUsage02 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        jdbcTemplate.execute("INSERT INTO account(name, money) VALUES ('迪丽热巴',10000)");
    }
}
