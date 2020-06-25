package _help5;

import java.io.FileReader;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MemoSelect3 {
	public static void main(String[] args) 
			throws Exception
	{
		//메모 테이블의 내용을 수정하자 (작성자, 메모내용, 작성일)
		
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
		String name=JOptionPane.showInputDialog(
				"검색할 작성자를 입력하세요");
		
		//홍길동=> 홍길동이 입력한 글이 몇개 있는지 출력하는
		//sql문장을 작성
		//"3건의 글이 있습니다", "작성한 글이 없습니다"
		String sql="SELECT count(idx) cnt FROM memo WHERE name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		ResultSet rs=pstmt.executeQuery();
		boolean b=rs.next();//커서 이동
		if(b){
			//int count=rs.getInt(1);
			int count=rs.getInt("cnt");
			if(count<=0){
				System.out.println("작성한 글이 없어요!");
				return;
			}
			System.out.println(count+"개의 글이 있습니다.");
			
			//작성자(홍길동)의 글들을 가져와 출력하세요
			sql="SELECT idx, name, msg, wdate FROM memo";
			sql+=" WHERE name=? ORDER BY idx";
			PreparedStatement pstmt2
			=con.prepareStatement(sql);
			pstmt2.setString(1, name);
			ResultSet rs2=pstmt2.executeQuery();
			
			while(rs2.next()){
				int idx=rs2.getInt("idx");
				String name2=rs2.getString("name");
				String msg=rs2.getString("msg");
				Date wdate=rs2.getDate("wdate");
				System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
			}
			rs2.close();
			pstmt2.close();
			
		}//if-------------------------
		rs.close();
		pstmt.close();
		con.close();
	}

}













