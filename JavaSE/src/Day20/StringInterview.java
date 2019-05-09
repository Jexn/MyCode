package Day20;

/**
 * Java是按值传递的：对象传递的是引用地址值，基本类型传递的是本身的值，此例中change(String str,char chars[])中str是
 */

public class StringInterview {
    String str = new String("Good");
    char[] chars = {'t', 'e', 's', 't'};

    public void change(String str, char chars[]) {
        str = "Test Ok";
        chars[0] = 'b';
    }

    public static void main(String[] args) {
        StringInterview stringInterview = new StringInterview();
        stringInterview.change(stringInterview.str, stringInterview.chars);

        System.out.println(stringInterview.str);
        for (char aChar : stringInterview.chars) {
            System.out.print(aChar);
        }
    }
}
