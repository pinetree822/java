import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import java.io.*;

// update관련

class  PreparedStatementTest2
{
	public static void main(String[] args) 
		throws Exception
	{
		// 메모 테이블의 내용을 수정하자(작성자,메모자,작성일)
		Scanner sc = new Scanner(System.in);

		System.out.println("수정할 글번호 입력=>");
		int idx = sc.nextInt();
		System.out.println("수정할 작성자 입력=>");
		String name = sc.next(); // 엔터때문에 nextLine() 넘어간다.
		sc.skip("\r\n");
		
		System.out.println("수정할 메모내용 입력=>");
		String msg = sc.nextLine();
		System.out.println( idx + "/" + name + "/" + msg );

		
		
		
		// 데이타베이스 정보 로드
		FileReader fr = new FileReader("DB.properties");
		Properties p = new Properties();
		p.load(fr);
		
		// 데이타정보 초기화
		Class.forName(p.getProperty("dbdriver"));
		String url = p.getProperty("dburl");
		String user = p.getProperty("dbuser");
		String pwd = p.getProperty("dbpwd");
				
		// 데이타베이스 연결
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("db연결성공");
		
		// PreparedStatement 는 sql문을 전처리(미리 컴파일)
		// 시켜놓기 때문에 미리 sql문을 작성해 놓아야 한다.
		
		String sql = "Update MEMO SET name=?, msg=?, wdate=sysdate WHERE idx=?"; // ? 컬럼 index : 1,2,3
		System.out.println(sql);
		/* 
		 * ?
		 * IN Parameter
		 * 
		 * PreparedStatement는 ?를 제외한 sql문을 DB포맷에 맞게 
		 * 컴파일 하여 미리 준비시켜 놓는다.
		 * 
		 */
		// Stmt 얻기
		//Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		// ?의 값을 셋팅
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		pstmt.setInt(3, idx);
		
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt > 0 ? "성공" : "실패");
		//System.out.println(str);
		
		
		
		
		// select * memo;
		// DB연결 종료	
		pstmt.close();
		con.close();
		sc.close();
	}
}
/*



  
*/
