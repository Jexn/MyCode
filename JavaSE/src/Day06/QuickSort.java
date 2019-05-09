package Day06;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50) + 1;
        }

        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int n[], int left, int right) {
        if (left < right) {
            int i, j, v;
            i = left;
            j = right;
            v = n[left];

            while (i < j) {
                while (i < j && n[j] > v) {
                    j--;
                }
                if (i < j) {
                    n[i++] = n[j];
                }
                while (i < j && n[i] < v) {
                    i++;
                }
                if (i < j) {
                    n[j--] = n[i];
                }
            }

            n[i] = v;
            quickSort(n, left, i - 1);
            quickSort(n, i+1, right);
        }
    }
}
