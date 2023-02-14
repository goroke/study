import java.io.IOException;
import java.net.*;
import java.util.Date;

public class Day22_MulticastServer {
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket()) {  // UDP용 소켓
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();
                InetAddress group = InetAddress.getByName("224.0.0.7");
                DatagramPacket packet;
                packet = new DatagramPacket(buffer, buffer.length, group, 10000);
                serverSocket.send(packet);
                System.out.println("Time sent: " +
                        dateText);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }

            }
        }
        catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
