package test.mypac;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
	
	//문자열을 전송하는 가상의 메소드 
	public static void sendMessage(String msg) {
		//금지된 단어 목록
		List<String> list=new ArrayList<String>();
		list.add("바보");
		list.add("똥깨");
		list.add("멍청이");
		
		for(int i=0; i<list.size(); i++) {
			String tmp=list.get(i);
			//전송할 문자열에 금지어가 있는지 확인하기
			if(msg.contains(tmp)) {
				//예외 발생 시키기
				throw new WordFilterException(tmp+"는 금지된 단어 입니다.");
			}
		}
		
		for(String tmp:list) {
			//전송할 문자열에 금지어가 있는지 확인하기
			if(msg.contains(tmp)) {
				//예외 발생 시키기
				throw new WordFilterException(tmp+"는 금지된 단어 입니다.");
			}
		}
		
		list.forEach(tmp->{
			//전송할 문자열에 금지어가 있는지 확인하기
			if(msg.contains(tmp)) {
				//예외 발생 시키기
				throw new WordFilterException(tmp+"는 금지된 단어 입니다.");
			}
		});
		
		System.out.println(msg+" 를 전송 했습니다.");
	}
	
	//5 초가 걸리는 가상의 그림을 그리는 메소드
	public static void draw() {
		System.out.println("5초 동안 그림을 그려요...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("그림 완성!");
	}
	//5초가 걸리는 가상의 전송을 하는 메소드
	public static void send() throws InterruptedException {
		System.out.println("5초 동안 전송을 해요...");
		
		Thread.sleep(5000);
		
		System.out.println("전송 완료!");
	}
}
