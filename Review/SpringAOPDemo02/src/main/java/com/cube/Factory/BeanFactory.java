package com.cube.Factory;

import com.cube.bean.Account;
import com.cube.service.AccountServiceImpl;
import com.cube.service.IAccountService;
import com.cube.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Cube
 * @className BeanFactory
 * @description
 * @date 2019-06-13 18:42
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;


    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService(){
        return (AccountServiceImpl) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    // 1.开启事务
                    transactionManager.beginTransaction();
                    // 2.执行操作
                    returnValue = method.invoke(accountService,args);
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
                return returnValue;
            }
        });
    }
}
