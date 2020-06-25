package _help5;
import java.sql.*;
import java.util.*;
import java.io.*;
public class PreparedStatementTest2 {

	public static void main(String[] args) 
	throws Exception
	{
		//메모 테이블의 내용을 수정하자 (작성자, 메모내용, 작성일)
		Scanner sc=new Scanner(System.in);
		System.out.println("수정할 글번호 입력=>");//PK
		int idx=sc.nextInt();
		System.out.println("수정할 작성자 입력=>");
		String name=sc.next();
		sc.skip("\r\n");//엔터값 건너뛰기
		System.out.println("수정할 메모내용 입력=>");
		String msg=sc.nextLine();
		System.out.println(idx+"/"+name+"/"+msg);
		
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
		//m98-017-160
		//PreparedStatement는 sql문을 전처리(미리 컴파일)
		//시켜놓기 때문에 미리 sql문을 작성해 놓아야 한다.
		String sql
		="UPDATE memo SET name=?, msg=?, wdate=sysdate WHERE idx=?";
		/* ?
		 * IN Parameter
		 * PreparedStatement는 ? 를 제외한 sql문을 DB포맷에 맞게
		 * 컴파일 하여 미리 준비시켜 놓는다.
		 * */
		PreparedStatement pstmt=con.prepareStatement(sql);
		//	Statement stmt=con.createStatement();
		
		//? 의 값을 셋팅
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		pstmt.setInt(3, idx);
		
		
		int cnt=pstmt.executeUpdate();//db에 전송
		//int cnt=stmt.executeUpdate(sql);
		System.out.println(cnt>0? "성공":"실패");
		
		pstmt.close();
		con.close();
		sc.close();

	}

}










