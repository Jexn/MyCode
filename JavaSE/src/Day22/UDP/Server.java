package Day22.UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(8090)) {

            byte[] bytes = new byte[200];

            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);

            socket.receive(datagramPacket);

            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
