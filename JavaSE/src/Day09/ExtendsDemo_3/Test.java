package Day09.ExtendsDemo_3;

/**
 * @cLassName: EmployeeTest
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 11:07
 */
public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("circle.getArea() = " + circle.getArea());

        Cylinder cylinder = new Cylinder(10,10);
        System.out.println("cylinder.getArea() = " + cylinder.getArea());
        System.out.println("cylinder.getVolume() = " + cylinder.getVolume());
    }
}
