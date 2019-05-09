package JDBC.myJDBC;

import org.jetbrains.annotations.Contract;

/**
 * @program: MyCalculator
 * @description:
 * @author: Cube
 * @create: 2019-05-04 10:37
 **/
public class MyCalculator {
    @Contract(pure = true)
    public static int add(int a, int b) {
        return a + b;
    }

    public static double divide(int a, int b) throws ArithmeticException {
        if (b == 0){
            throw new ArithmeticException("除数不能为0");
        }
        return a / b;
    }
}
