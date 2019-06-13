package com.cube.service;

import com.cube.bean.Account;
import com.cube.dao.IAccountDao;
import com.cube.utils.TransactionManager;

import java.util.List;

/**
 * @author Cube
 * @className AccountServiceImpl
 * @description
 * @date 2019-06-13 10:29
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3.提交事务
            transactionManager.commitTransaction();
            // 4.返回结果
            return accounts;
        } catch (Exception e) {
            // 5. 回滚操作
            transactionManager.rollbackTransaction();
        } finally {
            // 6.释放连接
            transactionManager.releaseTransaction();
        }
        return null;
    }

    public Account findAccountById(Integer id) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            Account account = accountDao.findAccountById(id);
            // 3.提交事务
            transactionManager.commitTransaction();
            // 4.返回结果
            return account;
        } catch (Exception e) {
            // 5. 回滚操作
            transactionManager.rollbackTransaction();
        } finally {
            // 6.释放连接
            transactionManager.releaseTransaction();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            accountDao.saveAccount(account);
            // 3.提交事务
            transactionManager.commitTransaction();
            // 4.返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            transactionManager.rollbackTransaction();
        } finally {
            // 6.释放连接
            transactionManager.releaseTransaction();
        }
    }

    public void updateAccount(Account account) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            accountDao.updateAccount(account);
            // 3.提交事务
            transactionManager.commitTransaction();
            // 4.返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            transactionManager.rollbackTransaction();
        } finally {
            // 6.释放连接
            transactionManager.releaseTransaction();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            accountDao.deleteAccount(id);
            // 3.提交事务
            transactionManager.commitTransaction();
            // 4.返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            transactionManager.rollbackTransaction();
        } finally {
            // 6.释放连接
            transactionManager.releaseTransaction();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            // 3.提交事务
            transactionManager.commitTransaction();
            // 4.返回结果
        } catch (Exception e) {
            // 5. 回滚操作
            transactionManager.rollbackTransaction();
        } finally {
            // 6.释放连接
            transactionManager.releaseTransaction();
        }
    }
}
