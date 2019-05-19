package com.THU.dao;

import com.THU.bean.Course;
import com.THU.bean.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author Cube
 * @className TeacherDao
 * @description 老师信息
 * @date 2019-05-17 10:51
 */
public interface TeacherDao {
    // 新建教师
    void createTeacher(Teacher teacher);

    // 根据ID删除教师
    void deleteTeacher(Integer id);

    // 更新教师信息
    void updateTeacher(Teacher teacher);

    // 查找教师信息
    Teacher getTeacherInfoById(Integer id);

    // 查找该教师所代课的课程
    List<Map<Course,Teacher>> getTeacherCoursesById(Integer id);
}
