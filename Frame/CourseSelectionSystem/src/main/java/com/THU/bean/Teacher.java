package com.THU.bean;

/**
 * @author Cube
 * @className Teacher
 * @description 教室类
 * @date 2019-05-17 10:36
 */
public class Teacher {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Integer Seniority;

    public Teacher(Integer id, String name, String sex, Integer age, Integer seniority) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        Seniority = seniority;
    }

    public Teacher(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher(Integer id, Integer age, Integer seniority) {
        this.id = id;
        this.age = age;
        Seniority = seniority;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSeniority() {
        return Seniority;
    }

    public void setSeniority(Integer seniority) {
        Seniority = seniority;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", Seniority=" + Seniority +
                '}';
    }
}
