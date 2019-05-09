package Day22.ClientToServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 1990);
                OutputStream outputStream = socket.getOutputStream();
        ) {
            outputStream.write("From Client Data".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
