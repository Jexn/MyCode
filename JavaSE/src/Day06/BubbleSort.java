package Day06;

public class BubbleSort {
    public static void main(String[] args) {
        int[] myArr = new int[10];

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = (int) (Math.random() * 100) + 1;
        }

        for (int i : myArr) {
            System.out.print(i + " ");
        }

        bubbleSort(myArr);

        System.out.println("\nbefore:");
        for (int i : myArr) {
            System.out.print(i + " ");
        }

    }

    private static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
