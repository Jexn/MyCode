package Day04;

import java.util.Scanner;

public class SwitchCaseTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("输入你的成绩：");
        int score = in.nextInt();
        switch (score /10){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不及格");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("及格了");
                break;
        }
    }
}
