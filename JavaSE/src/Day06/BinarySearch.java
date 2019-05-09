package Day06;

public class BinarySearch {
    public static void main(String[] args) {

        //    二分查找适用于有序数组

        int[] arr = new int[]{-23, -10, -6, -1, 0, 12, 14, 32, 43, 56, 77, 80};
        int target = 11;
        boolean isFound = false;
        int head = 0;
        int end = arr.length - 1;
        while (head < end) {
            int middle = (end + head) / 2;
            if (target < arr[middle]) {
                System.out.println("head = " + head + ",middle = " + middle + ",end = " + end);
                end = middle - 1;
            } else if (target == arr[middle]) {
                System.out.println("head = " + head + ",middle = " + middle + ",end = " + end);
                System.out.println("找到了，位置：" + middle);
                isFound = true;
                break;
            } else if (target > arr[middle]) {
                System.out.println("head = " + head + ",middle = " + middle + ",end = " + end);
                head = middle + 1;
            }
        }

        if (!isFound) {
            System.out.println("数组中没有这个数字");
        }

    }
}
