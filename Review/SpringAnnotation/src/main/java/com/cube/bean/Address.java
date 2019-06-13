package com.cube.bean;

/**
 * @author Cube
 * @className Address
 * @description
 * @date 2019-06-13 08:27
 */
public class Address {
    private String nation;
    private String province;
    private String Street;

    public Address() {
    }

    public Address(String nation, String province, String street) {
        this.nation = nation;
        this.province = province;
        Street = street;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", Street='" + Street + '\'' +
                '}';
    }
}
