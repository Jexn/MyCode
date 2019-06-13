package com.cube.UI;

import com.cube.Service.IAccountService;
import com.cube.Service.impl.AccountServiceImpl;

/**
 * @author Cube
 * @className Client
 * @description 模拟一个表现层，用于调用业务层
 * @date 2019-06-12 15:21
 */
public class Client {
    public static void main(String[] args) {
        IAccountService service = new AccountServiceImpl();
        service.saveAccount();
    }
}
