package edu.switches;

import java.util.Scanner;

public class SwitchOne0127 {
	
	public static void main(String[] args) {
		
		// 학점 판별 문제
		Scanner	sc		= new Scanner(System.in);
		int			score;
		char		grade;
		
		System.out.print("점수(0~100) 입력: ");
		score = sc.nextInt();

		// 구형 switch 문 이용
		grade = 'F';
		
		switch(score > 100? -1 : score / 10) {
		case 9: case 10:
			grade --;
		case 8:
			grade --;
		case 7:
			grade --;
		case 6:
			grade -= 2;
		case 5: case 4: case 3: case 2: case 1: case 0:
			break;
		default:
			grade = '?';
		} 
		
		/* grade = switch (score > 100? -1 : score / 10) {
		case 9, 10					-> 'A';
		case 8						-> 'B';
		case 7							-> 'C';
		case 6						-> 'D';
		case 0, 1, 2, 3, 4, 5	-> 'F';
		default						-> '?';
		}; */
		
		System.out.printf(grade == '?'?	"점수가 이상합니다.\n" :
																	"%c 학점을 받았습니다.\n", grade);
		
		sc.close();
	}
	
}
