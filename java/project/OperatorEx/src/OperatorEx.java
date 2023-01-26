
public class OperatorEx {
	public static void main(String[] args) {
		int a = 1;
		System.out.printf("a = %d\n", a);
		a = a + 1;
		System.out.printf("a = %d\n", a);
		a++;
		System.out.printf("a = %d\n", a);
		++a;
		System.out.printf("a = %d\n", a);
		System.out.printf("a = %d\n", ++a);
		System.out.printf("a = %d\n", a++);
		System.out.printf("a = %d\n", a);
		
		int b = 9;
		System.out.printf("b = %d\n", b);
		b = b + 1;
		System.out.printf("b = %d\n", b);
		b--;
		System.out.printf("b = %d\n", b);
		--b;
		System.out.printf("b = %d\n", b);
		System.out.printf("b = %d\n", --b);
		System.out.printf("b = %d\n", b--);
		System.out.printf("b = %d\n", b);
		
		int c = 8, d = 27;
		int max = c > d ? c : d;
		System.out.println(max);
	}
}
