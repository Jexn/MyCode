package com.cube.service;

import org.springframework.stereotype.Service;

/**
 * @author Cube
 * @className AccountServiceImpl
 * @description
 * @date 2019-06-13 10:29
 */
@Service("accountService")

public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("保存账户");
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("更新用户");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }
}
