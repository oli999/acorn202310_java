package test.main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import test.dto.MemberDto;

public class MainClass11 {
	public static void main(String[] args) {
		// members.dat 파일에 저장된 MemberDto 객체를 읽어와서 회원의 번호, 이름, 주소를 콘솔에 출력해 보세요
		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis=new FileInputStream("c:/acorn202310/myFolder/members.dat");
			ois=new ObjectInputStream(fis);
			//읽어낸 Object 를 원래 type 인 MemberDto type 으로 casting 한다.
			MemberDto dto=(MemberDto)ois.readObject();
			String info=String.format("%d %s %s", dto.getNum(), dto.getName(), dto.getAddr());
			System.out.println(info);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois!=null)ois.close();
				if(fis!=null)fis.close();
			}catch(Exception e) {}
		}
	}
}








