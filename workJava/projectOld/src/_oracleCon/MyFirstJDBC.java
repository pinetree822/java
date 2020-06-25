
import java.sql.*;

public class MyFirstJDBC {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		
		// 2. DB연결
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "scott";
		String pwd = "tiger";

		// 연결이 안되면 SQLException 발생
		Connection con = DriverManager.getConnection(url, user, pwd); // static method인 Connection
		System.out.println("DB Connected.");
		
		// 3. Statement얻어오기
		Statement stmt = con.createStatement();
		
		// 4. 전송할 쿼리문(SQL문) 작성
		String sql = "INSERT INTO ";
		sql += "MEMO ";
		sql += "(" + "idx" +","+ "name" +","+ "msg" + ") ";
		sql += " VALUES(";
		sql += "3" + ",";
		sql += "'" +"홍길동" + "'" + ",";
		sql += "'" +"첫번째 글입니다.*^^*" + "'" + "";
		sql += ")";
		System.out.println(sql);
		
		// 5. execute()메소드로 실행
		boolean isRs = stmt.execute(sql);
		System.out.println("isRs = " + isRs);
		// execute하면 자동으로 commit된다.
		
		
		// 6. close()
		stmt.close();
		con.close();
	}
}

/*
 * 
	드라이버 로딩 성공!
	DB Connected..
	INSERT INTO MEMO (idx,name,msg)  VALUES(1,'홍길동','첫번째 글입니다.*^^*')

	드라이버 로딩 성공!
	DB Connected.
	INSERT INTO MEMO (idx,name,msg)  VALUES(2,'홍길동','첫번째 글입니다.*^^*')
	isRs = false

	드라이버 로딩 성공!
	DB Connected.
	INSERT INTO MEMO (idx,name,msg)  VALUES(3,'홍길동','첫번째 글입니다.*^^*')
	isRs = false


SQL> select * from memo;

       IDX NAME                 MSG                                                                                          WDATE
---------- -------------------- ---------------------------------------------------------------------------------------------------- --------
         2 홍길동               첫번째 글입니다.*^^*                                                                         16/10/17
         3 홍길동               첫번째 글입니다.*^^*                                                                         16/10/17
         1 홍길동               첫번째 글입니다.*^^*                                                                         16/10/17
 * */



