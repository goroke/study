package edu.interfaceone;

interface IVehicle{
	int makeYear = 2022;
	
	abstract void start();
	abstract int speed();
	
	public default void stop() {};
	private void show() {};
	public static void trafficLight() {};
	
	// ���� Ŭ���� (��ǰ, ���� ��Ҷ�� �����ϸ� �ȴ�.)
	static class Price{
		int salesPercent = 10;
	}
}

class Car implements IVehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int speed() {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class InterfaceOne0201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IVehicle.Price() ;
	}

}
