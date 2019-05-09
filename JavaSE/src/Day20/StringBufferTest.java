package Day20;

import org.junit.Test;

/**
 * String、StringBuffer、StringBuilder三者的异同？
 * 相同点：都是字符相关类，底层都用char[]数组存储；
 *
 * 不同：
 * String：不可变的字符串序列；
 * StringBuffer：可变的字符串序列；线程安全，效率低；
 * StringBuilder：可变的字符串序列；线程不安全，效率高；
 */

public class StringBufferTest {
    @Test
    public void method1(){
        StringBuffer sb = new StringBuffer("abc");
        sb.setCharAt(0,'m');
        System.out.println(sb);
    }
}
