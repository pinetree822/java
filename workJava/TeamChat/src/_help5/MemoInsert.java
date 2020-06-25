package _help5;
import java.sql.*;
import javax.swing.*;

public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		//메모 테이블에 메모 내용을 등록해보자.
		String name
		=JOptionPane.showInputDialog("작성자를 입력하세요");
		String msg
		=JOptionPane.showInputDialog("메모 내용을 입력하세요");
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/*1) OracleDriver를 메모리에 로드한다.
		 *2) OracleDriver객체를 DriverManager에 등록한다.
		 *- DriverManager는 드라이버들을 관리하는 클래스로
		 *  여러 드라이버들을 Vector에 저장하여 관리한다. 
		 * */
		
		//2. db연결 => Connection 얻기 (DriverManager통해서)
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con=DriverManager.getConnection(url,user,pwd);
		
		//3. Statement얻기=> Connection 통해서
		Statement stmt=con.createStatement();
		
		//4. SQL문 작성=> INSERT문 작성
		String sql="INSERT INTO memo(idx,name,msg,wdate)";
	sql+="VALUES(memo_idx_seq.nextval,'"+name+"','"+msg+"',sysdate)";
		System.out.println(sql);
		
		//5. stmt의 execute()메소드로 전송
		boolean b=stmt.execute(sql);
		System.out.println("b="+b);
		//select문이면=>true, 그 외 문장=>false반환
		
		//6. DB 자원 반납=> close()
		stmt.close();
		con.close();
	}

}




