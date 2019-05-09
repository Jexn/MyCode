package Day03;

public class Practice {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;

        if ((x++ == 2) & (++y == 2)) {
            x = 7;
        }

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int x1 = 1;
        int y1 = 1;
        if ((x1++ == 2) && (++y1 == 2)) {
            x1 = 7;
        }

        System.out.println("x1 = " + x1);
        System.out.println("y1 = " + y1);

        int x2 = 1;
        int y2 = 1;
        if ((x2++ == 1) | (++y2 == 1)) {
            x2 = 7;
        }

        System.out.println("x2 = " + x2);
        System.out.println("y2 = " + y2);

        int x3 = 1;
        int y3 = 1;
        if ((x3++ == 1) || (++y3 == 1)) {
            x3 = 7;
        }

        System.out.println("x3 = " + x3);
        System.out.println("y3= " + y3);
    }
}
