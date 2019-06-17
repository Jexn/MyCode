package com.cube.Test;

import com.cube.Dao.IUserDao;
import com.cube.bean.QueryVO;
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
import java.util.Date;
import java.util.List;

/**
 * @Name MyTest
 * @Description
 * @User Cube
 * @Time 2019-06-15 10:06
 */
public class MyTest {
    private SqlSession session;
    private InputStream in;
    private IUserDao userDao;

    @Before
    public void getSession() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("MyBatisConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);

    }

    @Test
    public void method01() {
        //5.使用代理对象执行方法
        List<User> users = userDao.findAllUser();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void method02(){
        User user = new User();
        user.setUserName("老王");
        user.setAddress("上海");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.saveUser(user);
        session.commit();
    }

    @Test
    public void method03(){
        User user = new User(45,"Update",new Date(),"男","广州");
        userDao.updateUser(user);
        session.commit();
    }

    @Test
    public void method04(){
        userDao.deleteUser(51);
        session.commit();
    }

    @Test
    public void findByID(){
        User user = userDao.findUserById(45);
        System.out.println(user);
    }

    /**
     * 模糊查询注意加%p%
     */
    @Test
    public void findByName(){
        // List<User> users = userDao.findUserByName("王");
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findAllNum(){
        int count = userDao.findAllNum();
        System.out.println(count);
    }

    /**
     * 结果集对象查询
     */
    @Test
    public void queryVOFind(){
        QueryVO queryVO = new QueryVO();
        User user = new User();
        user.setUserName("%王%");
        queryVO.setUser(user);
        List<User> users = userDao.findUserByQueryVO(queryVO);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @After
    public void after() throws IOException {
        session.close();
        in.close();
    }
}
