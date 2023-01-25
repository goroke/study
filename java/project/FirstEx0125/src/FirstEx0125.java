
public class FirstEx0125 {

	public static void main(String[] args) {
		int a = 5;
		
		// 줄바꿈 지원이 되는 print 함수
		System.out.println("Study");

		// 줄바꿈 지원이 안 되는 print 함수
		System.out.print("Hello JAVA\n");
		System.out.println("INHA");	// 줄바꿈 하려면 \n 넣어야 함
		
		System.out.printf("DecimalNum = %d\n", 7);
		System.out.printf("a = %d\n", a);
		
		// 더 큰 범위로는 자동 캐스팅이 되지만, 작은 범위로는 안 된다.
		// (데이터 손실이 생기기 때문)
		float  fv = 3.14f;
		double dv = 6.28;
		System.out.printf("fv = %f, dv = %f\n", fv, dv);
		System.out.printf("fv = %.2f, dv = %.2f\n", fv, dv);
		System.out.printf("fv = %07.2f, dv = %7.2f\n", fv, dv);
		System.out.printf("fv = %-7.2f\n", fv);
		System.out.print("fv = " + fv + '\n');
		
		System.out.printf("dv = %.2f\n", dv);
		
		char c = 'a';
		System.out.printf("c = '%c' \n", c);
		System.out.printf("c = %d \n", (int)c);
		
		String name = "gilei";
		System.out.println("name = " + name);
		System.out.printf("name = %s\n", name);
		
		final double PI = 3.14;
		System.out.printf("PI = %.2f\n", PI);
		
		// 나눗셈 연산자를 int끼리 계산하면 소수점이 안 나온다.
		int s = 15/2;
		System.out.printf("%d", s);
		
		System.out.println(++s);
	}
}