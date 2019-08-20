package com.cube.service.Impl;

import com.cube.bean.Account;
import com.cube.dao.AccountDao;
import com.cube.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }
}
