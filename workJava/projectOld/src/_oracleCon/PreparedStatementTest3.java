import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import java.io.*;
/// insert����


class  PreparedStatementTest3
{
	public static void main(String[] args) 
		throws Exception
	{
		// �޸� ���̺��� ������ ��������(�ۼ���,�޸���,�ۼ���)
		Scanner sc = new Scanner(System.in);

		System.out.println("�Է����� �ۼ��� �Է�=>");
		String name = sc.next(); // ���Ͷ����� nextLine() �Ѿ��.
		sc.skip("\r\n");
		
		System.out.println("�Է��� �޸𳻿� �Է�=>");
		String msg = sc.nextLine();
		System.out.println( name + "/" + msg );

		
		
		
		// ����Ÿ���̽� ���� �ε�
		FileReader fr = new FileReader("DB.properties");
		Properties p = new Properties();
		p.load(fr);
		
		// ����Ÿ���� �ʱ�ȭ
		Class.forName(p.getProperty("dbdriver"));
		String url = p.getProperty("dburl");
		String user = p.getProperty("dbuser");
		String pwd = p.getProperty("dbpwd");
				
		// ����Ÿ���̽� ����
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("db���Ἲ��");
		
		
		
		

		// 1. SQL�� �ۼ� => Insert�� �ۼ�
		//String sql = "INSERT INTO  MEMO ( idx ,name, msg, wdate ) VALUES ( ? , ? , ?,  ?  )";
		String sql = "INSERT INTO  MEMO ( idx ,name, msg, wdate ) VALUES ( MEMO_IDX_SEQ.NEXTVAL , ? , ?,  sysdate  )";
		System.out.println(sql);
		
		
		// PreparedStatement �� ���
		//Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement(sql);
		

		// in �Ķ���� (?) ���� ����
		//pstmt.setString(0, "MEMO_IDX_SEQ.NEXTVAL");
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		//pstmt.setDate(3, new java.sql.Date().toString()); // �ڹٿ��� Oracle������ ���缭 �־��ֱ�
		

		// ����
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt > 0 ? "����" : "����");
		//System.out.println(str);
		
		
		// ��� �޽��� ���
		
		
		// db�ڿ� �ݳ�
		
		// select * memo;
		// DB���� ����	
		pstmt.close();
		con.close();
		sc.close();
	}
}
/*



  
*/
