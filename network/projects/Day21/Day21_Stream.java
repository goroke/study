import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.Scanner;

public class Day21_Stream {
    // 그냥 혼자 연구용으로 만든 파일
    public static void main(String[] args) {
        // 1부터 n까지의 합 구해보기
        int n;
        AtomicInteger i = new AtomicInteger();
        AtomicInteger S = new AtomicInteger();
        n = new Scanner(System.in).nextInt();
        Stream.generate(() -> i.incrementAndGet())
                .map(x -> {
                    S.addAndGet(x); return x;})
                .allMatch(x -> x < n);

        System.out.println(S);
    }
}
