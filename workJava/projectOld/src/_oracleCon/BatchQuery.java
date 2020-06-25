import java.sql.*;

/*
 * 여러 개의 sql문을 한꺼번에 전송하는 일괄처리 방식을 살펴보자.
 * 
 	여러개의  sql문을 작성하여 Statment의 addBatch(sql), 
 	executeBatch()메소드로 일괄처리한다.
 	
 	
 * 
 */

public class BatchQuery {

	public static void main(String[] args) 
	throws Exception 
	{
		Connection con=DbUtil.getCon();
		con.setAutoCommit(false);	// 자동 커밋 취소(Transaction)
		
		boolean isCommit = false;// batchsql 실행 성공여부
		Statement st = con.createStatement();
		
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'김길동', 'Batch테스트9', sysdate )" );
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'이길동', 'Batch테스트10', sysdate )" );
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'최길동', 'Batch테스트11', sysdate )" );
		st.executeQuery("INSERT INTO MEMO VALUES ( memo_idx_seq.nextval, "
				+ "'홍길동', 'Batch테스트12' )" );

		
		// 한개라도 실패하면 rollback(); 해야 한다.
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
			System.out.println("배치 실행 성공");
			
		} else {
			con.rollback();
			System.out.println("배치 실행 실패");
		}
		con.setAutoCommit(true);// 자동커밋 상태로 복원

	}

}
