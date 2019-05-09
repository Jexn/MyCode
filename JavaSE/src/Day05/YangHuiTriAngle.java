package Day05;

public class YangHuiTriAngle {
    public static void main(String[] args) {
        //创建前十行杨辉三角
        int[][] YH = new int[10][];

        // 为二维数组赋值
        for (int i = 0; i < YH.length; i++) {
            YH[i] = new int[i + 1];

            // 为每行首末元素赋值为1
            YH[i][0] = YH[i][i] = 1;

            // 给非首末元素赋值
            for (int j = 1; j < YH[i].length - 1; j++) {
                YH[i][j] = YH[i - 1][j - 1] + YH[i - 1][j];
            }
        }

        // 遍历
        for (int[] ints : YH) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

    }
}
