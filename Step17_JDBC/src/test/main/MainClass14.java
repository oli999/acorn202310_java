package test.main;

import test.dao.MemberDao;

public class MainClass14 {
	public static void main(String[] args) {
		//10 번 회원을 삭제 하려면?
		int num=11;
		//MemberDao 객체를 이용해서 삭제하기 
		boolean isSuccess=new MemberDao().delete(num);
		if(isSuccess) {
			System.out.println(num+" 번 회원을 삭제 했습니다");
		}else {
			System.out.println(num+" 번 회원은 존재 하지 않습니다. 작업실패!");
		}
		
	}
}
