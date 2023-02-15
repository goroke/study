import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Stream;

public class NetworkInterfaceTest {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaceEnum = NetworkInterface.getNetworkInterfaces();

        for (NetworkInterface element; interfaceEnum.hasMoreElements();) {
            element = interfaceEnum.nextElement();
            System.out.printf("%-8s %-32s\n", element.getName(), element.getDisplayName());
            Enumeration<InetAddress> addresses = element.getInetAddresses();

            for (InetAddress inetAddress : Collections.list(addresses))
                System.out.printf(" InetAddress: %s\n", inetAddress);

        }
    }
}
