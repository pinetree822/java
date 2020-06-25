package _help5;
import java.sql.*;
import java.util.*;
import java.io.*;
public class PreparedStatementTest {

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
		// STMT 얻기
		Statement stmt=con.createStatement();
		
		//SQL문 작성=> UPDATE문
		String sql="UPDATE memo SET name='"+name+"',";
		sql+=" msg='"+msg+"', wdate=SYSDATE WHERE idx="+idx;
		
		System.out.println(sql);
		
		//실행=> dml문  int executeUpdate()
		int cnt=stmt.executeUpdate(sql);		
		
		//실행 결과 "1개의 레코드가 수정되었어요"
		//System.out.println(cnt+"개의 레코드가 수정되었어요");
		String str=(cnt>0)?"수정 성공":"수정 실패-글번호가 없어요";
		System.out.println(str);
		
		//DB연결 종료
		stmt.close();
		con.close();
		sc.close();

	}

}










