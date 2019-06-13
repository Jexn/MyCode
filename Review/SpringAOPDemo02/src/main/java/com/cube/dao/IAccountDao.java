package com.cube.dao;

import com.cube.bean.Account;

import java.util.List;

/**
 * @author Cube
 * @className IAccountDao
 * @description
 * @date 2019-06-13 10:30
 */
public interface IAccountDao {
    // 查找所有用户
    List<Account> findAllAccount();

    // 根据ID查找
    Account findAccountById(Integer id);

    // 保存用户
    void saveAccount(Account account);

    // 更新用户
    void updateAccount(Account account);

    // 根据ID删除用户
    void deleteAccount(Integer id);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的一个结果就返回，如果没有结果返回null,如果结果集超过一个就抛出异常
     */
    Account findAccountByName(String accountName);
}
