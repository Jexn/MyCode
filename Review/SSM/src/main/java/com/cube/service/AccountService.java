package com.cube.service;

import com.cube.bean.Account;

import java.util.List;

/**
 * TODO：
 * author：Cube
 * create：2019-06-30 09:06
 */
public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    public void saveAccount(Account account);
}
