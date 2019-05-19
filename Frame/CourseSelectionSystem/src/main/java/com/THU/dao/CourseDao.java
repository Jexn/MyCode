package com.THU.dao;

import com.THU.bean.Course;
import com.THU.bean.Student;

import java.util.List;

public interface CourseDao {
    // 新建课程
    void createCourse(Course course);

    // 根据课程ID删除课程
    void deleteCourse(Integer id);

    // 根据ID查找该课程信息
    Course getCourseById(Integer id);

    // 查找选修该课程的所有学生
    List<Student> getStudentsByCourseId(Integer id);

    // 更新课程信息
    void updateCourseInfo(Course course);
}
