package _help5;
import java.sql.*;
import javax.swing.*;

public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		//�޸� ���̺� �޸� ������ ����غ���.
		String name
		=JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���");
		String msg
		=JOptionPane.showInputDialog("�޸� ������ �Է��ϼ���");
		//1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/*1) OracleDriver�� �޸𸮿� �ε��Ѵ�.
		 *2) OracleDriver��ü�� DriverManager�� ����Ѵ�.
		 *- DriverManager�� ����̹����� �����ϴ� Ŭ������
		 *  ���� ����̹����� Vector�� �����Ͽ� �����Ѵ�. 
		 * */
		
		//2. db���� => Connection ��� (DriverManager���ؼ�)
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con=DriverManager.getConnection(url,user,pwd);
		
		//3. Statement���=> Connection ���ؼ�
		Statement stmt=con.createStatement();
		
		//4. SQL�� �ۼ�=> INSERT�� �ۼ�
		String sql="INSERT INTO memo(idx,name,msg,wdate)";
	sql+="VALUES(memo_idx_seq.nextval,'"+name+"','"+msg+"',sysdate)";
		System.out.println(sql);
		
		//5. stmt�� execute()�޼ҵ�� ����
		boolean b=stmt.execute(sql);
		System.out.println("b="+b);
		//select���̸�=>true, �� �� ����=>false��ȯ
		
		//6. DB �ڿ� �ݳ�=> close()
		stmt.close();
		con.close();
	}

}




