package _help5;

import java.io.FileReader;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class MemoInsert2 {

	public static void main(String[] args) 
			throws Exception
	{
		//메모 테이블의 내용을 수정하자 (작성자, 메모내용, 작성일)
		Scanner sc=new Scanner(System.in);
		
		System.out.println("작성자 입력=>");
		String name=sc.next();
		sc.skip("\r\n");//엔터값 건너뛰기
		System.out.println("메모내용 입력=>");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		
		FileReader fr=new FileReader("DB.properties");
		Properties p=new Properties();
		p.load(fr);
		
		Class.forName(p.getProperty("driver"));
		String url=p.getProperty("dburl");
		String user=p.getProperty("user");
		String pwd=p.getProperty("pwd");
		Connection con
		=DriverManager.getConnection(url,user,pwd);
		System.out.println("db연결 성공");
		//1. INSERT문을 작성
		String sql="INSERT INTO memo(idx,name,msg,wdate)";
		sql+=" VALUES(memo_idx_seq.nextval,?,?,sysdate)";
		
		//2. PreparedStatement얻기
		PreparedStatement pstmt
				=con.prepareStatement(sql);
		
		//3. in 파라미터 (?) 값을 셋팅
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		
		//4. 실행
		int cnt=pstmt.executeUpdate();
		
		//5. 결과 메시지 출력
		System.out.println(cnt>0? "등록 성공":"등록 실패");
		//6. db자원 반납
		pstmt.close();
		con.close();
		sc.close();
	}

}





