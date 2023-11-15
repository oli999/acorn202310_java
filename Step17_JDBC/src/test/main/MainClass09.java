package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass09 {
	//전체 회원의 목록을 리턴하는 메소드
	public static List<MemberDto> getList(){
		//ArrayList 회원정보를 누적 시킬 ArrayList 객체를 미리 생생한다. 
		List<MemberDto> list=new ArrayList<>();
		
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
					+ " ORDER BY num ASC";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			rs=pstmt.executeQuery();
			
			//반복문 돌면서 
			while(rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				//cursor 가 위치한 곳에서 num, name, addr 칼럼의 정보를 얻어낸다.
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				//MemberDto 객체를 생성해서
				MemberDto dto=new MemberDto();
				//회원 한명의 정보를 담고
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				//ArrayList 객체 누적 시키기 
				list.add(dto);
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
		//회원 목록이 담겨있는 객체의 참조값을 리턴해 준다. 
		return list;
	}
	// run 했을때 실행의 흐름이 시작되는 main 메소드 
	public static void main(String[] args) {
		//메소드를 이용해서 회원 목록 얻어내기
		List<MemberDto> list=getList();
		//얻어낸 회원 목록 사용하기 
		for(MemberDto tmp:list) {
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
		}
	}
}










