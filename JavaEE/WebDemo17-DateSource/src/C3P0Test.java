import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Cube
 * @className C3P0Test
 * @description 测试类
 * @date 2019-05-08 09:02
 */
public class C3P0Test {
    @Test
    public void method() throws InterruptedException {
        insert();
        Thread.sleep(1000);
        C3P0Util.poolStatus();
    }

    public static void insert() {
        try (
                Connection connection = C3P0Util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user(id,name) values ('1005','jack')");
        ) {
            // 查看c3p0状态
            C3P0Util.poolStatus();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
