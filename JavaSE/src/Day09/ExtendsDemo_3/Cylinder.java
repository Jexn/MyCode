package Day09.ExtendsDemo_3;

/**
 * @cLassName: Cylinder
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 11:04
 */
public class Cylinder extends Circle{
    private double length;

    public Cylinder(){
        super();
        this.length = 1;
    }

    public Cylinder(double length,double radius) {
        super(radius);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getVolume(){
        return super.getArea() * length;
    }

    @Override
    public double getArea() {
        return super.getArea() * 2 + super.getPerimeter() * length;
    }
}
