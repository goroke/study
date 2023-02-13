import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Day21_Socket {
    // Thread a = new Thread();
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000);
             Socket clientSocket = new Socket("165.246.115.106", 6060)) {

            clientSocket.connect(clientSocket.getRemoteSocketAddress());
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {

        }
    }
}
