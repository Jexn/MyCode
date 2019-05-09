package JDBC.myJDBC;

import JDBC.DataBaseUtil.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: JDBCAutoClose
 * @description: 自动关闭
 * @author: Cube
 * @create: 2019-05-04 15:34
 **/
public class JDBCAutoClose {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DBUtil.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_user");
            List<User> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date date = resultSet.getDate("birthday");

                list.add(new User(id, name, email, date));
            }
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
