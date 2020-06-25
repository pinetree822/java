import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import java.io.*;
/// insert관련


class  PreparedStatementTest3
{
	public static void main(String[] args) 
		throws Exception
	{
		// 메모 테이블의 내용을 수정하자(작성자,메모자,작성일)
		Scanner sc = new Scanner(System.in);

		System.out.println("입력할할 작성자 입력=>");
		String name = sc.next(); // 엔터때문에 nextLine() 넘어간다.
		sc.skip("\r\n");
		
		System.out.println("입력할 메모내용 입력=>");
		String msg = sc.nextLine();
		System.out.println( name + "/" + msg );

		
		
		
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
		
		
		
		

		// 1. SQL문 작성 => Insert문 작성
		//String sql = "INSERT INTO  MEMO ( idx ,name, msg, wdate ) VALUES ( ? , ? , ?,  ?  )";
		String sql = "INSERT INTO  MEMO ( idx ,name, msg, wdate ) VALUES ( MEMO_IDX_SEQ.NEXTVAL , ? , ?,  sysdate  )";
		System.out.println(sql);
		
		
		// PreparedStatement 는 얻기
		//Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement(sql);
		

		// in 파라미터 (?) 값을 세팅
		//pstmt.setString(0, "MEMO_IDX_SEQ.NEXTVAL");
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		//pstmt.setDate(3, new java.sql.Date().toString()); // 자바에서 Oracle유형에 맞춰서 넣어주기
		

		// 실행
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt > 0 ? "성공" : "실패");
		//System.out.println(str);
		
		
		// 결과 메시지 출력
		
		
		// db자원 반납
		
		// select * memo;
		// DB연결 종료	
		pstmt.close();
		con.close();
		sc.close();
	}
}
/*



  
*/
