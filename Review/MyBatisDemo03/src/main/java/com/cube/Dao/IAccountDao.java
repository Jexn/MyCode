package com.cube.Dao;

import com.cube.bean.Account;
import com.cube.bean.AccountInfo;

import java.util.List;

public interface IAccountDao {
    List<Account> findAllAccount();

    List<AccountInfo> findAllAccountInfo();

    List<Account> findAllAccountOneByOne();

    Account findById(Integer id);
}
