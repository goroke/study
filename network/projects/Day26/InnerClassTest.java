public class InnerClassTest {
    private int factor;

    InnerClassTest(int f){
        factor = f;
    }

    class Functions{
        int plus(int x){
            return x+factor;
        }
        int multiply(int x){
            return x*factor;
        }
    }

    public static void main(String[] args) {
        // inner function 처럼 클래스 안의 데이터를 저장할 수도 있다.
        InnerClassTest.Functions test = new InnerClassTest(2).new Functions();
        System.out.println(test.multiply(100));
    }
}
