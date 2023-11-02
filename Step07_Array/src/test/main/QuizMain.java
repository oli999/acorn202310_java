package test.main;

import java.util.Random;

public class QuizMain {
	public static void main(String[] args) {
		/*   
		 *   1. run 했을때
		 		cherry, apple, banana, melon, 7
		 *      5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.  
		 *      
		 *      hint)
		 *      Random 객체와 String[] 객체를 활용해 보세요.
		 */
		String[] data= {"cherry", "apple", "banana", "melon", "7"};
		//랜덤한 숫자를 얻어낼수 있는 객체 생성 
		Random ran=new Random();
		int ranNum=ran.nextInt(5);
		System.out.println(data[ranNum]);
		
	}
}









