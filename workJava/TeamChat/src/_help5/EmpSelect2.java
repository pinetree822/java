package _help5;
import java.sql.*;
public class EmpSelect2 {

	public static void main(String[] args) 
	throws Exception
	{
		// 부서별로 최대 급여를 받는 사원의
		// 부서번호, 사원명, 급여, 업무, 부서명을 가져오는 sql문
		// 을 작성하고 출력하세요
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
