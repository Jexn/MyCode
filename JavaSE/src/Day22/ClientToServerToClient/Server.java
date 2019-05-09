package Day22.ClientToServerToClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (
                // 1. 创建ServerSocket
                ServerSocket serverSocket = new ServerSocket(1990);

                // 2. 打开Socket接收
                Socket socket = serverSocket.accept();

                // 3. 接受数据
                InputStream inputStream = socket.getInputStream();

                // 4. 写入数据
                FileOutputStream fileOutputStream = new FileOutputStream("File/FromClient.jpg")

        ) {
            byte[] bytes = new byte[20];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("接收完毕".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
