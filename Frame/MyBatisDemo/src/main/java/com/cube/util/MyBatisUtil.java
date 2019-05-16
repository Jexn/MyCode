package com.cube.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Cube
 * @className MyBatisUtil
 * @description MyBatis工具类
 * @date 2019-05-15 11:37
 */
public class MyBatisUtil {
    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        try {
            if (sqlSessionFactory == null){
                InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
                synchronized (MyBatisUtil.class){
                    if (sqlSessionFactory == null){
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession();
    }
}
