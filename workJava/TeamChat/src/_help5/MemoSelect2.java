package _help5;
import java.sql.*;

import javax.swing.JOptionPane;
public class MemoSelect2 {

	public static void main(String[] args) 
	throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con
		=DriverManager.getConnection(url, user, pwd);
		System.out.println("DB�����");
		
		Statement stmt=con.createStatement();
		
		String name=JOptionPane.showInputDialog(
			"�˻��� �ۼ��ڸ��� �Է��ϼ���");
		//Ư�� �ۼ��ڰ� �� �۸� ����ϼ���=> where�� select��
		String sql
	="SELECT idx,name,msg,wdate FROM memo WHERE name='"+name+"'";
		
		//'��'�ڰ� �ԷµǸ� ȫ�浿 ��浿..���� ��� ������
		String sql2="SELECT idx,name,msg,wdate FROM MEMO"
					+" WHERE name LIKE '%"+name+"%'";
		
		System.out.println(sql2);
		
		ResultSet rs=stmt.executeQuery(sql2);
		System.out.println("----"+name+"�� �� �˻� ���-----");
		while(rs.next()){
			//int idx=rs.getInt("idx");//�÷��� ����
			int idx=rs.getInt(1);//�÷��ε����� ����
			String name2=rs.getString(2);
			String msg=rs.getString(3);
			Date wdate=rs.getDate(4);
			System.out.println(idx+"\t"+name2+"\t"+msg+"\t"+wdate);
		}
		System.out.println("-------------------------------");
		rs.close();
		stmt.close();
		con.close();

	}

}//////////////////////////////////////////





