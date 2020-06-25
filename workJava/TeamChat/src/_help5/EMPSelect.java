package _help5;
import java.sql.*;

import javax.swing.JOptionPane;

public class EMPSelect {

	public static void main(String[] args) 
	throws Exception
	{
		String deptno=JOptionPane.showInputDialog(
			"�˻��ϰ��� �ϴ� �μ���ȣ�� �Է��ϼ���");
		//�ش� �μ��� ��� ������ ����ϴ� ���α׷��� �ۼ��ϼ���
		//���, �����, �μ���, ����, �޿�, �ٹ���
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con
		=DriverManager.getConnection(url, user, pwd);
		System.out.println("DB�����");
		Statement stmt=con.createStatement();
		
		//4. sql�� �ۼ�(select��. join��)
String sql="SELECT E.DEPTNO,EMPNO,ENAME,DNAME,JOB, SAL, LOC "
				+" FROM EMP E JOIN DEPT D"
				+" ON E.DEPTNO=D.DEPTNO"
				+" WHERE E.DEPTNO="+deptno;
		System.out.println(sql);
		
		//5. ����-executeXXXX()
		ResultSet rs=stmt.executeQuery(sql);
		//6. ���� ��� ������ ������ ����ϱ�
		while(rs.next()){
			int dno=rs.getInt(1);
			int empno=rs.getInt(2);
			String ename=rs.getString(3);
			String dname=rs.getString(4);
			String job=rs.getString(5);
			float sal=rs.getFloat(6);
			String loc=rs.getString(7);
			System.out.println(dno+"\t"+empno+"\t"+
			ename+"\t"+dname+"\t"+job+"\t"+sal+"\t"+loc);
		}
		//7. close()
		rs.close();
		stmt.close();
		con.close();
	}

}




