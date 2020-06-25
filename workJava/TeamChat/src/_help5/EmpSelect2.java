package _help5;
import java.sql.*;
public class EmpSelect2 {

	public static void main(String[] args) 
	throws Exception
	{
		// �μ����� �ִ� �޿��� �޴� �����
		// �μ���ȣ, �����, �޿�, ����, �μ����� �������� sql��
		// �� �ۼ��ϰ� ����ϼ���
		String sql
		="SELECT  A.DEPTNO, ENAME, SAL, JOB, DNAME FROM ("
		+" SELECT * FROM EMP" 
		+" WHERE (DEPTNO, SAL ) IN"    
		+" (SELECT DEPTNO, MAX(SAL)"
		+" FROM EMP  GROUP BY DEPTNO)  )  A JOIN DEPT D"
		+" ON A.DEPTNO=D.DEPTNO ORDER BY 1";
		
		Connection con=DBUtil.getCon();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			int deptno=rs.getInt(1);
			String ename=rs.getString(2);
			int sal=rs.getInt(3);
			String job=rs.getString(4);
			String dname=rs.getString(5);
			System.out.println(deptno+"\t"+ename+"\t"+sal+"\t"+job
					+"\t"+dname);
		}
		rs.close();
		ps.close();
		con.close();
	}

}
