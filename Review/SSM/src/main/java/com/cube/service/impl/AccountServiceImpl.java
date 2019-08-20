package com.cube.service.impl;

import com.cube.bean.Account;
import com.cube.dao.AccountDao;
import com.cube.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO：
 * author：Cube
 * create：2019-06-30 09:07
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层保存账户");
        accountDao.saveAccount(account);
    }
}
