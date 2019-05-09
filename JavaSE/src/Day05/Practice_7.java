package Day05;

public class Practice_7 {
    private static boolean check(int[] array,int value){
        boolean flag = false;
        for (int i : array) {
            if (i == value) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        int all = 0;
        do {
            int index = (int) (Math.random()*30) + 1;
            boolean isAdd = check(arr, index);
            if (!isAdd){
                arr[all] = index;
                all++;
            }
        }while (all < 6);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
