import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import java.io.*;

// update����

class  PreparedStatementTest2
{
	public static void main(String[] args) 
		throws Exception
	{
		// �޸� ���̺��� ������ ��������(�ۼ���,�޸���,�ۼ���)
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �۹�ȣ �Է�=>");
		int idx = sc.nextInt();
		System.out.println("������ �ۼ��� �Է�=>");
		String name = sc.next(); // ���Ͷ����� nextLine() �Ѿ��.
		sc.skip("\r\n");
		
		System.out.println("������ �޸𳻿� �Է�=>");
		String msg = sc.nextLine();
		System.out.println( idx + "/" + name + "/" + msg );

		
		
		
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
		
		// PreparedStatement �� sql���� ��ó��(�̸� ������)
		// ���ѳ��� ������ �̸� sql���� �ۼ��� ���ƾ� �Ѵ�.
		
		String sql = "Update MEMO SET name=?, msg=?, wdate=sysdate WHERE idx=?"; // ? �÷� index : 1,2,3
		System.out.println(sql);
		/* 
		 * ?
		 * IN Parameter
		 * 
		 * PreparedStatement�� ?�� ������ sql���� DB���˿� �°� 
		 * ������ �Ͽ� �̸� �غ���� ���´�.
		 * 
		 */
		// Stmt ���
		//Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		// ?�� ���� ����
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		pstmt.setInt(3, idx);
		
		int cnt = pstmt.executeUpdate();
		System.out.println(cnt > 0 ? "����" : "����");
		//System.out.println(str);
		
		
		
		
		// select * memo;
		// DB���� ����	
		pstmt.close();
		con.close();
		sc.close();
	}
}
/*



  
*/
