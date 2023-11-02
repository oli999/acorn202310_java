package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass03 {
	public static void main(String[] args) {
		//아래의 3줄을 실행하면 참조값이 몇개가 나올까? (객체가 몇개가 생성될까?)
		
		HandPhone p1=new HandPhone(); //여기서 HandPhone 객체는 1개만 생성된다.
		Phone p2=p1; //여기는 객체가 생성되는 것이 아니고 p1 에 들어 있던 참조값이 p2 에 복사되는 것이다. 
		Object p3=p1; //여기는 객체가 생성되는 것이 아니고 p1 에 들어 있던 참조값이 p3 에 복사되는 것이다. 
		
		//자식 객체의 참조값은 부모 type 변수나 필드에 자연스럽게 담긴다.	
	}
}













