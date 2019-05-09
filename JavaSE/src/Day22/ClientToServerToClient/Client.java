package Day22.ClientToServerToClient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try (
                // 1. 创建socket
                Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 1990);
                // 2. 创建输出流
                OutputStream outputStream = socket.getOutputStream();
                // 3. 读取本地数据
                FileInputStream fileInputStream = new FileInputStream("File/Road.jpg");
                // 接受服务端数据
                ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        ) {
            // 4. 传输数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

            // 5. 关闭传输，防止阻塞
            socket.shutdownOutput();

            // 6. 接受服务端数据
            InputStream inputStream = socket.getInputStream();
            byte[] inputBytes = new byte[200];
            int lent;
            while ((len = inputStream.read(inputBytes)) != -1) {
                outputStream1.write(inputBytes, 0, len);
            }
            System.out.println("来自服务端数据：" + outputStream1.toString());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
