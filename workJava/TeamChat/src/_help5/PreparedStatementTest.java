package _help5;
import java.sql.*;
import java.util.*;
import java.io.*;
public class PreparedStatementTest {

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
		// STMT ���
		Statement stmt=con.createStatement();
		
		//SQL�� �ۼ�=> UPDATE��
		String sql="UPDATE memo SET name='"+name+"',";
		sql+=" msg='"+msg+"', wdate=SYSDATE WHERE idx="+idx;
		
		System.out.println(sql);
		
		//����=> dml��  int executeUpdate()
		int cnt=stmt.executeUpdate(sql);		
		
		//���� ��� "1���� ���ڵ尡 �����Ǿ����"
		//System.out.println(cnt+"���� ���ڵ尡 �����Ǿ����");
		String str=(cnt>0)?"���� ����":"���� ����-�۹�ȣ�� �����";
		System.out.println(str);
		
		//DB���� ����
		stmt.close();
		con.close();
		sc.close();

	}

}










