package com.THU.test;

import com.THU.bean.Course;
import com.THU.bean.Student;
import com.THU.dao.CourseDao;
import com.THU.util.BatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Cube
 * @className CourseTest
 * @description 课程类测试
 * @date 2019-05-17 16:46
 */
public class CourseTest {
    private CourseDao courseDao;
    private SqlSession sqlSession;

    @Before
    public void init(){
        sqlSession = BatisUtils.getSqlSession();
        courseDao = sqlSession.getMapper(CourseDao.class);
    }

    // // 新建课程
    // void createCourse(Course course);
    //
    // // 根据课程ID删除课程
    // void deleteCourse(Integer id);
    //
    // // 根据ID查找该课程信息
    // Course getCourseById(Integer id);
    //
    // // 查找选修该课程的所有学生
    // List<Student> getStudentsByCourseId(Integer id);
    //
    // // 更新课程信息
    // void updateCourseInfo(Course course);
    @Test
    public void createCourse(){
        Course course = new Course(1000,"Java编程实现",1);
        courseDao.createCourse(course);
    }

    @Test
    public void deleteCourse(){
        courseDao.deleteCourse(1000);
    }

    @Test
    public void getCourseById(){
        Course course = courseDao.getCourseById(23);
        System.out.println(course);
    }

    @Test
    public void getStudentsByCourseId(){
        List<Student> students = courseDao.getStudentsByCourseId(23);
        System.out.println(students);
    }

    @Test
    public void updateCourseInfo(){
        Course course = new Course(23,"高等数学（工本）",4);
        courseDao.updateCourseInfo(course);
    }

    @After
    public void destroy(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

}
