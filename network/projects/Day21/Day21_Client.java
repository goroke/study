import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Day21_Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("165.246.115.106", 60000);
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.println("Connected to server");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine();
                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;  // 종료 조건
                }
                pw.println(inputLine);
                String response = br.readLine();
                System.out.println("서버로부터: " + response);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}