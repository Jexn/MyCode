package com.cube.dao;

import com.cube.bean.Student;

import java.util.List;

/**
 * @author Cube
 * @className StudentDao
 * @description
 * @date 2019-05-15 09:09
 */
public interface StudentDao {
    void insertStudent(Student student);
    void deleteStudent(int id);
    void updateStudent(Student student);
    List<Student> selectAllStudent();
    Student selectStudentByID(int id);
    List<Student> selectStudentsByName(String name);
}
