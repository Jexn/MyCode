package Projects.FamilyAccountProject;

public class FamilyAccount {
    public static void main(String[] args) {
        String details = "收支\t\t收支金额\t\t账户余额\t\t说明\n";
        double balance = 10000;

        boolean loopFlag = true;

        do {
            System.out.println("\n-----------------家庭收支记账软件-----------------\n");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退    出\n");
            System.out.print("                   请选择(1-4)：");

            char key = Utility.readMenuSelection();

            System.out.println();
            switch (key) {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------------");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    double value_1 = Utility.readNumber();
                    System.out.print("本次收支说明：");
                    String desc_1 = Utility.readString();

                    balance += value_1;
                    details += "支出\t\t" + value_1 + "\t\t" + balance + "\t\t" + desc_1 + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    double value_2 = Utility.readNumber();
                    System.out.print("本次收支说明：");
                    String desc_2 = Utility.readString();
                    balance -= value_2;
                    details += "支出\t\t" + value_2 + "\t\t" + balance + "\t\t" + desc_2 + "\n";
                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '4':
                    System.out.print("确认是否退出（Y/N）：");
                    char confirm = Utility.readConfirmSelection();
                    if (confirm == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        } while (loopFlag);
    }
}
