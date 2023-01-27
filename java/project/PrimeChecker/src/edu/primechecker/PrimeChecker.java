package edu.primechecker;

import java.util.Scanner;

public class PrimeChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 1, n = 1, prime_cnt = 0;
		
		System.out.print("<소수 구하기 프로그램>\r\n"
				+ "1부터 원하는 정수까지의 소수를 출력합니다.\r\n"
				+ "소수인지 판단할 정수의 상한값을 입력해주세요: ");
		
		max = sc.nextInt();

		System.out.printf("\n1부터 %d까지의 소수 목록입니다.\n-> ", max);
		
		// 소수인지 판단하여 출력
		for(n = 1; n <= max; ++n)
			if(isPrime(n)) {
				System.out.printf("%d ", n);
				++prime_cnt;
			}
		
		System.out.printf("\n\n총 %d개가 발견되었습니다.\n", prime_cnt);
	}

	// 소수인지 확인하는 함수
	public static boolean isPrime(int n){
		// 1은 소수가 아니다.
	    if (n==1) return false;
	    
	    // 2부터 자신의 제곱근까지 약수가 있는지 체크
        for (int i = 2; i*i <= n; ++i)
        	// 하나라도 있으면 소수가 아니다.
            if (n % i == 0) return false;
        
        // 없으면 소수
        return true;
	}

}
