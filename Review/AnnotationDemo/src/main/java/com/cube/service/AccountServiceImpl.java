package com.cube.service;

import com.cube.bean.Account;
import com.cube.dao.IAccountDao;

import java.util.List;

/**
 * @author Cube
 * @className AccountServiceImpl
 * @description
 * @date 2019-06-13 10:29
 */
public class AccountServiceImpl implements IAccountService{
    private IAccountDao accountDao;

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
