package _help5;
import java.sql.*;

public class MyFirstJDBC {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		
		//2. DB 연결
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결 성공!");
		
		//3. Statement얻어오기
		Statement stmt=con.createStatement();
		
		//4. 전송할 쿼리문(SQL문) 작성
		String sql="INSERT INTO memo(idx,name,msg)";
			   sql+=" VALUES(3,'최길동','두번째 글입니다.*^^*')";
		System.out.println(sql);	   
		
		//5. execute()메소드로 실행
		boolean b=stmt.execute(sql);
		System.out.println("b="+b);	
		//자동으로 commit됨
		
		//6. close()
		stmt.close();
		con.close();
	}

}





