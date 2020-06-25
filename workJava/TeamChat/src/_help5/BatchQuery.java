package _help5;
import java.sql.*;
/*���� ���� sql���� �Ѳ����� �����ϴ� �ϰ� ó�� ����� ���캸��.
 * ���� ���� sql���� �ۼ��Ͽ� Statement�� addBatcvh(sql),
 * executeBatch()�޼ҵ�� �ϰ� ó���Ѵ�.
 * */

public class BatchQuery {
	
	public static void main(String[] args)
	throws Exception
	{
		Connection con=DBUtil.getCon();
		con.setAutoCommit(false);//�ڵ� Ŀ�� ���
		boolean isCommit=false;
		Statement st=con.createStatement();
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'��浿','Batch�׽�Ʈ5',sysdate)");
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'�ӱ浿','Batch�׽�Ʈ6',sysdate)");
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'�ֱ浿','Batch�׽�Ʈ7',sysdate)");
		st.addBatch("INSERT INTO memo VALUES(memo_idx_seq.nextval,"
				+"'ȫ�浿','Batch�׽�Ʈ8',sysdate)");
		try{
			int[] cnt=st.executeBatch();
			isCommit=true;
		}catch(SQLException e){
			isCommit=false;
			e.printStackTrace();
		}
		if(isCommit){
			con.commit();
			System.out.println("��ġ ���� ����");
		}else{
			con.rollback();
			System.out.println("��ġ ���� ����");
		}
		con.setAutoCommit(true);//�ڵ�Ŀ�� ���·� ����

		//select������ memo���� ������ ����ϼ���
		
		
	}

}









