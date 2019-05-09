package Day23;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    @Test
    public void method1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通形式");
            }
        };

        runnable.run();

        System.out.println("********Lambda表达式**********");

        Runnable runnable1 = () -> System.out.println("Lambda表达式");
        runnable1.run();
    }

    @Test
    public void method2(){
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);

        Comparator<Integer> comparator3 = Integer::compareTo;

        Integer[] arrays1 = new Integer[]{12,55,1,2,23,123,432,324,12};
        Arrays.sort(arrays1,comparator1);;
        System.out.println(arrays1);
        for (Integer integer : arrays1) {
            System.out.print(integer+" ");
        }

        System.out.println();
        System.out.println("**************");

        Integer[] arrays2 = new Integer[]{122,515,13,12,223,1423,4232,34,12};
        Arrays.sort(arrays2,comparator2);
        for (Integer integer : arrays2) {
            System.out.print(integer+" ");
        }

        System.out.println();
        System.out.println("**************");
        Integer[] arrays3 = new Integer[]{1212,51215,133,122,2123,141223,42132,343,123};
        Arrays.sort(arrays3,comparator3);
        for (Integer integer : arrays3) {
            System.out.print(integer+" ");
        }
    }
}
