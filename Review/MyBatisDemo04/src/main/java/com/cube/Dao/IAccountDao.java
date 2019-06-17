package com.cube.Dao;

import com.cube.bean.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAllAccount();

    Account findAccountById(Integer id);
}
