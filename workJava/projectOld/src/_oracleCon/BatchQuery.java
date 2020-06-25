import java.sql.*;

/*
 * ���� ���� sql���� �Ѳ����� �����ϴ� �ϰ�ó�� ����� ���캸��.
 * 
 	��������  sql���� �ۼ��Ͽ� Statment�� addBatch(sql), 
 	executeBatch()�޼ҵ�� �ϰ�ó���Ѵ�.
 	
 	
 * 
 */

public class BatchQuery {

	public static void main(String[] args) 
	throws Exception 
	{
		Connection con=DbUtil.getCon();
		con.setAutoCommit(false);	// �ڵ� Ŀ�� ���(Transaction)
		
		boolean isCommit = false;// batchsql ���� ��������
		Statement st = con.createStatement();
		
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'��浿', 'Batch�׽�Ʈ9', sysdate )" );
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'�̱浿', 'Batch�׽�Ʈ10', sysdate )" );
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'�ֱ浿', 'Batch�׽�Ʈ11', sysdate )" );
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'ȫ�浿', 'Batch�׽�Ʈ12' )" );

		
		// �Ѱ��� �����ϸ� rollback(); �ؾ� �Ѵ�.
		try {
			int[] cnt=st.executeBatch();
			isCommit = true;
			
		} catch (Exception e) {
			isCommit=false;
			e.printStackTrace();
		}// try
		
		// commit / rollback
		if(isCommit) {
			con.commit();
			System.out.println("��ġ ���� ����");
			
		} else {
			con.rollback();
			System.out.println("��ġ ���� ����");
		}
		con.setAutoCommit(true);// �ڵ�Ŀ�� ���·� ����

	}

}
