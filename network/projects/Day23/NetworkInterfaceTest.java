import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Stream;

public class NetworkInterfaceTest {
    public static String getMACIdentifier(NetworkInterface network) {
        StringBuilder identifier = new StringBuilder();
        try {
            byte[] macBuffer = network.getHardwareAddress();
            if (macBuffer != null) {
                for (int i = 0; i <
                        macBuffer.length; i++) {
                    identifier.append(
                            String.format("%02X%s", macBuffer[i],
                                    (i < macBuffer.length - 1)
                                            ? "-" : ""));
                }
            } else {
                return "---";
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return identifier.toString();
    }

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
