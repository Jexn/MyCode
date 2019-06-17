package com.cube.dao;

import com.cube.bean.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author Cube
 * @className AccountDao
 * @description
 * @date 2019-06-14 16:10
 */

public class AccountDao extends JdbcDaoSupport implements IAccountDao {

    // 这种方式可以在使用注解时继续使用，继承JdbcDaoSupport方式则会变得很麻烦
    // private JdbcTemplate jdbcTemplate;
    //
    // public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = super.getJdbcTemplate().query("SELECT * FROM account WHERE id = ?", new BeanPropertyRowMapper<>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("SELECT * FROM account WHERE name = ?", new BeanPropertyRowMapper<>(Account.class),name);
        if (accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("UPDATE account set name = ?,money = ? WHERE id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
