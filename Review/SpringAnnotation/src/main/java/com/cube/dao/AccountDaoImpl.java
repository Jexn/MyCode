package com.cube.dao;

import org.springframework.stereotype.Repository;

/**
 * @author Cube
 * @className AccountDaoImpl
 * @description
 * @date 2019-06-13 08:24
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements IAccountDao {
    public AccountDaoImpl() {
    }

    public void saveAccount() {
        System.out.println("账户保存了");
    }
}
