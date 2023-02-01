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
		System.out.printf("%s: �ƹ���\n", name);
	}	
	
	public void talk(String ment) {
		System.out.printf("%s: %s\n", name, ment);
	}	
	
	public void breathe() {
		System.out.println("ȭ ���� ��õ��û");
	}
	
	public void attack(Person target) {
		target.talk("����");
	}
	
	public Person(String name) {
		this.name = name;
		this.age  = 1;
		System.out.println("�� ���ֿ���");
	}

	public Person(String name, int age) {
		this.name = name;
		this.age  = age;
		System.out.printf("%d��° ��� %s(%d) ����\n", ++population, name, age);
	}
	
	public Person() {this("A", 100);}
	public String name() {return name;}
	public void name(String name){
		this.name = name;
		System.out.printf("2023�� %s���� �̸� ����!\n", name);
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
		System.out.printf("%s���� ����߽��ϴ�.\n", name);
	}
	
	public int getMoney() {
		// show me the money
		return this.money;
	}
	
	public void setJob(String job) {this.job = job;}
	public String getJob() {return job;}
	
	@Override
	public String toString() {
		return name + "(" + age +")/" + job + " - �ܰ� " + money + "��, IQ " + super.IQ;
	}
}

public class Inheritance0131 {

	public static void main(String[] args) {
		Man man = new Man("���缮", 52, 70000, "����MC");
		System.out.println(man);
	}

}

