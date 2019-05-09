package Day07;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100+1);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = arr.length  - 1; i >= 0; i--){
            arr[i] /= arr[0];
        }

        System.out.println(Arrays.toString(arr));

    }
}
