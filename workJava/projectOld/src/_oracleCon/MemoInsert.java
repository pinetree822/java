import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		// �޸� ���̺� �޸� ������ ����غ���
		String name = JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���.");
		String msg = JOptionPane.showInputDialog("�޸𳻿��� �Է��ϼ���.");

		
		// 0. ȯ�漳��
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String user = "scott";
		String pwd = "tiger";
		
		// 1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/*
		 * 1) OracleDriver�� �޸𸮿� �ε��Ѵ�.
		 * 2) OracleDriver��ü�� DriverManager�� ����Ѵ�.
		 		- DriverManager�� ����̹����� �����ϴ� Ŭ������
		 			���� ����̹����� Vector�� �����Ͽ� �����Ѵ�.
		 */
		System.out.println("����̹� �ε��Ϸ�");
		
		
		// 2. db���� => Connection ��� (DriverManager ���ؼ�)
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB ���� �Ϸ�");
		
		// 3. statement��� => Connection ���ؼ�
		Statement stmt = con.createStatement();		
		
		

		// 4. SQL�� �ۼ� => Insert�� �ۼ�
		String sql = "INSERT INTO ";
		sql += "MEMO";
		sql += "(";
		sql += "idx" + ",";
		sql += "name" + ",";
		sql += "msg" + "";
		sql += ")";
		sql += "VALUES";
		sql += "(";
		sql += "MEMO_IDX_SEQ" +".NEXTVAL" + ",";
		sql += "'" + name + "'" + ",";	//sql += subject + i + ",";
		sql += "'" + msg + "'" + "";	//sql += context + i + ",";
		sql += ")";
		System.out.println(sql);
		/*		String subject = "����";
		String context = "����";		
		String sql = "INSERT INTO MEMO(idx, name, msg, wdate)";
		sql+= "VALUES(memo_idx, seq.nextval,'��浿','���� �Ϸ�~', sysdate)";*/
		
		
		
		
		/*
			INSERT INTO MEMO(idx, name, msg)
			VALUES(memo_idx_seq.NEXTVAL, '�׽�Ʈ1', '�ȳ�~');
			--1�� �� ��(��) ���ԵǾ����ϴ�.
			
			�������� ���簪�� ���� �ʹٸ�
			SELECT memo_idx_seq.CURRVAL FROM DUAL;
			--   CURRVAL
			------------
			--         7
		*/

		
		
		
		
		
		// 5. execute() �޼ҵ�� �ۼ�
		boolean isRs = stmt.execute(sql);	
		System.out.println("isRs = " + isRs);
		System.out.println(sql + " ���� ����");	
		
		// 6. DB �ڿ� �ݳ� ==> close()
		stmt.close();
		con.close();
		// ����Ŭ ������(Sequence) ���
	}
}


/*
 * 

	����̹� �ε��Ϸ�
	DB ���� �Ϸ�
	INSERT INTO MEMO(idx,name,msg)VALUES(MEMO_IDX_SEQ.NEXTVAL,'������','ȫ����̵�')
	isRs = false
	INSERT INTO MEMO(idx,name,msg)VALUES(MEMO_IDX_SEQ.NEXTVAL,'������','ȫ����̵�')���� ����

 * 
 */
