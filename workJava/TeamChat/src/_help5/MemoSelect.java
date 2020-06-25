package _help5;
import java.sql.*;
public class MemoSelect {

	public static void main(String[] args) 
	throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con
		=DriverManager.getConnection(url, user, pwd);
		System.out.println("DB연결됨");
		
		Statement stmt=con.createStatement();
		
		String sql
		="SELECT idx, name, msg, wdate FROM memo ORDER BY 1";
		//DML문장(INSERT,DELETE,UPDATE)=> int executeUpdate(sql)
		//DQL문장(SELECT문)=> ResultSet executeQuery(sql)
		
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println("-----------------------");
		//ResultSet의 메소드
		//boolean next() :
		/*rs의 논리적 커서는 첫번째 행의 직전에 위치한다.
		 * => before first
		 * next()가 호출되면 커서를 다음으로 이동시킨다.
		 * 이동시켜 가리키는 지점에 레코드가 있으면 true를 반환,
		 * 없으면 false를 반환한다.
		 * ----------------------------------
		 * 자료형 getXXX("컬럼명") : 해당 컬럼값을 꺼낼 때 호출
		 * 이때 오라클 자료형과 자바 자료형을 맞춰서 꺼내오자.
		 * */
		
		while(rs.next()){
			int idx=rs.getInt("idx");//글번호값 받기
			String name=rs.getString("name");//작성자
			String msg=rs.getString("msg");//메모내용
			java.sql.Date wdate=rs.getDate("wdate");//작성일
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		System.out.println("-----------------------");
		
		rs.close();
		stmt.close();
		con.close();

	}

}//////////////////////////////////////////





