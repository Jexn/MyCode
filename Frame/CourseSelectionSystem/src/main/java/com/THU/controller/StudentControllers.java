package com.THU.controller;

import com.THU.bean.Student;
import com.THU.dao.StudentDao;
import com.THU.util.BatisUtils;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Cube
 * @className StudentControllers
 * @description 学生信息请求
 * @date 2019-05-18 10:14
 */
@RestController
@RequestMapping("/Student/")
public class StudentControllers {
    private StudentDao studentDao;
    private SqlSession sqlSession;

    {
        sqlSession = BatisUtils.getSqlSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    // 新增学生
    // void createStudent(Student student);
    @PostMapping("addStudents")
    public String createStudent(@RequestBody Student student){
        System.out.println(student);
        studentDao.createStudent(student);
        return JSON.toJSONString("success");
    }
    // // 根据ID和课程信息修改学生成绩
    // void updateStudentInfo(Student student);
    @PostMapping("updateStudents")
    public String updateStudentInfo(@RequestBody Student student){
        studentDao.updateStudentInfo(student);
        return JSON.toJSONString("success");
    }
    // // 获取所有学生信息
    // List<Student> getAllStudent();
    @GetMapping("getStudents")
    public String findAllStudents(){
        List<Student> studentList = studentDao.getAllStudent();
        return JSON.toJSONString(studentList);
    }
    // // 根据学生ID查找学生
    // List<Student> getStudentById(Integer id);
    @GetMapping("getStudent/{id}")
    public String getStudentById(@PathVariable Integer id){
        List<Student> students = studentDao.getStudentById(id);
        return JSON.toJSONString(students);
    }
    // // 根据ID删除学生
    // void deleteStudentById(Integer id);
    @DeleteMapping("student/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        studentDao.deleteStudentById(id);
        return JSON.toJSONString("success");
    }
    // // 根据学生姓名查找学生
    // List<Student> getStudentByName(String name);
    @GetMapping("students/{name}")
    public String getStudentByName(@PathVariable String name){
        List<Student> students = studentDao.getStudentByName(name);
        return JSON.toJSONString(students);
    }

    // // 根据ID查找学生的课程成绩
    // List<Map<String,Integer>> getScoreByID(Integer id);
    @GetMapping("studentScore/{id}")
    public String getScoreByID(@PathVariable Integer id){
        List<Map<String,Integer>> list = studentDao.getScoreByID(id);
        return JSON.toJSONString(list);
    }

}
