package edu.ifforex;

import java.util.Scanner;

public class IfForEx0126 {

	public static void main(String[] args) {
		int a = 0;
		
		if			(a > 0)	System.out.printf("%d → 양수...\n", a);
		else if	(a < 0)	System.out.printf("%d → 음수...\n", a);
		else					System.out.printf("왜 하필 0이야...\n");

		// 학점 판별 문제
		Scanner	sc		= new Scanner(System.in);
		int			score;
		char		grade;
		
		System.out.print("JAVA 점수(0~100) 입력: ");
		score = sc.nextInt();

		/*// if 문 이용
		if			(score >= 90	&& score <= 100)	grade = 'A';
		else if	(score >= 80	&& score <= 90)	grade = 'B';
		else if	(score >= 70	&& score <= 80)	grade = 'C';
		else if	(score >= 60	&& score <= 70)	grade = 'D';
		else if	(score >= 0	&& score <= 60)	grade = 'F';
		else	grade = '?';
		*/	
		
		// 1. 더 짧은 if
		if			(score >= 90	&& score <= 100)	grade = 'A';
		else if	(score >= 80)								grade = 'B';
		else if	(score >= 70)									grade = 'C';
		else if	(score >= 60)								grade = 'D';
		else if	(score >= 0)									grade = 'F';
		else	grade = '?';
		
		// 2. 신박한 if
		grade = '?';
		if	(score >= 0	&& score <= 100)	grade = 'A';
		if	(score < 90)									grade++;
		if	(score < 80)									grade++;
		if	(score < 70)									grade++;
		if	(score < 60)									grade += 2;
		
		System.out.printf(grade == '?'?	"자바 점수를 못 자바써요\n" :
																	"%c 학점을 받았습니다.\n", grade);
		sc.close();
	}
}
