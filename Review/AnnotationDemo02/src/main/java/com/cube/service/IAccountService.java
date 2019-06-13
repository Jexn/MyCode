package com.cube.service;

import com.cube.bean.Account;

import java.util.List;

/**
 * @author Cube
 * @className IAccountService
 * @description 账户业务层接口
 * @date 2019-06-13 10:24
 */
public interface IAccountService {
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

}
