package _help5;
import java.sql.*;
/* ResultSet�� Ŀ���� ��������� �̵����Ѻ���.
 * 
 * PreparedStatement ps=con.prepareStatement(sql)
 * => rs�� Ŀ���� next()�� ������
 * 
 * -rs�� Ŀ���� ��������� �̵���Ű����
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
		//�ݺ��� ���鼭 ������ ������ ���
		//�⺻������ rs�� Ŀ���� "ù��° ���� ����"�� ��ġ�Ѵ�.
		//�츮�� rs�� Ŀ���� "�������� ����"�� �̵����Ѻ���.
		rs.afterLast();
		while(rs.previous()){
			int empno=rs.getInt(1);
			String ename=rs.getString(2);
			String job=rs.getString(3);
			int sal=rs.getInt(4);
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
		}
		
		//Ư�� ������ �̵���Ű���� �Ѵٸ�
		rs.absolute(2);
		/*�Ű������� ���: next()   ����: previous()
		 * */
		System.out.println(rs.getInt(1)+"/"+rs.getString(2));
		
		rs.absolute(-1);
		
		System.out.println(rs.getInt(1)+"/"+rs.getString(2));
		/*  beforFirst() : ù��° ���� ������ ��ġ
		 *  first() : ù��° �࿡ ��ġ
		 * 	last()  : ������ �࿡ ��ġ
		 *  getRow() : ���� Ŀ���� ��ġ�� ���� ���ȣ�� ��ȯ
		 * */
		
		rs.close();
		ps.close();
		con.close();

	}

}/////////////////////////////////////////////////







