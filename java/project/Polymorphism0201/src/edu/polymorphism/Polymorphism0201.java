package edu.polymorphism;

abstract class Mammal {
	public Mammal() {
		System.out.println("Mammal()");
	}
	
	public void show() { System.out.println("�������� �� �� �� �𸥴�"); }
	public abstract void move();
}

class Person extends Mammal {
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
		++population;
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
	
	public void show() { super.show(); System.out.println("�ΰ� �����ֱ�"); }

	@Override
	public void move() { System.out.println("A person is moving."); }
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
	
	public void show() { super.show(); System.out.println("�ΰ� �Ⱥ����ֱ�"); }
	
	public void setJob(String job) {this.job = job;}
	public String getJob() {return job;}
	
	public void move() { System.out.println("A man is moving."); }
	
	@Override
	public String toString() {
		return name + "(" + age +")/" + job + " - �ܰ� " + money + "��, IQ " + IQ;
	}
}

public class Polymorphism0201 {

	public static void main(String[] args) {
		Mammal jaeseok = new Man("������", 52, 70000, "����MC");
		System.out.println(jaeseok);
		//jaeseok.talk("���� ������ Ǯ���ִ� �ű��� ��");

		((Man)jaeseok).work();
		jaeseok.show();
		System.out.println(((Man)jaeseok).getMoney()); // ��ƴ� �ִ�.
		//Man jaeseok2 = (Man) jaeseok;
		//jaeseok.getMoney();
		jaeseok.move();
		
		//new Mammal();
	}
	
}//opcn-kakao.com/gtZCUgVe = https://open.kakao.com/o/gLXhDTUe