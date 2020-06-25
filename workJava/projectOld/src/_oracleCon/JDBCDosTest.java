import java.sql.*;

class JDBCDosTest
{
	public static void main(String[] args) throws SQLSyntaxErrorException
	{
		try
		{
			// 1. 드라이버 로딩 - ojdbc7.jar
			// => Class.forName("패키지명.드라이버명")메소드를 이용
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success~~");

			// 2. DB와 연결 : DriverManager.getConnection()
			// DriverManager 클래스이다
			// => Connection con=DriverManager.getConnection(url, user, pwd)

			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			// jdbc,디비타입,드라이버타입,ip,port,전역데이타베이스
			// 프로토콜:oracle:드라이버타입:@호스트:포트번호:SID
			// url은 DBMS사마다 다르다.

			String user="scott";
			String pwd ="tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connected..");

			// 3. DB에 SQL문을 전송하기 위해 Statment객체를 얻어온다.
			// Connection의 createStatement()를 이용
			Statement stmt = con.createStatement();
			
			// 4. SQL문 작성
			String sql = "CREATE TABLE memo1";
					sql += "(";
					sql += "idx number(4) primary key,";
					sql += "name varchar2(20) not null,";
					sql += "msg varchar2(100),";
					sql += "wdate date default sysdate";
					sql += ")";

			// 5. SQL문을 DB에 전송(실행)
			// => Statement의 executeXXX() 메소드를 통해
			// boolean execute(String sql) : 
			//		sql문이 [ select문 ]일 경우는 true를 반환하고,
			//				[ 그 외 문장 ]일 경우는 false를 반환

			boolean isRs = stmt.execute(sql);		// sql문 실행 - 실패하면 exception 일어남
			System.out.println("isRs = " + isRs);	// 검증확인, 성공해도 false가 뜬다.
			
			// 6. DB자원 반납
			stmt.close();	// sql 자원반납
			con.close();	// con 자원반납

			/*
			Driver Loading Success~~
			DB Connected..
			isRs = false
			드라이버 로딩 성공
			*/
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		System.out.println("드라이버 로딩 성공");

	}//public static void main(String[] args)
}// class JDBCTest




/*
CREATE TABLE memo1 (
  idx number(4) primary key,
  name varchar2(20) not null,
  msg varchar2(100),
  wdate date default sysdate
)
 */