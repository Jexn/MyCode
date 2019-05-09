package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @program: DBUtil
 * @description: Books查询工具
 * @author: Cube
 * @create: 2019-05-05 14:47
 **/
public class DBUtil {
    private static String driverClass = null;
    private static String url = null;
    private static String name = null;
    private static String password= null;

    static {
        ResourceBundle resourceBundle =ResourceBundle.getBundle("Dao/db");
        driverClass = resourceBundle.getString("driverClass");
        url = resourceBundle.getString("url");
        name = resourceBundle.getString("username");
        password = resourceBundle.getString("password");

        try {
            Class.forName(driverClass);
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,password);
    }
}
