package edu.inha.scanner;

import java.util.Scanner;

public class ScannerEx0126 {

	public static void main(String[] args) {
		final int year = 2023;
		int age = 0;
		char blood = '\0';
		double height = 0.;
		String name = null;
		
		Scanner sc = new Scanner(System.in);

		System.out.print("당신은 몇 살인가요: ");
		age = sc.nextInt();
		
		System.out.print("이름이 뭐에요: ");
		//name = sc.next();
		sc.nextLine();
		name = sc.nextLine();
		
		System.out.print("혈액형이 뭐에요: ");
		blood = sc.next().charAt(0);
		
		System.out.print("키가 얼마인가요(cm): ");
		height = sc.nextDouble();
		
		System.out.printf("당신은 %d년생이고, 혈액형은 %c형입니다.\n"
									+ "키는 대략 %.2fcm 정도입니다."
									+ "\n젊게 사세요 %s씨\n",
										1+year-age, blood, height, name);

		sc.close();
		// System.out.print("asdf".substring(0, 4) );	// 문자열 슬라이스는 이렇게 하면 될 듯
	}

}
