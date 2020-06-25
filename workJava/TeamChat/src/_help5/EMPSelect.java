package _help5;
import java.sql.*;

import javax.swing.JOptionPane;

public class EMPSelect {

	public static void main(String[] args) 
	throws Exception
	{
		String deptno=JOptionPane.showInputDialog(
			"검색하고자 하는 부서번호를 입력하세요");
		//해당 부서의 사원 정보를 출력하는 프로그램을 작성하세요
		//사번, 사원명, 부서명, 업무, 급여, 근무지
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String user="james", pwd="tiger";
		Connection con
		=DriverManager.getConnection(url, user, pwd);
		System.out.println("DB연결됨");
		Statement stmt=con.createStatement();
		
		//4. sql문 작성(select문. join문)
String sql="SELECT E.DEPTNO,EMPNO,ENAME,DNAME,JOB, SAL, LOC "
				+" FROM EMP E JOIN DEPT D"
				+" ON E.DEPTNO=D.DEPTNO"
				+" WHERE E.DEPTNO="+deptno;
		System.out.println(sql);
		
		//5. 실행-executeXXXX()
		ResultSet rs=stmt.executeQuery(sql);
		//6. 실행 결과 데이터 가져와 출력하기
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




