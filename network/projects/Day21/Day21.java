import java.net.InetAddress;
import java.net.UnknownHostException;

public class Day21 {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("inha.ac.kr");
            System.out.println(addr);
            System.out.println(addr.getCanonicalHostName());
        } catch (UnknownHostException e) {
            // throw new RuntimeException(e);
            System.out.println("없어 임마!");
        }
    }
}
