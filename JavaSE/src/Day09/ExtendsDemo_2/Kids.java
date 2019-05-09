package Day09.ExtendsDemo_2;

/**
 * @cLassName: Kids
 * @author: cube
 * @description: TODO
 * @date: 2019/3/23 10:55
 */
public class Kids extends ManKind{
    private int yearsOld;

    public void printAge(){
        System.out.println("yearsOld = " + yearsOld);
    }

    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.setSex("man");
        someKid.setSalary(10000);

        someKid.employed();
    }
}
