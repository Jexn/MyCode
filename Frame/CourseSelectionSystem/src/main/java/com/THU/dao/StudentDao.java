package com.THU.dao;

import com.THU.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    // 新增学生
    void createStudent(Student student);

    // 根据ID删除学生
    void deleteStudentById(Integer id);

    // 根据学生姓名查找学生
    List<Student> getStudentByName(String name);

    // 根据学生ID查找学生
    List<Student> getStudentById(Integer id);

    // 获取所有学生信息
    List<Student> getAllStudent();

    // 根据ID和课程信息修改学生成绩
    void updateStudentInfo(Student student);

    // 根据ID查找学生的课程成绩
    List<Map<String,Integer>> getScoreByID(Integer id);
}
