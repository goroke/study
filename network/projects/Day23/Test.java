import java.net.NetworkInterface;
import java.net.SocketException;

class PrivateConstructor{
    public static PrivateConstructor getNewInstance(){
        return new PrivateConstructor();
    }

    private PrivateConstructor(){
        System.out.println("make");
    }
}

public class Test {
    public static String getMAC(NetworkInterface network){
        StringBuilder identifier = new StringBuilder();

        try {
            byte[] macBuffer = network.getHardwareAddress();
            if (macBuffer != null) {
                for (int i = 0; i <
                        macBuffer.length; i++) {
                    identifier.append(
                            String.format("%02X%s",macBuffer[i],
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

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("wow");
        for (int i=0; ++i<=10;) s.append("!");
        System.out.println(s);
    }
}