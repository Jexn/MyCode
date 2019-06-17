package Test;

import com.cube.Dao.IAccountDao;
import com.cube.Dao.IUserDao;
import com.cube.bean.Account;
import com.cube.bean.AccountInfo;
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
 * create：2019-06-17 09:54
 */
public class MyTest {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Before
    public void init() throws IOException {
        inputStream  = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @Test
    public void findAllAccount(){
        List<Account> accountList = accountDao.findAllAccount();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void findAllAccountInfo(){
        List<AccountInfo> accountInfoList = accountDao.findAllAccountInfo();
        for (AccountInfo accountInfo : accountInfoList) {
            System.out.println(accountInfo);
        }
    }

    @Test
    public void oneByOne(){
        List<Account> accounts = accountDao.findAllAccountOneByOne();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        inputStream.close();
    }
}
