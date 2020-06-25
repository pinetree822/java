import java.sql.*;


public class EmpSelect2 {

	public static void main(String[] args) 
	throws Exception
	{
		// 부서별로 최대 급여를 받는 사원의
		// 부서번호, 사원명, 급여, 업무, 부서명을 가져오는  sql문
		// 을 작성하고 출력하세요.		
		/*
		 * 
			select * from (
  					select * from emp
  					where (deptno, sal) in ( select deptno, max(sal) from emp group by deptno )
  			) A JOIN DEPT D ON a.deptno=d.deptno order by 1; 
		 * 
		 */
		String sql = 	"select a.deptno, a.ename, a.sal, a.job, d.loc from ( " ;
				sql+= 					"select * from emp ";
				sql+= 					"where (deptno, sal) in ( select deptno, max(sal) from emp group by deptno ) ";
				sql+= 				") A JOIN DEPT D ";
				sql+= "ON A.deptno=D.deptno order by 1";

		Connection con = DbUtil.getCon();
		//Statement stmt = con.createStatement();
		//ResultSet rs = stmt.executeQuery(sql);
		PreparedStatement ps =con.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery(sql);
		
		while(rs.next()){
			String mgr = rs.getString(1);
			String ename = rs.getString(2);
			int sal = Integer.parseInt(rs.getString(3));
			String job = rs.getString(3);
			String loc = rs.getString(4);
			System.out.println("mgr = " + mgr + ", ename = " + ename + ", sal = " + sal + ", job = " + job + ", Loc = " + loc);
		}

		rs.close();
		ps.close();
		//stmt.close();
		con.close();
		
	}

}

/*
 * Driver Loading Success..
 * 
	mgr = 10, ename = KING, sal = 5000, job = 5000, Loc = PRESIDENT
	mgr = 20, ename = SCOTT, sal = 3000, job = 3000, Loc = ANALYST
	mgr = 20, ename = FORD, sal = 3000, job = 3000, Loc = ANALYST
	mgr = 30, ename = BLAKE, sal = 2850, job = 2850, Loc = MANAGER



SQL> select * from emp order by 1 desc;

     EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- --------- ---------- -------- ---------- ---------- ----------
      7934 MILLER     CLERK           7782 82/01/23       1300                    10
      7902 FORD       ANALYST         7566 81/12/03       3000                    20
      7900 JAMES      CLERK           7698 81/12/03        950                    30
      7876 ADAMS      CLERK           7788 83/01/12       1100                    20
      7844 TURNER     SALESMAN        7698 81/09/08       1500          0         30
      7839 KING       PRESIDENT            81/11/17       5000                    10
      7788 SCOTT      ANALYST         7566 82/12/09       3000                    20
      7782 CLARK      MANAGER         7839 81/06/09       2450                    10
      7698 BLAKE      MANAGER         7839 81/05/01       2850                    30
      7654 MARTIN     SALESMAN        7698 81/09/28       1250       1400         30
      7566 JONES      MANAGER         7839 81/04/02       2975                    20

     EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- --------- ---------- -------- ---------- ---------- ----------
      7521 WARD       SALESMAN        7698 81/02/22       1250        500         30
      7499 ALLEN      SALESMAN        7698 81/02/20       1600        300         30
      7369 SMITH      CLERK           7902 80/12/17        800                    20

14 행이 선택되었습니다.
*/