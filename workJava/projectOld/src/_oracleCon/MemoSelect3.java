import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.sql.*;
import java.io.*;


// select ����


class  MemoSelect3
{
	public static void main(String[] args) 
		throws Exception
	{		
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

		
/*
		// �޸� ���̺��� ������ ��������(�ۼ���,�޸���,�ۼ���)
		Scanner sc = new Scanner(System.in);

		System.out.println("�Է����� �ۼ��� �Է�=>");
		String name = sc.next(); // ���Ͷ����� nextLine() �Ѿ��.
		sc.skip("\r\n");
		
		System.out.println("�Է��� �޸𳻿� �Է�=>");
		String msg = sc.nextLine();
		System.out.println( name + "/" + msg );
		*/
		
		String name = JOptionPane.showInputDialog("�˻��� �ۼ��ڸ� �Է��ϼ���.");
		
		

		// 1. SQL�� �ۼ� => Insert�� �ۼ�
		//String sql = "INSERT INTO  MEMO ( idx ,name, msg, wdate ) VALUES ( ? , ? , ?,  ?  )";
		String sql = "SELECT count(idx) as cnt FROM MEMO WHERE name like ?";
		System.out.println(sql);
		
		
		// PreparedStatement �� ���
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// in �Ķ���� (?) ���� ����
		pstmt.setString(1, name);
		
		// ����
		ResultSet rs = pstmt.executeQuery();	// �غ�� ���� ���� , ����� ���� ���
		
		boolean b = rs.next();// Ŀ�� �̵�
		if(b){
			//int count = rs.getInt(1);
			int count=rs.getInt("cnt");
			if(count<=0){
				System.out.println("�ۼ��� ���� �����!");
				return;
			}
			System.out.println(count + "���� ���� �ֽ��ϴ�.");
			
			// �ۼ���(ȫ�浿)�� �۵��� ������ ����ϼ���.
			//4. sql�� �ۼ�(select��. join��)
			String sql1="SELECT * FROM MEMO "
					+" WHERE name=? ORDER BY idx";
			System.out.println(sql1);
			
			// PreparedStatement �� ���
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, name);
						
			//5. ����-executeXXXX()
			ResultSet rs1=pstmt1.executeQuery();
						
			//6. ���� ��� ������ ������ ����ϱ�
			while(rs1.next()){
				int no1=rs1.getInt(1);					// idx
				String name1=rs1.getString(2);		// name
				String msg1=rs1.getString(2);		// msg
				Date date1=rs.getDate(4);			// date
				System.out.println(no1+"\t"+name1+"\t"+ msg1+"\t"+date1);
			}
			
			pstmt1.close();
			rs1.close();
			
		}// if-----------------------------------------------

		pstmt.close();
		rs.close();
		con.close();
		
		
		
		//System.out.println(str);
		// ȫ�浿 => ȫ�浿�� �Է��� ���� � �ִ��� ����ϴ�
		// sql������ �ۼ�
		// "3���� ���� �ֽ��ϴ�.", "�ۼ��� ���� �����ϴ�."
		//
		
		/*
		 * 
		SQL> select * from memo order by 1;
		
		       IDX NAME                 MSG                                                                                          WDATE
		---------- -------------------- ---------------------------------------------------------------------------------------------------- --------
		         2 ����浿           ��ùóù��° ������� ���Դϴ�.                                                              16/10/20
		         8 ������               ȫ����̵�                                                                                   16/10/18
		         9 �׽�Ʈ99             ��ٴٽ� ������մϴ�.                                                                       16/10/20
		        11 ȫ�浿1              ȫȣȫ�浿 �޸�1                                                                             16/10/20

		 * 
		 * select count(idx) from memo where name="ȫ����";
		 */
		// ȫ�浵 => ȫ�浿�� �Է��� ���� � �ִ��� ����ϴ�
		// sql ������ �ۼ�
		// "3���� ���� �ֽ��ϴ�.", "�ۼ��� ���� �����ϴ�.";
		
	}
}
		