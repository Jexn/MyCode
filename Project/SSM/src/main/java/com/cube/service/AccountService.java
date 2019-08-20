package com.cube.service;

import com.cube.bean.Account;

import java.util.List;

public interface AccountService {
    /**
     * 保存账户
     * @param account
     */
    void addAccount(Account account);

    /**
     * 查询所有账户
     * @return 返回所有账户
     */
    List<Account> findAllAccount();
}
