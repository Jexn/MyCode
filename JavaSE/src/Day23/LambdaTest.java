package Day23;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 *  Lambda表达式的的使用情景
 *
 *  (o1,o2) -> Integer.compare(o1,o2);
 *
 *  格式：
 *      -> : Lambda操作符 或 箭头操作符
 *      -> 左边: Lambda形参列表，接口实现方法的形参列表
 *      -> 右边: Lambda体，重写抽象方法的方法体
 *
 *  Lambda本质：接口的实例
  */

public class LambdaTest {

    // 语法格式一：无参，无返回值
    @Test
    public void method1(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通形式");
            }
        };

        Runnable runnable2 = () -> System.out.println("无参无返回值");

        runnable1.run();
        runnable2.run();
    }

    // 语法格式二：有参，无返回值、
    @Test
    public void method2(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer2 = (String s) -> {
            System.out.println(s);
        };

        consumer1.accept("普通形式");
        consumer2.accept("Lambda形式");
    }

    // 语法格式三：类型推断，可以省略数据类型
    @Test
    public void method3(){
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept("类型推断");
    }

    // 语法格式四：Lambda只有一个参数，参数括号可以省略
    @Test
    public void method4(){
        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("省略括号");
    }

    // 语法格式五：有多个参数，多条执行语句，并且有返回值
    @Test
    public void method5(){
        Comparator<Integer> comparator = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(comparator.compare(32,31));
    }

    // 语法格式六：当Lambda体只有一条语句，return 与大括号若有，可以省略
    @Test
    public void method6(){
        Comparator<Integer> comparator = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator.compare(32, 21));
    }
}
