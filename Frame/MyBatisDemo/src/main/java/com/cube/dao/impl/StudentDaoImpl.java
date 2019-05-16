package com.cube.dao.impl;

import com.cube.bean.Student;
import com.cube.dao.StudentDao;
import com.cube.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Cube
 * @className StudentDaoImpl
 * @description
 * @date 2019-05-15 10:29
 */
public class StudentDaoImpl implements StudentDao {

    private SqlSession sqlSession;

    @Override
    public void insertStudent(Student student) {
        try {
            //读取主配置文件
            InputStream input = Resources.getResourceAsStream("MyBatis.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(input);
            //创建SqlSession对象
            sqlSession = sessionFactory.openSession();
            //新增数据操作
            sqlSession.insert("insertStudent", student);
            //提交SqlSession
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.delete("deleteStudent", id);
        sqlSession.commit();

    }

    @Override
    public void updateStudent(Student student) {
        sqlSession = MyBatisUtil.getSqlSession();
        sqlSession.update("updateStudent",student);
        sqlSession.commit();
    }

    @Override
    public List<Student> selectAllStudent() {
        sqlSession = MyBatisUtil.getSqlSession();
        List<Student> students = null;
        students = sqlSession.selectList("selectAllStudent");
        sqlSession.commit();
        return students;
    }

    @Override
    public Student selectStudentByID(int id) {
        sqlSession = MyBatisUtil.getSqlSession();
        Student student = sqlSession.selectOne("selectStudentById",id);
        sqlSession.commit();
        return student;
    }

    @Override
    public List<Student> selectStudentsByName(String name) {
        sqlSession = MyBatisUtil.getSqlSession();
        List<Student> students = null;
        students = sqlSession.selectList("selectStudentByName",name);
        sqlSession.commit();
        return students;
    }
}
