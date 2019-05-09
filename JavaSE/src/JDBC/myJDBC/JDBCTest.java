package JDBC.myJDBC;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class JDBCTest {
    // 1.注册驱动
    // 2. 获取连接Connection
    // 3. 得到执行sql语句的对象Statement
    // 4. 执行sql语句，并返回结果
    // 5. 处理结果
    // 6. 关闭Connection

    public static Connection connection = null;
    public static Statement statement = null;

    private static Statement getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8", "root", "passwd");
            statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 创建sql语句语句
        return statement;
    }

    @Test
    public void executeQuery() throws SQLException {
        statement = getConnection();
        // 执行sql查询语句并得到结果集
        ResultSet resultSet = statement.executeQuery("SELECT * FROM t_user");
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("name"));
            System.out.println(resultSet.getObject("password"));
            System.out.println(resultSet.getObject("email"));
            System.out.println(resultSet.getObject("birthday"));
            System.out.println("------------");
        }
        resultSet = statement.executeQuery("select id from t_user");
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("id"));
        }
        resultSet.close();
        statement.close();
    }

    // 断言测试
    @Test
    public void method1() {
        Assert.assertEquals(16, MyCalculator.add(5, 11));
    }

    // 浮动范围测试
    @Test
    public void method2() {
        Assert.assertEquals(2, MyCalculator.divide(10, 4), 0.15);
    }
}
