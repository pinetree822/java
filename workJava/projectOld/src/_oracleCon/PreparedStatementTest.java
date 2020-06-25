import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import java.io.*;

// update 관련

class  PreparedStatementTest
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
		
		// Stmt 얻기
		Statement stmt = con.createStatement();
		
		
		// sql문 작성		
		String sql = "UPDATE " + "MEMO ";
		sql += "SET ";
		sql += "name" + "="  + "'" +name+ "'"+ ",";
		sql += "msg" + "="  + "'" +msg+ "'"+ ",";
		sql += "wdate" + "="  + "SYSDATE ";
		sql += "WHERE ";
		sql += "idx" + "=" + idx;
		System.out.println(sql);
		
		// 실행		
		
		// 실행 결과 "1개의 레코드가 수정되었어요"		
		// 5. execute()메소드로 실행
		//boolean isRs = stmt.execute(sql);	
		// 실행 dml문 int = executeUpdate()메소드
		int isCnt = stmt.executeUpdate(sql);
		System.out.println("isCnt = " + isCnt);
		
		String str = (isCnt>0)?"수정성공":"수정된게 없습니다.";
		System.out.println(str);
		
		
		
		
		// select * memo;
		// DB연결 종료	
		stmt.close();
		con.close();
		sc.close();
	}
}
/*
IDX NAME                 MSG                     WDATE
---------- -------------------- ------------------------ --------
  2 홍길동               첫번째 글입니다.*^^*    16/10/17
  9 테스트1              안녕~                      16/10/18
  8 왕조현               홍콩아이돌                 16/10/18
  
SQL> select * from memo;

IDX NAME                 MSG                    WDATE
----- -------------------- ---------------------------- --------
2 홍길동               첫번째 글입니다.*^^*     16/10/17
9 테스트99             닷다다시 재수정합니다.  16/10/20
8 왕조현               홍콩아이돌                  16/10/18

  
  
*/


/*
 * 
String sql = "SELECT * "
				sql += "FROM " +  "MEMO "
				UPDATE MEMBER  SET REG_DATE = (  SELECT MAX(REG_DATE) FROM MEMBER    )
				 WHERE MILEAGE =0;
*/
