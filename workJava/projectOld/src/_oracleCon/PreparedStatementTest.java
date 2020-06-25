import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import java.io.*;

// update ����

class  PreparedStatementTest
{
	public static void main(String[] args) 
		throws Exception
	{
		// �޸� ���̺��� ������ ��������(�ۼ���,�޸���,�ۼ���)
		Scanner sc = new Scanner(System.in);

		System.out.println("������ �۹�ȣ �Է�=>");
		int idx = sc.nextInt();
		System.out.println("������ �ۼ��� �Է�=>");
		String name = sc.next(); // ���Ͷ����� nextLine() �Ѿ��.
		sc.skip("\r\n");
		
		System.out.println("������ �޸𳻿� �Է�=>");
		String msg = sc.nextLine();
		System.out.println( idx + "/" + name + "/" + msg );

		
		
		
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
		
		// Stmt ���
		Statement stmt = con.createStatement();
		
		
		// sql�� �ۼ�		
		String sql = "UPDATE " + "MEMO ";
		sql += "SET ";
		sql += "name" + "="  + "'" +name+ "'"+ ",";
		sql += "msg" + "="  + "'" +msg+ "'"+ ",";
		sql += "wdate" + "="  + "SYSDATE ";
		sql += "WHERE ";
		sql += "idx" + "=" + idx;
		System.out.println(sql);
		
		// ����		
		
		// ���� ��� "1���� ���ڵ尡 �����Ǿ����"		
		// 5. execute()�޼ҵ�� ����
		//boolean isRs = stmt.execute(sql);	
		// ���� dml�� int = executeUpdate()�޼ҵ�
		int isCnt = stmt.executeUpdate(sql);
		System.out.println("isCnt = " + isCnt);
		
		String str = (isCnt>0)?"��������":"�����Ȱ� �����ϴ�.";
		System.out.println(str);
		
		
		
		
		// select * memo;
		// DB���� ����	
		stmt.close();
		con.close();
		sc.close();
	}
}
/*
IDX NAME                 MSG                     WDATE
---------- -------------------- ------------------------ --------
  2 ȫ�浿               ù��° ���Դϴ�.*^^*    16/10/17
  9 �׽�Ʈ1              �ȳ�~                      16/10/18
  8 ������               ȫ����̵�                 16/10/18
  
SQL> select * from memo;

IDX NAME                 MSG                    WDATE
----- -------------------- ---------------------------- --------
2 ȫ�浿               ù��° ���Դϴ�.*^^*     16/10/17
9 �׽�Ʈ99             ��ٴٽ� ������մϴ�.  16/10/20
8 ������               ȫ����̵�                  16/10/18

  
  
*/


/*
 * 
String sql = "SELECT * "
				sql += "FROM " +  "MEMO "
				UPDATE MEMBER  SET REG_DATE = (  SELECT MAX(REG_DATE) FROM MEMBER    )
				 WHERE MILEAGE =0;
*/
