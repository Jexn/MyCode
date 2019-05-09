package Day02;

import Day01.Person;
import org.junit.Test;

public class MyTest {
    @Test
    public void method1(){
        PersonUtils.checkNum(new Person(10,"LiuQiangDong"));
    }

    // 避免自动装箱
    @Test
    public void method2(){
        Long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        Long expend = System.currentTimeMillis() - start;
        System.out.println(sum);
    }

    //2305843008139952128
    @Test
    public void method3(){
        Long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 1; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        Long expend = System.currentTimeMillis() - start;
        System.out.println(sum);
    }
}
