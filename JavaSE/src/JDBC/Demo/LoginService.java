package JDBC.Demo;

import JDBC.DataBaseUtil.DBUtil;
import JDBC.myJDBC.User;

import java.sql.*;

/**
 * @program: LoginService
 * @description: 登录查询
 * @author: Cube
 * @create: 2019-05-04 15:58
 **/
public class LoginService {
    public static User findUserByNameAndPassword(String name, String password) {
        User user = null;
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("select id,name,password,email,birthday from t_user where name =? And password = ?")
        ) {
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                String user_Password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                user = new User(id, username, email, birthday);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
