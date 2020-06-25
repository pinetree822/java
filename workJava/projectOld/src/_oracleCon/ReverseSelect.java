import java.sql.*;

/*
 * ResultSet의 커서를 자유자재로 이동시켜보자
 * 
 * PreparedStatement ps = con.prepareStatement(sql)
 * => rs의 커서는 next()만 가능함
 * 
 * -rs의 커서를 자유자재로 이동시키려면
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
		
		// PreparedStatement 는 얻기
		PreparedStatement ps = con.prepareStatement(sql, 
				 									ResultSet.TYPE_SCROLL_SENSITIVE, //  cursor 이동
				 									ResultSet.CONCUR_READ_ONLY);	// cursor 읽기 옵션
	
		// 실행, rs
		ResultSet rs = ps.executeQuery();
		rs.afterLast();

		// 준비된 쿼리 실행 , 결과값 참조 얻기
		// 반복문 돌면서 데이터 꺼내와 출력
		// 기본적으로 rs의 커서는 "첫번째 행의 직전"에 위치한다.
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

		// 특정 행으로 이동시키고자 한다면
		/*
		 * 매개변수가 양수 : next(),
		 * 매개변수가 음수 : previous()
		 */
		rs.absolute(2);//7499/ALLEN
		System.out.println( rs.getInt(1) + "/" + rs.getString(2));
		
		rs.absolute(-1);//7934/MILLER
		System.out.println( rs.getInt(1) + "/" + rs.getString(2));

		/*
		 * beforeFirst() : 첫번째 행의 이전에 위치
		 * first() 			: 첫번째 행에 위치
		 * last() 			: 마지막 행에 위치
		 * getRow() 		: 실제 커서가 위치한 곳의 행번호를 반환
		 * 
		 */
		
		
		
		ps.close();
		rs.close();
		con.close();		
		
		
		
		
		
		
		//ps
		//rs
		//반복문 돌면서 데이터 꺼내와 출력
	}

}
