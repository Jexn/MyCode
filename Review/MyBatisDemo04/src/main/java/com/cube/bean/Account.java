package com.cube.bean;

import java.io.Serializable;

/**
 * TODO：
 * author：Cube
 * create：2019-06-17 09:49
 */
public class Account implements Serializable {
    private Integer ID;
    private Integer UID;
    private Double MONEY;
    private User user;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public Double getMONEY() {
        return MONEY;
    }

    public void setMONEY(Double MONEY) {
        this.MONEY = MONEY;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", UID=" + UID +
                ", MONEY=" + MONEY +
                ", user=" + user +
                '}';
    }
}
