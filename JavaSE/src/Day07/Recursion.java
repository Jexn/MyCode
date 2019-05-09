package Day07;

/**
 * 练习1：请用Java写出递归求阶乘(n!)的算法
 *
 * 练习2：已知有一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),其中n是大于0的整数，求f(10)的值。
 *
 * 练习3：已知一个数列：f(20) = 1,f(21) = 4,f(n+2) = 2*f(n+1)+f(n),
 *       其中n是大于0的整数，求f(10)的值。
 */


public class Recursion {
    public static void main(String[] args) {
        System.out.println("recursion_1(10) = " + recursion_1(10));
        System.out.println("f(10) = " + recursion_2(10));
        System.out.println("recursion_3(10) = " + recursion_3(10));
    }

    public static long recursion_1(long n) {
        long value = 1;
        if (n > 1) {
            value = n;
            return recursion_1(--n) * value;
        }
        return value;
    }

    public static long recursion_2(long n) {
        long value = 0;
        if (n >= 0){
            if ( n == 0){
                value = 1;
            }else if (n == 1){
                value = 4;
            }else {
                value = 2 * recursion_2(n-1)+ recursion_2(n -2);
            }
        }
        return value;
    }

    public static long recursion_3(long n){
        long value = 0;
        if ( n >= 0){
            if ( n == 20){
                value = 1;
            }else if (n == 21){
                value = 4;
            }else {
                value = recursion_3(n+2) - 2* recursion_3( n +1);
            }
        }
        return value;
    }
}
