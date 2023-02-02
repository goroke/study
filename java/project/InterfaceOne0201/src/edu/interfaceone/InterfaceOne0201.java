package edu.interfaceone;

interface IZerg{
	void display();
	default void zergAttack() {System.out.println("zerg 공격");}
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
		System.out.println("승객을운");
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
		System.out.println("terran 공격");
	}

	@Override
	public void protossAttack() {
		System.out.println("protoss 공격");		
	}
	
}

interface IVehicle{
	// 클래스의 static은 상속이 되는데 얘는 상속이 안 된다.
	int makeYear = 2022;
	
	abstract void start();
	abstract int speed();
	abstract void drive();
	
	// public 함수는 default를 안 붙이면 abstract로 간주한다.
	public default void stop() {System.out.println("\"멈춰\" 외치니..");}
	public static void turn() {System.out.println("turn");;}
	private void show() {}
	public static void trafficLight() {};
	
	// 하위 클래스 (부품, 구성 요소라고 생각하면 된다.)
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
		System.out.println("Car 가 출발한다.");		
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
		// interface는 다중 상속이 되기 때문에 super 를 쓸 수 없다(super가 여럿이기 때문).
		System.out.println("stop");
	}

	public void drive() {
		System.out.println("drive");
	}
}

public class InterfaceOne0201 {

	public static void main(String[] args) {
		Car k5 = new Car () {public void drive() {System.out.println("no drive");}};
		if( k5 instanceof Car ) ((Car) k5).drive();	// 혹은 IVehicle 인터페이스에 drive 메서드를 추가해도 된다.
		k5.start();
		k5.stop();
		IVehicle.turn();
		k5.fetch();
		System.out.println();
		
		// 유넬
		IGame yunel = new StarCraft();
		yunel.zergAttack();
		yunel.terranAttack();
		yunel.protossAttack();
		yunel.display();
		yunel.gg();
	}
}
