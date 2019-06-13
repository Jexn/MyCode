package com.cube.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Cube
 * @className ConnectionUtils
 * @description 连接的工具类，用于从数据源中获取一个连接，并且实现和线程绑定
 * @date 2019-06-13 16:33
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     *
     * @return
     */
    public Connection getThreadConnection() {
        // 1. 从ThreadLocal上获取
        Connection connection = connectionThreadLocal.get();
        // 2. 判断当前线程上是否有连接
        try {
            if (connection == null) {
                // 3. 从数据源中获取一个连接，并且存入ThreadLocal中
                connection = dataSource.getConnection();
                connectionThreadLocal.set(connection);
            }
            // 4. 返回当前线程上的连接
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        connectionThreadLocal.remove();
    }
}
