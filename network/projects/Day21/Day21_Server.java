import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class NewThread extends Thread {
    public BufferedReader br;
    public PrintWriter pw;
    public String extra;

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            while (sc.hasNext())
                this.extra += sc.nextLine();
        }
    }
}
public class Day21_Server {
    public static void main(String[] args) {
        NewThread a = new NewThread();
        System.out.println("Reverse Server");
        try (ServerSocket serverSocket = new ServerSocket(60000)) {
            // BufferedReader listener = new BufferedReader(new InputStreamReader(serverSocket.get))
            // PrintWriter sender = new PrintWriter(serverSocket.get)

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            ) {
                System.out.println("연결");
                a.br = br;
                a.pw = pw;
                //a.run();
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    pw.println(rev(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String rev(String text){
        String x = "";
        for(int i=text.length()-1; i>=0; --i)
            x += "" + text.charAt(i);
        return x;
    }
}
