package JDBC.myJDBC;

import JDBC.DataBaseUtil.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @program: CRUDEnhance
 * @description: CRUD增强
 * @author: Cube
 * @create: 2019-05-04 16:42
 **/
public class CRUDEnhance {

    @Test
    public void create() {
        String name = "老赵";
        String password = "laozhao";
        String email = "laozhao@qq.com";
        String birthday = "1991-09-19";

        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO t_user(name, password, email, birthday) values (?,?,?,?)");
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, birthday);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE t_user set email=? where id = ?");
        ) {
            preparedStatement.setString(1, "root@qq.com");
            preparedStatement.setString(2, "5");
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void query() {
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from t_user where id=?");
        ) {
            preparedStatement.setString(1, "2");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Date birthday = resultSet.getDate("birthday");
                user = new User(id, name, password, birthday);
            }
            System.out.println(user);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE from t_user where id = ?");
        ) {
            preparedStatement.setString(1,"5");
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
