package com.THU.bean;

import java.util.List;
import java.util.Map;

/**
 * @author Cube
 * @className Student
 * @description 学生类
 * @date 2019-05-17 10:32
 */
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Integer grade;
    private Integer course_id;
    private Integer score;
    private List<Course> courses;

    public Student() {
    }

    public Student(Integer id, String name, Integer course_id, Integer score) {
        this.id = id;
        this.name = name;
        this.course_id = course_id;
        this.score = score;
    }

    public Student(Integer id, Integer course_id, Integer score) {
        this.id = id;
        this.course_id = course_id;
        this.score = score;
    }

    public Student(Integer id, String name, Integer age, String sex, Integer grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
    }

    public Student(Integer id, String name, Integer age, String sex, Integer grade, Integer course_id, Integer score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
        this.course_id = course_id;
        this.score = score;
    }

    public Student(Integer id, String name, Integer age, String sex, Integer grade, Integer course_id, Integer score, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
        this.course_id = course_id;
        this.score = score;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", grade=" + grade +
                ", course_id=" + course_id +
                ", score=" + score +
                '}';
    }
}
