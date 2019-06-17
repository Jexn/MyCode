package com.cube.jdbcTemplate;

import com.cube.bean.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Cube
 * @className JDBCTemplateUsage03
 * @description
 * @date 2019-06-14 15:39
 */
public class JDBCTemplateUsage03 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        // 更新
        jdbcTemplate.update("UPDATE account SET name = ? , money = ? WHERE id = ?","刘亦菲",90000,9);

        // 删除
        jdbcTemplate.update("DELETE from account WHERE id = ?",8);

        // 查询
        // List<Account> lists = jdbcTemplate.query("SELECT * FROM account where money > ?",new AccountRowMapper(),1000f);
        List<Account> lists = jdbcTemplate.query("SELECT * FROM account WHERE money > ?",new BeanPropertyRowMapper<>(Account.class),1000f);
        for (Account account : lists) {
            System.out.println(account);
        }
    }
}

/**
 * 定义Account的疯转策略
 */
class AccountRowMapper implements RowMapper<Account>{

    /**
     * 把结果集的数据封装到Account中，然后Spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}