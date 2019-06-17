package com.cube.dao;

import com.cube.bean.Account;

/**
 * @author Cube
 * @className IAccountDao
 * @description
 * @date 2019-06-14 16:08
 */
public interface IAccountDao {
    /**
     * 根据ID查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据姓名查询账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
