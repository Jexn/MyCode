package JDBC.DataBaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @program: DBUtil
 * @description: 数据库连接
 * @author: Cube
 * @create: 2019-05-04 15:46
 **/
public class DBUtil {
    private static String driverClass = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("JDBC/DataBaseUtil/db");
        driverClass = resourceBundle.getString("driverClass");
        url = resourceBundle.getString("url");
        username = resourceBundle.getString("username");
        password = resourceBundle.getString("password");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
