package com.cube.beans;

/**
 * @author Cube
 * @className Car
 * @description
 * @date 2019-06-12 09:55
 */
public class Car {
    private String brand;
    private String corp;
    private int price;
    private int maxSpeed;

    public Car(String brand, String corp, int price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class B{
    public static void main(String[] args) {

    }
}
