package _help5;
import java.sql.*;
public class MemoSelect {

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
		
		String sql
		="SELECT idx, name, msg, wdate FROM memo ORDER BY 1";
		//DML����(INSERT,DELETE,UPDATE)=> int executeUpdate(sql)
		//DQL����(SELECT��)=> ResultSet executeQuery(sql)
		
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println("-----------------------");
		//ResultSet�� �޼ҵ�
		//boolean next() :
		/*rs�� ���� Ŀ���� ù��° ���� ������ ��ġ�Ѵ�.
		 * => before first
		 * next()�� ȣ��Ǹ� Ŀ���� �������� �̵���Ų��.
		 * �̵����� ����Ű�� ������ ���ڵ尡 ������ true�� ��ȯ,
		 * ������ false�� ��ȯ�Ѵ�.
		 * ----------------------------------
		 * �ڷ��� getXXX("�÷���") : �ش� �÷����� ���� �� ȣ��
		 * �̶� ����Ŭ �ڷ����� �ڹ� �ڷ����� ���缭 ��������.
		 * */
		
		while(rs.next()){
			int idx=rs.getInt("idx");//�۹�ȣ�� �ޱ�
			String name=rs.getString("name");//�ۼ���
			String msg=rs.getString("msg");//�޸𳻿�
			java.sql.Date wdate=rs.getDate("wdate");//�ۼ���
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		System.out.println("-----------------------");
		
		rs.close();
		stmt.close();
		con.close();

	}

}//////////////////////////////////////////





