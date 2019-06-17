import com.cube.Dao.IAccountDao;
import com.cube.Dao.IUserDao;
import com.cube.bean.Account;
import com.cube.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * TODO：
 * author：Cube
 * create：2019-06-17 15:56
 */
public class MyTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @Test
    public void findAllAccount(){
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void findAllUser(){
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        inputStream.close();
    }
}
