package Day11;

/**
 * @cLassName: InterViewTest_1
 * @author: cube
 * @description: TODO
 * @date: 2019/3/25 9:41
 */
public class InterViewTest_1 {
    public static void main(String[] args) {
        Base base = new Sub();
        base.add(1,2,3);
    }
}

class Base{
    public void add(int a,int... arr){
        System.out.println("Base");
    }
}

class Sub extends Base{
    public void add(int a,int[] arr){
        System.out.println("Sub_1");
    }

    public void add(int a,int b,int c){
        System.out.println("Sub_2");
    }
}
