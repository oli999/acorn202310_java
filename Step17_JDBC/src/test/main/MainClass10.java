package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	
	//매개변수에 전달된 회원번호에 해당되는 회원정보를 DB 에서 select 한 다음 MemberDto 객체에 담아서 
	//리턴하는 메소드를 완성 시켜 보세요.
	//num 에 해당하는 만일 회원정보가 없으면 null 을 리턴하도록 하세요
	public static MemberDto getData(int num) {
		
		MemberDto dto=null;
		
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn=new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql="SELECT num, name, addr"
					+ " FROM member"
					+ " WHERE num=?";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			//만일 select 된 row 가 존재 한다면  
			if(rs.next()) {
				//select 된 회원의 이름과 주소 읽어오기
				//String name=rs.getString("name");
				//String addr=rs.getString("addr");
				//num, name, addr 을 MemberDto 객체를 생성해서 담는다.
				dto=new MemberDto();
				dto.setNum(num); 
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return dto;
	}
	
	public static void main(String[] args) {
		int num=9;
		//1 번회원의 정보를 얻어와서 
		MemberDto dto=getData(num); // null 을 리턴할 가능성이 있기 때문에 대비 해야 한다.
		
		if(dto != null) {
			//사용하기
			System.out.println(num+" 번 회원의 이름은 "+dto.getName()+" 이고 주소는 "+dto.getAddr());
		}else {
			System.out.println(num+" 번 회원은 존재하지 않습니다.");
		}
		
		
	}
}








