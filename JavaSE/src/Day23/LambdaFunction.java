package Day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaFunction {

    @Test
    public void method1() {
        happyTime(500, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("去大保健，消费：" + integer);
            }
        });

        happyTime(500, amount -> System.out.println("去补习班，消费：" + amount));
    }

    public void happyTime(int amount, Consumer<Integer> consumer) {
        consumer.accept(amount);
    }

    @Test
    public void method2() {
        List<String> list = Arrays.asList("四川热", "南京热", "北京热", "武汉热", "东京热", "长春冷");

        List<String> filterList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("热");
            }
        });

        System.out.println(filterList);

        System.out.println("************************");

        List<String> filterList_lambda = filterString(list,s -> s.contains("冷"));
        System.out.println(filterList_lambda);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterString = new ArrayList<>();

        for (String s : list) {
            if (pre.test(s)) {
                filterString.add(s);
            }
        }
        return filterString;
    }
}
