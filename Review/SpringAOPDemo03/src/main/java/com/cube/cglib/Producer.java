package com.cube.cglib;

/**
 * @author Cube
 * @className Producer
 * @description 生产者
 * @date 2019-06-13 17:22
 */
public class Producer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后服务
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱：" + money);
    }
}
