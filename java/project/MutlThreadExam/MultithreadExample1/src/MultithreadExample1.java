
public class MultithreadExample1 {
	public static void main(String args[]) {
        Thread thread = new DigitThread();// 쓰레드를 생성   
        thread.start();     // 쓰레드를 시작
        for (char ch = 'A'; ch <= 'Z'; ch++) 
            System.out.print(ch);
    }
}
