package Day23.StreamAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 *    集合Collection关注的是数据的存储，与内存打交道
 *
 * 2. ① Stream自身不存储数据；
 *    ② Stream不会改变源对象；相反，它们会返回一个持有结果新的Stream；
 *    ③ Stream操作是延时的。这意味着它们会等到需要结果的时候才执行；
 *
 * 3. 执行流程：Stream实例化 ==>  一系列的中间操作（映射、过滤。。。） ==> 终止操作
 *
 * 4. 说明：
 *    ① 一个中间操作链，对数据源的数据进行处理
 *    ② 只有执行终止操作才会执行中间操作，并产生结果；之后，不会再被使用
 *
 */

public class StreamDemo {

    // 实例化方式一：通过集合
    @Test
    public void method1(){
        List<String> strings = Arrays.asList("one","two","three","four","12","90");
        strings.stream().sorted().forEach(System.out::println);

    }
}
