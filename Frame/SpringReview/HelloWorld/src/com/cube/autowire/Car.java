package com.cube.autowire;

/**
 * @author Cube
 * @className Car
 * @description
 * @date 2019-06-12 11:09
 */
public class Car {
    private String name;
    private String area;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", price=" + price +
                '}';
    }
}
