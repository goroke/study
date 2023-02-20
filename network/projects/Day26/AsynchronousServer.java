import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynchronousServer {
    public static void main(String[] args) {
        try(AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open()){

            // 서버가 왜 다른 IP에 bind 하지?.. → 서버 하나가 여러 IP를 가질 수 있기 때문에 그 중에 하나를 선택하는 것! (다른 IP 아님)
            serverSocket.bind(new InetSocketAddress("localhost", 20000));

            // 클라이언트를 바로 accept 로 받지 않고, Future 로 받았다가 get 으로 처리한다. 이러면 비동기 처리가 된다.
            Future<AsynchronousSocketChannel> accept = serverSocket.accept();

            try(AsynchronousSocketChannel clientSocket = accept.get()){
                ByteBuffer bf = ByteBuffer.allocate(64);
                Future<Integer> result = clientSocket.read(bf);
                System.out.println(result.get(10, TimeUnit.SECONDS));
                bf.flip();
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                System.out.println("야!!!!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
