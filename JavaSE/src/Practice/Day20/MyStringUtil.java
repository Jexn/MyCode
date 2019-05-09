package Practice.Day20;

import java.util.Arrays;

public class MyStringUtil {

    public static String myTrim(String str) {
        boolean flag = true;
        int num = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                num = i;
                break;
            }
        }

        String newString = str.substring(num);

        chars = newString.toCharArray();

        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] != ' ') {
                num = i;
                break;
            }
        }
        return newString.substring(0, num + 1);
    }

    public static String myReversal(String str, int start, int end) {
        String revStr = str.substring(start, end + 1);
        char[] chars = revStr.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        revStr = new String(chars);

        return str.substring(0, start) + revStr + str.substring(end + 1);
    }

    public static int countNum(String resource, String target) {
        int num = 0;

        if (target.length() > resource.length()) {
            return 0;
        } else if (resource.length() == target.length()) {
            if (resource.equals(target)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            char[] chars = resource.toCharArray();
            char[] targetChars = target.toCharArray();

            for (int i = 0; i < chars.length; i++) {

                // 判断是否与目标第一字符相等
                if (chars[i] == targetChars[0]) {
                    boolean flag = true;

                    // 判断剩余字符是否相等
                    for (int j = 1; j < targetChars.length; j++) {
                        if (chars[i + j] != targetChars[j]) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    // 查找最长子串
    public static String getMaxSubstring(String str1, String str2) {
        String max;
        String min;

        max = (str1.length() > str2.length()) ? str1 : str2;
        min = (max == str1) ? str2 : str1;

        for (int i = 0; i < min.length(); i++) {

            // 像一个x一样换装查找
            for (int j = 0, y = min.length() - i; y <= min.length(); j++, y++) {
                String temp = min.substring(j, y);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }

        return "";
    }

    public static String mySort(String str) {
        String newStr = "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        newStr = new String(chars);

        return newStr;
    }

    public static void main(String[] args) {
        String str = myTrim("     aba  ");

        String revStr = myReversal("abcdefg", 2, 5);

        System.out.println(revStr);

        int num = countNum("ab", "abc");
        System.out.println(num);

        String max = getMaxSubstring("somethingisonew", "just one");
        System.out.println(max);

        String sortStr = mySort("soaskdfhksdjfdsa");
        System.out.println(sortStr);
    }

}
