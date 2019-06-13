package com.cube.proxy;

/**
 * @author Cube
 * @className IProducer
 * @description
 * @date 2019-06-13 17:24
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后服务
     * @param money
     */
    public void afterService(float money);
}
