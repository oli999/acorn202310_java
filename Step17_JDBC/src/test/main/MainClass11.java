package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass11 {
	
	public static void main(String[] args) {
		// 회원 한명의 정보를 추가 하려면?
		String name="원숭이2";
		String addr="상도동2";
		//위의 정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//MemberDao 객체의 메소드를 이용해서 추가 하기 
		MemberDao dao=new MemberDao();
		dao.insert(dto);
		
		System.out.println("회원 정보를 추가 했습니다.");
	}
}






