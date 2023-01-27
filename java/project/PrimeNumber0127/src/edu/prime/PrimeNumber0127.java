package edu.prime;

import java.util.Scanner;

public class PrimeNumber0127 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 1, n = 1, prime_cnt = 0;
		
		System.out.print("<�Ҽ� ���ϱ� ���α׷�>\r\n"
				+ "1���� ���ϴ� ���������� �Ҽ��� ����մϴ�.\r\n"
				+ "�Ҽ����� �Ǵ��� ������ ���Ѱ��� �Է����ּ���: ");
		
		max = sc.nextInt();

		System.out.printf("\n1���� %d������ �Ҽ� ����Դϴ�.\n-> ", max);
		
		// �Ҽ����� �Ǵ��Ͽ� ���
		for(n = 1; n <= max; ++n)
			if(isPrime(n)) {
				System.out.printf("%d ", n);
				++prime_cnt;
			}
		
		System.out.printf("\n\n�� %d���� �߰ߵǾ����ϴ�.\n", prime_cnt);
	}

	// �Ҽ����� Ȯ���ϴ� �Լ�
	public static boolean isPrime(int n){
		// 1�� �Ҽ��� �ƴϴ�.
	    if (n==1) return false;
	    
	    // 2���� �ڽ��� �����ٱ��� ����� �ִ��� üũ
        for (int i = 2; i*i <= n; ++i)
        	// �ϳ��� ������ �Ҽ��� �ƴϴ�.
            if (n % i == 0) return false;
        
        // ������ �Ҽ�
        return true;
	}
}
