import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadSocket implements Runnable {
    private Socket s;
    private BufferedReader br;
    private PrintWriter pw;

    public ThreadSocket(Socket s) throws IOException {
        this.s = s;
        this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.pw = new PrintWriter(s.getOutputStream(), true);

        ExecutorService a = Executors.newFixedThreadPool(100);
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pw.println(Day22_ThreadServer.rev(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Day22_ThreadServer {
    public static void main(String[] args) {
        System.out.println("Reverse Server");
        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            // BufferedReader listener = new BufferedReader(new InputStreamReader(serverSocket.get))
            // PrintWriter sender = new PrintWriter(serverSocket.get)

            while (true) {
                System.out.println("연결을 시도합니다.");
                try {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(new ThreadSocketCalc(clientSocket)).start();

                } catch (Exception e) {
                    throw new RuntimeException(e);
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
