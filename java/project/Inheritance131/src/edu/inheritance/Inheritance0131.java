package edu.inheritance;


//import java.util.Scanner;

class Person {
	protected String	name = null;
	protected int		age = 0;
	protected final int	IQ = 140;
	
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
	
	public Person() {this("A", 100);}
	public String name() {return name;}
	public void name(String name){
		this.name = name;
		System.out.printf("2023년 %s으로 이름 개명!\n", name);
	}
		
	public int age() {return age;}
	public void setAge(int age) {this.age = age;} 	

	public static int getPopulation() {
		return Person.population;
	}
}

class Man extends Person {
	final int IQ = 150;
	
	public Man(){}
	public Man(String name){super(name);}
	public Man(String name, int age){super(name, age);}
	
	public Man(String name, int age, int money, String job) {
		super(name, age);
		this.money = money;
		this.job   = job;
	}
	
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
	
	public void setJob(String job) {this.job = job;}
	public String getJob() {return job;}
	
	@Override
	public String toString() {
		return name + "(" + age +")/" + job + " - 잔고 " + money + "원, IQ " + super.IQ;
	}
}

public class Inheritance0131 {

	public static void main(String[] args) {
		Man man = new Man("유재석", 52, 70000, "국민MC");
		System.out.println(man);
	}

}

