package _help5;
import java.sql.*;

import javax.swing.JOptionPane;
public class MemoSelect2 {

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
		
		String name=JOptionPane.showInputDialog(
			"검색할 작성자명을 입력하세요");
		//특정 작성자가 쓴 글만 출력하세요=> where절 select문
		String sql
	="SELECT idx,name,msg,wdate FROM memo WHERE name='"+name+"'";
		
		//'길'자가 입력되면 홍길동 김길동..글이 모두 나오게
		String sql2="SELECT idx,name,msg,wdate FROM MEMO"
					+" WHERE name LIKE '%"+name+"%'";
		
		System.out.println(sql2);
		
		ResultSet rs=stmt.executeQuery(sql2);
		System.out.println("----"+name+"님 글 검색 결과-----");
		while(rs.next()){
			//int idx=rs.getInt("idx");//컬럼명 지정
			int idx=rs.getInt(1);//컬럼인덱스를 지정
			String name2=rs.getString(2);
			String msg=rs.getString(3);
			Date wdate=rs.getDate(4);
			System.out.println(idx+"\t"+name2+"\t"+msg+"\t"+wdate);
		}
		System.out.println("-------------------------------");
		rs.close();
		stmt.close();
		con.close();

	}

}//////////////////////////////////////////





