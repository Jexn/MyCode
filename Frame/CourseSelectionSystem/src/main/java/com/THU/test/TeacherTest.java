package com.THU.test;

import com.THU.bean.Course;
import com.THU.bean.Teacher;
import com.THU.dao.TeacherDao;
import com.THU.util.BatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Cube
 * @className TeacherTest
 * @description 教师类
 * @date 2019-05-17 17:40
 */
public class TeacherTest {
    private TeacherDao teacherDao;
    private SqlSession sqlSession;

    @Before
    public void init(){
        sqlSession = BatisUtils.getSqlSession();
        teacherDao = sqlSession.getMapper(TeacherDao.class);
    }


    // // 新建教师
    // void createTeacher(Teacher teacher);
    @Test
    public void createTeacher(){
        Teacher teacher = new Teacher(10,"赵云","male",32,6);
        teacherDao.createTeacher(teacher);
    }

    // // 根据ID删除教师
    // void deleteTeacher(Integer id);
    @Test
    public void deleteTeacher(){
        teacherDao.deleteTeacher(10);
    }

    // // 更新教师信息
    // void updateTeacher(Teacher teacher);
    @Test
    public void updateTeacher(){
        Teacher teacher = new Teacher(3,40,10);
        teacherDao.updateTeacher(teacher);
    }

    // // 查找教师信息
    // Course getTeacherInfoById(Integer id);
    @Test
    public void getTeacherInfoById(){
        Teacher teacher = teacherDao.getTeacherInfoById(3);
        System.out.println(teacher);
    }
    // // 查找该教师所代课的课程
    // List<Map<Course,Teacher>> getTeacherCoursesById(Integer id);
    @Test
    public void getTeacherCoursesById(){
        List<Map<Course,Teacher>> list = teacherDao.getTeacherCoursesById(3);
        for (Map<Course, Teacher> courseTeacherMap : list) {
            for (Map.Entry<Course,Teacher> map:courseTeacherMap.entrySet()){
                System.out.println(map.getKey()+":"+map.getValue());
            }
        }
    }

    @After
    public void destroy(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
