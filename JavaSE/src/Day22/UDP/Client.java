package Day22.UDP;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket();
        ) {
            byte[] bytes = "利用UDP用户数据报发送的数据".getBytes();

            // 提供数据报，在数据报中提供要发送的数据，以及要发送的到接收端的IP地址和端口号
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8090);
            datagramSocket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
