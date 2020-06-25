package _help5;
import java.sql.*;
/* ResultSet의 커서를 자유자재로 이동시켜보자.
 * 
 * PreparedStatement ps=con.prepareStatement(sql)
 * => rs의 커서는 next()만 가능함
 * 
 * -rs의 커서를 자유자재로 이동시키려면
 * PreparedStatement ps=con.prepareStatement(sql,
 * 					ResultSet.TYPE_SCROLL_SENSITIVE,
 * 					ResultSet.CONCUR_READ_ONLY);
 * 
 * */
public class ReverseSelect {

	public static void main(String[] args) 
	throws Exception
	{
		Connection con=DBUtil.getCon();
		System.out.println("con="+con);
		String sql="SELECT empno, ename, job, sal FROM EMP ";
				sql+=" order by empno asc";
		PreparedStatement ps=con.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);		
		//rs
		ResultSet rs=ps.executeQuery();
		//반복문 돌면서 데이터 꺼내와 출력
		//기본적으로 rs의 커서는 "첫번째 행의 직전"에 위치한다.
		//우리는 rs의 커서를 "마지막행 직후"로 이동시켜보자.
		rs.afterLast();
		while(rs.previous()){
			int empno=rs.getInt(1);
			String ename=rs.getString(2);
			String job=rs.getString(3);
			int sal=rs.getInt(4);
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
		}
		
		//특정 행으로 이동시키고자 한다면
		rs.absolute(2);
		/*매개변수가 양수: next()   음수: previous()
		 * */
		System.out.println(rs.getInt(1)+"/"+rs.getString(2));
		
		rs.absolute(-1);
		
		System.out.println(rs.getInt(1)+"/"+rs.getString(2));
		/*  beforFirst() : 첫번째 행의 이전에 위치
		 *  first() : 첫번째 행에 위치
		 * 	last()  : 마지막 행에 위치
		 *  getRow() : 실제 커서가 위치한 곳의 행번호를 반환
		 * */
		
		rs.close();
		ps.close();
		con.close();

	}

}/////////////////////////////////////////////////







