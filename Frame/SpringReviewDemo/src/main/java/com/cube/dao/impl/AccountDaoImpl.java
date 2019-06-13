package com.cube.dao.impl;

import com.cube.dao.IAccountDao;

/**
 * @author Cube
 * @className AccountDaoImpl
 * @description 持久层实现
 * @date 2019-06-12 15:20
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了数据");
    }
}
