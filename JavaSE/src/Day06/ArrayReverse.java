package Day06;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        int[] newArr = new int[arr.length];

        // 第一种反转
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - i - 1];
        }

        for (int i : newArr) {
            System.out.print(i+" ");
        }

        System.out.println("\n----------------------");

        // 第二种反转
        for (int i = 0, j = arr.length-1; i < j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
