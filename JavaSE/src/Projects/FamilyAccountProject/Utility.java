package Projects.FamilyAccountProject;

import java.util.Scanner;

public class Utility {
    private static Scanner in = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c == '1' || c == '2' || c == '3' || c == '4') {
                break;
            } else {
                System.out.println("输入有误，请重新输入：");
            }
        }
        return c;
    }

    //获取数字
    public static int readNumber() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(4);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("请输入数字：");
            }
        }
        return n;
    }

    // 获取备注信息
    public static String readString() {
        String str = readKeyBoard(8);
        return str;
    }

    //退出
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
        return c;
    }

    //获取输入信息
    private static String readKeyBoard(int limit) {
        String line = "";
        while (in.hasNext()) {
            line = in.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}
