package test.main;

public class QuizMain {
	/*
	 *  run 했을때 콘솔창에 
	 *  1초
	 *  2초
	 *  3초
	 *  .
	 *  .
	 *  경과 시간이 출력되다가
	 *  .
	 *  .
	 *  10초
	 *  까지만 출력하고 종료되는 프로그래밍을 해 보세요.
	 */
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			int sec=i+1;
			System.out.println(sec+"초");
		}
		
	}
}




















