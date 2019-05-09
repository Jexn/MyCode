package JDBC.Demo;

import JDBC.myJDBC.User;

import java.util.Scanner;

/**
 * @program: Login
 * @description: LoginTest
 * @author: Cube
 * @create: 2019-05-04 16:10
 **/
public class Login {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String name = in.nextLine();
        System.out.println("请输入密码：");
        String password = in.nextLine();

        User user = LoginService.findUserByNameAndPassword(name, password);

        if (user == null) {
            System.out.println("登录失败！");
        } else {
            System.out.println("登录成功！");
            System.out.println(user);
        }
    }
}
