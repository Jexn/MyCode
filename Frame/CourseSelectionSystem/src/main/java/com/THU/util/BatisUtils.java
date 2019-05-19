package com.THU.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Cube
 * @className BatisUtils
 * @description MyBatis工具类
 * @date 2019-05-17 11:19
 */
public class BatisUtils {
    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        try {
            if (sqlSessionFactory == null){
                InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
                synchronized (BatisUtils.class){
                    if (sqlSessionFactory == null){
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    }
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return sqlSessionFactory.openSession(true);
    }
}
