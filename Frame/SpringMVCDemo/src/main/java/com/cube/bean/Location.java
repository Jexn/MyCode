package com.cube.bean;

/**
 * @author Cube
 * @className Location
 * @description
 * @date 2019-05-11 09:53
 */
public class Location {
    private String name;
    private String localInfo;

    public Location() {
    }

    public Location(String name, String localInfo) {
        this.name = name;
        this.localInfo = localInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalInfo() {
        return localInfo;
    }

    public void setLocalInfo(String localInfo) {
        this.localInfo = localInfo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", localInfo='" + localInfo + '\'' +
                '}';
    }
}
