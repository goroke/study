package edu.oopfirst;

import java.util.Scanner;

class Person {
	private String	name = null;
	private int		age = 0;
	
	private static int population = 0;

	public void display() {
		// System.out.printf();
	}
	
	public void talk() {
		System.out.printf("%s: 아무말\n", name);
	}	
	
	public void talk(String ment) {
		System.out.printf("%s: %s\n", name, ment);
	}	
	
	public void breathe() {
		System.out.println("화 오후 금천구청");
	}
	
	public void attack(Person target) {
		target.talk("으윽");
	}
	
	public Person(String name) {
		this.name = name;
		this.age  = 1;
		System.out.println("아 응애에요");
	}

	public Person(String name, int age) {
		this.name = name;
		this.age  = age;
		System.out.printf("%d번째 멤버 %s(%d) 등장\n", ++population, name, age);
	}
	
	public Person() {
		this("A", 100);
	}

 	public String name() {
		return name;
	}
 	
 	public int age() {
		return age;
	}
 	
 	public void setAge(int age) {
		this.age = age;
	} 	
 	
	public void name(String new_name){
		name = new_name;
		System.out.printf("2023년 %s으로 이름 개명!\n", new_name);
	}
	
	public static int getPopulation() {
		return Person.population;
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
		
		System.out.printf("hyunbin.name=\"%s\"\nhyunbin.age=%d\n",
						   golbin.name(), golbin.age());
		
		golbin.talk();
		golbin.talk("ㅗ무말멎렂");
		System.out.print(Person.getPopulation());
		
		sc.close();
	}
} 