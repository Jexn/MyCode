import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Cube
 * @className C3P0Util
 * @description C3P0连接池
 * @date 2019-05-08 08:52
 */
public class C3P0Util {
    // 获取c3p0的数据源
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 从数据源中获取一个连接对象
    // 获取一个Connection对象，该connection经过c3p0装饰之后的Connection
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接错误");
        }
        return connection;
    }

    // 查看连接池的状态
    public static void poolStatus(){
        try {
            System.out.println("所有连接池数量："+dataSource.getNumConnections());
            System.out.println("空闲数量："+dataSource.getNumIdleConnections());
            System.out.println("忙碌数量："+dataSource.getNumBusyConnections());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
