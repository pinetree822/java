package _help5;

import java.io.FileReader;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class MemoInsert2 {

	public static void main(String[] args) 
			throws Exception
	{
		//�޸� ���̺��� ������ �������� (�ۼ���, �޸𳻿�, �ۼ���)
		Scanner sc=new Scanner(System.in);
		
		System.out.println("�ۼ��� �Է�=>");
		String name=sc.next();
		sc.skip("\r\n");//���Ͱ� �ǳʶٱ�
		System.out.println("�޸𳻿� �Է�=>");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		
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
		//1. INSERT���� �ۼ�
		String sql="INSERT INTO memo(idx,name,msg,wdate)";
		sql+=" VALUES(memo_idx_seq.nextval,?,?,sysdate)";
		
		//2. PreparedStatement���
		PreparedStatement pstmt
				=con.prepareStatement(sql);
		
		//3. in �Ķ���� (?) ���� ����
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		
		//4. ����
		int cnt=pstmt.executeUpdate();
		
		//5. ��� �޽��� ���
		System.out.println(cnt>0? "��� ����":"��� ����");
		//6. db�ڿ� �ݳ�
		pstmt.close();
		con.close();
		sc.close();
	}

}





