package Day04;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        while ( b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        System.out.println("a = " + a);
    }
}
