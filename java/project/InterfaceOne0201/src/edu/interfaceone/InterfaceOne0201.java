package edu.interfaceone;

interface IZerg{
	void display();
	default void zergAttack() {System.out.println("zerg ����");}
}

interface ITerran{
	void terranAttack();
}

interface IProtoss{
	void protossAttack();
}

interface IGame extends IZerg, ITerran, IProtoss{
	public void gg();
}

class Carrier{

	public void fetch() {
		System.out.println("�°�����");
	}

}


class StarCraft implements IGame{

	@Override
	public void display() {
		System.out.println("Display Zerg");
	}

	@Override
	public void gg() {
		System.out.println("GG");
	}

	@Override
	public void terranAttack() {
		System.out.println("terran ����");
	}

	@Override
	public void protossAttack() {
		System.out.println("protoss ����");		
	}
	
}

interface IVehicle{
	// Ŭ������ static�� ����� �Ǵµ� ��� ����� �� �ȴ�.
	int makeYear = 2022;
	
	abstract void start();
	abstract int speed();
	abstract void drive();
	
	// public �Լ��� default�� �� ���̸� abstract�� �����Ѵ�.
	public default void stop() {System.out.println("\"����\" ��ġ��..");}
	public static void turn() {System.out.println("turn");;}
	private void show() {}
	public static void trafficLight() {};
	
	// ���� Ŭ���� (��ǰ, ���� ��Ҷ�� �����ϸ� �ȴ�.)
	static class Price{
		int salesPercent = 10;
	}
}

class Overlord implements IZerg, IVehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int speed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}

class Car extends Carrier implements IVehicle{
	private int speed;
	
	@Override
	public void start() {
		System.out.println("Car �� ����Ѵ�.");		
	}

	@Override
	public int speed() {
		return ++speed;
	}
	
	public Car() {
		System.out.println("Car()");
	}
	
	@Override
	public void stop() {
		// interface�� ���� ����� �Ǳ� ������ super �� �� �� ����(super�� �����̱� ����).
		System.out.println("stop");
	}

	public void drive() {
		System.out.println("drive");
	}
}

public class InterfaceOne0201 {

	public static void main(String[] args) {
		Car k5 = new Car () {public void drive() {System.out.println("no drive");}};
		if( k5 instanceof Car ) ((Car) k5).drive();	// Ȥ�� IVehicle �������̽��� drive �޼��带 �߰��ص� �ȴ�.
		k5.start();
		k5.stop();
		IVehicle.turn();
		k5.fetch();
		System.out.println();
		
		// ����
		IGame yunel = new StarCraft();
		yunel.zergAttack();
		yunel.terranAttack();
		yunel.protossAttack();
		yunel.display();
		yunel.gg();
	}
}
