import java.sql.*;

/*
 * ResultSet�� Ŀ���� ��������� �̵����Ѻ���
 * 
 * PreparedStatement ps = con.prepareStatement(sql)
 * => rs�� Ŀ���� next()�� ������
 * 
 * -rs�� Ŀ���� ��������� �̵���Ű����
 * PreparedStatement ps = con.preparedStatement(sql, 
 * 									ResultSet.TYPE_SCROLL_SENSITIVE,
 * 									ResultSet.CONCUR_READ_ONLY);
 * 
 * 
 */
public class ReverseSelect {

	public static void main(String[] args) 
	throws Exception
	{
		Connection con = DbUtil.getCon();
		System.out.println("con = " + con);
		
		String sql = "SELECT empno, ename, job, sal FROM EMP ";
		sql += " order by empno asc";
		//System.out.println(sql);
		
		// PreparedStatement �� ���
		PreparedStatement ps = con.prepareStatement(sql, 
				 									ResultSet.TYPE_SCROLL_SENSITIVE, //  cursor �̵�
				 									ResultSet.CONCUR_READ_ONLY);	// cursor �б� �ɼ�
	
		// ����, rs
		ResultSet rs = ps.executeQuery();
		rs.afterLast();

		// �غ�� ���� ���� , ����� ���� ���
		// �ݺ��� ���鼭 ������ ������ ���
		// �⺻������ rs�� Ŀ���� "ù��° ���� ����"�� ��ġ�Ѵ�.
		while(rs.previous()){//rs.next()
			int empno =rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int sal =rs.getInt(4);
			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
		}
		/*
		 * 
		 * 
		Driver Loading Success..
		con = oracle.jdbc.driver.T4CConnection@2d363fb3
		7934	MILLER	CLERK	1300
		7902	FORD	ANALYST	3000
		7900	JAMES	CLERK	950
		7876	ADAMS	CLERK	1100
		7844	TURNER	SALESMAN	1500
		7839	KING	PRESIDENT	5000
		7788	SCOTT	ANALYST	3000
		7782	CLARK	MANAGER	2450
		7698	BLAKE	MANAGER	2850
		7654	MARTIN	SALESMAN	1250
		7566	JONES	MANAGER	2975
		7521	WARD	SALESMAN	1250
		7499	ALLEN	SALESMAN	1600
		7369	SMITH	CLERK	800

		 */

		// Ư�� ������ �̵���Ű���� �Ѵٸ�
		/*
		 * �Ű������� ��� : next(),
		 * �Ű������� ���� : previous()
		 */
		rs.absolute(2);//7499/ALLEN
		System.out.println( rs.getInt(1) + "/" + rs.getString(2));
		
		rs.absolute(-1);//7934/MILLER
		System.out.println( rs.getInt(1) + "/" + rs.getString(2));

		/*
		 * beforeFirst() : ù��° ���� ������ ��ġ
		 * first() 			: ù��° �࿡ ��ġ
		 * last() 			: ������ �࿡ ��ġ
		 * getRow() 		: ���� Ŀ���� ��ġ�� ���� ���ȣ�� ��ȯ
		 * 
		 */
		
		
		
		ps.close();
		rs.close();
		con.close();		
		
		
		
		
		
		
		//ps
		//rs
		//�ݺ��� ���鼭 ������ ������ ���
	}

}
