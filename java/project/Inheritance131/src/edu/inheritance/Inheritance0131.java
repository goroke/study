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
		System.out.printf("2023�� %s���� �̸� ����!\n", new_name);
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
		System.out.printf("%s���� ����߽��ϴ�.\n", name);
	}
	
	public int getMoney() {
		// show me the money
		return this.money;
	}
}

public class Inheritance0131 {

	public static void main(String[] args) {
		Man man = new Man("???", 50);
		man.name("�����");
		man.talk("������ ���ȿ� ���� ������");
		man.work();
		System.out.println(man.getMoney() + "���� ������ �ֽ��ϴ�.");
		
		man.breathe();
		man.talk("������� ������ڴ�� �񺭺��ڽ��ϴ�.");
		System.out.println(man.age + "�� " + man.name + "��");
	}

}
