package com.THU.bean;

import java.util.List;

/**
 * @author Cube
 * @className Course
 * @description 课程类
 * @date 2019-05-17 10:34
 */
public class Course {
    private Integer id;
    private String name;
    private Integer teacher_id;
    private List<Student> students;

    public Course(Integer id, String name, Integer teacher_id, List<Student> students) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
        this.students = students;
    }

    public Course(Integer id, String name, Integer teacher_id) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher_id=" + teacher_id +
                ", students=" + students +
                '}';
    }
}
