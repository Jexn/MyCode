package com.cube.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Cube
 * @className JDBCTemplateUsage01
 * @description jdbcTemplate最基本用法
 * @date 2019-06-14 15:19
 */
public class JDBCTemplateUsage01 {
    public static void main(String[] args) {
        // 准备数据源，Spring的内置数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("passwd");

        // 创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.execute("INSERT INTO account(name, money) VALUES ('刘亦菲',10000)");
    }
}
