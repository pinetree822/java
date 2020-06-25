
import java.sql.*;

public class MyFirstJDBC {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		// 1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
		
		// 2. DB����
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "scott";
		String pwd = "tiger";

		// ������ �ȵǸ� SQLException �߻�
		Connection con = DriverManager.getConnection(url, user, pwd); // static method�� Connection
		System.out.println("DB Connected.");
		
		// 3. Statement������
		Statement stmt = con.createStatement();
		
		// 4. ������ ������(SQL��) �ۼ�
		String sql = "INSERT INTO ";
		sql += "MEMO ";
		sql += "(" + "idx" +","+ "name" +","+ "msg" + ") ";
		sql += " VALUES(";
		sql += "3" + ",";
		sql += "'" +"ȫ�浿" + "'" + ",";
		sql += "'" +"ù��° ���Դϴ�.*^^*" + "'" + "";
		sql += ")";
		System.out.println(sql);
		
		// 5. execute()�޼ҵ�� ����
		boolean isRs = stmt.execute(sql);
		System.out.println("isRs = " + isRs);
		// execute�ϸ� �ڵ����� commit�ȴ�.
		
		
		// 6. close()
		stmt.close();
		con.close();
	}
}

/*
 * 
	����̹� �ε� ����!
	DB Connected..
	INSERT INTO MEMO (idx,name,msg)  VALUES(1,'ȫ�浿','ù��° ���Դϴ�.*^^*')

	����̹� �ε� ����!
	DB Connected.
	INSERT INTO MEMO (idx,name,msg)  VALUES(2,'ȫ�浿','ù��° ���Դϴ�.*^^*')
	isRs = false

	����̹� �ε� ����!
	DB Connected.
	INSERT INTO MEMO (idx,name,msg)  VALUES(3,'ȫ�浿','ù��° ���Դϴ�.*^^*')
	isRs = false


SQL> select * from memo;

       IDX NAME                 MSG                                                                                          WDATE
---------- -------------------- ---------------------------------------------------------------------------------------------------- --------
         2 ȫ�浿               ù��° ���Դϴ�.*^^*                                                                         16/10/17
         3 ȫ�浿               ù��° ���Դϴ�.*^^*                                                                         16/10/17
         1 ȫ�浿               ù��° ���Դϴ�.*^^*                                                                         16/10/17
 * */



