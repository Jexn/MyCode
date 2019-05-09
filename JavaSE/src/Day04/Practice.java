package Day04;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[2];
        for (int i = 0; i < 2; i++){
            nums[i] = (int)(Math.random()*90+10);
        }

        System.out.println("本期中奖号码：");
        for (int num : nums) {
            System.out.print(num+" ");
        }

        System.out.print("\n请输入第一位数字:");
        int user_num_1 = in.nextInt();
        System.out.print("请输入第二位数字:");
        int user_num_2 = in.nextInt();

        if (user_num_1 == nums[0] && user_num_2 == nums[1]){
            System.out.println("奖金10000美元");
        }else if (user_num_1 == nums[1] && user_num_2 == nums[0]){
            System.out.println("奖金3000美元");
        }else if (user_num_1 == nums[0] || user_num_2 == nums[1]){
            System.out.println("奖金1000美元");
        }else if (user_num_1 == nums[1] || user_num_2 == nums[0]){
            System.out.println("奖金500美元");
        }else {
            System.out.println("没有中奖");
        }
    }
}
