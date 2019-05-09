package Day09.ExtendsDemo_3;

/**
 * @cLassName: Circle
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 11:01
 */
public class Circle {
    private static final double PI = 3.14;
    private double radius;

    public Circle(){
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.pow(this.radius, 2) * PI;
    }

    public double getPerimeter(){
        return 2 * this.radius * PI;
    }
}
