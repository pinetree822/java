package _help5;
import java.sql.*;
import java.util.*;
import java.io.*;
public class PreparedStatementTest2 {

	public static void main(String[] args) 
	throws Exception
	{
		//�޸� ���̺��� ������ �������� (�ۼ���, �޸𳻿�, �ۼ���)
		Scanner sc=new Scanner(System.in);
		System.out.println("������ �۹�ȣ �Է�=>");//PK
		int idx=sc.nextInt();
		System.out.println("������ �ۼ��� �Է�=>");
		String name=sc.next();
		sc.skip("\r\n");//���Ͱ� �ǳʶٱ�
		System.out.println("������ �޸𳻿� �Է�=>");
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
		System.out.println("db���� ����");
		//m98-017-160
		//PreparedStatement�� sql���� ��ó��(�̸� ������)
		//���ѳ��� ������ �̸� sql���� �ۼ��� ���ƾ� �Ѵ�.
		String sql
		="UPDATE memo SET name=?, msg=?, wdate=sysdate WHERE idx=?";
		/* ?
		 * IN Parameter
		 * PreparedStatement�� ? �� ������ sql���� DB���˿� �°�
		 * ������ �Ͽ� �̸� �غ���� ���´�.
		 * */
		PreparedStatement pstmt=con.prepareStatement(sql);
		//	Statement stmt=con.createStatement();
		
		//? �� ���� ����
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		pstmt.setInt(3, idx);
		
		
		int cnt=pstmt.executeUpdate();//db�� ����
		//int cnt=stmt.executeUpdate(sql);
		System.out.println(cnt>0? "����":"����");
		
		pstmt.close();
		con.close();
		sc.close();

	}

}










