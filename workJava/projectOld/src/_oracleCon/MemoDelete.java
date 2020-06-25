import java.sql.*;
import java.io.*;
import java.util.Properties;	// Hashtable의 자식 클래스

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args)
	throws Exception
	{
		// DB.properties파일과 스트림 연결
		FileReader fr = new FileReader("DB.properties");
		Properties prop = new Properties(); // 키값과 밸류값을 매핑하여 저장한다.
		prop.load(fr);
		// DB.properties파일 내용이 Properties객체에 저장됨

		
		
		/*

			// 밸류의 타입은?
			// 공란허용한다.
			// 특수문자처리?
			The load(Reader) / store(Writer, String) methods load 
			and store properties from 
			and to a character based stream in a simple line-oriented format specified below. 
			
			The load(InputStream) / store(OutputStream, String) methods 


		System.out.println(prop.getProperty("dbdriver"));
		System.out.println(prop.getProperty("dburl"));
		
//		oracle.jdbc.OracleDriver
//		jdbc:oracle:this:@localhost:1521:ORCL
		*/
		
		Class.forName(prop.getProperty("dbdriver").trim());
		String url = prop.getProperty("dburl");
		String user = prop.getProperty("dbuser");
		String pwd = prop.getProperty("dbpwd");
		//String str=prop.getProperty("subject");
		//System.out.println(str);
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB 연결 성공");
		
		// 삭제할 글번호를 입력받는다. => JOptionPane 이용
		String num = JOptionPane.showInputDialog("글번호를 입력하세요.");
		
		// Statement얻어오기
		Statement stmt = con.createStatement();
		
		// SQL문 작성 => DELETE문 작성
		//String sql = "DELETE FROM MEMO WHERE idx=1;"; //num
		String sql = "DELETE FROM MEMO WHERE idx=" + num; //


		/*
		 * 
		boolean isRs = stmt.execute(sql);
		System.out.println("실행 결과는 " + isRs);
		DB 연결 성공
		실행 결과는 false
		실행 문장은 DELETE FROM MEMO WHERE idx=1
		 */		
		
		/*
		// execute()로 실행
		 * 
		 * DML문장(insert, delete, update문)인 경우
		 * 
		 * public int executeUpdate(String sql)
		 * 메소드를 활용한다.
		 * sql문에 의해 영향받은 레코드 수를 반환한다.
		 * 
		 */
		

		int delCnt = stmt.executeUpdate(sql);

		if( delCnt > 0 )
		{
			//System.out.println("삭제된 문장은 " + delCnt + " 개 입니다.");
			JOptionPane.showMessageDialog(null, "삭제된 문장은 " + delCnt + " 개 입니다.");
		} else {
			//System.out.println("삭제된 문장이 없습니다. " );
			JOptionPane.showMessageDialog(null, "해당 글이 없습니다.");
		}
		System.out.println("실행 문장은 " + sql);	
		
		/*
		DB 연결 성공
		삭제된 문장은 1
		실행 문장은 DELETE FROM MEMO WHERE idx=10

		DB 연결 성공
		삭제된 문장은 0
		실행 문장은 DELETE FROM MEMO WHERE idx=100
		*/
		// db연결 종료
		
		//stmt.executeQuery("select * from memo");
		
		if(stmt != null) stmt.close();
		if(con != null) con.close();		
		
	}
	
}


