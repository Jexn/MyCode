package Projects.Project2;

/**
 * @cLassName: CustomerView
 * @author: cube
 * @description: 视图层
 * @date: 2019/3/22 17:50
 */
public class CustomerView {

    private static CustomerList customerList = new CustomerList();

    public void enterMainMenu() {

        boolean isFlag = true;

        do {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            // 从键盘获取用户1-5的选择
            char menu = CMUtility.readMenuSelection();
            // 使用switch-case对用户的选择，进行区别处理
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char exit = CMUtility.readConfirmSelection();
                    if (exit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }

        } while (isFlag);

    }

    private void listAllCustomers() {
        Customer[] customers = new Customer[customerList.getTotal()];
        customers = customerList.getCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void deleteCustomer() {
        System.out.println("请输入删除客户的编号：");
        int index = CMUtility.readInt();
        if (customerList.deleteCustomer(index)){
            System.out.println("删除成功!");
        }else {
            System.out.println("没有这个用户");
        }
    }

    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        Customer customer;
        int index;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                // break;//不能使用break
                return;
            }
            // 对于用户来讲，我们让index 默认从1开始。
            customer = customerList.getCustomer(index - 1);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {
                break;
            }
        }
        System.out.println(customer);
        System.out.print("请输入姓名：");
        String name = CMUtility.readString(10);

        System.out.print("\n请输入性别（male\\female)：");
        String sex = CMUtility.readString(6);

        System.out.print("\n请输入年龄：");
        int age = CMUtility.readInt();

        System.out.print("\n请输入联系方式：");
        String phone = CMUtility.readString(11);

        System.out.print("\n请输入电子邮件：");
        String eMail = CMUtility.readString(30);
    }

    private void addNewCustomer() {
        System.out.print("请输入姓名：");
        String name = CMUtility.readString(10);

        System.out.print("\n请输入性别（male\\female)：");
        String sex = CMUtility.readString(6);

        System.out.print("\n请输入年龄：");
        int age = CMUtility.readInt();

        System.out.print("\n请输入联系方式：");
        String phone = CMUtility.readString(11);

        System.out.print("\n请输入电子邮件：");
        String eMail = CMUtility.readString(30);

        customerList.addCustomer(new Customer(name, sex, age,phone,eMail));
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
