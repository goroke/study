package edu.oopfirst;

import java.util.Scanner;

class Person {
	private String	name = null;
	private int		age = 0;
	
	public static int population = 0;
	
	public void talk(String ment) {
		System.out.printf("%s: %s\n", name, ment);
	}
	
	public void breathe() {
		System.out.println("화 오후 금천구청");
	}
	
	public void attack(Person target) {
		target.talk("으윽");
	}

	public Person(String m_name, int m_age) {
		name = m_name;
		age  = m_age;
		System.out.printf("%d번째 멤버 %s(%d) 등장\n", ++population, name, age);
	}


 	public String name() {
		return name;
	}
 	
 	public int age() {
		return age;
	}	
 	
	public void name(String new_name){
		name = new_name;
		System.out.printf("2023년 %s으로 이름 개명!\n", new_name);
	}
}

public class OOPOne0130 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String myname = null; int myage = 0;
		
		System.out.print("이름 입력하시오: ");
		myname = sc.nextLine();
		System.out.print("나이 입력하시오: ");
		myage = sc.nextInt();
		
		Person golbin = new Person(myname, myage);
		
		System.out.printf("hyunbin.name=\"%s\"\nhyunbin.age=%d",
						   golbin.name(), golbin.age());
	}
}