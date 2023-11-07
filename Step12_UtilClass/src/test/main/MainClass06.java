package test.main;

import test.mypac.Car;

public class MainClass06 {
	public static void main(String[] args) {
		useNums();
		useNums(10);
		useNums(10, 20);
		useNums(10, 20, 30);
		
		useStrings();
		useStrings("kim", "lee", "park");
		
		useCars();
		useCars(new Car("소나타"));
		useCars(new Car("프라이드"), new Car("아반떼"));
	}
	//Integer type 여러개를 전달받는 메소드 
	public static void useNums(Integer... nums) { //nums 는 Integer[] type 이다.
		
	}
	//String type 여러개를 전달 받는 메소드 
	public static void useStrings(String... strs) {//strs 는 String[] type 이다
		
	}
	//Car type 여러개를 전달 받는 메소드 
	public static void useCars(Car... cars) { //cars 는 Car[] type 이다
		
	}
}





