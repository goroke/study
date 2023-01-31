package edu.inheritance;

// import java.util.Scanner;

class Person {
	protected String	name = null;
	protected int		age = 0;
	
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

class Man extends Person {
	public Man(){}
	public Man(String name){}
	public Man(String name, int age){super(name, age);}
	
	private int money = 0;
	private int pay   = 100;
	private String job = null;
	
	public void work() {
		this.money += pay;
		System.out.printf("%s씨가 출근했습니다.\n", name);
	}
	
	public int getMoney() {
		// show me the money
		return this.money;
	}
}

public class Inheritance0131 {

	public static void main(String[] args) {
		Man man = new Man("???", 50);
		man.name("유비빔");
		man.talk("음식이 몸안에 들어가면 비벼져요");
		man.work();
		System.out.println(man.getMoney() + "원을 가지고 있습니다.");
		
		man.breathe();
		man.talk("세계분의 비빔박자대로 비벼보겠습니다.");
		System.out.println(man.age + "세 " + man.name + "씨");
	}

}
