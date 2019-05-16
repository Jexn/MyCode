package com.cube.bean;

/**
 * @author Cube
 * @className School
 * @description
 * @date 2019-05-11 19:19
 */
public class School {
    private String school_name;
    private String local;

    public School(String school_name, String local) {
        this.school_name = school_name;
        this.local = local;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "School{" +
                "school_name='" + school_name + '\'' +
                ", local='" + local + '\'' +
                '}';
    }

}
