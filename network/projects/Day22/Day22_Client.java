import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day22_Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 20000); // 165.246.115.165
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.println("Connected to server");
            Scanner scanner = new Scanner(System.in);
            /*while (true) {
                System.out.print("Enter text: ");
                String inputLine = scanner.nextLine();
                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;  // 종료 조건
                }
                pw.println(inputLine);
                String response = br.readLine();
                System.out.println("서버로부터: " + response);

            }*/
            System.out.print("메시지 입력: ");
            pw.println(scanner.nextLine());
            Stream.generate(() -> {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    return null;
                }
            }).map(s -> {
                System.out.println("서버로부터: " + s);
                String nextLine = scanner.nextLine();
                pw.println(nextLine);
                return nextLine;
            })
            .allMatch(s -> !s.equalsIgnoreCase("exit"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}