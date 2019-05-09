package Day20;

import org.junit.Test;

public class StringTest {
    /**
     * 1. String:字符串，使用一对""表示；
     * 2. String声明为final的，不可继承；
     * 3. String实现了Serializable接口，表示可序列化；实现了comparable：表示可比较的；
     * 4. String内部定义了final char[] value用于存储字符串数据；
     * 5. String：代表不可变的字符串序列；
     * 6. 通过字面量的方式（区别于new)给一个字符串赋值，此时的字符串值声明在方法区（字符串常量池中）；
     * 7. 字符串常量池不会存储相同内容的字符串；
     */
    @Test
    public void method1() {
        String s1 = "abc";
        String s2 = "abc";

        System.out.println("s1 == s2 = " + (s1 == s2));


        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void method2() {
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
    }

    /**
     * s3 == s4 ? true
     * s3 == s5 ? false
     * s5 == s6 ? false
     * s5 == s7 ? false
     * s3 == s8 ? true
     * 字符串如果使用new String("xxx")创建的，会首先在堆空间内创建地址，然后指向方法区地址，在方法区字符串常量池中创建字符串
     * <p>
     * 1. 常量与常量的拼接在方法区内。且常量池中不会存在相同内容的常量；
     * 2. 字符串拼接只要其中一个是变量，结果就会在堆空间中；
     * 3. 如果拼接的结果直接调用intern()方法，返回值就在常量池中；
     */
    @Test
    public void method3() {
        String s1 = "Java";
        String s2 = "Script";

        String s3 = "JavaScript";
        String s4 = "Java" + "Script";

        String s5 = s1 + "Script";
        String s6 = "Java" + s2;
        String s7 = s1 + s2;

        System.out.println("s3 == s4 ? " + (s3 == s4));
        System.out.println("s3 == s5 ? " + (s3 == s5));
        System.out.println("s5 == s6 ? " + (s5 == s6));
        System.out.println("s5 == s7 ? " + (s5 == s6));

        String s8 = s5.intern();

        System.out.println("s3 == s8 ? " + (s3 == s8));
    }

    @Test
    public void finalMethod() {
        String s1 = "JavaScript";
        String s2 = "Java";
        String s3 = s2 + "Script";
        System.out.println(s1 == s3);

        // 对于final修饰的变量会变成常量，存放在方法区，所以，s5还是常量+常量，所以，s1 == s5 为true
        final String s4 = "Script";
        String s5 = "Java" + s4;
        System.out.println(s1 == s5);
    }
}
