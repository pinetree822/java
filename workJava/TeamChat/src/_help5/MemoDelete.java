package _help5;
import java.sql.*;
import java.io.*;
import java.util.Properties;//Hashtable의 자식 클래스

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args) 
	throws Exception
	{
		//DB.properties파일과 스트림 연결
		FileReader fr=new FileReader("DB.properties");
		Properties prop=new Properties();
		//키값과 밸류값을 매핑하여 저장한다.
		prop.load(fr);
		//DB.properties파일 내용이 Properties객체에 저장됨
		//System.out.println(prop.getProperty("driver"));
		//System.out.println(prop.getProperty("dburl"));
		Class.forName(prop.getProperty("driver"));
		String url=prop.getProperty("dburl");
		String user=prop.getProperty("user");
		String pwd=prop.getProperty("pwd");
		Connection con
		=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결 성공");
		//삭제할 글번호를 입력받는다.=>JOptionPane이용
		String idxStr
		=JOptionPane.showInputDialog(
				"삭제할 글번호를 입력하세요");
		
		//Statement얻어오기
		Statement stmt=con.createStatement();
		
		//SQL문 작성=> DELETE문 작성
		String sql="DELETE FROM memo WHERE idx="+idxStr;
		System.out.println(sql);
		
		//execute()로 실행
		/*DML문장(insert,delete,update문)인 경우
		 * public int executeUpdate(String sql)
		 * 메소드를 활용한다.
		 * sql문에 의해 영향받은 레코드수를 반환한다.
		 * */
		int delCount=stmt.executeUpdate(sql);
		System.out.println("삭제된 레코드수: "+delCount);
		if(delCount>0){
		System.out.println("삭제 처리됨");
		}else{
		System.out.println("삭제 실패: 글번호가 존재하지 않아요");
		}
		//db연결 종료
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		
	}

}










