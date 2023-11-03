package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		
		Weapon w1=new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무나 공격하자!");
			}
		};
		
		useWeapon(w1);
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무나 공격해요");
			}
		});
	}
	
	//Weapon type 의 참조값을 전달 받아서 사용하는 static 메소드 
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}
}



