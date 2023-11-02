package test.auto2;

import test.auto.Car;
import test.auto.Engine;

public class MiniCar extends Car{

	public MiniCar(Engine engine) {
		super(engine);
		
	}
	
	public void openTrunk() {
		if(this.engine == null) {
			System.out.println("Engine 이 없어서 차가 동작하지 않아요");
			return;
		}
		System.out.println("트렁크를 열어요!");
	}

}
