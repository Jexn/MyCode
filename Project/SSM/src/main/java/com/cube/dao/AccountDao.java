package com.cube.dao;

import com.cube.bean.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

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
