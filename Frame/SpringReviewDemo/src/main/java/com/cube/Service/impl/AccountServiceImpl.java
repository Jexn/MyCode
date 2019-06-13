package com.cube.Service.impl;

import com.cube.Service.IAccountService;
import com.cube.dao.IAccountDao;
import com.cube.dao.impl.AccountDaoImpl;

/**
 * @author Cube
 * @className AccountServiceImpl
 * @description
 * @date 2019-06-12 15:16
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
