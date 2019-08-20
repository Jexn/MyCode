package com.cube.spring_boot_demo01.dao;

/**
 * TODO：
 * author：Cube
 * create：2019-07-03 08:19
 */
public class User {
    private Integer id;
    private String account_id;
    private String name;
    private String token;
    private Long GMT_Create;
    private Long GMT_Modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGMT_Create() {
        return GMT_Create;
    }

    public void setGMT_Create(Long GMT_Create) {
        this.GMT_Create = GMT_Create;
    }

    public Long getGMT_Modified() {
        return GMT_Modified;
    }

    public void setGMT_Modified(Long GMT_Modified) {
        this.GMT_Modified = GMT_Modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account_id='" + account_id + '\'' +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", GMT_Create=" + GMT_Create +
                ", GMT_Modified=" + GMT_Modified +
                '}';
    }
}
