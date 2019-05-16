package com.cube.test;
import com.cube.bean.Student;
import com.cube.dao.StudentDao;
import com.cube.dao.impl.StudentDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Cube
 * @className StudentTest
 * @description
 * @date 2019-05-15 10:47
 */
public class StudentTest {

    private StudentDao studentDao;

    @Before
    public void initStudentDao(){
        studentDao = new StudentDaoImpl();
    }

    @Test
    public void insertStudent(){
        Student student = new Student("刘德华",30,89);
        System.out.println(student);
        studentDao.insertStudent(student);
        System.out.println(student);
    }

    @Test
    public void deleteStudent(){
        studentDao.deleteStudent(6);
    }

    @Test
    public void updateStudent(){
        Student student = new Student("蔡徐坤",30,3);
        student.setId(8);
        studentDao.updateStudent(student);
    }

    @Test
    public void selectAllStudents(){
        List<Student> list = studentDao.selectAllStudent();
        list.forEach(System.out::println);
    }

    @Test
    public void selectStudentById(){
        Student student = studentDao.selectStudentByID(8);
        System.out.println(student);
    }

    @Test
    public void selectStudentByName(){
        List<Student> list = studentDao.selectStudentsByName("马");
        list.forEach(System.out::println);
    }
}
