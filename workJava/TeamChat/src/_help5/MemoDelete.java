package _help5;
import java.sql.*;
import java.io.*;
import java.util.Properties;//Hashtable�� �ڽ� Ŭ����

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args) 
	throws Exception
	{
		//DB.properties���ϰ� ��Ʈ�� ����
		FileReader fr=new FileReader("DB.properties");
		Properties prop=new Properties();
		//Ű���� ������� �����Ͽ� �����Ѵ�.
		prop.load(fr);
		//DB.properties���� ������ Properties��ü�� �����
		//System.out.println(prop.getProperty("driver"));
		//System.out.println(prop.getProperty("dburl"));
		Class.forName(prop.getProperty("driver"));
		String url=prop.getProperty("dburl");
		String user=prop.getProperty("user");
		String pwd=prop.getProperty("pwd");
		Connection con
		=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB���� ����");
		//������ �۹�ȣ�� �Է¹޴´�.=>JOptionPane�̿�
		String idxStr
		=JOptionPane.showInputDialog(
				"������ �۹�ȣ�� �Է��ϼ���");
		
		//Statement������
		Statement stmt=con.createStatement();
		
		//SQL�� �ۼ�=> DELETE�� �ۼ�
		String sql="DELETE FROM memo WHERE idx="+idxStr;
		System.out.println(sql);
		
		//execute()�� ����
		/*DML����(insert,delete,update��)�� ���
		 * public int executeUpdate(String sql)
		 * �޼ҵ带 Ȱ���Ѵ�.
		 * sql���� ���� ������� ���ڵ���� ��ȯ�Ѵ�.
		 * */
		int delCount=stmt.executeUpdate(sql);
		System.out.println("������ ���ڵ��: "+delCount);
		if(delCount>0){
		System.out.println("���� ó����");
		}else{
		System.out.println("���� ����: �۹�ȣ�� �������� �ʾƿ�");
		}
		//db���� ����
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
		
	}

}










