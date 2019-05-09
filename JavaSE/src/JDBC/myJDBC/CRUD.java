package JDBC.myJDBC;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: CRUD
 * @description: 增删改查JDBC
 * @author: Cube
 * @create: 2019-05-04 11:14
 **/
public class CRUD {
    public static Connection connection = null;
    public static Statement statement = null;

    public static Statement getStatement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT%2B8", "root", "passwd");
            statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return statement;
    }

    @Test
    public void insert() throws SQLException {
        statement = getStatement();
        statement.executeUpdate("INSERT INTO t_user(name,password,birthday) values ('root','root','1990-09-09')");
        statement.close();
    }

    @Test
    public void update() throws SQLException {
        statement = getStatement();
        statement.executeUpdate("update t_user set email='cubeto@qq.com' where id=4");
        statement.close();
    }

    @Test
    public void delete() throws SQLException {
        statement = getStatement();
        statement.executeUpdate("delete from t_user where id='1'");
        statement.close();
    }

    @Test
    public void query() throws SQLException {
        statement = getStatement();
        ResultSet resultSet = statement.executeQuery("select * from t_user");
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("name");
            Date date = resultSet.getDate("birthday");

            list.add(new User(id, name, password, date));
        }

        for (User user : list) {
            System.out.println(user);
        }
        statement.close();
    }
}
