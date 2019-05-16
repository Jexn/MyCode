package com.cube.bean;

/**
 * @author Cube
 * @className User
 * @description
 * @date 2019-05-11 09:14
 */
public class User {
    private String name;
    private String sex;
    private int age;
    private String email;
    private String phone;
    private Location location;

    public User() {
    }

    public User(String name, String sex, int age, String email, String phone) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public User(String name, String sex, int age, String email, String phone, Location location) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
