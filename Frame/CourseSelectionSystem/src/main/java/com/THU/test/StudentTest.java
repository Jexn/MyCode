package com.THU.test;

import com.THU.bean.Student;
import com.THU.bean.Teacher;
import com.THU.dao.CourseDao;
import com.THU.dao.StudentDao;
import com.THU.dao.TeacherDao;
import com.THU.util.BatisUtils;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Cube
 * @className StudentTest
 * @description MyBatis测试类
 * @date 2019-05-17 11:24
 */
public class StudentTest {
    private StudentDao studentDao;
    private SqlSession sqlSession;

    @Before
    public void before() {
        sqlSession = BatisUtils.getSqlSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    @Test
    public void createStudent() {
        Student student = new Student(919, "王松", 24, "male", 4, 23, 85);
        studentDao.createStudent(student);
    }

    // 根据ID删除学生
    // void deleteStudentById(Integer id);
    @Test
    public void deleteStudent() {
        studentDao.deleteStudentById(919);
    }
    // // 根据学生姓名查找学生
    // Student getStudentByName(String name);

    @Test
    public void getStudentByName() {
        List<Student> students = studentDao.getStudentByName("汪");
        students.forEach(System.out::println);
    }

    // // 根据学生ID查找学生
    // Student getStudentById(Integer id);
    @Test
    public void getStudentById() {
        List<Student> students = studentDao.getStudentById(10);
        students.forEach(System.out::println);
        System.out.println(JSON.toJSONString(students));
    }

    // // 获取所有学生信息
    // List<Student> getAllStudent();
    @Test
    public void getAllStudent() {
        List<Student> students = studentDao.getAllStudent();
        String jsonStr = JSON.toJSONString(students);
        System.out.println(jsonStr);
    }

    // // 根据ID修改学生信息
    // void updateStudentInfo(Student student);
    @Test
    public void updateStudentInfo() {
        Student student = new Student(18, 2198, 61);
        studentDao.updateStudentInfo(student);
    }

    // // 根据ID查找学生的课程成绩
    // Map<String,Integer> getScoreByID(Integer id);
    @Test
    public void getScoreByID() {
        List<Map<String, Integer>> list = studentDao.getScoreByID(10);
        for (Map<String, Integer> map : list) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
        System.out.println(JSON.toJSONString(list));
    }

    @After
    public void after() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
