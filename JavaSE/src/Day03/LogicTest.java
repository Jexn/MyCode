package Day03;

public class LogicTest {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;

        System.out.println("(b1 & b2) = " + (b1 & b2));
        System.out.println("(b1 && b2) = " + (b1 && b2));
        System.out.println("(b1 | b2) = " + (b1 | b2));
        System.out.println("(b1 || b2) = " + (b1 || b2));
        System.out.println("(b1 ^ b2) = " + (b1 ^ b2));
        System.out.println("!b1 = " + !b1);

        System.out.println("逻辑'&'与和短路与'&&'的区别:");

        boolean isFlag_1 = false;
        int num_1 = 10;
        if (isFlag_1 & (num_1++ > 0)) {
            System.out.println("num_1 = " + num_1);
        } else {
            System.out.println("num_1 = " + num_1);
        }

        boolean isFlag_2 = false;
        int num_2 = 10;
        if (isFlag_2 && (num_2++ > 0)) {
            System.out.println("num_2 = " + num_2);
        } else {
            System.out.println("num_2 = " + num_2);
        }

        System.out.println("逻辑或'|'和短路或'||'的区别：");
        boolean isFlag_3 = true;
        int num_3 = 10;
        if (isFlag_3 | (num_3++ > 0)){
            System.out.println("num_3 = " + num_3);
        }else {
            System.out.println("num_3 = " + num_3);
        }

        boolean isFlag_4 = true;
        int num_4 = 10;
        if (isFlag_4 || (num_4++ > 0)){
            System.out.println("num_4 = " + num_4);
        }else {
            System.out.println("num_4 = " + num_4);
        }
    }
}
