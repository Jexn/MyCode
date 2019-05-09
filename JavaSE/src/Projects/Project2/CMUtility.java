package Projects.Project2;

import java.util.Scanner;

/**
 * @cLassName: CMUtility
 * @author: cube
 * @description: 输入处理
 * @date: 2019/3/22 17:24
 */
public class CMUtility {
    private static Scanner in = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("输入有误，请重新输入：");
            } else {
                break;
            }
        }
        return c;
    }

    public static int readInt(){
        int n;
        for (;;){
            String str = readKeyBoard(3,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException ex){
                System.out.println("数字输入有误，请重新输入");
            }
        }
        return n;
    }

    /**
     * 处理年龄
     * @param defaultValue
     * @return
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(3, true);
            if ("".equals(str)) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("数字输入有误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 获取字符串
     * @param limit
     * @param defaultValue
     * @return
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return "".equals(str) ? defaultValue : str;
    }

    /**
     * 处理用户输入信息
     *
     * @param limit
     * @param blankReturn
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (in.hasNextLine()) {
            line = in.nextLine();

            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else
                    continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }

    /**
     * 获取退出信息
     *
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
}
