import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

public class FutureClassTest {
    private static class TestClass implements Future<String> {

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public String get() throws InterruptedException, ExecutionException {
            Thread.sleep(1000);
            return "꺆";
        }

        @Override
        public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return get();
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Future<String> test = new TestClass();
        System.out.println(test.get(5, TimeUnit.MILLISECONDS));
    }
}
