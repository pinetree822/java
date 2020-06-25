import java.sql.*;
import java.io.*;
import java.util.Properties;	// Hashtable�� �ڽ� Ŭ����

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args)
	throws Exception
	{
		// DB.properties���ϰ� ��Ʈ�� ����
		FileReader fr = new FileReader("DB.properties");
		Properties prop = new Properties(); // Ű���� ������� �����Ͽ� �����Ѵ�.
		prop.load(fr);
		// DB.properties���� ������ Properties��ü�� �����

		
		
		/*

			// ����� Ÿ����?
			// ��������Ѵ�.
			// Ư������ó��?
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
		System.out.println("DB ���� ����");
		
		// ������ �۹�ȣ�� �Է¹޴´�. => JOptionPane �̿�
		String num = JOptionPane.showInputDialog("�۹�ȣ�� �Է��ϼ���.");
		
		// Statement������
		Statement stmt = con.createStatement();
		
		// SQL�� �ۼ� => DELETE�� �ۼ�
		//String sql = "DELETE FROM MEMO WHERE idx=1;"; //num
		String sql = "DELETE FROM MEMO WHERE idx=" + num; //


		/*
		 * 
		boolean isRs = stmt.execute(sql);
		System.out.println("���� ����� " + isRs);
		DB ���� ����
		���� ����� false
		���� ������ DELETE FROM MEMO WHERE idx=1
		 */		
		
		/*
		// execute()�� ����
		 * 
		 * DML����(insert, delete, update��)�� ���
		 * 
		 * public int executeUpdate(String sql)
		 * �޼ҵ带 Ȱ���Ѵ�.
		 * sql���� ���� ������� ���ڵ� ���� ��ȯ�Ѵ�.
		 * 
		 */
		

		int delCnt = stmt.executeUpdate(sql);

		if( delCnt > 0 )
		{
			//System.out.println("������ ������ " + delCnt + " �� �Դϴ�.");
			JOptionPane.showMessageDialog(null, "������ ������ " + delCnt + " �� �Դϴ�.");
		} else {
			//System.out.println("������ ������ �����ϴ�. " );
			JOptionPane.showMessageDialog(null, "�ش� ���� �����ϴ�.");
		}
		System.out.println("���� ������ " + sql);	
		
		/*
		DB ���� ����
		������ ������ 1
		���� ������ DELETE FROM MEMO WHERE idx=10

		DB ���� ����
		������ ������ 0
		���� ������ DELETE FROM MEMO WHERE idx=100
		*/
		// db���� ����
		
		//stmt.executeQuery("select * from memo");
		
		if(stmt != null) stmt.close();
		if(con != null) con.close();		
		
	}
	
}


