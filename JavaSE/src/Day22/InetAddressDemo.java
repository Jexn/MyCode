package Day22;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {

        // 实例化
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.123.1");
            System.out.println(inetAddress);

            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);

            // 获取本地IP
            InetAddress inetAddress2 = InetAddress.getLocalHost();
            System.out.println(inetAddress2);

            // 获取域名和IP地址
            System.out.println("inetAddress1.getAddress() = " + inetAddress1.getAddress());
            System.out.println("inetAddress1.getHostAddress() = " + inetAddress1.getHostAddress());
            System.out.println("inetAddress1.getHostName() = " + inetAddress1.getHostName());
            System.out.println("inetAddress1.getCanonicalHostName() = " + inetAddress1.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
